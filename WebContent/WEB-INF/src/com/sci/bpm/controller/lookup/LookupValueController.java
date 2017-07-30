package com.sci.bpm.controller.lookup;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.sci.bpm.command.LookupValueBean;
import com.sci.bpm.controller.base.SciBaseController;
import com.sci.bpm.db.model.SciCustomerMaster;
import com.sci.bpm.db.model.SciLookupMaster;
import com.sci.bpm.db.model.SciMasterItem;
import com.sci.bpm.db.model.SciMatspecMaster;
import com.sci.bpm.db.model.SciReportConfiguration;
import com.sci.bpm.db.model.SciVendorMaster;
import com.sci.bpm.service.lookup.LookUpValueService;
import com.sci.bpm.service.task.TaskService;

@Controller("lookupcontbean")
public class LookupValueController extends SciBaseController {

	
	@Autowired
	private LookUpValueService service;
	
	@Autowired
	private TaskService taskService;
	
	public Event addNewValue(RequestContext context) throws Exception {
		LookupValueBean value = (LookupValueBean)getFormObject(context);
		SciLookupMaster master = new SciLookupMaster();
		try {
			BeanUtils.copyProperties(master, value);
			master.setUpdatedDt(new java.util.Date());
			master.setUpdatedBy(getUserPreferences().getUserID());
			service.addNewValue(master);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success();
	}
	
	public Event addNewItemValue(RequestContext context) throws Exception {
		LookupValueBean value = (LookupValueBean)getFormObject(context);
		SciMasterItem master = new SciMasterItem();
		
			master.setItemType(value.getLovType());
			master.setItemDescription(value.getLovDescription());
			master.setUpdatedDt(new java.util.Date());
			master.setUpdatedBy(getUserPreferences().getUserID());
			service.addNewItemValue(master);
	
		return success();
	}
	public Event addNewCustomer(RequestContext context) throws Exception {
		LookupValueBean value = (LookupValueBean)getFormObject(context);
		SciCustomerMaster master = new SciCustomerMaster();
		
			BeanUtils.copyProperties(master, value);
			master.setUpdatedDate(new java.util.Date());
			master.setUpdatedBy(getUserPreferences().getUserID());
			service.addNewCustomer(master);
	
		return success();
	}
	public Event addNewVendor(RequestContext context) throws Exception {
		LookupValueBean value = (LookupValueBean)getFormObject(context);
		SciVendorMaster master = new SciVendorMaster();
		
		BeanUtils.copyProperties(master, value);
		master.setUpdatedDate(new java.util.Date());
		master.setUpdatedBy(getUserPreferences().getUserID());
		service.addNewVendor(master);
	
		return success();
	}
	public Event addNewMatSpec(RequestContext context) throws Exception {
		LookupValueBean value = (LookupValueBean)getFormObject(context);
		SciMatspecMaster master = new SciMatspecMaster();
		
		BeanUtils.copyProperties(master, value);
		master.setMaterialSpec(value.getMatSpecDesc());
		master.setUpdatedDate(new java.util.Date());
		master.setMatcatCode(value.getSpecCode().substring(0,2));
		master.setUpdatedBy(getUserPreferences().getUserID());
			service.addNewMatSpec(master);
	       
		return success();
	}
	public Event addNewReport(RequestContext context) throws Exception {
		LookupValueBean value = (LookupValueBean)getFormObject(context);
		SciReportConfiguration master = new SciReportConfiguration();
		
		BeanUtils.copyProperties(master, value);
		master.setReportStatus("A");
		master.setInsertedDate(new java.util.Date());
		master.setUpdatedDate(new java.util.Date());
		master.setInsertedBy(getUserPreferences().getUserID());
		master.setUpdatedBy(getUserPreferences().getUserID());
			service.addNewReport(master);
	       resetForm(context);
	       List<SciReportConfiguration> reports = loadReports(context);
	       context.getFlowScope().put("reportsdata", reports);
	       
		return success();
	}
	
	public Event deactivateStatus(RequestContext context) throws Exception {
		LookupValueBean value = (LookupValueBean)getFormObject(context);
		List<SciReportConfiguration> reports = (List<SciReportConfiguration>) context.getFlowScope().get("reportsdata");
		
	     SciReportConfiguration config=   selectReport(reports, new Long(value.getSeqReportID()));
	     config.setReportStatus("D");
	     config.setUpdatedBy(getUserPreferences().getUserID());
	     config.setUpdatedDate(new java.util.Date());
	     service.updateStatus(config);
	     List<SciReportConfiguration> reportsdata = loadReports(context);
	       context.getFlowScope().put("reportsdata", reportsdata);
	       
		return success();
	}
	
	public Event runSelectedReport(RequestContext context) throws Exception {
		LookupValueBean value = (LookupValueBean)getFormObject(context);
		List<SciReportConfiguration> reports = (List<SciReportConfiguration>) context.getFlowScope().get("reportsdata");
		
	     SciReportConfiguration config=   selectReport(reports, new Long(value.getSeqReportID()));
	    taskService.runSelectedReport(config);
	       
		return success();
	}
	
	private SciReportConfiguration selectReport(List<SciReportConfiguration> master,Long seqReportId) {
		SciReportConfiguration selected = null;
		for(SciReportConfiguration m : master) {
			if(m.getSeqRepConfigId().intValue() == seqReportId.intValue()) {
				selected = m;
			}
		}
		
		return selected;
	}
	public List loadReports(RequestContext context) throws Exception {
		List<SciReportConfiguration> reports =service.loadReports();
	      
		return reports;
	}

	@Override
	public Event setupForm(RequestContext context) throws Exception {
	setFormObjectClass(LookupValueBean.class);
	
	setFormObjectName("lookupvalbean");
		return super.setupForm(context);
	}
}
