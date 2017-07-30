package com.sci.bpm.service.po;

import java.util.List;

import com.sci.bpm.command.po.POCommand;
import com.sci.bpm.db.model.SciPaymentDetails;
import com.sci.bpm.db.model.SciPurchItemMaster;
import com.sci.bpm.db.model.SciPurchaseMast;
import com.sci.bpm.db.model.SciRejectMaterialAudit;
import com.sci.bpm.db.model.SciRejectedMaterials;
import com.sci.bpm.db.model.SciVendorInvoiceMaster;
import com.sci.bpm.db.model.SciVendorMaster;
import com.sci.bpm.db.model.SciVendorPurchaseCost;
/**
 * 
 * @author prakash
 *
 */
public interface PurchaseOrderService {

	
	public  void addPurchOrder(SciPurchaseMast master,List<SciPurchItemMaster> itemlist) ;
	public  void addPurchOrder(SciPurchaseMast master,List<SciPurchItemMaster> itemlist,Long mistatus) ;
	public List<SciPurchaseMast> searchPOs(POCommand command);
	
	public List<SciPurchItemMaster> loadPODetails(SciPurchaseMast master);
	public void cancelPO(SciPurchaseMast master);
	public void updatePOStatus(SciPurchaseMast master);
	public List closePO(POCommand command);
	public void updateReject(SciRejectedMaterials mater,SciRejectMaterialAudit audit);
	public List viewRejected(POCommand command);
	public void despatchPO(SciPurchaseMast master);
	public void updatePOStatus(SciPurchaseMast master,Long mistatus);
	public void addPaymentDetails(SciPaymentDetails details);
	public List<SciPaymentDetails> loadPaymentDetails();
	public SciVendorMaster loadSciVendorMaster(Long seqVendorID);
	public List<SciVendorInvoiceMaster> loadInvoiceDetails();
	public void addInvoiceDetails(SciVendorInvoiceMaster vmaster);
	public List<SciPurchaseMast> loadPODetails(Long seqVendorID);
	
	public List<SciVendorInvoiceMaster> loadbillNo(Long seqVendorID);
	
	public List<SciVendorPurchaseCost> loadQuotations(String matDept,String matCategory);
	
	public void addPurchaseVendorCost(SciVendorPurchaseCost purchaseCost);
}
