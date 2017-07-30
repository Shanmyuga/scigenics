package com.sci.bpm.db.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SciIssueMaster entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_ISSUE_MASTER", schema = "SCIGENICS", uniqueConstraints = {})
public class SciIssueMaster implements java.io.Serializable {

	// Fields

	private Long seqIssueId;
	private String issueStatus;
	private Date issueOpenDate;
	private Date issueCloseDate;
	private String issueCreatedBy;
	private String updatedBy;
	private Date updatedDate;
	private String issueAssignedTo;
	
	private Set<SciIssueDetails> sciIssueDetailses = new HashSet<SciIssueDetails>(
			0);

	// Constructors

	/** default constructor */
	public SciIssueMaster() {
	}

	/** minimal constructor */
	public SciIssueMaster(Long seqIssueId) {
		this.seqIssueId = seqIssueId;
	}

	/** full constructor */
	public SciIssueMaster(Long seqIssueId, String issueStatus,
			Date issueOpenDate, Date issueCloseDate, String issueCreatedBy,
			String updatedBy, Date updatedDate,
			Set<SciIssueDetails> sciIssueDetailses) {
		this.seqIssueId = seqIssueId;
		this.issueStatus = issueStatus;
		this.issueOpenDate = issueOpenDate;
		this.issueCloseDate = issueCloseDate;
		this.issueCreatedBy = issueCreatedBy;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.sciIssueDetailses = sciIssueDetailses;
	}

	// Property accessors
	@Id
	@Column(name = "SEQ_ISSUE_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_ISSUE_MASTER_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_ISSUE_MASTER_SEQ" ,name="SCI_ISSUE_MASTER_SEQ" )
	public Long getSeqIssueId() {
		return this.seqIssueId;
	}

	public void setSeqIssueId(Long seqIssueId) {
		this.seqIssueId = seqIssueId;
	}

	
	@Column(name = "ISSUE_ASSIGNEDTO", unique = false, nullable = false, insertable = true, updatable = true, length = 500)
	public String getIssueAssignedTo() {
		return issueAssignedTo;
	}

	public void setIssueAssignedTo(String issueAssignedTo) {
		this.issueAssignedTo = issueAssignedTo;
	}

	@Column(name = "ISSUE_STATUS", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public String getIssueStatus() {
		return this.issueStatus;
	}

	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ISSUE_OPEN_DATE", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	public Date getIssueOpenDate() {
		return this.issueOpenDate;
	}

	public void setIssueOpenDate(Date issueOpenDate) {
		this.issueOpenDate = issueOpenDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ISSUE_CLOSE_DATE", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	public Date getIssueCloseDate() {
		return this.issueCloseDate;
	}

	public void setIssueCloseDate(Date issueCloseDate) {
		this.issueCloseDate = issueCloseDate;
	}

	@Column(name = "ISSUE_CREATED_BY", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public String getIssueCreatedBy() {
		return this.issueCreatedBy;
	}

	public void setIssueCreatedBy(String issueCreatedBy) {
		this.issueCreatedBy = issueCreatedBy;
	}

	@Column(name = "UPDATED_BY", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy = "sciIssueMaster")
	public Set<SciIssueDetails> getSciIssueDetailses() {
		return this.sciIssueDetailses;
	}

	public void setSciIssueDetailses(Set<SciIssueDetails> sciIssueDetailses) {
		this.sciIssueDetailses = sciIssueDetailses;
	}

	public void addIssueDetails(SciIssueDetails details) {
		details.setSciIssueMaster(this);
		
		this.sciIssueDetailses.add(details);
	}
}