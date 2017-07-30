package com.sci.bpm.dao.po;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sci.bpm.command.po.POCommand;
import com.sci.bpm.command.po.PurchaseStatusCommand;
import com.sci.bpm.db.model.SciPaymentDetails;
import com.sci.bpm.db.model.SciPurchaseMast;
import com.sci.bpm.db.model.SciRejectMaterialAudit;
import com.sci.bpm.db.model.SciRejectedMaterials;
import com.sci.bpm.db.model.SciVendorInvoiceMaster;
import com.sci.bpm.db.model.SciVendorMaster;
import com.sci.bpm.db.model.SciVendorPurchaseCost;

@Repository
public class SciPurchaseMasterDAOimpl implements ISciPurchaseMastDAO {

	@PersistenceContext
	private EntityManager em;

	public void delete(SciPurchaseMast entity) {
		// TODO Auto-generated method stub

	}

	public List<SciPurchaseMast> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public SciPurchaseMast findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SciPurchaseMast> findByProperty(String propertyName,
			Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SciPurchaseMast> findByPurchaseStatus(Object purchaseStatus) {
		Query q = em
				.createQuery("from SciPurchaseMast m where m.purchaseStatus = :purstatus ");
		q.setParameter("purstatus", purchaseStatus);

		return q.getResultList();
	}

	public List<SciPurchaseMast> findByUpdatedBy(Object updatedBy) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SciPurchaseMast> findByVendorAddress(Object vendorAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SciPurchaseMast> findByVendorOrder(Object vendorOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(SciPurchaseMast entity) {
		em.persist(entity);

	}

	public SciPurchaseMast update(SciPurchaseMast entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public List searchPO(POCommand command) {

		String query = "from SciPurchaseMast m where m.purchaseStatus >= 0 ";

		
		
		Map parameters = new HashMap();
		String whereClause = "";
		if (command.getPurchaseType() != null
				&& !"".equals(command.getPurchaseType())) {
			whereClause = whereClause + " and m.purchaseType =:purtype ";
			// parameters.add(command.getMatDuedate());
			parameters.put("purtype", command.getPurchaseType());
		}
		if (command.getPurchaseStatus().intValue() != 0) {
			whereClause = whereClause + " and m.purchaseStatus = :purstatus ";
			// parameters.add(command.getMatDuedate());
			parameters.put("purstatus", command.getPurchaseStatus());
		}
		if (command.getPurchaseID() != null) {
			whereClause = whereClause + " and m.seqPurchId =:purchaseid ";
			// parameters.add(command.getMatDuedate());
			parameters.put("purchaseid", command.getPurchaseID());
		}

		if (command.getFromdate() != null) {
			whereClause = whereClause
					+ " and m.purchaseCreatedDt >= :purchasefromdate ";
			// parameters.add(command.getMatDuedate());
			parameters.put("purchasefromdate", command.getFromdate());
		}

		if (command.getTodate() != null) {
			whereClause = whereClause
					+ " and m.purchaseCreatedDt <=:purchasetodate ";
			// parameters.add(command.getMatDuedate());
			parameters.put("purchasetodate", command.getTodate());
		}
		
		if (command.getSeqVendorId() !=0 ) {
			whereClause = whereClause
					+ " and m.sciVendorMaster.seqVendorId =:vendorid ";
			// parameters.add(command.getMatDuedate());
			parameters.put("vendorid", command.getSeqVendorId());
		}
		
		if (command.getSeqWorkId() != null ) {
			whereClause = whereClause
					+ " and m.seqPurchId in (select  p.seqPurchId from PurchaseWorkOrderView p where p.seqWorkId=:seqWorkId) ";
			// parameters.add(command.getMatDuedate());
			parameters.put("seqWorkId", command.getSeqWorkId());
		}
		Iterator keyset = parameters.keySet().iterator();

		Query wquery = em.createQuery(query + whereClause);
		while (keyset.hasNext()) {
			String key = (String) keyset.next();
			wquery.setParameter(key, parameters.get(key));
		}

		return wquery.getResultList();
	}

	public List closePO(POCommand command) {

		String myquery = "select  mi.MATCODE, mi.MAT_Spec, mi.MAT_TYPE,  to_char(mi.MAT_QTY_MOD,'999999.99') as orderQuantity, qcmi.QC_APP_CNT as qccnt, qcmi.QC_REC_CNT  as recdcnt, mi.MAT_DIMESION as orderDimension, qcmi.QC_APP_DIME as qcdim,qcmi.QC_REC_DIME as recddim  "
				+ " , wm.JOB_DESC from  SCI_WORKORDER_MASTER wm , SCI_PURCHASE_MAST pm, SCI_PURCHASE_ITEMDETAILS_ pi, SCI_PURCH_ITEM_MASTER im, SCI_ITEMMI_DETAILS itmi, SCI_MATIND_MASTER mi, SCI_QC_MI_MASTER qcmi  where mi.SEQ_MI_ID = itmi.SEQ_MI_ID and "
				+ " itmi.SEQ_PURITEM_ID = im.SEA_PURITEM_ID and im.SEA_PURITEM_ID = pi.SEQ_ITEM_ID and pi.SEQ_PURCH_ID = pm.SEQ_PURCH_ID and  qcmi.SEQ_MI_ID = mi.seq_mi_id and qcmi.po_id = pm.seq_purch_id and mi.SEQ_WORK_ID = wm.SEQ_WORK_ID and pm.seq_purch_id =:purchaseid ";
		Query q = em.createNativeQuery(myquery);
		q.setParameter("purchaseid", command.getScipurchID());
		List arrayList = q.getResultList();
		List polist = new ArrayList();
		for (int idx = 0; idx < arrayList.size(); idx++) {

			Object[] arr = (Object[]) arrayList.get(idx);
			PurchaseStatusCommand comma = new PurchaseStatusCommand(
					(String) arr[0], (String) arr[1], (String) arr[2],
					(String) arr[3], (String) arr[4], (String) arr[5],
					(String) arr[6], (String) arr[7], (String) arr[8], null,
					(String) arr[9]);
			polist.add(comma);
		}
		return polist;
	}

	public List viewRejected(POCommand command) {
		String query = "Select distinct m from SciRejectedMaterials m ,SciMattypeMaster mt where mt.matCode  = substr(m.matcode,1,2)  ";
		// Query query = em.createQuery("Select * from SciMatindMaster m ");
		Map parameters = new HashMap();
		String whereClause = "";
		if (command.getFromdate() != null) {
			whereClause = whereClause + " and  m.rejdDate >= :fromdate ";
			// parameters.add(command.getMatDuedate());
			parameters.put("fromdate", command.getFromdate());
		}
		if (command.getTodate() != null) {
			whereClause = whereClause + " and m.rejdDate <= :todate ";
			parameters.put("todate", command.getTodate());
		}

		if (command.getMatCategory() != null
				&& !"".equals(command.getMatCategory())) {
			whereClause = whereClause + " and substr(m.matcode,3,2) = :matcat ";
			parameters.put("matcat", command.getMatCategory());
		}
		if (command.getMatDept() != null && !"".equals(command.getMatDept())) {
			whereClause = whereClause + " and mt.matDept = :matdept ";
			parameters.put("matdept", command.getMatDept());
		}

		if (command.getFilterStatus() != null
				&& !"".equals(command.getFilterStatus())) {
			whereClause = whereClause + " and m.rejectStatus = :filterstatus ";
			parameters.put("filterstatus", command.getFilterStatus());
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
		List<SciRejectedMaterials> milist = wquery.getResultList();
		System.out.println(milist.size());
		return milist;
	}

	public void updateReject(SciRejectedMaterials mater,
			SciRejectMaterialAudit audit) {
		em.merge(mater);
		em.persist(audit);

	}

	public void cancelPO(SciPurchaseMast master) {
		System.out.println( master.getSeqPurchId());
		Query qry = em
				.createNativeQuery("update SCI_MATIND_MASTER mi set mi.PUR_STATUS = (select seq_lov_id from scigenics.SCI_LOOKUP_MASTER lm where lm.lov_name = 'MI_APPROVED'),unit_cost =0.00   where mi.seq_mi_id in "
						+ "(select seq_mi_id from  SCI_ITEMMI_DETAILS im where im.SEQ_PURITEM_ID in "
						+ "(select SEQ_ITEM_ID from SCI_PURCHASE_ITEMDETAILS_ where   SEQ_PURCH_ID = :poid)) and mi.pur_status in (select seq_lov_id from scigenics.SCI_LOOKUP_MASTER lm where lm.lov_name in ( 'MI_PURCHASE_CREATED','MI_PO_ORDERED'))");
		qry.setParameter("poid", master.getSeqPurchId());
		int count = qry.executeUpdate();
		System.out.println("count" + count);
		if(count > 0 ) { 
				em.merge(master);
				
		}			

	}

	public void despatchPO(SciPurchaseMast master) {
		em.merge(master);
		
	}

	public void addPaymentDetails(SciPaymentDetails details) {
		
		em.persist(details);
		/*Query qry = em.createQuery("Select m from SciVendorInvoiceMaster m where  m.sciVendorMaster.seqVendorId =:seqVendorID and finalAmount > 0 order by billDate asc");
		qry.setParameter("seqVendorID", details.getSciVendorMaster().getSeqVendorId());
		List<SciVendorInvoiceMaster> vendorIssueMaster = qry.getResultList();
		if(vendorIssueMaster.size() <= 0) {
			SciVendorInvoiceMaster master = new SciVendorInvoiceMaster();
			master.setBillDate(details.getPaymentDate());
			master.setBillAmount(new Double(-details.getPaymentAmt().doubleValue()));
			master.setSciVendorMaster(details.getSciVendorMaster());
			master.setUpdatedBy(details.getInsertedBy());
			master.setInsertedDate(details.getInsertedDate());
			master.setUpdatedDate(details.getInsertedDate());
			master.setInsertedBy(details.getInsertedBy());
			master.setBillNo("ADVANCE");
			master.setPoId(100L);
			master.setFinalAmount(new Double(-details.getPaymentAmt().doubleValue()));
			em.persist(master);
			return;
		}
		double paymentAmout = details.getPaymentAmt().doubleValue();
		for(SciVendorInvoiceMaster vm:vendorIssueMaster) {
			double billamt = vm.getFinalAmount().doubleValue();
			if(paymentAmout > billamt) {
				vm.setAdjustAmount(billamt);
				vm.setFinalAmount(new Double(0.0));
				paymentAmout = paymentAmout - billamt;
				vm.setSeqPaymentID(details.getSeqPaymentId());
			}
			else  {
				vm.setAdjustAmount(paymentAmout);
				vm.setFinalAmount(billamt-paymentAmout);
				vm.setSeqPaymentID(details.getSeqPaymentId());
				paymentAmout = new Double(0) ;
				break;
			}
		}
		
		if(paymentAmout > 0) {
			SciVendorInvoiceMaster master = new SciVendorInvoiceMaster();
			master.setBillDate(details.getPaymentDate());
			master.setBillAmount(new Double(-paymentAmout));
			master.setSciVendorMaster(details.getSciVendorMaster());
			master.setUpdatedBy(details.getInsertedBy());
			master.setInsertedDate(details.getInsertedDate());
			master.setUpdatedDate(details.getInsertedDate());
			master.setBillNo("ADVANCE");
			master.setPoId(100L);
			master.setInsertedBy(details.getInsertedBy());
			master.setFinalAmount(new Double(-paymentAmout));
			em.persist(master);
		}*/
	}

	public List<SciPaymentDetails> loadPaymentDetails() {
		// TODO Auto-generated method stub
		Query qry = em.createQuery("Select m from SciPaymentDetails m order by paymentDate desc");
		return qry.getResultList();
	}

	public SciVendorMaster loadSciVendorMaster(Long seqVendorID) {
		// TODO Auto-generated method stub
		return em.find(SciVendorMaster.class, seqVendorID);
	}

	public void addInvoiceDetails(SciVendorInvoiceMaster vmaster) {
		// TODO Auto-generated method stub
		em.persist(vmaster);
	}

	public List<SciVendorInvoiceMaster> loadInvoiceDetails() {
		Query qry = em.createQuery("Select m from SciVendorInvoiceMaster m order by billDate desc");
		return qry.getResultList();
	}

	public List<SciPurchaseMast> loadPODetails(Long seqVendorID) {
		Query qry = em.createQuery("Select m from SciPurchaseMast m where m.sciVendorMaster.seqVendorId =:seqVendorID ");
		qry.setParameter("seqVendorID", seqVendorID);
		return qry.getResultList();
	}

	@Override
	public List<SciVendorInvoiceMaster> loadbillNo(Long seqVendorID) {
		// TODO Auto-generated method stub
		
		Query qry = em.createQuery("Select m from SciVendorInvoiceMaster m where m.sciVendorMaster.seqVendorId=:seqVendorID order by billDate desc");
		
		qry.setParameter("seqVendorID", seqVendorID);
		return qry.getResultList();
	}

	@Override
	public void addPurchaseVendorCost(SciVendorPurchaseCost purchaseCost) {
		// TODO Auto-generated method stub
		em.persist(purchaseCost);
	}

	@Override
	public List<SciVendorPurchaseCost> loadQuotations(String matDept,
			String matCategory) {
		Query qry = em.createQuery("Select m from SciVendorPurchaseCost m where m.matDept=:matDept and m.matCategory=:matCategory order by matCost asc");
		
		qry.setParameter("matDept", matDept);
		qry.setParameter("matCategory", matCategory);
		return qry.getResultList();
	}

}
