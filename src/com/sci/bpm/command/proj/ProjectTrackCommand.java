package com.sci.bpm.command.proj;

import java.io.Serializable;
import java.util.Date;

public class ProjectTrackCommand implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String phaseDetail;
	private Date estStdate;
	private Date estEnddate;
	private Date actualStdate;
	private Date actualEnddate;

	private Long seqWorkId;

	private Long phaseOrder;

	private Date fromdate;

	private Date todate;
	
	private String subPhaseName;
	
	private Date subEstStart;
	private Date subEstEnd;
	private Date subActStdate;
	private Date subActEnd;
	private Long phaseidx;
	private Long woTrackId;
	
	private Long estManhours;

	private String phaseDesc;
	private String taskDesc;
	private Long actManHours;
	
	private String isPhaseCompleted;
	
	private String costCategory;
	private String costRemarks;
	private Integer totalCost;
	private String approvedBy;
	public String getPhaseDetail() {
		return phaseDetail;
	}
	public void setPhaseDetail(String phaseDetail) {
		this.phaseDetail = phaseDetail;
	}
	
	public Date getEstStdate() {
		return estStdate;
	}
	public void setEstStdate(Date estStdate) {
		this.estStdate = estStdate;
	}
	
	public Date getEstEnddate() {
		return estEnddate;
	}
	public void setEstEnddate(Date estEnddate) {
		this.estEnddate = estEnddate;
	}
	
	public Date getActualStdate() {
		return actualStdate;
	}
	public void setActualStdate(Date actualStdate) {
		this.actualStdate = actualStdate;
	}
	public Date getActualEnddate() {
		return actualEnddate;
	}
	public void setActualEnddate(Date actualEnddate) {
		this.actualEnddate = actualEnddate;
	}
	public Long getPhaseOrder() {
		return phaseOrder;
	}
	public void setPhaseOrder(Long phaseOrder) {
		this.phaseOrder = phaseOrder;
	}
	public String getSubPhaseName() {
		return subPhaseName;
	}
	public void setSubPhaseName(String subPhaseName) {
		this.subPhaseName = subPhaseName;
	}
	public Date getSubEstStart() {
		return subEstStart;
	}
	public void setSubEstStart(Date subEstStart) {
		this.subEstStart = subEstStart;
	}
	public Date getSubEstEnd() {
		return subEstEnd;
	}
	public void setSubEstEnd(Date subEstEnd) {
		this.subEstEnd = subEstEnd;
	}
	public Date getSubActStdate() {
		return subActStdate;
	}
	public void setSubActStdate(Date subActStdate) {
		this.subActStdate = subActStdate;
	}
	public Date getSubActEnd() {
		return subActEnd;
	}
	public void setSubActEnd(Date subActEnd) {
		this.subActEnd = subActEnd;
	}
	public Long getPhaseidx() {
		return phaseidx;
	}
	public void setPhaseidx(Long phaseidx) {
		this.phaseidx = phaseidx;
	}
	public Long getWoTrackId() {
		return woTrackId;
	}
	public void setWoTrackId(Long woTrackId) {
		this.woTrackId = woTrackId;
	}
	public Long getEstManhours() {
		return estManhours;
	}
	public void setEstManhours(Long estManhours) {
		this.estManhours = estManhours;
	}
	public String getPhaseDesc() {
		return phaseDesc;
	}
	public void setPhaseDesc(String phaseDesc) {
		this.phaseDesc = phaseDesc;
	}
	public Long getActManHours() {
		return actManHours;
	}
	public void setActManHours(Long actManHours) {
		this.actManHours = actManHours;
	}
	public String getIsPhaseCompleted() {
		return isPhaseCompleted;
	}
	public void setIsPhaseCompleted(String isPhaseCompleted) {
		this.isPhaseCompleted = isPhaseCompleted;
	}
	public String getTaskDesc() {
		return taskDesc;
	}
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	public String getCostCategory() {
		return costCategory;
	}
	public void setCostCategory(String costCategory) {
		this.costCategory = costCategory;
	}
	public String getCostRemarks() {
		return costRemarks;
	}
	public void setCostRemarks(String costRemarks) {
		this.costRemarks = costRemarks;
	}
	public Integer getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}
	public String getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
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

	public Long getSeqWorkId() {
		return seqWorkId;
	}

	public void setSeqWorkId(Long seqWorkId) {
		this.seqWorkId = seqWorkId;
	}
}
