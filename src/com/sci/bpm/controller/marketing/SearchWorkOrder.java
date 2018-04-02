package com.sci.bpm.controller.marketing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sci.bpm.chart.model.ChartModel;
import com.sci.bpm.command.LookupValueBean;
import com.sci.bpm.db.model.SciReportConfiguration;
import com.sci.bpm.service.lookup.LookUpValueService;
import org.apache.commons.lang.StringUtils;
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
		StringBuilder builder = new StringBuilder();
		for(SciWorkorderMaster wm:mylist) {
			builder.append(wm.getJobDesc()+"|");
		}
		context.getFlowScope().put("workorderlistNames", builder.toString());
		return success();
	}


	public List<SciWorkorderMaster> searchWorkOrderList(RequestContext context) {

		List<SciWorkorderMaster> mylist = service.searchWorkOrder();

		return mylist;
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

	public Event selectWorderChart(RequestContext context) {

		try {
			WorkOrderCommand wrkcommand = (WorkOrderCommand)context.getFlowScope().get("workorderbean");
			List wlist = (List)context.getFlowScope().get("workorderlist");

			SciWorkorderMaster wmaster = (SciWorkorderMaster) wlist.get(Integer.parseInt(wrkcommand.getWindex())-1);
			wrkcommand.setClientDetails(wmaster.getClientDetails());
			wrkcommand.setJobDesc(wmaster.getJobDesc());
			context.getFlowScope().put("workorderbean", wrkcommand);
			context.getFlowScope().put("selectedwo", wmaster);
			List<ChartModel> charts = service.getWorkOrderCostStats(wmaster.getSeqWorkId());
			ObjectMapper mapper = new ObjectMapper();

			String chartJSON = mapper.writeValueAsString(charts);
			chartJSON = chartJSON.replaceAll("\"type\"","type");
			chartJSON = chartJSON.replaceAll("\"name\"","name");
			chartJSON = chartJSON.replaceAll("\"legendText\"","legendText");
			chartJSON = chartJSON.replaceAll("\"showInLegend\"","showInLegend");
			chartJSON = chartJSON.replaceAll("\"dataPoints\"","dataPoints");
			chartJSON = chartJSON.replaceAll("\"label\"","label");
			chartJSON = chartJSON.replaceAll("\"y\"","y");


			System.out.println(chartJSON);
			context.getFlowScope().put("chartData",chartJSON);
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
	public Event filterReport(RequestContext context) throws Exception {
		WorkOrderCommand value = (WorkOrderCommand)getFormObject(context);
		List<SciWorkorderMaster> workorderMasters = searchWorkOrderList(context);
		List<SciWorkorderMaster> workorderMastersList = null;
		if(!StringUtils.isEmpty(value.getReportFilter())) {
			workorderMastersList = selectWorkOrderByJobDesc(workorderMasters, value.getReportFilter());
		}
		else {
			workorderMastersList = searchWorkOrderList(context);
		}
		context.getFlowScope().put("workorderlist", workorderMastersList);

		return success();
	}


	private List<SciWorkorderMaster> selectWorkOrderByJobDesc(List<SciWorkorderMaster> master,String filter) {
		System.out.println("filter " + filter);
		List<SciWorkorderMaster> configurationList = new ArrayList<SciWorkorderMaster>();
		for(SciWorkorderMaster m : master) {
			if(m.getJobDesc().matches(".*"+filter+".*")) {
				configurationList.add(m);
			}
		}

		return configurationList;
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
