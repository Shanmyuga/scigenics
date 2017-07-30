package com.sci.bpm.dao.qc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sci.bpm.command.qc.QualityControlBean;
import com.sci.bpm.db.model.SciAvailableMaterials;
import com.sci.bpm.db.model.SciPurchItemMaster;
import com.sci.bpm.db.model.SciPurchaseMast;
import com.sci.bpm.db.model.SciQcDocs;
import com.sci.bpm.db.model.SciQcMaster;
import com.sci.bpm.db.model.SciQcMiMaster;
import com.sci.bpm.db.model.SciRawMIDetails;
import com.sci.bpm.db.model.SciRejectedMaterials;
import com.sci.bpm.db.model.SciStoreMaster;
import com.sci.bpm.db.model.SciWorkorderMaster;

@Repository
public class QCDaoImpl implements QCDao {

	@PersistenceContext
	private EntityManager em;
	
	

	public List loadQCItems() {
	 Query qry = em.createQuery("select m from SciQcMiMaster m where  m.ocStatus = 'N'   ");
	 List mylist = qry.getResultList();
	 
		return mylist;
	}

	public boolean addQCResult(SciQcMaster master, SciStoreMaster stmaster) {
		em.persist(master);
		
		em.merge(stmaster);
		return true;
	}

	public List loadMiList(String seqItemId) {
		// TODO Auto-generated method stub
		em.find(SciPurchItemMaster.class, new Long(seqItemId));
		return null;
	}

	public boolean updateQCResult(SciQcMiMaster master) {
		
		em.merge(master);
	         	return true;
	}

	public List loadApprovedList() {
		Query qry = em.createQuery("select m from SciQcMiMaster m where m.qcTestsApproval = 'Y'  ");
		 List mylist = qry.getResultList();
		 
			return mylist;
	}

	public List loadunapprovedList() {
		Query qry = em.createQuery("select m from SciQcMiMaster m where m.qcTestsApproval = 'N' and m.ocStatus = 'Y' ");
		 List mylist = qry.getResultList();
		 
			return mylist;
	}

	public List<SciQcDocs> loadQCDocs(Long seqQCID) {
		// TODO Auto-generated method stub
		Query qry = em.createQuery("select m from SciQcDocs m where m.seqQcId =:seqQCId ");
		qry.setParameter("seqQCId", seqQCID);
		return qry.getResultList();
	}

	public void addQCDocs(SciQcDocs doc) {
		// TODO Auto-generated method stub
		em.persist(doc);
	}

	public void approveQC(SciQcMiMaster master) {
		// TODO Auto-generated method stub
		em.merge(master);
	}

	public List loadunapprovedList(String deptid) {
		// TODO Auto-generated method stub
		Query qry = em.createQuery("select distinct m from SciQcMiMaster m,SciMattypeMaster sm where substr(m.matCode,1,2) = sm.matCode and sm.matDept =:dept and m.qcTestsApproval = 'N' and m.ocStatus='Y' ");
		qry.setParameter("dept", deptid);
		 List mylist = qry.getResultList();
		 
			return mylist;
	}

	public List loadQCItems(String deptid) {
		 Query qry = em.createQuery("select m from SciQcMiMaster m ,SciMattypeMaster sm where substr(m.matCode,1,2) = sm.matCode and sm.matDept =:dept and  m.ocStatus = 'N'  ");
		 qry.setParameter("dept", deptid);
		 List mylist = qry.getResultList();
		 
			return mylist;
	}

	public boolean updateQCResult(SciQcMiMaster master,
			SciRejectedMaterials rejected) {
		em.merge(master);
		if(rejected != null) {
			em.persist(rejected);
		}
     	return true;
	}

