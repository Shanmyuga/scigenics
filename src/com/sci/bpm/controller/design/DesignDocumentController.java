package com.sci.bpm.controller.design;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.sci.bpm.command.design.DrawingDetailsBean;
import com.sci.bpm.command.design.DrawingRefBean;
import com.sci.bpm.command.mi.MatCollectionCommand;
import com.sci.bpm.command.mi.MatindCommand;
import com.sci.bpm.controller.base.SciBaseController;
import com.sci.bpm.db.model.SciDesignDocMaster;
import com.sci.bpm.db.model.SciDrawingRef;
import com.sci.bpm.db.model.SciDrwingDetails;
import com.sci.bpm.db.model.SciMatindMaster;
import com.sci.bpm.db.model.SciMatspecMaster;
import com.sci.bpm.db.model.SciWoDesgDocs;
import com.sci.bpm.db.model.SciWorkorderMaster;
import com.sci.bpm.service.design.DesignDocService;
import com.sci.bpm.service.task.DiskWriterJob;

/**
 * 
 * @author prakash
 * 
 */
@Controller("drawcont")
public class DesignDocumentController extends SciBaseController {

	@Autowired
	private DiskWriterJob diskwriter;
	
	
	@Override
	public Event setupForm(RequestContext context) throws Exception {
		setFormObjectClass(DrawingRefBean.class);
		setFormObjectName("drawingbean");
		return super.setupForm(context);
	}

	@Autowired
	private DesignDocService service;

	public Event addDesignDoc(RequestContext context) throws Exception {

		DrawingRefBean bean = (DrawingRefBean) getFormObject(context);

		MultipartFile file = bean.getFiledoc();

		SciDrawingRef master = new SciDrawingRef();
		SciWorkorderMaster wmaster = (SciWorkorderMaster) context
				.getFlowScope().get("selectedwo");
		List<SciDesignDocMaster> desgdocs = (List) context.getFlowScope().get("desgdocs");
		SciDesignDocMaster selectdoc = selectDrawingdoc(desgdocs, bean.getDocumentid());
		BeanUtils.copyProperties(master, bean);
		master.setSciWorkorderMaster(wmaster);
		master.setDesgDocMaster(selectdoc);
		master.setDocumentName(selectdoc.getDocnumDesc());
		master.setUpdatedBy(getUserPreferences().getUserID());
		master.setUpdatedDate(new java.util.Date());
		master.setInsertedBy(getUserPreferences().getUserID());
		master.setInsertedDate(new java.util.Date());
		
		SciDrwingDetails details = new SciDrwingDetails();
		details.setDataFile(bean.getFiledoc().getBytes());
		details.setDrawingStatus("N");
		details.setUpdatedBy(getUserPreferences().getUserID());
		details.setDocumentVersion(new Long(1));
		details.setUpdatedDate(new java.util.Date());
		details.setOriginalDoc(file.getOriginalFilename());
		details.setDocCnttype(file.getContentType());
		master.adddesignDetails(details);
		service.addNewDesign(master);
		diskwriter.writeDrawings();
		return success();
	}

	public Event loaddrawingList(RequestContext context) {

		SciDrawingRef master = new SciDrawingRef();
		SciWorkorderMaster wmaster = (SciWorkorderMaster) context
				.getFlowScope().get("selectedwo");
		master.setSciWorkorderMaster(wmaster);
		List<SciDrwingDetails> deslist = service.searchDesignWorkOrder(master);
		
		context.getExternalContext().getSessionMap().put("workdes", deslist);
		context.getFlowScope().put("workdes", deslist);
		return success();
	}

	public Event loadAppdrawingList(RequestContext context) {

		SciDrawingRef master = new SciDrawingRef();
		SciWorkorderMaster wmaster = (SciWorkorderMaster) context
				.getFlowScope().get("selectedwo");
		master.setSciWorkorderMaster(wmaster);
		List deslist = service.searchApprovedDesignWork(master);
		context.getExternalContext().getSessionMap().put("workdes", deslist);
		context.getFlowScope().put("workdes", deslist);
		return success();
	}
	
	public Event loadPendingList(RequestContext context) {

		SciDrawingRef master = new SciDrawingRef();
		SciWorkorderMaster wmaster = (SciWorkorderMaster) context
				.getFlowScope().get("selectedwo");
		master.setSciWorkorderMaster(wmaster);
		List deslist = service.loadPendingDrawing(wmaster);
		
		context.getExternalContext().getSessionMap().put("penddesg", deslist);
		context.getFlowScope().put("penddesg", deslist);
		return success();
	}

	public Event loadunappdrawingList(RequestContext context) {

		SciDrawingRef master = new SciDrawingRef();
		SciWorkorderMaster wmaster = (SciWorkorderMaster) context
				.getFlowScope().get("selectedwo");
		master.setSciWorkorderMaster(wmaster);
		List deslist = service.searchUnappDesign(master);
		context.getExternalContext().getSessionMap().put("workdes", deslist);
		context.getFlowScope().put("workdes", deslist);
		return success();
	}

	public Event selectRevision(RequestContext context) throws Exception {

		DrawingRefBean bean = (DrawingRefBean) getFormObject(context);

		List<DrawingDetailsBean> mylist = (List<DrawingDetailsBean>) context
				.getFlowScope().get("workdes");
		DrawingDetailsBean ref = selectDrawing(mylist, new Long(bean
				.getRevisionid()));

		context.getFlowScope().put("revdrawing", ref);
		return success();
	}
	
