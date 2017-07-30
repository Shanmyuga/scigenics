package com.sci.bpm.service.design;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sci.bpm.command.mi.MatindCommand;
import com.sci.bpm.dao.design.DesignDocDAO;
import com.sci.bpm.db.model.SciDesignDocMaster;
import com.sci.bpm.db.model.SciDrawingRef;
import com.sci.bpm.db.model.SciDrwingDetails;
import com.sci.bpm.db.model.SciWoDesgDocs;
import com.sci.bpm.db.model.SciWorkorderMaster;

@Service("designservice")
@Transactional
public class DesignDocServiceImpl implements DesignDocService {

	@Autowired
	private DesignDocDAO daoimpl;
	
	public void addNewDesign(SciDrawingRef master) {
		daoimpl.addNewDesign(master);

	}

	public void approveDesign(String seqdrwinglist, String approvedBy) {
		daoimpl.approveDesign(seqdrwinglist, approvedBy);

	}

	public void cancelDesign(SciDrawingRef master) {
		// TODO Auto-generated method stub

	}

	public List searchDesign(MatindCommand command) {
		// TODO Auto-generated method stub
		return null;
	}

	public List searchDesignWorkOrder(SciDrawingRef command) {
		// TODO Auto-generated method stub
		return daoimpl.searchDesignWorkOrder(command);
	}

	public void updateDesign(SciDrawingRef master) {
		daoimpl.updateDesign(master);

	}

	public void addRevision(SciDrwingDetails details) {
		daoimpl.addRevision(details);
		
	}

	public List searchUnappDesign(SciDrawingRef command) {
		// TODO Auto-generated method stub
		return daoimpl.searchUnappDesign(command);
	}

	public List loadDocs() {
		// TODO Auto-generated method stub
		return daoimpl.loadDocs();
	}

	public List searchApprovedDesignWork(SciDrawingRef command) {
		// TODO Auto-generated method stub
		return daoimpl.searchApprovedDesignWork(command);
	}

	public void addDesgDocMaster(SciDesignDocMaster master) {
		daoimpl.addDesgDocMaster(master);
		
	}

	public void addDesignPlan(List<SciWoDesgDocs> finalist) {
		daoimpl.addDesignPlan(finalist);
		
	}

	public List loadDesgPlan(SciWorkorderMaster wmaster) {
		// TODO Auto-generated method stub
		return daoimpl.loadDesgPlan(wmaster);
	}

	public SciDrwingDetails loadDrawingdetails(Long seqDrawdtlid) {
		// TODO Auto-generated method stub
		return daoimpl.loadDrawingdetails(seqDrawdtlid);
	}

	public List loadPendingDrawing(SciWorkorderMaster wmaster) {
		// TODO Auto-generated method stub
		return daoimpl.loadPendingDrawing(wmaster);
	}

	public void rejectDesign(String seqdrwinglist, String rejectedBy,
			String rejectComments) {
	daoimpl.rejectDesign(seqdrwinglist, rejectedBy, rejectComments);
		
	}

	public void deleteDesign(Long seqDrawindDtl) {
		// TODO Auto-generated method stub
		daoimpl.deleteDesign(seqDrawindDtl);
	}

	

}
