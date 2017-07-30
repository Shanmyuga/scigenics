package com.sci.bpm.command.user;

import java.io.Serializable;

public class UserListBean implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userFirstname;
	private String userLastname;
	private String userId;
	private String userName;
	
	


	public UserListBean(String userID,String fname,String lname) {
		this.userId= userID;
		this.userFirstname = fname;
		this.userLastname = lname;
		
	}


	public String getUserFirstname() {
		return userFirstname;
	}


	public void setUserFirstname(String userFirstname) {
		this.userFirstname = userFirstname;
	}


	public String getUserLastname() {
		return userLastname;
	}


	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	public String getUserName() {
		return userId + ","+ userFirstname + " "+ userLastname;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}
	

}
