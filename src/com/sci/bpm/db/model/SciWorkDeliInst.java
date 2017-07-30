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
 * SciWorkDeliInst entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_WORK_DELI_INST", schema = "SCIGENICS")
public class SciWorkDeliInst implements java.io.Serializable {

	// Fields

	private SciWorkDeliInstId id;
	private SciWorkorderMaster sciWorkorderMaster;

	// Constructors

	/** default constructor */
	public SciWorkDeliInst() {
	}

	/** minimal constructor */
	public SciWorkDeliInst(SciWorkDeliInstId id) {
		this.id = id;
	}

	/** full constructor */
	public SciWorkDeliInst(SciWorkDeliInstId id,
			SciWorkorderMaster sciWorkorderMaster) {
		this.id = id;
		this.sciWorkorderMaster = sciWorkorderMaster;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "seqWorkId", column = @Column(name = "SEQ_WORK_ID", unique = false, nullable = true, insertable = true, updatable = true, precision = 22, scale = 0)),
			@AttributeOverride(name = "delLovId", column = @Column(name = "DEL_LOV_ID", unique = false, nullable = true, insertable = true, updatable = true, precision = 22, scale = 0)) })
	public SciWorkDeliInstId getId() {
		return this.id;
	}

	public void setId(SciWorkDeliInstId id) {
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