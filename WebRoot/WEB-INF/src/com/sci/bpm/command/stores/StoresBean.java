package com.sci.bpm.command.stores;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.sci.bpm.db.model.SciWorkorderMaster;

public class StoresBean implements Serializable {

	private Long seqItemId;

	private Long itemType;
	private Date itemRecdDate;
	private Long numberPassed;
	private Date qcApprDate;
	private Long seqPurchId;
	private Long seqAvailId;
	private String itemName;
	private Long currentCnt;
	private Date issuedDate;
	private BigDecimal issueCnt;
	
	
	private String issueDimension;
	private String remarks;
	private Long seqmiid;
	private Long seqStoreId;
	private String issuedTo;
	private String issueRemarks;
	private String itemRecdFull = "N";
	private Long seqSelectMIID;
	private Long selectedQCID;
	private String ocStatus;
	private String receivedDimen;
	private String miandcode;
	private String receivedCnt;
	private String availableCnt;
	private String availableDim;
	private String searchcriteria = "mi";
	private String toreturnQty;
	private String issuedStatus;
	private String toreturnDim;
	private String hasReturnQty;
	private Long seqIssueId;
	private String returnStatus;
	private String matCategory;
	private String matDept;
	private String storerequestStatus = "N";
	private Date fromdate;
	private SciWorkorderMaster wmaster;
	private Date todate;
	private Long seqStoreissueId;
	private String matcode;
	private String retQuantity;
	private String retDimension;
	private String prodRemarks;
	private String damagedStatus;
	private String closezeroItems;
	private String matCode;
	private Long seqWorkId;
	private Long seqVendorID;
	private String requestUserId;
	private int searchMax =1000;
	private String returnCriteria;
	private String isScrap;
	
	public Long getSeqVendorID() {
		return seqVendorID;
	}

	public void setSeqVendorID(Long seqVendorID) {
		this.seqVendorID = seqVendorID;
	}

	public Long getSeqWorkId() {
		return seqWorkId;
	}

	public void setSeqWorkId(Long seqWorkId) {
		this.seqWorkId = seqWorkId;
	}

	public String getIssuedTo() {
		return issuedTo;
	}

	public void setIssuedTo(String issuedTo) {
		this.issuedTo = issuedTo;
	}

	public Long getSeqItemId() {
		return seqItemId;
	}

	public void setSeqItemId(Long seqItemId) {
		this.seqItemId = seqItemId;
	}

	public Long getItemType() {
		return itemType;
	}

	public void setItemType(Long itemType) {
		this.itemType = itemType;
	}

	public Date getItemRecdDate() {
		return itemRecdDate;
	}

	public void setItemRecdDate(Date itemRecdDate) {
		this.itemRecdDate = itemRecdDate;
	}

	public Long getNumberPassed() {
		return numberPassed;
	}

	public void setNumberPassed(Long numberPassed) {
		this.numberPassed = numberPassed;
	}

	public Date getQcApprDate() {
		return qcApprDate;
	}

	public void setQcApprDate(Date qcApprDate) {
		this.qcApprDate = qcApprDate;
	}

	public Long getSeqPurchId() {
		return seqPurchId;
	}

