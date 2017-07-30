package com.sci.bpm.dao.qc;

import java.util.List;

import com.sci.bpm.command.qc.QualityControlBean;
import com.sci.bpm.db.model.SciPurchaseMast;
import com.sci.bpm.db.model.SciQcDocs;
import com.sci.bpm.db.model.SciQcMaster;
import com.sci.bpm.db.model.SciQcMiMaster;
import com.sci.bpm.db.model.SciRawMIDetails;
import com.sci.bpm.db.model.SciRejectedMaterials;
import com.sci.bpm.db.model.SciStoreMaster;

public interface QCDao {

	public List loadQCItems(String deptid);
	public List loadQCItems(String deptid,String approval);
	public List loadunapprovedList(String deptid);

	public List loadApprovedList();

	public boolean addQCResult(SciQcMaster master, SciStoreMaster stmaster);
	public void approveQC(SciQcMiMaster master);
	public List loadMiList(String seqItemId);
	public List loadAllList(QualityControlBean bean);
	public List loadAllListIssueDocs(QualityControlBean bean);
	public List loadAllListDocs(QualityControlBean bean);
	public boolean updateQCResult(SciQcMiMaster master,SciRejectedMaterials rejected);
	public void addQCDocs(SciQcDocs doc);
	public List<SciQcDocs> loadQCDocs(Long seqQCID);
	public List<SciQcDocs> loadmiQCDocs(Long seqMIID);
	
	public List<SciRawMIDetails>  getRawMidata(Long seqsubcontMiId);
	
	public List<SciPurchaseMast> loadsubcontPurchase(Long seqqcID);
}
