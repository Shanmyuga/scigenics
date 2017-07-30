package com.sci.bpm.validator.proj;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sci.bpm.command.proj.ProjectTrackCommand;

public class ProjTrackValidator implements Validator {

	public boolean supports(Class arg0) {
		// TODO Auto-generated method stub
		return arg0.equals(ProjectTrackCommand.class);
	}

	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		ProjectTrackCommand command = (ProjectTrackCommand)arg0;
		
		
	}

}
