package com.sci.bpm.command.marketing;

import java.io.Serializable;
import java.util.Date;

public class EnqBean implements Serializable {

	private int windex;
	private Long seqCustomerId;
	private String enqDetails;
	private Date enqDate;
	private Long enqType;
	private String enqSource;
	private String enqStatus;
	private String actionTaken;
	private String enqAttendee;
	private Date actionDate;
	private Long seqenqmasterid;
	
	private Long enqmasterType;
private Long enqCategory;
	
	private Long customerDept;
	
	private String customerContact;
	private Date bringForwardDate;

	private String purpose;
	public Long getSeqCustomerId() {
		return seqCustomerId;
	}
	public void setSeqCustomerId(Long seqCustomerId) {
		this.seqCustomerId = seqCustomerId;
	}
	public String getEnqDetails() {
		return enqDetails;
	}
	public void setEnqDetails(String enqDetails) {
		this.enqDetails = enqDetails;
	}
	public Date getEnqDate() {
		return enqDate;
	}
	public void setEnqDate(Date enqDate) {
		this.enqDate = enqDate;
	}
	public Long getEnqType() {
		return enqType;
	}
	public void setEnqType(Long enqType) {
		this.enqType = enqType;
	}
	public String getEnqSource() {
		return enqSource;
	}
	public void setEnqSource(String enqSource) {
		this.enqSource = enqSource;
	}
	public String getEnqStatus() {
		return enqStatus;
	}
	public void setEnqStatus(String enqStatus) {
		this.enqStatus = enqStatus;
	}
	public String getActionTaken() {
		return actionTaken;
	}
	public void setActionTaken(String actionTaken) {
		this.actionTaken = actionTaken;
	}
	public Date getActionDate() {
		return actionDate;
	}
	public String getEnqAttendee() {
		return enqAttendee;
	}
	public void setEnqAttendee(String enqAttendee) {
		this.enqAttendee = enqAttendee;
	}
	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}
	public int getWindex() {
		return windex;
	}
	public void setWindex(int windex) {
		this.windex = windex;
	}
	public Long getSeqenqmasterid() {
		return seqenqmasterid;
	}
	public void setSeqenqmasterid(Long seqenqmasterid) {
		this.seqenqmasterid = seqenqmasterid;
	}
	public Date getBringForwardDate() {
		return bringForwardDate;
	}
	public void setBringForwardDate(Date bringForwardDate) {
		this.bringForwardDate = bringForwardDate;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public Long getEnqCategory() {
		return enqCategory;
	}
	public void setEnqCategory(Long enqCategory) {
		this.enqCategory = enqCategory;
	}
	public Long getCustomerDept() {
		return customerDept;
	}
	public void setCustomerDept(Long customerDept) {
		this.customerDept = customerDept;
	}
	public String getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	public Long getEnqmasterType() {
		return enqmasterType;
	}
	public void setEnqmasterType(Long enqmasterType) {
		this.enqmasterType = enqmasterType;
	}
	
	
}