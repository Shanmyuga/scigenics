package com.sci.bpm.controller.marketing;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.sci.bpm.command.marketing.WorkOrderCommand;
import com.sci.bpm.controller.base.SciBaseController;
import com.sci.bpm.db.model.SciAmendmentMaster;
import com.sci.bpm.db.model.SciCustomerMaster;
import com.sci.bpm.db.model.SciWorkorderMaster;
import com.sci.bpm.service.marketing.WorkOrderService;
import com.sci.bpm.validator.marketing.WorkOrderValidator;

@Controller("workordercont")
public class WorkOrderController extends SciBaseController {

	@Override
	public Event setupForm(RequestContext context) throws Exception {
		setFormObjectClass(WorkOrderCommand.class);
		setFormObjectName("workorderbean");

		setValidator(new WorkOrderValidator());
		return super.setupForm(context);
	}

	@Autowired
	private WorkOrderService workorderserv;

	public Event addWorkOrder(RequestContext context) {

		try {
			WorkOrderCommand command = (WorkOrderCommand) getFormObject(context);
			SciCustomerMaster custmaster = workorderserv.loadCustomer(command
					.getSeqCustId());
			SciWorkorderMaster master = new SciWorkorderMaster();

			master.setSciCustomerMaster(custmaster);
			BeanUtils.copyProperties(master, command);
			master.setWoStatus("Y");

			master.setClientDetails(custmaster.getCustomerName());
			master.setUpdatedBy(getUserPreferences().getUserID());
			master.setUpdatedDt(new java.util.Date());
			master.setWorkCreateDt(new java.util.Date());
			master.setInsertedBy(getUserPreferences().getUserID());
			master.setInsertedDate(new java.util.Date());
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
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
		binder.registerCustomEditor(String.class,
				new StringTrimmerEditor(false));

		super.initBinder(context, binder);
	}

	public Event addAmendment(RequestContext context) {

		try {
			WorkOrderCommand command = (WorkOrderCommand) getFormObject(context);
			SciAmendmentMaster master = new SciAmendmentMaster();
			SciWorkorderMaster wmaster = (SciWorkorderMaster) context
					.getFlowScope().get("selectedwo");
			master.setAmendDetails(command.getAmendDetails());
			master.setSciWorkorderMaster(wmaster);
			master.setUpdatedBy(getUserPreferences().getUserID());
			master.setUpdatedDt(new java.util.Date());
			workorderserv.addAmendment(master);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return success();
	}

	public Event loadamendList(RequestContext context) {

		try {

			SciWorkorderMaster master = (SciWorkorderMaster) context
					.getFlowScope().get("selectedwo");

			List<SciAmendmentMaster> myamendlist = workorderserv
					.searchAmend(master);
			context.getFlowScope().put("amendlist", myamendlist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return success();
	}
}
