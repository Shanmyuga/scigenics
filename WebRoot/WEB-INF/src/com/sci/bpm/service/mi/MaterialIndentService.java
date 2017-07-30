package com.sci.bpm.service.mi;

import java.util.List;

import com.sci.bpm.command.mi.MatindCommand;
import com.sci.bpm.db.model.SciMatindMaster;
import com.sci.bpm.db.model.SciStoresRequest;
import com.sci.bpm.db.model.SciSubcontJobstatus;

public interface MaterialIndentService {

	
	public void addNewMI(SciMatindMaster master);
	
	public void addSubContStatus(SciSubcontJobstatus jobstatus);
	public List searchMI(MatindCommand command);
	public void approveMilist(List<SciMatindMaster> milist);
	public void approveMI(String seqmilist,String approvedBy);
	public List searchMIWorkOrder(SciMatindMaster command,MatindCommand comm);
	public void updateMI(SciMatindMaster master);
	public void mergeMI(SciMatindMaster master);
	public void cancelMI(SciMatindMaster master);
	
	public List selectDesignDocs(SciMatindMaster command);
	
	public List loadOpenMI(SciMatindMaster command);
	
	public void addStoreRequest(SciStoresRequest request);
	
	public List loadStoreRequest(MatindCommand command);
	public List loadStoreRequestFilters(MatindCommand command);
	public List loadStoreRequestIssue(MatindCommand command);
	public List loadforAppPurchStRequest(MatindCommand command);
	public List loadforAppProdStRequest(MatindCommand command);
	public SciMatindMaster loadMI(Long seqmiID);
	public void updateStoreRequest(SciStoresRequest request);
	public void updateFullMi(SciMatindMaster request);
	public List<SciSubcontJobstatus> getRecentSubcontJobStatus(Long seqWorkID);
	public List<SciSubcontJobstatus> getLoadDetails(Long jobCode,String jobType,Long seqWorkId);
	
	
}
