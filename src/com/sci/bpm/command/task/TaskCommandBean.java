package com.sci.bpm.command.task;

import java.io.Serializable;

public class TaskCommandBean implements Serializable{


	private String issueStatus;
	private String issueSubject;
	private String issueDetails;
	private String[] assignedTo;
private String updateTo;
	private String taskid;
	
	
	
	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	public String getIssueDetails() {
		return issueDetails;
	}

	public void setIssueDetails(String issueDetails) {
		this.issueDetails = issueDetails;
	}

	public String getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}

	public String getIssueSubject() {
		return issueSubject;
	}

	public void setIssueSubject(String issueSubject) {
		this.issueSubject = issueSubject;
	}

	public String[] getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String[] assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getUpdateTo() {
		return updateTo;
	}

	public void setUpdateTo(String updateTo) {
		this.updateTo = updateTo;
	}

	
	
	
}
