package com.sci.bpm.db.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * SciDrwingDetails entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_DRWING_DETAILS", schema = "SCIGENICS")
public class SciDrwingDetails implements java.io.Serializable {

	// Fields

	private Long seqDrwDtlid;
	private SciDrawingRef sciDrawingRef;
	
	private Long documentVersion;
	private String updatedBy;
	private Date updatedDate;
	private String drawingStatus;
	private String approvedBy;
	private byte[] dataFile;
	private String docCnttype;
	private String originalDoc;
	private String rejectedBy;
	private String rejectComments;
	
	private String drwdetails;
	// Constructors

	/** default constructor */
	public SciDrwingDetails() {
	}

	/** minimal constructor */
	public SciDrwingDetails(Long seqDrwDtlid, SciDrawingRef sciDrawingRef,
			 Long documentVersion, String updatedBy,
			Date updatedDate, String drawingStatus) {
		this.seqDrwDtlid = seqDrwDtlid;
		this.sciDrawingRef = sciDrawingRef;
		
		this.documentVersion = documentVersion;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.drawingStatus = drawingStatus;
	}

	/** full constructor */
	public SciDrwingDetails(Long seqDrwDtlid, SciDrawingRef sciDrawingRef,
			 Long documentVersion, String updatedBy,
			Date updatedDate, String drawingStatus, String approvedBy) {
		this.seqDrwDtlid = seqDrwDtlid;
		this.sciDrawingRef = sciDrawingRef;
		
		this.documentVersion = documentVersion;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.drawingStatus = drawingStatus;
		this.approvedBy = approvedBy;
	}

	// Property accessors
	@Id
	@Column(name = "SEQ_DRW_DTLID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_DRWING_DETAILS_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_DRWING_DETAILS_SEQ" ,name="SCI_DRWING_DETAILS_SEQ" )
	public Long getSeqDrwDtlid() {
		return this.seqDrwDtlid;
	}

	public void setSeqDrwDtlid(Long seqDrwDtlid) {
		this.seqDrwDtlid = seqDrwDtlid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SCI_DRWING_ID", nullable = false)
	public SciDrawingRef getSciDrawingRef() {
		return this.sciDrawingRef;
	}

	public void setSciDrawingRef(SciDrawingRef sciDrawingRef) {
		this.sciDrawingRef = sciDrawingRef;
	}

	

	@Column(name = "DOCUMENT_VERSION", nullable = false, precision = 22, scale = 0)
	public Long getDocumentVersion() {
		return this.documentVersion;
	}

	public void setDocumentVersion(Long documentVersion) {
		this.documentVersion = documentVersion;
	}

	@Column(name = "UPDATED_BY", nullable = false, length = 20)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE", nullable = false, length = 7)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "DRAWING_STATUS", nullable = false, length = 1)
	public String getDrawingStatus() {
		return this.drawingStatus;
	}

	public void setDrawingStatus(String drawingStatus) {
		this.drawingStatus = drawingStatus;
	}

	@Column(name = "APPROVED_BY", length = 20)
	public String getApprovedBy() {
		return this.approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	@Lob
	@Column(name = "DATA_FILE", nullable = false)
	public byte[] getDataFile() {
		return this.dataFile;
	}

	public void setDataFile(byte[] dataFile) {
		this.dataFile = dataFile;
	}
	@Column(name = "DOC_CNTTYPE", length = 200)
	public String getDocCnttype() {
		return docCnttype;
	}

	public void setDocCnttype(String docCnttype) {
		this.docCnttype = docCnttype;
	}
	@Column(name = "ORIGINAL_DOC", length = 200)
	public String getOriginalDoc() {
		return originalDoc;
	}

	public void setOriginalDoc(String originalDoc) {
		this.originalDoc = originalDoc;
	}

	@Transient
	public String getDrwdetails() {
		return this.seqDrwDtlid + ","+this.originalDoc;
	}

	public void setDrwdetails(String drwdetails) {
		this.drwdetails = drwdetails;
	}
	@Column(name = "REJECTED_BY", length = 20)
	public String getRejectedBy() {
		return rejectedBy;
	}

	public void setRejectedBy(String rejectedBy) {
		this.rejectedBy = rejectedBy;
	}
	@Column(name = "REJECT_COMMENT", length = 200)
	public String getRejectComments() {
		return rejectComments;
	}

	public void setRejectComments(String rejectComments) {
		this.rejectComments = rejectComments;
	}
	
	
}