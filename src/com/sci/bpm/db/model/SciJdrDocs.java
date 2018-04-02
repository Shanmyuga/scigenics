package com.sci.bpm.db.model;


import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SciJdrDocs entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_JDR_DOCS", schema = "SCIGENICS")
public class SciJdrDocs implements java.io.Serializable {

	// Fields

	private Long seqJdrId;
	private Long seqWorkId;
	private String jdrDesc;
	private byte[] jdrDoc;
	private String jdrDocName;
	private String updatedBy;
	private Date updatedDate;
	private String docVersion;
	private String originalDoc;
	private Long docType;



	private String docCnttype;
	// Constructors

	/** default constructor */
	public SciJdrDocs() {
	}

	/** minimal constructor */
	public SciJdrDocs(Long seqJdrId, Long seqWorkId, String jdrDoc,
			String jdrDocName) {
		this.seqJdrId = seqJdrId;
		this.seqWorkId = seqWorkId;
		
		this.jdrDocName = jdrDocName;
		
		
	}

	/** full constructor */
	public SciJdrDocs(Long seqJdrId, Long seqWorkId,
			String jdrDesc, String jdrDoc, String jdrDocName) {
		this.seqJdrId = seqJdrId;
		this.seqWorkId = seqWorkId;
		this.jdrDesc = jdrDesc;
		
		this.jdrDocName = jdrDocName;
	}

	// Property accessors
	@Id
	@Column(name = "SEQ_JDR_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_JDR_DOC_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_JDR_DOC_SEQ" ,name="SCI_JDR_DOC_SEQ" )
	public Long getSeqJdrId() {
		return this.seqJdrId;
	}

	public void setSeqJdrId(Long seqJdrId) {
		this.seqJdrId = seqJdrId;
	}

	@Column(name = "SEQ_WORK_ID", nullable = false, precision = 22, scale = 0)
	public Long getSeqWorkId() {
		return this.seqWorkId;
	}

	public void setSeqWorkId(Long seqWorkId) {
		this.seqWorkId = seqWorkId;
	}

	@Column(name = "JDR_DESC", length = 100)
	public String getJdrDesc() {
		return this.jdrDesc;
	}

	public void setJdrDesc(String jdrDesc) {
		this.jdrDesc = jdrDesc;
	}

	
	
	@Column(name = "JDR_DOC_NAME", nullable = false, length = 100)
	public String getJdrDocName() {
		return this.jdrDocName;
	}

	public void setJdrDocName(String jdrDocName) {
		this.jdrDocName = jdrDocName;
	}
	@Lob
	@Column(name = "JDR_DOC", nullable = false)
	public byte[] getJdrDoc() {
		return jdrDoc;
	}

	public void setJdrDoc(byte[] jdrDoc) {
		this.jdrDoc = jdrDoc;
	}
	
	@Column(name = "UPDATED_BY", length = 20)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE", length = 7)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "DOC_VERSION", length = 3)
	public String getDocVersion() {
		return this.docVersion;
	}

	public void setDocVersion(String docVersion) {
		this.docVersion = docVersion;
	}
	@Column(name = "ORIGINAL_DOC", nullable = true, length = 100)
	public String getOriginalDoc() {
		return originalDoc;
	}

	public void setOriginalDoc(String originalDoc) {
		this.originalDoc = originalDoc;
	}
	@Column(name = "DOC_CNTTYPE", nullable = true, length = 200)
	public String getDocCnttype() {
		return docCnttype;
	}

	public void setDocCnttype(String docCnttype) {
		this.docCnttype = docCnttype;
	}
	@Column(name = "DOC_TYPE", nullable = true, length = 20)
	public Long getDocType() {
		return docType;
	}

	public void setDocType(Long docType) {
		this.docType = docType;
	}

}