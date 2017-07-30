package com.sci.bpm.db.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * SciVendorMaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_VENDOR_MASTER", schema = "SCIGENICS")
public class SciVendorMaster implements java.io.Serializable {

	// Fields

	private Long seqVendorId;
	private String vendorName;
	private String vendorAddress1;
	private String phoneNumber;
	private String emailId;
	private String vendorContact;
	private String vendorCity;
	private String vendorAddress;

	// Constructors

	/** default constructor */
	public SciVendorMaster() {
	}

	/** minimal constructor */
	public SciVendorMaster(Long seqVendorId) {
		this.seqVendorId = seqVendorId;
	}

	/** full constructor */
	public SciVendorMaster(Long seqVendorId, String vendorName,
			String vendorAddress1, String phoneNumber, String emailId,
			String vendorContact, String vendorCity, String vendorAddress) {
		this.seqVendorId = seqVendorId;
		this.vendorName = vendorName;
		this.vendorAddress1 = vendorAddress1;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.vendorContact = vendorContact;
		this.vendorCity = vendorCity;
		this.vendorAddress = vendorAddress;
	}


		@Id
	@Column(name = "SEQ_VENDOR_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_VENDOR_MASTER_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_VENDOR_MASTER_SEQ" ,name="SCI_VENDOR_MASTER_SEQ" )
	public Long getSeqVendorId() {
		return this.seqVendorId;
	}

	public void setSeqVendorId(Long seqVendorId) {
		this.seqVendorId = seqVendorId;
	}

	@Column(name = "VENDOR_NAME", length = 100)
	public String getVendorName() {
		return this.vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	@Column(name = "VENDOR_ADDRESS1", length = 500)
	public String getVendorAddress1() {
		return this.vendorAddress1;
	}

	public void setVendorAddress1(String vendorAddress1) {
		this.vendorAddress1 = vendorAddress1;
	}

	@Column(name = "PHONE_NUMBER", length = 100)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "EMAIL_ID", length = 50)
	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "VENDOR_CONTACT", length = 100)
	public String getVendorContact() {
		return this.vendorContact;
	}

	public void setVendorContact(String vendorContact) {
		this.vendorContact = vendorContact;
	}

	@Column(name = "VENDOR_CITY", length = 100)
	public String getVendorCity() {
		return this.vendorCity;
	}

	public void setVendorCity(String vendorCity) {
		this.vendorCity = vendorCity;
	}

	@Column(name = "VENDOR_ADDRESS", length = 500)
	public String getVendorAddress() {
		return this.vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}
	
	private String updatedBy;
	private Date updatedDate;
	
	@Column(name = "UPDATED_BY", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	
	private String vendorConcat;

	@Transient
	public String getVendorConcat() {
		return this.vendorName +" - " + vendorAddress;
	}

	public void setVendorConcat(String vendorConcat) {
		this.vendorConcat = vendorConcat;
	}
	
	
}