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
 * SciAmendmentMaster entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_AMENDMENT_MASTER", schema = "SCIGENICS")
public class SciAmendmentMaster implements java.io.Serializable {

	// Fields

	private Long seqAmendId;
	private SciWorkorderMaster sciWorkorderMaster;
	private String amendDetails;
	private String updatedBy;
	private Date updatedDt;

	// Constructors

	/** default constructor */
	public SciAmendmentMaster() {
	}

	/** minimal constructor */
	public SciAmendmentMaster(Long seqAmendId, String updatedBy, Date updatedDt) {
		this.seqAmendId = seqAmendId;
		this.updatedBy = updatedBy;
		this.updatedDt = updatedDt;
	}

	/** full constructor */
	public SciAmendmentMaster(Long seqAmendId,
			SciWorkorderMaster sciWorkorderMaster, String amendDetails,
			String updatedBy, Date updatedDt) {
		this.seqAmendId = seqAmendId;
		this.sciWorkorderMaster = sciWorkorderMaster;
		this.amendDetails = amendDetails;
		this.updatedBy = updatedBy;
		this.updatedDt = updatedDt;
	}

	// Property accessors
	
	@Id
	@Column(name = "SEQ_AMEND_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_AMENDMENT_MASTER_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_AMENDMENT_MASTER_SEQ" ,name="SCI_AMENDMENT_MASTER_SEQ" )
	public Long getSeqAmendId() {
		return this.seqAmendId;
	}

	public void setSeqAmendId(Long seqAmendId) {
		this.seqAmendId = seqAmendId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SEQ_WORK_ID")
	public SciWorkorderMaster getSciWorkorderMaster() {
		return this.sciWorkorderMaster;
	}

	public void setSciWorkorderMaster(SciWorkorderMaster sciWorkorderMaster) {
		this.sciWorkorderMaster = sciWorkorderMaster;
	}

	@Column(name = "AMEND_DETAILS", length = 2000)
	public String getAmendDetails() {
		return this.amendDetails;
	}

	public void setAmendDetails(String amendDetails) {
		this.amendDetails = amendDetails;
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

}