package com.sci.bpm.service.marketing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sci.bpm.command.marketing.EnqBean;
import com.sci.bpm.dao.marketing.EnquiryDAO;
import com.sci.bpm.db.model.SciEnquiryDetails;
import com.sci.bpm.db.model.SciEnquiryMaster;

@Service
@Transactional
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	private EnquiryDAO dao;
	public void addNewEnqMaster(SciEnquiryMaster master) {
	   
	 dao.addNewEnqMaster(master);
		
	}

	public void addNewEnquiryDetail(SciEnquiryDetails details,
			SciEnquiryMaster master) {
		dao.addNewEnquiryDetail(details, master);
		
	}

	public List loadEnquiryDetails(SciEnquiryMaster master) {
		// TODO Auto-generated method stub
		return dao.loadEnquiryDetails(master);
	}

	public List loadOpenEnquiry(EnqBean bean) {
		
		
		return dao.loadOpenEnquiry(bean);
	}

	public void closeEnquury(SciEnquiryMaster master) {
		dao.closeEnquury(master);
		
	}

	public void updateEnquiryMaster(SciEnquiryMaster master) {
		// TODO Auto-generated method stub
		dao.closeEnquury(master);
	}

}
