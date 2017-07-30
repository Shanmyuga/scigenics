package com.sci.bpm.dao.item;

import java.util.List;

import com.sci.bpm.db.model.SciPurchItemMaster;
import com.sci.bpm.db.model.SciPurchaseMast;
import com.sci.bpm.db.model.SciRawMIDetails;

/**
 * Interface for SciPurchItemMasterDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ISciPurchItemMasterDAO {
	/**
	 * Perform an initial save of a previously unsaved SciPurchItemMaster
	 * entity. All subsequent persist actions of this entity should use the
	 * #update() method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ISciPurchItemMasterDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            SciPurchItemMaster entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(SciPurchItemMaster entity);

	/**
	 * Delete a persistent SciPurchItemMaster entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ISciPurchItemMasterDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            SciPurchItemMaster entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(SciPurchItemMaster entity);

	/**
	 * Persist a previously saved SciPurchItemMaster entity and return it or a
	 * copy of it to the sender. A copy of the SciPurchItemMaster entity
	 * parameter is returned when the JPA persistence mechanism has not
	 * previously been tracking the updated entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently saved to the persistence store, i.e., database. This
	 * method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = ISciPurchItemMasterDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            SciPurchItemMaster entity to update
	 * @returns SciPurchItemMaster the persisted SciPurchItemMaster entity
	 *          instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public SciPurchItemMaster update(SciPurchItemMaster entity);

	public SciPurchItemMaster findById(Long id);

	/**
	 * Find all SciPurchItemMaster entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the SciPurchItemMaster property to query
	 * @param value
	 *            the property value to match
	 * @return List<SciPurchItemMaster> found by query
	 */
	public List<SciPurchItemMaster> findByProperty(String propertyName,
			Object value);

	public List<SciPurchItemMaster> findByItemDescription(Object itemDescription);

	public List<SciPurchItemMaster> findByItemDimen(Object itemDimen);

	public List<SciPurchItemMaster> findByItemEstimatedCost(
			Object itemEstimatedCost);

	public List<SciPurchItemMaster> findByItemStatus(Object itemStatus);

	public List<SciPurchItemMaster> findByItemActualCost(Object itemActualCost);

	public List<SciPurchItemMaster> findByUpdatedBy(Object updatedBy);

	public List<SciPurchItemMaster> findByItemQty(Object itemQty);
	public void updatePOStatus(SciPurchaseMast master);
	/**
	 * Find all SciPurchItemMaster entities.
	 * 
	 * @return List<SciPurchItemMaster> all SciPurchItemMaster entities
	 */
	public List<SciPurchItemMaster> findAll();
	
	public boolean checkRawMI(Long rawMI);
	public List<SciPurchItemMaster> loadPODetails(SciPurchaseMast master);
	
	public void addRawMI(SciRawMIDetails midetails);
}