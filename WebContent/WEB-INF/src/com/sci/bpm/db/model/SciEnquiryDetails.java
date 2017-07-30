package com.sci.bpm.db.model;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SciEnquiryDetails entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_ENQUIRY_DETAILS", schema = "SCIGENICS")
public class SciEnquiryDetails implements java.io.Serializable {

	// Fields

	private Long seqEnqDetId;
	private SciEnquiryMaster sciEnquiryMaster;
	private String actionTaken;
	private Date actionDate;
	private Date insertedDate;
	private String insertedBy;
	private Date updatedDate;
	private String updatedBy;
	
	private Date bringForwardDate;

	private String purpose;
	
	
	// Constructors

	/** default constructor */
	public SciEnquiryDetails() {
	}

	/** minimal constructor */
	public SciEnquiryDetails(Long seqEnqDetId) {
		this.seqEnqDetId = seqEnqDetId;
	}

	/** full constructor */
	public SciEnquiryDetails(Long seqEnqDetId,
			SciEnquiryMaster sciEnquiryMaster, String actionTaken,
			Date actionDate, Date insertedDate, String insertedBy,
			Date updatedDate, String updatedBy) {
		this.seqEnqDetId = seqEnqDetId;
		this.sciEnquiryMaster = sciEnquiryMaster;
		this.actionTaken = actionTaken;
		this.actionDate = actionDate;
		this.insertedDate = insertedDate;
		this.insertedBy = insertedBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}

	// Property accessors
	
	
	@Id
	@Column(name = "SEQ_ENQ_DET_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 10, scale = 0)
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_ENQ_DET_ID_SEQ", name="SCI_ENQ_DET_ID_SEQ" )
	@GeneratedValue(generator = "SCI_ENQ_DET_ID_SEQ")
	public Long getSeqEnqDetId() {
		return this.seqEnqDetId;
	}

	public void setSeqEnqDetId(Long seqEnqDetId) {
		this.seqEnqDetId = seqEnqDetId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SEQ_ENQRY_ID")
	public SciEnquiryMaster getSciEnquiryMaster() {
		return this.sciEnquiryMaster;
	}

	public void setSciEnquiryMaster(SciEnquiryMaster sciEnquiryMaster) {
		this.sciEnquiryMaster = sciEnquiryMaster;
	}

	@Column(name = "ACTION_TAKEN", length = 2000)
	public String getActionTaken() {
		return this.actionTaken;
	}

	public void setActionTaken(String actionTaken) {
		this.actionTaken = actionTaken;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "ACTION_DATE", length = 7)
	public Date getActionDate() {
		return this.actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "INSERTED_DATE", length = 7)
	public Date getInsertedDate() {
		return this.insertedDate;
	}

	public void setInsertedDate(Date insertedDate) {
		this.insertedDate = insertedDate;
	}

	@Column(name = "INSERTED_BY", length = 20)
	public String getInsertedBy() {
		return this.insertedBy;
	}

	public void setInsertedBy(String insertedBy) {
		this.insertedBy = insertedBy;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE", length = 7)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "UPDATED_BY", length = 20)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "BRING_FORWARD_DATE", nullable=true,length = 7)
	public Date getBringForwardDate() {
		return bringForwardDate;
	}

	public void setBringForwardDate(Date bringForwardDate) {
		this.bringForwardDate = bringForwardDate;
	}
	@Column(name = "PURPOSE", nullable=true,length = 250)
	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

}