package com.sci.bpm.service.task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ReportQueryService extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		
		tservice.generateReports();
	}

	
	public TaskService getTservice() {
		return tservice;
	}

	public void setTservice(TaskService tservice) {
		this.tservice = tservice;
	}

	private TaskService tservice;

}
