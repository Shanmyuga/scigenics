package com.sci.bpm.controller.marketing;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.sci.bpm.command.marketing.WorkOrderCommand;
import com.sci.bpm.controller.base.SciBaseController;
import com.sci.bpm.db.model.SciWorkorderMaster;
import com.sci.bpm.service.marketing.WorkOrderService;
import com.sci.bpm.validator.marketing.WorkOrderValidator;

@Controller("searchworkcont")
public class SearchWorkOrder extends SciBaseController{
	
	
	@Autowired
	private WorkOrderService service;
	
	public Event searchWorkOrder(RequestContext context) {
		
		List<SciWorkorderMaster> mylist = service.searchWorkOrder();
		context.getFlowScope().put("workorderlist", mylist);
		return success();
	}

	@Override
	public Event setupForm(RequestContext context) throws Exception {
		setFormObjectClass(WorkOrderCommand.class);
		setFormObjectName("workorderbean");
		
		setValidator(new WorkOrderValidator());
		return super.setupForm(context);
	}
	
	public Event selectWorder(RequestContext context) {
			
			try {
				WorkOrderCommand wrkcommand = (WorkOrderCommand)context.getFlowScope().get("workorderbean");
				List wlist = (List)context.getFlowScope().get("workorderlist");
				
				SciWorkorderMaster wmaster = (SciWorkorderMaster) wlist.get(Integer.parseInt(wrkcommand.getWindex())-1);
				wrkcommand.setClientDetails(wmaster.getClientDetails());
				wrkcommand.setJobDesc(wmaster.getJobDesc());
				context.getFlowScope().put("workorderbean", wrkcommand);
				context.getFlowScope().put("selectedwo", wmaster);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return success();
		}

	
	public Event selectDesigndocs(RequestContext context) {
		
		try {
			WorkOrderCommand wrkcommand = (WorkOrderCommand)context.getFlowScope().get("workorderbean");
			List wlist = (List)context.getFlowScope().get("workorderlist");
			
			SciWorkorderMaster wmaster = (SciWorkorderMaster) wlist.get(Integer.parseInt(wrkcommand.getWindex())-1);
			wrkcommand.setClientDetails(wmaster.getClientDetails());
			wrkcommand.setJobDesc(wmaster.getJobDesc());
			context.getFlowScope().put("workorderbean", wrkcommand);
			context.getFlowScope().put("selectedwo", wmaster);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return success();
	}
	
	
	public Event closeWO(RequestContext context) {
		
		SciWorkorderMaster wmaster = (SciWorkorderMaster) context
		.getFlowScope().get("selectedwo");
		wmaster.setWoStatus("C");
		wmaster.setWoCloseDate(new Date());
		wmaster.setUpdatedBy(getUserPreferences().getUserID());
		wmaster.setUpdatedDt(new Date());
		service.closeWO(wmaster,getLookupservice().loadIDData("MI_CLOSED_WO_ORDER"));
		return success();
	
	}
public Event dormantWO(RequestContext context) {
		
		SciWorkorderMaster wmaster = (SciWorkorderMaster) context
		.getFlowScope().get("selectedwo");
		wmaster.setWoStatus("I");
		wmaster.setWoCloseDate(new Date());
		wmaster.setUpdatedBy(getUserPreferences().getUserID());
		wmaster.setUpdatedDt(new Date());
		service.closeWO(wmaster,null);
		return success();
	
	}
}
