package com.sci.bpm.service.proj;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sci.bpm.dao.proj.ProjTrackDao;
import com.sci.bpm.db.model.SciProjectCostMaster;
import com.sci.bpm.db.model.SciWoTrackMaster;
import com.sci.bpm.db.model.SciWorkorderMaster;

@Service("projservice")
@Transactional
public class ProjTrackServiceImpl implements ProjTrackService {

	@Autowired
	private ProjTrackDao daoimpl;

	public void addTaskPhase(SciWoTrackMaster master) {
		daoimpl.addTaskPhase(master);

	}

	public List loadWoPhases(SciWorkorderMaster master) {
		// TODO Auto-generated method stub
		return daoimpl.loadWoPhases(master);
	}

	public List loadSubPhase(String phaseMaster) {
		// TODO Auto-generated method stub
		return daoimpl.loadSubPhase(phaseMaster);
	}

	public boolean checkPhaseExist(String phaseName, String subphase,
			Long seqworkid) {
		// TODO Auto-generated method stub

		return daoimpl.checkPhaseExist(phaseName, subphase, seqworkid);
	}

	public SciWoTrackMaster loadWoMaster(String phasename, Long seqWorkId) {
		// TODO Auto-generated method stub
		return daoimpl.loadWoMaster(phasename, seqWorkId);
	}

	public void updateDates(String phasename, Long seqWorkID) {
		daoimpl.updateDates(phasename, seqWorkID);

	}

	public void updateActualDates(String phasename, String subphase,
			Long seqWorkId, Date actualStart, Date actualend) {
		daoimpl.updateActualDates(phasename, subphase, seqWorkId, actualStart,
				actualend);

	}

	public List loadProjectCost(SciWorkorderMaster wmaster) {
		// TODO Auto-generated method stub
		return daoimpl.loadProjectCost(wmaster);
	}

	public void addProjectCost(SciProjectCostMaster costmaster) {
		// TODO Auto-generated method stub
		daoimpl.addProjectCost(costmaster);
	}

}
