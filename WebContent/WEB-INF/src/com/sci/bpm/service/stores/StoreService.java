package com.sci.bpm.service.stores;

import java.util.List;

import com.sci.bpm.command.stores.StoresBean;
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

public interface StoreService {

	
	public List loadPOItems(Long seqpoid,String[] seqLovID);
	public SciStoreMiMaster getStoreData(Long seqMiid);
	public void addNewStore(SciStoreMaster storeitems,SciPurchItemMaster master,List<SciMatindMaster> status);
	public List searchQCApprovedMI(Long seqmiid);
	public List<SciMatindMaster> selectMis(SciPurchItemMaster seqitemid);
	public void issueItems(SciStoreissueMaster master);
	public void issueItems(SciStoreissueMaster master,SciAvailableMaterials availdata,SciStoresRequest request);
	public List getMatItems(SciPurchItemMaster master);
	public List<SciAvailableMaterials> viewStore(StoresBean command);
	public List<SciRecdMaterials> viewrecd(StoresBean command);
	public void addNewtoStores(SciStoreMiMaster master ,SciQcMiMaster qcmi,String qcstatus,SciRecdMaterials recd);
	public void updateQCData(SciStoreMiMaster stmi,SciQcMiMaster qcdata,SciAvailableMaterials availmat,Long miStatus);
	public List<SciAvailableMaterials> getMiData(Long seqMiId,String matCode);
	public List loadStoreRequest(StoresBean command);
	public List getRecdMIs(Long seqMiid);
	public List getQCUpdateS();
	public List loadStoreissueList(StoresBean bean);
	public List loadReturnRequest(StoresBean bean);
	public List loadissueAcceptance();
	public void updateIssueMaster(SciStoreissueMaster issuemaster);
	public List loadReturnupdates();
	public void addReturntoStores(SciAvailableMaterials availmat,SciReturnitemsRequest request);
	public void addStoreReturns(SciReturnitemsRequest request,SciStoreissueMaster  stissue);
	public List viewStorereqIssues(SciStoresRequest request);
	public void addDamagedMaterial(SciRejectedMaterials dmater,SciReturnitemsRequest request);
	
}
