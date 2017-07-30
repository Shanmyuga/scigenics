package com.sci.bpm.dao.user;

import java.util.List;

import com.sci.bpm.db.model.ScigenicsUserMaster;

/**
 * Interface for ScigenicsUserMasterDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IScigenicsUserMasterDAO {
	/**
	 * Perform an initial save of a previously unsaved ScigenicsUserMaster
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
	 * IScigenicsUserMasterDAO.save(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            ScigenicsUserMaster entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(ScigenicsUserMaster entity);

	/**
	 * Delete a persistent ScigenicsUserMaster entity. This operation must be
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
	 * IScigenicsUserMasterDAO.delete(entity);
	 * txManager.commit(txn);
	 * entity = null;
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            ScigenicsUserMaster entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(ScigenicsUserMaster entity);

	/**
	 * Persist a previously saved ScigenicsUserMaster entity and return it or a
	 * copy of it to the sender. A copy of the ScigenicsUserMaster entity
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
	 * entity = IScigenicsUserMasterDAO.update(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            ScigenicsUserMaster entity to update
	 * @returns ScigenicsUserMaster the persisted ScigenicsUserMaster entity
	 *          instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public ScigenicsUserMaster update(ScigenicsUserMaster entity);

	public ScigenicsUserMaster findById(Long id);

	/**
	 * Find all ScigenicsUserMaster entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the ScigenicsUserMaster property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<ScigenicsUserMaster> found by query
	 */
	public List<ScigenicsUserMaster> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<ScigenicsUserMaster> findByUserFirstname(Object userFirstname,
			int... rowStartIdxAndCount);

	public List<ScigenicsUserMaster> findByUserLastname(Object userLastname,
			int... rowStartIdxAndCount);

	public List<ScigenicsUserMaster> findByUserId(Object userId,
			int... rowStartIdxAndCount);

	public List<ScigenicsUserMaster> findByPassword(Object password,
			int... rowStartIdxAndCount);

	/**
	 * Find all ScigenicsUserMaster entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<ScigenicsUserMaster> all ScigenicsUserMaster entities
	 */
	public ScigenicsUserMaster findUser(String userID);
	public List selectUserList();
	public List<ScigenicsUserMaster> findAll(int... rowStartIdxAndCount);
}