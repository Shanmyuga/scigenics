package com.sci.bpm.service.user;

import java.util.List;

import com.sci.bpm.db.model.ScigenicsRoleMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sci.bpm.dao.user.IScigenicsUserMasterDAO;
import com.sci.bpm.db.model.ScigenicsUserMaster;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private IScigenicsUserMasterDAO daoimpl;

	
	public boolean addUser(ScigenicsUserMaster user) {
		daoimpl.save(user);
		return true;
	}

	public ScigenicsUserMaster findUser(String userID) {
		// TODO Auto-generated method stub
		return daoimpl.findUser(userID);
	}

	public boolean updateRoleForUser(int[] roleid, String seqUserID) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean updateUser(ScigenicsUserMaster user) {
		// TODO Auto-generated method stub
		daoimpl.update(user);
		return true;
	}

	@Override
	public ScigenicsRoleMaster generateRole(Long roleID) {

		return daoimpl.selectRole(roleID);
	}

	public List selectUserList() {
		// TODO Auto-generated method stub
		return daoimpl.selectUserList();
	}

}
