package com.sci.bpm.controller.lookup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sci.bpm.service.lookup.LookUpValueService;

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
	
}
