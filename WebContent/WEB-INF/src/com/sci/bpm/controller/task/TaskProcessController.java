package com.sci.bpm.controller.task;

import java.util.List;
import java.util.prefs.PreferenceChangeEvent;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.sci.bpm.command.task.TaskCommandBean;
import com.sci.bpm.command.user.UserPreference;
import com.sci.bpm.constants.SciDataConstans;
import com.sci.bpm.controller.base.SciBaseController;
import com.sci.bpm.db.model.SciIssueDetails;
import com.sci.bpm.db.model.SciIssueMaster;
import com.sci.bpm.service.task.TaskService;

@Controller("taskcontroller")
public class TaskProcessController extends SciBaseController {

	@Autowired
	private TaskService taskService;
	
	@Override
	public Event setupForm(RequestContext context) throws Exception
	{
		setFormObjectClass(TaskCommandBean.class);
		setFormObjectName("taskcommand");
	
		return super.setupForm(context);
		
		
	}
	
	public Event addNewTasks(RequestContext context) {
		
		try {
			TaskCommandBean bean = (TaskCommandBean)getFormObject(context);
			//String seqID = taskService.getNextSeqID();
			String assignto = StringUtils.join(bean.getAssignedTo(),",");
			SciIssueMaster issueMaster = new SciIssueMaster();
			//issueMaster.setSeqIssueId(new Long(seqID));
			UserPreference userpref = getUserPreferences();
			issueMaster.setIssueAssignedTo(userpref.getUserID());
			issueMaster.setIssueStatus(SciDataConstans.TASK_OPEN_STATUS);
		    issueMaster.setIssueAssignedTo(assignto);
		    issueMaster.setUpdatedBy(userpref.getUserID());
		    issueMaster.setIssueCreatedBy(userpref.getUserID());
		   issueMaster.setIssueOpenDate(new  java.util.Date());
		    issueMaster.setUpdatedDate(new java.util.Date());
		    SciIssueDetails issueDetails = new SciIssueDetails();
		    issueDetails.setIssueSubject(bean.getIssueSubject());
		    issueDetails.setIssueDetails(bean.getIssueDetails());
		    issueDetails.setAssignedDate(new java.util.Date());
		    issueDetails.setIssueStatus(SciDataConstans.TASK_OPEN_STATUS);
		    issueDetails.setAssignedFrom(userpref.getUserID());
		    issueDetails.setAssignedTo(assignto);
		    issueDetails.setUpdatedBy(userpref.getUserID());
		    issueDetails.setUpdatedDate(new java.util.Date());
		   
		    issueMaster.addIssueDetails(issueDetails);
		
		    taskService.addNewTask(issueMaster);
		
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return success();
	}
	
	public List searchMyTasks() {
		List mylist = null;
		try{
			 UserPreference userobject = getUserPreferences();
			 
			 mylist = taskService.searchTasks(SciDataConstans.TASK_OPEN_STATUS, 0,userobject.getUserID());
			 System.out.println("tasks" + mylist.size());
			
		}
		catch(Exception e) {
			
		}
		return mylist;
	}
	
	public Event loadTaskDetail(RequestContext context) {
		TaskCommandBean commandBean = null;
		try {
			commandBean = (TaskCommandBean) getFormObject(context);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String seqid = commandBean.getTaskid();
		
		SciIssueDetails details = taskService.loadDetails(seqid);
		System.out.println("");
		context.getFlowScope().put("mytask",details );
		return success();
	}
	
	public Event updateTask(RequestContext context) {
		TaskCommandBean commandBean = null;
		UserPreference userpref = getUserPreferences();
		try {
			commandBean = (TaskCommandBean) getFormObject(context);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SciIssueDetails newdetails = new SciIssueDetails();
		
		SciIssueDetails details = (SciIssueDetails) context.getFlowScope().get("mytask");
		SciIssueMaster master = details.getSciIssueMaster();
		
		master.setIssueAssignedTo(commandBean.getUpdateTo());
		master.setUpdatedBy(userpref.getUserID());
		master.setUpdatedDate(new java.util.Date());
		master.setIssueStatus(SciDataConstans.TASK_OPEN_STATUS);
;		newdetails.setSciIssueMaster(master);
		   newdetails.setIssueSubject(details.getIssueSubject());
		newdetails.setIssueDetails(commandBean.getIssueDetails());
		newdetails.setAssignedDate(new java.util.Date());
		newdetails.setIssueStatus(SciDataConstans.TASK_OPEN_STATUS);
		newdetails.setAssignedFrom(userpref.getUserID());
		newdetails.setAssignedTo(commandBean.getUpdateTo());
		newdetails.setUpdatedBy(userpref.getUserID());
		newdetails.setUpdatedDate(new java.util.Date());
	    taskService.forwardTasks(newdetails);
		return success();
	}
	
	public Event closeTask(RequestContext context) {
		TaskCommandBean commandBean = null;
		try {
			commandBean = (TaskCommandBean) getFormObject(context);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserPreference userpref = getUserPreferences();
		String seqid = commandBean.getTaskid();
		
		SciIssueDetails details = taskService.loadDetails(seqid);
		details.setIssueStatus(SciDataConstans.TASK_CLOSE_STATUS);
		String userid = details.getSciIssueMaster().getIssueCreatedBy();
		details.setUpdatedBy(userpref.getUserID());
		details.setUpdatedDate(new java.util.Date());
		SciIssueMaster master = details.getSciIssueMaster();
		master.setIssueStatus(SciDataConstans.TASK_CLOSE_STATUS);
		master.setIssueCloseDate(new java.util.Date());
		master.setUpdatedBy(userpref.getUserID());
		master.setUpdatedDate(new java.util.Date());
		details.setSciIssueMaster(master);
		System.out.println("creatpr " + userid);
		System.out.println("logon " + userpref.getUserID());
		if(userid.equals(userpref.getUserID())) {
			taskService.closeTasks(details);
			
		}
		return success();
	}
}
