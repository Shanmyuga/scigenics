package com.sci.bpm.command.user;

import java.io.Serializable;

public class UserMasterBean implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userFirstname;
	private String userLastname;
	private String userId;
	private String password;
	private String roleID[];
	private String rolename;
	private String selectedUserID;
	private String userStatus;
	
	
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String[] getRoleID() {
		return roleID;
	}
	public void setRoleID(String[] roleID) {
		this.roleID = roleID;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSelectedUserID() {
		return selectedUserID;
	}
	public void setSelectedUserID(String selectedUserID) {
		this.selectedUserID = selectedUserID;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	
	
	
}
