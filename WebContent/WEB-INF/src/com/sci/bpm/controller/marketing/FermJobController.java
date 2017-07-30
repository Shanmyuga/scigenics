package com.sci.bpm.controller.marketing;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.sci.bpm.command.marketing.FermJobDetailsBean;
import com.sci.bpm.command.marketing.WorkOrderCommand;
import com.sci.bpm.controller.base.SciBaseController;
import com.sci.bpm.db.model.SciFermJobDetails;
import com.sci.bpm.db.model.SciWorkDeliInst;
import com.sci.bpm.db.model.SciWorkDeliInstId;
import com.sci.bpm.db.model.SciWorkorderMaster;
import com.sci.bpm.service.marketing.WorkOrderService;

@Controller("fermjobcont")
public class FermJobController extends SciBaseController {

	@Override
	public Event setupForm(RequestContext context) throws Exception {
		setFormObjectClass(FermJobDetailsBean.class);
		setFormObjectName("fermjobbean");
		return super.setupForm(context);
	}
	
	@Autowired
	private WorkOrderService workorderserv;

	public Event addFermJobDetail(RequestContext context) {
		
		try {
			FermJobDetailsBean bean = (FermJobDetailsBean)getFormObject(context);
			SciFermJobDetails jobdetails = new SciFermJobDetails();
			BeanUtils.copyProperties(jobdetails, bean);
			
			WorkOrderCommand command = (WorkOrderCommand)context.getFlowScope().get("workorderbean");
			System.out.println(command.getJobDesc());
			SciWorkorderMaster master = new SciWorkorderMaster();
			BeanUtils.copyProperties(master,command);
			//String[] deliinst = command.getDeliinstr();
			/*for (String delidx : deliinst) {
				SciWorkDeliInstId instid = new SciWorkDeliInstId();
				instid.setDelLovId(new Long(delidx));
				SciWorkDeliInst inst = new SciWorkDeliInst();
				inst.setId(instid);
				master.addDeliinst(inst);
			}*/
			master.addFermJob(jobdetails);
			jobdetails.setSciWorkorderMaster(master);
			master.setUpdatedBy(getUserPreferences().getUserID());
			master.setUpdatedDt(new java.util.Date());
			master.setWorkCreateDt(new java.util.Date());
			workorderserv.createWorkOrder(master);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return success();
		
	}

	@Override
	protected void initBinder(RequestContext context, DataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
		

		super.initBinder(context, binder);
	}




	
	
	
	
}
