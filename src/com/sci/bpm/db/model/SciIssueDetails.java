package com.sci.bpm.db.model;

import java.util.Date;

import javax.persistence.CascadeType;
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
 * SciIssueDetails entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_ISSUE_DETAILS", schema = "SCIGENICS", uniqueConstraints = {})
public class SciIssueDetails implements java.io.Serializable {

	// Fields

	private Long seqIssueDtlId;
	private SciIssueMaster sciIssueMaster;
	private String issueDetails;
	private String assignedFrom;
	private String assignedTo;
	private Date assignedDate;
	private Date updatedDate;
	private String updatedBy;

	private String issueStatus;
	private String issueSubject;
	// Constructors

	/** default constructor */
	public SciIssueDetails() {
	}

	/** minimal constructor */
	public SciIssueDetails(Long seqIssueDtlId) {
		this.seqIssueDtlId = seqIssueDtlId;
	}

	/** full constructor */
	public SciIssueDetails(Long seqIssueDtlId, SciIssueMaster sciIssueMaster,
			String issueDetails, String assignedFrom, String assignedTo,
			Date assignedDate, Date updatedDate, String updatedBy,String issueStatus,String issueSubject) {
		this.seqIssueDtlId = seqIssueDtlId;
		this.sciIssueMaster = sciIssueMaster;
		this.issueDetails = issueDetails;
		this.assignedFrom = assignedFrom;
		this.assignedTo = assignedTo;
		this.assignedDate = assignedDate;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.issueSubject = issueSubject;
		this.issueStatus = issueStatus;
	}

	// Property accessors
	@Id
	@Column(name = "SEQ_ISSUE_DTL_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_ISSUE_DETAILS_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_ISSUE_DETAILS_SEQ" ,name="SCI_ISSUE_DETAILS_SEQ" )
	public Long getSeqIssueDtlId() {
		return this.seqIssueDtlId;
	}

	public void setSeqIssueDtlId(Long seqIssueDtlId) {
		this.seqIssueDtlId = seqIssueDtlId;
	}

	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "SEQ_ISSUE_ID", unique = false, nullable = false)
	public SciIssueMaster getSciIssueMaster() {
		return this.sciIssueMaster;
	}

	public void setSciIssueMaster(SciIssueMaster sciIssueMaster) {
		this.sciIssueMaster = sciIssueMaster;
	}

	@Column(name = "ISSUE_DETAILS", unique = false, nullable = true, insertable = true, updatable = true, length = 2000)
	public String getIssueDetails() {
		return this.issueDetails;
	}

	public void setIssueDetails(String issueDetails) {
		this.issueDetails = issueDetails;
	}

	@Column(name = "ASSIGNED_FROM", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public String getAssignedFrom() {
		return this.assignedFrom;
	}

	public void setAssignedFrom(String assignedFrom) {
		this.assignedFrom = assignedFrom;
	}

	@Column(name = "ASSIGNED_TO", unique = false, nullable = true, insertable = true, updatable = true, length = 500)
	public String getAssignedTo() {
		return this.assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ASSIGNED_DATE", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	public Date getAssignedDate() {
		return this.assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "UPDATED_BY", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
	@Column(name = "ISSUE_STATUS", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public String getIssueStatus() {
		return this.issueStatus;
	}

	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}

	@Column(name = "ISSUE_SUBJECT", unique = false, nullable = false, insertable = true, updatable = true, length = 200)
	public String getIssueSubject() {
		return this.issueSubject;
	}

	public void setIssueSubject(String issueSubject) {
		this.issueSubject = issueSubject;
	}

}