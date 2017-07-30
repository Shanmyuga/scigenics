package com.sci.bpm.dao.user;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sci.bpm.db.model.ScigenicsRoleMaster;
import com.sci.bpm.db.model.ScigenicsUserMaster;

@Repository
public class UserMasterDAO implements IScigenicsUserMasterDAO {

	
	@PersistenceContext
	private EntityManager em;
	
	public void delete(ScigenicsUserMaster entity) {
		em.remove(entity);

	}

	public List<ScigenicsUserMaster> findAll(int... rowStartIdxAndCount) {
		// TODO Auto-generated method stub
		return null;
	}

	public ScigenicsUserMaster findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ScigenicsUserMaster> findByPassword(Object password,
			int... rowStartIdxAndCount) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ScigenicsUserMaster> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ScigenicsUserMaster> findByUserFirstname(Object userFirstname,
			int... rowStartIdxAndCount) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ScigenicsUserMaster> findByUserId(Object userId,
			int... rowStartIdxAndCount) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ScigenicsUserMaster> findByUserLastname(Object userLastname,
			int... rowStartIdxAndCount) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(ScigenicsUserMaster entity) {
		
		Set<ScigenicsRoleMaster> rolemaster = entity.getScigenicsRoleMasters();
		Set<ScigenicsRoleMaster> refreshedSet = new HashSet<ScigenicsRoleMaster>();
		for(ScigenicsRoleMaster rm : rolemaster) {
		
			refreshedSet.add(em.find(ScigenicsRoleMaster.class, rm.getSeqRoleId()));
		}
		entity.setScigenicsRoleMasters(refreshedSet);
		em.persist(entity);

	}
	public ScigenicsUserMaster update(ScigenicsUserMaster entity) {
		
		return em.merge(entity);
	}

	public List selectUserList() {
		// TODO Auto-generated method stub
		List<ScigenicsUserMaster> users = em.createQuery("from ScigenicsUserMaster  um where um.userStatus = 'Y' ").getResultList();
		for(ScigenicsUserMaster sm:users) {
			sm.getScigenicsRoleMasters();
		}
		return users;
	}

	public ScigenicsUserMaster findUser(String userID) {
		// TODO Auto-generated method stub
		Query qp = em.createQuery("from ScigenicsUserMaster  um where um.userId =:userID");
		qp.setParameter("userID", userID);
		List mylist = qp.getResultList();
		if(mylist.size() > 0) {
			return (ScigenicsUserMaster)mylist.get(0);
		}
		return null;
	}

}
