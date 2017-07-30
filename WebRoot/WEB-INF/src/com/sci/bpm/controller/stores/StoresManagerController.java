package com.sci.bpm.controller.stores;

import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.sci.bpm.command.mi.MatindCommand;
import com.sci.bpm.command.stores.StoresBean;
import com.sci.bpm.controller.base.SciBaseController;
import com.sci.bpm.db.model.SciAvailableMaterials;
import com.sci.bpm.db.model.SciDamagedMaterials;
import com.sci.bpm.db.model.SciMatindMaster;
import com.sci.bpm.db.model.SciPurchItemMaster;
import com.sci.bpm.db.model.SciQcMiMaster;
import com.sci.bpm.db.model.SciRecdMaterials;
import com.sci.bpm.db.model.SciRejectedMaterials;
import com.sci.bpm.db.model.SciReturnitemsRequest;
import com.sci.bpm.db.model.SciStoreMiMaster;
import com.sci.bpm.db.model.SciStoreissueMaster;
import com.sci.bpm.db.model.SciStoresRequest;
import com.sci.bpm.db.model.SciWorkorderMaster;
import com.sci.bpm.service.product.ProductMasterService;
import com.sci.bpm.service.stores.StoreService;

@Controller("storecont")
public class StoresManagerController extends SciBaseController {

	@Override
	public Event setupForm(RequestContext context) throws Exception {
		setFormObjectName("storesbean");
		setFormObjectClass(StoresBean.class);
		return super.setupForm(context);
	}

	@Autowired
	private StoreService service;
	@Autowired
	private ProductMasterService prservice;
	public Event loadPOItems(RequestContext context) throws Exception {

		StoresBean bean = (StoresBean) getFormObject(context);
		List<SciPurchItemMaster> mylist = service.loadPOItems(bean
				.getSeqPurchId(),getLookupservice().loadIDData("PO_CANCELLED"));
		context.getFlowScope().put("poitemslist", mylist);
		context.getFlowScope().remove("matitemlist");
		bean.reset();
		return success();
	}

	private SciPurchItemMaster selectPI(List<SciPurchItemMaster> master,
			Long seqitemid) {
		SciPurchItemMaster selected = null;
		for (SciPurchItemMaster m : master) {
			if (m.getSeaPuritemId().intValue() == seqitemid.intValue()) {
				selected = m;
			}
		}

		return selected;
	}

	private SciMatindMaster selectMI(List<SciMatindMaster> master, Long seqmiid) {
		SciMatindMaster selected = null;
		for (SciMatindMaster m : master) {
			if (m.getSeqMiId().intValue() == seqmiid.intValue()) {
				selected = m;
			}
		}

		return selected;
	}

	public Event searchByMi(RequestContext context) throws Exception {
		StoresBean bean = (StoresBean) getFormObject(context);
		List streqList = (List) context.getFlowScope().get("openstreq");
		SciStoresRequest request = selectRequest(streqList, bean
				.getSeqSelectMIID());
		List<SciAvailableMaterials> storelist = null;

		storelist = service.getMiData(request.getSciMiMaster().getSeqMiId(), request
				.getMatcode());
		System.out.println(storelist.size());
		for(SciAvailableMaterials mat:storelist) {
			System.out.println(mat.getSeqAvailId());
		}
		context.getFlowScope().put("storeavailmi", storelist);
		context.getFlowScope().put("selectedreq", request);
		return success();
	}
	
	
	public Event loadPrevIssues(RequestContext context) throws Exception {
		StoresBean bean = (StoresBean) getFormObject(context);
		List streqList = (List) context.getFlowScope().get("openstreq");
		SciStoresRequest request = selectRequest(streqList, bean
				.getSeqSelectMIID());
		
		List previssues = service.viewStorereqIssues(request);
		
		context.getFlowScope().put("storeIssues", previssues);
		return success();
	}

