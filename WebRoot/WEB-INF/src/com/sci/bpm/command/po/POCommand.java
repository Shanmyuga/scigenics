package com.sci.bpm.command.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sci.bpm.command.mi.MatCollectionCommand;

public class POCommand implements Serializable {

	private String vendorOrder;
	private String vendorAddress;
	private Date purchaseDueDate;
	private Long seqVendorId;
	private Long purchaseStatus;
	private Long scipurchID;
	private String specialCondition;
	private Float totalCost;
	private String modeOfDispatch;
	private String insurance;
	private String paymentTerms;
	private String deliverySchedule;
	private String[] supportDocuments;
	private String matCategory;
	private String matDept;
	private String purchaseType;
	private Long purchaseID;
	private Long seqRejectid;
	private Date fromdate;
	private String rejectremarks;
	private String rejectStatus;
	private String filterStatus;
	private Double freigntCharges = new Double("0");
	private Double vatCharges = new Double("0");
	private Double exciseCharges= new Double("0");
	private Double excisePercent= new Double("0");
	private Double vatPercentage= new Double("0");
	private Double itemTotalCost= new Double("0");
	private Double poTotalcost= new Double("0");
	private Double packingFrwdCharges= new Double("0");
	private List<POCollectionCommand> poitemList = new ArrayList();
	private String remarksPO;
	private String refundStatement;
	private Date todate;
	private String[] poDetailIndex;
	private Date refDate;
	private String qutRefNo;
	private Date paymentDate;

	private String subContVendor;
	private String paymentRemarks;
	private Double paymentAmt;
	private Date billDate;
	private Double billAmount;
	private String billNo;
	private Double poId;
	
	private Double matCost;
	
	private String specDetails;
	
	private Float exciseDuty;
	
	private Float salesTax;
	
	private Double frieghtCharges;
	private Date quotationDate;

	public POCommand() {
		super();
		for (int idx = 0; idx < 100; idx++) {
			this.poitemList.add(new POCollectionCommand());
		}
	}

	public List<POCollectionCommand> getPoitemList() {
		return poitemList;
	}

	public void setPoitemList(List<POCollectionCommand> poitemList) {
		this.poitemList = poitemList;
	}

	public String[] getPoDetailIndex() {
		return poDetailIndex;
	}

	public void setPoDetailIndex(String[] poDetailIndex) {
		this.poDetailIndex = poDetailIndex;
	}

