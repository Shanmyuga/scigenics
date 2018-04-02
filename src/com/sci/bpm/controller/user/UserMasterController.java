package com.sci.bpm.controller.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.sci.bpm.command.user.UserMasterBean;
import com.sci.bpm.controller.base.SciBaseController;
import com.sci.bpm.db.model.ScigenicsRoleMaster;
import com.sci.bpm.db.model.ScigenicsUserMaster;
import com.sci.bpm.service.login.LoginService;
import com.sci.bpm.service.user.UserService;

@Controller("usercontroller")
public class UserMasterController extends SciBaseController {

	@Autowired
	private UserService userService;

	@Autowired
	private LoginService loginService;

	public Event addUser(RequestContext context) {

		UserMasterBean mybean;
		try {
			mybean = (UserMasterBean) getFormObject(context);

			ScigenicsUserMaster masterbean = new ScigenicsUserMaster();
			Set<ScigenicsRoleMaster> rolemasterset = new HashSet<ScigenicsRoleMaster>();

			BeanUtils.copyProperties(masterbean, mybean);
			masterbean.setUserStatus("Y");
			String roleidp[] = mybean.getRoleID();
			for (int idx = 0; idx < roleidp.length; idx++) {
				ScigenicsRoleMaster rolemaster = new ScigenicsRoleMaster();
				rolemaster.setSeqRoleId(new Long(roleidp[idx]));
				rolemasterset.add(rolemaster);

			}
			masterbean.setScigenicsRoleMasters(rolemasterset);
			userService.addUser(masterbean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success();
	}

	@Override
	public Event setupForm(RequestContext context) throws Exception {
		setFormObjectClass(UserMasterBean.class);
		setFormObjectName("userbean");
		return super.setupForm(context);
	}

	public Event loadUserData(RequestContext context)throws Exception {
		UserMasterBean mybean = (UserMasterBean) getFormObject(context);
		List userlist = this.userService.selectUserList();
		context.getFlowScope().put("userlist", userlist);

		return success();
	}

	public Event loadRoleForUser(RequestContext context) throws Exception {
		UserMasterBean mybean = (UserMasterBean) getFormObject(context);
		String userid = mybean.getSelectedUserID();
		List<ScigenicsUserMaster> userlist = (List) context.getFlowScope().get(
				"userlist");
		ScigenicsUserMaster userbean = null;
		for (ScigenicsUserMaster um : userlist) {
			if (um.getSeqUserId().toString().equals(userid)) {
				userbean = um;

				break;
			}
		}
List<String> roles = new ArrayList<String>();
		if(userbean != null) {

			for(ScigenicsRoleMaster role: userbean.getScigenicsRoleMasters()) {
				roles.add(String.valueOf(role.getSeqRoleId()));
			}
		}
		String [] roleNAmes = roles.toArray(new String[roles.size()]);
		mybean.setRoleID(roleNAmes);
		return success();
	}

	public Event updateUserdata(RequestContext context) throws Exception {
		UserMasterBean mybean = (UserMasterBean) getFormObject(context);
		String userid = mybean.getSelectedUserID();
		List<ScigenicsUserMaster> userlist = (List) context.getFlowScope().get(
				"userlist");
		ScigenicsUserMaster userbean = null;
		for (ScigenicsUserMaster um : userlist) {
			if (um.getSeqUserId().toString().equals(userid)) {
				userbean = um;

				break;
			}
		}
		if (!StringUtils.isBlank(mybean.getPassword())) {
			userbean.setPassword(mybean.getPassword());
		}
		if ("N".equals(mybean.getUserStatus())) {
			userbean.setUserStatus("N");
		}
		Set<ScigenicsRoleMaster> rolemasterset = new HashSet<ScigenicsRoleMaster>();

		String roleidp[] = mybean.getRoleID();
		for (int idx = 0; idx < roleidp.length; idx++) {
			ScigenicsRoleMaster rolemaster = userService.generateRole(Long.parseLong(roleidp[idx]));

			rolemasterset.add(rolemaster);

		}
		userbean.setScigenicsRoleMasters(rolemasterset);
		userService.updateUser(userbean);
		mybean.setUserStatus("");
		return success();
	}
	
	public Event checkUserExists(RequestContext context) throws Exception {
		UserMasterBean mybean = (UserMasterBean) getFormObject(context);
		ScigenicsUserMaster master = userService.findUser(mybean.getUserId());
		if(master != null) {
			context.getFlashScope().put("userexist", "User ID already exist.Please give a new User ID");
		}
		else {
			context.getFlashScope().put("userexist", "User ID is available.");
		}
		return success();
	}

}
