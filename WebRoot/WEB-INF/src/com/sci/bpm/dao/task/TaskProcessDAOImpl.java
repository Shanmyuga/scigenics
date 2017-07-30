package com.sci.bpm.dao.task;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.sci.bpm.db.model.SciIssueDetails;
import com.sci.bpm.db.model.SciIssueMaster;
import com.sci.bpm.db.model.SciReportConfiguration;

@Repository
public class TaskProcessDAOImpl implements TaskProcessDAO {

	@PersistenceContext
	private EntityManager em;

	public boolean addNewDetails(SciIssueDetails details) {
		em.merge(details.getSciIssueMaster());
		em.merge(details);
		return true;
	}

	public boolean addNewTask(SciIssueMaster master) {
		em.persist(master);
		return true;
	}

	public List<SciIssueDetails> searchOpenTask(String status, int startpage,
			String userid) {

		List<SciIssueDetails> mylist = new ArrayList();
		Query qe = em
				.createNativeQuery(
						" SELECT D.* FROM SCI_ISSUE_MASTER M ,SCI_ISSUE_DETAILS d WHERE M.SEQ_ISSUE_ID = D.SEQ_ISSUE_ID and"
								+ " M.issue_status != 'closed' and m.ISSUE_ASSIGNEDTO like ?  and d.seq_issue_dtl_id = (select max(p.seq_issue_dtl_id) from  SCI_ISSUE_DETAILS p where p.SEQ_ISSUE_ID = M.SEQ_ISSUE_ID)"
								+

								" union "
								+

								" SELECT D.* FROM SCI_ISSUE_MASTER M ,SCI_ISSUE_DETAILS d WHERE M.SEQ_ISSUE_ID = D.SEQ_ISSUE_ID and"
								+ " M.issue_status != 'closed' and m.ISSUE_CREATED_BY like ?  and d.seq_issue_dtl_id = (select max(p.seq_issue_dtl_id) from  SCI_ISSUE_DETAILS p where p.SEQ_ISSUE_ID = M.SEQ_ISSUE_ID)",
						SciIssueDetails.class);

		qe.setParameter(1, "%" + userid + "%");
		qe.setParameter(2, "%" + userid + "%");
		mylist.addAll(qe.getResultList());

		return mylist;
	}

	public boolean updateDetails(List<SciIssueDetails> detailList) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getNextSeqTaskID() {
		Query myquery = em
				.createNativeQuery("SELECT SCI_ISSUE_MASTER_SEQ.nextval from dual ");
		BigDecimal seqid = (BigDecimal) myquery.getSingleResult();

		return seqid.toPlainString();
	}

	public SciIssueDetails loadDetails(String seqid) {

		return em.find(SciIssueDetails.class, new Long(seqid));
	}

	public boolean closeTasks(SciIssueDetails issueDetails) {
		em.merge(issueDetails);
		return false;
	}

