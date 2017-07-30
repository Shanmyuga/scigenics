package com.sci.bpm.db.model;

import java.util.Date;
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
 * SciStoresRequest entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_STORES_REQUEST", schema = "SCIGENICS")
public class SciStoresRequest implements java.io.Serializable {

	// Fields

	private Long seqStreqId;
	
	private String matcode;
	private String reqQuantity;
	private String reqDimension;
	private String prodApproval;
	private String purchApproval;
	private String updatedBy;
	private Date reqDate;
	private Date updatedDt;
	private String prodRemarks;
	private String purhRemarks;
	private String prodAppBy;
	private String purchApprBy;
	private String requestStatus;
	private Set<SciStoreissueMaster> sciStoreIssueSet;
	private String requestBy;
	// Constructors

	/** default constructor */
	public SciStoresRequest() {
	}

	/** minimal constructor */
	public SciStoresRequest(Long seqStreqId, 
			String matcode, String updatedBy, Date reqDate, Date updatedDt) {
		this.seqStreqId = seqStreqId;
		
		this.matcode = matcode;
		this.updatedBy = updatedBy;
		this.reqDate = reqDate;
		this.updatedDt = updatedDt;
	}

	/** full constructor */
	public SciStoresRequest(Long seqStreqId, 
			String matcode, String reqQuantity, String reqDimension,
			String prodApproval, String purchApproval, String updatedBy,
			Date reqDate, Date updatedDt, String prodRemarks,
			String purhRemarks, String prodAppBy, String purchApprBy) {
		this.seqStreqId = seqStreqId;
		
		this.matcode = matcode;
		this.reqQuantity = reqQuantity;
		this.reqDimension = reqDimension;
		this.prodApproval = prodApproval;
		this.purchApproval = purchApproval;
		this.updatedBy = updatedBy;
		this.reqDate = reqDate;
		this.updatedDt = updatedDt;
		this.prodRemarks = prodRemarks;
		this.purhRemarks = purhRemarks;
		this.prodAppBy = prodAppBy;
		this.purchApprBy = purchApprBy;
	}

	// Property accessors
	@Id
	@Column(name = "SEQ_STREQ_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_STORES_REQUEST_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_STORES_REQUEST_SEQ" ,name="SCI_STORES_REQUEST_SEQ" )
	public Long getSeqStreqId() {
		return this.seqStreqId;
	}

	public void setSeqStreqId(Long seqStreqId) {
		this.seqStreqId = seqStreqId;
	}

	
	@Column(name = "MATCODE", nullable = false, length = 20)
	public String getMatcode() {
		return this.matcode;
	}

	public void setMatcode(String matcode) {
		this.matcode = matcode;
	}

	@Column(name = "REQ_QUANTITY", length = 20)
	public String getReqQuantity() {
		return this.reqQuantity;
	}

	public void setReqQuantity(String reqQuantity) {
		this.reqQuantity = reqQuantity;
	}

	@Column(name = "REQ_DIMENSION", length = 100)
	public String getReqDimension() {
		return this.reqDimension;
	}

	public void setReqDimension(String reqDimension) {
		this.reqDimension = reqDimension;
	}

	@Column(name = "PROD_APPROVAL", length = 1)
	public String getProdApproval() {
		return this.prodApproval;
	}

	public void setProdApproval(String prodApproval) {
		this.prodApproval = prodApproval;
	}

	@Column(name = "PURCH_APPROVAL", length = 1)
	public String getPurchApproval() {
		return this.purchApproval;
	}

	public void setPurchApproval(String purchApproval) {
		this.purchApproval = purchApproval;
	}

	@Column(name = "UPDATED_BY", nullable = false, length = 20)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "REQ_DATE", nullable = false, length = 7)
	public Date getReqDate() {
		return this.reqDate;
	}

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DT", nullable = false, length = 7)
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

	@Column(name = "PURH_REMARKS", length = 1000)
	public String getPurhRemarks() {
		return this.purhRemarks;
	}

	public void setPurhRemarks(String purhRemarks) {
		this.purhRemarks = purhRemarks;
	}

	@Column(name = "PROD_APP_BY", length = 20)
	public String getProdAppBy() {
		return this.prodAppBy;
	}

	public void setProdAppBy(String prodAppBy) {
		this.prodAppBy = prodAppBy;
	}

	@Column(name = "PURCH_APPR_BY", length = 20)
	public String getPurchApprBy() {
		return this.purchApprBy;
	}

	public void setPurchApprBy(String purchApprBy) {
		this.purchApprBy = purchApprBy;
	}
	@Column(name = "REQUEST_STATUS", length = 1)
	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	@Column(name = "REQUEST_BY", length = 20)
	public String getRequestBy() {
		return requestBy;
	}

	public void setRequestBy(String requestBy) {
		this.requestBy = requestBy;
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

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy = "strequest")
	public Set<SciStoreissueMaster> getSciStoreIssueSet() {
		return sciStoreIssueSet;
	}

	public void setSciStoreIssueSet(Set sciStoreIssueSet) {
		this.sciStoreIssueSet = sciStoreIssueSet;
	}
	
	
	
}