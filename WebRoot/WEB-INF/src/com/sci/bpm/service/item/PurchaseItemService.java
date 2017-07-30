package com.sci.bpm.service.item;

import java.util.List;

import com.sci.bpm.command.mi.ItemCommand;
import com.sci.bpm.db.model.SciMatindMaster;
import com.sci.bpm.db.model.SciPurchItemMaster;
import com.sci.bpm.db.model.SciRawMIDetails;

public interface PurchaseItemService {

	public  void addNewItem(SciPurchItemMaster command,List<SciMatindMaster> milist,SciRawMIDetails details);
	
	public List<SciPurchItemMaster> search(ItemCommand  entity);
	
	public boolean checkRawMI(Long rawMI);
	
	public void addRawMI(SciRawMIDetails midetails);
}
