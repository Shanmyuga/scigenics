package com.sci.bpm.dao.marketing;

import java.util.List;
import java.util.Map;

import com.sci.bpm.chart.model.ChartModel;
import com.sci.bpm.db.model.SciAmendmentMaster;
import com.sci.bpm.db.model.SciCustomerMaster;
import com.sci.bpm.db.model.SciJdrDocs;
import com.sci.bpm.db.model.SciWorkorderMaster;

/**
 * Interface for SciWorkorderMasterDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ISciWorkorderMasterDAO {
	/**
	 * Perform an initial save of a previously unsaved SciWorkorderMaster
	 * entity. All subsequent persist actions of this entity should use the
	 * #update() method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * <p>
	 * User-managed Spring transaction example:
	 * 
	 * <pre>
	 * TransactionStatus txn = txManager
	 * 		.getTransaction(new DefaultTransactionDefinition());
	 * ISciWorkorderMasterDAO.save(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            SciWorkorderMaster entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(SciWorkorderMaster entity);

	/**
	 * Delete a persistent SciWorkorderMaster entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * <p>
	 * User-managed Spring transaction example:
	 * 
	 * <pre>
	 * TransactionStatus txn = txManager
	 * 		.getTransaction(new DefaultTransactionDefinition());
	 * ISciWorkorderMasterDAO.delete(entity);
	 * txManager.commit(txn);
	 * entity = null;
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            SciWorkorderMaster entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(SciWorkorderMaster entity);

	/**
	 * Persist a previously saved SciWorkorderMaster entity and return it or a
	 * copy of it to the sender. A copy of the SciWorkorderMaster entity
	 * parameter is returned when the JPA persistence mechanism has not
	 * previously been tracking the updated entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently saved to the persistence store, i.e., database. This
	 * method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * <p>
	 * User-managed Spring transaction example:
	 * 
	 * <pre>
	 * TransactionStatus txn = txManager
	 * 		.getTransaction(new DefaultTransactionDefinition());
	 * entity = ISciWorkorderMasterDAO.update(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            SciWorkorderMaster entity to update
	 * @returns SciWorkorderMaster the persisted SciWorkorderMaster entity
	 *          instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public SciWorkorderMaster update(SciWorkorderMaster entity);

	public SciWorkorderMaster findById(Long id);

	/**
	 * Find all SciWorkorderMaster entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the SciWorkorderMaster property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<SciWorkorderMaster> found by query
	 */
	public List<SciWorkorderMaster> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	/**
	 * Find all SciWorkorderMaster entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<SciWorkorderMaster> all SciWorkorderMaster entities
	 */
	public List<SciWorkorderMaster> findAll(int... rowStartIdxAndCount);
	
	public List<SciWorkorderMaster> searchWork();
	
	public List<SciAmendmentMaster> searchAmend(SciWorkorderMaster master);
	
	public void addAmendment(SciAmendmentMaster master);
	
	public void addWorkOrderwithDetails(Map workbeans);
	
	public List<SciJdrDocs> getJDRDocs(Long seqWorkId);
	
	public void addJDRDcos(SciJdrDocs docmaster);
	public SciCustomerMaster loadCustomer(Long seqCustID);
	
	public void updateWO(SciWorkorderMaster wm,Long seqLovID);

	public List<ChartModel> getWorkOrderCostStats(Long seqWorkId);


}