package com.sci.bpm.service.marketing;

import java.util.List;

import com.sci.bpm.command.user.UserPreference;
import com.sci.bpm.constants.SciDataConstans;
import com.sci.bpm.dao.task.TaskProcessDAO;
import com.sci.bpm.db.model.SciIssueDetails;
import com.sci.bpm.db.model.SciIssueMaster;
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
			issueDetails.setIssueSubject(master.getCustomerContact());
			issueDetails.setIssueDetails(master.getEnqDetails());
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

}
