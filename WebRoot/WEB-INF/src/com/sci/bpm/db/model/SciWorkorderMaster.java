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
 * SciWorkorderMaster entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_WORKORDER_MASTER", schema = "SCIGENICS", uniqueConstraints = {})
public class SciWorkorderMaster implements java.io.Serializable {

	// Fields

	private Long seqWorkId;
	private String oldWordId;
	private Date workCreateDt;
	private String clientDetails;
	private String deliveryAdd;
	private String preparedBy;
	private String approvedBy;
	private Date updatedDt;
	private String updatedBy;
	private String wordOrderType;
	private String jobDesc;
	private Date poDate;
	private String poNumber;
	private String frieght;
	private String packing;
	private String octroi;
	private String transportation;
	private String insurance;
	private String roadPermit;
	private String exciseDuty;
	private Long currentStatusLov;
	private Long deptOwnerLov;
	private String salesTax;
	private Date datePerPo;
	private String inspectionBy;
	private String basis;
	
	private String woStatus;
	
	private Date woCloseDate;
	private Set<SciWorkInspection> sciWorkInspections = new HashSet<SciWorkInspection>(
			0);
	private Set<SciFermJobDetails> sciFermJobDetailses = new HashSet<SciFermJobDetails>(
			0);
	private Set<SciWorkDeliInst> sciWorkDeliInsts = new HashSet<SciWorkDeliInst>(
			0);
	private SciCustomerMaster sciCustomerMaster;
	
	
	// Constructors

	/** default constructor */
	public SciWorkorderMaster() {
	}

	/** minimal constructor */
	public SciWorkorderMaster(Long seqWorkId, String clientDetails,
			Date updatedDt, String updatedBy, String wordOrderType,
			String jobDesc) {
		this.seqWorkId = seqWorkId;
		this.clientDetails = clientDetails;
		this.updatedDt = updatedDt;
		this.updatedBy = updatedBy;
		this.wordOrderType = wordOrderType;
		this.jobDesc = jobDesc;
	}

	/** full constructor */
	public SciWorkorderMaster(Long seqWorkId, String oldWordId,
			Date workCreateDt, String clientDetails, String deliveryAdd,
			String preparedBy, String approvedBy, Date updatedDt,
			String updatedBy, String wordOrderType, String jobDesc,
			Date poDate, String poNumber, String frieght, String packing,
			String octroi, String transportation, String insurance,
			String roadPermit, String salesTax, String exciseDuty,
			Long currentStatusLov, Long deptOwnerLov,
			Set<SciWorkInspection> sciWorkInspections,
			Set<SciFermJobDetails> sciFermJobDetailses,
			Set<SciWorkDeliInst> sciWorkDeliInsts) {
		this.seqWorkId = seqWorkId;
		this.oldWordId = oldWordId;
		this.workCreateDt = workCreateDt;
		this.clientDetails = clientDetails;
		this.deliveryAdd = deliveryAdd;
		this.preparedBy = preparedBy;
		this.approvedBy = approvedBy;
		this.updatedDt = updatedDt;
		this.updatedBy = updatedBy;
		this.wordOrderType = wordOrderType;
		this.jobDesc = jobDesc;
		this.poDate = poDate;
		this.poNumber = poNumber;
		this.frieght = frieght;
		this.packing = packing;
		this.octroi = octroi;
		this.transportation = transportation;
		this.insurance = insurance;
		this.roadPermit = roadPermit;
		this.salesTax = salesTax;
		this.exciseDuty = exciseDuty;
		this.currentStatusLov = currentStatusLov;
		this.deptOwnerLov = deptOwnerLov;
		this.sciWorkInspections = sciWorkInspections;
		this.sciFermJobDetailses = sciFermJobDetailses;
		this.sciWorkDeliInsts = sciWorkDeliInsts;
	}

	// Property accessors
	@Id
	@Column(name = "SEQ_WORK_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_WORKORDER_MASTER_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_WORKORDER_MASTER_SEQ" ,name="SCI_WORKORDER_MASTER_SEQ" )
	public Long getSeqWorkId() {
		return this.seqWorkId;
	}

	public void setSeqWorkId(Long seqWorkId) {
		this.seqWorkId = seqWorkId;
	}

	@Column(name = "OLD_WORD_ID", length = 30)
	public String getOldWordId() {
		return this.oldWordId;
	}

	public void setOldWordId(String oldWordId) {
		this.oldWordId = oldWordId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "WORK_CREATE_DT", length = 7)
	public Date getWorkCreateDt() {
		return this.workCreateDt;
	}

	public void setWorkCreateDt(Date workCreateDt) {
		this.workCreateDt = workCreateDt;
	}

	@Column(name = "CLIENT_DETAILS", nullable = true, length = 2000)
	public String getClientDetails() {
		return this.clientDetails;
	}

	public void setClientDetails(String clientDetails) {
		this.clientDetails = clientDetails;
	}

	@Column(name = "DELIVERY_ADD", length = 2000)
	public String getDeliveryAdd() {
		return this.deliveryAdd;
	}

	public void setDeliveryAdd(String deliveryAdd) {
		this.deliveryAdd = deliveryAdd;
	}

	@Column(name = "PREPARED_BY", length = 40)
	public String getPreparedBy() {
		return this.preparedBy;
	}

	public void setPreparedBy(String preparedBy) {
		this.preparedBy = preparedBy;
	}