	public Event addStoreMIItems(RequestContext context) throws Exception {
		System.out.println("shanmuga");
		StoresBean bean = (StoresBean) getFormObject(context);
		List<SciMatindMaster> master = (List<SciMatindMaster>) context
				.getFlowScope().get("matitemlist");
		SciMatindMaster mast = selectMI(master, bean.getSeqSelectMIID());
		SciStoreMiMaster storems = service.getStoreData(mast.getSeqMiId());
	
		if (storems == null) {
			storems = new SciStoreMiMaster();
		}
	
		storems.setSciMiMaster(mast);
	
		storems.setPoId(new Long(bean.getSeqPurchId()));
		storems.setOrdDim(mast.getMatDimesion());
		storems.setOrdQty(mast.getMatQty().toString());
		storems.setRecdDate(new Date());
		storems.setRecdMatQty(bean.getReceivedCnt());
		storems.setRecdMatDime(bean.getReceivedDimen());
		storems.setRecdStatus(bean.getItemRecdFull());
		storems.setIssuedStatus("N");
		storems.setMatCode(mast.getMatcode());
		storems.setUpdatedDt(new Date());
		storems.setMatSpec(mast.getMatSpec());
		storems.setMatType(mast.getMatType());
		storems.setUpdatedBy(getUserPreferences().getUserID());
		storems.setInsertedBy(getUserPreferences().getUserID()) ;
		storems.setInsertedDate(new java.util.Date());
		SciQcMiMaster qcmi = new SciQcMiMaster();
		qcmi.setSciMiMaster(mast);
		qcmi.setMatCode(mast.getMatcode());
		qcmi.setQcRecCnt(bean.getReceivedCnt());
		qcmi.setQcRecDime(bean.getReceivedDimen());
		qcmi.setMatSpec(mast.getMatSpec());
		qcmi.setMatType(mast.getMatType());
		qcmi.setUpdatedDt(new Date());
		qcmi.setOcStatus("N");
		qcmi.setQcTestsApproval("N");
		qcmi.setUpdatedBy(getUserPreferences().getUserID());
		qcmi.setInsertedBy(getUserPreferences().getUserID()) ;
		qcmi.setInsertedDate(new java.util.Date());
		qcmi.setPoId(new Long(bean.getSeqPurchId()));
		SciRecdMaterials recdmat = new SciRecdMaterials();
		recdmat.setSciMiMaster(mast);
		recdmat.setMatSpec(mast.getMatSpec());
		recdmat.setMatType(mast.getMatType());
		if(Float.parseFloat(bean.getReceivedCnt()) > 0 ) {
			
		}
		recdmat.setRecdQuantity(bean.getReceivedCnt());
		recdmat.setRecdDimension(bean.getReceivedDimen());
		recdmat.setRecdDate(new Date());
		recdmat.setPoId(new Long(bean.getSeqPurchId()));
		recdmat.setUpdatedDate(new Date());
		recdmat.setUpdatedBy(getUserPreferences().getUserID());
		recdmat.setRemarks(bean.getRemarks());
		recdmat.setMatcode(mast.getMatcode());
		recdmat.setInsertedBy(getUserPreferences().getUserID()) ;
		recdmat.setInsertedDate(new java.util.Date());
		service.addNewtoStores(storems, qcmi, getLookupservice().loadIDData(
				"MI_INQC").toString(), recdmat);
		
		// storems.set
		return success();
	}

	/*
	 * public Event searchByMatCode(RequestContext context) throws Exception {
	 * StoresBean bean = (StoresBean) getFormObject(context); List streqList =
	 * (List) context.getFlowScope().get("openstreq"); SciStoresRequest request
	 * = selectRequest(streqList, bean .getSeqSelectMIID());
	 * 
	 * List storelist = null;
	 * 
	 * storelist = service.getMiData(null, request.getMatcode());
	 * 
	 * context.getFlowScope().put("storeavailmi", storelist); return success();
	 * }
	 */
	public Event viewstores(RequestContext context) throws Exception {
		StoresBean bean = (StoresBean) getFormObject(context);

		List<SciAvailableMaterials> stlist = service.viewStore(bean);
		
		
		context.getFlowScope().put("stlist", stlist);
		return success();
	}

