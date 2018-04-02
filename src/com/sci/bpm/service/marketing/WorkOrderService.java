package com.sci.bpm.service.marketing;

import java.util.List;
import java.util.Map;

import com.sci.bpm.chart.model.ChartModel;
import com.sci.bpm.db.model.SciAmendmentMaster;
import com.sci.bpm.db.model.SciCustomerMaster;
import com.sci.bpm.db.model.SciJdrDocs;
import com.sci.bpm.db.model.SciWorkorderMaster;

public interface WorkOrderService {

	public void createWorkOrder(SciWorkorderMaster workMaster);
	
	public List<SciWorkorderMaster> searchWorkOrder();
	
public List<SciAmendmentMaster> searchAmend(SciWorkorderMaster master);
	
	public void addAmendment(SciAmendmentMaster master);
	
	public void addWorkOrderwithDetails(Map workbeans);
	
	public List<SciJdrDocs> getJDRDocs(Long seqWorkId);
	
	public void addJDRDcos(SciJdrDocs docmaster);
	
	public SciCustomerMaster loadCustomer(Long seqCustID);
	
	public void closeWO(SciWorkorderMaster wm,Long seqLovID);

	public List<ChartModel> getWorkOrderCostStats(Long seqWorkId);
	
}
