package com.sci.bpm.view.resolver;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

public class SciViewResolver extends UrlBasedViewResolver {

	@Override
	protected AbstractUrlBasedView buildView(String viewName) throws Exception {
		
		if(viewName != null && viewName.indexOf("report.") < 0) {
			return super.buildView(viewName);
		}
		else {
			return null;
		}
		
	}

	
	

	
	

	
	

}
