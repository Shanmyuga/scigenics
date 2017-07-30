package com.sci.bpm.service.task;

import java.util.List;
import java.util.Map;

import com.sci.bpm.db.model.SciIssueDetails;
import com.sci.bpm.db.model.SciIssueMaster;
import com.sci.bpm.db.model.SciReportConfiguration;

public interface TaskService {

	
	public boolean addNewTask(SciIssueMaster master);
	
	
	public boolean forwardTasks(SciIssueDetails issueDetails);
	
	public boolean closeTasks(SciIssueDetails issueDetails);
	
	public boolean esclateTasks(SciIssueDetails  details);
	
	public List loadForEscalation(int numberOfdays);
	
	public List searchTasks(String status ,int startpage,String userid);
	public SciIssueDetails loadDetails(String seqid);
	
	public String getNextSeqID();
	public Map<String,Map<Integer,String>> getReportCount();
	
	public List<Map<Integer,String>>  getWOTotalCount();
	public void generateReports();
	public void generateWeeklyReports();
	
	public void runSelectedReport(SciReportConfiguration configuration);
}
