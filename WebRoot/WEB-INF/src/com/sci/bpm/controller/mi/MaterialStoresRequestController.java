package com.sci.bpm.controller.mi;

import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.sci.bpm.command.mi.MatindCommand;
import com.sci.bpm.controller.base.DatePropertyEditorRegistrar;
import com.sci.bpm.controller.base.SciBaseController;
import com.sci.bpm.db.model.SciMatindMaster;
import com.sci.bpm.db.model.SciReturnitemsRequest;
import com.sci.bpm.db.model.SciStoreissueMaster;
import com.sci.bpm.db.model.SciStoresRequest;
import com.sci.bpm.db.model.SciWorkorderMaster;
import com.sci.bpm.service.mi.MaterialIndentService;
import com.sci.bpm.service.product.ProductMasterService;
import com.sci.bpm.service.stores.StoreService;

@Controller("storeRequestCont")
public class MaterialStoresRequestController extends SciBaseController {

	
	@Autowired
	private MaterialIndentService service;
	
	@Autowired
	private ProductMasterService prservice;

	
	@Autowired
	private StoreService sservice;
	@Override
	public Event setupForm(RequestContext context) throws Exception {
		setFormObjectClass(MatindCommand.class);
		setFormObjectName("matindbean");
		setPropertyEditorRegistrar(new DatePropertyEditorRegistrar());
		return super.setupForm(context);
	}
	
	public Event loadStoreRequest(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);
		//SciWorkorderMaster wmaster = (SciWorkorderMaster) context.getFlowScope().get("selectedwo");
		//command.setWm(wmaster);
		
		List<SciStoresRequest> mylist = null; 
			if("prodsupervisor".equals(getUserPreferences().getRoleName())) {
				command.setRolelevel("prodsupervisor");
				mylist = service.loadStoreRequestFilters(command);
				
				context.getFlowScope().put("rolelevel","prodSuper" );
			}
			else if("purchase".equals(getUserPreferences().getRoleName())) {
				command.setRolelevel("purchase");
				mylist = service.loadStoreRequestFilters(command);
				context.getFlowScope().put("rolelevel","purchaseSuper" );
			}
			else {
				mylist = service.loadStoreRequestFilters(command);
			}
			context.getFlowScope().put("openstreq", mylist);
		