	public List loadAllList(QualityControlBean command) {
		// TODO Auto-generated method stub
		String query = "Select distinct m from SciQcMiMaster m ,SciMattypeMaster mt where mt.matCode  = substr(m.matCode,1,2) and m.ocStatus != 'N' ";
		// Query query = em.createQuery("Select * from SciMatindMaster m ");
		SciWorkorderMaster wmaster = null;
		if(command.getSeqWorkId() != null && !"".equals(command.getSeqWorkId())) {
			wmaster = em.find(SciWorkorderMaster.class, new Long(command.getSeqWorkId()));
		}
		Map parameters = new HashMap();
		String whereClause = "";
		if (command.getFromdate() != null) {
			whereClause = whereClause + " and  m.updatedDt >= :fromdate ";
			// parameters.add(command.getMatDuedate());
			parameters.put("fromdate", command.getFromdate());
		}
		if (command.getTodate() != null ) {
			whereClause = whereClause + " and m.updatedDt <= :todate ";
			parameters.put("todate", command.getTodate());
		}
		
		
		if (command.getMatCategory() != null && !"".equals(command.getMatCategory())) {
			whereClause = whereClause + " and substr(m.matCode,3,2) = :matcat ";
			parameters.put("matcat", command.getMatCategory());
		}
		if (command.getMaterialCode() != null && !"".equals(command.getMaterialCode())) {
			whereClause = whereClause + " and m.matCode = :matcode ";
			parameters.put("matcode", command.getMaterialCode());
		}
		if (command.getMatDept() != null && !"".equals(command.getMatDept())) {
			whereClause = whereClause + " and mt.matDept = :matdept ";
			parameters.put("matdept", command.getMatDept());
		}
		
		if (command.getSeqQcMiId() != null) {
			whereClause = whereClause + " and  m.sciMiMaster.seqMiId=:seqQCMIid ";
			parameters.put("seqQCMIid", command.getSeqQcMiId());
		}
		if (wmaster != null) {
			whereClause = whereClause + " and m.sciMiMaster.sciWorkorderMaster = :wm ";
			parameters.put("wm", wmaster);
		}
		Query wquery = null;
		if (parameters.size() > 0) {
			wquery = em.createQuery(query
					+ whereClause.replaceAll("where and", "where"));
		} else {
			wquery = em.createQuery(query);
		}
		Iterator keyset = parameters.keySet().iterator();

		while (keyset.hasNext()) {
			String key = (String) keyset.next();
			wquery.setParameter(key, parameters.get(key));
		}
		Query docquery = em.createQuery("from SciQcDocs d where d.seqQcId =:seqQCId order by updatedDt desc");
		List<SciQcMiMaster> qcmilist = wquery.getResultList();
		for(SciQcMiMaster m : qcmilist) {
			docquery.setParameter("seqQCId", m.getSeqQcMiId());
			List<SciQcDocs> doclist = docquery.getResultList();
			if(doclist.size() > 0) {
				m.setSeqQCDoc(doclist.get(0));
			}
			}
		return qcmilist;
	
	}
	
	public List loadQCItems(String deptid, String approval) {
		 Query qry = em.createQuery("select m from SciQcMiMaster m ,SciMattypeMaster sm where substr(m.matCode,1,2) = sm.matCode and sm.matDept =:dept and  m.ocStatus = 'N' and m.qcTestsApproval =:approval  ");
		 qry.setParameter("dept", deptid);
		 qry.setParameter("approval", approval);
		 List mylist = qry.getResultList();
		 
			return mylist;
	}

	public List loadAllListDocs(QualityControlBean command) {
		// TODO Auto-generated method stub
		String query = "Select distinct m from SciQcMiMaster m ,SciMattypeMaster mt where mt.matCode  = substr(m.matCode,1,2)  ";
		// Query query = em.createQuery("Select * from SciMatindMaster m ");
		SciWorkorderMaster wmaster = null;
		if(command.getSeqWorkId() != null && !"".equals(command.getSeqWorkId())) {
			wmaster = em.find(SciWorkorderMaster.class, new Long(command.getSeqWorkId()));
		}
		Map parameters = new HashMap();
		String whereClause = "";
		if (command.getFromdate() != null) {
			whereClause = whereClause + " and  m.updatedDt >= :fromdate ";
			// parameters.add(command.getMatDuedate());
			parameters.put("fromdate", command.getFromdate());
		}
		if (command.getTodate() != null ) {
			whereClause = whereClause + " and m.updatedDt <= :todate ";
			parameters.put("todate", command.getTodate());
		}
		if (command.getQcTestsApproval() != null ) {
			whereClause = whereClause + " and m.qcTestsApproval = :approval ";
			parameters.put("approval", command.getQcTestsApproval());
		}
		
		
		
		if (command.getMatCategory() != null && !"".equals(command.getMatCategory())) {
			whereClause = whereClause + " and substr(m.matCode,3,2) = :matcat ";
			parameters.put("matcat", command.getMatCategory());
		}
		if (command.getMaterialCode() != null && !"".equals(command.getMaterialCode())) {
			whereClause = whereClause + " and m.matCode = :matcode ";
			parameters.put("matcode", command.getMaterialCode());
		}
		if (command.getMatDept() != null && !"".equals(command.getMatDept())) {
			whereClause = whereClause + " and mt.matDept = :matdept ";
			parameters.put("matdept", command.getMatDept());
		}
		if (command.getSeqMiID() != null && !"".equals(command.getSeqMiID())) {
			whereClause = whereClause + " and m.sciMiMaster.seqMiId = :seqMiId ";
			parameters.put("seqMiId", command.getSeqMiID());
		}
		if (wmaster != null) {
			whereClause = whereClause + " and m.sciMiMaster.sciWorkorderMaster = :wm ";
			parameters.put("wm", wmaster);
		}
		Query wquery = null;
		if (parameters.size() > 0) {
			wquery = em.createQuery(query
					+ whereClause.replaceAll("where and", "where"));
		} else {
			wquery = em.createQuery(query);
		}
		Iterator keyset = parameters.keySet().iterator();

		while (keyset.hasNext()) {
			String key = (String) keyset.next();
			wquery.setParameter(key, parameters.get(key));
		}
		if(command.getMaxResults() != null) {
			wquery.setMaxResults(Integer.parseInt(command.getMaxResults()));
		}
		List<SciAvailableMaterials> milist = wquery.getResultList();
		return wquery.getResultList();
	}

