package com.sci.bpm.controller.base;

import org.springframework.webflow.engine.FlowExecutionExceptionHandler;
import org.springframework.webflow.engine.RequestControlContext;
import org.springframework.webflow.execution.FlowExecutionException;

public class Scigenics implements FlowExecutionExceptionHandler  {


	public boolean handles(FlowExecutionException arg0) {
		// TODO Auto-generated method stub
		arg0.printStackTrace();
		return true;
	}

	public boolean canHandle(FlowExecutionException arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public void handle(FlowExecutionException arg0, RequestControlContext arg1) {
		// TODO Auto-generated method stub
		
	}



}