	public void setSeqPurchId(Long seqPurchId) {
		this.seqPurchId = seqPurchId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Long getCurrentCnt() {
		return currentCnt;
	}

	public void setCurrentCnt(Long currentCnt) {
		this.currentCnt = currentCnt;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public BigDecimal getIssueCnt() {
		return issueCnt;
	}

	public void setIssueCnt(BigDecimal issueCnt) {
		this.issueCnt = issueCnt;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getReceivedDimen() {
		return receivedDimen;
	}

	public void setReceivedDimen(String receivedDimen) {
		this.receivedDimen = receivedDimen;
	}

	public String getReceivedCnt() {
		return receivedCnt;
	}

	public void setReceivedCnt(String receivedCnt) {
		this.receivedCnt = receivedCnt;
	}

	public Long getSeqmiid() {
		return seqmiid;
	}

	public void setSeqmiid(Long seqmiid) {
		this.seqmiid = seqmiid;
	}

	public Long getSeqStoreId() {
		return seqStoreId;
	}

	public void setSeqStoreId(Long seqStoreId) {
		this.seqStoreId = seqStoreId;
	}

	public String getIssueDimension() {
		return issueDimension;
	}

	public void setIssueDimension(String issueDimension) {
		this.issueDimension = issueDimension;
	}

	public String getIssueRemarks() {
		return issueRemarks;
	}

	public void setIssueRemarks(String issueRemarks) {
		this.issueRemarks = issueRemarks;
	}

	public String getItemRecdFull() {
		return itemRecdFull;
	}

	public void setItemRecdFull(String itemRecdFull) {
		this.itemRecdFull = itemRecdFull;
	}

	public Long getSeqSelectMIID() {
		return seqSelectMIID;
	}

	public void setSeqSelectMIID(Long seqSelectMIID) {
		this.seqSelectMIID = seqSelectMIID;
	}

	public Long getSelectedQCID() {
		return selectedQCID;
	}

	public void setSelectedQCID(Long selectedQCID) {
		this.selectedQCID = selectedQCID;
	}

	public String getOcStatus() {
		return ocStatus;
	}

	public void setOcStatus(String ocStatus) {
		this.ocStatus = ocStatus;
	}

	public String getAvailableCnt() {
		return availableCnt;
	}

	public void setAvailableCnt(String availableCnt) {
		this.availableCnt = availableCnt;
	}

	public String getAvailableDim() {
		return availableDim;
	}

	public void setAvailableDim(String availableDim) {
		this.availableDim = availableDim;
	}

	public String getMiandcode() {
		return miandcode;
	}

	public void setMiandcode(String miandcode) {
		this.miandcode = miandcode;
	}

	public String getSearchcriteria() {
		return searchcriteria;
	}

	public void setSearchcriteria(String searchcriteria) {
		this.searchcriteria = searchcriteria;
	}

	public String getToreturnQty() {
		return toreturnQty;
	}

	public void setToreturnQty(String toreturnQty) {
		this.toreturnQty = toreturnQty;
	}

	public String getToreturnDim() {
		return toreturnDim;
	}

	public void setToreturnDim(String toreturnDim) {
		this.toreturnDim = toreturnDim;
	}

	public String getIssuedStatus() {
		return issuedStatus;
	}

	public void setIssuedStatus(String issuedStatus) {
		this.issuedStatus = issuedStatus;
	}

	public void reset() {
		this.receivedCnt = null;
		this.receivedDimen = null;
		this.seqSelectMIID = null;
		this.seqItemId = null;
	}

	public String getHasReturnQty() {
		return hasReturnQty;
	}

	public void setHasReturnQty(String hasReturnQty) {
		this.hasReturnQty = hasReturnQty;
	}

	public Long getSeqAvailId() {
		return seqAvailId;
	}

	public void setSeqAvailId(Long seqAvailId) {
		this.seqAvailId = seqAvailId;
	}

	public Long getSeqIssueId() {
		return seqIssueId;
	}

	public void setSeqIssueId(Long seqIssueId) {
		this.seqIssueId = seqIssueId;
	}

	public String getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}

	public String getStorerequestStatus() {
		return storerequestStatus;
	}

	public void setStorerequestStatus(String storerequestStatus) {
		this.storerequestStatus = storerequestStatus;
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

	public String getMatcode() {
		return matcode;
	}

	public void setMatcode(String matcode) {
		this.matcode = matcode;
	}

	public SciWorkorderMaster getWmaster() {
		return wmaster;
	}

	public void setWmaster(SciWorkorderMaster wmaster) {
		this.wmaster = wmaster;
	}

	public Long getSeqStoreissueId() {
		return seqStoreissueId;
	}

	public void setSeqStoreissueId(Long seqStoreissueId) {
		this.seqStoreissueId = seqStoreissueId;
	}

	public String getRetQuantity() {
		return retQuantity;
	}

	public void setRetQuantity(String retQuantity) {
		this.retQuantity = retQuantity;
	}

	public String getRetDimension() {
		return retDimension;
	}

	public void setRetDimension(String retDimension) {
		this.retDimension = retDimension;
	}

	public String getProdRemarks() {
		return prodRemarks;
	}

	public void setProdRemarks(String prodRemarks) {
		this.prodRemarks = prodRemarks;
	}

	public String getDamagedStatus() {
		return damagedStatus;
	}

	public void setDamagedStatus(String damagedStatus) {
		this.damagedStatus = damagedStatus;
	}

	public String getClosezeroItems() {
		return closezeroItems;
	}

	public void setClosezeroItems(String closezeroItems) {
		this.closezeroItems = closezeroItems;
	}

	public String getRequestUserId() {
		return requestUserId;
	}

	public void setRequestUserId(String requestUserId) {
		this.requestUserId = requestUserId;
	}

	public int getSearchMax() {
		return searchMax;
	}

	public void setSearchMax(int searchMax) {
		this.searchMax = searchMax;
	}

	public String getReturnCriteria() {
		return returnCriteria;
	}

	public void setReturnCriteria(String returnCriteria) {
		this.returnCriteria = returnCriteria;
	}

	public String getIsScrap() {
		return isScrap;
	}

	public void setIsScrap(String isScrap) {
		this.isScrap = isScrap;
	}



	

	
	

}