	public Date getFromdate() {
		return fromdate;
	}

	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}

	public Date getTodate() {
		return todate;
	}

	public void setTodate(Date todate) {
		this.todate = todate;
	}

	public Long getPurchaseStatus() {
		return purchaseStatus;
	}

	public void setPurchaseStatus(Long purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}

	public String getVendorOrder() {
		return vendorOrder;
	}

	public void setVendorOrder(String vendorOrder) {
		this.vendorOrder = vendorOrder;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public Date getPurchaseDueDate() {
		return purchaseDueDate;
	}

	public void setPurchaseDueDate(Date purchaseDueDate) {
		this.purchaseDueDate = purchaseDueDate;
	}

	public Long getScipurchID() {
		return scipurchID;
	}

	public void setScipurchID(Long scipurchID) {
		this.scipurchID = scipurchID;
	}

	public Long getSeqVendorId() {
		return seqVendorId;
	}

	public void setSeqVendorId(Long seqVendorId) {
		this.seqVendorId = seqVendorId;
	}

	public String getSpecialCondition() {
		return specialCondition;
	}

	public void setSpecialCondition(String specialCondition) {
		this.specialCondition = specialCondition;
	}

	public Float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Float totalCost) {
		this.totalCost = totalCost;
	}

	public String getModeOfDispatch() {
		return modeOfDispatch;
	}

	public void setModeOfDispatch(String modeOfDispatch) {
		this.modeOfDispatch = modeOfDispatch;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getPaymentTerms() {
		return paymentTerms;
	}

	public void setPaymentTerms(String paymentTerms) {
		this.paymentTerms = paymentTerms;
	}

	public String getDeliverySchedule() {
		return deliverySchedule;
	}

	public void setDeliverySchedule(String deliverySchedule) {
		this.deliverySchedule = deliverySchedule;
	}

	public String[] getSupportDocuments() {
		return supportDocuments;
	}

	public void setSupportDocuments(String[] supportDocuments) {
		this.supportDocuments = supportDocuments;
	}

	public String getPurchaseType() {
		return purchaseType;
	}

	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
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

	public Long getPurchaseID() {
		return purchaseID;
	}

	public void setPurchaseID(Long purchaseID) {
		this.purchaseID = purchaseID;
	}

	public Long getSeqRejectid() {
		return seqRejectid;
	}

	public void setSeqRejectid(Long seqRejectid) {
		this.seqRejectid = seqRejectid;
	}

	public String getRejectremarks() {
		return rejectremarks;
	}

	public void setRejectremarks(String rejectremarks) {
		this.rejectremarks = rejectremarks;
	}

	public String getRejectStatus() {
		return rejectStatus;
	}

	public void setRejectStatus(String rejectStatus) {
		this.rejectStatus = rejectStatus;
	}

	public String getFilterStatus() {
		return filterStatus;
	}

	public void setFilterStatus(String filterStatus) {
		this.filterStatus = filterStatus;
	}

	public Double getFreigntCharges() {
		return freigntCharges;
	}

	public void setFreigntCharges(Double freigntCharges) {
		this.freigntCharges = freigntCharges;
	}

	public Double getVatCharges() {
		return vatCharges;
	}

	public void setVatCharges(Double vatCharges) {
		this.vatCharges = vatCharges;
	}

	public Double getExciseCharges() {
		return exciseCharges;
	}

	public void setExciseCharges(Double exciseCharges) {
		this.exciseCharges = exciseCharges;
	}

	public Double getExcisePercent() {
		return excisePercent;
	}

	public void setExcisePercent(Double excisePercent) {
		this.excisePercent = excisePercent;
	}

	public Double getVatPercentage() {
		return vatPercentage;
	}

	public void setVatPercentage(Double vatPercentage) {
		this.vatPercentage = vatPercentage;
	}

	public Double getItemTotalCost() {
		return itemTotalCost;
	}

	public void setItemTotalCost(Double itemTotalCost) {
		this.itemTotalCost = itemTotalCost;
	}

	public Double getPoTotalcost() {
		return poTotalcost;
	}

	public void setPoTotalcost(Double poTotalcost) {
		this.poTotalcost = poTotalcost;
	}

	public Double getPackingFrwdCharges() {
		return packingFrwdCharges;
	}

	public void setPackingFrwdCharges(Double packingFrwdCharges) {
		this.packingFrwdCharges = packingFrwdCharges;
	}

	public String getRemarksPO() {
		return remarksPO;
	}

	public void setRemarksPO(String remarksPO) {
		this.remarksPO = remarksPO;
	}

	public String getRefundStatement() {
		return refundStatement;
	}

	public void setRefundStatement(String refundStatement) {
		this.refundStatement = refundStatement;
	}

	public Date getRefDate() {
		return refDate;
	}

	public void setRefDate(Date refDate) {
		this.refDate = refDate;
	}

	public String getQutRefNo() {
		return qutRefNo;
	}

	public void setQutRefNo(String qutRefNo) {
		this.qutRefNo = qutRefNo;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentRemarks() {
		return paymentRemarks;
	}

	public void setPaymentRemarks(String paymentRemarks) {
		this.paymentRemarks = paymentRemarks;
	}

	public Double getPaymentAmt() {
		return paymentAmt;
	}

	public void setPaymentAmt(Double paymentAmt) {
		this.paymentAmt = paymentAmt;
	}

	public Double getPoId() {
		return poId;
	}

	public void setPoId(Double poId) {
		this.poId = poId;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public Double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getSubContVendor() {
		return subContVendor;
	}

	public void setSubContVendor(String subContVendor) {
		this.subContVendor = subContVendor;
	}


	
	

	public Double getMatCost() {
		return matCost;
	}

	public void setMatCost(Double matCost) {
		this.matCost = matCost;
	}

	public String getSpecDetails() {
		return specDetails;
	}

	public void setSpecDetails(String specDetails) {
		this.specDetails = specDetails;
	}

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

	public Date getQuotationDate() {
		return quotationDate;
	}

	public void setQuotationDate(Date quotationDate) {
		this.quotationDate = quotationDate;
	}
	
	

}
