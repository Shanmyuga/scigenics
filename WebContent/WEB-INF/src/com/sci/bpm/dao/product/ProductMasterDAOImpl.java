package com.sci.bpm.dao.product;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sci.bpm.db.model.SciMatcatMaster;
import com.sci.bpm.db.model.SciMatspecMaster;
import com.sci.bpm.db.model.SciProductMaster;

@Repository
public class ProductMasterDAOImpl implements ProductMasterDAO {

	
	@PersistenceContext
	private EntityManager em;
	
	public List selectProdCat() {
Query qry = em.createQuery("from SciMatcatMaster pm");
		
		return qry.getResultList();
	}

	public List selectProducts(String cat) {
		// TODO Auto-generated method stub
		System.out.println(cat);
		Query qry = em.createQuery("select pm from SciMatspecMaster pm where pm.matcatCode =:matcatCode ");
		qry.setParameter("matcatCode", cat);
		
		List mylist = qry.getResultList();
		List newList = new ArrayList();
		for(int idx=0;idx<mylist.size();idx++) {
			SciMatspecMaster pm = (SciMatspecMaster) mylist.get(idx);
			pm.setMatSpecDesc(pm.getMaterialSpec());
			newList.add(pm);
		}
		return newList;
	}

	public SciProductMaster loadProd(Long seqprodid) {
		// TODO Auto-generated method stub
		
		return em.find(SciProductMaster.class, seqprodid);
	}

	public List selectProdType() {
		// TODO Auto-generated method stub
		Query qry = em.createQuery("from SciMattypeMaster pm");
		
		return qry.getResultList();
	}

	public String getMatDept(String matTypeCode) {
		// TODO Auto-generated method stub
		Query qry = em.createQuery("Select pm.matDept from SciMattypeMaster pm where pm.matCode =:matCode");
		qry.setParameter("matCode", matTypeCode);
		String dept = (String) qry.getResultList().get(0);
		return dept;
	}

	public List selectCategory(String mattype, String matDept) {
	
		Query qry = em.createQuery("from SciMatcatMaster pm where pm.matDept =:matDept");
		
		qry.setParameter("matDept", matDept);
		
		return qry.getResultList();
	}

	public List selectProducts(String cat, String matDept) {
		Query qry = em.createQuery("select pm from SciMatspecMaster pm where pm.matcatCode =:matcatCode and pm.matDept=:matDept ");
		qry.setParameter("matcatCode", cat);
		qry.setParameter("matDept", matDept);
		List mylist = qry.getResultList();
		List newList = new ArrayList();
		for(int idx=0;idx<mylist.size();idx++) {
			SciMatspecMaster pm = (SciMatspecMaster) mylist.get(idx);
			pm.setMatSpecDesc(pm.getMaterialSpec());
			newList.add(pm);
		}
		return newList;
		
	}

	public String getMatType(String cat, String dept) {
		Query qry = em.createQuery("from SciMatcatMaster pm where pm.matcatCode=:matCode and pm.matDept =:matDept");
		qry.setParameter("matCode", cat);
		qry.setParameter("matDept", dept);
		SciMatcatMaster matcat = (SciMatcatMaster) qry.getSingleResult();
		return matcat.getMatcatType();
	}

	public List selectCategory(String matDept) {
		Query qry = em.createQuery("from SciMatcatMaster pm where pm.matDept =:matDept");
		qry.setParameter("matDept", matDept);
		return qry.getResultList();
	}
}
