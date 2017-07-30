package com.sci.bpm.command.marketing;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class WorkOrderCommand implements Serializable {

	
	private String oldWordId;
	private Date workCreateDt;
	private String clientDetails;
	private String deliveryAdd;
	private String preparedBy;
	private String approvedBy;
	
	private String wordOrderType;
	private String jobDesc;
	private String poDatestr;
	private String poNumber;
	private String packing;

	private Date poDate;
	private String seqworkid;
	private String windex;
	
	private String entryTax;
	private String frieght;
	private String transportation;
	private String octroi;
	
	private String amendDetails;
	
	
	private String insurance;
	private String roadPermit;
	private String exciseDuty;
	private Long currentStatusLov;
	private Long deptOwnerLov;
	private String salesTax;
	private Date datePerPo;
	private String inspectionBy;
	private String basis;
	
	private Long seqCustId;
	public String getAmendDetails() {
		return amendDetails;
	}

	public void setAmendDetails(String amendDetails) {
		this.amendDetails = amendDetails;
	}

	public String getPacking() {
		return packing;
	}

	public void setPacking(String packing) {
		this.packing = packing;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getFrieght() {
		return frieght;
	}

	public void setFrieght(String frieght) {
		this.frieght = frieght;
	}

	public String getTransportation() {
		return transportation;
	}

	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}

	public String getOctroi() {
		return octroi;
	}

	public void setOctroi(String octroi) {
		this.octroi = octroi;
	}

	public String getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(String salesTax) {
		this.salesTax = salesTax;
	}

	public String getExciseDuty() {
		return exciseDuty;
	}

	public void setExciseDuty(String exciseDuty) {
		this.exciseDuty = exciseDuty;
	}

	public String getRoadPermit() {
		return roadPermit;
	}

	public void setRoadPermit(String roadPermit) {
		this.roadPermit = roadPermit;
	}

	public String getOldWordId() {
		return oldWordId;
	}
	
	

	public void setOldWordId(String oldWordId) {
		this.oldWordId = oldWordId;
	}
	
	public String getClientDetails() {
		return clientDetails;
	}
	public void setClientDetails(String clientDetails) {
		this.clientDetails = clientDetails;
	}
	public String getDeliveryAdd() {
		return deliveryAdd;
	}
	public void setDeliveryAdd(String deliveryAdd) {
		this.deliveryAdd = deliveryAdd;
	}
	public String getPreparedBy() {
		return preparedBy;
	}
	public void setPreparedBy(String preparedBy) {
		this.preparedBy = preparedBy;
	}
	public String getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
	
	public String getWordOrderType() {
		return wordOrderType;
	}
	public void setWordOrderType(String wordOrderType) {
		this.wordOrderType = wordOrderType;
	}
	public String getJobDesc() {
		return jobDesc;
	}
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	public Date getWorkCreateDt() {
		return workCreateDt;
	}
	public void setWorkCreateDt(Date workCreateDt) {
		this.workCreateDt = workCreateDt;
	}
	public String getPoDatestr() {
		return poDatestr;
	}
	public void setPoDatestr(String poDate) {
		this.poDatestr = poDate;
	}
	public String getPoNumber() {
		return poNumber;
	}
	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public Date getPoDate() {
		return poDate;
	}

	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}

	public String getSeqworkid() {
		return seqworkid;
	}

	public void setSeqworkid(String seqworkid) {
		this.seqworkid = seqworkid;
	}

	public String getWindex() {
		return windex;
	}

	public void setWindex(String windex) {
		this.windex = windex;
	}

	public Date getDatePerPo() {
		return datePerPo;
	}

	public void setDatePerPo(Date datePerPo) {
		this.datePerPo = datePerPo;
	}

	public String getInspectionBy() {
		return inspectionBy;
	}

	public void setInspectionBy(String inspectionBy) {
		this.inspectionBy = inspectionBy;
	}

	public String getBasis() {
		return basis;
	}

	public void setBasis(String basis) {
		this.basis = basis;
	}

	public String getEntryTax() {
		return entryTax;
	}

	public void setEntryTax(String entryTax) {
		this.entryTax = entryTax;
	}

	public Long getSeqCustId() {
		return seqCustId;
	}

	public void setSeqCustId(Long seqCustId) {
		this.seqCustId = seqCustId;
	}
	
	
}
