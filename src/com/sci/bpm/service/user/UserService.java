package com.sci.bpm.service.user;

import java.util.List;

import com.sci.bpm.db.model.ScigenicsRoleMaster;
import com.sci.bpm.db.model.ScigenicsUserMaster;

public interface UserService {

	
	public boolean addUser(ScigenicsUserMaster user);
	
	public boolean updateUser(ScigenicsUserMaster user);

	public ScigenicsRoleMaster generateRole(Long roleID);
	
	public ScigenicsUserMaster findUser(String userID);
	
	public boolean updateRoleForUser(int roleid[],String seqUserID);
	
	public List selectUserList();
	
	
	
	
}
