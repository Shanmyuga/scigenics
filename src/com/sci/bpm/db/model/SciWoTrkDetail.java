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
 * SciWoTrkDetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_WO_TRK_DETAIL", schema = "SCIGENICS")
public class SciWoTrkDetail implements java.io.Serializable {

	// Fields

	private Long seqTrkDtlId;
	private SciWoTrackMaster sciWoTrackMaster;
	private String subPhaseName;
	private Date subEstStart;
	private Date subEstEnd;
	private Date subActStdate;
	private Date subActEnd;
	private Long subPhaseOrder;
	private Date insertedDate;
	private String insertedBy;
	private String updatedBy;
	private Date updatedDate;
	private Long actManhours;
	private String taskDesc;
	// Constructors

	/** default constructor */
	public SciWoTrkDetail() {
	}

	/** minimal constructor */
	public SciWoTrkDetail(Long seqTrkDtlId, Long seqWoTrkId,
			String subPhaseName, Date insertedDate, String insertedBy,
			String updatedBy, Date updatedDate) {
		this.seqTrkDtlId = seqTrkDtlId;
		
		this.subPhaseName = subPhaseName;
		this.insertedDate = insertedDate;
		this.insertedBy = insertedBy;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	/** full constructor */
	public SciWoTrkDetail(Long seqTrkDtlId, Long seqWoTrkId,
			String subPhaseName, Date subEstStart, Date subEstEnd,
			Date subActStdate, Date subActEnd,
			Long subPhaseOrder, Date insertedDate,
			String insertedBy, String updatedBy, Date updatedDate) {
		this.seqTrkDtlId = seqTrkDtlId;
		
		this.subPhaseName = subPhaseName;
		this.subEstStart = subEstStart;
		this.subEstEnd = subEstEnd;
		this.subActStdate = subActStdate;
		this.subActEnd = subActEnd;
		this.subPhaseOrder = subPhaseOrder;
		this.insertedDate = insertedDate;
		this.insertedBy = insertedBy;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	@Id
	@Column(name = "SEQ_TRK_DTL_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_WO_TRK_DTL_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_WO_TRK_DTL_SEQ" ,name="SCI_WO_TRK_DTL_SEQ" )
	
	public Long getSeqTrkDtlId() {
		return this.seqTrkDtlId;
	}

	public void setSeqTrkDtlId(Long seqTrkDtlId) {
		this.seqTrkDtlId = seqTrkDtlId;
	}


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SEQ_WO_TRK_ID", nullable = false)
	public SciWoTrackMaster getSciWoTrackMaster() {
		return this.sciWoTrackMaster;
	}

	public void setSciWoTrackMaster(SciWoTrackMaster sciWoTrackMaster) {
		this.sciWoTrackMaster = sciWoTrackMaster;
	}


	@Column(name = "SUB_PHASE_NAME", nullable = true, length = 200)
	public String getSubPhaseName() {
		return this.subPhaseName;
	}

	public void setSubPhaseName(String subPhaseName) {
		this.subPhaseName = subPhaseName;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "SUB_EST_START", length = 7)
	public Date getSubEstStart() {
		return this.subEstStart;
	}

	public void setSubEstStart(Date subEstStart) {
		this.subEstStart = subEstStart;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "SUB_EST_END", length = 7)
	public Date getSubEstEnd() {
		return this.subEstEnd;
	}

	public void setSubEstEnd(Date subEstEnd) {
		this.subEstEnd = subEstEnd;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "SUB_ACT_STDATE", length = 7)
	public Date getSubActStdate() {
		return this.subActStdate;
	}

	public void setSubActStdate(Date subActStdate) {
		this.subActStdate = subActStdate;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "SUB_ACT_END", length = 7)
	public Date getSubActEnd() {
		return this.subActEnd;
	}

	public void setSubActEnd(Date subActEnd) {
		this.subActEnd = subActEnd;
	}

	@Column(name = "SUB_PHASE_ORDER", precision = 22, scale = 0)
	public Long getSubPhaseOrder() {
		return this.subPhaseOrder;
	}

	public void setSubPhaseOrder(Long subPhaseOrder) {
		this.subPhaseOrder = subPhaseOrder;
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

	@Column(name = "UPDATED_BY", nullable = false, length = 20)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE", nullable = false, length = 7)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	@Column(name = "ACTUAL_MAN_HOURS",nullable=true, precision = 10, scale = 0)
	public Long getActManhours() {
		return actManhours;
	}

	public void setActManhours(Long actManhours) {
		this.actManhours = actManhours;
	}
	@Column(name = "TASK_DESC", nullable = false, length = 200)
	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

}