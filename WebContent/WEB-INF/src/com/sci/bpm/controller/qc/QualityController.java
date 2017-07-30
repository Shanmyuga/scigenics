package com.sci.bpm.controller.qc;

import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.sci.bpm.command.qc.QualityControlBean;
import com.sci.bpm.command.stores.StoresBean;
import com.sci.bpm.controller.base.SciBaseController;
import com.sci.bpm.db.model.SciQcDocs;
import com.sci.bpm.db.model.SciQcMiMaster;
import com.sci.bpm.db.model.SciRejectedMaterials;
import com.sci.bpm.service.product.ProductMasterService;
import com.sci.bpm.service.qc.QCService;
import com.sci.bpm.service.stores.StoreService;
import com.sci.bpm.service.task.DiskWriterJob;

@Controller("qccont")
public class QualityController extends SciBaseController {

	@Autowired
	private QCService service;

	@Autowired
	private StoreService storeservice;
	@Autowired
	private ProductMasterService prservice;
	
	@Autowired
	private DiskWriterJob diskwriter;
	
	@Override
	public Event setupForm(RequestContext context) throws Exception {
		// TODO Auto-generated method stub

		setFormObjectClass(QualityControlBean.class);
		setFormObjectName("qcbean");
		return super.setupForm(context);
	}
	public Event selectQC(RequestContext context) throws Exception {

		QualityControlBean bean = (QualityControlBean) getFormObject(context);
		List mydocs  = service.loadQCDocs(bean.getSeqQCId());
		context.getExternalContext().getSessionMap().put("qcdocsList", mydocs);
		context.getFlowScope().put("qcdocs", mydocs);
		return success();
	}
	
	
	public Event addQCDocs(RequestContext context) throws Exception {

		QualityControlBean bean = (QualityControlBean) getFormObject(context);
		MultipartFile file = bean.getFiledoc();
		SciQcDocs master = new SciQcDocs();
 		master.setDataFile(bean.getFiledoc().getBytes());
		
		
		master.setOriginalFile(file.getOriginalFilename());
		master.setDocCnttype(file.getContentType());
		master.setUpdatedBy(getUserPreferences().getUserID());
		master.setUpdatedDt(new java.util.Date());
		master.setSeqQcId(bean.getSeqQCId());
		service.addQCDocs(master);
		selectQC(context);
		diskwriter.writeQC();
		return success();
	}
	public Event loadQCItems(RequestContext context) throws Exception{
		QualityControlBean bean = (QualityControlBean) getFormObject(context);
		List mylist = service.loadQCItems(bean.getDept());

		context.getFlowScope().put("qcitemslist", mylist);
		return success();
	}

	
	public Event loadUnapprovedQCItems(RequestContext context) throws Exception {
		QualityControlBean bean = (QualityControlBean) getFormObject(context);
		List mylist = service.loadunapprovedList(bean.getDept());

		context.getFlowScope().put("qcunappitemslist", mylist);
		return success();
	}
	
	
	public Event loadAllQCItems(RequestContext context) throws Exception {
		QualityControlBean bean = (QualityControlBean) getFormObject(context);
		List mylist = service.loadAllList(bean);

		context.getFlowScope().put("qcallupdateditems", mylist);
		return success();
	}
	public Event loadAllIssueQCItems(RequestContext context) throws Exception {
		QualityControlBean bean = (QualityControlBean) getFormObject(context);
		List mylist = service.loadAllListIssueDocs(bean);

		context.getFlowScope().put("qcallupdateditems", mylist);
		return success();
	}
	
	public Event loadAllQCItemsDocs(RequestContext context) throws Exception {
		QualityControlBean bean = (QualityControlBean) getFormObject(context);
		List mylist = service.loadAllListDocs(bean);

		context.getFlowScope().put("qcunappitemslist", mylist);
		return success();
	}
	public Event loadApprovedQCItems(RequestContext context) {
		List mylist = service.loadApprovedList();

		context.getFlowScope().put("qcappitemslist", mylist);
		return success();
	}
	private SciQcMiMaster selectPI(List<SciQcMiMaster> master, Long seqQCMIId) {
		SciQcMiMaster selected = null;
		for (SciQcMiMaster m : master) {
			if (m.getSeqQcMiId().intValue() == seqQCMIId.intValue()) {
				selected = m;
			}
		}

		return selected;
	}

	public Event addQCResults(RequestContext context) throws Exception {

		QualityControlBean bean = (QualityControlBean) getFormObject(context);
		List<SciQcMiMaster> master = (List<SciQcMiMaster>) context
				.getFlowScope().get("qcitemslist");
		SciQcMiMaster mast = selectPI(master, bean.getSeqQcMiId());

		BeanUtils.copyProperties(mast, bean);

		mast.setUpdatedBy(getUserPreferences().getUserID());
		mast.setUpdatedDt(new java.util.Date());
		mast.setQcTestsApproval("N");
		mast.setOcStatus("Y");
		SciRejectedMaterials rejected = null;
		
		
		if("Y".equals(mast.getFailedStatus())) {
			rejected = new SciRejectedMaterials();
			BeanUtils.copyProperties(rejected, mast);
			rejected.setSeqQcId(mast.getSeqQcMiId());
			rejected.setRejdDate(new Date());
			rejected.setInsertedBy(getUserPreferences().getUserID());
			rejected.setInsertedDate(new Date());
			rejected.setRejdQuantity(mast.getQcFailedCnt());
			rejected.setRejdDimension(mast.getQcFailedDim());
			rejected.setMatcode(mast.getMatCode());
			rejected.setRemarks(mast.getQcFailReason());
			rejected.setUpdatedDate(new Date());
			rejected.setPoId(mast.getPoId());
			rejected.setRejectStatus("NEW_REJECTED");
			
		}
		if(Double.parseDouble(mast.getQcAppCnt())<0){
			throw new Exception();
		}
		// service.addNewStore(storems, mast);
		// storems.set
		service.updateQCResult(mast,rejected);
		loadQCItems(context);
		resetForm(context);
		return success();
	}
	
	public Event approveQC(RequestContext context) throws Exception {

		QualityControlBean bean = (QualityControlBean) getFormObject(context);
		List<SciQcMiMaster> masterlist = (List<SciQcMiMaster>) context
		.getFlowScope().get("qcunappitemslist");
		SciQcMiMaster master = selectPI(masterlist, bean.getSeqQCId());
		master.setQcTestsApproval(bean.getApproval());
		if("N".equals(bean.getApproval())) {
			master.setOcStatus("N");
		}
		
		master.setApprovedBy(getUserPreferences().getUserID());
		master.setQcApprovalDate(new java.util.Date());
		if(bean.getQcTestsCond() != null && !"".equals(bean.getQcTestsCond())) {
			master.setQcTestsCond(bean.getQcTestsCond());
		}
		if(bean.getQcFailReason() != null && !"".equals(bean.getQcFailReason())) {
			master.setQcFailReason(bean.getQcFailReason());
		}
		service.approveQC(master);
		loadUnapprovedQCItems(context);
		
		return success();
	}
	
	public Event loadMatCatItems(RequestContext context) throws Exception {
		QualityControlBean command = (QualityControlBean) getFormObject(context);
		List matcatlist = prservice.selectCategory(command.getMatDept());
		context.getFlowScope().put("matcatitems",matcatlist);
		return success();
	}
}
