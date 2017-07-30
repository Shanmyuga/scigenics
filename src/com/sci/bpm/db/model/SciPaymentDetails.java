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
 * SciPaymentDetails entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_PAYMENT_DETAILS", schema = "SCIGENICS")
public class SciPaymentDetails implements java.io.Serializable {

	// Fields

	private Long seqPaymentId;
	private Date paymentDate;
	private SciVendorMaster sciVendorMaster;
	private String paymentRemarks;
	private Double paymentAmt;
	private String insertedBy;
	private Date insertedDate;
	private Long poId;
	private String billNo;
	// Constructors

	/** default constructor */
	public SciPaymentDetails() {
	}

	/** minimal constructor */
	public SciPaymentDetails(Long seqPaymentId, Date paymentDate,
			 Double paymentAmt, String insertedBy,
			Date insertedDate) {
		this.seqPaymentId = seqPaymentId;
		this.paymentDate = paymentDate;
		
		this.paymentAmt = paymentAmt;
		this.insertedBy = insertedBy;
		this.insertedDate = insertedDate;
	}

	/** full constructor */
	public SciPaymentDetails(Long seqPaymentId, Date paymentDate,
			 String paymentRemarks, Double paymentAmt,
			String insertedBy, Date insertedDate) {
		this.seqPaymentId = seqPaymentId;
		this.paymentDate = paymentDate;
		
		this.paymentRemarks = paymentRemarks;
		this.paymentAmt = paymentAmt;
		this.insertedBy = insertedBy;
		this.insertedDate = insertedDate;
	}

	// Property accessors
	
	@Id
	@Column(name = "SEQ_PAYMENT_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_PAYMENT_DETAILS_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_PAYMENT_DETAILS_SEQ" ,name="SCI_PAYMENT_DETAILS_SEQ" )
	public Long getSeqPaymentId() {
		return this.seqPaymentId;
	}

	public void setSeqPaymentId(Long seqPaymentId) {
		this.seqPaymentId = seqPaymentId;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "PAYMENT_DATE", nullable = false, length = 7)
	public Date getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}



	@Column(name = "PAYMENT_REMARKS", length = 60)
	public String getPaymentRemarks() {
		return this.paymentRemarks;
	}

	public void setPaymentRemarks(String paymentRemarks) {
		this.paymentRemarks = paymentRemarks;
	}

	@Column(name = "PAYMENT_AMT", nullable = false, precision = 10)
	public Double getPaymentAmt() {
		return this.paymentAmt;
	}

	public void setPaymentAmt(Double paymentAmt) {
		this.paymentAmt = paymentAmt;
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
	@Column(name = "PO_ID", nullable = true, precision = 0)
	public Long getPoId() {
		return poId;
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
	@Column(name = "BILL_NO", length = 200)
	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billno) {
		this.billNo = billno;
	}
}