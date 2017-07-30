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
 * SciVendorInvoiceMaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_VENDOR_INVOICE_MASTER", schema = "SCIGENICS")
public class SciVendorInvoiceMaster implements java.io.Serializable {

	// Fields

	private Long seqInvoiceId;
	private SciVendorMaster sciVendorMaster;
	private Date billDate;
	private Double billAmount;
	private String billNo;
	private String insertedBy;
	private Date insertedDate;
	private String updatedBy;
	private Date updatedDate;
	private Long poId;
	private Double adjustAmount;
	private Double finalAmount;
	private Long seqPaymentID;
	private String vatFormRaised;
	
	private Date vatFormDate;
	// Constructors

	/** default constructor */
	public SciVendorInvoiceMaster() {
	}

	/** minimal constructor */
	public SciVendorInvoiceMaster(Long seqInvoiceId,
			Date billDate, Double billAmount, String insertedBy,
			Date insertedDate, String updatedBy, Date updatedDate,
			Long poId) {
		this.seqInvoiceId = seqInvoiceId;
		
		this.billDate = billDate;
		this.billAmount = billAmount;
		this.insertedBy = insertedBy;
		this.insertedDate = insertedDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.poId = poId;
	}

	/** full constructor */
	public SciVendorInvoiceMaster(Long seqInvoiceId, 
			Date billDate, Double billAmount, String billNo,
			String insertedBy, Date insertedDate, String updatedBy,
			Date updatedDate, Long poId) {
		this.seqInvoiceId = seqInvoiceId;
		
		this.billDate = billDate;
		this.billAmount = billAmount;
		this.billNo = billNo;
		this.insertedBy = insertedBy;
		this.insertedDate = insertedDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.poId = poId;
	}

	// Property accessors
	
	@Id
	@Column(name = "SEQ_INVOICE_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_INVOICE_DETAILS_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_INVOICE_DETAILS_SEQ" ,name="SCI_INVOICE_DETAILS_SEQ" )
	public Long getSeqInvoiceId() {
		return this.seqInvoiceId;
	}

	public void setSeqInvoiceId(Long seqInvoiceId) {
		this.seqInvoiceId = seqInvoiceId;
	}

	
	@Temporal(TemporalType.DATE)
	@Column(name = "BILL_DATE", nullable = false, length = 7)
	public Date getBillDate() {
		return this.billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	@Column(name = "BILL_AMOUNT", nullable = false, precision = 10)
	public Double getBillAmount() {
		return this.billAmount;
	}

	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}

	@Column(name = "BILL_NO", length = 50)
	public String getBillNo() {
		return this.billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
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

	@Column(name = "PO_ID", nullable = false, precision = 0)
	public Long getPoId() {
		return this.poId;
	}

	public void setPoId(Long poId) {
		this.poId = poId;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.EAGER)
	@JoinColumn(name = "SEQ_VENDOR_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public SciVendorMaster getSciVendorMaster() {
		return sciVendorMaster;
	}

	public void setSciVendorMaster(SciVendorMaster sciVendorMaster) {
		this.sciVendorMaster = sciVendorMaster;
	}
	@Column(name = "ADJUSTED_AMOUNT", nullable = true, precision = 10)
	public Double getAdjustAmount() {
		return adjustAmount;
	}

	public void setAdjustAmount(Double adjustAmount) {
		this.adjustAmount = adjustAmount;
	}
	@Column(name = "FINAL_AMOUNT", nullable = true, precision = 10)
	public Double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(Double finalAmount) {
		this.finalAmount = finalAmount;
	}
	@Column(name = "SEQ_PAYMENT_ID", nullable = true, precision = 22)
	public Long getSeqPaymentID() {
		return seqPaymentID;
	}

	public void setSeqPaymentID(Long seqPaymentID) {
		this.seqPaymentID = seqPaymentID;
	}

}