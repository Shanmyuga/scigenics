package com.sci.bpm.service.lookup;

import java.util.List;
import java.util.Map;

import com.sci.bpm.db.model.SciCustomerMaster;
import com.sci.bpm.db.model.SciLookupMaster;
import com.sci.bpm.db.model.SciMasterItem;
import com.sci.bpm.db.model.SciMatspecMaster;
import com.sci.bpm.db.model.SciReportConfiguration;
import com.sci.bpm.db.model.SciVendorMaster;


public interface LookUpValueService {
	
	public List getDropDownValues(String queryKey);
	
	public boolean addNewValue(SciLookupMaster master);
	public Long loadIDData(String lovName);
	public boolean addNewItemValue(SciMasterItem master);
	public Map loadIDDescription();
	public void addNewMatSpec(SciMatspecMaster specmaster);
	public void addNewCustomer(SciCustomerMaster custmaster);
	public void addNewVendor(SciVendorMaster vendorMaster);
	public void updateVendor(SciVendorMaster vendorMaster);
	public void updateCustomer(SciCustomerMaster customerMaster);
	public  SciVendorMaster loadVendor(Long seqVendorId);
	public void addNewReport(SciReportConfiguration reportConfig);
	public List<SciReportConfiguration> loadReports();
	public void updateStatus(SciReportConfiguration config);
}
