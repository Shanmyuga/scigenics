package com.sci.bpm.service.lookup;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sci.bpm.dao.lookup.LookupValueDAO;
import com.sci.bpm.db.model.SciCustomerMaster;
import com.sci.bpm.db.model.SciLookupMaster;
import com.sci.bpm.db.model.SciMasterItem;
import com.sci.bpm.db.model.SciMatspecMaster;
import com.sci.bpm.db.model.SciReportConfiguration;
import com.sci.bpm.db.model.SciVendorMaster;

@Service
@Transactional
public class LookupValueServiceImpl implements LookUpValueService {

	@Autowired
	private LookupValueDAO daoimpl;
	
	
	public List getDropDownValues(String queryKey) {
		
		
		return daoimpl.getDropDownList(queryKey);
	}
	
	public boolean addNewValue(SciLookupMaster master) {
		
		return daoimpl.addNewValue(master);
	}

	
	public Long loadIDData(String lovName) {
		return daoimpl.lookupId(lovName);
	}
	
	
	public Long loadIDDestc(String lovName) {
		return daoimpl.lookupId(lovName);
	}
	
	
	public Map loadIDDescription() {
		
		return daoimpl.loadDesc();
	}
	
	
	public boolean addNewItemValue(SciMasterItem master) {
		
		return daoimpl.addNewItemValue(master);
	}
	public void addNewCustomer(SciCustomerMaster custmaster) {
		daoimpl.addNewCustomer(custmaster);
		
	}
	public void addNewMatSpec(SciMatspecMaster specmaster) {
		daoimpl.addNewMatSpec(specmaster);
		
	}
	public void addNewVendor(SciVendorMaster vendorMaster) {
		
		daoimpl.addNewVendor(vendorMaster);
	}

	@Override
	public void updateVendor(SciVendorMaster vendorMaster) {
		daoimpl.updateVendor(vendorMaster);
	}

	@Override
	public void updateCustomer(SciCustomerMaster customerMaster) {
		daoimpl.updateCustomer(customerMaster);
	}

	@Override
	public SciVendorMaster loadVendor(Long seqVendorId) {

		return daoimpl.loadVendor(seqVendorId);
	}

	public void addNewReport(SciReportConfiguration reportConfig) {
		// TODO Auto-generated method stub
		daoimpl.addNewReport(reportConfig);
	}

	public List<SciReportConfiguration> loadReports() {
		// TODO Auto-generated method stub
		return daoimpl.loadReports();
	}

	public void updateStatus(SciReportConfiguration config) {
		// TODO Auto-generated method stub
		daoimpl.updateStatus(config);
	}
	
	
}
