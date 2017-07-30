package com.sci.bpm.dao.bulletin;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sci.bpm.db.model.SciBulletinBoard;

@Repository
public class BulletinDAOImpl implements BulletinDAO {

	@PersistenceContext
	private EntityManager em;
	public boolean addBulletin(SciBulletinBoard board) {
	em.persist(board);
		return true;
	}

	public List searchBulletins() {
		
		Query qr = em.createQuery("from SciBulletinBoard as m order by m.bulletinDate desc");
		
		qr.setMaxResults(10);
		List mylist = qr.getResultList();
		if(mylist != null) {
		System.out.println("mylist size" + mylist.size());
		}
		return mylist;
	}

}