	public Event viewrecditems(RequestContext context) throws Exception {
		StoresBean bean = (StoresBean) getFormObject(context);

		List<SciRecdMaterials> stlist = service.viewrecd(bean);
		
		
		context.getFlowScope().put("recdlist", stlist);
		return success();
	}
	public Event getMatIndItems(RequestContext context) throws Exception {
		StoresBean bean = (StoresBean) getFormObject(context);
		List<SciPurchItemMaster> master = (List<SciPurchItemMaster>) context
				.getFlowScope().get("poitemslist");
		SciPurchItemMaster mast = selectPI(master, bean.getSeqItemId());

		List<SciMatindMaster> matitemlist = service.getMatItems(mast);
		context.getFlowScope().put("matitemlist", matitemlist);
		return success();
	}

	public Event loadQCUpdates(RequestContext context) throws Exception {

		List stlist = service.getQCUpdateS();
		context.getFlowScope().put("qcupdatelist", stlist);
		return success();
	}

	public Event addQCUpdates(RequestContext context) throws Exception {
		StoresBean bean = (StoresBean) getFormObject(context);
		List<SciQcMiMaster> masterlist = (List<SciQcMiMaster>) context
				.getFlowScope().get("qcupdatelist");
		SciQcMiMaster qcdata = selectQC(masterlist, bean.getSelectedQCID());
		SciStoreMiMaster storemi = qcdata.getStmimaster();
		storemi.setAvailableCnt(bean.getAvailableCnt());
		storemi.setAvailableDim(bean.getAvailableDim());
		storemi.setRecdStatus(bean.getOcStatus());
		storemi.setOcStatus("Y");
		storemi.setRemarks(bean.getRemarks());
		storemi.setUpdatedBy(getUserPreferences().getUserID());
		storemi.setUpdatedDt(new Date());
		qcdata.setOcStatus("D");
		qcdata.setUpdatedBy(getUserPreferences().getUserID());
		qcdata.setUpdatedDt(new Date());
		if(!"Y".equals(bean.getClosezeroItems())) {
		SciAvailableMaterials availmaters = new SciAvailableMaterials();

		availmaters.setSciMiMaster(qcdata.getSciMiMaster());
		availmaters.setAvailQty(bean.getAvailableCnt());
		availmaters.setAvailDimension(bean.getAvailableDim());
		availmaters.setMatcode(storemi.getMatCode());
		availmaters.setMatSpec(storemi.getMatSpec());
		availmaters.setMatSpec(storemi.getMatType());
		availmaters.setUpdatedBy(getUserPreferences().getUserID());
		availmaters.setUpdatedDate(new Date());
		availmaters.setRemarks(bean.getRemarks());
		availmaters.setIssuedFully("N");
		availmaters.setSeqQcId(qcdata.getSeqQcMiId());
		availmaters.setInsertedBy(getUserPreferences().getUserID()) ;
		availmaters.setInsertedDate(new java.util.Date());
		service.updateQCData(storemi, qcdata, availmaters,getLookupservice().loadIDData(
		"MI_INSTORES"));
		}
		else {
			service.updateQCData(storemi, qcdata, null,getLookupservice().loadIDData(
			"MI_INSTORES"));
		}
		resetForm(context);
		return success();
	}

	private SciQcMiMaster selectQC(List<SciQcMiMaster> master, Long seqqcmiid) {
		SciQcMiMaster selected = null;
		for (SciQcMiMaster m : master) {
			if (m.getSeqQcMiId().intValue() == seqqcmiid.intValue()) {
				selected = m;
			}
		}

		return selected;
	}

	private SciAvailableMaterials selectAvailable(
			List<SciAvailableMaterials> master, Long seqAvailId) {
		SciAvailableMaterials selected = null;
		for (SciAvailableMaterials m : master) {
			if (m.getSeqAvailId().intValue() == seqAvailId.intValue()) {
				selected = m;
			}
		}

		return selected;
	}

	public Event loadrecdMIItems(RequestContext context) throws Exception {
		StoresBean bean = (StoresBean) getFormObject(context);
		List<SciMatindMaster> master = (List<SciMatindMaster>) context
				.getFlowScope().get("matitemlist");
		SciMatindMaster mast = selectMI(master, bean.getSeqSelectMIID());
		List recdmiitems = service.getRecdMIs(mast.getSeqMiId());
		context.getFlashScope().put("recditems", recdmiitems);
		return success();
	}

