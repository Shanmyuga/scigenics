package com.sci.bpm.dao.login;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sci.bpm.db.model.ScigenicsRoleMaster;
import com.sci.bpm.db.model.ScigenicsUserMaster;

@Repository
public class LoginDAOImpl implements LoginDAO {

	
	private EntityManager em;

	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Object validateUserRole(String userID, String password,
			int seqRoleID) {
		boolean result = false;
		Query qc = em.createQuery("from ScigenicsUserMaster user where " +
				" user.userId =:userID and user.password =:password and user.userStatus = 'Y' " );
			
		qc.setParameter("userID", userID);
		qc.setParameter("password",password );
		
		
		
		ScigenicsUserMaster usermaster = (ScigenicsUserMaster)qc.getSingleResult();
		if(usermaster == null) {
			return null;
		}
		Set<ScigenicsRoleMaster> roles = usermaster.getScigenicsRoleMasters();
	
		for(ScigenicsRoleMaster rm : roles) {
			if(rm.getSeqRoleId() == seqRoleID) {
				result = true;
				break;
			}	
			
		}
		if(!result) {
			usermaster = null;
		}
		return usermaster;
	}

	public List getRoleList() {
		// TODO Auto-generated method stub
	
		return  em.createQuery("from ScigenicsRoleMaster").getResultList();
	}

	public void changePass(String userid, String password) {
		
	Query qry = em.createQuery("update ScigenicsUserMaster m set m.password =:pass where m.userId =:userid ");
	qry.setParameter("pass", password);
	qry.setParameter("userid", userid);
		
	qry.executeUpdate();
	}
	
	
}
