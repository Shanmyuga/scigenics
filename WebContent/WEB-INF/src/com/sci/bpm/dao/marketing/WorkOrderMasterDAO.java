package com.sci.bpm.dao.marketing;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


import com.sci.bpm.db.model.SciAmendmentMaster;
import com.sci.bpm.db.model.SciCustomerMaster;
import com.sci.bpm.db.model.SciInstruDetails;
import com.sci.bpm.db.model.SciJdrDocs;
import com.sci.bpm.db.model.SciWorkordDet;
import com.sci.bpm.db.model.SciWorkordInst;
import com.sci.bpm.db.model.SciWorkorderMaster;

@Repository
public class WorkOrderMasterDAO implements ISciWorkorderMasterDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void delete(SciWorkorderMaster entity) {
		// TODO Auto-generated method stub
		
	}

	public List<SciWorkorderMaster> findAll(int rowStartIdxAndCount) {
		// TODO Auto-generated method stub
		return null;
	}

	public SciWorkorderMaster findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SciWorkorderMaster> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(SciWorkorderMaster entity) {
		// TODO Auto-generated method stub
		em.persist(entity);
	}

	public SciWorkorderMaster update(SciWorkorderMaster entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SciWorkorderMaster> searchWork() {
		
		
		return em.createQuery("from SciWorkorderMaster m where m.woStatus = 'Y' ").getResultList();
	}

	public List<SciWorkorderMaster> findAll(int... rowStartIdxAndCount) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addAmendment(SciAmendmentMaster master) {
		// TODO Auto-generated method stub
		em.persist(master);
	}

	public List<SciAmendmentMaster> searchAmend(SciWorkorderMaster master) {
		
		// TODO Auto-generated method stub
	  Query query = em.createQuery("from SciAmendmentMaster where sciWorkorderMaster =:workmaster");
	  query.setParameter("workmaster",master);
	  
	  
		return query.getResultList();
	}

	public void addWorkOrderwithDetails(Map workbeans) {
		SciWorkorderMaster master = (SciWorkorderMaster)workbeans.get("0");
		
		SciInstruDetails instrudet = (SciInstruDetails)workbeans.get("3");
		
		SciWorkordDet workdet = (SciWorkordDet)workbeans.get("1");
		SciWorkordInst workinst = (SciWorkordInst)workbeans.get("2");
		em.persist(master);
		Query qry = em.createNativeQuery("select SCI_WORKORD_DET_SEQ.nextval from dual");
		BigDecimal seqid = (BigDecimal) qry.getSingleResult();
		instrudet.setSeqInstruDet(new Long(seqid.toString()));
		instrudet.setSeqWorkId(master.getSeqWorkId());
		workdet.setSeqWorkDet(new Long(seqid.toString()));
		workdet.setSeqWorkId(master.getSeqWorkId());
		workinst.setSeqWorkInstru(new Long(seqid.toString()));
		workinst.setSeqWorkId(master.getSeqWorkId());
		em.persist(instrudet);
		em.persist(workdet);
		em.persist(workinst);
	}

	public List<SciJdrDocs> getJDRDocs(Long seqWorkId) {
		
		Query qry = em.createQuery("from SciJdrDocs jb where jb.seqWorkId =:workmaster ");
		qry.setParameter("workmaster", seqWorkId);
		return qry.getResultList();
	}

	public void addJDRDcos(SciJdrDocs docmaster) {
		em.persist(docmaster);
		
	}

	public SciCustomerMaster loadCustomer(Long seqCustID) {
		// TODO Auto-generated method stub
		return em.find(SciCustomerMaster.class, seqCustID);
	}

	public void updateWO(SciWorkorderMaster wm,Long seqLovID) {
		
		// TODO Auto-generated method stub
		if(seqLovID != null) {
		Query qry =em.createNativeQuery("update SCIGENICS.SCI_MATIND_MASTER set PUR_STATUS=?,updated_Date =sysdate,updated_by = ? where SEQ_WORK_ID=? and PUR_STATUS in (select scilookupm1_.SEQ_LOV_ID from SCIGENICS.SCI_LOOKUP_MASTER scilookupm1_ where scilookupm1_.LOV_NAME='MI_APPROVED')");
		qry.setParameter(1, seqLovID);
		qry.setParameter(2, wm.getUpdatedBy());
		qry.setParameter(3, wm.getSeqWorkId());
		
		qry.executeUpdate();
		
		}
		em.merge(wm);
	}

	
	
}
