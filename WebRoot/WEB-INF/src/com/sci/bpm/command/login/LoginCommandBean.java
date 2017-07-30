package com.sci.bpm.command.login;

import java.io.Serializable;


public class LoginCommandBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userid;
	
	private String password;
	
	private String seqRoleID;
	
	private String rolename;
	
	

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSeqRoleID() {
		return seqRoleID;
	}

	public void setSeqRoleID(String seqRoleID) {
		this.seqRoleID = seqRoleID;
	}
	
}
