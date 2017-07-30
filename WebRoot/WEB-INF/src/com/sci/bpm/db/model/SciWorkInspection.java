package com.sci.bpm.db.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * SciWorkInspection entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_WORK_INSPECTION", schema = "SCIGENICS")
public class SciWorkInspection implements java.io.Serializable {

	// Fields

	private SciWorkInspectionId id;
	private SciWorkorderMaster sciWorkorderMaster;

	// Constructors

	/** default constructor */
	public SciWorkInspection() {
	}

	/** minimal constructor */
	public SciWorkInspection(SciWorkInspectionId id) {
		this.id = id;
	}

	/** full constructor */
	public SciWorkInspection(SciWorkInspectionId id,
			SciWorkorderMaster sciWorkorderMaster) {
		this.id = id;
		this.sciWorkorderMaster = sciWorkorderMaster;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "seqWorkId", column = @Column(name = "SEQ_WORK_ID", unique = false, nullable = true, insertable = true, updatable = true, precision = 22, scale = 0)),
			@AttributeOverride(name = "inspectionLovId", column = @Column(name = "INSPECTION_LOV_ID", unique = false, nullable = true, insertable = true, updatable = true, precision = 22, scale = 0)) })
	public SciWorkInspectionId getId() {
		return this.id;
	}

	public void setId(SciWorkInspectionId id) {
		this.id = id;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "SEQ_WORK_ID", unique = false, nullable = true, insertable = false, updatable = false)
	public SciWorkorderMaster getSciWorkorderMaster() {
		return this.sciWorkorderMaster;
	}

	public void setSciWorkorderMaster(SciWorkorderMaster sciWorkorderMaster) {
		this.sciWorkorderMaster = sciWorkorderMaster;
	}

}