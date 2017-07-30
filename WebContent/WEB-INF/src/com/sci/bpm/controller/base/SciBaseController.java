package com.sci.bpm.controller.base;

import java.util.Map;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.webflow.action.FormAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.sci.bpm.command.user.UserPreference;
import com.sci.bpm.service.lookup.LookUpValueService;

public class SciBaseController extends FormAction {

	@Autowired
	private UserPreference userPreferences;
	
	@Autowired
	private LookUpValueService lookupservice;
	
	@Autowired
	private PropertyEditorRegistrar propertyEditorRegistrar;
	
        

	public LookUpValueService getLookupservice() {
		return lookupservice;
	}

	public void setLookupservice(LookUpValueService lookupservice) {
		this.lookupservice = lookupservice;
	}

	public UserPreference getUserPreferences() {
		return userPreferences;
	}

	public void setUserPreferences(UserPreference userPreference) {
		this.userPreferences = userPreference;
	}
	
	
	
	@Override
	public Event setupForm(RequestContext context) throws Exception {
		Map mymap = (Map) context.getFlowScope().get("lovmap");
		if(mymap == null) {
			mymap = lookupservice.loadIDDescription();
			context.getFlowScope().put("lovmap", mymap);
		}
		
		return super.setupForm(context);
	}

	@Override
	public void setPropertyEditorRegistrar(
			PropertyEditorRegistrar propertyEditorRegistrar) {
		// TODO Auto-generated method stub
		super.setPropertyEditorRegistrar(propertyEditorRegistrar);
	}

	@Override
	protected void initBinder(RequestContext context, DataBinder binder) {
		// TODO Auto-generated method stub
		
		this.propertyEditorRegistrar.registerCustomEditors(binder);
	}

	

	

	@Override
	protected void doValidate(RequestContext context, Object formObject,
			Errors errors) throws Exception {
		// TODO Auto-generated method stub
		super.doValidate(context, formObject, errors);
	}

	
}
