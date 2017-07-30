package com.sci.bpm.service.mi;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sci.bpm.command.mi.MatindCommand;
import com.sci.bpm.dao.mi.ISciMatindMasterDAO;
import com.sci.bpm.db.model.SciMatindMaster;
import com.sci.bpm.db.model.SciStoresRequest;
import com.sci.bpm.db.model.SciSubcontJobstatus;


@Service
@Transactional
public class MaterialIndentServiceImpl implements MaterialIndentService {

	@Autowired
	private ISciMatindMasterDAO daoimpl;
	
	
	public void addNewMI(SciMatindMaster master) {
		
	daoimpl.save(master);
	}

	
	public List<SciMatindMaster> searchMI(MatindCommand command) {
		List<SciMatindMaster> milist = daoimpl.searchMI(command);
		for(SciMatindMaster miitem:milist) {
		//SciMatindMaster fullmi= daoimpl.loadMI(miitem.getSeqMiId());
		
			//miitem.setMatDuedate(fullmi.getMatDuedate());
			//miitem.setSciWorkorderMaster(fullmi.getSciWorkorderMaster());
			
		
			miitem.setTempunitCost(daoimpl.loadLatestUnitCost(miitem));
		}
		return milist;
	}
	
	public void updateMI(SciMatindMaster master) {
		// TODO Auto-generated method stub
		daoimpl.updateMI(master);
	}
	
	public List searchMIWorkOrder(SciMatindMaster command,MatindCommand comm) {
		
		return daoimpl.searchMIByWorkOrder(command,comm);
	}
	
	public void approveMI(String seqmilist, String approvedBy) {
		// TODO Auto-generated method stub
		daoimpl.approveMI(seqmilist, approvedBy);
	}
	
	public void cancelMI(SciMatindMaster master) {
		daoimpl.cancelMI(master);
	}
	
	
	public List selectDesignDocs(SciMatindMaster command) {
		// TODO Auto-generated method stub
		return daoimpl.selectDesignDocs(command);
	}
	
	
	public List loadOpenMI(SciMatindMaster command) {
		// TODO Auto-generated method stub
		return daoimpl.loadOpenMI(command);
	}

	public void addStoreRequest(SciStoresRequest request) {
		daoimpl.addStoreRequest(request);
		
	}


	public List loadStoreRequest(MatindCommand command) {
		return daoimpl.loadStoreRequest(command);
		
	}


	public List loadforAppProdStRequest(MatindCommand command) {
		return daoimpl.loadforAppProdStRequest(command);
		
	}


	public List loadforAppPurchStRequest(MatindCommand command) {
		return daoimpl.loadforAppPurchStRequest(command);
		
	}


	public SciMatindMaster loadMI(Long seqmiID) {
		// TODO Auto-generated method stub
		return daoimpl.loadMI(seqmiID);
	}


	public void updateStoreRequest(SciStoresRequest request) {
		daoimpl.updateStoreRequest(request);
		
	}


	public void approveMilist(List<SciMatindMaster> milist) {
		daoimpl.approveMilist(milist);
		
	}


	public void updateFullMi(SciMatindMaster request) {
		daoimpl.update(request);
		
	}


	public void mergeMI(SciMatindMaster master) {
		daoimpl.mergeMI(master);
		
	}


	public List loadStoreRequestIssue(MatindCommand command) {
		// TODO Auto-generated method stub
		return daoimpl.loadStoreRequestIssue(command);
	}


	public List loadStoreRequestFilters(MatindCommand command) {
		// TODO Auto-generated method stub
		return daoimpl.loadStoreRequestFilters(command);
	}


	public void addSubContStatus(SciSubcontJobstatus jobstatus) {
		// TODO Auto-generated method stub
		daoimpl.addSubContStatus(jobstatus);
	}


	public List<SciSubcontJobstatus> getRecentSubcontJobStatus(Long seqWorkID) {
		// TODO Auto-generated method stub
		return daoimpl.getRecentSubcontJobStatus(seqWorkID);
	}


	public List<SciSubcontJobstatus> getLoadDetails(Long jobCode,
			String jobType, Long seqWorkId) {
		// TODO Auto-generated method stub
		return daoimpl.getLoadDetails(jobCode, jobType, seqWorkId);
	}


	

}
