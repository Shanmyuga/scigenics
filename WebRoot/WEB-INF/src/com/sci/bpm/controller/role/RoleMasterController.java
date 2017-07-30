package com.sci.bpm.controller.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.sci.bpm.command.role.RoleMasterBean;
import com.sci.bpm.controller.base.SciBaseController;
import com.sci.bpm.db.model.ScigenicsRoleMaster;
import com.sci.bpm.service.role.RoleService;

@Controller("rolemasterCont")
public class RoleMasterController extends SciBaseController {

	@Autowired
	private RoleService roleService;
	
	
	public Event addRole(RequestContext context) {
		
		try {
			RoleMasterBean rolebean = (RoleMasterBean) getFormObject(context);
			String rolename = rolebean.getRoleName();
			ScigenicsRoleMaster roleMaster = new ScigenicsRoleMaster();
			roleMaster.setRoleName(rolename);
			roleService.addRole(roleMaster);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return success();
	}


	@Override
	public Event setupForm(RequestContext context) throws Exception {
		
		setFormObjectClass(RoleMasterBean.class);
		setFormObjectName("rolemasterBean");
		return super.setupForm(context);
	}
	
}
