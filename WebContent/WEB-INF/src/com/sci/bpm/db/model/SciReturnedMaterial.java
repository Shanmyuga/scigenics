package com.sci.bpm.db.model;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SciReturnedMaterial entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_RETURNED_MATERIAL", schema = "SCIGENICS")
public class SciReturnedMaterial implements java.io.Serializable {

	// Fields

	private Long seqReturnId;
	private Long seqStissueId;
	private String matcode;
	private String matDimension;
	private String matQty;
	private Date returnDate;
	private Date updatedDt;
	private String updatedBy;
	private String storeApproval;
	private Date storeAppDate;

	// Constructors

	/** default constructor */
	public SciReturnedMaterial() {
	}

	/** minimal constructor */
	public SciReturnedMaterial(Long seqReturnId) {
		this.seqReturnId = seqReturnId;
	}

	/** full constructor */
	public SciReturnedMaterial(Long seqReturnId, Long seqStissueId,
			String matcode, String matDimension, String matQty,
			Date returnDate, Date updatedDt, String updatedBy,
			String storeApproval, Date storeAppDate) {
		this.seqReturnId = seqReturnId;
		this.seqStissueId = seqStissueId;
		this.matcode = matcode;
		this.matDimension = matDimension;
		this.matQty = matQty;
		this.returnDate = returnDate;
		this.updatedDt = updatedDt;
		this.updatedBy = updatedBy;
		this.storeApproval = storeApproval;
		this.storeAppDate = storeAppDate;
	}

	// Property accessors
	@Id
	@Column(name = "SEQ_RETURN_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getSeqReturnId() {
		return this.seqReturnId;
	}

	public void setSeqReturnId(Long seqReturnId) {
		this.seqReturnId = seqReturnId;
	}

	@Column(name = "SEQ_STISSUE_ID", precision = 22, scale = 0)
	public Long getSeqStissueId() {
		return this.seqStissueId;
	}

	public void setSeqStissueId(Long seqStissueId) {
		this.seqStissueId = seqStissueId;
	}

	@Column(name = "MATCODE", length = 20)
	public String getMatcode() {
		return this.matcode;
	}

	public void setMatcode(String matcode) {
		this.matcode = matcode;
	}

	@Column(name = "MAT_DIMENSION", length = 1000)
	public String getMatDimension() {
		return this.matDimension;
	}

	public void setMatDimension(String matDimension) {
		this.matDimension = matDimension;
	}

	@Column(name = "MAT_QTY", length = 20)
	public String getMatQty() {
		return this.matQty;
	}

	public void setMatQty(String matQty) {
		this.matQty = matQty;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "RETURN_DATE", length = 7)
	public Date getReturnDate() {
		return this.returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
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

	@Column(name = "STORE_APPROVAL", length = 1)
	public String getStoreApproval() {
		return this.storeApproval;
	}

	public void setStoreApproval(String storeApproval) {
		this.storeApproval = storeApproval;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "STORE_APP_DATE", length = 7)
	public Date getStoreAppDate() {
		return this.storeAppDate;
	}

	public void setStoreAppDate(Date storeAppDate) {
		this.storeAppDate = storeAppDate;
	}

}