	public List<SciIssueDetails> escalateTasks(int numberofDays) {

		List mylist = new ArrayList();
		try {
			String myqry = " select idt  from SciIssueDetails idt join idt.sciIssueMaster im"
					+ " where  im.issueStatus = 'open' and "
					+ "idt.seqIssueDtlId =   (select max(imt.seqIssueDtlId) from "
					+ " SciIssueDetails imt where imt.sciIssueMaster.seqIssueId =im.seqIssueId ) and "
					+ "idt.assignedDate < :assignedDate ";

			Query qry = em.createQuery(myqry);

			Calendar mycal = GregorianCalendar.getInstance();
			mycal.setTime(new Date());
			mycal.add(Calendar.DATE, -numberofDays);
			qry.setParameter("assignedDate", mycal.getTime());
			mylist = qry.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mylist;
	}

	public Map<String, Map<Integer, String>> getTotalCount() {
		Map<String, Map<Integer, String>> datamap = null;
		try {
			datamap = new java.util.TreeMap<String, Map<Integer, String>>();
			Date mydate = new Date();

			Calendar mycaleder = Calendar.getInstance();
			mycaleder.add(Calendar.DATE, -1);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String yesterdayDate = format.format(mycaleder.getTime());
			String month = mycaleder.getDisplayName(Calendar.MONDAY,
					Calendar.LONG, Locale.getDefault());
			System.out.println("shanmuga inside rep dao");
			Query recdqry = em
					.createNativeQuery("select nvl(sum(costy),0),count(costy)  from ( SELECT (to_number(recd_quantity) * mi.unit_cost) as costy ,mi.unit_cost,   l.* FROM sci_recd_materials l,   sci_matind_master mi WHERE IS_NUMERIC(recd_quantity) <> -200  and l.inserted_date >= to_Date(to_char(sysdate-1,'yyyymmdd'),'yyyymmdd') and l.inserted_Date < to_Date(to_char(sysdate,'yyyymmdd'),'yyyymmdd') AND mi.seq_mi_id            = l.seq_mi_id ORDER BY costy DESC) ");
			// BigDecimal recdCost = (BigDecimal) recdqry.getResultList();

			datamap.put("1. Recd Cost of the Material for  " + yesterdayDate,
					getResultData(recdqry.getResultList(), new TreeMap()));
			Query issuedqry = em
					.createNativeQuery("select nvl(sum(costy),0),count(costy)  from (  SELECT (ISSUE_CNT_MOD * mi.unit_Cost) as costy ,   l.* FROM SCI_STOREISSUE_MASTER l,   sci_matind_master mi WHERE to_number(ISSUE_CNT_MOD) <> 0 AND l.inserted_date >= to_Date(to_char(sysdate-1,'yyyymmdd'),'yyyymmdd') and  l.inserted_Date < to_Date(to_char(sysdate,'yyyymmdd'),'yyyymmdd') AND mi.seq_mi_id            = l.seq_mi_id ORDER BY costy DESC) ");

			datamap.put("2. Issued Cost of the Material for " + yesterdayDate,
					getResultData(issuedqry.getResultList(), new TreeMap()));
			Query availqry = em
					.createNativeQuery("select nvl(sum(costy),0),count(costy)  from ( select  (mi.unit_cost * adt1.avail_qty ) as costy from sci_available_materials_audit adt1 , sci_matind_master mi,(select seq_avail_id id1 ,min(updated_date) upd from sci_available_materials_audit adt where adt.inserted_Date >= to_Date(to_char(sysdate-1,'yyyymmdd'),'yyyymmdd') and  adt.inserted_Date < to_Date(to_char(sysdate,'yyyymmdd'),'yyyymmdd') group by seq_avail_id ) de  where adt1.seq_avail_id = de.id1 and adt1.updated_date = de.upd and mi.seq_mi_id = adt1.seq_mi_id) ");

			datamap.put("3. Added Cost of the Material to Stores for "
					+ yesterdayDate,
					getResultData(availqry.getResultList(), new TreeMap()));

			Query qcqry = em
					.createNativeQuery("select nvl(sum(costy),0),count(costy)  from ( SELECT (to_number(QC_APP_CNT) * mi.unit_cost) as costy ,mi.unit_cost,   l.* FROM SCI_QC_MI_MASTER l,   sci_matind_master mi WHERE IS_NUMERIC(QC_APP_CNT) <> -200 and l.QC_APPROVAL_DATE is not null and  l.QC_APPROVAL_DATE >= to_Date(to_char(sysdate-1,'yyyymmdd'),'yyyymmdd') and  l.QC_APPROVAL_DATE < to_Date(to_char(sysdate,'yyyymmdd'),'yyyymmdd') AND mi.seq_mi_id            = l.seq_mi_id ORDER BY costy DESC) ");

			datamap.put("4. QC Cost of the Material to Stores for "
					+ yesterdayDate,
					getResultData(qcqry.getResultList(), new TreeMap()));

			Query qcmechqry = em
					.createNativeQuery("select nvl(sum(costy),0),count(costy)  from ( SELECT (to_number(QC_APP_CNT) * mi.unit_cost) as costy ,mi.unit_cost,   l.* FROM SCI_QC_MI_MASTER l,   sci_matind_master mi , sci_mattype_master mt WHERE IS_NUMERIC(QC_APP_CNT) <> -200 and l.QC_APPROVAL_DATE is not null and  l.QC_APPROVAL_DATE >= to_Date(to_char(sysdate-1,'yyyymmdd'),'yyyymmdd') and  l.QC_APPROVAL_DATE < to_Date(to_char(sysdate,'yyyymmdd'),'yyyymmdd') AND mi.seq_mi_id            = l.seq_mi_id  and substr(mi.matcode,1,2) = mt.mat_code and mt.mat_dept = 'MECH' ORDER BY costy DESC) ");

			datamap.put("4.1 QC Cost of the Mech Material to Stores for "
					+ yesterdayDate,
					getResultData(qcmechqry.getResultList(), new TreeMap()));
			Query qceiqry = em
					.createNativeQuery("select nvl(sum(costy),0),count(costy)  from ( SELECT (to_number(QC_APP_CNT) * mi.unit_cost) as costy ,mi.unit_cost,   l.* FROM SCI_QC_MI_MASTER l,   sci_matind_master mi, sci_mattype_master mt WHERE IS_NUMERIC(QC_APP_CNT) <> -200 and l.QC_APPROVAL_DATE is not null and  l.QC_APPROVAL_DATE >= to_Date(to_char(sysdate-1,'yyyymmdd'),'yyyymmdd') and  l.QC_APPROVAL_DATE < to_Date(to_char(sysdate,'yyyymmdd'),'yyyymmdd') AND mi.seq_mi_id            = l.seq_mi_id  and substr(mi.matcode,1,2) = mt.mat_code and mt.mat_dept like 'E%' ORDER BY costy DESC) ");

			datamap.put("4.2 QC Cost of the EI Material to Stores for "
					+ yesterdayDate,
					getResultData(qceiqry.getResultList(), new TreeMap()));

			Query monrecdqry = em
					.createNativeQuery("select nvl(sum(costy),0),count(costy)  from ( SELECT (to_number(recd_quantity) * mi.unit_cost) as costy ,mi.unit_cost,   l.* FROM sci_recd_materials l,   sci_matind_master mi WHERE IS_NUMERIC(recd_quantity) <> -200  and to_Char(l.inserted_date,'yyyymmdd') >= to_char(to_Date(to_char(sysdate-1,'yyyymmdd'),'yyyymmdd') ,'yyyymm')||'01' and l.inserted_date <  to_Date(TO_CHAR(sysdate,'yyyymmdd'),'yyyymmdd') AND mi.seq_mi_id            = l.seq_mi_id ORDER BY costy DESC) ");

			datamap.put("5. Recd Cost of the Material for the Month of "
					+ month,
					getResultData(monrecdqry.getResultList(), new TreeMap()));
			Query monissueqry = em
					.createNativeQuery("select nvl(sum(costy),0),count(costy)  from (  SELECT (ISSUE_CNT_MOD * mi.unit_Cost) as costy ,   l.* FROM SCI_STOREISSUE_MASTER l,   sci_matind_master mi WHERE to_number(ISSUE_CNT_MOD) <> 0 AND to_Char(l.inserted_date,'yyyymmdd') >= to_char(to_Date(to_char(sysdate-1,'yyyymmdd'),'yyyymmdd') ,'yyyymm')||'01' AND  l.inserted_date <  to_Date(TO_CHAR(sysdate,'yyyymmdd'),'yyyymmdd') and mi.seq_mi_id            = l.seq_mi_id ORDER BY costy DESC) ");

			datamap.put("6. Issued Cost of the Material for " + month,
					getResultData(monissueqry.getResultList(), new TreeMap()));
			Query monavailqry = em
					.createNativeQuery("select nvl(sum(costy),0),count(costy)  from ( select  (mi.unit_cost * adt1.avail_qty ) as costy from sci_available_materials_audit adt1 , sci_matind_master mi,(select seq_avail_id id1 ,min(updated_date) upd from sci_available_materials_audit adt where  to_Char(adt.inserted_date,'yyyymmdd') >= to_char(to_Date(to_char(sysdate-1,'yyyymmdd'),'yyyymmdd') ,'yyyymm')||'01'and adt.inserted_date <  to_Date(TO_CHAR(sysdate,'yyyymmdd'),'yyyymmdd') group by seq_avail_id ) de  where adt1.seq_avail_id = de.id1 and adt1.updated_date = de.upd and mi.seq_mi_id = adt1.seq_mi_id) ");

			datamap.put("7. Added Cost of the Material to Stores for " + month,
					getResultData(monavailqry.getResultList(), new TreeMap()));

			Query monqcqry = em
					.createNativeQuery("select nvl(sum(costy),0),count(costy)  from ( SELECT (to_number(QC_APP_CNT) * mi.unit_cost) as costy ,mi.unit_cost,   l.* FROM SCI_QC_MI_MASTER l,   sci_matind_master mi WHERE IS_NUMERIC(QC_APP_CNT) <> -200 and l.QC_APPROVAL_DATE is not null and  to_Char(l.QC_APPROVAL_DATE,'yyyymmdd') >= to_char(to_Date(to_char(sysdate-1,'yyyymmdd'),'yyyymmdd') ,'yyyymm')||'01' AND l.QC_APPROVAL_DATE <  to_Date(TO_CHAR(sysdate,'yyyymmdd'),'yyyymmdd') and mi.seq_mi_id            = l.seq_mi_id ORDER BY costy DESC) ");

			datamap.put("8. QC Cost of the Material to Stores for " + month,
					getResultData(monqcqry.getResultList(), new TreeMap()));

			Query totalcost = em
					.createNativeQuery("select nvl(sum (costy),0),count(costy) from (  SELECT (to_number(avail_qty) * mi.unit_cost) as costy ,mi.unit_cost,   l.* FROM sci_Available_materials l,   sci_matind_master mi WHERE IS_NUMERIC(Avail_qty) <> -200 and is_numeric(avail_qty) <> 0  AND mi.seq_mi_id            = l.seq_mi_id ORDER BY costy DESC)  ");

			/*
			 * datamap.put(
			 * "9. Total Cost of the Stores Materials Available till today ",
			 * getResultData(totalcost.getResultList(), new TreeMap()));
			 */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datamap;
	}

	private Map<Integer, String> getResultData(List resultSet,
			TreeMap<Integer, String> datamap) {
		if (resultSet.size() > 0) {
			Object[] array = (Object[]) resultSet.get(0);
			for (int idx = 0; idx < array.length; idx++) {
				datamap.put(idx, array[idx].toString());
			}
		}
		return (Map) datamap;
	}

	public List<Map<Integer, String>> getWOTotalCount() {
		List<Map<Integer, String>> datalist = null;
		try {
			datalist = new ArrayList<Map<Integer, String>>();

			Query workorder = em
					.createNativeQuery("SELECT job_desc,   wm.client_details ,   (SELECT NVL(SUM((mi.mat_qty_mod * mi.EST_UNIT_COST) ),0)   FROM sci_matind_master mi   WHERE mi.approved_status = 'Y'   AND mi.pur_status NOT   IN     (SELECT seq_lov_id FROM sci_lookup_master lm WHERE lm.lov_name='MI_CANCEL'     )   AND mi.seq_work_id = wm.seq_work_id   ) AS approved_mi_estimated_cost,   (SELECT COUNT(1)   FROM sci_matind_master mi   WHERE mi.approved_status = 'Y'   AND mi.pur_status NOT   IN     (SELECT seq_lov_id FROM sci_lookup_master lm WHERE lm.lov_name='MI_CANCEL'     )   AND mi.seq_work_id = wm.seq_work_id   ) AS approved_mi_count,    (SELECT COUNT(1)   FROM sci_matind_master mi,     sci_mattype_master mt   WHERE mi.approved_status = 'Y'   AND mi.pur_status NOT   IN     (SELECT seq_lov_id FROM sci_lookup_master lm WHERE lm.lov_name='MI_CANCEL'     )   AND mi.seq_work_id = wm.seq_work_id    and substr(mi.matcode,1,2) = mt.mat_code and   mt.mat_dept like 'MECH%'   ) AS approved_mi_MECH_count,    (SELECT COUNT(1)   FROM sci_matind_master mi,     sci_mattype_master mt   WHERE mi.approved_status = 'Y'   AND mi.pur_status NOT   IN     (SELECT seq_lov_id FROM sci_lookup_master lm WHERE lm.lov_name='MI_CANCEL'     )   AND mi.seq_work_id = wm.seq_work_id    and substr(mi.matcode,1,2) = mt.mat_code and   mt.mat_dept like 'E%'   ) AS approved_mi_EI_count,   (SELECT SUM((mi.mat_qty_mod * mi.unit_cost) )   FROM sci_matind_master mi   WHERE mi.unit_cost     > 0   AND mi.approved_status = 'Y'   AND mi.seq_work_id     = wm.seq_work_id   ) AS itemized_mi_cost,   (SELECT COUNT(1)   FROM sci_matind_master mi   WHERE mi.unit_cost     > 0   AND mi.approved_status = 'Y'   AND mi.seq_work_id     = wm.seq_work_id   ) AS itemized_mi_count,   (SELECT SUM((mi.unit_cost * rm.RECD_QUANTITY) )   FROM sci_matind_master mi,     sci_recd_materials rm   WHERE rm.seq_mi_id             = mi.seq_mi_id   AND is_numeric(recd_quantity) <> -200   AND mi.seq_work_id             = wm.seq_work_id   ) AS received_mi_cost,   (SELECT COUNT((mi.unit_cost * rm.RECD_QUANTITY) )   FROM sci_matind_master mi,     sci_recd_materials rm   WHERE rm.seq_mi_id             = mi.seq_mi_id   AND is_numeric(recd_quantity) <> -200   AND mi.seq_work_id             = wm.seq_work_id   ) AS recd_mi_count,   (SELECT SUM((ISSUE_CNT_MOD * mi2.unit_Cost) )   FROM SCI_STOREISSUE_MASTER l,     sci_matind_master mi,     sci_matind_master mi2,     SCI_STORES_REQUEST st   WHERE l.seq_mi_id   = mi2.seq_mi_id   AND st.SEQ_STREQ_ID = l.SEQ_STREQ_ID   AND st.seq_mi_id    = mi.seq_mi_id   AND mi.seq_work_id  = wm.seq_work_id   ) AS Issued_cost,   (SELECT COUNT(1 )   FROM SCI_STOREISSUE_MASTER l,     sci_matind_master mi,     sci_matind_master mi2,     SCI_STORES_REQUEST st   WHERE l.seq_mi_id   = mi2.seq_mi_id   AND st.SEQ_STREQ_ID = l.SEQ_STREQ_ID   AND st.seq_mi_id    = mi.seq_mi_id   AND mi.seq_work_id  = wm.seq_work_id   ) AS Issued_mi_count,   (SELECT COUNT(1 )   FROM SCI_STOREISSUE_MASTER l,     sci_matind_master mi,     sci_matind_master mi2,     SCI_STORES_REQUEST st,     sci_mattype_master mt   WHERE l.seq_mi_id   = mi2.seq_mi_id   AND st.SEQ_STREQ_ID = l.SEQ_STREQ_ID   AND st.seq_mi_id    = mi.seq_mi_id   AND mi.seq_work_id  = wm.seq_work_id   and substr(mi2.matcode,1,2) = mt.mat_code and   mt.mat_dept = 'MECH'   ) AS Issued_mech_count,        (SELECT COUNT(1 )   FROM SCI_STOREISSUE_MASTER l,     sci_matind_master mi,     sci_matind_master mi2,     SCI_STORES_REQUEST st,     sci_mattype_master mt   WHERE l.seq_mi_id   = mi2.seq_mi_id   AND st.SEQ_STREQ_ID = l.SEQ_STREQ_ID   AND st.seq_mi_id    = mi.seq_mi_id   AND mi.seq_work_id  = wm.seq_work_id   and substr(mi2.matcode,1,2) = mt.mat_code and   mt.mat_dept like 'E%'   ) AS Issued_ei_count,   wm.WORK_CREATE_DT FROM SCI_WORKORDER_MASTER wm WHERE wm.wo_status NOT IN ('C','I') AND wm.work_create_dt   >'1-Jan-2012' AND wm.word_order_type IN ('Fermenter') ORDER BY WORK_CREATE_DT DESC");

			List resultSet = workorder.getResultList();
			// System.out.println("theujj " +re.size());
			for (int i = 0; i < resultSet.size(); i++) {
				Object[] array = (Object[]) resultSet.get(i);
				Map<Integer, String> datamap = new TreeMap<Integer, String>();
				for (int idx = 0; idx < array.length; idx++) {
					if (array[idx] == null) {
						datamap.put(idx, "0");
					} else {
						datamap.put(idx, array[idx].toString());
					}
				}
				datalist.add(datamap);
			}
			System.out.println("theujj " + datalist.size());
		} catch (Exception e) {

		}
		return datalist;
	}

	public List<SciReportConfiguration> loadDailyReports() {
		// TODO Auto-generated method stub
		Query qry = em
				.createQuery("Select m from SciReportConfiguration m where m.reportStatus  = 'A' and m.reportSchedule= 'DAILY' ");

		return qry.getResultList();
	}

	public List<java.util.LinkedHashMap<String, Object>> generateReports(
			String sqlQuery) {
		Session session = (Session) em.getDelegate();
		java.sql.Connection connection = session.connection();

		List<LinkedHashMap<String, Object>> mylist = new ArrayList<LinkedHashMap<String, Object>>();
		Statement st;
		try {
			st = connection.createStatement();

			ResultSet rs = st.executeQuery(sqlQuery);
			ResultSetMetaData metadata = rs.getMetaData();
			LinkedHashMap<String, Object> colnamemap = new LinkedHashMap<String, Object>();
			for (int i = 0; i < metadata.getColumnCount(); i++) {
				colnamemap.put(metadata.getColumnName(i + 1),
						metadata.getColumnName(i + 1));
			}
			mylist.add(colnamemap);

			while (rs.next()) {
				LinkedHashMap<String, Object> rowMap = new java.util.LinkedHashMap<String, Object>();

				for (int i = 0; i < metadata.getColumnCount(); i++) {
					Object value = rs.getObject(i + 1);
					String colname = metadata.getColumnName(i + 1);
					rowMap.put(colname, value);
				}

				mylist.add(rowMap);
				System.out.println("");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mylist;
	}

	public List<SciReportConfiguration> loadWeeklyReports() {
		Query qry = em
				.createQuery("Select m from SciReportConfiguration m where m.reportStatus  = 'A' and m.reportSchedule= 'WEEKLY' ");

		return qry.getResultList();
	}

}
