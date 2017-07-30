package com.sci.bpm.command.po;

import java.io.Serializable;

public class PurchaseStatusCommand implements Serializable {

	private String matCode;
	private String recdMatQty;
	private String recdMatDime;
	private String ordQty;
	private String ordDim;
	private String qcappQty;
	private String qcappdim;
	private String matType = null;
	private String matSpec = null;
	private String workorder = null;
	private String clientJob = null;
	private String poid;

	public String getMatCode() {
		return matCode;
	}
	public void setMatCode(String matCode) {
		this.matCode = matCode;
	}
	public String getRecdMatQty() {
		return recdMatQty;
	}
	public void setRecdMatQty(String recdMatQty) {
		this.recdMatQty = recdMatQty;
	}
	public String getRecdMatDime() {
		return recdMatDime;
	}
	public void setRecdMatDime(String recdMatDime) {
		this.recdMatDime = recdMatDime;
	}
	public String getOrdQty() {
		return ordQty;
	}
	public void setOrdQty(String ordQty) {
		this.ordQty = ordQty;
	}
	public String getOrdDim() {
		return ordDim;
	}
	public void setOrdDim(String ordDim) {
		this.ordDim = ordDim;
	}
	public String getQcappQty() {
		return qcappQty;
	}
	public void setQcappQty(String qcappQty) {
		this.qcappQty = qcappQty;
	}
	public String getQcappdim() {
		return qcappdim;
	}
	public void setQcappdim(String qcappdim) {
		this.qcappdim = qcappdim;
	}
	public String getMatType() {
		return matType;
	}
	public void setMatType(String matType) {
		this.matType = matType;
	}
	public String getMatSpec() {
		return matSpec;
	}
	public void setMatSpec(String matSpec) {
		this.matSpec = matSpec;
	}
	public PurchaseStatusCommand(String matCode,String matSpec,String matType, String ordQty,String qcappQty,String recdMatQty,
			String ordDim,String qcappdim,String recdMatDime ,String poid ,String workorder
			  ) { 
		super();
		this.matCode = matCode;
		this.recdMatQty = recdMatQty;
		this.recdMatDime = recdMatDime;
		this.ordQty = ordQty;
		this.ordDim = ordDim;
		this.qcappQty = qcappQty;
		this.qcappdim = qcappdim;
		this.matType = matType;
		this.matSpec = matSpec;
		this.workorder = workorder;
		this.poid = poid;
	}
	public String getWorkorder() {
		return workorder;
	}
	public void setWorkorder(String workorder) {
		this.workorder = workorder;
	}
	public String getClientJob() {
		return clientJob;
	}
	public void setClientJob(String clientJob) {
		this.clientJob = clientJob;
	}
	public String getPoid() {
		return poid;
	}
	public void setPoid(String poid) {
		this.poid = poid;
	}
	
	
}
