package com.sci.bpm.dao.item;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sci.bpm.db.model.SciPurchItemMaster;
import com.sci.bpm.db.model.SciPurchaseMast;
import com.sci.bpm.db.model.SciRawMIDetails;

@Repository
public class PurchaseItemMasterDAOImpl implements ISciPurchItemMasterDAO {

	@PersistenceContext
	private EntityManager em;
	
	
	public void delete(SciPurchItemMaster entity) {
		// TODO Auto-generated method stub

	}

	public List<SciPurchItemMaster> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public SciPurchItemMaster findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SciPurchItemMaster> findByItemActualCost(Object itemActualCost) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SciPurchItemMaster> findByItemDescription(Object itemDescription) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SciPurchItemMaster> findByItemDimen(Object itemDimen) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SciPurchItemMaster> findByItemEstimatedCost(
			Object itemEstimatedCost) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SciPurchItemMaster> findByItemQty(Object itemQty) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<SciPurchItemMaster> findByItemStatus(Object itemStatus) {
		Query query = null;
		if(itemStatus == null) {
			
			query = em.createQuery("from SciPurchItemMaster pm ");
			
		}
		else {
			query = em.createQuery("from SciPurchItemMaster pm where pm.itemStatus= :itemstat");
			query.setParameter("itemstat", itemStatus);
		}
		return query.getResultList();
	}

	public List<SciPurchItemMaster> findByProperty(String propertyName,
			Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SciPurchItemMaster> findByUpdatedBy(Object updatedBy) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(SciPurchItemMaster entity) {
	   em.persist(entity);

	}

	public SciPurchItemMaster update(SciPurchItemMaster entity) {
		return em.merge(entity);
	}

	public List<SciPurchItemMaster> loadPODetails(SciPurchaseMast master) {
		// TODO Auto-generated method stub
		
		Query query = null;
		
	
			query = em.createQuery("select pm from SciPurchItemMaster pm,SciPurchaseItemdetails pi where pi.seqItemId = pm.seaPuritemId and pi.sciPurchaseMast = :scipomaster");
			query.setParameter("scipomaster",master );
		
		return query.getResultList();
		
	}

	public void updatePOStatus(SciPurchaseMast master) {
		em.merge(master);
		
	}

	public boolean checkRawMI(Long rawMI) {
		// TODO Auto-generated method stub
		Query query = null;
		query = em.createQuery("from SciStoreissueMaster im where im.sciMiMaster.seqMiId=:seqMIID");
		query.setParameter("seqMIID", rawMI);
		if(query.getResultList() != null && query.getResultList().size() >0 ) {
			return true;
		}
		return false;
	}

	public void addRawMI(SciRawMIDetails midetails) {
		em.merge(midetails);
		
	}

	
}
