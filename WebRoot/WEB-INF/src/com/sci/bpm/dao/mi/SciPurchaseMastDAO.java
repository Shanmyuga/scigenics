package com.sci.bpm.dao.mi;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sci.bpm.db.model.SciPurchaseMast;


/**
 * A data access object (DAO) providing persistence and search support for
 * SciPurchaseMast entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see com.sci.bpm.db.model.SciPurchaseMast
 * @author MyEclipse Persistence Tools
 */
@Repository
public class SciPurchaseMastDAO implements ISciPurchaseMastDAO {

	@PersistenceContext
	private EntityManager em;
	public void delete(SciPurchaseMast entity) {
		// TODO Auto-generated method stub
		
	}

	public List<SciPurchaseMast> findAll(int... rowStartIdxAndCount) {
		// TODO Auto-generated method stub
		return null;
	}

	public SciPurchaseMast findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SciPurchaseMast> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(SciPurchaseMast entity) {
	em.persist(entity);
		
	}

	public SciPurchaseMast update(SciPurchaseMast entity) {
		// TODO Auto-generated method stub
		return em.merge(entity);
	}

	

}