package com.sci.bpm.db.model;

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

/**
 * SciSubcontJobstatus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_SUBCONT_JOBSTATUS", schema = "SCIGENICS")
public class SciSubcontJobstatus implements java.io.Serializable {

	// Fields

	private Long seqScjobId;
	private String jobType;
	private Long jobCode;
	private String status;
	private SciVendorMaster sciVendorMaster;
	private Date sentDate;
	private Date receivedDate;
	private Date estimatedReturnDate;
	private String remarksColumn;
	private Date insertedDate;
	private String insertedBy;
	private String updatedBy;
	private Date updatedDate;
	private Date offLoadingDate;
	private Long seqWorkId;
	private SciWorkorderMaster sciWorkorderMaster;
	
	private Integer noOfDays;
	private String operationStatus;
	private Long operation;
	
	private Double quantity;
	
	private String moc;
	// Constructors

	/** default constructor */
	public SciSubcontJobstatus() {
	}

	/** minimal constructor */
	public SciSubcontJobstatus(Long seqScjobId, String jobType,
			Long jobCode, String status, String seqVendorId,
			Date insertedDate, String insertedBy, String updatedBy,
			Date updatedDate, Long seqWorkId) {
		this.seqScjobId = seqScjobId;
		this.jobType = jobType;
		this.jobCode = jobCode;
		this.status = status;
		
		this.insertedDate = insertedDate;
		this.insertedBy = insertedBy;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.seqWorkId = seqWorkId;
	}

	/** full constructor */
	public SciSubcontJobstatus(Long seqScjobId, String jobType,
			Long jobCode, String status, String seqVendorId,
			Date sentDate, Date receivedDate,
			Date estimatedReturnDate, String remarksColumn,
			Date insertedDate, String insertedBy, String updatedBy,
			Date updatedDate, Long seqWorkId) {
		this.seqScjobId = seqScjobId;
		this.jobType = jobType;
		this.jobCode = jobCode;
		this.status = status;
		
		this.sentDate = sentDate;
		this.receivedDate = receivedDate;
		this.estimatedReturnDate = estimatedReturnDate;
		this.remarksColumn = remarksColumn;
		this.insertedDate = insertedDate;
		this.insertedBy = insertedBy;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.seqWorkId = seqWorkId;
	}

	// Property accessors
	@Id
	@Column(name = "SEQ_SCJOB_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_SUBCONT_JOB_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_SUBCONT_JOB_SEQ" ,name="SCI_SUBCONT_JOB_SEQ" )
	
	public Long getSeqScjobId() {
		return this.seqScjobId;
	}

	public void setSeqScjobId(Long seqScjobId) {
		this.seqScjobId = seqScjobId;
	}

	@Column(name = "JOB_TYPE", nullable = false, length = 20)
	public String getJobType() {
		return this.jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	@Column(name = "JOB_CODE", nullable = false, precision = 0)
	public Long getJobCode() {
		return this.jobCode;
	}

	public void setJobCode(Long jobCode) {
		this.jobCode = jobCode;
	}

	@Column(name = "STATUS", nullable = false, length = 20)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.EAGER)
	@JoinColumn(name = "SEQ_VENDOR_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public SciVendorMaster getSciVendorMaster() {
		return sciVendorMaster;
	}

	public void setSciVendorMaster(SciVendorMaster sciVendorMaster) {
		this.sciVendorMaster = sciVendorMaster;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "SENT_DATE", length = 7)
	public Date getSentDate() {
		return this.sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "RECEIVED_DATE", length = 7)
	public Date getReceivedDate() {
		return this.receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "ESTIMATED_RETURN_DATE", length = 7)
	public Date getEstimatedReturnDate() {
		return this.estimatedReturnDate;
	}

	public void setEstimatedReturnDate(Date estimatedReturnDate) {
		this.estimatedReturnDate = estimatedReturnDate;
	}

	@Column(name = "REMARKS_COLUMN", length = 200)
	public String getRemarksColumn() {
		return this.remarksColumn;
	}

	public void setRemarksColumn(String remarksColumn) {
		this.remarksColumn = remarksColumn;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "INSERTED_DATE", nullable = false, length = 7)
	public Date getInsertedDate() {
		return this.insertedDate;
	}

	public void setInsertedDate(Date insertedDate) {
		this.insertedDate = insertedDate;
	}

	@Column(name = "INSERTED_BY", nullable = false, length = 20)
	public String getInsertedBy() {
		return this.insertedBy;
	}

	public void setInsertedBy(String insertedBy) {
		this.insertedBy = insertedBy;
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

	@ManyToOne(cascade = {}, fetch = FetchType.EAGER)
	@JoinColumn(name = "SEQ_WORK_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public SciWorkorderMaster getSciWorkorderMaster() {
		return this.sciWorkorderMaster;
	}

	public void setSciWorkorderMaster(SciWorkorderMaster sciWorkorderMaster) {
		this.sciWorkorderMaster = sciWorkorderMaster;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "OFFLOADING_DATE", length = 7)
	public Date getOffLoadingDate() {
		return offLoadingDate;
	}

	public void setOffLoadingDate(Date offLoadingDate) {
		this.offLoadingDate = offLoadingDate;
	}
	@Column(name = "QUANTITY", nullable = true, precision = 10,scale=2)
	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	@Column(name = "MAT_CODE", nullable = true, length = 20)
	public String getMoc() {
		return moc;
	}

	public void setMoc(String moc) {
		this.moc = moc;
	}
	
	@Column(name = "NO_OF_DAYS", nullable = false, precision = 5, scale = 0)
	public Integer getNoOfDays() {
		return this.noOfDays;
	}

	public void setNoOfDays(Integer noOfDays) {
		this.noOfDays = noOfDays;
	}

	@Column(name = "OPERATION_STATUS", length = 200)
	public String getOperationStatus() {
		return this.operationStatus;
	}

	public void setOperationStatus(String operationStatus) {
		this.operationStatus = operationStatus;
	}

	@Column(name = "OPERATION", precision = 0)
	public Long getOperation() {
		return this.operation;
	}

	public void setOperation(Long operation) {
		this.operation = operation;
	}


}