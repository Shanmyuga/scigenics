package com.sci.bpm.db.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * SciStoreissueMaster entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_STOREISSUE_MASTER", schema = "SCIGENICS")
public class SciStoreissueMaster implements java.io.Serializable {

	// Fields

	private Long seqStissueId;
	
	private String matcode;
	private BigDecimal issueCnt;
	private String issueDimension;
	private Long seqItemId;
	private Date issueDate;
	private String updatedBy;
	private Date updatedDt;
	private String issuedTo;
	private String issueRemarks;
	private SciStoresRequest strequest;
	private String returnStatus;
	
	private Date returnDate;
	private String issueAcceptance;
	private Date acceptedDate;
	private String acceptedBy;
	private BigDecimal finalCount;
	private float totalReturnQty;
	
	// Constructors

	

	/** default constructor */
	public SciStoreissueMaster() {
	}

	/** minimal constructor */
	public SciStoreissueMaster(Long seqStissueId,  BigDecimal issueCnt,
			String issueDimension, Long seqItemId, Date issueDate,
			String updatedBy, Date updatedDt, String issuedTo) {
		this.seqStissueId = seqStissueId;
		
		this.issueCnt = issueCnt;
		this.issueDimension = issueDimension;
		this.seqItemId = seqItemId;
		this.issueDate = issueDate;
		this.updatedBy = updatedBy;
		this.updatedDt = updatedDt;
		this.issuedTo = issuedTo;
	}

	/** full constructor */
	public SciStoreissueMaster(Long seqStissueId,  BigDecimal issueCnt,
			String issueDimension, Long seqItemId, Date issueDate,
			String updatedBy, Date updatedDt, String issuedTo,
			String issueRemarks) {
		this.seqStissueId = seqStissueId;
		
		this.issueCnt = issueCnt;
		this.issueDimension = issueDimension;
		this.seqItemId = seqItemId;
		this.issueDate = issueDate;
		this.updatedBy = updatedBy;
		this.updatedDt = updatedDt;
		this.issuedTo = issuedTo;
		this.issueRemarks = issueRemarks;
	}

	// Property accessors
	
	@Id
	@Column(name = "SEQ_STISSUE_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_STOREISSUE_MASTER_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_STOREISSUE_MASTER_SEQ" ,name="SCI_STOREISSUE_MASTER_SEQ" )
	public Long getSeqStissueId() {
		return this.seqStissueId;
	}

	public void setSeqStissueId(Long seqStissueId) {
		this.seqStissueId = seqStissueId;
	}

	
	@Column(name = "ISSUE_CNT_MOD", nullable = true, precision = 22, scale = 4)
	public BigDecimal getIssueCnt() {
		return this.issueCnt;
	}

	public void setIssueCnt(BigDecimal issueCnt) {
		this.issueCnt = issueCnt;
	}

	@Column(name = "ISSUE_DIMENSION", nullable = false, length = 200)
	public String getIssueDimension() {
		return this.issueDimension;
	}

	public void setIssueDimension(String issueDimension) {
		this.issueDimension = issueDimension;
	}

	@Column(name = "SEQ_ITEM_ID", nullable = true, precision = 22, scale = 0)
	public Long getSeqItemId() {
		return this.seqItemId;
	}

	public void setSeqItemId(Long seqItemId) {
		this.seqItemId = seqItemId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ISSUE_DATE", nullable = false, length = 7)
	public Date getIssueDate() {
		return this.issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	@Column(name = "UPDATED_BY", nullable = false, length = 20)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DT", nullable = false, length = 7)
	public Date getUpdatedDt() {
		return this.updatedDt;
	}

	public void setUpdatedDt(Date updatedDt) {
		this.updatedDt = updatedDt;
	}

	@Column(name = "ISSUED_TO", nullable = false, length = 100)
	public String getIssuedTo() {
		return this.issuedTo;
	}

	public void setIssuedTo(String issuedTo) {
		this.issuedTo = issuedTo;
	}

	@Column(name = "ISSUE_REMARKS", length = 100)
	public String getIssueRemarks() {
		return this.issueRemarks;
	}

	public void setIssueRemarks(String issueRemarks) {
		this.issueRemarks = issueRemarks;
	}
	
	@Column(name = "RETURN_STATUS", nullable = true, length=1)
	public String getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "RETURN_DATE", nullable = true, length = 7)
	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	@Column(name = "MATCODE", nullable = true, length=20)
	public String getMatcode() {
		return matcode;
	}

	public void setMatcode(String matcode) {
		this.matcode = matcode;
	}
	
	private String matType = null;
	private String matSpec = null;
	@Column(name = "MAT_TYPE", unique = false, nullable = true, insertable = true, updatable = true, length=1000)
	public String getMatType() {
		return this.matType;
	}

	public void setMatType(String matType) {
		this.matType = matType;
	}

	@Column(name = "MAT_SPEC", unique = false, nullable = true, insertable = true, updatable = true, length = 1000)
	public String getMatSpec() {
		return this.matSpec;
	}

	public void setMatSpec(String matSpec) {
		this.matSpec = matSpec;
	}
private String insertedBy;
	
	private Date insertedDate;
	@Column(name = "INSERTED_BY", length = 20)
	public String getInsertedBy() {
		return insertedBy;
	}

	public void setInsertedBy(String insertedBy) {
		this.insertedBy = insertedBy;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "INSERTED_DATE", nullable = true, length = 7)
	public Date getInsertedDate() {
		return insertedDate;
	}

	public void setInsertedDate(Date insertedDate) {
		this.insertedDate = insertedDate;
	}

private SciMatindMaster sciMiMaster;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SEQ_MI_ID")
		public SciMatindMaster getSciMiMaster() {
		return sciMiMaster;
	}

	public void setSciMiMaster(SciMatindMaster sciMiMaster) {
		this.sciMiMaster = sciMiMaster;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SEQ_STREQ_ID")
	public SciStoresRequest getStrequest() {
		return strequest;
	}

	public void setStrequest(SciStoresRequest strequest) {
		this.strequest = strequest;
	}

	@Column(name = "ISSUE_ACCEPTANCE", length = 1)
	public String getIssueAcceptance() {
		return issueAcceptance;
	}

	public void setIssueAcceptance(String issueAcceptance) {
		this.issueAcceptance = issueAcceptance;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ACCEPTED_DATE", nullable = true, length = 7)
	public Date getAcceptedDate() {
		return acceptedDate;
	}

	public void setAcceptedDate(Date acceptedDate) {
		this.acceptedDate = acceptedDate;
	}

	@Column(name = "ACCEPTED_BY", length = 50)
	public String getAcceptedBy() {
		return acceptedBy;
	}

	public void setAcceptedBy(String acceptedBy) {
		this.acceptedBy = acceptedBy;
	}
	
	@Transient
	public BigDecimal getFinalCount() {
		return finalCount;
	}

	public void setFinalCount(BigDecimal finalCount) {
		this.finalCount = finalCount;
	}
	@Transient
	public float getTotalReturnQty() {
		return totalReturnQty;
	}

	public void setTotalReturnQty(float totalReturnQty) {
		this.totalReturnQty = totalReturnQty;
	}
	
	
}