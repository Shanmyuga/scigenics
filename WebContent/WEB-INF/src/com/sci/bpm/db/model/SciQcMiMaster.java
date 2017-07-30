package com.sci.bpm.db.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
 * SciQcMiMaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_QC_MI_MASTER", schema = "SCIGENICS")
public class SciQcMiMaster implements java.io.Serializable {

	// Fields

	private Long seqQcMiId;
	private SciQcDocs seqQCDoc;
	private String ocStatus;
	private String qcRecCnt;
	private String qcRecDime;
	private String matCode;
	private String qcAppCnt;
	private String qcAppDime;
	private String qcTestsCond;
	private String qcFailReason;
	private String qcFailedCnt;
	private String qcFailedDim;
	private String updatedBy;
	private Date updatedDt;
	private String approvedBy;
	private Date qcApprovalDate;

	private String  qcTestsApproval;
	private SciStoreMiMaster stmimaster;
	private Long seqStoreMiId;
	private Long reworkQnt;
	private String reworkDim;
	private String reworkStatus;
	private String failedStatus;
	private Long poId;
	
	private Long seqPurchItemID;
	
	private List<SciRawMIDetails> rawmis;
	private List<SciPurchaseMast> pomasters;
	private List<SciQcDocs> mydocs = new ArrayList<SciQcDocs>();
	// Constructors

	/** default constructor */
	public SciQcMiMaster() {
	}

	/** minimal constructor */
	public SciQcMiMaster(Long seqQcMiId, 
			String ocStatus, String qcRecCnt, String qcRecDime, String matCode,
			String updatedBy, Date updatedDt) {
		this.seqQcMiId = seqQcMiId;
		
		this.ocStatus = ocStatus;
		this.qcRecCnt = qcRecCnt;
		this.qcRecDime = qcRecDime;
		this.matCode = matCode;
		this.updatedBy = updatedBy;
		this.updatedDt = updatedDt;
	}

	/** full constructor */
	public SciQcMiMaster(Long seqQcMiId, 
			String ocStatus, String qcRecCnt, String qcRecDime, String matCode,
			String qcAppCnt, String qcAppDime, String qcTestsCond,
			String qcFailReason, String qcFailedCnt, String qcFailedDim,
			String updatedBy, Date updatedDt) {
		this.seqQcMiId = seqQcMiId;
		
		this.ocStatus = ocStatus;
		this.qcRecCnt = qcRecCnt;
		this.qcRecDime = qcRecDime;
		this.matCode = matCode;
		this.qcAppCnt = qcAppCnt;
		this.qcAppDime = qcAppDime;
		this.qcTestsCond = qcTestsCond;
		this.qcFailReason = qcFailReason;
		this.qcFailedCnt = qcFailedCnt;
		this.qcFailedDim = qcFailedDim;
		this.updatedBy = updatedBy;
		this.updatedDt = updatedDt;
	}

	// Property accessors
	@Id
	@Column(name = "SEQ_QC_MI_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_QC_MI_MASTER_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_QC_MI_MASTER_SEQ" ,name="SCI_QC_MI_MASTER_SEQ" )
	public Long getSeqQcMiId() {
		return this.seqQcMiId;
	}

	public void setSeqQcMiId(Long seqQcMiId) {
		this.seqQcMiId = seqQcMiId;
	}


	@Column(name = "OC_STATUS", nullable = false, length = 1)
	public String getOcStatus() {
		return this.ocStatus;
	}

	public void setOcStatus(String ocStatus) {
		this.ocStatus = ocStatus;
	}

	@Column(name = "QC_REC_CNT", nullable = false, length = 20)
	public String getQcRecCnt() {
		return this.qcRecCnt;
	}

	public void setQcRecCnt(String qcRecCnt) {
		this.qcRecCnt = qcRecCnt;
	}

	@Column(name = "QC_REC_DIME", nullable = false, length = 1000)
	public String getQcRecDime() {
		return this.qcRecDime;
	}

	public void setQcRecDime(String qcRecDime) {
		this.qcRecDime = qcRecDime;
	}

	@Column(name = "MAT_CODE", nullable = false, length = 20)
	public String getMatCode() {
		return this.matCode;
	}

	public void setMatCode(String matCode) {
		this.matCode = matCode;
	}

	@Column(name = "QC_APP_CNT", length = 20)
	public String getQcAppCnt() {
		return this.qcAppCnt;
	}

	public void setQcAppCnt(String qcAppCnt) {
		this.qcAppCnt = qcAppCnt;
	}

	@Column(name = "QC_APP_DIME", length = 1000)
	public String getQcAppDime() {
		return this.qcAppDime;
	}

	public void setQcAppDime(String qcAppDime) {
		this.qcAppDime = qcAppDime;
	}

