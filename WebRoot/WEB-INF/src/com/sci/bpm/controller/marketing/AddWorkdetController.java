package com.sci.bpm.controller.marketing;

import org.springframework.stereotype.Controller;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.sci.bpm.command.marketing.SciWorkordDetCommand;
import com.sci.bpm.controller.base.SciBaseController;

@Controller("desiSpecCont")
public class AddWorkdetController extends SciBaseController {

	@Override
	public Event setupForm(RequestContext context) throws Exception {
		setFormObjectClass(SciWorkordDetCommand.class);
		setFormObjectName("workdetbasic");
		return super.setupForm(context);
		
		
	}
	
	
}
