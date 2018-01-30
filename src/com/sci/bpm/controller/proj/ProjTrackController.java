package com.sci.bpm.controller.proj;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.sci.bpm.command.proj.ProjectReportView;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.sci.bpm.command.proj.ProjectTrackCommand;
import com.sci.bpm.controller.base.SciBaseController;
import com.sci.bpm.db.model.SciMatindMaster;
import com.sci.bpm.db.model.SciProjectCostMaster;
import com.sci.bpm.db.model.SciProjectPhases;
import com.sci.bpm.db.model.SciWoTrackMaster;
import com.sci.bpm.db.model.SciWoTrkDetail;
import com.sci.bpm.db.model.SciWorkorderMaster;
import com.sci.bpm.service.proj.ProjTrackService;

@Controller("projtrack")
public class ProjTrackController extends SciBaseController {

	@Override
	public Event setupForm(RequestContext context) throws Exception {
		// TODO Auto-generated method stub
		setFormObjectClass(ProjectTrackCommand.class);
		setFormObjectName("projschebean");
		return super.setupForm(context);
	}

	@Autowired
	private ProjTrackService service;

	public Event addProjectPhase(RequestContext context) throws Exception {

		ProjectTrackCommand command = (ProjectTrackCommand) getFormObject(context);
		
		SciWorkorderMaster wmaster = (SciWorkorderMaster) context
				.getFlowScope().get("selectedwo");
		List wophases = (List) context.getFlowScope().get("wophases");
		SciWoTrackMaster master = selectWoTrack(wophases, command.getPhaseidx());
		
		

		SciWoTrkDetail detail = new SciWoTrkDetail();

		master.setUpdatedBy(getUserPreferences().getUserID());
		master.setUpdatedDate(new Date());
		BeanUtils.copyProperties(detail, command);
detail.setSubPhaseName(master.getPhaseDesc());
		long totalhours = 0;
		
if(detail.getTaskDesc() == null || "".equals(detail.getTaskDesc())) {
	throw new Exception();
}
		Set<SciWoTrkDetail> detaisset= master.getSciWoTrkDetails();
		for(SciWoTrkDetail dt:detaisset) {
			totalhours = totalhours + dt.getActManhours();
		}
		if(totalhours == 0) {
			master.setActualStdate(new Date());
		}
		totalhours = totalhours + command.getActManHours();
		master.setActManhours(totalhours);
		master.addWoProjDetail(detail);
		detail.setSciWoTrackMaster(master);
		detail.setInsertedBy(getUserPreferences().getUserID());
		detail.setInsertedDate(new Date());
		detail.setUpdatedBy(getUserPreferences().getUserID());
		detail.setUpdatedDate(new Date());
		detail.setActManhours(command.getActManHours());
	if("Y".equals(command.getIsPhaseCompleted())) {
		detail.setSubActEnd(new Date());
		master.setActualEnddate(new Date());
	}
	

			service.addTaskPhase(master);
			
	
		loadProjectPhases(context);
		loadsubtasks(context);
		resetForm(context);
		return success();
	}
	
	public Event addProjectEstimationPhase(RequestContext context) throws Exception {

		ProjectTrackCommand command = (ProjectTrackCommand) getFormObject(context);
		boolean fail = false;
		String error = "";
		if (command.getSubEstStart() == null || command.getSubEstEnd() == null) {
			fail = true;
			error = "Estimated Dates cannot be Empty";
		}
		if (command.getSubEstStart() != null && command.getSubEstEnd() != null) {
			if (command.getSubEstStart().after(command.getSubEstEnd())) {
				fail = true;
				error = " Estimated Start dates cannot be after Estimated End date";
			}
		}

		if (fail) {
			context.getFlashScope().put("ERROR_MSG", error);
			return success();
		}
		List totphaseList = (List) context.getFlowScope().get("totphaseslist");
		SciWorkorderMaster wmaster = (SciWorkorderMaster) context
				.getFlowScope().get("selectedwo");
		SciWoTrackMaster master = null;
		if (master == null) {
			master = new SciWoTrackMaster();
			BeanUtils.copyProperties(master, command);
			Long phaseorder = selectPhaseOrder(totphaseList, command
					.getPhaseDetail());
			String phasename = selectPhaseOrdername(totphaseList, command.getSubPhaseName());
			
			
			master.setPhaseOrder(phaseorder);
			master.setInsertedBy(getUserPreferences().getUserID());
			master.setInsertedDate(new Date());
			master.setEstStdate(command.getSubEstStart());
			master.setEstEnddate(command.getSubEstEnd());
		}

	

		master.setUpdatedBy(getUserPreferences().getUserID());
		master.setUpdatedDate(new Date());

		
		
		
		master.setSciWorkorderMaster(wmaster);
		//master.addWoProjDetail(detail);
		

		if (!service.checkPhaseExist(command.getPhaseDetail(), command
				.getSubPhaseName(), wmaster.getSeqWorkId())) {

			service.addTaskPhase(master);
			
		}
		loadProjectPhases(context);
		//loadsubtasks(context);
		resetForm(context);
		return success();
	}