	@Column(name = "QC_TESTS_COND", length = 1000)
	public String getQcTestsCond() {
		return this.qcTestsCond;
	}

	public void setQcTestsCond(String qcTestsCond) {
		this.qcTestsCond = qcTestsCond;
	}

	@Column(name = "QC_FAIL_REASON", length = 1000)
	public String getQcFailReason() {
		return this.qcFailReason;
	}

	public void setQcFailReason(String qcFailReason) {
		this.qcFailReason = qcFailReason;
	}

	@Column(name = "QC_FAILED_CNT", length = 20)
	public String getQcFailedCnt() {
		return this.qcFailedCnt;
	}

	public void setQcFailedCnt(String qcFailedCnt) {
		this.qcFailedCnt = qcFailedCnt;
	}

	@Column(name = "QC_FAILED_DIM", length = 1000)
	public String getQcFailedDim() {
		return this.qcFailedDim;
	}

	public void setQcFailedDim(String qcFailedDim) {
		this.qcFailedDim = qcFailedDim;
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

	@Transient
	public SciStoreMiMaster getStmimaster() {
		return stmimaster;
	}

	public void setStmimaster(SciStoreMiMaster stmimaster) {
		this.stmimaster = stmimaster;
	}
	@Column(name = "QC_TESTS_APPROVAL", nullable = false, length = 1)
	public String getQcTestsApproval() {
		return qcTestsApproval;
	}

	public void setQcTestsApproval(String qcTestsApproval) {
		this.qcTestsApproval = qcTestsApproval;
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
	@Column(name = "APPROVED_BY", unique = false, nullable = true, insertable = true, updatable = true, length=20)
	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	
	@Temporal(TemporalType.DATE)
	@Column(name = "QC_APPROVAL_DATE", nullable = true, length = 7)
	public Date getQcApprovalDate() {
		return qcApprovalDate;
	}

	public void setQcApprovalDate(Date qcApprovalDate) {
		this.qcApprovalDate = qcApprovalDate;
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
	@Column(name = "SEQ_STORE_MI_ID", insertable = true, updatable = true, precision = 22, scale = 0)
	public Long getSeqStoreMiId() {
		return seqStoreMiId;
	}

	public void setSeqStoreMiId(Long seqStoreMiId) {
		this.seqStoreMiId = seqStoreMiId;
	}
	


	@Column(name = "REWORK_QNT", precision = 22, scale = 0)
	public Long getReworkQnt() {
		return this.reworkQnt;
	}

	public void setReworkQnt(Long reworkQnt) {
		this.reworkQnt = reworkQnt;
	}

	@Column(name = "REWORK_DIM", length = 100)
	public String getReworkDim() {
		return this.reworkDim;
	}

	public void setReworkDim(String reworkDim) {
		this.reworkDim = reworkDim;
	}

	@Column(name = "REWORK_STATUS", length = 1)
	public String getReworkStatus() {
		return this.reworkStatus;
	}

	public void setReworkStatus(String reworkStatus) {
		this.reworkStatus = reworkStatus;
	}

	@Column(name = "FAILED_STATUS", length = 1)
	public String getFailedStatus() {
		return this.failedStatus;
	}

	public void setFailedStatus(String failedStatus) {
		this.failedStatus = failedStatus;
	}
	@Column(name = "PO_ID", nullable = true, precision = 22, scale = 0)
	public Long getPoId() {
		return this.poId;
	}

	public void setPoId(Long poId) {
		this.poId = poId;
	}

	@Transient
	public SciQcDocs getSeqQCDoc() {
		return seqQCDoc;
	}

	public void setSeqQCDoc(SciQcDocs seqQCDoc) {
		this.seqQCDoc = seqQCDoc;
	}
	@Column(name="SEQ_PURCHITEM_ID", precision=9, scale=0)
	public Long getSeqPurchItemID() {
		return seqPurchItemID;
	}

	public void setSeqPurchItemID(Long seqPurchItemID) {
		this.seqPurchItemID = seqPurchItemID;
	}
	
	
	@Transient
	public List<SciRawMIDetails> getRawmis() {
		return rawmis;
	}

	public void setRawmis(List<SciRawMIDetails> rawmis) {
		this.rawmis = rawmis;
	}
	@Transient
	public List<SciPurchaseMast> getPomasters() {
		return pomasters;
	}

	public void setPomasters(List<SciPurchaseMast> pomasters) {
		this.pomasters = pomasters;
	}

	@Transient
	public List<SciQcDocs> getMydocs() {
		return mydocs;
	}

	public void setMydocs(List<SciQcDocs> mydocs) {
		this.mydocs = mydocs;
	}
	
	public void addmydocs(List<SciQcDocs> rdocs) {
		this.mydocs.addAll(rdocs);
	}

}