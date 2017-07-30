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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SciWoTrackMaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_WO_TRACK_MASTER", schema = "SCIGENICS")
public class SciWoTrackMaster implements java.io.Serializable {

	// Fields

	private Long seqWoTrkId;
	private SciWorkorderMaster sciWorkorderMaster;
	private String phaseDetail;
	private Date estStdate;
	private Date estEnddate;
	private Date actualStdate;
	private Date actualEnddate;
	private Long phaseOrder;
	private String insertedBy;
	private Date insertedDate;
	private String updatedBy;
	private Date updatedDate;
	private Set<SciWoTrkDetail> sciWoTrkDetails = new HashSet<SciWoTrkDetail>(0);
	
	private Long estManhours;

	private String phaseDesc;
	private Long actManhours;
	// Constructors

	/** default constructor */
	public SciWoTrackMaster() {
	}

	/** minimal constructor */
	public SciWoTrackMaster(Long seqWoTrkId,
			SciWorkorderMaster sciWorkorderMaster, String phaseDetail,
			String insertedBy, Date insertedDate, String updatedBy,
			Date updatedDate) {
		this.seqWoTrkId = seqWoTrkId;
		this.sciWorkorderMaster = sciWorkorderMaster;
		this.phaseDetail = phaseDetail;
		this.insertedBy = insertedBy;
		this.insertedDate = insertedDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	/** full constructor */
	public SciWoTrackMaster(Long seqWoTrkId,
			SciWorkorderMaster sciWorkorderMaster, String phaseDetail,
			Date estStdate, Date estEnddate, Date actualStdate,
			Date actualEnddate, Long phaseOrder, String insertedBy,
			Date insertedDate, String updatedBy, Date updatedDate) {
		this.seqWoTrkId = seqWoTrkId;
		this.sciWorkorderMaster = sciWorkorderMaster;
		this.phaseDetail = phaseDetail;
		this.estStdate = estStdate;
		this.estEnddate = estEnddate;
		this.actualStdate = actualStdate;
		this.actualEnddate = actualEnddate;
		this.phaseOrder = phaseOrder;
		this.insertedBy = insertedBy;
		this.insertedDate = insertedDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	// Property accessors
	
	
	@Id
	@Column(name = "SEQ_WO_TRK_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_WO_TRK_MASTER_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_WO_TRK_MASTER_SEQ" ,name="SCI_WO_TRK_MASTER_SEQ" )
	public Long getSeqWoTrkId() {
		return this.seqWoTrkId;
	}

	public void setSeqWoTrkId(Long seqWoTrkId) {
		this.seqWoTrkId = seqWoTrkId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SEQ_WORK_ID", nullable = false)
	public SciWorkorderMaster getSciWorkorderMaster() {
		return this.sciWorkorderMaster;
	}

	public void setSciWorkorderMaster(SciWorkorderMaster sciWorkorderMaster) {
		this.sciWorkorderMaster = sciWorkorderMaster;
	}

	@Column(name = "PHASE_DETAIL", nullable = false, length = 200)
	public String getPhaseDetail() {
		return this.phaseDetail;
	}

	public void setPhaseDetail(String phaseDetail) {
		this.phaseDetail = phaseDetail;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "EST_STDATE", length = 7)
	public Date getEstStdate() {
		return this.estStdate;
	}

	public void setEstStdate(Date estStdate) {
		this.estStdate = estStdate;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "EST_ENDDATE", length = 7)
	public Date getEstEnddate() {
		return this.estEnddate;
	}

	public void setEstEnddate(Date estEnddate) {
		this.estEnddate = estEnddate;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "ACTUAL_STDATE", length = 7)
	public Date getActualStdate() {
		return this.actualStdate;
	}

	public void setActualStdate(Date actualStdate) {
		this.actualStdate = actualStdate;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "ACTUAL_ENDDATE", length = 7)
	public Date getActualEnddate() {
		return this.actualEnddate;
	}

	public void setActualEnddate(Date actualEnddate) {
		this.actualEnddate = actualEnddate;
	}

	@Column(name = "PHASE_ORDER", precision = 22, scale = 0)
	public Long getPhaseOrder() {
		return this.phaseOrder;
	}

	public void setPhaseOrder(Long phaseOrder) {
		this.phaseOrder = phaseOrder;
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
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "sciWoTrackMaster")
	public Set<SciWoTrkDetail> getSciWoTrkDetails() {
		return this.sciWoTrkDetails;
	}

	public void setSciWoTrkDetails(Set<SciWoTrkDetail> sciWoTrkDetails) {
		this.sciWoTrkDetails = sciWoTrkDetails;
	}
	
	public void addWoProjDetail(SciWoTrkDetail details) {
		this.sciWoTrkDetails.add(details);
	}
	@Column(name = "EST_MAN_HOURS",nullable=true, precision = 10, scale = 0)
	public Long getEstManhours() {
		return estManhours;
	}

	public void setEstManhours(Long estManhours) {
		this.estManhours = estManhours;
	}
	@Column(name = "PHASE_DESC", nullable = false, length = 200)
	public String getPhaseDesc() {
		return phaseDesc;
	}

	public void setPhaseDesc(String phaseDesc) {
		this.phaseDesc = phaseDesc;
	}
	@Column(name = "ACT_MAN_HOURS",nullable=true, precision = 10, scale = 0)
	public Long getActManhours() {
		return actManhours;
	}

	public void setActManhours(Long actManhours) {
		this.actManhours = actManhours;
	}
}