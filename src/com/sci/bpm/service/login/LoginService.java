package com.sci.bpm.service.login;

import java.util.List;


public interface LoginService {

	public Object validateRole(String username,String password,int seqRoleID);
	
	public List getRoleList();
	
	public void changePass(String userid,String password);
}
