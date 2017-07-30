package com.sci.bpm.dao.stores;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sci.bpm.command.stores.StoresBean;
import com.sci.bpm.db.model.SciAvailableMaterials;
import com.sci.bpm.db.model.SciItemmiDetails;
import com.sci.bpm.db.model.SciLookupMaster;
import com.sci.bpm.db.model.SciMatindMaster;
import com.sci.bpm.db.model.SciPurchItemMaster;
import com.sci.bpm.db.model.SciPurchaseMast;
import com.sci.bpm.db.model.SciQcMiMaster;
import com.sci.bpm.db.model.SciRecdMaterials;
import com.sci.bpm.db.model.SciRejectedMaterials;
import com.sci.bpm.db.model.SciReturnitemsRequest;
import com.sci.bpm.db.model.SciStoreMaster;
import com.sci.bpm.db.model.SciStoreMiMaster;
import com.sci.bpm.db.model.SciStoreissueMaster;
import com.sci.bpm.db.model.SciStoresRequest;

@Repository
public class StoreDAOImpl implements StoresDAO {

	@PersistenceContext
	private EntityManager em;

	public void addNewStore(List storeitems) {
		// TODO Auto-generated method stub

	}

	public List loadPOItems(Long seqpoid,Long seqLovid) {
		// TODO Auto-generated method stub

		Query query = em
				.createQuery("select pi from SciPurchItemMaster pi,SciPurchaseItemdetails pm where pm.seqItemId = pi.seaPuritemId and   pm.sciPurchaseMast =:po   ");
		SciPurchaseMast master = em.find(SciPurchaseMast.class, seqpoid);
		
		
		if(master.getPurchaseStatus().equals(seqLovid)) {
			return null;
		}
		query.setParameter("po", master);
		List<SciPurchItemMaster> mylist = query.getResultList();

		/*
		 * List milist = new ArrayList<SciMatindMaster>(); Query pucqry =
		 * em.createQuery(
		 * "select m from SciMatindMaster m,SciItemmiDetails det where m.seqMiId = det.seqMiId and det.sciPurchItemMaster =:sciitems"
		 * ); for(SciPurchItemMaster pitem : mylist) {
		 * pucqry.setParameter("sciitems", pitem);
		 * milist.add(pucqry.getResultList()); }
		 */

		return mylist;
	}

	public void addNewStore(SciStoreMaster storeitems,
			SciPurchItemMaster master, Long status) {

		em.persist(storeitems);

		em.merge(master);

	}

	public List searchQCApprovedMI(Long seqmiid) {

		Query query = em
				.createNativeQuery("select distinct sm.SEQ_ITEM_ID  from  SCI_STORE_MASTER sm ,SCI_ITEMMI_DETAILS mi ,sci_lookup_master qc where  mi.seq_puritem_id= sm.seq_item_id and  "
						+ "sm.qc_status = qc.seq_lov_id and qc.lov_name='QC_APPROVED' and mi.seq_mi_id = :miid ");
		BigDecimal seqitemid = null;
		query.setParameter("miid", seqmiid);
		List itemidlist = query.getResultList();
		if (itemidlist != null && itemidlist.size() > 0) {
			seqitemid = (BigDecimal) itemidlist.get(0);
		} else {
			return null;
		}

		Query qc = em
				.createQuery("from SciStoreMaster ms where ms.seqItemId =:itemid");
		Long seqitemidln = new Long(seqitemid.longValue());
		qc.setParameter("itemid", seqitemidln);

		List<SciStoreMaster> mylist = qc.getResultList();

		return mylist;

	}

	public List<SciAvailableMaterials> getMiData(Long seqMiId, String matCode) {
		List stlist = new ArrayList();
		if (seqMiId != null) {
			Query qc = em
					.createQuery("Select ms from SciAvailableMaterials ms Join ms.sciMiMaster m  where  m.seqMiId =:miid and  ms.availQty <> '0.0' ");
			qc.setParameter("miid", seqMiId);
			stlist.addAll(qc.getResultList());
		}
		System.out.println("stlist" +stlist.size());
		if (matCode != null) {
			Query qc = em
					.createQuery("Select ms from SciAvailableMaterials ms Join ms.sciMiMaster m where ms.matcode =:matcode and  ms.availQty <> '0.0' and m.seqMiId !=:miid");
			qc.setParameter("matcode", matCode);
			qc.setParameter("miid", seqMiId);
			if(qc.getResultList().size() > 0 ) {
				
				stlist.addAll(qc.getResultList());
			}
		}
		System.out.println("mat stlist" +stlist.size());
		return stlist;
	}

