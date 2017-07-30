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
import javax.persistence.Transient;

/**
 * SciReturnitemsRequest entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_RETURNITEMS_REQUEST", schema = "SCIGENICS")
public class SciReturnitemsRequest implements java.io.Serializable {

	// Fields

	private Long seqRtreqId;
	private SciMatindMaster sciMiMaster;
	private String matcode;
	private String retQuantity;
	private String retDimension;
	private String updatedBy;
	private Date retDate;
	private Date updatedDt;
	private String prodRemarks;
	private String requestStatus;
	private String requestBy;
	private String matType;
	private String matSpec;
	private String insertedBy;
	private Date insertedDate;
	private SciStoreissueMaster stissue;
	private String damagedStatus;
	private String actualReturnQty;
	
	// Constructors

	/** default constructor */
	public SciReturnitemsRequest() {
	}

	/** minimal constructor */
	public SciReturnitemsRequest(Long seqRtreqId) {
		this.seqRtreqId = seqRtreqId;
	}

	/** full constructor */
	public SciReturnitemsRequest(Long seqRtreqId, Long seqMiId,
			String matcode, String retQuantity, String retDimension,
			String updatedBy, Date retDate, Date updatedDt,
			String prodRemarks, String requestStatus, String requestBy,
			String matType, String matSpec, String insertedBy,
			Date insertedDate, Long seqStreqId) {
		this.seqRtreqId = seqRtreqId;
		
		this.matcode = matcode;
		this.retQuantity = retQuantity;
		this.retDimension = retDimension;
		this.updatedBy = updatedBy;
		this.retDate = retDate;
		this.updatedDt = updatedDt;
		this.prodRemarks = prodRemarks;
		this.requestStatus = requestStatus;
		this.requestBy = requestBy;
		this.matType = matType;
		this.matSpec = matSpec;
		this.insertedBy = insertedBy;
		this.insertedDate = insertedDate;
		
	}

	@Id
	@Column(name = "SEQ_RTREQ_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_RETURNITEMS_REQUEST_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_RETURNITEMS_REQUEST_SEQ" ,name="SCI_RETURNITEMS_REQUEST_SEQ" )
	
	public Long getSeqRtreqId() {
		return this.seqRtreqId;
	}

	public void setSeqRtreqId(Long seqRtreqId) {
		this.seqRtreqId = seqRtreqId;
	}

	

	@Column(name = "MATCODE", length = 20)
	public String getMatcode() {
		return this.matcode;
	}

	public void setMatcode(String matcode) {
		this.matcode = matcode;
	}

	@Column(name = "RET_QUANTITY", length = 20)
	public String getRetQuantity() {
		return this.retQuantity;
	}

	public void setRetQuantity(String retQuantity) {
		this.retQuantity = retQuantity;
	}

	@Column(name = "RET_DIMENSION", length = 100)
	public String getRetDimension() {
		return this.retDimension;
	}

	public void setRetDimension(String retDimension) {
		this.retDimension = retDimension;
	}

	@Column(name = "UPDATED_BY", length = 20)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "RET_DATE", length = 7)
	public Date getRetDate() {
		return this.retDate;
	}

	public void setRetDate(Date retDate) {
		this.retDate = retDate;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DT", length = 7)
	public Date getUpdatedDt() {
		return this.updatedDt;
	}

	public void setUpdatedDt(Date updatedDt) {
		this.updatedDt = updatedDt;
	}

	@Column(name = "PROD_REMARKS", length = 1000)
	public String getProdRemarks() {
		return this.prodRemarks;
	}

	public void setProdRemarks(String prodRemarks) {
		this.prodRemarks = prodRemarks;
	}

	@Column(name = "REQUEST_STATUS", length = 1)
	public String getRequestStatus() {
		return this.requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	@Column(name = "REQUEST_BY", length = 20)
	public String getRequestBy() {
		return this.requestBy;
	}

	public void setRequestBy(String requestBy) {
		this.requestBy = requestBy;
	}

	@Column(name = "MAT_TYPE", length = 1000)
	public String getMatType() {
		return this.matType;
	}

	public void setMatType(String matType) {
		this.matType = matType;
	}

	@Column(name = "MAT_SPEC", length = 1000)
	public String getMatSpec() {
		return this.matSpec;
	}

	public void setMatSpec(String matSpec) {
		this.matSpec = matSpec;
	}

	@Column(name = "INSERTED_BY", length = 20)
	public String getInsertedBy() {
		return this.insertedBy;
	}

	public void setInsertedBy(String insertedBy) {
		this.insertedBy = insertedBy;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "INSERTED_DATE", length = 7)
	public Date getInsertedDate() {
		return this.insertedDate;
	}

	public void setInsertedDate(Date insertedDate) {
		this.insertedDate = insertedDate;
	}

	

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SEQ_MI_ID")
		public SciMatindMaster getSciMiMaster() {
		return sciMiMaster;
	}
	

	public void setSciMiMaster(SciMatindMaster sciMiMaster) {
		this.sciMiMaster = sciMiMaster;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SEQ_STISSUE_ID")
	public SciStoreissueMaster getStissue() {
		return stissue;
	}
	
	
	public void setStissue(SciStoreissueMaster stissue) {
		this.stissue = stissue;
	}
	@Column(name = "DAMAGED_STATUS", length = 2)
	public String getDamagedStatus() {
		return damagedStatus;
	}

	public void setDamagedStatus(String damagedStatus) {
		this.damagedStatus = damagedStatus;
	}

	@Transient
	public String getActualReturnQty() {
		float val = this.stissue.getIssueCnt().floatValue()- Float.parseFloat( this.stissue.getStrequest().getReqQuantity());
		if(val < 0) {
			val = 0;
		}
		return String.valueOf(val);
	}

	public void setActualReturnQty(String actualReturnQty) {
		this.actualReturnQty = actualReturnQty;
	}
	
	
}