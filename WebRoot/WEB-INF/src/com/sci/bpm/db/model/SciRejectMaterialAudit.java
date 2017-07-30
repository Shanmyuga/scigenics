package com.sci.bpm.db.model;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SciRejectMaterialAudit entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_REJECT_MATERIAL_AUDIT", schema = "SCIGENICS")
public class SciRejectMaterialAudit implements java.io.Serializable {

	// Fields

	private Long seqRejAdtId;
	private Long seqRejectId;
	private String rejectStatus;
	private Date rejectDate;
	private String insertedBy;
	private Date insertedDate;

	// Constructors

	/** default constructor */
	public SciRejectMaterialAudit() {
	}

	/** full constructor */
	public SciRejectMaterialAudit(Long seqRejAdtId,
			Long seqRejectId, String rejectStatus, Date rejectDate,
			String insertedBy, Date insertedDate) {
		this.seqRejAdtId = seqRejAdtId;
		this.seqRejectId = seqRejectId;
		this.rejectStatus = rejectStatus;
		this.rejectDate = rejectDate;
		this.insertedBy = insertedBy;
		this.insertedDate = insertedDate;
	}

	// Property accessors
	
	@Id
	@Column(name = "SEQ_REJ_ADT_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_REJECT_MAT_AUDIT_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_REJECT_MAT_AUDIT_SEQ" ,name="SCI_REJECT_MAT_AUDIT_SEQ" )
	
	public Long getSeqRejAdtId() {
		return this.seqRejAdtId;
	}

	public void setSeqRejAdtId(Long seqRejAdtId) {
		this.seqRejAdtId = seqRejAdtId;
	}

	@Column(name = "SEQ_REJECT_ID", nullable = false, precision = 22, scale = 0)
	public Long getSeqRejectId() {
		return this.seqRejectId;
	}

	public void setSeqRejectId(Long seqRejectId) {
		this.seqRejectId = seqRejectId;
	}

	@Column(name = "REJECT_STATUS", nullable = false, length = 100)
	public String getRejectStatus() {
		return this.rejectStatus;
	}

	public void setRejectStatus(String rejectStatus) {
		this.rejectStatus = rejectStatus;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "REJECT_DATE", nullable = false, length = 7)
	public Date getRejectDate() {
		return this.rejectDate;
	}

	public void setRejectDate(Date rejectDate) {
		this.rejectDate = rejectDate;
	}

	@Column(name = "INSERTED_BY", nullable = false, length = 20)
	public String getInsertedBy() {
		return this.insertedBy;
	}

	public void setInsertedBy(String insertedBy) {
		this.insertedBy = insertedBy;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "INSERTED_DATE", nullable = false, length = 7)
	public Date getInsertedDate() {
		return this.insertedDate;
	}

	public void setInsertedDate(Date insertedDate) {
		this.insertedDate = insertedDate;
	}

}