	public Event loadAvail(RequestContext context) throws Exception {

		StoresBean bean = (StoresBean) getFormObject(context);
		List<SciQcMiMaster> masterlist = (List<SciQcMiMaster>) context
				.getFlowScope().get("qcupdatelist");
		SciQcMiMaster qcdata = selectQC(masterlist, bean.getSelectedQCID());
		bean.setAvailableCnt(qcdata.getQcAppCnt());
		bean.setAvailableDim(qcdata.getQcAppDime());

		return success();
	}

	public Event issueItem(RequestContext context) throws Exception {
		StoresBean bean = (StoresBean) getFormObject(context);
		List<SciAvailableMaterials> masterlist = (List<SciAvailableMaterials>) context
				.getFlowScope().get("storeavailmi");

		SciAvailableMaterials availdata = selectAvailable(masterlist, bean
				.getSeqAvailId());
		SciStoresRequest request = (SciStoresRequest) context.getFlowScope()
				.get("selectedreq");

		SciStoreissueMaster master = new SciStoreissueMaster();
		BeanUtils.copyProperties(master, bean);
		availdata.setAvailDimension(bean.getAvailableDim());
	
		if (bean.getAvailableCnt() == null || "".equals(bean.getAvailableCnt().trim())) {
			
			double cnt = Double.parseDouble(availdata.getAvailQty())- bean.getIssueCnt().doubleValue();
			System.out.println("final store count" + cnt);
			if(cnt < 0) {
				
				throw new Exception(" quantity cannot be null or negative");
			}
			
			availdata.setAvailQty(String.valueOf(cnt));
		} else {
			
			if(Double.parseDouble(bean.getAvailableCnt()) < 0 )  {
				throw new Exception(" quantity cannot be negative");
			}
			else {
			availdata.setAvailQty(bean.getAvailableCnt());
			}
		}

		request.setRequestStatus(bean.getStorerequestStatus() == null ? "N"
				: "Y");
		request.setUpdatedBy(getUserPreferences().getUserID());
		request.setUpdatedDt(new Date());
		
		availdata.setUpdatedBy(getUserPreferences().getUserID());
		availdata.setUpdatedDate(new Date());
		availdata.setSeqStreqId(request.getSeqStreqId());
		availdata.setIssuedFully(bean.getIssuedStatus() == null ? "N" : "Y");
		master.setSciMiMaster(availdata.getSciMiMaster());
		master.setStrequest(request);
		master.setUpdatedBy(getUserPreferences().getUserID());
		master.setUpdatedDt(new Date());
		master.setIssueDate(new Date());
		if(Float.parseFloat(request.getReqQuantity()) < bean.getIssueCnt().floatValue()) {
			master.setReturnStatus("Y");
		}
		else {
			master.setReturnStatus("N");
		}
		master.setMatcode(request.getMatcode());
		master.setMatSpec(request.getMatSpec());
		master.setMatType(request.getMatType());
		master.setInsertedBy(getUserPreferences().getUserID()) ;
		master.setInsertedDate(new java.util.Date());
		master.setIssueAcceptance("N");
		service.issueItems(master, availdata, request);
		return success();
	}

	/*public Event load(RequestContext context) throws Exception {
		StoresBean bean = (StoresBean) getFormObject(context);
		List<SciAvailableMaterials> masterlist = (List<SciAvailableMaterials>) context
				.getFlowScope().get("storeavailmi");
		SciAvailableMaterials availdata = selectAvailable(masterlist, bean
				.getSeqAvailId());
		SciStoreissueMaster master = new SciStoreissueMaster();
		BeanUtils.copyProperties(master, bean);
		master.setSeqMiId(bean.getSeqmiid());
		master.setUpdatedBy(getUserPreferences().getUserID());
		master.setUpdatedDt(new Date());
		master.setIssueDate(new Date());
		service.issueItems(master);
		return success();
	}*/

