package com.sci.bpm.dao.po;

import java.util.List;

import com.sci.bpm.command.po.POCommand;
import com.sci.bpm.db.model.SciPaymentDetails;
import com.sci.bpm.db.model.SciPurchaseMast;
import com.sci.bpm.db.model.SciRejectMaterialAudit;
import com.sci.bpm.db.model.SciRejectedMaterials;
import com.sci.bpm.db.model.SciVendorInvoiceMaster;
import com.sci.bpm.db.model.SciVendorMaster;
import com.sci.bpm.db.model.SciVendorPurchaseCost;

/**
 * Interface for SciPurchaseMastDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ISciPurchaseMastDAO {
	/**
	 * Perform an initial save of a previously unsaved SciPurchaseMast entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ISciPurchaseMastDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            SciPurchaseMast entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(SciPurchaseMast entity);

	/**
	 * Delete a persistent SciPurchaseMast entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ISciPurchaseMastDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            SciPurchaseMast entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(SciPurchaseMast entity);

	/**
	 * Persist a previously saved SciPurchaseMast entity and return it or a copy
	 * of it to the sender. A copy of the SciPurchaseMast entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = ISciPurchaseMastDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            SciPurchaseMast entity to update
	 * @returns SciPurchaseMast the persisted SciPurchaseMast entity instance,
	 *          may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public SciPurchaseMast update(SciPurchaseMast entity);

	public SciPurchaseMast findById(Long id);

	/**
	 * Find all SciPurchaseMast entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the SciPurchaseMast property to query
	 * @param value
	 *            the property value to match
	 * @return List<SciPurchaseMast> found by query
	 */
	public List<SciPurchaseMast> findByProperty(String propertyName,
			Object value);

	public List<SciPurchaseMast> findByVendorOrder(Object vendorOrder);

	public List<SciPurchaseMast> findByVendorAddress(Object vendorAddress);

	public List<SciPurchaseMast> findByUpdatedBy(Object updatedBy);

	public List<SciPurchaseMast> findByPurchaseStatus(Object purchaseStatus);

	/**
	 * Find all SciPurchaseMast entities.
	 * 
	 * @return List<SciPurchaseMast> all SciPurchaseMast entities
	 */
	public List<SciPurchaseMast> findAll();
	public void cancelPO(SciPurchaseMast master);
	public List searchPO(POCommand command);
	public List closePO(POCommand command);
	public List viewRejected(POCommand command);
	public void updateReject(SciRejectedMaterials mater,SciRejectMaterialAudit audit);
	
	public void despatchPO(SciPurchaseMast master);
	public void addPaymentDetails(SciPaymentDetails details);
	public List<SciPaymentDetails> loadPaymentDetails();
	public SciVendorMaster loadSciVendorMaster(Long seqVendorID);
	public void addInvoiceDetails(SciVendorInvoiceMaster vmaster);
	public List<SciVendorInvoiceMaster> loadInvoiceDetails();
	public List<SciPurchaseMast> loadPODetails(Long seqVendorID);
	
	public List<SciVendorInvoiceMaster> loadbillNo(Long seqVendorID);      
	
	public List<SciVendorPurchaseCost> loadQuotations(String matDept,String matCategory);
	
	public void addPurchaseVendorCost(SciVendorPurchaseCost purchaseCost);
	
	
}