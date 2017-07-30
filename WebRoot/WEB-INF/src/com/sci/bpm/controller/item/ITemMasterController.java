package com.sci.bpm.controller.item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.sci.bpm.command.mi.ItemCommand;
import com.sci.bpm.command.mi.MatindCommand;
import com.sci.bpm.controller.base.SciBaseController;
import com.sci.bpm.db.model.SciItemmiDetails;
import com.sci.bpm.db.model.SciMatindMaster;
import com.sci.bpm.db.model.SciPurchItemMaster;
import com.sci.bpm.db.model.SciRawMIDetails;
import com.sci.bpm.service.item.PurchaseItemService;
import com.sci.bpm.service.mi.MaterialIndentService;

@Controller("itemcont")
public class ITemMasterController extends SciBaseController {

	@Autowired
	private PurchaseItemService service;
	
	public Event addPurchItem(RequestContext context) {
		
		return null;
	}
	@Autowired
	private MaterialIndentService miservice;
	@Override
	public Event setupForm(RequestContext context) throws Exception {
		setFormObjectClass(ItemCommand.class);
		setFormObjectName("itemcommand");
		
		return super.setupForm(context);
	}
	public Event addNewItem(RequestContext context) throws Exception {
		
		ItemCommand command = (ItemCommand) getFormObject(context);
		String estcost[] =  command.getMicost();
		String miremarks[] = command.getMiremarks();
		SciPurchItemMaster  itemmaster = new SciPurchItemMaster();
		BeanUtils.copyProperties(itemmaster,command);
		List<SciMatindMaster> milist = (List)context.getFlowScope().get("itemmilist");
		String itemCode = null;
		 int idx = 0;
		 double totalQuantity = 0.000;
		 double totalCost = 0.000;
		 List<SciMatindMaster> datalist = new ArrayList<SciMatindMaster>();
		 boolean checkrawmi = checkRawMI(command.getRawmiid());
		 if(!checkrawmi) {
			 throw new Exception("Raw mi are not valid issued MI");
		 }
		 itemmaster.setRawmis(command.getRawmiid());
		for(SciMatindMaster m : milist){
			SciItemmiDetails midetails = new SciItemmiDetails();
			m = miservice.loadMI(m.getSeqMiId());
			midetails.setSeqMiId(m.getSeqMiId());
			midetails.setSciPurchItemMaster(itemmaster);
			m.setUnitCost(new BigDecimal(estcost[idx]));
			System.out.println(m.getUnitCost().floatValue());
			if(m.getUnitCost().floatValue() <= 0) {
				throw new Exception("Estimated Cost Cannot be null");
			}
			m.setPurStatus(getLookupservice().loadIDData("MI_ITEMISED"));
			m.setUpdatedBy(getUserPreferences().getUserID());
			m.setUpdatedDate(new java.util.Date());
			m.setPoDetails(miremarks[idx]);
			m.setUnitCostDate(new java.util.Date());
			totalQuantity = totalQuantity + m.getMatQty().doubleValue();
			totalCost = totalCost + (m.getMatQty().doubleValue() * m.getUnitCost().doubleValue());
			itemCode = m.getMatcode();
			datalist.add(m);
			itemmaster.addMidetails(midetails);
			idx++;
		}
		itemmaster.setItemQty(String.valueOf(totalQuantity));
		itemmaster.setItemEstimatedCost(new Float(totalCost));
		itemmaster.setItemOrderDate(new java.util.Date());
		itemmaster.setUpdatedBy(getUserPreferences().getUserID());
		itemmaster.setUpdatedDate(new java.util.Date());
		itemmaster.setItemStatus(getLookupservice().loadIDData("PITEM_OPEN"));
		itemmaster.setItemCode(itemCode) ;
		if(command.getItemDenom().equals("")) {
			throw new Exception("ITem denom cannot be blank");
		}
		itemmaster.setItemDenom(command.getItemDenom());
				service.addNewItem(itemmaster, datalist,new SciRawMIDetails());
				String rawmis  = itemmaster.getRawmis();
				
				String[] rawmisarr = StringUtils.split(rawmis,",");
				for(SciMatindMaster m: datalist) {
					
					if(rawmisarr != null) {
						for(String rawmi:rawmisarr) {
							SciRawMIDetails rmidetails = new SciRawMIDetails();
							rmidetails.setSeqOrigMIID(Long.parseLong(rawmi));
							rmidetails.setSeqSubContMIID(m.getSeqMiId());
							service.addRawMI(rmidetails);
							 
						}
						}
				}
				
		return success();
	}
	
	public Event selectPOItem(RequestContext context) throws Exception {
		ItemCommand command = (ItemCommand) getFormObject(context);
		List poitemlist = null;
		if(context.getFlowScope().get("poItemlist") == null) {
			 poitemlist = new ArrayList();
		}
		else {
			poitemlist = (List)context.getFlowScope().get("poItemlist");
		}
		
		
		String[] itemlist = command.getItemlist();
		List fullitemlist = (List) context.getFlowScope().get("itemlist");
		for(int idx=0;idx < itemlist.length;idx++) {
			poitemlist.add(fullitemlist.get(Integer.parseInt(itemlist[idx])-1));
		}
		context.getFlowScope().put("poItemlist", poitemlist);
		return success();
	}
	
	
	public Event searchItems(RequestContext context) throws Exception {
		ItemCommand command = (ItemCommand) getFormObject(context);
		List<SciPurchItemMaster> itemlist = service.search(command);
		context.getFlowScope().put("itemlist", itemlist);
		context.getFlowScope().put("openITEM", getLookupservice().loadIDData("PITEM_OPEN"));
		return success();
	}
	
	public Event loadItemDesc(RequestContext context) throws Exception {
		ItemCommand command = (ItemCommand) getFormObject(context);
		String matspec = (String) context.getFlowScope().get("itemdesc");
		command.setItemDescription(matspec);
		return success();
	}
	public Event selecttempItem(RequestContext context) throws Exception {
		ItemCommand command = (ItemCommand) getFormObject(context);
		String[] itemlist = command.getItemlist();
		List poitemlist = null;
		if(context.getFlowScope().get("poItemlist") == null) {
			 poitemlist = new ArrayList();
		}
		else {
			poitemlist = (List)context.getFlowScope().get("poItemlist");
		}
		
		List fullitemlist = (List) context.getFlowScope().get("itemlist");
		
		for(int idx=0;idx<itemlist.length;idx++) {
			poitemlist.add(fullitemlist.get(Integer.parseInt(itemlist[idx])-1));
		}
		context.getFlowScope().put("poItemlist", poitemlist);
		return success();
	}
	
	
	public boolean checkRawMI(String rawMiid) {
		boolean check = true;
		String[] rawmis = StringUtils.split(rawMiid,",");
		for(String rawmi:rawmis) {
			
			 check = service.checkRawMI(Long.parseLong(rawmi));
			if(!check) {
				break;
			}
		}
		return check;
	}

	
	

}
