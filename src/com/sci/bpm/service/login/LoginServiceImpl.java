package com.sci.bpm.service.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sci.bpm.dao.login.LoginDAO;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO daoimpl;
	
	
	public Object validateRole(String username, String password, int seqRoleID) {
	
		
		
		return  daoimpl.validateUserRole(username, password, seqRoleID);
	}
	
	public List getRoleList() {
		// TODO Auto-generated method stub
		return daoimpl.getRoleList();
	}
	public LoginServiceImpl() {
		
	}
	public void changePass(String userid, String password) {
		daoimpl.changePass(userid, password);
		
	}

}
