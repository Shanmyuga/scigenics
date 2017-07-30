package com.sci.bpm.dao.role;

import java.util.List;

import com.sci.bpm.db.model.ScigenicsRoleMaster;

/**
 * Interface for ScigenicsRoleMasterDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IScigenicsRoleMasterDAO {
	/**
	 * Perform an initial save of a previously unsaved ScigenicsRoleMaster
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
	 * IScigenicsRoleMasterDAO.save(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            ScigenicsRoleMaster entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(ScigenicsRoleMaster entity);

	/**
	 * Delete a persistent ScigenicsRoleMaster entity. This operation must be
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
	 * IScigenicsRoleMasterDAO.delete(entity);
	 * txManager.commit(txn);
	 * entity = null;
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            ScigenicsRoleMaster entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(ScigenicsRoleMaster entity);

	/**
	 * Persist a previously saved ScigenicsRoleMaster entity and return it or a
	 * copy of it to the sender. A copy of the ScigenicsRoleMaster entity
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
	 * entity = IScigenicsRoleMasterDAO.update(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            ScigenicsRoleMaster entity to update
	 * @returns ScigenicsRoleMaster the persisted ScigenicsRoleMaster entity
	 *          instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public ScigenicsRoleMaster update(ScigenicsRoleMaster entity);

	public ScigenicsRoleMaster findById(Long id);

	/**
	 * Find all ScigenicsRoleMaster entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the ScigenicsRoleMaster property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<ScigenicsRoleMaster> found by query
	 */
	public List<ScigenicsRoleMaster> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<ScigenicsRoleMaster> findByRoleName(Object roleName,
			int... rowStartIdxAndCount);

	/**
	 * Find all ScigenicsRoleMaster entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<ScigenicsRoleMaster> all ScigenicsRoleMaster entities
	 */
	public List<ScigenicsRoleMaster> findAll(int... rowStartIdxAndCount);
	
	public ScigenicsRoleMaster getRoleDetails(Long SeqRoleID);
	
	public Long getRoleID(String rolename);
}