		return success();
	}
	
	private SciStoreissueMaster selectIssueRequest(List<SciStoreissueMaster> master,
			Long seqStoreissueID) {
		SciStoreissueMaster selected = null;
		for (SciStoreissueMaster m : master) {
			if (m.getSeqStissueId().intValue() == seqStoreissueID.intValue()) {
				selected = m;
			}
		}

		return selected;
	}
	
	public Event updateIssueAcceptance(RequestContext context)  throws Exception{
		
		MatindCommand command = (MatindCommand) getFormObject(context);
		List issueMasterList = (List) context.getFlowScope().get("issueAcceptance");
	
		SciStoreissueMaster issueMaster = selectIssueRequest(issueMasterList, command.getMiindexID());
		issueMaster.setAcceptedBy(command.getAcceptedBy());
		issueMaster.setIssueAcceptance(command.getIssueAcceptance());
		issueMaster.setAcceptedDate(new Date());
		if("R".equals(command.getIssueAcceptance())) {
			SciReturnitemsRequest request = new SciReturnitemsRequest();
			
			BeanUtils.copyProperties(request, command);
			request.setRetQuantity(String.valueOf(issueMaster.getIssueCnt()));
			request.setRetDimension(issueMaster.getIssueDimension());
			request.setProdRemarks("ISSUE REJECTED ITEMS");
			request.setInsertedBy(getUserPreferences().getUserID());
			request.setInsertedDate(new Date());
			request.setUpdatedBy(getUserPreferences().getUserID());
			request.setUpdatedDt(new Date());
			request.setRetDate(new Date());
			request.setSciMiMaster(issueMaster.getSciMiMaster());
			request.setStissue(issueMaster);
			request.setRequestStatus("N");
			request.setMatcode(issueMaster.getSciMiMaster().getMatcode());
			request.setMatSpec(issueMaster.getSciMiMaster().getMatSpec());
			request.setMatType(issueMaster.getSciMiMaster().getMatType());
			issueMaster.setReturnStatus("N");
			issueMaster.setUpdatedBy(getUserPreferences().getUserID());
			issueMaster.setUpdatedDt(new Date());
			sservice.addStoreReturns(request, issueMaster);
			
		}
		
		else {
			sservice.updateIssueMaster(issueMaster);
		}
		
		if("Y".equals(command.getReopenRequest())) {
			SciStoresRequest strequest = issueMaster.getStrequest();
			strequest.setRequestStatus("N");
			strequest.setProdRemarks("REOPEN REQUEST");
			strequest.setUpdatedBy(getUserPreferences().getUserID());
			strequest.setUpdatedDt(new Date());
			service.updateStoreRequest(strequest);
		}
		return success();
	}
	
	public Event loadIssueAcceptance(RequestContext context) throws Exception {

		List issueList = sservice.loadissueAcceptance();
		context.getFlowScope().put("issueAcceptance",issueList);
		return success();
	}
	
	public Event loadStoreRequestIssues(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);
		SciWorkorderMaster wmaster = (SciWorkorderMaster) context.getFlowScope().get("selectedwo");
		command.setWm(wmaster);
		
		List<SciStoreissueMaster> mylist = null; 
			
							mylist = service.loadStoreRequestIssue(command);
						context.getFlowScope().put("openstreq", mylist);
		
		return success();
	}
	
	public Event viewMi(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);
		List storelist = (List) context.getFlowScope().get("openstreq");
		SciStoresRequest request = selectRequest(storelist, command.getMiindexID());
		SciMatindMaster master = request.getSciMiMaster();
		List storeIssues = sservice.viewStorereqIssues(request);
		context.getFlashScope().put("viewmidetails", master);
		context.getFlashScope().put("storeobj", request);
		context.getFlashScope().put("storeIssues", storeIssues);
		return success();
	}
	
	public Event updatebyProd(RequestContext context) throws Exception {
		System.out.println("its inside");
		MatindCommand command = (MatindCommand) getFormObject(context);
		List storelist = (List) context.getFlowScope().get("openstreq");
		String[] stindex = command.getMiindex();
		for(int idx =0;idx < stindex.length;idx++) {
		SciStoresRequest request = selectRequest(storelist, Long.parseLong(stindex[idx]));
		request.setProdApproval(command.getStrapproval());
		request.setProdRemarks(command.getRemarks());
		request.setProdAppBy(getUserPreferences().getUserID());
		request.setUpdatedBy(getUserPreferences().getUserID());
		request.setUpdatedDt(new Date());
		service.updateStoreRequest(request);
		}
		resetForm(context);
		context.getFlowScope().remove("openstreq");
		return success();
	}
	
	private SciStoresRequest selectRequest(List<SciStoresRequest> master,Long seqStoreID) {
		SciStoresRequest selected = null;
		for(SciStoresRequest m : master) {
			if(m.getSeqStreqId().intValue() == seqStoreID.intValue()) {
				selected = m;
			}
		}
		
		return selected;
	}
	

	public Event updatebyPurch(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);
		List storelist = (List) context.getFlowScope().get("openstreq");
		String[] stindex = command.getMiindex();
		for(int idx =0;idx < stindex.length;idx++) {
		SciStoresRequest request = selectRequest(storelist,Long.parseLong(stindex[idx]));
		request.setPurchApproval(command.getStrapproval());
		request.setPurhRemarks(command.getRemarks());
		request.setPurchApprBy(getUserPreferences().getUserID());
		request.setUpdatedBy(getUserPreferences().getUserID());
		request.setUpdatedDt(new Date());
		service.updateStoreRequest(request);
		}
		context.getFlowScope().remove("openstreq");
		resetForm(context);
		return success();
	}
	
	public Event loadMatCatItems(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);
		List matcatlist = prservice.selectCategory(command.getMatDept());
		System.out.println("inside catergor");
		context.getFlowScope().put("matcatitems",matcatlist);
		return success();
	}
	
}
