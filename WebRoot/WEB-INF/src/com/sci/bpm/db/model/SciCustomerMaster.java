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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * SciCustomerMaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_CUSTOMER_MASTER", schema = "SCIGENICS")
public class SciCustomerMaster implements java.io.Serializable {

	// Fields

	private Long seqCustId;
	private String customerName;
	private String customerAddress;
	private String customerAddress1;
	private String customerPhone;
	private String cusomterCity;
	private String customerEmail;
	private String customerContact;
	private String customerDetails;
	private Long customerState;
	
	private String customerCountry;
	private Set<SciWorkorderMaster> sciWorkorderMasters = new HashSet<SciWorkorderMaster>(
			0);

	// Constructors

	/** default constructor */
	public SciCustomerMaster() {
	}

	/** minimal constructor */
	public SciCustomerMaster(Long seqCustId) {
		this.seqCustId = seqCustId;
	}

	/** full constructor */
	public SciCustomerMaster(Long seqCustId, String customerName,
			String customerAddress, String customerAddress1,
			String customerPhone, String cusomterCity, String customerEmail,
			String customerContact, Set<SciWorkorderMaster> sciWorkorderMasters) {
		this.seqCustId = seqCustId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerAddress1 = customerAddress1;
		this.customerPhone = customerPhone;
		this.cusomterCity = cusomterCity;
		this.customerEmail = customerEmail;
		this.customerContact = customerContact;
		this.sciWorkorderMasters = sciWorkorderMasters;
	}

	// Property accessors

		@Id
	@Column(name = "SEQ_CUST_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_CUSTOMER_MAST_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_CUSTOMER_MAST_SEQ" ,name="SCI_CUSTOMER_MAST_SEQ" )
	public Long getSeqCustId() {
		return this.seqCustId;
	}

	public void setSeqCustId(Long seqCustId) {
		this.seqCustId = seqCustId;
	}

	@Column(name = "CUSTOMER_NAME", length = 500)
	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Column(name = "CUSTOMER_ADDRESS", length = 1000)
	public String getCustomerAddress() {
		return this.customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Column(name = "CUSTOMER_ADDRESS1", length = 1000)
	public String getCustomerAddress1() {
		return this.customerAddress1;
	}

	public void setCustomerAddress1(String customerAddress1) {
		this.customerAddress1 = customerAddress1;
	}

	@Column(name = "CUSTOMER_PHONE", length = 100)
	public String getCustomerPhone() {
		return this.customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	@Column(name = "CUSOMTER_CITY", length = 100)
	public String getCusomterCity() {
		return this.cusomterCity;
	}

	public void setCusomterCity(String cusomterCity) {
		this.cusomterCity = cusomterCity;
	}

	@Column(name = "CUSTOMER_EMAIL", length = 50)
	public String getCustomerEmail() {
		return this.customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	@Column(name = "CUSTOMER_CONTACT", length = 100)
	public String getCustomerContact() {
		return this.customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sciCustomerMaster")
	public Set<SciWorkorderMaster> getSciWorkorderMasters() {
		return this.sciWorkorderMasters;
	}

	public void setSciWorkorderMasters(
			Set<SciWorkorderMaster> sciWorkorderMasters) {
		this.sciWorkorderMasters = sciWorkorderMasters;
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

	@Transient
	public String getCustomerDetails() {
		return customerName +" -  "+customerContact;
	}

	public void setCustomerDetails(String customerDetails) {
		this.customerDetails = customerDetails;
	}
	@Column(name = "CUSTOMER_STATE",  precision = 9, scale = 0)
	public Long getCustomerState() {
		return customerState;
	}

	public void setCustomerState(Long customerState) {
		this.customerState = customerState;
	}
	@Column(name = "CUSTOMER_COUNTRY", length = 50)
	public String getCustomerCountry() {
		return customerCountry;
	}

	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}

}