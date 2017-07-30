package com.sci.bpm.command.bulletin;

import java.io.Serializable;


public class BulletinCommandBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bulletinNews;
	private String bulletinSubject;
	
	
	public String getBulletinNews() {
		return bulletinNews;
	}
	public void setBulletinNews(String bulletinNews) {
		this.bulletinNews = bulletinNews;
	}
	public String getBulletinSubject() {
		return bulletinSubject;
	}
	public void setBulletinSubject(String bulletinSubject) {
		this.bulletinSubject = bulletinSubject;
	}
	
	
	
}
