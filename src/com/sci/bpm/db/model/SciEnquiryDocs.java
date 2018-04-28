package com.sci.bpm.db.model;


import javax.persistence.*;
import java.util.Date;

/**
 * SciJdrDocs entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_ENQUIRY_DOCS", schema = "SCIGENICS")
public class SciEnquiryDocs implements java.io.Serializable {

	// Fields

	private Long seqEnquiryDocId;
	private Long seqEnqId;
	private String enqDocDesc;

	private String enqDocName;
	private String updatedBy;
	private Date updatedDate;
	private String docVersion;
	private String originalDoc;

	private byte[] enqDocData;

	private String docCnttype;
	// Constructors

	/** default constructor */
	public SciEnquiryDocs() {
	}

	/** minimal constructor */
	public SciEnquiryDocs(Long seqEnquiryDocId, Long seqWorkId, String enqDocData,
                          String enqDocName) {
		this.seqEnquiryDocId = seqEnquiryDocId;
		this.seqEnqId = seqWorkId;

		this.enqDocName = enqDocName;


	}

	/** full constructor */
	public SciEnquiryDocs(Long seqEnquiryDocId, Long seqWorkId,
						  String enqDocDesc, String enqDocData, String enqDocName) {
		this.seqEnquiryDocId = seqEnquiryDocId;
		this.seqEnqId = seqWorkId;
		this.enqDocDesc = enqDocDesc;
		
		this.enqDocName = enqDocName;
	}

	// Property accessors
	@Id
	@Column(name = "SEQ_ENQ_DOC_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_ENQUIRY_DOC_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_ENQUIRY_DOC_SEQ" ,name="SCI_ENQUIRY_DOC_SEQ" )
	public Long getSeqEnquiryDocId() {
		return this.seqEnquiryDocId;
	}

	public void setSeqEnquiryDocId(Long seqEnquiryDocId) {
		this.seqEnquiryDocId = seqEnquiryDocId;
	}

	@Column(name = "SEQ_ENQ_ID", nullable = false, precision = 22, scale = 0)
	public Long getSeqEnqId() {
		return this.seqEnqId;
	}

	public void setSeqEnqId(Long seqEnqId) {
		this.seqEnqId = seqEnqId;
	}

	@Column(name = "ENQ_DOC_DESC", length = 100)
	public String getEnqDocDesc() {
		return this.enqDocDesc;
	}

	public void setEnqDocDesc(String enqDocDesc) {
		this.enqDocDesc = enqDocDesc;
	}

	
	
	@Column(name = "ENQ_DOC_NAME", nullable = false, length = 100)
	public String getEnqDocName() {
		return this.enqDocName;
	}

	public void setEnqDocName(String enqDocName) {
		this.enqDocName = enqDocName;
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
	@Lob
	@Column(name = "ENQ_DOC_DATA", nullable = false)
	public byte[] getEnqDocData() {
		return enqDocData;
	}

	public void setEnqDocData(byte[] enqDocData) {
		this.enqDocData = enqDocData;
	}

	@Column(name = "DOC_CNTTYPE", nullable = true, length = 200)
	public String getDocCnttype() {
		return docCnttype;
	}

	public void setDocCnttype(String docCnttype) {
		this.docCnttype = docCnttype;
	}

}