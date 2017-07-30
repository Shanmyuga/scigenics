package com.sci.bpm.controller.marketing;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.sci.bpm.command.design.DrawingRefBean;
import com.sci.bpm.command.marketing.JobDescBean;
import com.sci.bpm.controller.base.SciBaseController;
import com.sci.bpm.db.model.SciDrawingRef;
import com.sci.bpm.db.model.SciDrwingDetails;
import com.sci.bpm.db.model.SciJdrDocs;
import com.sci.bpm.db.model.SciWorkorderMaster;
import com.sci.bpm.service.marketing.WorkOrderService;
import com.sci.bpm.service.task.DiskWriterJob;


@Controller("jdrcont")
public class JDRMasterController extends SciBaseController {
	
	@Autowired
	private WorkOrderService service;
	
	@Autowired
	private DiskWriterJob diskwriter;
	
	public Event addJdrWork(RequestContext context) throws Exception{
		
		JobDescBean bean = (JobDescBean) getFormObject(context);

		MultipartFile file = bean.getFiledoc();

		SciJdrDocs master = new SciJdrDocs();
		SciWorkorderMaster wmaster = (SciWorkorderMaster) context
				.getFlowScope().get("selectedwo");
		BeanUtils.copyProperties(master, bean);
		master.setSeqWorkId(wmaster.getSeqWorkId());
		master.setUpdatedBy(getUserPreferences().getUserID());
		master.setUpdatedDate(new java.util.Date());
		
		master.setJdrDoc(bean.getFiledoc().getBytes());
		
		
		master.setOriginalDoc(file.getOriginalFilename());
		master.setDocCnttype(file.getContentType());
		
		service.addJDRDcos(master);
		diskwriter.writejdr();
		return success();
	}

	@Override
	public Event setupForm(RequestContext context) throws Exception {
		
		setFormObjectClass(JobDescBean.class);
		setFormObjectName("jdrbean");
		return super.setupForm(context);
	}
	
	
	public Event loadJdrList(RequestContext context) {

		
		SciWorkorderMaster wmaster = (SciWorkorderMaster) context
				.getFlowScope().get("selectedwo");
		
		List jdrlist = service.getJDRDocs(wmaster.getSeqWorkId());
		context.getExternalContext().getSessionMap().put("workjdr", jdrlist);
		context.getFlowScope().put("workjdrdocs", jdrlist);
		return success();
	}
	
	

}
