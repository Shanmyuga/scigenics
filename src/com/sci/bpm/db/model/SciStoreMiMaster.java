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
 * SciStoreMiMaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_STORE_MI_MASTER", schema = "SCIGENICS")
public class SciStoreMiMaster implements java.io.Serializable {

	// Fields

	private Long seqStoremiId;
	
	private String matCode;
	private String recdMatQty;
	private String recdMatDime;
	private String ordQty;
	private String ordDim;
	private Date recdDate;
	private String recdStatus;
	private String issuedStatus;
	private Long poId;
	private String updatedBy;
	private Date updatedDt;
	private String ocStatus;
	private String availableCnt;
	private String availableDim;
	private String remarks;
	private String qcappQty;
	private String qcappdim;
	

	// Constructors

	/** default constructor */
	public SciStoreMiMaster() {
	}

	/** minimal constructor */
	public SciStoreMiMaster(Long seqStoremiId, Long seqMiId,
			String matCode, Date recdDate, String recdStatus,
			String issuedStatus, Long poId, String updatedBy,
			Date updatedDt, String ocStatus, String availableCnt,
			String availableDim) {
		this.seqStoremiId = seqStoremiId;
		
		this.matCode = matCode;
		this.recdDate = recdDate;
		this.recdStatus = recdStatus;
		this.issuedStatus = issuedStatus;
		this.poId = poId;
		this.updatedBy = updatedBy;
		this.updatedDt = updatedDt;
		this.ocStatus = ocStatus;
		this.availableCnt = availableCnt;
		this.availableDim = availableDim;
	}

	/** full constructor */
	public SciStoreMiMaster(Long seqStoremiId, Long seqMiId,
			String matCode, String recdMatQty, String recdMatDime,
			String ordQty, String ordDim, Date recdDate, String recdStatus,
			String issuedStatus, Long poId, String updatedBy,
			Date updatedDt, String ocStatus, String availableCnt,
			String availableDim) {
		this.seqStoremiId = seqStoremiId;
		
		this.matCode = matCode;
		this.recdMatQty = recdMatQty;
		this.recdMatDime = recdMatDime;
		this.ordQty = ordQty;
		this.ordDim = ordDim;
		this.recdDate = recdDate;
		this.recdStatus = recdStatus;
		this.issuedStatus = issuedStatus;
		this.poId = poId;
		this.updatedBy = updatedBy;
		this.updatedDt = updatedDt;
		this.ocStatus = ocStatus;
		this.availableCnt = availableCnt;
		this.availableDim = availableDim;
	}

	// Property accessors
	@Id
	@Column(name = "SEQ_STOREMI_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_STORE_MI_MASTER_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_STORE_MI_MASTER_SEQ" ,name="SCI_STORE_MI_MASTER_SEQ" )
	public Long getSeqStoremiId() {
		return this.seqStoremiId;
	}

	public void setSeqStoremiId(Long seqStoremiId) {
		this.seqStoremiId = seqStoremiId;
	}

	

	@Column(name = "MAT_CODE", nullable = false, length = 20)
	public String getMatCode() {
		return this.matCode;
	}

	public void setMatCode(String matCode) {
		this.matCode = matCode;
	}

	@Column(name = "RECD_MAT_QTY", length = 20)
	public String getRecdMatQty() {
		return this.recdMatQty;
	}

	public void setRecdMatQty(String recdMatQty) {
		this.recdMatQty = recdMatQty;
	}

	@Column(name = "RECD_MAT_DIME", length = 1000)
	public String getRecdMatDime() {
		return this.recdMatDime;
	}

	public void setRecdMatDime(String recdMatDime) {
		this.recdMatDime = recdMatDime;
	}

	@Column(name = "ORD_QTY", length = 20)
	public String getOrdQty() {
		return this.ordQty;
	}

	public void setOrdQty(String ordQty) {
		this.ordQty = ordQty;
	}

	@Column(name = "ORD_DIM", length = 1000)
	public String getOrdDim() {
		return this.ordDim;
	}

	public void setOrdDim(String ordDim) {
		this.ordDim = ordDim;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "RECD_DATE", nullable = false, length = 7)
	public Date getRecdDate() {
		return this.recdDate;
	}

	public void setRecdDate(Date recdDate) {
		this.recdDate = recdDate;
	}

	@Column(name = "RECD_STATUS", nullable = true, length = 1)
	public String getRecdStatus() {
		return this.recdStatus;
	}

	public void setRecdStatus(String recdStatus) {
		this.recdStatus = recdStatus;
	}

	@Column(name = "ISSUED_STATUS", nullable = true, length = 1)
	public String getIssuedStatus() {
		return this.issuedStatus;
	}

	public void setIssuedStatus(String issuedStatus) {
		this.issuedStatus = issuedStatus;
	}

	@Column(name = "PO_ID", nullable = false, precision = 22, scale = 0)
	public Long getPoId() {
		return this.poId;
	}

	public void setPoId(Long poId) {
		this.poId = poId;
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

	@Column(name = "OC_STATUS", nullable = true, length = 1)
	public String getOcStatus() {
		return this.ocStatus;
	}

	public void setOcStatus(String ocStatus) {
		this.ocStatus = ocStatus;
	}

	@Column(name = "AVAILABLE_CNT", nullable = true, length = 20)
	public String getAvailableCnt() {
		return this.availableCnt;
	}

	public void setAvailableCnt(String availableCnt) {
		this.availableCnt = availableCnt;
	}

	@Column(name = "AVAILABLE_DIM", nullable = true, length = 1000)
	public String getAvailableDim() {
		return this.availableDim;
	}

	public void setAvailableDim(String availableDim) {
		this.availableDim = availableDim;
	}
	@Column(name = "REMARKS", nullable = true, length = 1000)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	private String matType = null;
	private String matSpec = null;
	@Column(name = "MAT_TYPE", unique = false, nullable = true, insertable = true, updatable = true, length=1000)
	public String getMatType() {
		return this.matType;
	}

	public void setMatType(String matType) {
		this.matType = matType;
	}

	@Column(name = "MAT_SPEC", unique = false, nullable = true, insertable = true, updatable = true, length = 1000)
	public String getMatSpec() {
		return this.matSpec;
	}

	public void setMatSpec(String matSpec) {
		this.matSpec = matSpec;
	}
	
private String insertedBy;
	
	private Date insertedDate;
	@Column(name = "INSERTED_BY", length = 20)
	public String getInsertedBy() {
		return insertedBy;
	}

	public void setInsertedBy(String insertedBy) {
		this.insertedBy = insertedBy;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "INSERTED_DATE", nullable = true, length = 7)
	public Date getInsertedDate() {
		return insertedDate;
	}

	public void setInsertedDate(Date insertedDate) {
		this.insertedDate = insertedDate;
	}

private SciMatindMaster sciMiMaster;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SEQ_MI_ID")
		public SciMatindMaster getSciMiMaster() {
		return sciMiMaster;
	}

	public void setSciMiMaster(SciMatindMaster sciMiMaster) {
		this.sciMiMaster = sciMiMaster;
	}

	@Transient
	public String getQcappQty() {
		return qcappQty;
	}

	public void setQcappQty(String qcappQty) {
		this.qcappQty = qcappQty;
	}
	@Transient
	public String getQcappdim() {
		return qcappdim;
	}

	public void setQcappdim(String qcappdim) {
		this.qcappdim = qcappdim;
	}
	
	
}