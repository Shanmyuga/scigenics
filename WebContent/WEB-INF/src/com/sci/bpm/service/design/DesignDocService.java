package com.sci.bpm.service.design;

import java.util.List;

import com.sci.bpm.command.mi.MatindCommand;
import com.sci.bpm.db.model.SciDesignDocMaster;
import com.sci.bpm.db.model.SciDrawingRef;
import com.sci.bpm.db.model.SciDrwingDetails;
import com.sci.bpm.db.model.SciMatindMaster;
import com.sci.bpm.db.model.SciWoDesgDocs;
import com.sci.bpm.db.model.SciWorkorderMaster;

public interface DesignDocService {

	
public void addNewDesign(SciDrawingRef master);
	
	
	public List searchDesign(MatindCommand command);
	public List searchUnappDesign(SciDrawingRef command);
	public void approveDesign(String seqdrwinglist,String approvedBy);
	public void rejectDesign(String seqdrwinglist,String rejectedBy,String rejectComments);
	public List searchDesignWorkOrder(SciDrawingRef command);
	public List searchApprovedDesignWork(SciDrawingRef command);
	public void updateDesign(SciDrawingRef master);
	public void cancelDesign(SciDrawingRef master);
	public void addRevision(SciDrwingDetails details);
	public void addDesgDocMaster(SciDesignDocMaster master);
	public List loadDocs();
	public void addDesignPlan(List<SciWoDesgDocs> finalist);
	public SciDrwingDetails loadDrawingdetails(Long seqDrawdtlid);
	public List loadDesgPlan(SciWorkorderMaster wmaster);
	public void deleteDesign(Long seqDrawindDtl);
	public List loadPendingDrawing(SciWorkorderMaster wmaster);
	
}
