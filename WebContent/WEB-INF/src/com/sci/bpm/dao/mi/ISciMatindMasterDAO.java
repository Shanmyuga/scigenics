package com.sci.bpm.dao.mi;

import java.util.List;

import com.sci.bpm.command.mi.MatindCommand;
import com.sci.bpm.db.model.SciMatindMaster;
import com.sci.bpm.db.model.SciStoresRequest;
import com.sci.bpm.db.model.SciSubcontJobstatus;

/**
 * Interface for SciMatindMasterDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ISciMatindMasterDAO {
	/**
	 * Perform an initial save of a previously unsaved SciMatindMaster entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ISciMatindMasterDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            SciMatindMaster entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(SciMatindMaster entity);

	/**
	 * Delete a persistent SciMatindMaster entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ISciMatindMasterDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            SciMatindMaster entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(SciMatindMaster entity);

	/**
	 * Persist a previously saved SciMatindMaster entity and return it or a copy
	 * of it to the sender. A copy of the SciMatindMaster entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = ISciMatindMasterDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            SciMatindMaster entity to update
	 * @returns SciMatindMaster the persisted SciMatindMaster entity instance,
	 *          may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public SciMatindMaster update(SciMatindMaster entity);

	public SciMatindMaster findById(Long id);

	/**
	 * Find all SciMatindMaster entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the SciMatindMaster property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<SciMatindMaster> found by query
	 */
	public List<SciMatindMaster> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	/**
	 * Find all SciMatindMaster entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<SciMatindMaster> all SciMatindMaster entities
	 */
	public List<SciMatindMaster> findAll(int... rowStartIdxAndCount);
	
	public List<SciMatindMaster> searchMI(MatindCommand command);
		
	public List searchMIByWorkOrder(SciMatindMaster master,MatindCommand command);
	public void approveMI(String seqmilist, String approvedBy);
	public void cancelMI(SciMatindMaster master);
	public void updateMI(SciMatindMaster master);
	public List selectDesignDocs(SciMatindMaster command);
	public void addStoreRequest(SciStoresRequest request);
	public List loadOpenMI(SciMatindMaster command);
	public List loadStoreRequest(MatindCommand command);
	public List loadforAppPurchStRequest(MatindCommand command);
	public List loadforAppProdStRequest(MatindCommand command);
	public SciMatindMaster loadMI(Long seqmiID);
	public void updateStoreRequest(SciStoresRequest request);
	public void approveMilist(List<SciMatindMaster> milist);
	public void mergeMI(SciMatindMaster master);
	public List availableinStores(String matcode); 
	public List loadStoreIssueRequest(MatindCommand  command);
	public List checkStockedMI(String matcode,Long lovid);
	public List loadStoreRequestIssue(MatindCommand command);
	public List loadStoreRequestFilters(MatindCommand command);
	public float loadLatestUnitCost(SciMatindMaster matid);
	public void addSubContStatus(SciSubcontJobstatus jobstatus);
	public List<SciSubcontJobstatus> getRecentSubcontJobStatus(Long seqWorkID);
	public List<SciSubcontJobstatus> getLoadDetails(Long jobCode,String jobType,Long seqWorkId);
	
	
}