	public List<SciMatindMaster> selectMis(SciPurchItemMaster seqitemid) {
		// TODO Auto-generated method stub
		List<SciMatindMaster> milist = new ArrayList<SciMatindMaster>();
		Query qta = em
				.createQuery("from SciItemmiDetails details where details.sciPurchItemMaster =:sciitemmaster");
		qta.setParameter("sciitemmaster", seqitemid);
		List<SciItemmiDetails> midetails = qta.getResultList();
		for (SciItemmiDetails itmi : midetails) {
			SciMatindMaster mi = em.find(SciMatindMaster.class, itmi
					.getSeqMiId());
			milist.add(mi);

		}
		return milist;
	}

	public void updateMi(SciMatindMaster mi) {
		// TODO Auto-generated method stub
		em.merge(mi);
	}

	public void issueItems(SciStoreissueMaster master) {
		// TODO Auto-generated method stub
		em.persist(master);
	}

	public List<SciAvailableMaterials> viewStore(StoresBean command) {
		// TODO Auto-generated method stub

		
		String query = "Select distinct m from SciAvailableMaterials m ,SciMattypeMaster mt where mt.matCode  = substr(m.matcode,1,2) and m.availQty <> '0.0' ";
		// Query query = em.createQuery("Select * from SciMatindMaster m ");
		Map parameters = new HashMap();
		String whereClause = "";
		if (command.getFromdate() != null) {
			whereClause = whereClause + " and  m.insertedDate >= :fromdate ";
			// parameters.add(command.getMatDuedate());
			parameters.put("fromdate", command.getFromdate());
		}
		if (command.getTodate() != null ) {
			whereClause = whereClause + " and m.insertedDate <= :todate ";
			parameters.put("todate", command.getTodate());
		}
		if (command.getMatcode() != null && !"".equals(command.getMatcode().trim())) {
			whereClause = whereClause + " and m.matcode =:matcode ";
			parameters.put("matcode", command.getMatcode());
		}
		
		if (command.getMatCategory() != null && !"".equals(command.getMatCategory())) {
			whereClause = whereClause + " and substr(m.matcode,3,2) = :matcat ";
			parameters.put("matcat", command.getMatCategory());
		}
		if (command.getMatDept() != null && !"".equals(command.getMatDept())) {
			whereClause = whereClause + " and mt.matDept = :matdept ";
			parameters.put("matdept", command.getMatDept());
		}
		
		if (command.getSeqmiid() != null ) {
			whereClause = whereClause + " and m.sciMiMaster.seqMiId = :seqmiid ";
			parameters.put("seqmiid", command.getSeqmiid());
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
		List<SciAvailableMaterials> milist = wquery.getResultList();
		return wquery.getResultList();
	}

	public List getMatItems(SciPurchItemMaster master) {
		List milist = new ArrayList<SciMatindMaster>();
		Query pucqry = em
				.createQuery("select m from SciMatindMaster m,SciItemmiDetails det where m.seqMiId = det.seqMiId and det.sciPurchItemMaster =:sciitems");

		pucqry.setParameter("sciitems", master);
		List<SciMatindMaster> mylist = pucqry.getResultList();
		for (SciMatindMaster m : mylist) {
			milist.add(m);
		}

		return milist;
	}

	public void addNewtoStores(SciStoreMiMaster master, SciQcMiMaster qcmi,
			String qcstatus,SciRecdMaterials recditems) {

		SciStoreMiMaster mimaster = em.merge(master);
		qcmi.setSeqStoreMiId(mimaster.getSeqStoremiId());
		
		Query qry = em.createQuery("from SciItemmiDetails immi where immi.seqMiId =:seqmiid");
		qry.setParameter("seqmiid", qcmi.getSciMiMaster().getSeqMiId());
		List<SciItemmiDetails> details  = qry.getResultList();
		Long seqPurchitemid = 0L;
		for(SciItemmiDetails itemmi :details) {
			 seqPurchitemid = itemmi.getSciPurchItemMaster().getSeaPuritemId();
			break;
		}
		qcmi.setSeqPurchItemID(seqPurchitemid);
		recditems.setSeqPurchItemID(seqPurchitemid);
		em.persist(qcmi);
		SciMatindMaster mi =qcmi.getSciMiMaster();
		mi.setPurStatus(new Long(qcstatus));
		mi.setUpdatedBy(qcmi.getUpdatedBy());
		mi.setUpdatedDate(new Date());
		em.merge(mi);
		em.persist(recditems);
	}

	public List getQCUpdateS() {
		Query qp = em
				.createQuery("Select m from SciQcMiMaster m where m.qcTestsApproval = 'Y' and m.ocStatus != 'D'");
		List<SciQcMiMaster> qclist = qp.getResultList();
		Query qsmi = em
				.createQuery("Select m from SciStoreMiMaster m where m.seqStoremiId =:seqStoremiId or m.sciMiMaster =:mimaster ");
		List myList = new ArrayList();
		for (SciQcMiMaster qc : qclist) {
			qsmi.setParameter("seqStoremiId", qc.getSeqStoreMiId());
			qsmi.setParameter("mimaster", qc.getSciMiMaster());
			qc.setStmimaster((SciStoreMiMaster) qsmi.getResultList().get(0));
			myList.add(qc);
		}
		return myList;
	}

	public void updateQCData(SciStoreMiMaster stmi, SciQcMiMaster qcdata,SciAvailableMaterials availmat,Long mistatus) {
		em.merge(stmi);
		em.merge(qcdata);
		if(availmat != null) {
		em.persist(availmat);
		}
		SciMatindMaster mi = qcdata.getSciMiMaster();
		mi.setPurStatus(mistatus);
		mi.setUpdatedBy(qcdata.getUpdatedBy());
		mi.setUpdatedDate(new Date());
		em.merge(mi);
	}

	public SciStoreMiMaster getStoreData(Long seqMiid) {
		Query qsmi = em
				.createQuery("Select d from SciStoreMiMaster d Join  d.sciMiMaster m where m.seqMiId =:seqmiid");

		qsmi.setParameter("seqmiid", seqMiid);
		SciStoreMiMaster stmi = null;
		List stmilist = qsmi.getResultList();
		if (stmilist.size() > 0) {
			stmi = (SciStoreMiMaster) stmilist.get(0);
		}

		return stmi;
	}

	public List getRecdMIs(Long seqMiid) {

		Query qsmi = em
				.createQuery("Select d from SciRecdMaterials d Join  d.sciMiMaster m where m.seqMiId =:seqmiid");

		qsmi.setParameter("seqmiid", seqMiid);
		return qsmi.getResultList();
	}

	public List loadStoreRequest(StoresBean command) {
		System.out.println("insider dao");
		String query = "Select distinct m from SciStoresRequest m ,SciMattypeMaster mt where mt.matCode  = substr(m.matcode,1,2) and m.purchApproval='Y' and m.prodApproval = 'Y' and m.requestStatus = 'N' ";
		// Query query = em.createQuery("Select * from SciMatindMaster m ");
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
			whereClause = whereClause + " and substr(m.matcode,3,2) = :matcat ";
			parameters.put("matcat", command.getMatCategory());
		}
		if (command.getMatDept() != null && !"".equals(command.getMatDept())) {
			whereClause = whereClause + " and mt.matDept = :matdept ";
			parameters.put("matdept", command.getMatDept());
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
		List<SciStoresRequest> milist = wquery.getResultList();
		System.out.println(milist.size());
		return milist;
		
		
	}

	

	public List loadStoreissueList(StoresBean command) {
		String query = "Select distinct m from SciStoreissueMaster m ,SciMattypeMaster mt where mt.matCode  = substr(m.matcode,1,2) ";
		// Query query = em.createQuery("Select * from SciMatindMaster m ");
		Map parameters = new HashMap();
		String whereClause = "";
		if (command.getFromdate() != null) {
			whereClause = whereClause + " and  m.insertedDate >= :fromdate ";
			// parameters.add(command.getMatDuedate());
			parameters.put("fromdate", command.getFromdate());
		}
		if (command.getTodate() != null ) {
			whereClause = whereClause + " and m.insertedDate <= :todate ";
			parameters.put("todate", command.getTodate());
		}
		
		if (command.getMatCategory() != null && !"".equals(command.getMatCategory())) {
			whereClause = whereClause + " and substr(m.matcode,3,2) = :matcat ";
			parameters.put("matcat", command.getMatCategory());
		}
		if (command.getMatDept() != null && !"".equals(command.getMatDept())) {
			whereClause = whereClause + " and mt.matDept = :matdept ";
			parameters.put("matdept", command.getMatDept());
		}
		if (command.getReturnStatus() != null && !"".equals(command.getReturnStatus())) {
			whereClause = whereClause + " and m.returnStatus = :returnstat ";
			parameters.put("returnstat", command.getReturnStatus());
		}
		if (command.getSeqmiid() != null) {
			whereClause = whereClause + " and m.strequest.sciMiMaster.seqMiId = :miid ";
			parameters.put("miid", command.getSeqmiid());
		}
		if (command.getMatcode() != null && !"".equals(command.getMatcode().trim())) {
			whereClause = whereClause + " and m.matcode =:matcode ";
			parameters.put("matcode", command.getMatcode());
		}
		if (command.getRequestUserId() != null && !"".equals(command.getRequestUserId().trim())) {
			whereClause = whereClause + " and m.strequest.insertedBy =:requestUserId ";
			parameters.put("requestUserId", command.getRequestUserId());
		}
		
		if (command.getHasReturnQty() != null && !"".equals(command.getHasReturnQty().trim())) {
			whereClause = whereClause + " and m.returnStatus =:returnStatus ";
			parameters.put("returnStatus", command.getHasReturnQty());
		}
		if (command.getSeqWorkId() != null && command.getSeqWorkId() != 0) {
			whereClause = whereClause + " and m.strequest.sciMiMaster.sciWorkorderMaster.seqWorkId = :wm ";
			parameters.put("wm", command.getSeqWorkId());
		}
		if ("P".equals(command.getReturnCriteria())) {
			whereClause = whereClause + " and not exists  (Select 1 from  SciReturnitemsRequest ms Join ms.stissue m2 where m2.seqStissueId =m.seqStissueId)";
			
		}
		if ("R".equals(command.getReturnCriteria())) {
			whereClause = whereClause + " and  exists  (Select 1 from  SciReturnitemsRequest ms Join ms.stissue m2 where m2.seqStissueId =m.seqStissueId)";
			
		}
		if ("S".equals(command.getReturnCriteria())) {
			whereClause = whereClause + " and  exists  (Select 1 from  SciReturnitemsRequest ms Join ms.stissue m2 where m2.seqStissueId =m.seqStissueId and ms.prodRemarks ='SCRAP')";
			
		}
		Query wquery = null;
		if (parameters.size() > 0) {
			wquery = em.createQuery(query
					+ whereClause.replaceAll("where and", "where"));
		} else {
			wquery = em.createQuery(query+ whereClause.replaceAll("where and", "where"));
		}
		Iterator keyset = parameters.keySet().iterator();

		while (keyset.hasNext()) {
			String key = (String) keyset.next();
			wquery.setParameter(key, parameters.get(key));
		}
		wquery.setMaxResults(command.getSearchMax());
		List<SciStoreissueMaster> milist = wquery.getResultList();
		 Query storeqry = em.createQuery("Select m from SciReturnitemsRequest m Join m.stissue ms where ms.seqStissueId =:seqStissueId and m.requestStatus='Y'"); 
		 for(SciStoreissueMaster mi:milist) {
				storeqry.setParameter("seqStissueId", mi.getSeqStissueId());
				List<SciReturnitemsRequest> stlist = storeqry.getResultList();
				float totalret = 0;
				for(SciReturnitemsRequest retReq:stlist) {
					totalret = totalret + Float.parseFloat(retReq.getRetQuantity());
				}
					
				
				  float finalqty = mi.getIssueCnt().floatValue() - totalret;
				  
					mi.setFinalCount(new BigDecimal(String.valueOf(finalqty)));
					mi.setTotalReturnQty(totalret);
				}
				
				
			
		return milist;
	}

	public void issueItems(SciStoreissueMaster master,
			SciAvailableMaterials availdata, SciStoresRequest request) {
		em.persist(master);
		em.merge(availdata);
		
		SciMatindMaster mi = availdata.getSciMiMaster();
		if("Y".equals(request.getRequestStatus())) {
			SciLookupMaster lm = (SciLookupMaster) em.createQuery("from SciLookupMaster lm where lm.lovName = 'MI_ISSUED'").getSingleResult();
			SciLookupMaster lm1 = (SciLookupMaster) em.createQuery("from SciLookupMaster lm where lm.lovName = 'MI_ISSUED_FOR_OTHERS'").getSingleResult();
			if(mi.getSeqMiId().longValue() == request.getSciMiMaster().getSeqMiId().longValue()) {
				mi.setPurStatus(lm.getSeqLovId());
			}
			else {
				mi.setPurStatus(lm1.getSeqLovId());
			}
			
			em.merge(mi);
		}
		em.merge(request);
	}

	public List<SciRecdMaterials> viewrecd(StoresBean command) {
		String query = "Select distinct m from SciRecdMaterials m ,SciMattypeMaster mt ,SciPurchaseMast pm where mt.matCode  = substr(m.matcode,1,2) and pm.seqPurchId = m.poId ";
		// Query query = em.createQuery("Select * from SciMatindMaster m ");
		Map parameters = new HashMap();
		String whereClause = "";
		if (command.getFromdate() != null) {
			whereClause = whereClause + " and  m.updatedDate >= :fromdate ";
			// parameters.add(command.getMatDuedate());
			parameters.put("fromdate", command.getFromdate());
		}
		if (command.getSeqVendorID() != null) {
			whereClause = whereClause + " and  pm.sciVendorMaster.seqVendorId = :seqvendorID ";
			// parameters.add(command.getMatDuedate());
			parameters.put("seqvendorID", command.getSeqVendorID());
		}
		if (command.getSeqmiid() != null) {
			whereClause = whereClause + " and m.sciMiMaster.seqMiId =:seqMiId ";
			parameters.put("seqMiId", command.getSeqmiid());
		}
		if (command.getTodate() != null ) {
			whereClause = whereClause + " and m.updatedDate <= :todate ";
			parameters.put("todate", command.getTodate());
		}
		
		if (command.getMatCategory() != null && !"".equals(command.getMatCategory())) {
			whereClause = whereClause + " and substr(m.matcode,3,2) = :matcat ";
			parameters.put("matcat", command.getMatCategory());
		}
		if (command.getMatcode() != null && !"".equals(command.getMatcode().trim())) {
			whereClause = whereClause + " and m.matcode =:matcode ";
			parameters.put("matcode", command.getMatcode());
		}
		if (command.getMatDept() != null && !"".equals(command.getMatDept())) {
			whereClause = whereClause + " and mt.matDept = :matdept ";
			parameters.put("matdept", command.getMatDept());
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
		List<SciRecdMaterials> milist = wquery.getResultList();
		return wquery.getResultList();
	}

	public List loadReturnRequest(StoresBean command) {
		String query = "Select distinct m from SciStoreissueMaster m ,SciMattypeMaster mt where mt.matCode  = substr(m.matcode,1,2)  ";
		// Query query = em.createQuery("Select * from SciMatindMaster m ");
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
		if (command.getMatcode() != null  && !"".equals(command.getMatcode())) {
			whereClause = whereClause + " and m.matcode = :matcode ";
			parameters.put("matcode", command.getMatcode());
		}
		if (command.getSeqmiid() != null) {
			whereClause = whereClause + " and m.strequest.sciMiMaster.seqMiId = :miid ";
			parameters.put("miid", command.getSeqmiid());
		}
		if (command.getMatCategory() != null && !"".equals(command.getMatCategory())) {
			whereClause = whereClause + " and substr(m.matcode,3,2) = :matcat ";
			parameters.put("matcat", command.getMatCategory());
		}
		if (command.getMatDept() != null && !"".equals(command.getMatDept())) {
			whereClause = whereClause + " and mt.matDept = :matdept ";
			parameters.put("matdept", command.getMatDept());
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
		List<SciStoresRequest> milist = wquery.getResultList();
		System.out.println(milist.size());
		return milist;
		
	}

	public void addStoreReturns(SciReturnitemsRequest request,
			SciStoreissueMaster stissue) {
		SciStoresRequest strequest = stissue.getStrequest();
		strequest.setRequestStatus("R");
		em.merge(strequest);
		em.merge(stissue);
		em.persist(request);
		
	}

	public List loadReturnupdates() {
		// TODO Auto-generated method stub
		Query qry = em.createQuery("from SciReturnitemsRequest m where m.requestStatus is null or m.requestStatus = 'N' ");
		
		return qry.getResultList();
	}

	public void addReturntoStores(SciAvailableMaterials availmat,
			SciReturnitemsRequest request) {
		// TODO Auto-generated method stub
		em.merge(request);
		if(availmat != null) {
			em.persist(availmat);
		}
		
	}

	public void addDamagedMaterial(SciRejectedMaterials dmater,
			SciReturnitemsRequest request) {
		// TODO Auto-generated method stub
		em.merge(request);
		em.persist(dmater);
		
	}

	public List viewStorereqIssues(SciStoresRequest request) {
		Query qry = em.createQuery("from SciStoreissueMaster m where m.strequest =:request");
		qry.setParameter("request",request);
		return qry.getResultList();
	}

	public List loadissueAcceptance() {
		Query qry = em.createQuery("from SciStoreissueMaster m where m.issueAcceptance ='N'");
		
		return qry.getResultList();
	}

	public void updateIssueMaster(SciStoreissueMaster issuemaster) {
		em.merge(issuemaster);
		
	}

	

}
