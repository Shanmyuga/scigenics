package com.sci.bpm.service.qc;

import java.util.List;

import com.sci.bpm.command.qc.QualityControlBean;
import com.sci.bpm.db.model.SciQcDocs;
import com.sci.bpm.db.model.SciQcMaster;
import com.sci.bpm.db.model.SciQcMiMaster;
import com.sci.bpm.db.model.SciRejectedMaterials;
import com.sci.bpm.db.model.SciStoreMaster;

public interface QCService {

	public List loadQCItems(String deptid);
	public List loadQCItems(String deptid,String approval);
	
	public boolean addQCResult(SciQcMaster master,SciStoreMaster stmaster);
	
	public boolean updateQCResult(SciQcMiMaster master,SciRejectedMaterials rejected);
	public List loadAllListIssueDocs(QualityControlBean bean);
	public List loadMiList(String seqItemId);
	
	public List loadunapprovedList(String deptid);
	public List loadAllList(QualityControlBean bean);
	public List loadAllListDocs(QualityControlBean bean);
	public List loadApprovedList();
	
	public void addQCDocs(SciQcDocs doc);
	
	public void approveQC(SciQcMiMaster master);
	public List<SciQcDocs> loadQCDocs(Long seqQCID);
	
	
}
