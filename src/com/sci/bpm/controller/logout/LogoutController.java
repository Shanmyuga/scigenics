package com.sci.bpm.controller.logout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.webflow.context.servlet.ServletExternalContext;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.sci.bpm.controller.base.SciBaseController;

@Controller("logoutcont")
public class LogoutController extends SciBaseController {

	
	public Event logoutApp(RequestContext context) {
		
		ServletExternalContext sercontext = (ServletExternalContext)context.getExternalContext();
		//HttpSession session = sercontext.getRequest().getSession(false);
		HttpServletRequest request = (HttpServletRequest)sercontext.getNativeRequest();
		HttpSession session = request.getSession(false);
		System.out.println(getUserPreferences().getUserID());
		if(session != null) {
			session.invalidate();
		}
		return success();
	}
}
