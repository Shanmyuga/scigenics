package com.sci.bpm.service.task;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.sci.bpm.constants.SciDataConstans;
import com.sci.bpm.db.model.SciIssueDetails;
import com.sci.bpm.db.model.SciIssueMaster;



public class EscalationService extends QuartzJobBean {


	
public TaskService getTservice() {
		return tservice;
	}

	public void setTservice(TaskService tservice) {
		this.tservice = tservice;
	}

private TaskService tservice;
	
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		
		Properties props = new Properties();
		System.out.println("shanmuga inside escalation");
		try {
			props.load(this.getClass().getResourceAsStream("escalationdetails.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<SciIssueDetails> opentasks = tservice.loadForEscalation(Integer.parseInt(props.getProperty("escalation.Interval")));
		System.out.println(opentasks.size());
		try {
			for(SciIssueDetails details:opentasks){
				SciIssueDetails newdetails = new SciIssueDetails();
				SciIssueMaster master = details.getSciIssueMaster();
				
				master.setIssueAssignedTo(props.getProperty("escalation.users"));
				master.setUpdatedBy("admin");
				
				master.setUpdatedDate(new java.util.Date());
				master.setIssueStatus("escalated");
;				newdetails.setSciIssueMaster(master);
				newdetails.setIssueSubject("Escalated - " + details.getIssueSubject());
				newdetails.setIssueDetails("Escalated -  " + details.getIssueDetails());
				newdetails.setAssignedDate(new java.util.Date());
				newdetails.setIssueStatus(SciDataConstans.TASK_ESCALATED_STATUS);
				newdetails.setAssignedFrom(details.getAssignedTo());
				newdetails.setAssignedTo(props.getProperty("escalation.users"));
				newdetails.setUpdatedBy("admin");
				newdetails.setUpdatedDate(new java.util.Date());
				
				tservice.esclateTasks(newdetails);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

public void escalateTask() {
	System.out.println("inside escalation");
}

}
