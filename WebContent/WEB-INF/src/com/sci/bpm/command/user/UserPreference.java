package com.sci.bpm.command.user;

import java.io.Serializable;
import java.util.Set;

import com.sci.bpm.db.model.ScigenicsRoleMaster;


public class UserPreference implements Serializable{

	private String userID;
	
	private String userFirstName;
	
	private String roleName;
	
	private Set<ScigenicsRoleMaster> rolemasterset;


	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public String getUserFirstName() {
		return userFirstName;
	}


	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}


	public Set<ScigenicsRoleMaster> getRolemasterset() {
		return rolemasterset;
	}


	public void setRolemasterset(Set<ScigenicsRoleMaster> rolemasterset) {
		this.rolemasterset = rolemasterset;
	}
	
	
}
