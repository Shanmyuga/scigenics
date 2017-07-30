package com.sci.bpm.command.design;

import java.io.Serializable;
import java.util.Date;

import com.sci.bpm.db.model.SciDrawingRef;

public class DrawingDetailsBean implements Serializable {
	private Long seqDrwDtlid;
	private SciDrawingRef sciDrawingRef;
	
	private Long documentVersion;
	private String updatedBy;
	private Date updatedDate;
	private String drawingStatus;
	private String approvedBy;
	private String rejectComments;
	
	private String docCnttype;
	private String originalDoc;
	
	private String drwdetails;

	public Long getSeqDrwDtlid() {
		return seqDrwDtlid;
	}

	public void setSeqDrwDtlid(Long seqDrwDtlid) {
		this.seqDrwDtlid = seqDrwDtlid;
	}

	public SciDrawingRef getSciDrawingRef() {
		return sciDrawingRef;
	}

	public void setSciDrawingRef(SciDrawingRef sciDrawingRef) {
		this.sciDrawingRef = sciDrawingRef;
	}

	public Long getDocumentVersion() {
		return documentVersion;
	}

	public void setDocumentVersion(Long documentVersion) {
		this.documentVersion = documentVersion;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getDrawingStatus() {
		return drawingStatus;
	}

	public void setDrawingStatus(String drawingStatus) {
		this.drawingStatus = drawingStatus;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getDocCnttype() {
		return docCnttype;
	}

	public void setDocCnttype(String docCnttype) {
		this.docCnttype = docCnttype;
	}

	public String getOriginalDoc() {
		return originalDoc;
	}

	public void setOriginalDoc(String originalDoc) {
		this.originalDoc = originalDoc;
	}

	public String getDrwdetails() {
		return this.seqDrwDtlid + ","+this.originalDoc;
	}

	public void setDrwdetails(String drwdetails) {
		this.drwdetails = drwdetails;
	}

	public String getRejectComments() {
		return rejectComments;
	}

	public void setRejectComments(String rejectComments) {
		this.rejectComments = rejectComments;
	}

	public DrawingDetailsBean(Long seqDrwDtlid, SciDrawingRef sciDrawingRef,
			Long documentVersion, String updatedBy, Date updatedDate,
			String drawingStatus, String approvedBy, String docCnttype,
			String originalDoc) {
		super();
		this.seqDrwDtlid = seqDrwDtlid;
		this.sciDrawingRef = sciDrawingRef;
		this.documentVersion = documentVersion;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.drawingStatus = drawingStatus;
		this.approvedBy = approvedBy;
		this.docCnttype = docCnttype;
		this.originalDoc = originalDoc;
		
	}

	public DrawingDetailsBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
