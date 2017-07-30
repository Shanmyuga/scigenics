package com.sci.bpm.db.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * SciProjectPhases entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_PROJECT_PHASES", schema = "SCIGENICS", uniqueConstraints = @UniqueConstraint(columnNames = {
		"SUB_PHASE_NAME", "SUB_PHASE_ORDER", "PHASE_NAME" }))
public class SciProjectPhases implements java.io.Serializable {

	// Fields

	private Long seqPhaseId;
	private String phaseName;
	private String subPhaseName;
	private Short subPhaseOrder;
	private Long phaseOrder;

	// Constructors

	/** default constructor */
	public SciProjectPhases() {
	}

	/** minimal constructor */
	public SciProjectPhases(Long seqPhaseId, String phaseName,
			Short subPhaseOrder, Long phaseOrder) {
		this.seqPhaseId = seqPhaseId;
		this.phaseName = phaseName;
		this.subPhaseOrder = subPhaseOrder;
		this.phaseOrder = phaseOrder;
	}

	/** full constructor */
	public SciProjectPhases(Long seqPhaseId, String phaseName,
			String subPhaseName, Short subPhaseOrder, Long phaseOrder) {
		this.seqPhaseId = seqPhaseId;
		this.phaseName = phaseName;
		this.subPhaseName = subPhaseName;
		this.subPhaseOrder = subPhaseOrder;
		this.phaseOrder = phaseOrder;
	}

	// Property accessors
	@Id
	@Column(name = "SEQ_PHASE_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getSeqPhaseId() {
		return this.seqPhaseId;
	}

	public void setSeqPhaseId(Long seqPhaseId) {
		this.seqPhaseId = seqPhaseId;
	}

	@Column(name = "PHASE_NAME", nullable = false, length = 100)
	public String getPhaseName() {
		return this.phaseName;
	}

	public void setPhaseName(String phaseName) {
		this.phaseName = phaseName;
	}

	@Column(name = "SUB_PHASE_NAME", length = 100)
	public String getSubPhaseName() {
		return this.subPhaseName;
	}

	public void setSubPhaseName(String subPhaseName) {
		this.subPhaseName = subPhaseName;
	}

	@Column(name = "SUB_PHASE_ORDER", nullable = false, precision = 3, scale = 0)
	public Short getSubPhaseOrder() {
		return this.subPhaseOrder;
	}

	public void setSubPhaseOrder(Short subPhaseOrder) {
		this.subPhaseOrder = subPhaseOrder;
	}

	@Column(name = "PHASE_ORDER", nullable = false, precision = 22, scale = 0)
	public Long getPhaseOrder() {
		return this.phaseOrder;
	}

	public void setPhaseOrder(Long phaseOrder) {
		this.phaseOrder = phaseOrder;
	}

}