package com.sci.bpm.dao.login;

import java.util.List;


public interface LoginDAO {

	
	public Object validateUserRole(String username,String password,int seqRoleID);
	
	public List getRoleList();
	public void changePass(String sequserid,String password);

}
