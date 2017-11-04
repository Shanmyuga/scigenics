package com.sci.bpm.command;

import java.io.Serializable;

public class LookupValueBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String lovName;
	private String lovType;
	private String lovDescription;
	
	private String customerName;
	private String customerAddress;
	private String customerAddress1;
	private String customerPhone;
	private String cusomterCity;
	private String customerEmail;
	private String customerContact;
	private Long customerState;

	private String customerCountry;
	
	
	private String vendorName;
	private String vendorAddress1;
	private String phoneNumber;
	private String emailId;
	private String vendorContact;
	private String vendorCity;
	private String vendorAddress;
	
	
	
	private String seqReportID;
	private String reportQuery;
	private String reportSubject;
	private String reportEmail;



	private String reportSchedule;
	private String reportStatus;

	private String reportFilter;
	private String matcatCode;
     private String matSpecDesc;
     private String materialSpec;
     private String specCode;

     private String matDept;
	
	public String getLovName() {
		return lovName;
	}
	public void setLovName(String lovName) {
		this.lovName = lovName;
	}
	public String getLovType() {
		return lovType;
	}
	public void setLovType(String lovType) {
		this.lovType = lovType;
	}
	public String getLovDescription() {
		return lovDescription;
	}
	public void setLovDescription(String lovDescription) {
		this.lovDescription = lovDescription;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerAddress1() {
		return customerAddress1;
	}
	public void setCustomerAddress1(String customerAddress1) {
		this.customerAddress1 = customerAddress1;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCusomterCity() {
		return cusomterCity;
	}
	public void setCusomterCity(String cusomterCity) {
		this.cusomterCity = cusomterCity;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorAddress1() {
		return vendorAddress1;
	}
	public void setVendorAddress1(String vendorAddress1) {
		this.vendorAddress1 = vendorAddress1;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getVendorContact() {
		return vendorContact;
	}
	public void setVendorContact(String vendorContact) {
		this.vendorContact = vendorContact;
	}
	public String getVendorCity() {
		return vendorCity;
	}
	public void setVendorCity(String vendorCity) {
		this.vendorCity = vendorCity;
	}
	public String getVendorAddress() {
		return vendorAddress;
	}
	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}
	public String getMatcatCode() {
		return matcatCode;
	}
	public void setMatcatCode(String matcatCode) {
		this.matcatCode = matcatCode;
	}
	public String getMatSpecDesc() {
		return matSpecDesc;
	}
	public void setMatSpecDesc(String matSpecDesc) {
		this.matSpecDesc = matSpecDesc;
	}
	public String getMaterialSpec() {
		return materialSpec;
	}
	public void setMaterialSpec(String materialSpec) {
		this.materialSpec = materialSpec;
	}
	public String getSpecCode() {
		return specCode;
	}
	public void setSpecCode(String specCode) {
		this.specCode = specCode;
	}
	public String getMatDept() {
		return matDept;
	}
	public void setMatDept(String matDept) {
		this.matDept = matDept;
	}
	
	public String getReportQuery() {
		return reportQuery;
	}
	public void setReportQuery(String reportQuery) {
		this.reportQuery = reportQuery;
	}
	public String getReportSubject() {
		return reportSubject;
	}
	public void setReportSubject(String reportSubject) {
		this.reportSubject = reportSubject;
	}
	public String getReportEmail() {
		return reportEmail;
	}
	public void setReportEmail(String reportEmail) {
		this.reportEmail = reportEmail;
	}
	public String getReportSchedule() {
		return reportSchedule;
	}
	public void setReportSchedule(String reportSchedule) {
		this.reportSchedule = reportSchedule;
	}
	public String getReportStatus() {
		return reportStatus;
	}
	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}
	public String getSeqReportID() {
		return seqReportID;
	}
	public void setSeqReportID(String seqReportID) {
		this.seqReportID = seqReportID;
	}
	public Long getCustomerState() {
		return customerState;
	}
	public void setCustomerState(Long customerState) {
		this.customerState = customerState;
	}
	public String getCustomerCountry() {
		return customerCountry;
	}
	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}

	public String getReportFilter() {
		return reportFilter;
	}

	public void setReportFilter(String reportFilter) {
		this.reportFilter = reportFilter;
	}

}
