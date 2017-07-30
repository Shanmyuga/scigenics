package com.sci.bpm.service.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sci.bpm.dao.product.ProductMasterDAO;
import com.sci.bpm.db.model.SciMatindMaster;
import com.sci.bpm.db.model.SciProductMaster;

@Service
@Transactional
public class ProductMasterServImpl implements ProductMasterService {

	@Autowired
	private ProductMasterDAO dao;

	public List selectProdCat() {
		// TODO Auto-generated method stub
		return dao.selectProdCat();
	}

	public List selectProducts(String cat) {
		// TODO Auto-generated method stub
		return dao.selectProducts(cat);
	}

	/*public Map[] loadDesc(List<SciMatindMaster> milist) {
		// TODO Auto-generated method stub
		Map[] mymap = new HashMap[2];
		mymap[0] = new HashMap<Long, String>();
		mymap[1] = new HashMap<Long, String>();
		for (SciMatindMaster m : milist) {
			SciProductMaster prod = dao.loadProd(new m.getMatType());
			if (prod != null) {
				mymap[0].put(prod.getSeqProductId(), prod.getProductCat());
				mymap[1].put(prod.getSeqProductId(), prod.getProductSpec());
			}
		}
		return mymap;
	}*/

	public List selectProdType() {
		
		return dao.selectProdType();
	}

	public String getMatDept(String matTypeCode) {
		
		return dao.getMatDept(matTypeCode);
	}

	public List selectCategory(String mattype, String matDept) {
		
		System.out.println(mattype + " " + matDept);
		return dao.selectCategory(mattype, matDept);
	}

	public List selectProducts(String cat, String matDept) {
		
		return dao.selectProducts(cat, matDept);
	}

	public String getMatType(String cat, String dept) {
		
		return dao.getMatType(cat, dept);
	}

	public List selectCategory(String matDept) {
		// TODO Auto-generated method stub
		return dao.selectCategory(matDept);
	}

}
