package com.sci.bpm.dao.proj;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sci.bpm.db.model.SciProjectCostMaster;
import com.sci.bpm.db.model.SciWoTrackMaster;
import com.sci.bpm.db.model.SciWorkorderMaster;

@Repository
public class ProjTrackDAOImpl implements ProjTrackDao {

	@PersistenceContext
	private EntityManager em;

	public void addTaskPhase(SciWoTrackMaster master) {
		// TODO Auto-generated method stub
		System.out.println("add ed");
		em.merge(master);

	}

	public List loadWoPhases(SciWorkorderMaster master) {

		Query qry = em
				.createQuery("from SciWoTrackMaster wm where wm.sciWorkorderMaster =:wmaster");
		qry.setParameter("wmaster", master);

		return qry.getResultList();

	}

	public List loadSubPhase(String phaseMaster) {
		// TODO Auto-generated method stub
		Query qry = em
				.createQuery("from SciProjectPhases m "
						+ "where m.phaseName =:phaseName order by subPhaseOrder asc ");
		qry.setParameter("phaseName", phaseMaster);

		return qry.getResultList();
	}

	public boolean checkPhaseExist(String phaseName, String subphase,
			Long seqworkid) {
		// TODO Auto-generated method stub
		Query qry = em
				.createNativeQuery("select count(1) from SCI_WO_TRACK_MASTER m "
						+ " where m.phase_desc =:subphase and "
						+ " m.PHASE_DETAIL =:phasename and m.SEQ_WORK_ID =:workID");

		qry.setParameter("subphase", subphase);
		qry.setParameter("phasename", phaseName);
		qry.setParameter("workID", seqworkid);
		if (((java.math.BigDecimal) qry.getSingleResult()).intValue() > 0) {
			return true;
		}
		return false;
	}

	public SciWoTrackMaster loadWoMaster(String phasename, Long seqWorkId) {
		// TODO Auto-generated method stub
		SciWorkorderMaster master = em
				.find(SciWorkorderMaster.class, seqWorkId);
		Query qry = em
				.createQuery("from SciWoTrackMaster wm where wm.sciWorkorderMaster =:wmaster and wm.phaseDetail = :phasename");
		qry.setParameter("wmaster", master);
		qry.setParameter("phasename", phasename);

		List rstlist = qry.getResultList();
		if (rstlist.size() > 0) {
			return (SciWoTrackMaster) rstlist.get(0);
		}
		return null;
	}

	public void updateDates(String phasename, Long seqWorkID) {
		// TODO Auto-generated method stub
		Query qry = em
				.createNativeQuery("update SCI_WO_TRACK_MASTER m set(m.EST_STDATE,m.EST_ENDDATE) = "
						+ " ( select min(d.SUB_EST_START) ,max(d.SUB_EST_END)  from Sci_wo_trk_detail d where  "
						+ "m.SEQ_WO_TRK_ID = d.SEQ_WO_TRK_ID  ) " +

						" where m.PHASE_DETAIL =:phasename and m.SEQ_WORK_ID = :workID");
		qry.setParameter("phasename", phasename);
		qry.setParameter("workID", seqWorkID);
		qry.executeUpdate();
	}

	public void updateActualDates(String phasename, String subphase,
			Long seqWorkId, Date actualStart, Date actualend) {

		Query qry = em
				.createNativeQuery("update Sci_wo_trk_detail d1 set d1.SUB_ACT_STDATE =:actual ,SUB_ACT_END =:subActEnd where d1.SEQ_TRK_DTL_ID in ( select d.SEQ_TRK_DTL_ID from SCI_WO_TRACK_MASTER m,Sci_wo_trk_detail d "
						+ " where m.SEQ_WO_TRK_ID = d.SEQ_WO_TRK_ID and d.SUB_PHASE_NAME =:subphase and "
						+ " m.PHASE_DETAIL =:phasename and m.SEQ_WORK_ID =:workID )");
		qry.setParameter("actual", actualStart);
		qry.setParameter("subActEnd", actualend);
		qry.setParameter("subphase", subphase);
		qry.setParameter("phasename", phasename);
		qry.setParameter("workID", seqWorkId);
		qry.executeUpdate();

		Query qry1 = em
				.createNativeQuery("update SCI_WO_TRACK_MASTER m set(m.ACTUAL_STDATE,m.ACTUAL_ENDDATE) = "
						+ " ( select min(d.SUB_ACT_STDATE) ,max(d.SUB_ACT_END)  from Sci_wo_trk_detail d where  "
						+ "m.SEQ_WO_TRK_ID = d.SEQ_WO_TRK_ID  ) " +

						" where m.PHASE_DETAIL =:phasename and m.SEQ_WORK_ID = :workID");
		qry1.setParameter("phasename", phasename);
		qry1.setParameter("workID", seqWorkId);
		qry1.executeUpdate();

	}

	public List loadProjectCost(SciWorkorderMaster wmaster) {
		// TODO Auto-generated method stub
		Query qry = em.createQuery("from SciProjectCostMaster pm where pm.seqWorkId =:workID");
		qry.setParameter("workID", wmaster.getSeqWorkId());
		return qry.getResultList();
	}

	public void addProjectCost(SciProjectCostMaster costmaster) {
		em.persist(costmaster);
		
	}

}