	public Event loadStoreRequest(RequestContext context) throws Exception {
		StoresBean bean = (StoresBean) getFormObject(context);
		
		List<SciStoresRequest> mylist = null;
		//bean.setWmaster(wmaster);
		
		
		System.out.println("inside storemanager");
		mylist = service.loadStoreRequest(bean);
		context.getFlowScope().put("openstreq", mylist);
		
		return success();
	}
	public Event loadreturnRequest(RequestContext context) throws Exception {
		StoresBean bean = (StoresBean) getFormObject(context);
		
		List<SciStoresRequest> mylist = null;
		//bean.setWmaster(wmaster);
		System.out.println("inside storemanager");
		mylist = service.loadReturnRequest(bean);
		context.getFlowScope().put("openreturnreq", mylist);

		return success();
	}
	public Event searchIssueList(RequestContext context) throws Exception {
		StoresBean bean = (StoresBean) getFormObject(context);
		List<SciStoreissueMaster> mylist = null;
		mylist = service.loadStoreissueList(bean);
		context.getFlowScope().put("storeissuelist", mylist);

		return success();
	}
	public Event searchIssueListForReturn(RequestContext context) throws Exception {
		StoresBean bean = (StoresBean) getFormObject(context);
		/*SciWorkorderMaster wmaster = (SciWorkorderMaster) context.getFlowScope().get("selectedwo");
		bean.setWmaster(wmaster);
		bean.setSeqWorkId(wmaster.getSeqWorkId());*/
		if("Y".equals(bean.getRequestUserId())) {
			bean.setRequestUserId(getUserPreferences().getUserID());		
		}
	
		System.out.println(bean.getFromdate());
		List<SciStoreissueMaster> mylist = null;
		mylist = service.loadStoreissueList(bean);
		context.getFlowScope().put("openreturnreq", mylist);

		return success();
	}
	private SciStoresRequest selectRequest(List<SciStoresRequest> master,
			Long seqStoreID) {
		SciStoresRequest selected = null;
		for (SciStoresRequest m : master) {
			if (m.getSeqStreqId().intValue() == seqStoreID.intValue()) {
				selected = m;
			}
		}

		return selected;
	}
	