	@Column(name = "APPROVED_BY", length = 40)
	public String getApprovedBy() {
		return this.approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DT", nullable = false, length = 7)
	public Date getUpdatedDt() {
		return this.updatedDt;
	}

	public void setUpdatedDt(Date updatedDt) {
		this.updatedDt = updatedDt;
	}

	@Column(name = "UPDATED_BY", nullable = false, length = 20)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name = "WORD_ORDER_TYPE", nullable = false, length = 200)
	public String getWordOrderType() {
		return this.wordOrderType;
	}

	public void setWordOrderType(String wordOrderType) {
		this.wordOrderType = wordOrderType;
	}

	@Column(name = "JOB_DESC", nullable = false, length = 2000)
	public String getJobDesc() {
		return this.jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PO_DATE", length = 7)
	public Date getPoDate() {
		return this.poDate;
	}

	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}

	@Column(name = "PO_NUMBER", length = 100)
	public String getPoNumber() {
		return this.poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	@Column(name = "FRIEGHT", length = 200)
	public String getFrieght() {
		return this.frieght;
	}

	public void setFrieght(String frieght) {
		this.frieght = frieght;
	}

	@Column(name = "PACKING", length = 200)
	public String getPacking() {
		return this.packing;
	}

	public void setPacking(String packing) {
		this.packing = packing;
	}

	@Column(name = "OCTROI", length = 200)
	public String getOctroi() {
		return this.octroi;
	}

	public void setOctroi(String octroi) {
		this.octroi = octroi;
	}

	@Column(name = "TRANSPORTATION", length = 200)
	public String getTransportation() {
		return this.transportation;
	}

	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}

	@Column(name = "INSURANCE", length = 200)
	public String getInsurance() {
		return this.insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	@Column(name = "ROAD_PERMIT", length = 200)
	public String getRoadPermit() {
		return this.roadPermit;
	}

	public void setRoadPermit(String roadPermit) {
		this.roadPermit = roadPermit;
	}

	@Column(name = "EXCISE_DUTY", length = 200)
	public String getExciseDuty() {
		return this.exciseDuty;
	}

	public void setExciseDuty(String exciseDuty) {
		this.exciseDuty = exciseDuty;
	}

	@Column(name = "CURRENT_STATUS_LOV", precision = 22, scale = 0)
	public Long getCurrentStatusLov() {
		return this.currentStatusLov;
	}

	public void setCurrentStatusLov(Long currentStatusLov) {
		this.currentStatusLov = currentStatusLov;
	}

	@Column(name = "DEPT_OWNER_LOV", precision = 22, scale = 0)
	public Long getDeptOwnerLov() {
		return this.deptOwnerLov;
	}

	public void setDeptOwnerLov(Long deptOwnerLov) {
		this.deptOwnerLov = deptOwnerLov;
	}

	@Column(name = "SALES_TAX", length = 200)
	public String getSalesTax() {
		return this.salesTax;
	}

	public void setSalesTax(String salesTax) {
		this.salesTax = salesTax;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_PER_PO", length = 7)
	public Date getDatePerPo() {
		return this.datePerPo;
	}

	public void setDatePerPo(Date datePerPo) {
		this.datePerPo = datePerPo;
	}

	@Column(name = "INSPECTION_BY", length = 200)
	public String getInspectionBy() {
		return this.inspectionBy;
	}

	public void setInspectionBy(String inspectionBy) {
		this.inspectionBy = inspectionBy;
	}

	@Column(name = "BASIS", length = 200)
	public String getBasis() {
		return this.basis;
	}

	public void setBasis(String basis) {
		this.basis = basis;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "sciWorkorderMaster")
	public Set<SciWorkInspection> getSciWorkInspections() {
		return this.sciWorkInspections;
	}

	public void setSciWorkInspections(Set<SciWorkInspection> sciWorkInspections) {
		this.sciWorkInspections = sciWorkInspections;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "sciWorkorderMaster")
	public Set<SciFermJobDetails> getSciFermJobDetailses() {
		return this.sciFermJobDetailses;
	}

	public void setSciFermJobDetailses(
			Set<SciFermJobDetails> sciFermJobDetailses) {
		this.sciFermJobDetailses = sciFermJobDetailses;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "sciWorkorderMaster")
	public Set<SciWorkDeliInst> getSciWorkDeliInsts() {
		return this.sciWorkDeliInsts;
	}

	public void setSciWorkDeliInsts(Set<SciWorkDeliInst> sciWorkDeliInsts) {
		this.sciWorkDeliInsts = sciWorkDeliInsts;
	}
	
	public void addFermJob(SciFermJobDetails job) {
		this.sciFermJobDetailses.add(job);
	}
	public void addDeliinst(SciWorkDeliInst job) {
		this.sciWorkDeliInsts.add(job);
	}
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SEQ_CUSTOMER_ID")
	public SciCustomerMaster getSciCustomerMaster() {
		return this.sciCustomerMaster;
	}
	
	public void setSciCustomerMaster(SciCustomerMaster sciCustomerMaster) {
		this.sciCustomerMaster = sciCustomerMaster;
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
	@Column(name = "WO_STATUS", length = 20)
	public String getWoStatus() {
		return woStatus;
	}

	public void setWoStatus(String woStatus) {
		this.woStatus = woStatus;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "WO_CLOSE_DATE", nullable = true, length = 7)
	public Date getWoCloseDate() {
		return woCloseDate;
	}

	public void setWoCloseDate(Date woCloseDate) {
		this.woCloseDate = woCloseDate;
	}


}