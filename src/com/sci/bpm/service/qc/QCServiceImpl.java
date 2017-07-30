package com.sci.bpm.service.qc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sci.bpm.command.qc.QualityControlBean;
import com.sci.bpm.dao.qc.QCDao;
import com.sci.bpm.db.model.SciQcDocs;
import com.sci.bpm.db.model.SciQcMaster;
import com.sci.bpm.db.model.SciQcMiMaster;
import com.sci.bpm.db.model.SciRawMIDetails;
import com.sci.bpm.db.model.SciRejectedMaterials;
import com.sci.bpm.db.model.SciStoreMaster;

@Service
@Transactional
public class QCServiceImpl implements QCService {

	@Autowired
	private QCDao dao;
	

	

	public boolean addQCResult(SciQcMaster master, SciStoreMaster stmaster) {
		// TODO Auto-generated method stub
		return dao.addQCResult(master, stmaster);
	}

	public List loadMiList(String seqItemId) {
		// TODO Auto-generated method stub
		return dao.loadMiList(seqItemId);
	}

	

	public List loadApprovedList() {
		// TODO Auto-generated method stub
		return dao.loadApprovedList();
	}



	public List<SciQcDocs> loadQCDocs(Long seqQCID) {
		// TODO Auto-generated method stub
		return dao.loadQCDocs(seqQCID);
	}

	public void addQCDocs(SciQcDocs doc) {
		
		dao.addQCDocs(doc);
		
	}

	public void approveQC(SciQcMiMaster master) {
	dao.approveQC(master);
		
	}

	public List loadunapprovedList(String deptid) {
		// TODO Auto-generated method stub
		List<SciQcMiMaster> qclist = dao.loadunapprovedList(deptid);
		
		return qclist;
		
	}

	public List loadQCItems(String deptid) {
		
		List<SciQcMiMaster> qclist = dao.loadQCItems(deptid);
		for(SciQcMiMaster qcbean:qclist) {
			//qcbean.setQcdocs(dao.loadQCDocs(qcbean.getSeqQcMiId()));
			qcbean.setPomasters(dao.loadsubcontPurchase(qcbean.getSeqQcMiId()));
			qcbean.setRawmis(dao.getRawMidata(qcbean.getSciMiMaster().getSeqMiId()));
			List<SciRawMIDetails> rmidetails  = qcbean.getRawmis();
			for(SciRawMIDetails rmi : rmidetails) {
				qcbean.addmydocs(dao.loadmiQCDocs(rmi.getSeqOrigMIID()));
			}
		}
		
		return qclist;
	}

	public boolean updateQCResult(SciQcMiMaster master,
			SciRejectedMaterials rejected) {
		// TODO Auto-generated method stub
		return dao.updateQCResult(master, rejected);
	}

	public List loadAllList(QualityControlBean bean) {
		// TODO Auto-generated method stub
		return dao.loadAllList(bean);
	}

	public List loadQCItems(String deptid, String approval) {
		// TODO Auto-generated method stub
		return null;
	}

	public List loadAllListDocs(QualityControlBean bean) {
		// TODO Auto-generated method stub
		return dao.loadAllListDocs(bean);
	}

	public List loadAllListIssueDocs(QualityControlBean bean) {
		// TODO Auto-generated method stub
		List<QualityControlBean> mylist = dao.loadAllListIssueDocs(bean);
		for(QualityControlBean qcbean:mylist) {
			qcbean.setQcdocs(dao.loadQCDocs(qcbean.getSeqQcMiId()));
			qcbean.setPomasters(dao.loadsubcontPurchase(qcbean.getSeqQcMiId()));
			qcbean.setRawmis(dao.getRawMidata(Long.parseLong(qcbean.getIssueMI())));
			List<SciRawMIDetails> rmidetails  = qcbean.getRawmis();
			for(SciRawMIDetails rmi : rmidetails) {
				qcbean.addmydocs(dao.loadmiQCDocs(rmi.getSeqOrigMIID()));
			}
		}
		
		return mylist;
	}

}
