package com.sci.bpm.controller.marketing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.sci.bpm.command.marketing.SciInstruDetailsCommand;
import com.sci.bpm.command.marketing.SciWorkordDetCommand;
import com.sci.bpm.command.marketing.SciWorkordInstCommand;
import com.sci.bpm.command.marketing.WorkOrderCommand;
import com.sci.bpm.controller.base.SciBaseController;
import com.sci.bpm.db.model.SciInstruDetails;
import com.sci.bpm.db.model.SciWorkordDet;
import com.sci.bpm.db.model.SciWorkordInst;
import com.sci.bpm.db.model.SciWorkorderMaster;
import com.sci.bpm.service.marketing.WorkOrderService;

@Controller("instrudetcont")
public class InstrumentationDetController extends SciBaseController {

	@Override
	public Event setupForm(RequestContext context) throws Exception {
		setFormObjectClass(SciInstruDetailsCommand.class);
		setFormObjectName("instrudetails");
		return super.setupForm(context);
	}

	@Autowired
	private WorkOrderService workservice;
	
	public Event addFinalWorkOrder(RequestContext context) throws Exception {
		
		SciInstruDetailsCommand instrudetcommand = (SciInstruDetailsCommand) getFormObject(context);
		SciWorkordInstCommand workinstcommand = (SciWorkordInstCommand) context.getFlowScope().get("workdesginst");
		SciWorkordDetCommand workordDetCommand = (SciWorkordDetCommand)context.getFlowScope().get("workdetbasic");
		WorkOrderCommand wbasic = (WorkOrderCommand)context.getFlowScope().get("workorderbean");
		
		Map mymap = new HashMap();
		SciWorkorderMaster master = new SciWorkorderMaster();
		BeanUtils.copyProperties(master, wbasic);
		master.setUpdatedBy(getUserPreferences().getUserID());
		master.setUpdatedDt(new java.util.Date());
		master.setWorkCreateDt(new java.util.Date());
	
		SciInstruDetails instrudetails = new SciInstruDetails();
		BeanUtils.copyProperties(instrudetails, instrudetcommand);
		SciWorkordDet workordDet = new SciWorkordDet();
		SciWorkordInst workinst = new SciWorkordInst();
		BeanUtils.copyProperties(workordDet, workordDetCommand);
		BeanUtils.copyProperties(workinst, workinstcommand);
		
		mymap.put("0",master);
		mymap.put("1", workordDet);
		mymap.put("2", workinst);
		mymap.put("3", instrudetails);
		
		workservice.addWorkOrderwithDetails(mymap);
		return success();
		
	}
}
