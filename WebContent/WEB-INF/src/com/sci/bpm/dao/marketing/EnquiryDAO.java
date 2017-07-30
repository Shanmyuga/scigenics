package com.sci.bpm.dao.marketing;

import java.util.List;

import com.sci.bpm.command.marketing.EnqBean;
import com.sci.bpm.db.model.SciEnquiryDetails;
import com.sci.bpm.db.model.SciEnquiryMaster;

public interface EnquiryDAO {
	public List loadOpenEnquiry(EnqBean bean);
	
	public void addNewEnqMaster(SciEnquiryMaster master);
	
	public void addNewEnquiryDetail(SciEnquiryDetails details,SciEnquiryMaster master);
	
	public List loadEnquiryDetails(SciEnquiryMaster master);
	public void closeEnquury(SciEnquiryMaster master);
	
	public void updateEnquiryMaster(SciEnquiryMaster master);
}