	private SciReturnitemsRequest selectReturn(List<SciReturnitemsRequest> master,
			Long seqReturnId) {
		SciReturnitemsRequest selected = null;
		for (SciReturnitemsRequest m : master) {
			if (m.getSeqRtreqId().intValue() == seqReturnId.intValue()) {
				selected = m;
			}
		}

		return selected;
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
	
	
	public Event loadMatCatItems(RequestContext context) throws Exception {
		StoresBean command = (StoresBean) getFormObject(context);
		List matcatlist = prservice.selectCategory(command.getMatDept());
		context.getFlowScope().put("matcatitems",matcatlist);
		return success();
	}
	public Event loadAvailmat(RequestContext context) throws Exception {
		StoresBean command = (StoresBean) getFormObject(context);
		List matcatlist = prservice.selectCategory(command.getMatDept());
		context.getFlowScope().put("matcatitems",matcatlist);
		return success();
	}
	
	public Event addReturnRequest(RequestContext context) throws Exception {
		StoresBean command = (StoresBean) getFormObject(context);
		SciReturnitemsRequest request = new SciReturnitemsRequest();
		List<SciStoreissueMaster> issuelist = (List<SciStoreissueMaster>) context.getFlowScope().get("openreturnreq");
		
		SciStoreissueMaster master = selectIssueRequest(issuelist,command.getSeqStoreissueId());
		BeanUtils.copyProperties(request, command);
		
		request.setInsertedBy(getUserPreferences().getUserID());
		request.setInsertedDate(new Date());
		request.setUpdatedBy(getUserPreferences().getUserID());
		request.setUpdatedDt(new Date());
		request.setRetDate(new Date());
		request.setSciMiMaster(master.getSciMiMaster());
		
		request.setStissue(master);
		request.setRequestStatus("N");
		request.setMatcode(master.getSciMiMaster().getMatcode());
		request.setMatSpec(master.getSciMiMaster().getMatSpec());
		request.setMatType(master.getSciMiMaster().getMatType());
		if("Y".equals(command.getIsScrap())) {
			request.setProdRemarks("SCRAP");
			request.setRequestStatus("Y");
		}
		
		master.setReturnStatus("N");
		master.setUpdatedBy(getUserPreferences().getUserID());
		master.setUpdatedDt(new Date());
		service.addStoreReturns(request, master);
		searchIssueListForReturn(context);
		resetForm(context);
		return success();
		
	}
	
	
	
	public Event loadReturnUpdate(RequestContext context) {
		List stlist = service.loadReturnupdates();
		context.getFlowScope().put("retupdatelist", stlist);
		return success();
		
	}

	
	public Event loadAvailReturn(RequestContext context) throws Exception {

		StoresBean bean = (StoresBean) getFormObject(context);
		List<SciReturnitemsRequest> masterlist = (List<SciReturnitemsRequest>) context
				.getFlowScope().get("retupdatelist");
		SciReturnitemsRequest retdata = selectReturn(masterlist, bean.getSelectedQCID());
		bean.setAvailableCnt(retdata.getRetQuantity());
		bean.setAvailableDim(retdata.getRetDimension());
		bean.setRemarks(retdata.getProdRemarks());
		return success();
	}
	
	
	
	
	
	public Event addReturnUpdates(RequestContext context) throws Exception {
		StoresBean bean = (StoresBean) getFormObject(context);
		List<SciReturnitemsRequest> masterlist = (List<SciReturnitemsRequest>) context
				.getFlowScope().get("retupdatelist");
		SciReturnitemsRequest retdata = selectReturn(masterlist, bean.getSelectedQCID());
	
		if(!"Y".equals(retdata.getDamagedStatus()) ) {
			SciAvailableMaterials availmaters = null;
			if(!"Y".equals(bean.getClosezeroItems())) {
		
				availmaters = new SciAvailableMaterials();
		availmaters.setSciMiMaster(retdata.getSciMiMaster());
		availmaters.setAvailQty(bean.getAvailableCnt());
		availmaters.setAvailDimension(bean.getAvailableDim());
		availmaters.setMatcode(retdata.getSciMiMaster().getMatcode());
		availmaters.setMatSpec(retdata.getSciMiMaster().getMatSpec());
		availmaters.setMatSpec(retdata.getSciMiMaster().getMatType());
		availmaters.setUpdatedBy(getUserPreferences().getUserID());
		availmaters.setUpdatedDate(new Date());
		availmaters.setRemarks(bean.getRemarks());
		availmaters.setIssuedFully("N");
		availmaters.setInsertedBy(getUserPreferences().getUserID()) ;
		availmaters.setInsertedDate(new java.util.Date());
		
		retdata.setUpdatedBy(getUserPreferences().getUserID());
		retdata.setUpdatedDt(new Date());
		retdata.setRequestStatus("Y");
			}
			
			else {
				retdata.setProdRemarks("Stores Closed as Zero Items as the Request was wrong");
				retdata.setRequestStatus("R");
				retdata.setRetQuantity("0");
				
				retdata.setUpdatedBy(getUserPreferences().getUserID());
				retdata.setUpdatedDt(new Date());
				
			}
		//availmaters.setSeqQcId(qcdata.getSeqQcMiId());
	
		/*service.updateQCData(storemi, qcdata, availmaters,getLookupservice().loadIDData(
		"MI_INSTORES"));*/
		service.addReturntoStores(availmaters, retdata);
		}
		else {
			SciRejectedMaterials damaMater = new SciRejectedMaterials();

			damaMater.setSciMiMaster(retdata.getSciMiMaster());
			damaMater.setRejdQuantity(bean.getAvailableCnt());
			damaMater.setRejdDimension(bean.getAvailableDim());
			damaMater.setMatcode(retdata.getSciMiMaster().getMatcode());
			damaMater.setMatSpec(retdata.getSciMiMaster().getMatSpec());
			damaMater.setMatSpec(retdata.getSciMiMaster().getMatType());
			damaMater.setUpdatedBy(getUserPreferences().getUserID());
			damaMater.setUpdatedDate(new Date());
			damaMater.setRemarks(bean.getRemarks());
			damaMater.setRejectStatus("NEW_REJECTED");
			damaMater.setRejdDate(retdata.getRetDate());
			retdata.setRequestStatus(bean.getOcStatus());
			retdata.setUpdatedBy(getUserPreferences().getUserID());
			retdata.setUpdatedDt(new Date());
			//availmaters.setSeqQcId(qcdata.getSeqQcMiId());
			damaMater.setInsertedBy(getUserPreferences().getUserID()) ;
			damaMater.setInsertedDate(new java.util.Date());
			service.addDamagedMaterial(damaMater, retdata);
		}
		resetForm(context);
		return success();
	}
}
