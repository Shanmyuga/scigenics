package com.sci.bpm.dao.stores;

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

public interface StoresDAO {
public List loadPOItems(Long seqpoid,Long seqlovid);
public List<SciRecdMaterials> viewrecd(StoresBean command);
public void addNewStore(SciStoreMaster storeitems,SciPurchItemMaster master,Long status);
public void issueItems(SciStoreissueMaster master,SciAvailableMaterials availdata,SciStoresRequest request);
public List searchQCApprovedMI(Long seqmiid);
public List<SciMatindMaster> selectMis(SciPurchItemMaster seqitemid);

public void updateMi(SciMatindMaster mi);
public void issueItems(SciStoreissueMaster master);
public List<SciAvailableMaterials> viewStore(StoresBean command);
public List loadissueAcceptance();
public List getMatItems(SciPurchItemMaster master);
public void updateIssueMaster(SciStoreissueMaster issuemaster);
public void updateQCData(SciStoreMiMaster stmi,SciQcMiMaster qcdata,SciAvailableMaterials availmat,Long mistatus);
public List getQCUpdateS();
public SciStoreMiMaster getStoreData(Long seqMiid);
public List<SciAvailableMaterials> getMiData(Long seqMiId,String matCode);
public List getRecdMIs(Long seqMiid);
public List loadStoreRequest(StoresBean command);
public List loadStoreissueList(StoresBean bean);
public List loadReturnRequest(StoresBean bean);
public List loadReturnupdates();
public void addNewtoStores(SciStoreMiMaster master ,SciQcMiMaster qcmi,String qcstatus,SciRecdMaterials recd);
public void addStoreReturns(SciReturnitemsRequest request,SciStoreissueMaster  stissue);
public void addReturntoStores(SciAvailableMaterials availmat,SciReturnitemsRequest request);
public List viewStorereqIssues(SciStoresRequest request);
public void addDamagedMaterial(SciRejectedMaterials dmater,SciReturnitemsRequest request);
}
