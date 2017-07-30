package com.sci.bpm.dao.task;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sci.bpm.db.model.SciIssueDetails;
import com.sci.bpm.db.model.SciIssueMaster;
import com.sci.bpm.db.model.SciReportConfiguration;

public interface TaskProcessDAO {

	public boolean addNewTask(SciIssueMaster master);
	
	public boolean closeTasks(SciIssueDetails issueDetails);
	
	public boolean addNewDetails(SciIssueDetails details);
	
	public boolean updateDetails(List<SciIssueDetails> detailList);
	
	public List searchOpenTask(String status ,int startpage,String userid);
	
	public String getNextSeqTaskID();
	
	public SciIssueDetails loadDetails(String seqid);
	
	public List escalateTasks(int numberofDays);
	
	public Map<String,Map<Integer,String>>  getTotalCount();
	
	public List<Map<Integer,String>>  getWOTotalCount();
	public List<SciReportConfiguration>  loadDailyReports();
	public List<SciReportConfiguration>  loadWeeklyReports();
	
	public List<LinkedHashMap<String,Object>> generateReports(String sqlQuery);

}
