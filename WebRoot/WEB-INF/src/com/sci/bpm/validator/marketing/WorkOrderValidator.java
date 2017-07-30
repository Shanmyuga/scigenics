package com.sci.bpm.validator.marketing;


import org.apache.commons.lang.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sci.bpm.command.marketing.WorkOrderCommand;

public class WorkOrderValidator  implements Validator{

	public boolean supports(Class arg0) {
	
		return arg0.equals(WorkOrderCommand.class);
	}

	public void validate(Object arg0, Errors arg1) {
		WorkOrderCommand command = (WorkOrderCommand)arg0;
		boolean reqValuemissing = false;
		if(StringUtils.isBlank(command.getClientDetails())) {
			reqValuemissing = true;
		}
		if(StringUtils.isBlank(command.getApprovedBy())) {
			reqValuemissing = true;
		}
		if(StringUtils.isBlank(command.getDeliveryAdd())) {
			reqValuemissing = true;
		}
		if(StringUtils.isBlank(command.getExciseDuty())) {
			reqValuemissing = true;
		}
		if(StringUtils.isBlank(command.getFrieght())) {
			reqValuemissing = true;
		}
		if(StringUtils.isBlank(command.getInsurance())) {
			reqValuemissing = true;
		}
		if(StringUtils.isBlank(command.getOctroi())) {
			reqValuemissing = true;
		}
		if(StringUtils.isBlank(command.getJobDesc())) {
			reqValuemissing = true;
		}
		
		if(StringUtils.isBlank(command.getPreparedBy())) {
			reqValuemissing = true;
		}
		if(StringUtils.isBlank(command.getPacking())) {
			reqValuemissing = true;
		}
		if(StringUtils.isBlank(command.getWordOrderType())) {
			reqValuemissing = true;
		}
		if(StringUtils.isBlank(command.getTransportation())) {
			reqValuemissing = true;
		}
		if(StringUtils.isBlank(command.getSalesTax())) {
			reqValuemissing = true;
		}
		
		if(reqValuemissing) {
			arg1.rejectValue(null, "error.required" ,"Required Value Missing");
		}
		
	}

}
