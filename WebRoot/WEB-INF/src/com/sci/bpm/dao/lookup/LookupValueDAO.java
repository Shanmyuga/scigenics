package com.sci.bpm.dao.lookup;

import java.util.List;
import java.util.Map;

import com.sci.bpm.db.model.SciCustomerMaster;
import com.sci.bpm.db.model.SciLookupMaster;
import com.sci.bpm.db.model.SciMasterItem;
import com.sci.bpm.db.model.SciMatspecMaster;
import com.sci.bpm.db.model.SciReportConfiguration;
import com.sci.bpm.db.model.SciVendorMaster;

public interface LookupValueDAO {

	
	public List getDropDownList(String query);
	
	public boolean addNewValue(SciLookupMaster master);

	public Long lookupId(String lovname);
	public boolean addNewItemValue(SciMasterItem master);
	public Map loadDesc();
	public void addNewReport(SciReportConfiguration reportConfig);
	public void addNewMatSpec(SciMatspecMaster specmaster);
	public void addNewCustomer(SciCustomerMaster custmaster);
	public void addNewVendor(SciVendorMaster vendorMaster);
	public List<SciReportConfiguration> loadReports();
	public void updateStatus(SciReportConfiguration config);
}
