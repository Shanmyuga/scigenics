package com.sci.bpm.db.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SciWorkAmendments entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_WORK_AMENDMENTS", schema = "SCIGENICS", uniqueConstraints = {})
public class SciWorkAmendments implements java.io.Serializable {

	// Fields

	private Long seqAmendId;
	private SciWorkorderMaster sciWorkorderMaster;
	private String amendDetails;
	private Date amendDate;
	private String updatedBy;
	private Date updatedDate;

	// Constructors

	/** default constructor */
	public SciWorkAmendments() {
	}

	/** minimal constructor */
	public SciWorkAmendments(Long seqAmendId) {
		this.seqAmendId = seqAmendId;
	}

	/** full constructor */
	public SciWorkAmendments(Long seqAmendId,
			SciWorkorderMaster sciWorkorderMaster, String amendDetails,
			Date amendDate, String updatedBy, Date updatedDate) {
		this.seqAmendId = seqAmendId;
		this.sciWorkorderMaster = sciWorkorderMaster;
		this.amendDetails = amendDetails;
		this.amendDate = amendDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	// Property accessors
	@Id
	@Column(name = "SEQ_AMEND_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	public Long getSeqAmendId() {
		return this.seqAmendId;
	}

	public void setSeqAmendId(Long seqAmendId) {
		this.seqAmendId = seqAmendId;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "SEQ_WORK_ID", unique = false, nullable = true, insertable = true, updatable = true)
	public SciWorkorderMaster getSciWorkorderMaster() {
		return this.sciWorkorderMaster;
	}

	public void setSciWorkorderMaster(SciWorkorderMaster sciWorkorderMaster) {
		this.sciWorkorderMaster = sciWorkorderMaster;
	}

	@Column(name = "AMEND_DETAILS", unique = false, nullable = true, insertable = true, updatable = true, length = 4000)
	public String getAmendDetails() {
		return this.amendDetails;
	}

	public void setAmendDetails(String amendDetails) {
		this.amendDetails = amendDetails;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AMEND_DATE", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	public Date getAmendDate() {
		return this.amendDate;
	}

	public void setAmendDate(Date amendDate) {
		this.amendDate = amendDate;
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

}