package com.sci.bpm.validator.login;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sci.bpm.command.login.LoginCommandBean;

public class LoginValidator implements Validator {

	public boolean supports(Class arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object arg0, Errors arg1) {
		LoginCommandBean commandBean = (LoginCommandBean)arg0;
	
		if(commandBean.getUserid() == null || "".equals(commandBean.getUserid())) {
			
			arg1.reject("error.userID", "User ID cannot be null");
		}
	}

}
