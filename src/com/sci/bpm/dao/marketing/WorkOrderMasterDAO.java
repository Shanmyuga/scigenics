package com.sci.bpm.dao.marketing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sci.bpm.chart.model.ChartModel;
import com.sci.bpm.chart.model.DataPoint;
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

	@Override
	public List<ChartModel> getWorkOrderCostStats(Long seqWorkId) {

		Query qry =em.createNativeQuery("SELECT job_desc,    wm.client_details ,    (select     pcm.total_cost    from    SCI_PROJECT_COST_MASTER pcm        where pcm.seq_work_id = wm.seq_Work_id and     pcm.cost_Category = 'Total Mechanical Material Cost ') as EstMechMatCostMarketing,      (select     pcm.total_cost    from    SCI_PROJECT_COST_MASTER pcm        where pcm.seq_work_id = wm.seq_Work_id and     pcm.cost_Category = 'Total EI Material Cost ') as EstEIMatCostMarketing,    (SELECT NVL(SUM((mi.mat_qty_mod * mi.EST_UNIT_COST) ),0)    FROM sci_matind_master mi    WHERE mi.approved_status = 'Y'    AND mi.pur_status NOT   IN      (SELECT seq_lov_id FROM sci_lookup_master lm WHERE lm.lov_name='MI_CANCEL'      )    AND mi.seq_work_id = wm.seq_work_id    ) AS approved_mi_estimated_cost,    (SELECT COUNT(1)    FROM sci_matind_master mi    WHERE mi.approved_status = 'Y'    AND mi.pur_status NOT   IN      (SELECT seq_lov_id FROM sci_lookup_master lm WHERE lm.lov_name='MI_CANCEL'      )    AND mi.seq_work_id = wm.seq_work_id    ) AS approved_mi_count,    (SELECT COUNT(1)    FROM sci_matind_master mi,      sci_mattype_master mt    WHERE mi.approved_status = 'Y'    AND mi.pur_status NOT   IN      (SELECT seq_lov_id FROM sci_lookup_master lm WHERE lm.lov_name='MI_CANCEL'      )    AND mi.seq_work_id         = wm.seq_work_id    AND SUBSTR(mi.matcode,1,2) = mt.mat_code    AND mt.mat_dept LIKE 'MECH%'    ) AS approved_mi_MECH_count,    (SELECT COUNT(1)    FROM sci_matind_master mi,      sci_mattype_master mt    WHERE mi.approved_status = 'Y'    AND mi.pur_status NOT   IN      (SELECT seq_lov_id FROM sci_lookup_master lm WHERE lm.lov_name='MI_CANCEL'      )    AND mi.seq_work_id         = wm.seq_work_id    AND SUBSTR(mi.matcode,1,2) = mt.mat_code    AND mt.mat_dept LIKE 'E%'    ) AS approved_mi_EI_count,    (SELECT SUM((mi.mat_qty_mod * mi.unit_cost) )    FROM sci_matind_master mi    WHERE mi.unit_cost     > 0    AND mi.approved_status = 'Y'    AND mi.seq_work_id     = wm.seq_work_id    ) AS itemized_mi_cost,    (SELECT COUNT(1)    FROM sci_matind_master mi    WHERE mi.unit_cost     > 0    AND mi.approved_status = 'Y'    AND mi.seq_work_id     = wm.seq_work_id    ) AS itemized_mi_count,    (SELECT SUM((mi.unit_cost * rm.RECD_QUANTITY) )    FROM sci_matind_master mi,      sci_recd_materials rm    WHERE rm.seq_mi_id             = mi.seq_mi_id    AND is_numeric(recd_quantity) <> -200    AND mi.seq_work_id             = wm.seq_work_id    ) AS received_mi_cost,    (SELECT COUNT((mi.unit_cost * rm.RECD_QUANTITY) )    FROM sci_matind_master mi,      sci_recd_materials rm    WHERE rm.seq_mi_id             = mi.seq_mi_id    AND is_numeric(recd_quantity) <> -200    AND mi.seq_work_id             = wm.seq_work_id    ) AS recd_mi_count,    ((SELECT SUM((ISSUE_CNT_MOD * mi2.unit_Cost) )    FROM SCI_STOREISSUE_MASTER l,      sci_matind_master mi,      sci_mattype_master mt,      sci_matind_master mi2,      SCI_STORES_REQUEST st    WHERE l.seq_mi_id   = mi2.seq_mi_id    AND st.SEQ_STREQ_ID = l.SEQ_STREQ_ID    AND st.seq_mi_id    = mi.seq_mi_id      AND SUBSTR(mi.matcode,1,2) = mt.mat_code    AND mt.mat_dept LIKE 'MECH%'    AND mi.seq_work_id  = wm.seq_work_id    )  -     (                  SELECT                      nvl(SUM( (ret_quantity * mi2.unit_cost) ),0)                  FROM                      sci_storeissue_master l,                      sci_matind_master mi,                        sci_mattype_master mt,                      sci_matind_master mi2,                      sci_stores_request st,                                  Sci_returnitems_request rte    WHERE l.seq_mi_id   = mi2.seq_mi_id    AND st.SEQ_STREQ_ID = l.SEQ_STREQ_ID    AND st.seq_mi_id    = mi.seq_mi_id    AND mi.seq_work_id  = wm.seq_work_id     AND SUBSTR(mi.matcode,1,2) = mt.mat_code    AND mt.mat_dept LIKE 'MECH%'    AND rte.seq_stissue_id = l.seq_stissue_id    and rte.request_status = 'Y'                  )) AS issued__mech_cost,                             ((SELECT SUM((ISSUE_CNT_MOD * mi2.unit_Cost) )    FROM SCI_STOREISSUE_MASTER l,      sci_matind_master mi,      sci_mattype_master mt,      sci_matind_master mi2,      SCI_STORES_REQUEST st    WHERE l.seq_mi_id   = mi2.seq_mi_id    AND st.SEQ_STREQ_ID = l.SEQ_STREQ_ID    AND st.seq_mi_id    = mi.seq_mi_id      AND SUBSTR(mi.matcode,1,2) = mt.mat_code    AND mt.mat_dept LIKE 'E%'    AND mi.seq_work_id  = wm.seq_work_id    )  -     (                  SELECT                      nvl(SUM( (ret_quantity * mi2.unit_cost) ),0)                  FROM                      sci_storeissue_master l,                      sci_matind_master mi,                        sci_mattype_master mt,                      sci_matind_master mi2,                      sci_stores_request st,                                  Sci_returnitems_request rte    WHERE l.seq_mi_id   = mi2.seq_mi_id    AND st.SEQ_STREQ_ID = l.SEQ_STREQ_ID    AND st.seq_mi_id    = mi.seq_mi_id    AND mi.seq_work_id  = wm.seq_work_id     AND SUBSTR(mi.matcode,1,2) = mt.mat_code    AND mt.mat_dept LIKE 'E%'    AND rte.seq_stissue_id = l.seq_stissue_id    and rte.request_status = 'Y'                  )) AS issued__ei_cost,    (SELECT COUNT(1 )    FROM SCI_STOREISSUE_MASTER l,      sci_matind_master mi,      sci_matind_master mi2,      SCI_STORES_REQUEST st    WHERE l.seq_mi_id   = mi2.seq_mi_id    AND st.SEQ_STREQ_ID = l.SEQ_STREQ_ID    AND st.seq_mi_id    = mi.seq_mi_id    AND mi.seq_work_id  = wm.seq_work_id    ) AS Issued_mi_count,    (SELECT COUNT(1 )    FROM SCI_STOREISSUE_MASTER l,      sci_matind_master mi,      sci_matind_master mi2,      SCI_STORES_REQUEST st,      sci_mattype_master mt    WHERE l.seq_mi_id           = mi2.seq_mi_id    AND st.SEQ_STREQ_ID         = l.SEQ_STREQ_ID    AND st.seq_mi_id            = mi.seq_mi_id    AND mi.seq_work_id          = wm.seq_work_id    AND SUBSTR(mi2.matcode,1,2) = mt.mat_code    AND mt.mat_dept             = 'MECH'    ) AS Issued_mech_count,    (SELECT COUNT(1 )    FROM SCI_STOREISSUE_MASTER l,      sci_matind_master mi,      sci_matind_master mi2,      SCI_STORES_REQUEST st,      sci_mattype_master mt    WHERE l.seq_mi_id           = mi2.seq_mi_id    AND st.SEQ_STREQ_ID         = l.SEQ_STREQ_ID    AND st.seq_mi_id            = mi.seq_mi_id    AND mi.seq_work_id          = wm.seq_work_id    AND SUBSTR(mi2.matcode,1,2) = mt.mat_code    AND mt.mat_dept LIKE 'E%'    ) AS Issued_ei_count,    wm.WORK_CREATE_DT  FROM SCI_WORKORDER_MASTER wm  WHERE wm.wo_status NOT IN ('C','I')  AND wm.work_create_dt   >'1-Jan-2012'  AND wm.word_order_type IN ('Fermenter')  and wm.seq_work_id = ?  ORDER BY WORK_CREATE_DT DESC");

		qry.setParameter(1,seqWorkId);
		List<Object[]> results =  qry.getResultList();
List<ChartModel> charts = new ArrayList<ChartModel>();
		if(results.size() > 0 ) {
			ChartModel model = new ChartModel();
			model.setType("column");
			model.setName("Estimated Cost");
			model.setLegendText("Estimated Cost in Rupees");
			model.setShowInLegend(new Boolean(true));
			Object[] array = results.get(0);
			DataPoint point = new DataPoint();
			point.setLabel("Electronic Cost");





			if(array[3] instanceof BigDecimal) {
				point.setY(new Double(((BigDecimal) (array[3]==null?0:array[3])).doubleValue()));

			}
			if(array[3] instanceof Integer) {

				point.setY(new Double(((Integer) (array[3]==null?0:array[3])).doubleValue()));
			}
			model.addDataPoint(point);
			point = new DataPoint();
			point.setLabel("Mechanical Cost");
			if(array[4] instanceof BigDecimal) {
				point.setY(new Double(((BigDecimal) (array[4]==null?0:array[4])).doubleValue()));

			}
			if(array[4] instanceof Integer) {

				point.setY(new Double(((Integer) (array[4]==null?0:array[4])).doubleValue()));
			}
			model.addDataPoint(point);
			charts.add(model);
			model = new ChartModel();
			model.setType("column");
			model.setName("Actual Issued Cost");
			model.setLegendText("Actual Issued Cost in Rupees");
			model.setShowInLegend(new Boolean(true));

			 point = new DataPoint();
			point.setLabel("Electronic Cost");
			if(array[13] instanceof BigDecimal) {
				point.setY(new Double(((BigDecimal) (array[13]==null?0:array[13])).doubleValue()));

			}
			if(array[13] instanceof Integer) {

				point.setY(new Double(((Integer) (array[13]==null?0:array[13])).doubleValue()));
			}
			model.addDataPoint(point);
			point = new DataPoint();
			point.setLabel("Mechanical Cost");
			if(array[12] instanceof BigDecimal) {
				point.setY(new Double(((BigDecimal) (array[12]==null?0:array[12])).doubleValue()));

			}
			if(array[12] instanceof Integer) {

				point.setY(new Double(((Integer) (array[12]==null?0:array[12])).doubleValue()));
			}
			model.addDataPoint(point);
			charts.add(model);
		}
		return charts;
	}


}
