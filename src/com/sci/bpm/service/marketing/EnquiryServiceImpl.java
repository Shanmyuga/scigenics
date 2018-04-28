package com.sci.bpm.service.marketing;

import java.util.List;

import com.sci.bpm.command.user.UserPreference;
import com.sci.bpm.constants.SciDataConstans;
import com.sci.bpm.dao.task.TaskProcessDAO;
import com.sci.bpm.db.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sci.bpm.command.marketing.EnqBean;
import com.sci.bpm.dao.marketing.EnquiryDAO;

@Service
@Transactional
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	private EnquiryDAO dao;

	@Autowired
	private TaskProcessDAO taskDao;
	public void addNewEnqMaster(SciEnquiryMaster master,boolean isTaskRequired) {


		dao.addNewEnqMaster(master);
		if(isTaskRequired) {
			SciIssueMaster issueMaster = new SciIssueMaster();
			//issueMaster.setSeqIssueId(new Long(seqID));
			String userid = master.getInsertedBy();
			issueMaster.setIssueAssignedTo(master.getInsertedBy());
			issueMaster.setIssueStatus(SciDataConstans.TASK_OPEN_STATUS);
			issueMaster.setIssueAssignedTo("marketingmanager");
			issueMaster.setUpdatedBy(userid);
			issueMaster.setIssueCreatedBy(userid);
			issueMaster.setIssueOpenDate(new java.util.Date());
			issueMaster.setUpdatedDate(new java.util.Date());
			taskDao.addNewTask(issueMaster);
			SciIssueDetails issueDetails = new SciIssueDetails();

			String customerDetails = master.getSciCustomerMaster().getCustomerName() + " " + master.getSciCustomerMaster().getCustomerDetails() + master.getCustomerContact();
					String enqDetails = master.getEnqCategory() + "  " + master.getEnqDetails();
			issueDetails.setIssueSubject(customerDetails);
			issueDetails.setIssueDetails(enqDetails);
			issueDetails.setAssignedDate(new java.util.Date());
			issueDetails.setIssueStatus(SciDataConstans.TASK_OPEN_STATUS);
			issueDetails.setAssignedFrom(userid);
			issueDetails.setAssignedTo("marketingmanager");
			issueDetails.setUpdatedBy(userid);
			issueDetails.setUpdatedDate(new java.util.Date());


			issueDetails.setSciIssueMaster(issueMaster);

			taskDao.addNewDetails(issueDetails);

		}
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

	@Override
	public void addEnquiryDocMaster(SciEnquiryDocs enquiryDocs) {

		dao.addEnquiryDocMaster(enquiryDocs);
	}

	@Override
	public List loadEnquiryDocs(SciEnquiryMaster enquiryMaster) {
		return dao.loadEnquiryDocs(enquiryMaster);
	}

}
