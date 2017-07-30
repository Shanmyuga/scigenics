package com.sci.bpm.command.mi;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jboss.util.collection.LazyList;

import com.sci.bpm.db.model.SciWorkorderMaster;

public class MatindCommand implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String seqWorkId;
	private Long matType;
	private String matSpec;
	private String matDesc;
	private BigDecimal matQty;
	private Date matDuedate;
	private String matDimesion;
	private String recommend;
	private Long purStatus;
	private String poDetails;
	private String preparedBy;
	private String approvedBy;
	private String updatedBy;
	private Date updatedDate;
	private String designRef;
	private String drawingRef;
	private String approvalStatus;
	private Long miindexID;
	private Long seqScjobIdkey;
	private String[] miindex;
	private String[] miindex2;
	private Date[] modduedate;
	private String productCat;
	private String rowindex;
	private Long seqprodID;
	private String strapproval;
	private String remarks;
	private List<MatCollectionCommand> matList = new ArrayList();
	private String dept;
	private String specdesc;
	private String selectedIdx;
	private String matCategory;
	private String matDept;
	private SciWorkorderMaster wm;
	private String matCodeselected;
	private String ststatus;
	private String rolelevel;
	private String oldQCId;
	private String stIssued;
	private Date fromdate;
	private Date todate;
	private int searchMax = 1000;
	private String prodAppStatus;
	private Long seqMatindid;
	private String reopenRequest;
	private String purAppStatus;
	private String estunitCostStatus;
	private String createdByUser;
	private String jobType;
	private Long jobCode;
	private String status;
	public String[] purStatusarr;
	private Date sentDate;
	private Date receivedDate;
	private Date estimatedReturnDate;
	private String remarksColumn;
	private Long seqVendorID;
	private Date offLoadingDate;
	private String cancelStatus;
	private Long cancelStatusLov;
	private String filterIssued;
	private String filterRejected;
    private Double quantity;
	
	private String moc;
	private Integer noOfDays;
	private String operationStatus;
	private Long operation;
	
	public String getProdAppStatus() {
		return prodAppStatus;
	}

	public void setProdAppStatus(String prodAppStatus) {
		this.prodAppStatus = prodAppStatus;
	}

	public String getPurAppStatus() {
		return purAppStatus;
	}

	public void setPurAppStatus(String purAppStatus) {
		this.purAppStatus = purAppStatus;
	}

	private String issueAcceptance;
	
	
	
	
	public int getSearchMax() {
		return searchMax;
	}

	public void setSearchMax(int searchMax) {
		this.searchMax = searchMax;
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

	public String getIssueAcceptance() {
		return issueAcceptance;
	}

	public void setIssueAcceptance(String issueAcceptance) {
		this.issueAcceptance = issueAcceptance;
	}

	public String getAcceptedBy() {
		return acceptedBy;
	}

	public void setAcceptedBy(String acceptedBy) {
		this.acceptedBy = acceptedBy;
	}

	private String acceptedBy;
	
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getRowindex() {
		return rowindex;
	}

	public void setRowindex(String rowindex) {
		this.rowindex = rowindex;
	}

	public String getProductCat() {
		return productCat;
	}

	public void setProductCat(String productCat) {
		this.productCat = productCat;
	}

	public Long getSeqprodID() {
		return seqprodID;
	}

	public void setSeqprodID(Long seqprodID) {
		this.seqprodID = seqprodID;
	}

	public Long getMiindexID() {
		return miindexID;
	}

	public void setMiindexID(Long miindexID) {
		this.miindexID = miindexID;
	}

	public String[] getMiindex() {
		return miindex;
	}

	public void setMiindex(String[] miindex) {
		this.miindex = miindex;
	}

	public Long getMatType() {
		return matType;
	}

	public void setMatType(Long matType) {
		this.matType = matType;
	}

	public String getMatSpec() {
		return matSpec;
	}

	public void setMatSpec(String matSpec) {
		this.matSpec = matSpec;
	}

	public String getMatDesc() {
		return matDesc;
	}

	public void setMatDesc(String matDesc) {
		this.matDesc = matDesc;
	}

	public BigDecimal getMatQty() {
		return matQty;
	}

	public void setMatQty(BigDecimal matQty) {
		this.matQty = matQty;
	}

	public Date getMatDuedate() {
		return matDuedate;
	}

	public void setMatDuedate(Date matDuedate) {
		this.matDuedate = matDuedate;
	}

	public String getMatDimesion() {
		return matDimesion;
	}

	public void setMatDimesion(String matDimesion) {
		this.matDimesion = matDimesion;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public Long getPurStatus() {
		return purStatus;
	}

	public void setPurStatus(Long purStatus) {
		this.purStatus = purStatus;
	}

	public String getPoDetails() {
		return poDetails;
	}

	public void setPoDetails(String poDetails) {
		this.poDetails = poDetails;
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

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getDesignRef() {
		return designRef;
	}

	public void setDesignRef(String designRef) {
		this.designRef = designRef;
	}

	public String getDrawingRef() {
		return drawingRef;
	}

	public void setDrawingRef(String drawingRef) {
		this.drawingRef = drawingRef;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public MatindCommand() {

		super();
		for (int idx = 0; idx < 11; idx++) {
			this.matList.add(new MatCollectionCommand());
		}
	}

	public List<MatCollectionCommand> getMatList() {
		return matList;
	}

	public void setMatList(List<MatCollectionCommand> matList) {
		this.matList = matList;
	}

	public String getStrapproval() {
		return strapproval;
	}

	public void setStrapproval(String strapproval) {
		this.strapproval = strapproval;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSpecdesc() {
		return specdesc;
	}

	public void setSpecdesc(String specdesc) {
		this.specdesc = specdesc;
	}

	public String getMatCodeselected() {
		return matCodeselected;
	}

	public void setMatCodeselected(String matCodeselected) {
		this.matCodeselected = matCodeselected;
	}

	public String getSelectedIdx() {
		return selectedIdx;
	}

	public void setSelectedIdx(String selectedIdx) {
		this.selectedIdx = selectedIdx;
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

	public Date[] getModduedate() {
		return modduedate;
	}

	public void setModduedate(Date[] modduedate) {
		this.modduedate = modduedate;
	}

	public SciWorkorderMaster getWm() {
		return wm;
	}

	public void setWm(SciWorkorderMaster wm) {
		this.wm = wm;
	}

	public String getSeqWorkId() {
		return seqWorkId;
	}

	public void setSeqWorkId(String seqWorkId) {
		this.seqWorkId = seqWorkId;
	}

	public String getStstatus() {
		return ststatus;
	}

	public void setStstatus(String ststatus) {
		this.ststatus = ststatus;
	}

	public String getRolelevel() {
		return rolelevel;
	}

	public void setRolelevel(String rolelevel) {
		this.rolelevel = rolelevel;
	}

	public String getOldQCId() {
		return oldQCId;
	}

	public void setOldQCId(String oldQCId) {
		this.oldQCId = oldQCId;
	}

	public String getStIssued() {
		return stIssued;
	}

	public void setStIssued(String stIssued) {
		this.stIssued = stIssued;
	}

	public Long getSeqMatindid() {
		return seqMatindid;
	}

	public void setSeqMatindid(Long seqMatindid) {
		this.seqMatindid = seqMatindid;
	}

	public String getReopenRequest() {
		return reopenRequest;
	}

	public void setReopenRequest(String reopenRequest) {
		this.reopenRequest = reopenRequest;
	}

	public String[] getMiindex2() {
		return miindex2;
	}

	public void setMiindex2(String[] miindex2) {
		this.miindex2 = miindex2;
	}

	public String getEstunitCostStatus() {
		return estunitCostStatus;
	}

	public void setEstunitCostStatus(String estunitCostStatus) {
		this.estunitCostStatus = estunitCostStatus;
	}

	public String getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(String createdByUser) {
		this.createdByUser = createdByUser;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		System.out.println("inside jobType " + jobType);
		this.jobType = jobType;
	}

	public Long getJobCode() {
		return jobCode;
	}

	public void setJobCode(Long jobCode) {
		this.jobCode = jobCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public Date getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}

	
	
	
	public Date getEstimatedReturnDate() {
		return estimatedReturnDate;
	}

	public void setEstimatedReturnDate(Date estimatedReturnDate) {
		this.estimatedReturnDate = estimatedReturnDate;
	}

	public String getRemarksColumn() {
		return remarksColumn;
	}

	public void setRemarksColumn(String remarksColumn) {
		this.remarksColumn = remarksColumn;
	}

	public Long getSeqVendorID() {
		return seqVendorID;
	}

	public void setSeqVendorID(Long seqVendorID) {
		this.seqVendorID = seqVendorID;
	}

	public Date getOffLoadingDate() {
		return offLoadingDate;
	}

	public void setOffLoadingDate(Date offLoadingDate) {
		this.offLoadingDate = offLoadingDate;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getMoc() {
		return moc;
	}

	public void setMoc(String moc) {
		this.moc = moc;
	}

	public Integer getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(Integer noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getOperationStatus() {
		return operationStatus;
	}

	public void setOperationStatus(String operationStatus) {
		this.operationStatus = operationStatus;
	}

	public Long getOperation() {
		return operation;
	}

	public void setOperation(Long operation) {
		this.operation = operation;
	}

	public Long getSeqScjobIdkey() {
		return seqScjobIdkey;
	}

	public void setSeqScjobIdkey(Long seqScjobIdkey) {
		this.seqScjobIdkey = seqScjobIdkey;
	}

	public String[] getPurStatusarr() {
		return purStatusarr;
	}

	public void setPurStatusarr(String[] purStatusarr) {
		this.purStatusarr = purStatusarr;
	}

	
	public String getPurchasestatuses() {
		return StringUtils.join(purStatusarr, ",");
	}

	public String getCancelStatus() {
		return cancelStatus;
	}

	public void setCancelStatus(String cancelStatus) {
		this.cancelStatus = cancelStatus;
	}

	public Long getCancelStatusLov() {
		return cancelStatusLov;
	}

	public void setCancelStatusLov(Long cancelStatusLov) {
		this.cancelStatusLov = cancelStatusLov;
	}

	public String getFilterIssued() {
		return filterIssued;
	}

	public void setFilterIssued(String filterIssued) {
		this.filterIssued = filterIssued;
	}

	public String getFilterRejected() {
		return filterRejected;
	}

	public void setFilterRejected(String filterRejected) {
		this.filterRejected = filterRejected;
	}

	

}
