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
 * SciRejectedMaterials entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_REJECTED_MATERIALS", schema = "SCIGENICS")
public class SciRejectedMaterials implements java.io.Serializable {

	// Fields

	private Long seqRejdId;
	
	private String rejdDimension;
	private String rejdQuantity;
	private Date rejdDate;
	private Long seqQcId;
	private String updatedBy;
	private Date updatedDate;
	private Long poId;
	private String matcode;
	private String remarks;
	private String matType;
	private String matSpec;
	private String insertedBy;
	private Date insertedDate;
	private String rejectStatus;

	// Constructors

	/** default constructor */
	public SciRejectedMaterials() {
	}

	/** minimal constructor */
	public SciRejectedMaterials(Long seqRejdId) {
		this.seqRejdId = seqRejdId;
	}

	/** full constructor */
	public SciRejectedMaterials(Long seqRejdId, Long seqMiId,
			String rejdDimension, String rejdQuantity, Date rejdDate,
			Long seqQcId, String updatedBy, Date updatedDate,
			Long poId, String matcode, String remarks, String matType,
			String matSpec, String insertedBy, Date insertedDate) {
		this.seqRejdId = seqRejdId;
		
		this.rejdDimension = rejdDimension;
		this.rejdQuantity = rejdQuantity;
		this.rejdDate = rejdDate;
		this.seqQcId = seqQcId;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.poId = poId;
		this.matcode = matcode;
		this.remarks = remarks;
		this.matType = matType;
		this.matSpec = matSpec;
		this.insertedBy = insertedBy;
		this.insertedDate = insertedDate;
	}

	// Property accessors
	@Id
	@Column(name = "SEQ_REJD_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_REJECTED_MAT_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_REJECTED_MAT_SEQ" ,name="SCI_REJECTED_MAT_SEQ" )
	
	
	public Long getSeqRejdId() {
		return this.seqRejdId;
	}

	public void setSeqRejdId(Long seqRejdId) {
		this.seqRejdId = seqRejdId;
	}

	

	@Column(name = "REJD_DIMENSION", length = 1000)
	public String getRejdDimension() {
		return this.rejdDimension;
	}

	public void setRejdDimension(String rejdDimension) {
		this.rejdDimension = rejdDimension;
	}

	@Column(name = "REJD_QUANTITY", length = 20)
	public String getRejdQuantity() {
		return this.rejdQuantity;
	}

	public void setRejdQuantity(String rejdQuantity) {
		this.rejdQuantity = rejdQuantity;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "REJD_DATE", length = 7)
	public Date getRejdDate() {
		return this.rejdDate;
	}

	public void setRejdDate(java.util.Date date) {
		this.rejdDate = date;
	}

	@Column(name = "SEQ_QC_ID", precision = 22, scale = 0)
	public Long getSeqQcId() {
		return this.seqQcId;
	}

	public void setSeqQcId(Long seqQcId) {
		this.seqQcId = seqQcId;
	}

	@Column(name = "UPDATED_BY", length = 20)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE", length = 7)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "PO_ID", precision = 22, scale = 0)
	public Long getPoId() {
		return this.poId;
	}

	public void setPoId(Long poId) {
		this.poId = poId;
	}

	@Column(name = "MATCODE", length = 20)
	public String getMatcode() {
		return this.matcode;
	}

	public void setMatcode(String matcode) {
		this.matcode = matcode;
	}

	@Column(name = "REMARKS", length = 1000)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	private SciMatindMaster sciMiMaster;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SEQ_MI_ID")
		public SciMatindMaster getSciMiMaster() {
		return sciMiMaster;
	}

	public void setSciMiMaster(SciMatindMaster sciMiMaster) {
		this.sciMiMaster = sciMiMaster;
	}
	@Column(name = "REJECT_STATUS", length = 100)
	public String getRejectStatus() {
		return rejectStatus;
	}

	public void setRejectStatus(String rejectStatus) {
		this.rejectStatus = rejectStatus;
	}

}