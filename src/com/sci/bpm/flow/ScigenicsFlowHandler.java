package com.sci.bpm.flow;

import javax.servlet.http.HttpServletRequest;

import org.springframework.webflow.context.servlet.FilenameFlowUrlHandler;
import org.springframework.webflow.context.servlet.FlowUrlHandler;
import org.springframework.webflow.core.collection.AttributeMap;
import org.springframework.webflow.core.collection.MutableAttributeMap;
import org.springframework.webflow.mvc.servlet.AbstractFlowHandler;

public class ScigenicsFlowHandler extends FilenameFlowUrlHandler {

	



	public String getFlowId(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		return arg0.getParameter("_flowId");
	}

	



}
