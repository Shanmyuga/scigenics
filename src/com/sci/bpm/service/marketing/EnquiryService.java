package com.sci.bpm.service.marketing;

import java.util.List;

import com.sci.bpm.command.marketing.EnqBean;
import com.sci.bpm.db.model.SciEnquiryDetails;
import com.sci.bpm.db.model.SciEnquiryDocs;
import com.sci.bpm.db.model.SciEnquiryMaster;

public interface EnquiryService {

	public List loadOpenEnquiry(EnqBean bean);
	
	public void addNewEnqMaster(SciEnquiryMaster master,boolean isTaskRequired);
	
	public void addNewEnquiryDetail(SciEnquiryDetails details,SciEnquiryMaster master);
	
	public List loadEnquiryDetails(SciEnquiryMaster master);
	
	public void closeEnquury(SciEnquiryMaster master);
	
	public void updateEnquiryMaster(SciEnquiryMaster master);

	public void addEnquiryDocMaster(SciEnquiryDocs enquiryDocs);
	public List loadEnquiryDocs(SciEnquiryMaster enquiryMaster);
}
