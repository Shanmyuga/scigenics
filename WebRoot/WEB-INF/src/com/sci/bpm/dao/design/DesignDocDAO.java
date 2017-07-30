package com.sci.bpm.dao.design;

import java.util.List;

import com.sci.bpm.command.mi.MatindCommand;
import com.sci.bpm.db.model.SciDesignDocMaster;
import com.sci.bpm.db.model.SciDrawingRef;
import com.sci.bpm.db.model.SciDrwingDetails;
import com.sci.bpm.db.model.SciWoDesgDocs;
import com.sci.bpm.db.model.SciWorkorderMaster;

public interface DesignDocDAO {
	public List searchDesign(MatindCommand command);
	public List searchUnappDesign(SciDrawingRef command);
	public void approveDesign(String seqdrwinglist,String approvedBy);
	public List searchDesignWorkOrder(SciDrawingRef command);
	public void updateDesign(SciDrawingRef master);
	public void cancelDesign(SciDrawingRef master);
	public void addNewDesign(SciDrawingRef master);
	public void addRevision(SciDrwingDetails details);
	public List loadDocs();
	public List searchApprovedDesignWork(SciDrawingRef command);
	public void addDesgDocMaster(SciDesignDocMaster master);
	public SciDrwingDetails getDetail(Long seqDrawingId);
	public void addDesignPlan(List<SciWoDesgDocs> finalist);
	public List loadDesgPlan(SciWorkorderMaster wmaster);
	public SciDrwingDetails loadDrawingdetails(Long seqDrawdtlid);
	public List loadPendingDrawing(SciWorkorderMaster wmaster);
	public void rejectDesign(String seqdrwinglist,String rejected,String rejectComments);
	public void deleteDesign(Long seqDrawindDtl);
}
