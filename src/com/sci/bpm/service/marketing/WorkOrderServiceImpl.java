package com.sci.bpm.service.marketing;

import java.util.List;
import java.util.Map;

import com.sci.bpm.chart.model.ChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sci.bpm.dao.marketing.ISciWorkorderMasterDAO;
import com.sci.bpm.db.model.SciAmendmentMaster;
import com.sci.bpm.db.model.SciCustomerMaster;
import com.sci.bpm.db.model.SciJdrDocs;
import com.sci.bpm.db.model.SciWorkorderMaster;

@Transactional
@Service
public class WorkOrderServiceImpl implements WorkOrderService {

	@Autowired
	private ISciWorkorderMasterDAO daoimpl;
	
	public void createAmendments() {
		// TODO Auto-generated method stub

	}

	public void createWorkOrder(SciWorkorderMaster workMaster) {
		// TODO Auto-generated method stub
		daoimpl.save(workMaster);
	}

	public void updateAmendments() {
		// TODO Auto-generated method stub

	}


	
    
	public List searchWorkOrder() {
		// TODO Auto-generated method stub
		return daoimpl.searchWork();
	}

	public void addAmendment(SciAmendmentMaster master) {
		// TODO Auto-generated method stub
		daoimpl.addAmendment(master);
	}

	public List<SciAmendmentMaster> searchAmend(SciWorkorderMaster master) {
		// TODO Auto-generated method stub
		return daoimpl.searchAmend(master);
	}

	public void addWorkOrderwithDetails(Map workbeans) {
		 daoimpl.addWorkOrderwithDetails(workbeans);
		
	}

	public List<SciJdrDocs> getJDRDocs(Long seqWorkId) {
		// TODO Auto-generated method stub
		return daoimpl.getJDRDocs(seqWorkId);
	}

	public void addJDRDcos(SciJdrDocs docmaster) {
		daoimpl.addJDRDcos(docmaster);
		
	}

	public SciCustomerMaster loadCustomer(Long seqCustID) {
		// TODO Auto-generated method stub
		return daoimpl.loadCustomer(seqCustID);
	}

	public void closeWO(SciWorkorderMaster wm,Long seqLovID) {
		// TODO Auto-generated method stub
		daoimpl.updateWO(wm,seqLovID);
	}

	@Override
	public List<ChartModel> getWorkOrderCostStats(Long seqWorkId) {
		return daoimpl.getWorkOrderCostStats(seqWorkId);
	}

}
