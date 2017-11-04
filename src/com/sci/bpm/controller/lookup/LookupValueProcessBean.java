package com.sci.bpm.controller.lookup;

import java.util.List;

import com.sci.bpm.db.model.SciReportConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sci.bpm.service.lookup.LookUpValueService;
import org.springframework.webflow.execution.RequestContext;

@Component("lookupbean")
public class LookupValueProcessBean {

	@Autowired
	private LookUpValueService lookupService;
	
	
	public List getDropDownList(String queryKey) {
		
		return lookupService.getDropDownValues(queryKey);
	}
	
public List loadReports() {
		
		return lookupService.loadReports();
	}

	public String loadReportNames() throws Exception {
		List<SciReportConfiguration> reports =lookupService.loadReports();
		StringBuilder builder = new StringBuilder();

		for(SciReportConfiguration report:reports) {
			builder.append(report.getReportSubject() + "|");

		}
		System.out.println(builder.toString());
		return builder.toString();
	}



	
}
