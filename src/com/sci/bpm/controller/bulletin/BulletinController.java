package com.sci.bpm.controller.bulletin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.webflow.action.FormAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.sci.bpm.command.bulletin.BulletinCommandBean;
import com.sci.bpm.command.user.UserPreference;
import com.sci.bpm.controller.base.SciBaseController;
import com.sci.bpm.db.model.SciBulletinBoard;
import com.sci.bpm.service.bulletin.BulletinService;

@Controller("bulletinController")
public class BulletinController extends SciBaseController {

	@Autowired
	private BulletinService service;
	
	@Override
	public Event setupForm(RequestContext context) throws Exception {
		setFormObjectClass(BulletinCommandBean.class);
		setFormObjectName("bulletinbean");
		return super.setupForm(context);
	}

	
	public Event addBulletin(RequestContext context) {
		
	try {
		BulletinCommandBean commandBean = (BulletinCommandBean)getFormObject(context);
		UserPreference userPrefence = getUserPreferences();
		SciBulletinBoard board = new SciBulletinBoard();
	    board.setBulletinDate(new java.util.Date());
	    board.setCreatedBy(userPrefence.getUserFirstName());
	    board.setUpdatedBy(userPrefence.getUserID());
	    board.setUpdateDate(new java.util.Date());
	    board.setBulletinNews(commandBean.getBulletinNews());
	    board.setBulletinSubject(commandBean.getBulletinSubject());
	    service.addBulletin(board);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
		return success();
	}
	
	public List searchBulletin() {
		System.out.println("Inside Bulletin");
		
		return service.searchBulletin();
	}
	
	
	
}
