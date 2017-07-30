package com.sci.bpm.service.item;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sci.bpm.command.mi.ItemCommand;
import com.sci.bpm.dao.item.ISciPurchItemMasterDAO;
import com.sci.bpm.dao.mi.ISciMatindMasterDAO;
import com.sci.bpm.dao.mi.SciMatindMasterDAO;
import com.sci.bpm.db.model.SciMatindMaster;
import com.sci.bpm.db.model.SciPurchItemMaster;
import com.sci.bpm.db.model.SciRawMIDetails;

@Service
@Transactional
public class PurchaseItemServiceImpl implements PurchaseItemService {

	@Autowired
	private ISciPurchItemMasterDAO dao;
	
	@Autowired
	private ISciMatindMasterDAO matdao;
	
	
	public void addNewItem(SciPurchItemMaster command,List<SciMatindMaster> milist,List<SciMatindMaster> splitmilist,SciRawMIDetails rmidetails) {
		String rawmis  = command.getRawmis();
		
		String[] rawmisarr = StringUtils.split(rawmis,",");
		
		dao.save(command);
		for(SciMatindMaster m: milist) {
			
			matdao.update(m);
		}
		
for(SciMatindMaster m: splitmilist) {
			
			matdao.save(m);
		}
	}

	
	public List<SciPurchItemMaster> search(ItemCommand entity) {
		
		return dao.findByItemStatus(entity.getItemStatus());
	}
	
	public boolean checkRawMI(Long rawMI) {
		// TODO Auto-generated method stub
		return dao.checkRawMI(rawMI);
	}

	
	public void addRawMI(SciRawMIDetails midetails) {
		// TODO Auto-generated method stub
		dao.addRawMI(midetails);
	}

	
}
