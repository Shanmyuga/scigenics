package com.sci.bpm.db.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the SCI_VENDOR_PURCHASE_COST database table.
 * 
 */
@Entity
@Table(name="SCI_VENDOR_PURCHASE_COST")
@NamedQuery(name="SciVendorPurchaseCost.findAll", query="SELECT s FROM SciVendorPurchaseCost s")
public class SciVendorPurchaseCost implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SEQ_VEND_PURCH_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_VENDOR_PURCH_COST_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_VENDOR_PURCH_COST_SEQ" ,name="SCI_VENDOR_PURCH_COST_SEQ" )
	private Long seqVendPurchId;

	@Column(name="MAT_COST")
	private Double matCost;

	@Column(name="EXCISE_DUTY")
	private Float exciseDuty;
	
	public Float getExciseDuty() {
		return exciseDuty;
	}

	public void setExciseDuty(Float exciseDuty) {
		this.exciseDuty = exciseDuty;
	}

	public Float getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(Float salesTax) {
		this.salesTax = salesTax;
	}

	public Double getFrieghtCharges() {
		return frieghtCharges;
	}

	public void setFrieghtCharges(Double frieghtCharges) {
		this.frieghtCharges = frieghtCharges;
	}

	@Column(name="SALES_TAX")
	private Float salesTax;
	
	@Column(name="FRIEGHT_CHARGES")
	private Double frieghtCharges;
	
	@Column(name="MATCODE")
	private String matCategory;
	
	@Column(name="MAT_DEPT")
	private String matDept;
	
	@Column(name="SPEC_DETAILS")
	private String specDetails;

	@ManyToOne(cascade = {}, fetch = FetchType.EAGER)
	@JoinColumn(name = "SEQ_VENDOR_ID", unique = false, nullable = false, insertable = true, updatable = true)
	private SciVendorMaster sciVendorMaster;

	@Column(name="UPDATED_BY")
	private String updatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE")
	private Date updatedDate;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="QUOTATION_DATE")
	private Date quotationDate;

	public SciVendorPurchaseCost() {
	}

	public long getSeqVendPurchId() {
		return this.seqVendPurchId;
	}

	public void setSeqVendPurchId(long seqVendPurchId) {
		this.seqVendPurchId = seqVendPurchId;
	}

	public Double getMatCost() {
		return this.matCost;
	}

	public void setMatCost(Double matCost) {
		this.matCost = matCost;
	}

	
	
	public String getMatCategory() {
		return matCategory;
	}

	public void setMatCategory(String matCategory) {
		this.matCategory = matCategory;
	}

	public String getMatDept() {
		return matDept;
	}

	public void setMatDept(String matDept) {
		this.matDept = matDept;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	
	
	public SciVendorMaster getSciVendorMaster() {
		return sciVendorMaster;
	}

	public void setSciVendorMaster(SciVendorMaster sciVendorMaster) {
		this.sciVendorMaster = sciVendorMaster;
	}

	public String getSpecDetails() {
		return specDetails;
	}

	public void setSpecDetails(String specDetails) {
		this.specDetails = specDetails;
	}

	public Date getQuotationDate() {
		return quotationDate;
	}

	public void setQuotationDate(Date quotationDate) {
		this.quotationDate = quotationDate;
	}
}