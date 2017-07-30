package com.sci.bpm.db.model;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SciQcDocs entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_QC_DOCS", schema = "SCIGENICS")
public class SciQcDocs implements java.io.Serializable {

	// Fields

	private Long seqQcDocId;
	private String originalFile;
	private byte[] dataFile;
	private String docCnttype;
	private String docVersion;
	private String updatedBy;
	private Date updatedDt;
	private Long seqQcId;

	// Constructors

	/** default constructor */
	public SciQcDocs() {
	}

	/** minimal constructor */
	public SciQcDocs(Long seqQcDocId) {
		this.seqQcDocId = seqQcDocId;
	}

	/** full constructor */
	public SciQcDocs(Long seqQcDocId, String originalFile,
			byte[] dataFile, String docCnttype, String docVersion,
			String updatedBy, Date updatedDt, Long seqQcId) {
		this.seqQcDocId = seqQcDocId;
		this.originalFile = originalFile;
		this.dataFile = dataFile;
		this.docCnttype = docCnttype;
		this.docVersion = docVersion;
		this.updatedBy = updatedBy;
		this.updatedDt = updatedDt;
		this.seqQcId = seqQcId;
	}

	// Property accessors
	
	@Id
	@Column(name = "SEQ_QC_DOC_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_QC_DOCS_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_QC_DOCS_SEQ" ,name="SCI_QC_DOCS_SEQ" )

	public Long getSeqQcDocId() {
		return this.seqQcDocId;
	}

	public void setSeqQcDocId(Long seqQcDocId) {
		this.seqQcDocId = seqQcDocId;
	}

	@Column(name = "ORIGINAL_FILE", length = 100)
	public String getOriginalFile() {
		return this.originalFile;
	}

	public void setOriginalFile(String originalFile) {
		this.originalFile = originalFile;
	}

	@Column(name = "DATA_FILE")
	public byte[] getDataFile() {
		return this.dataFile;
	}

	public void setDataFile(byte[] dataFile) {
		this.dataFile = dataFile;
	}

	@Column(name = "DOC_CNTTYPE", length = 100)
	public String getDocCnttype() {
		return this.docCnttype;
	}

	public void setDocCnttype(String docCnttype) {
		this.docCnttype = docCnttype;
	}

	@Column(name = "DOC_VERSION", length = 2)
	public String getDocVersion() {
		return this.docVersion;
	}

	public void setDocVersion(String docVersion) {
		this.docVersion = docVersion;
	}

	@Column(name = "UPDATED_BY", length = 20)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DT", length = 7)
	public Date getUpdatedDt() {
		return this.updatedDt;
	}

	public void setUpdatedDt(Date updatedDt) {
		this.updatedDt = updatedDt;
	}

	@Column(name = "SEQ_QC_ID", precision = 22, scale = 0)
	public Long getSeqQcId() {
		return this.seqQcId;
	}

	public void setSeqQcId(Long seqQcId) {
		this.seqQcId = seqQcId;
	}

}