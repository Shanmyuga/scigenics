package com.sci.bpm.dao.mi;

import java.util.List;

import com.sci.bpm.db.model.SciItemmiDetails;

/**
 * Interface for SciItemmiDetailsDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ISciItemmiDetailsDAO {
	/**
	 * Perform an initial save of a previously unsaved SciItemmiDetails entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ISciItemmiDetailsDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            SciItemmiDetails entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(SciItemmiDetails entity);

	/**
	 * Delete a persistent SciItemmiDetails entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ISciItemmiDetailsDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            SciItemmiDetails entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(SciItemmiDetails entity);

	/**
	 * Persist a previously saved SciItemmiDetails entity and return it or a
	 * copy of it to the sender. A copy of the SciItemmiDetails entity parameter
	 * is returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = ISciItemmiDetailsDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            SciItemmiDetails entity to update
	 * @returns SciItemmiDetails the persisted SciItemmiDetails entity instance,
	 *          may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public SciItemmiDetails update(SciItemmiDetails entity);

	public SciItemmiDetails findById(Long id);

	/**
	 * Find all SciItemmiDetails entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the SciItemmiDetails property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<SciItemmiDetails> found by query
	 */
	public List<SciItemmiDetails> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	/**
	 * Find all SciItemmiDetails entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<SciItemmiDetails> all SciItemmiDetails entities
	 */
	public List<SciItemmiDetails> findAll(int... rowStartIdxAndCount);
}