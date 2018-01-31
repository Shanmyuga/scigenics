package com.sci.bpm.service.stores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sci.bpm.command.stores.StoresBean;
import com.sci.bpm.dao.stores.StoresDAO;
import com.sci.bpm.db.model.SciAvailableMaterials;
import com.sci.bpm.db.model.SciMatindMaster;
import com.sci.bpm.db.model.SciPurchItemMaster;
import com.sci.bpm.db.model.SciQcMiMaster;
import com.sci.bpm.db.model.SciRecdMaterials;
import com.sci.bpm.db.model.SciRejectedMaterials;
import com.sci.bpm.db.model.SciReturnitemsRequest;
import com.sci.bpm.db.model.SciStoreMaster;
import com.sci.bpm.db.model.SciStoreMiMaster;
import com.sci.bpm.db.model.SciStoreissueMaster;
import com.sci.bpm.db.model.SciStoresRequest;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoresDAO dao;
	

	public List loadPOItems(Long seqpoid,String[] seqLovid) {
		// TODO Auto-generated method stub
		return dao.loadPOItems(seqpoid,seqLovid);
	}


	


	public List searchQCApprovedMI(Long seqmiid) {
		// TODO Auto-generated method stub
		return dao.searchQCApprovedMI(seqmiid);
	}


	public List<SciMatindMaster> selectMis(SciPurchItemMaster seqitemid) {
		// TODO Auto-generated method stub
		return dao.selectMis(seqitemid);
	}


	public void issueItems(SciStoreissueMaster master) {
		// TODO Auto-generated method stub
		dao.issueItems(master);
	}


	public List<SciAvailableMaterials> viewStore(StoresBean command) {
		// TODO Auto-generated method stub
		return dao.viewStore(command);
	}


	public List getMatItems(SciPurchItemMaster master) {
		// TODO Auto-generated method stub
		return dao.getMatItems(master);
	}





	public void addNewStore(SciStoreMaster storeitems,
			SciPurchItemMaster master, List<SciMatindMaster> milist) {
		
		dao.addNewStore(storeitems, master,null);
		for(SciMatindMaster mis :milist) {
			dao.updateMi(mis);
		}
	}





	public void addNewtoStores(SciStoreMiMaster master, SciQcMiMaster qcmi,String qcstatus,SciRecdMaterials recditem) {
		dao.addNewtoStores(master, qcmi, qcstatus,recditem);
		
	}





	public List getQCUpdateS() {
		// TODO Auto-generated method stub
		return dao.getQCUpdateS();
	}





	public void updateQCData(SciStoreMiMaster stmi, SciQcMiMaster qcdata,SciAvailableMaterials availmat,Long mistatus) {
		
		dao.updateQCData(stmi, qcdata,availmat,mistatus);
	}





	public List<SciAvailableMaterials> getMiData(Long seqMiId, String matCode) {
		// TODO Auto-generated method stub
		return dao.getMiData(seqMiId, matCode);
	}





	public SciStoreMiMaster getStoreData(Long seqMiid) {
		// TODO Auto-generated method stub
		return dao.getStoreData(seqMiid);
	}





	public List getRecdMIs(Long seqMiid) {
		// TODO Auto-generated method stub
		return dao.getRecdMIs(seqMiid);
	}





	public List loadStoreRequest(StoresBean command) {
		// TODO Auto-generated method stub
		return dao.loadStoreRequest(command);
	}





	





	public List loadStoreissueList(StoresBean bean) {
		
		return dao.loadStoreissueList(bean);
	}





	public void issueItems(SciStoreissueMaster master,
			SciAvailableMaterials availdata, SciStoresRequest request) {
	dao.issueItems(master, availdata, request);
		
	}





	public List<SciRecdMaterials> viewrecd(StoresBean command) {
		// TODO Auto-generated method stub
		return dao.viewrecd(command);
	}





	public List loadReturnRequest(StoresBean bean) {
		// TODO Auto-generated method stub
		return dao.loadReturnRequest(bean);
	}





	public void addStoreReturns(SciReturnitemsRequest request,
			SciStoreissueMaster stissue) {
		dao.addStoreReturns(request, stissue);
		
	}





	public List loadReturnupdates() {
		// TODO Auto-generated method stub
		return dao.loadReturnupdates();
	}





	public void addReturntoStores(SciAvailableMaterials availmat,
			SciReturnitemsRequest request) {
		// TODO Auto-generated method stub
		dao.addReturntoStores(availmat, request);
	}





	public void addDamagedMaterial(SciRejectedMaterials dmater,
			SciReturnitemsRequest request) {
		// TODO Auto-generated method stub
		dao.addDamagedMaterial(dmater, request);
	}





	public List viewStorereqIssues(SciStoresRequest request) {
		// TODO Auto-generated method stub
		return dao.viewStorereqIssues(request);
	}





	public List loadissueAcceptance() {
		// TODO Auto-generated method stub
		return dao.loadissueAcceptance();
	}





	public void updateIssueMaster(SciStoreissueMaster issuemaster) {
		// TODO Auto-generated method stub
		dao.updateIssueMaster(issuemaster);
	}

	@Override
	public void cancelStoresRequest(SciStoresRequest request) {
		dao.cancelStoresRequest(request);
	}


}
