package com.sci.bpm.dao.design;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sci.bpm.command.design.DrawingDetailsBean;
import com.sci.bpm.command.mi.MatindCommand;
import com.sci.bpm.db.model.SciDesignDocMaster;
import com.sci.bpm.db.model.SciDrawingRef;
import com.sci.bpm.db.model.SciDrwingDetails;
import com.sci.bpm.db.model.SciWoDesgDocs;
import com.sci.bpm.db.model.SciWorkorderMaster;

@Repository
public class DesignDocDaoImpl implements DesignDocDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void approveDesign(String seqdrwinglist, String approvedBy) {
		String query = "update SciDrwingDetails set drawingStatus='Y', approvedBy= :approvedBy ,updatedBy=:updatedBy ,updatedDate= :updatedDate " +
		" where seqDrwDtlid in ( " +seqdrwinglist+")";
Query wquery = em.createQuery(query);
wquery.setParameter("approvedBy",approvedBy );
wquery.setParameter("updatedBy",approvedBy );
wquery.setParameter("updatedDate",new Date() );
 wquery.executeUpdate();
	}

	public void cancelDesign(SciDrawingRef master) {
		// TODO Auto-generated method stub

	}

	public List searchDesign(MatindCommand command) {
		// TODO Auto-generated method stub
		return null;
	}

	public List searchDesignWorkOrder(SciDrawingRef command) {
		String query = " select  dd.SEQ_DRW_DTLID, dd.ORIGINAL_DOC, dd.DOCUMENT_VERSION, dm.DOCUMENT_NAME, dm.DRAWING_DESC, dm.DRWING_REFNUM, dd.UPDATED_DATE,dm.SEQ_DRAWING_ID ,dd.DRAWING_STATUS,dd.REJECT_COMMENT  from   scigenics.SCI_DRAWING_REF dm, scigenics.SCI_DRWING_DETAILS dd  where  dm.SEQ_DRAWING_ID = dd.SCI_DRWING_ID and dm.SEQ_WORK_ID = :wmwork  ";
		Query wquery = null;
		 wquery = em.createNativeQuery(query);
			
		 wquery.setParameter("wmwork", command.getSciWorkorderMaster().getSeqWorkId());
		 List desobjlist =  wquery.getResultList();
	       List deslist = createVOList(desobjlist);
		return deslist;
	}

	public void updateDesign(SciDrawingRef master) {
		// TODO Auto-generated method stub
		em.merge(master);
	}

	public void addNewDesign(SciDrawingRef master) {
		em.persist(master);
		
	}

	public void addRevision(SciDrwingDetails details) {
		SciDrawingRef ref  = details.getSciDrawingRef();
		ref = em.find(SciDrawingRef.class, ref.getSeqDrawingId());
		
		details.setSciDrawingRef(ref);
		
		em.merge(ref);
		em.merge(details);
		
	}

	public List searchUnappDesign(SciDrawingRef command) {
		String query = " select  dd.SEQ_DRW_DTLID, dd.ORIGINAL_DOC, dd.DOCUMENT_VERSION, dm.DOCUMENT_NAME, dm.DRAWING_DESC, dm.DRWING_REFNUM, dd.UPDATED_DATE,dm.SEQ_DRAWING_ID ,dd.DRAWING_STATUS,dd.REJECT_COMMENT from   scigenics.SCI_DRAWING_REF dm, scigenics.SCI_DRWING_DETAILS dd  where  dm.SEQ_DRAWING_ID = dd.SCI_DRWING_ID and dm.SEQ_WORK_ID = :wmwork and dd.DRAWING_STATUS in ('N') ";
		Query wquery = null;
		 wquery = em.createNativeQuery(query);
			
		 wquery.setParameter("wmwork", command.getSciWorkorderMaster().getSeqWorkId());
		 List desobjlist =  wquery.getResultList();
	       List deslist = createVOList(desobjlist);
		return deslist;
	}

	public List loadDocs() {
		
		return em.createQuery("from SciDesignDocMaster").getResultList();
	}

	public List searchApprovedDesignWork(SciDrawingRef command) {
		String query = " select  dd.SEQ_DRW_DTLID, dd.ORIGINAL_DOC, dd.DOCUMENT_VERSION, dm.DOCUMENT_NAME, dm.DRAWING_DESC, dm.DRWING_REFNUM, dd.UPDATED_DATE ,dm.SEQ_DRAWING_ID ,dd.DRAWING_STATUS,dd.REJECT_COMMENT from   scigenics.SCI_DRAWING_REF dm, scigenics.SCI_DRWING_DETAILS dd  where  dm.SEQ_DRAWING_ID = dd.SCI_DRWING_ID and dm.SEQ_WORK_ID = :wmwork and dd.DRAWING_STATUS = 'Y' and dd.SEQ_DRW_DTLID = (select max(ds.SEQ_DRW_DTLID) from scigenics.SCI_DRWING_DETAILS ds where ds.SCI_DRWING_ID = dm.SEQ_DRAWING_ID)";
		Query wquery = null;
		 wquery = em.createNativeQuery(query);
		
		 wquery.setParameter("wmwork", command.getSciWorkorderMaster().getSeqWorkId());
		 List desobjlist =  wquery.getResultList();
	       List deslist = createVOList(desobjlist);
		return deslist;
	}

	public SciDrwingDetails getDetail(Long seqDrawingId) {
		// TODO Auto-generated method stub
		return em.find(SciDrwingDetails.class, seqDrawingId);
	}

	public void addDesgDocMaster(SciDesignDocMaster master) {
		em.persist(master);
		
	}

	public void addDesignPlan(List<SciWoDesgDocs> finalist) {
		for(SciWoDesgDocs wo:finalist) {
			em.persist(wo);
		}
		
	}

	public List loadDesgPlan(SciWorkorderMaster wmaster) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("from SciWoDesgDocs m where m.sciWorkorderMaster =:sciWorkorderMaster");
		q.setParameter("sciWorkorderMaster", wmaster);
		return q.getResultList();
	}

	public SciDrwingDetails loadDrawingdetails(Long seqDrawdtlid) {
		// TODO Auto-generated method stub
		return em.find(SciDrwingDetails.class, seqDrawdtlid);
	}
	
	private List createVOList(List objectList) {
		List drawinglist = new ArrayList();
		for(int idx=0;idx < objectList.size();idx++) {
			Object[] arr = (Object[]) objectList.get(idx);
			DrawingDetailsBean  bean = new DrawingDetailsBean();
			bean.setSeqDrwDtlid( new Long(((BigDecimal)arr[0]).toString()));
			bean.setOriginalDoc((String) arr[1]);
			bean.setDocumentVersion( new Long(((BigDecimal)arr[2]).toString()));
			bean.setDrawingStatus((String)arr[8]);
			bean.setRejectComments((String)arr[9]);
			SciDrawingRef ref = new SciDrawingRef();
			
			ref.setDocumentName((String) arr[3]);
			ref.setDrawingDesc((String) arr[4]);
			ref.setDrwingRefnum((String) arr[5]);
			
			ref.setSeqDrawingId( new Long(((BigDecimal)arr[7]).toString()));
			
			bean.setSciDrawingRef(ref);
			bean.setUpdatedDate((Date) arr[6]);
			drawinglist.add(bean);
		}
		return drawinglist;
	}


	
	public List loadPendingDrawing(SciWorkorderMaster wmaster) {
		// TODO Auto-generated method stub
		Query qry = em.createQuery("from SciWoDesgDocs d   where" +
				" d.sciWorkorderMaster =:sciWorkorderMaster )");
		
		qry.setParameter("sciWorkorderMaster", wmaster);
		List mylist = qry.getResultList();
		System.out.println(mylist.size());
		return mylist;
	}

	public void rejectDesign(String seqdrwinglist, String rejectedBy,String rejectComments) {
		String query = "update SciDrwingDetails set drawingStatus='R', rejectedBy= :approvedBy ,rejectComments = :rejectComments ,updatedBy=:updatedBy ,updatedDate= :updatedDate " +
		" where seqDrwDtlid in ( " +seqdrwinglist+")";
Query wquery = em.createQuery(query);
wquery.setParameter("approvedBy",rejectedBy );
wquery.setParameter("updatedBy",rejectedBy );
wquery.setParameter("updatedDate",new Date() );
wquery.setParameter("rejectComments",rejectComments );
 wquery.executeUpdate();
		
	}

	public void deleteDesign(Long seqDrawindDtl) {
		Query qry = em.createNativeQuery("delete from SCI_DRWING_DETAILS where SEQ_DRW_DTLID = :seqid");
	qry.setParameter("seqid",seqDrawindDtl);
	qry.executeUpdate();
		
	}
}
