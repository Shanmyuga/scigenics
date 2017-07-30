package com.sci.bpm.controller.marketing;

import org.springframework.stereotype.Controller;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.sci.bpm.command.marketing.SciWorkordDetCommand;
import com.sci.bpm.command.marketing.SciWorkordInstCommand;
import com.sci.bpm.controller.base.SciBaseController;

@Controller("piperackcont")
public class WorkDesignInstController extends SciBaseController {

	@Override
	public Event setupForm(RequestContext context) throws Exception {
		setFormObjectClass(SciWorkordInstCommand.class);
		setFormObjectName("workdesginst");
		return super.setupForm(context);
	}

}
