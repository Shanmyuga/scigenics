package com.sci.bpm.service.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sci.bpm.dao.role.IScigenicsRoleMasterDAO;
import com.sci.bpm.db.model.ScigenicsRoleMaster;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private IScigenicsRoleMasterDAO daoimpl;
	
	public RoleServiceImpl() {
		super();
		System.out.println("shanmuga");
		
	}

	@Transactional
	public boolean addRole(ScigenicsRoleMaster role) {
		daoimpl.save(role);
		return true;
	}
	@Transactional
	public ScigenicsRoleMaster getRoleDetails(Long SeqRoleID) {
		// TODO Auto-generated method stub
		return daoimpl.getRoleDetails(SeqRoleID);
	}

	public List<ScigenicsRoleMaster> getRoledetails() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateRole(ScigenicsRoleMaster role) {
		daoimpl.update(role);
		return false;
	}
	@Transactional
	public Long getRoleID(String rolename) {
		// TODO Auto-generated method stub
		return daoimpl.getRoleID(rolename);
	}

}