	public Event deleteRevision(RequestContext context) throws Exception {

		DrawingRefBean bean = (DrawingRefBean) getFormObject(context);

		List<DrawingDetailsBean> mylist = (List<DrawingDetailsBean>) context
				.getFlowScope().get("workdes");
		DrawingDetailsBean ref = selectDrawing(mylist, new Long(bean
				.getRevisionid()));
	     if(!"Y".equals(ref.getDrawingStatus())) {
	    	 service.deleteDesign(ref.getSeqDrwDtlid());
	     }
		//context.getFlowScope().put("revdrawing", ref);
		return success();
	}

	public Event addRevision(RequestContext context) throws Exception {

		DrawingRefBean bean = (DrawingRefBean) getFormObject(context);
		MultipartFile file = bean.getFiledoc();
		DrawingDetailsBean referdetails = (DrawingDetailsBean) context
				.getFlowScope().get("revdrawing");

		SciDrwingDetails details = new SciDrwingDetails();
		details.setDataFile(bean.getFiledoc().getBytes());
		details.setDrawingStatus("N");
		details.setUpdatedBy(getUserPreferences().getUserID());
		details.setDocumentVersion(referdetails.getDocumentVersion() + 1);
		details.setUpdatedDate(new java.util.Date());
		details.setOriginalDoc(file.getOriginalFilename());
		details.setDocCnttype(file.getContentType());
		details.setSciDrawingRef(referdetails.getSciDrawingRef());

		service.addRevision(details);
		diskwriter.writeDrawings();
		return success();
	}

	public Event approveDesign(RequestContext context) throws Exception {

		DrawingRefBean bean = (DrawingRefBean) getFormObject(context);

		String[] details = bean.getDetailID();

		String seqdetailsid = "";
		for (int idx = 0; idx < details.length; idx++) {

			seqdetailsid = seqdetailsid + details[idx] + ",";
		}
		seqdetailsid = seqdetailsid.substring(0, seqdetailsid.length() - 1);

		service.approveDesign(seqdetailsid, getUserPreferences().getUserID());

		return success();
	}
	
	public Event rejectDesign(RequestContext context) throws Exception {

		DrawingRefBean bean = (DrawingRefBean) getFormObject(context);

		String[] details = bean.getDetailID();

		String seqdetailsid = "";
		for (int idx = 0; idx < details.length; idx++) {

			seqdetailsid = seqdetailsid + details[idx] + ",";
		}
		seqdetailsid = seqdetailsid.substring(0, seqdetailsid.length() - 1);

		service.rejectDesign(seqdetailsid, getUserPreferences().getUserID(),bean.getRejectComments());

		return success();
	}

	private DrawingDetailsBean selectDrawing(List<DrawingDetailsBean> workdes,
			Long seqId) {

		DrawingDetailsBean selectedDrf = null;
		for (DrawingDetailsBean drawref : workdes) {
			if (drawref.getSeqDrwDtlid().intValue() == seqId.intValue()) {
				selectedDrf = drawref;
				break;
			}
		}
		return selectedDrf;
	}

	private SciDesignDocMaster selectDrawingdoc(List<SciDesignDocMaster> workdes,
			Long seqId) {

		SciDesignDocMaster selectedDrf = null;
		for (SciDesignDocMaster drawref : workdes) {
			if (drawref.getSeqDesDocId().intValue() == seqId.intValue()) {
				selectedDrf = drawref;
				break;
			}
		}
		return selectedDrf;
	}
	public Event loadDesignDocs(RequestContext context) {
		List doclist = service.loadDocs();

		context.getFlowScope().put("desgdocs", doclist);
		return success();
	}

	public Event addDesignDocMaster(RequestContext context) throws Exception {
		DrawingRefBean bean = (DrawingRefBean) getFormObject(context);
		SciDesignDocMaster master = new SciDesignDocMaster();

		BeanUtils.copyProperties(master, bean);
		
	
		master.setInsertedBy(getUserPreferences().getUserID());
		master.setInsertedDate(new Date());
		service.addDesgDocMaster(master);

		return success();
	}

	public Event loadDesgPlan(RequestContext context) throws Exception {
		DrawingRefBean bean = (DrawingRefBean) getFormObject(context);
		SciWorkorderMaster wmaster = (SciWorkorderMaster) context
		.getFlowScope().get("selectedwo");

		List desplanlist = service.loadDesgPlan(wmaster);
		context.getFlowScope().put("desgplan", desplanlist);

		return success();
	}
	public Event addDesignPlan(RequestContext context) throws Exception {
		DrawingRefBean bean = (DrawingRefBean) getFormObject(context);
		List itemmilist = new ArrayList();
		SciWorkorderMaster wmaster = (SciWorkorderMaster) context
		.getFlowScope().get("selectedwo");
		
		List fulldoclist = (List) context.getFlowScope().get("desgdocs");
		
		
		List<MatCollectionCommand> matslist = bean.getMatList();
		String seqmilist = "";
		List<SciWoDesgDocs> finallst = new ArrayList();
		for (MatCollectionCommand mcoll:matslist) {
			if(mcoll.getMatindex() == null) {
				continue;
			}
			int position = Integer.parseInt(mcoll.getMatindex()) - 1;
			SciDesignDocMaster master = (SciDesignDocMaster) fulldoclist.get(position);
			SciWoDesgDocs designdoc = new SciWoDesgDocs();
			Date matdueDate = mcoll.getMatDuedate();
			designdoc.setSciWorkorderMaster(wmaster);
			designdoc.setDocmaster(master);
			designdoc.setEstCompletionDt(matdueDate);
			designdoc.setInsertedBy(getUserPreferences().getUserID());
			designdoc.setInsertedDate(new Date());
			finallst.add(designdoc);
			mcoll.reset();
			//seqmilist = seqmilist + master.getSeqMiId() + ",";
		}
		//seqmilist = seqmilist.substring(0, seqmilist.length() - 1);
		
		
		
		resetForm(context);
		service.addDesignPlan(finallst);
		return success();
	}
}
