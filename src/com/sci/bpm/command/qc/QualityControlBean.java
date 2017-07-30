package com.sci.bpm.command.qc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sci.bpm.db.model.SciPurchaseMast;
import com.sci.bpm.db.model.SciQcDocs;
import com.sci.bpm.db.model.SciRawMIDetails;

/**
 * @author prakash
 *
 */
public class QualityControlBean implements Serializable {

	private String qcAppCnt;
	
	private String qcAppDime;
	private String qcTestsCond;
	private String qcFailReason;
	private String qcFailedCnt;
	private String qcFailedDim;
	private transient MultipartFile filedoc;
	private String issueCnt;
	private String approval = "N";
	private String qcTestsApproval;
	private String mirecommend;
	private String issueMI;
	private String requestMI;
	private String materialCode;
	private String materSpec;
	public Long seqMiID;
	private String qcDocnames;
	private List<SciQcDocs> qcdocs;
	private List<SciRawMIDetails> rawmis;
	private List<SciPurchaseMast> pomasters;
	private List<SciQcDocs> mydocs = new ArrayList<SciQcDocs>();
	private String miFortype;
	private String mattype;
	
	
	private Long seqQCId;
	private String 	dept;
	private Long reworkQnt;
	private String reworkDim;
	private String reworkStatus = "N";
	private String failedStatus = "N";
	private Long seqQcMiId;
	private Date fromdate;
	private Date todate;
	private String matCategory;
	private String matDept;
	private String seqWorkId;
	private String ocStatus;
	
	private String maxResults  = "500";
	
	public String getQcTestsApproval() {
		return qcTestsApproval;
	}
	public void setQcTestsApproval(String qcTestsApproval) {
		this.qcTestsApproval = qcTestsApproval;
	}
	public String getMaxResults() {
		return maxResults;
	}
	public void setMaxResults(String maxResults) {
		this.maxResults = maxResults;
	}
	public String getOcStatus() {
		return ocStatus;
	}
	public void setOcStatus(String ocStatus) {
		this.ocStatus = ocStatus;
	}
	public String getQcAppCnt() {
		return qcAppCnt;
	}
	public void setQcAppCnt(String qcAppCnt) {
		this.qcAppCnt = qcAppCnt;
	}
	public String getQcAppDime() {
		return qcAppDime;
	}
	public void setQcAppDime(String qcAppDime) {
		this.qcAppDime = qcAppDime;
	}
	public String getQcTestsCond() {
		return qcTestsCond;
	}
	public void setQcTestsCond(String qcTestsCond) {
		this.qcTestsCond = qcTestsCond;
	}
	public String getQcFailReason() {
		return qcFailReason;
	}
	public void setQcFailReason(String qcFailReason) {
		this.qcFailReason = qcFailReason;
	}
	public String getQcFailedCnt() {
		return qcFailedCnt;
	}
	public void setQcFailedCnt(String qcFailedCnt) {
		this.qcFailedCnt = qcFailedCnt;
	}
	public String getQcFailedDim() {
		return qcFailedDim;
	}
	public void setQcFailedDim(String qcFailedDim) {
		this.qcFailedDim = qcFailedDim;
	}
	public Long getSeqQcMiId() {
		return seqQcMiId;
	}
	public void setSeqQcMiId(Long seqQcMiId) {
		this.seqQcMiId = seqQcMiId;
	}
	public MultipartFile getFiledoc() {
		return filedoc;
	}
	public void setFiledoc(MultipartFile filedoc) {
		this.filedoc = filedoc;
	}
	public Long getSeqQCId() {
		return seqQCId;
	}
	public void setSeqQCId(Long seqQCId) {
		this.seqQCId = seqQCId;
	}
	public String getApproval() {
		return approval;
	}
	public void setApproval(String approval) {
		this.approval = approval;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Long getReworkQnt() {
		return reworkQnt;
	}
	public void setReworkQnt(Long reworkQnt) {
		this.reworkQnt = reworkQnt;
	}
	public String getReworkDim() {
		return reworkDim;
	}
	public void setReworkDim(String reworkDim) {
		this.reworkDim = reworkDim;
	}
	public String getReworkStatus() {
		return reworkStatus;
	}
	public void setReworkStatus(String reworkStatus) {
		this.reworkStatus = reworkStatus;
	}
	public String getFailedStatus() {
		return failedStatus;
	}
	public void setFailedStatus(String failedStatus) {
		this.failedStatus = failedStatus;
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
	public String getSeqWorkId() {
		return seqWorkId;
	}
	public void setSeqWorkId(String seqWorkId) {
		this.seqWorkId = seqWorkId;
	}
	public String getIssueMI() {
		return issueMI;
	}
	public void setIssueMI(String issueMI) {
		this.issueMI = issueMI;
	}
	public String getRequestMI() {
		return requestMI;
	}
	public void setRequestMI(String requestMI) {
		this.requestMI = requestMI;
	}
	
	
	public String getMirecommend() {
		return mirecommend;
	}
	public void setMirecommend(String mirecommend) {
		this.mirecommend = mirecommend;
	}
	public String getMaterialCode() {
		return materialCode;
	}
	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}
	public String getMaterSpec() {
		return materSpec;
	}
	public void setMaterSpec(String materSpec) {
		this.materSpec = materSpec;
	}
	public Long getSeqMiID() {
		return seqMiID;
	}
	public void setSeqMiID(Long seqMiID) {
		this.seqMiID = seqMiID;
	}
	public String getQcDocnames() {
		return qcDocnames;
	}
	public void setQcDocnames(String qcDocnames) {
		this.qcDocnames = qcDocnames;
	}
	public List<SciQcDocs> getQcdocs() {
		return qcdocs;
	}
	public void setQcdocs(List<SciQcDocs> qcdocs) {
		this.qcdocs = qcdocs;
	}
	public String getMiFortype() {
		return miFortype;
	}
	public void setMiFortype(String miFortype) {
		this.miFortype = miFortype;
	}
	public String getMattype() {
		return mattype;
	}
	public void setMattype(String mattype) {
		this.mattype = mattype;
	}
	public List<SciRawMIDetails> getRawmis() {
		return rawmis;
	}
	public void setRawmis(List<SciRawMIDetails> rawmis) {
		this.rawmis = rawmis;
	}
	public List<SciQcDocs> getMydocs() {
		return mydocs;
	}
	public void setMydocs(List<SciQcDocs> mydocs) {
		this.mydocs = mydocs;
	}
	

	public void addmydocs(List<SciQcDocs> rdocs) {
		this.mydocs.addAll(rdocs);
	}
	public List<SciPurchaseMast> getPomasters() {
		return pomasters;
	}
	public void setPomasters(List<SciPurchaseMast> pomasters) {
		this.pomasters = pomasters;
	}
	public String getIssueCnt() {
		return issueCnt;
	}
	public void setIssueCnt(String issueCnt) {
		this.issueCnt = issueCnt;
	}
	
	
}
