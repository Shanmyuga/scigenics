package com.sci.bpm.dao.role;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sci.bpm.db.model.ScigenicsRoleMaster;

@Repository
public class RoleMasterDAOImpl implements IScigenicsRoleMasterDAO {

	@PersistenceContext
	private EntityManager em;
	public void delete(ScigenicsRoleMaster entity) {
		// TODO Auto-generated method stub

	}

	public List<ScigenicsRoleMaster> findAll(int... rowStartIdxAndCount) {
		// TODO Auto-generated method stub
		return null;
	}

	public ScigenicsRoleMaster findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ScigenicsRoleMaster> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ScigenicsRoleMaster> findByRoleName(Object roleName,
			int... rowStartIdxAndCount) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(ScigenicsRoleMaster entity) {
		em.persist(entity);

	}

	public ScigenicsRoleMaster update(ScigenicsRoleMaster entity) {
		// TODO Auto-generated method stub
		return em.merge(entity);
	}

	public ScigenicsRoleMaster getRoleDetails(Long seqRoleID) {
		// TODO Auto-generated method stub
		ScigenicsRoleMaster rolemaster = em.find(ScigenicsRoleMaster.class, seqRoleID);
		rolemaster.getScigenicsUserMasters();
		
		return rolemaster;
	}

	public Long getRoleID(String rolename) {
		// TODOAuto-generated method stub
		Query qry = em.createQuery("from ScigenicsRoleMaster m where m.roleName = :rolename" );
		qry.setParameter("rolename", rolename);
		System.out.println(qry.getResultList().size());
		ScigenicsRoleMaster seqroleid = (ScigenicsRoleMaster)qry.getResultList().get(0);
		
		return seqroleid.getSeqRoleId(); 
	}

}
