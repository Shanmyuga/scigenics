package com.sci.bpm.service.role;

import java.util.List;

import com.sci.bpm.db.model.ScigenicsRoleMaster;

public interface RoleService {

	
	public boolean addRole(ScigenicsRoleMaster role) ;
	
	public boolean updateRole(ScigenicsRoleMaster role);
	
	public List<ScigenicsRoleMaster> getRoledetails();
	
	public ScigenicsRoleMaster getRoleDetails(Long seqRoleID);
	
	public Long getRoleID(String rolename);
	
}
