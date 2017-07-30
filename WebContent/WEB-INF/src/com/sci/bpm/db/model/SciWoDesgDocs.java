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
 * SciWoDesgDocs entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_WO_DESG_DOCS", schema = "SCIGENICS")
public class SciWoDesgDocs implements java.io.Serializable {

	// Fields

	private Long seqWoDdId;
	private SciWorkorderMaster sciWorkorderMaster;
	private SciDesignDocMaster docmaster;
	private Date insertedDate;
	private String insertedBy;
	private Date estCompletionDt;

	// Constructors

	/** default constructor */
	public SciWoDesgDocs() {
	}

	/** minimal constructor */
	public SciWoDesgDocs(Long seqWoDdId,
			SciWorkorderMaster sciWorkorderMaster, Long seqDocId,
			Date insertedDate, String insertedBy) {
		this.seqWoDdId = seqWoDdId;
		this.sciWorkorderMaster = sciWorkorderMaster;
		
		this.insertedDate = insertedDate;
		this.insertedBy = insertedBy;
	}

	/** full constructor */
	public SciWoDesgDocs(Long seqWoDdId,
			SciWorkorderMaster sciWorkorderMaster, Long seqDocId,
			Date insertedDate, String insertedBy, Date estCompletionDt) {
		this.seqWoDdId = seqWoDdId;
		this.sciWorkorderMaster = sciWorkorderMaster;
	
		this.insertedDate = insertedDate;
		this.insertedBy = insertedBy;
		this.estCompletionDt = estCompletionDt;
	}

	@Id
	@Column(name = "SEQ_WO_DD_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_WO_DESDOC_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_WO_DESDOC_SEQ" ,name="SCI_WO_DESDOC_SEQ" )

	
	public Long getSeqWoDdId() {
		return this.seqWoDdId;
	}

	public void setSeqWoDdId(Long seqWoDdId) {
		this.seqWoDdId = seqWoDdId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SEQ_WORK_ID", nullable = false)
	public SciWorkorderMaster getSciWorkorderMaster() {
		return this.sciWorkorderMaster;
	}

	public void setSciWorkorderMaster(SciWorkorderMaster sciWorkorderMaster) {
		this.sciWorkorderMaster = sciWorkorderMaster;
	}

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SEQ_DOC_ID", nullable = false)
	public SciDesignDocMaster getDocmaster() {
		return docmaster;
	}

	public void setDocmaster(SciDesignDocMaster docmaster) {
		this.docmaster = docmaster;
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
	@Temporal(TemporalType.DATE)
	@Column(name = "EST_COMPLETION_DT", length = 7)
	public Date getEstCompletionDt() {
		return this.estCompletionDt;
	}

	public void setEstCompletionDt(Date estCompletionDt) {
		this.estCompletionDt = estCompletionDt;
	}

}