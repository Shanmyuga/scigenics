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
 * SciQcMaster entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_QC_MASTER", schema = "SCIGENICS")
public class SciQcMaster implements java.io.Serializable {

	// Fields

	private Long seqQcId;
	
	private Long itemsPassed;
	private Long itemsFailed;
	private String failureReasons;
	private Date updatedDt;
	private String updatedBy;
	private String qcTests;
	 private Long seqItemId;
	
	// Constructors

	/** default constructor */
	public SciQcMaster() {
	}

	/** minimal constructor */
	public SciQcMaster(Long seqQcId,
			Long itemsPassed) {
		this.seqQcId = seqQcId;
		
		this.itemsPassed = itemsPassed;
	}

	/** full constructor */
	public SciQcMaster(Long seqQcId,
			Long itemsPassed, Long itemsFailed, String failureReasons,
			Date updatedDt, String updatedBy) {
		this.seqQcId = seqQcId;
		
		this.itemsPassed = itemsPassed;
		this.itemsFailed = itemsFailed;
		this.failureReasons = failureReasons;
		this.updatedDt = updatedDt;
		this.updatedBy = updatedBy;
	}

	// Property accessors
	@Id
	@Column(name = "SEQ_QC_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_QC_MASTER_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_QC_MASTER_SEQ" ,name="SCI_QC_MASTER_SEQ" )
	public Long getSeqQcId() {
		return this.seqQcId;
	}

	public void setSeqQcId(Long seqQcId) {
		this.seqQcId = seqQcId;
	}


	@Column(name = "SEQ_ITEM_ID", nullable = false, precision = 22, scale = 0)
	public Long getSeqItemId() {
		return seqItemId;
	}

	public void setSeqItemId(Long seqItemId) {
		this.seqItemId = seqItemId;
	}

	@Column(name = "ITEMS_PASSED", nullable = false, precision = 22, scale = 0)
	public Long getItemsPassed() {
		return this.itemsPassed;
	}

	public void setItemsPassed(Long itemsPassed) {
		this.itemsPassed = itemsPassed;
	}

	@Column(name = "ITEMS_FAILED", precision = 22, scale = 0)
	public Long getItemsFailed() {
		return this.itemsFailed;
	}

	public void setItemsFailed(Long itemsFailed) {
		this.itemsFailed = itemsFailed;
	}

	@Column(name = "FAILURE_REASONS", length = 2000)
	public String getFailureReasons() {
		return this.failureReasons;
	}

	public void setFailureReasons(String failureReasons) {
		this.failureReasons = failureReasons;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DT", length = 7)
	public Date getUpdatedDt() {
		return this.updatedDt;
	}

	public void setUpdatedDt(Date updatedDt) {
		this.updatedDt = updatedDt;
	}

	@Column(name = "UPDATED_BY", length = 20)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	@Column(name = "QC_TESTS", nullable=false, length = 2000)
	public String getQcTests() {
		return qcTests;
	}

	public void setQcTests(String qcTests) {
		this.qcTests = qcTests;
	}
	
}