	public Event loadProjectPhases(RequestContext context) {
		SciWorkorderMaster wmaster = (SciWorkorderMaster) context
				.getFlowScope().get("selectedwo");
		List phaselist = service.loadWoPhases(wmaster);
		context.getFlowScope().put("wophases", phaselist);
		return success();
	}
	
	public Event loadProjectCost(RequestContext context) {
		SciWorkorderMaster wmaster = (SciWorkorderMaster) context
				.getFlowScope().get("selectedwo");
		List phaselist = service.loadProjectCost(wmaster);
		context.getFlowScope().put("costList", phaselist);
		return success();
	}

	public Event loadSubPhase(RequestContext context) throws Exception {
		ProjectTrackCommand command = (ProjectTrackCommand) getFormObject(context);
		List subphaselist = this.service.loadSubPhase(command.getPhaseDetail());
		context.getFlowScope().put("subphaselist", subphaselist);
		return success();
	}

	public Event updateActualDates(RequestContext context) throws Exception {
		ProjectTrackCommand command = (ProjectTrackCommand) getFormObject(context);
		boolean fail = false;
		String error = "";
		if (command.getSubActStdate() == null || command.getSubActEnd() == null) {
			fail = true;
			error = "Actual Dates cannot be Empty";
		}
		if (command.getSubActStdate() != null && command.getSubActEnd() != null) {
			if (command.getSubActStdate().after(command.getSubActEnd())) {
				fail = true;
				error = "Actual Start dates cannot be after Actual End date";
			}
		}
		if (fail) {
			context.getFlashScope().put("ERROR_MSG", error);
			return success();
		}
		SciWorkorderMaster wmaster = (SciWorkorderMaster) context
				.getFlowScope().get("selectedwo");
		this.service.updateActualDates(command.getPhaseDetail(), command
				.getSubPhaseName(), wmaster.getSeqWorkId(), command
				.getSubActStdate(), command.getSubActEnd());
		loadProjectPhases(context);
		resetForm(context);
		return success();
	}

	public Event loadsubtasks(RequestContext context) throws Exception {
		ProjectTrackCommand command = (ProjectTrackCommand) getFormObject(context);

		// List subphaselist =
		// this.service.loadSubPhase(command.getPhaseDetail());
		List<SciWoTrackMaster> wophases = (List) context.getFlowScope().get(
				"wophases");
		SciWoTrackMaster master = selectWoTrack(wophases, command.getPhaseidx());
		if(master.getActualEnddate() == null){
		context.getFlowScope()
				.put("subphaseTasks", master.getSciWoTrkDetails());
		}
		else {
			context.getFlowScope()
			.put("completeTask","Y");
		}
		return success();
	}


	public Event reportProjectStatus(RequestContext context) throws Exception {

		ProjectTrackCommand command = (ProjectTrackCommand) getFormObject(context);
List<ProjectReportView> reports = service.reportTasks(command);
context.getFlowScope().put("reportTasks",reports);
		return  success();
	}
	
	public Event addProjectCosts(RequestContext context) throws Exception {
		ProjectTrackCommand command = (ProjectTrackCommand) getFormObject(context);
		SciWorkorderMaster wmaster = (SciWorkorderMaster) context
				.getFlowScope().get("selectedwo");
		
		SciProjectCostMaster costmaster = new SciProjectCostMaster();
		costmaster.setSeqWorkId(wmaster.getSeqWorkId());
		BeanUtils.copyProperties(costmaster, command);
		costmaster.setInsertedBy(getUserPreferences().getUserID());
		costmaster.setInsertDate(new Date());
		costmaster.setUpdatedBy(getUserPreferences().getUserID());
		costmaster.setUpdatedDate(new Date());
		service.addProjectCost(costmaster);
		loadProjectCost(context);
		resetForm(context);
		return success();
	}
	private SciWoTrackMaster selectWoTrack(List<SciWoTrackMaster> wophases,
			Long seqWoTrkId) {

		SciWoTrackMaster selected = null;
		for (SciWoTrackMaster m : wophases) {
			if (m.getSeqWoTrkId().intValue() == seqWoTrkId.intValue()) {
				selected = m;
			}
		}

		return selected;

	}

	public Long selectPhaseOrder(List<SciProjectPhases> totPhase,
			String phasename) {

		Long phaseorder = null;
		for (SciProjectPhases wt : totPhase) {
			if (wt.getPhaseName().equals(phasename)) {
				phaseorder = wt.getPhaseOrder();
				break;
			}
		}

		return phaseorder;
	}
	public String selectPhaseOrdername(List<SciProjectPhases> totPhase,
			String phasename) {

		
		String phname = null;
		for (SciProjectPhases wt : totPhase) {
			if (wt.getPhaseName().equals(phasename)) {
				phname = phasename;
				
				break;
			}
		}

		return phname;
	}
	public Long selectSubPhaseOrder(List<SciProjectPhases> totPhase,
			String phasename, String subPhaseName) {

		Short phaseorder = null;
		for (SciProjectPhases wt : totPhase) {
			if (wt.getSubPhaseName().equals(subPhaseName)
					&& wt.getPhaseName().equals(phasename)) {
				phaseorder = wt.getSubPhaseOrder();
				break;
			}
		}

		return new Long(phaseorder.longValue());
	}

}