	public List loadAllListIssueDocs(QualityControlBean bean) {
		Query myquery = em.createNativeQuery("SELECT ism.SEQ_MI_ID  AS ISSUE_MI,    req.SEQ_MI_ID       AS REQUEST_MI,    ism.matcode         AS mat_code,    mi.RECOMMEND        AS REMARKS,    ism.ISSUE_DATE      AS issue_date,    ism.MAT_SPEC        AS ISSUE_MAT,    ISSUE_CNT_MOD -(select sum(ret_quantity) from sci_returnitems_request rt where rt.seq_stissue_id = ism.seq_stissue_id and rt.request_status = 'Y')    AS issue_CNT,    ism.ISSUE_DIMENSION AS issue_dim,    qc.SEQ_QC_MI_ID,    qc.qc_tests_cond,    qc.mat_spec,    wm.job_desc       AS Job_Desc,    wm.client_details AS Client_details,    mi.mi_for_type    AS mifortype,    (select mat_type from sci_mattype_master mt where mt.mat_code = substr(ism.MATCODE,1,2)) as mat_type   FROM SCI_STOREISSUE_MASTER ism,    sci_matind_master mi,    SCI_STORES_REQUEST req,    sci_qc_mi_master qc,    sci_Workorder_master wm  WHERE ism.SEQ_STREQ_ID = req.SEQ_STREQ_ID  AND qc.SEQ_MI_ID       = ism.SEQ_MI_ID  AND mi.SEQ_MI_ID       = req.SEQ_MI_ID  AND mi.seq_work_id     = wm.seq_work_id  AND mi.seq_work_id     =:seq_work_id ");
		
		myquery.setParameter("seq_work_id", bean.getSeqWorkId());
		
		return loadItemsList(myquery.getResultList());
	}
	
	private List<QualityControlBean> loadItemsList(List<Object[]> queryList) {
		List<QualityControlBean> mylist = new ArrayList<QualityControlBean>();
		for(Object[] row:queryList) {
			QualityControlBean bean = new QualityControlBean();
			
			bean.setIssueMI(row[0].toString());
			bean.setRequestMI(row[1].toString());
			bean.setMaterialCode(row[2].toString());
			bean.setMirecommend(row[3]==null?"":row[3].toString());
			bean.setSeqQcMiId(new Long(row[8].toString()));
			bean.setQcTestsCond(row[9]==null?"":row[9].toString());
			bean.setMaterSpec(row[10]==null?"":row[10].toString());
			bean.setMiFortype(row[13]==null?"":row[13].toString());
			bean.setMattype(row[14]==null?"":row[14].toString());
			bean.setIssueCnt(row[6]==null?"0":row[6].toString());
			mylist.add(bean);
		}
		return mylist;
	}

	public List<SciRawMIDetails> getRawMidata(Long seqsubcontMiId) {
		System.out.println(seqsubcontMiId);
		 Query qry = em.createQuery("select m from SciRawMIDetails m where  m.seqSubContMIID =:seqSubcontmiid   ");
		 qry.setParameter("seqSubcontmiid", seqsubcontMiId);
		 List mylist = qry.getResultList();
		 
			return mylist;
	}

	public List<SciQcDocs> loadmiQCDocs(Long seqMIID) {
		Query qry = em.createQuery("select m from SciQcDocs m , SciQcMiMaster master where m.seqQcId =master.seqQcMiId and master.sciMiMaster.seqMiId =:seqmiid ");
		qry.setParameter("seqmiid", seqMIID);
		return qry.getResultList();
	}

	public List<SciPurchaseMast> loadsubcontPurchase(Long seqqcID) {
		Query qry = em.createQuery("select m from SciPurchaseMast m , SciQcMiMaster master where m.seqPurchId =master.poId and master.seqQcMiId =:seqQCId ");
		qry.setParameter("seqQCId", seqqcID);
		 return qry.getResultList();
	}

	

}
