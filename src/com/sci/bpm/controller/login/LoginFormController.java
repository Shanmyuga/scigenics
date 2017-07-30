package com.sci.bpm.controller.login;

import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.webflow.context.servlet.ServletExternalContext;
import org.springframework.webflow.core.collection.SharedAttributeMap;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.sci.bpm.command.login.LoginCommandBean;
import com.sci.bpm.command.user.UserPreference;
import com.sci.bpm.controller.base.SciBaseController;
import com.sci.bpm.db.model.ScigenicsRoleMaster;
import com.sci.bpm.db.model.ScigenicsUserMaster;
import com.sci.bpm.service.login.LoginService;
import com.sci.bpm.validator.login.LoginValidator;

@Controller("loginController")
public class LoginFormController extends SciBaseController {

	private LoginService loginService;
	
	
	

	public LoginService getLoginService() {
		return loginService;
	}


	@Autowired
	public void setLoginService(LoginService loginService) {
		
		this.loginService = loginService;
	}


	public LoginFormController() {
		
		super();
		
		
	}
	



	public Event processLogin(RequestContext context)  {
		Event myevent = null;
		try {
			LoginCommandBean commandBean = (LoginCommandBean) getFormObject(context);
			String userid = commandBean.getUserid();
			String password = commandBean.getPassword();
			String rolename ="";
			int seqRoleID = Integer.parseInt(commandBean.getSeqRoleID());
			System.out.println("shanmuga seqRoleID" +seqRoleID);
			ScigenicsUserMaster userMaster = (ScigenicsUserMaster)loginService.validateRole(userid, password, seqRoleID);
			System.out.println("roles size" +userMaster.getScigenicsRoleMasters().size());
			
			List<ScigenicsRoleMaster> roles = (List)context.getFlowScope().get("roleitems");
			System.out.println("shanmuga 1");
			for(ScigenicsRoleMaster myrole:roles) {
				if(myrole.getSeqRoleId() == seqRoleID) {
					rolename = myrole.getRoleName().toLowerCase();
					break;
				}
			}
			System.out.println("shanmuga 2");
			if(userMaster != null ){
			ServletExternalContext sercontext =(ServletExternalContext)context.getExternalContext();
			
			SharedAttributeMap session  = sercontext.getSessionMap();
			 UserPreference userPreferences = (UserPreference) session.get("userPreferences");
			session.put("ROLE", rolename);
		
			  if(userPreferences == null) {
				  System.out.println("Inside Login null");
		            ApplicationContext act = WebApplicationContextUtils.getRequiredWebApplicationContext((ServletContext)sercontext.getNativeContext());
		           
		             userPreferences = (UserPreference)   act.getBean("userPreferences");
		             userPreferences.setUserID(userid);
		             userPreferences.setRoleName(rolename);
		             userPreferences.setUserFirstName(userMaster.getUserFirstname() +"," + userMaster.getUserLastname());
		             userPreferences.setRolemasterset(userMaster.getScigenicsRoleMasters());
		        }
			  session.put("userPreferences",userPreferences);
				myevent = success();
			}	
			else 
				myevent = error();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return myevent;
		
		
	}
public Event loadUserRoles(RequestContext context) throws Exception {
		
		LoginCommandBean commandBean = (LoginCommandBean) getFormObject(context);
		Set<ScigenicsRoleMaster> roleslist= getUserPreferences().getRolemasterset();
		
		context.getFlowScope().put("myrolelist", roleslist);
		return success();
	}

public Event changeuserrole(RequestContext context) throws Exception {
	String rolename ="";
	LoginCommandBean commandBean = (LoginCommandBean) getFormObject(context);
	int seqRoleID = Integer.parseInt(commandBean.getSeqRoleID());
	System.out.println("shanmuga seqRoleID" +seqRoleID);
	Set<ScigenicsRoleMaster> roles = (Set)context.getFlowScope().get("myrolelist");
	for(ScigenicsRoleMaster myrole:roles) {
		if(myrole.getSeqRoleId() == seqRoleID) {
			rolename = myrole.getRoleName().toLowerCase();
			break;
		}
	}
	ServletExternalContext sercontext =(ServletExternalContext)context.getExternalContext();
	
	SharedAttributeMap session  = sercontext.getSessionMap();
	
	session.put("ROLE", rolename);
	return success();
}
	
	public Event changePassword(RequestContext context) throws Exception {
		
		LoginCommandBean commandBean = (LoginCommandBean) getFormObject(context);
		String userid = getUserPreferences().getUserID();
		
		loginService.changePass(userid, commandBean.getPassword());
		
		return success();
	}
	

	@Override
	public Event setupForm(RequestContext context) throws Exception {
		// TODO Auto-generated method stub
		//resetForm(context);
		LoginCommandBean mybean = new LoginCommandBean();
		setFormObjectClass(LoginCommandBean.class);
		setFormObjectName("loginbean");
		setValidator(new LoginValidator());
		
		
		return super.setupForm( context);
	}


	
}
