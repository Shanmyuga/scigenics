package com.sci.bpm.controller.po;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.servlet.ServletContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.servlet.ServletContextURIResolver;
import org.apache.xmlgraphics.util.MimeConstants;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.webflow.context.servlet.ServletExternalContext;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;
import org.springframework.webflow.execution.RequestContextHolder;
import org.tempuri.po.Items;
import org.tempuri.po.ObjectFactory;
import org.tempuri.po.PurchaseOrderType;

import com.sci.bpm.command.mi.MatindCommand;
import com.sci.bpm.command.po.POCollectionCommand;
import com.sci.bpm.command.po.POCommand;
import com.sci.bpm.controller.base.SciBaseController;
import com.sci.bpm.db.model.SciPaymentDetails;
import com.sci.bpm.db.model.SciPurchItemMaster;
import com.sci.bpm.db.model.SciPurchaseItemdetails;
import com.sci.bpm.db.model.SciPurchaseMast;
import com.sci.bpm.db.model.SciRejectMaterialAudit;
import com.sci.bpm.db.model.SciRejectedMaterials;
import com.sci.bpm.db.model.SciVendorInvoiceMaster;
import com.sci.bpm.db.model.SciVendorMaster;
import com.sci.bpm.db.model.SciVendorPurchaseCost;
import com.sci.bpm.service.po.PurchaseOrderService;
import com.sci.bpm.service.product.ProductMasterService;

@Controller("pocont")
public class PurchaseOrderController extends SciBaseController {

	@Autowired
	private PurchaseOrderService service;
	@Autowired
	private ProductMasterService prservice;

	@Override
	public Event setupForm(RequestContext context) throws Exception {
		setFormObjectClass(POCommand.class);
		setFormObjectName("pocommand");
		return super.setupForm(context);
	}

	public Event addNewPO(RequestContext context) throws Exception {
		POCommand command = (POCommand) getFormObject(context);
		SciPurchaseMast purchmaster = new SciPurchaseMast();
		BeanUtils.copyProperties(purchmaster, command);
		String supportdocs = StringUtils.join(command.getSupportDocuments(),
				",");
		purchmaster.setSupportDocuments(supportdocs);
		List<SciPurchItemMaster> itemlist = (List) context.getFlowScope().get(
				"poItemlist");
		List<SciVendorMaster> master = (List<SciVendorMaster>) context
				.getFlowScope().get("vendordata");
		SciVendorMaster vendorDetail = getVendorMaster(master,
				command.getSeqVendorId());
		// purchmaster.setSeqVendorID(vendorDetail.getSeqVendorId());
		purchmaster.setSciVendorMaster(vendorDetail);
		purchmaster.setVendorOrder(vendorDetail.getVendorName());
		System.out.println(vendorDetail.getVendorAddress());
		String vendorcity = "";
		if(StringUtils.isNotBlank(vendorDetail.getVendorCity())) {
			vendorcity = vendorDetail.getVendorCity();
		}
		purchmaster.setVendorAddress(vendorDetail.getVendorAddress()+ "   " + vendorcity);
		
		float totalcost = 0;
		for (SciPurchItemMaster im : itemlist) {
			im.setItemStatus(getLookupservice().loadIDData("PITEM_INPURCHASE"));
			im.setUpdatedBy(getUserPreferences().getUserID());
			im.setUpdatedDate(new java.util.Date());
			totalcost = totalcost + im.getItemEstimatedCost().floatValue();
			SciPurchaseItemdetails itemdetails = new SciPurchaseItemdetails();
			itemdetails.setSeqItemId(im.getSeaPuritemId());

			itemdetails.setSciPurchaseMast(purchmaster);
			purchmaster.addItemDetail(itemdetails);
		}
		purchmaster.setTotalCost(new Float(totalcost));

		double itemtotalcost = purchmaster.getTotalCost().doubleValue();
		purchmaster.setItemTotalCost(new Double(itemtotalcost));
		itemtotalcost = itemtotalcost
				+ purchmaster.getPackingFrwdCharges().doubleValue();

		purchmaster.setExciseCharges((purchmaster.getExcisePercent()
				.doubleValue() * itemtotalcost) / 100);
		itemtotalcost = itemtotalcost
				+ purchmaster.getExciseCharges().doubleValue();

		purchmaster
				.setVatCharges((purchmaster.getVatPercentage().doubleValue() * itemtotalcost) / 100);
		
		
		itemtotalcost = itemtotalcost + purchmaster.getVatCharges();
		
		purchmaster
		.setGstCharges((purchmaster.getGst().doubleValue() * itemtotalcost) / 100);
		itemtotalcost = itemtotalcost + purchmaster.getGstCharges();
		purchmaster.setPoTotalcost(itemtotalcost);
		purchmaster.setPurchaseStatus(getLookupservice().loadIDData(
				"PO_CREATED"));
		purchmaster.setUpdatedBy(getUserPreferences().getUserID());
		purchmaster.setUpdatedDate(new java.util.Date());
		purchmaster.setInsertedBy(getUserPreferences().getUserID());
		purchmaster.setInsertedDate(new java.util.Date());
		purchmaster.setPurchaseCreatedDt(new java.util.Date());
		service.addPurchOrder(purchmaster, itemlist, getLookupservice()
				.loadIDData("MI_PURCHASE_CREATED"));
		return success();
	}

	public Event searchPO(RequestContext context) throws Exception {

		POCommand command = (POCommand) getFormObject(context);
		List<SciPurchaseMast> masterlist = service.searchPOs(command);
		context.getFlowScope().put("pomastlist", masterlist);
		return success();
	}

	public Event checkStatus(RequestContext context) throws Exception {

		POCommand command = (POCommand) getFormObject(context);
		List<SciPurchaseMast> master = (List<SciPurchaseMast>) context
				.getFlowScope().get("pomastlist");
		SciPurchaseMast selected = selectedPO(master, command.getScipurchID());
		if (selected.getPurchaseStatus().intValue() == getLookupservice()
				.loadIDData("PO_CREATED").intValue()) {
			context.getFlowScope().put("OPENSTATUS", "Y");
		}
		loadPOStoresStatus(context);

		return success();
	}

	public Event selectPO(RequestContext context) throws Exception {

		POCommand command = (POCommand) getFormObject(context);
		List<SciPurchaseMast> master = (List<SciPurchaseMast>) context
				.getFlowScope().get("pomastlist");
		SciPurchaseMast selected = selectedPO(master, command.getScipurchID());
		List<SciPurchItemMaster> podetails = service.loadPODetails(selected);
		context.getFlowScope().put("podetails", podetails);
		context.getFlowScope().put("selectedPO", selected);
		return success();
	}

	private SciPurchaseMast selectedPO(List<SciPurchaseMast> polist,
			Long seqPuchId) {
		SciPurchaseMast selected = null;
		for (SciPurchaseMast m : polist) {
			if (m.getSeqPurchId().intValue() == seqPuchId.intValue()) {
				selected = m;
				break;
			}
		}
		return selected;
	}
	
	private SciRejectedMaterials selectedreject(
			List<SciRejectedMaterials> rejlist, Long seqRejectid) {
		SciRejectedMaterials selected = null;
		for (SciRejectedMaterials m : rejlist) {
			if (m.getSeqRejdId().intValue() == seqRejectid.intValue()) {
				selected = m;
				break;
			}
		}
		return selected;
	}

	public Event updateRejectStatus(RequestContext context) throws Exception {
		POCommand command = (POCommand) getFormObject(context);
		List<SciRejectedMaterials> master = (List<SciRejectedMaterials>) context
				.getFlowScope().get("rejectedList");
		SciRejectedMaterials selected = selectedreject(master,
				command.getSeqRejectid());
		selected.setUpdatedBy(getUserPreferences().getUserID());
		selected.setUpdatedDate(new java.util.Date());
		selected.setRejectStatus(command.getRejectStatus());
		selected.setRemarks(command.getRejectremarks());
		SciRejectMaterialAudit audit = new SciRejectMaterialAudit();
		audit.setSeqRejectId(selected.getSeqRejdId());
		audit.setInsertedBy(getUserPreferences().getUserID());
		audit.setInsertedDate(new Date());
		audit.setRejectDate(new Date());
		audit.setRejectStatus(command.getRejectStatus());
		selected.setUpdatedBy(getUserPreferences().getUserID());
		selected.setUpdatedDate(new Date());
		service.updateReject(selected, audit);
		viewRejected(context);
		command.setRejectremarks(null);
		return success();
	}

	public Event updatePOStatus(RequestContext context) throws Exception {

		POCommand command = (POCommand) getFormObject(context);
		List<SciPurchaseMast> master = (List<SciPurchaseMast>) context
				.getFlowScope().get("pomastlist");
		SciPurchaseMast selected = selectedPO(master, command.getScipurchID());
		selected.setPurchaseStatus(getLookupservice().loadIDData("PO_SENT"));
		selected.setUpdatedBy(getUserPreferences().getUserID());
		selected.setUpdatedDate(new Date());
		service.updatePOStatus(selected,
				getLookupservice().loadIDData("MI_PO_ORDERED"));
		context.getFlowScope().remove("pomastlist");
		context.getFlowScope().remove("postorelist");
		resetForm(context);
		return success();
	}
	
	public Event updatePOItemDesc(RequestContext context) throws Exception {

		POCommand command = (POCommand) getFormObject(context);
		List<SciPurchItemMaster> master = (List<SciPurchItemMaster>) context
				.getFlowScope().get("podetails");
		List<POCollectionCommand> pilist = command.getPoitemList();
		System.out.println(pilist);
		
		return success();
	}

	public Event closePo(RequestContext context) throws Exception {

		POCommand command = (POCommand) getFormObject(context);
		List<SciPurchaseMast> master = (List<SciPurchaseMast>) context
				.getFlowScope().get("pomastlist");
		SciPurchaseMast selected = selectedPO(master, command.getScipurchID());
		selected.setPurchaseStatus(getLookupservice().loadIDData("PO_CLOSED"));
		selected.setUpdatedBy(getUserPreferences().getUserID());
		selected.setUpdatedDate(new Date());
		service.updatePOStatus(selected);
		context.getFlowScope().remove("pomastlist");
		resetForm(context);
		return success();
	}

	public Event viewPOPDF(RequestContext context) throws Exception {

		POCommand command = (POCommand) getFormObject(context);
		List<SciPurchaseMast> master = (List<SciPurchaseMast>) context
				.getFlowScope().get("pomastlist");
		SciPurchaseMast selected = selectedPO(master, command.getScipurchID());
		List<SciPurchItemMaster> itemlist = service.loadPODetails(selected);

		SimpleDateFormat dateformat = new SimpleDateFormat("dd.MM.yyyy");
		HashMap<String, String> headerkeymap = new HashMap();
		HashMap<String, String> commankeymap = new HashMap();
		JAXBContext jcontext = JAXBContext.newInstance("org.tempuri.po");
		ObjectFactory factory = new ObjectFactory();
		PurchaseOrderType ptype = factory.createPurchaseOrderType();
		ptype.setPonumber(selected.getSeqPurchId().toString());
		ptype.setPoDate(selected.getPurchaseCreatedDt().toString());
		ptype.setExciseAmount(selected.getExciseCharges().toString());
		ptype.setExcisePecentage(selected.getExcisePercent().toString());
		ptype.setInsurance(selected.getInsurance());
		ptype.setPaymentTerms(selected.getPaymentTerms());
		ptype.setModeOfDispatch(selected.getModeOfDispatch());
		ptype.setPackingForwarding(selected.getPackingFrwdCharges().toString());
		ptype.setVatAmount(selected.getVatCharges().toString());
		if(selected.getGst() != null && selected.getGstCharges() != null) {
		ptype.setGst(selected.getGst().toString());
		ptype.setGstAmount(selected.getGstCharges().toString());
		}
		ptype.setVatPercentage(selected.getVatPercentage().toString());
		ptype.setSupportDocuments(selected.getSupportDocuments());
		ptype.setSpecialConditions(selected.getSpecialCondition());
		ptype.setTotalCost(selected.getTotalCost().toString());
		ptype.setItemtotal(selected.getItemTotalCost().toString());
		ptype.setRefDate(selected.getRefDate()!=null?selected.getRefDate().toString():"");
		ptype.setQutrefno(selected.getQutRefNo());
		System.out.println(selected.getVendorAddress());
		System.out.println(selected.getVendorOrder());
		
		ptype.setVendorDetails(selected.getVendorOrder()+" | "+ selected.getVendorAddress());
		ptype.setDeliveryDate(selected.getDeliverySchedule() + " - " +  dateformat.format(selected.getPurchaseDueDate()));

		headerkeymap.put("PO.DATE",
				dateformat.format(selected.getPurchaseCreatedDt()));
		float itemtotal = 0;
		headerkeymap.put("CUST.INFO", selected.getVendorOrder()
				+ selected.getSciVendorMaster().getVendorAddress()!=null?selected.getSciVendorMaster().getVendorAddress():"");
		List poitemlist = new ArrayList();
		int idx = 1;
		HashMap<String, String> itemkeymap = new HashMap();
		for (int count = 1; count <= itemlist.size(); count++) {
			SciPurchItemMaster itemmaster = itemlist.get(count - 1);

			Items items = new Items();
			
			items.setDescription("("+itemmaster.getItemCode()+") "+itemmaster.getItemDescription());
			items.setQuantity(Float.parseFloat(itemmaster.getItemQty()));
			items.setSno(String.valueOf(count));
			items.setDenom(itemmaster.getItemDenom());
			itemkeymap.put("ITEM.INFO" + String.valueOf(idx),
					itemmaster.getItemDescription());

			String[] estimatedCost = StringUtils.splitByWholeSeparator(
					String.valueOf(itemmaster.getItemEstimatedCost()), ".");
			System.out.println(estimatedCost.length);
			System.out.println(itemmaster.getItemEstimatedCost());
			if (estimatedCost.length > 1) {
				items.setTotalcost(estimatedCost[0]);
				if (estimatedCost[1].length() == 1) {
					estimatedCost[1] = estimatedCost[1] + "0";
				}
				items.setTotalcostpaise(estimatedCost[1]);
			} else if (estimatedCost.length == 1) {
				items.setTotalcost(estimatedCost[0]);
				items.setTotalcostpaise("00");
			}
			System.out.println(itemmaster.getItemEstimatedCost());
			System.out.println(itemmaster.getItemQty());
			Float itemunitCost = itemmaster.getItemEstimatedCost()
					/ Float.parseFloat(itemmaster.getItemQty());
			String[] unitcost = StringUtils.splitByWholeSeparator(
					String.valueOf(itemunitCost), ".");
			if (unitcost.length > 1) {
				items.setUnitprice(unitcost[0]);
				if (unitcost[1].length() == 1) {
					unitcost[1] = unitcost[1] + "0";
				}
				items.setUnitpricepaise(unitcost[1]);
			} else if (unitcost.length == 1) {
				items.setUnitprice(unitcost[0]);
				items.setUnitpricepaise("00");
			}

			if (idx == 3) {
				itemkeymap.put("S.N0" + String.valueOf(idx),
						String.valueOf(count));
			} else {
				itemkeymap.put("S.NO" + String.valueOf(idx),
						String.valueOf(count));
			}

			itemkeymap.put("QTY." + String.valueOf(idx),
					itemmaster.getItemQty());
			idx = idx + 1;
			if (count % 3 == 0) {
				poitemlist.add(itemkeymap);

				itemkeymap = new HashMap();
				idx = 1;

			}
			ptype.getItems().add(items);

		}
		if (idx > 1) {
			poitemlist.add(itemkeymap);
		}

		if (selected.getItemTotalCost() != null) {
			String[] itemTotalCost = StringUtils.splitByWholeSeparator(
					String.valueOf(selected.getItemTotalCost()), ".");
			if (itemTotalCost.length > 1) {
				ptype.setItemtotal(itemTotalCost[0]);
				if (itemTotalCost[1].length() == 1) {
					itemTotalCost[1] = itemTotalCost[1] + "0";
				}
				ptype.setItemtotalpaise(itemTotalCost[1]);
			} else if (itemTotalCost.length == 1) {
				ptype.setItemtotal(itemTotalCost[0]);
				ptype.setItemtotalpaise("00");
			}
		}
		if (selected.getPoTotalcost() != null) {
			String[] poTotalCost = StringUtils.splitByWholeSeparator(
					String.valueOf(selected.getPoTotalcost()), ".");
			if (poTotalCost.length > 1) {
				ptype.setTotalCost(poTotalCost[0]);
				if (poTotalCost[1].length() == 1) {
					poTotalCost[1] = poTotalCost[1] + "0";
				}
				ptype.setTotalCostpaise(poTotalCost[1]);
			} else if (poTotalCost.length == 1) {
				ptype.setTotalCost(poTotalCost[0]);
				ptype.setTotalCostpaise("00");
			}
		}
		if (selected.getVatCharges() != null) {
			String[] vatTotalCost = StringUtils.splitByWholeSeparator(
					String.valueOf(selected.getVatCharges()), ".");
			if (vatTotalCost.length > 1) {
				ptype.setVatAmount(vatTotalCost[0]);
				if (vatTotalCost[1].length() == 1) {
					vatTotalCost[1] = vatTotalCost[1] + "0";
				}
				ptype.setVatAmountpaise(vatTotalCost[1]);
			} else if (vatTotalCost.length == 1) {
				ptype.setVatAmount(vatTotalCost[0]);
				ptype.setVatAmountpaise("00");
			}
		}
		
		if (selected.getGstCharges() != null) {
			String[] gstTotalCost = StringUtils.splitByWholeSeparator(
					String.valueOf(selected.getGstCharges()), ".");
			if (gstTotalCost.length > 1) {
				ptype.setGstAmount(gstTotalCost[0]);
				if (gstTotalCost[1].length() == 1) {
					gstTotalCost[1] = gstTotalCost[1] + "0";
				}
				ptype.setGstAmountpaise(gstTotalCost[1]);
			} else if (gstTotalCost.length == 1) {
				ptype.setGstAmount(gstTotalCost[0]);
				ptype.setGstAmountpaise("00");
			}
		}
		if (selected.getExciseCharges() != null) {
			String[] exciseCost = StringUtils.splitByWholeSeparator(
					String.valueOf(selected.getExciseCharges()), ".");
			if (exciseCost.length > 1) {
				ptype.setExciseAmount(exciseCost[0]);
				if (exciseCost[1].length() == 1) {
					exciseCost[1] = exciseCost[1] + "0";
				}
				ptype.setExciseAmountpaise(exciseCost[1]);
			} else if (exciseCost.length == 1) {
				ptype.setExciseAmount(exciseCost[0]);
				ptype.setExciseAmountpaise("00");
			}
		}

		if (selected.getPackingFrwdCharges() != null) {
			String[] packcost = StringUtils.splitByWholeSeparator(
					String.valueOf(selected.getPackingFrwdCharges()), ".");
			if (packcost.length > 1) {
				ptype.setPackingForwarding(packcost[0]);
				if (packcost[1].length() == 1) {
					packcost[1] = packcost[1] + "0";
				}
				ptype.setPackingForwardingpaise(packcost[1]);
			} else if (packcost.length == 1) {

				ptype.setPackingForwarding(packcost[0]);
				ptype.setPackingForwardingpaise("00");
			}
		}
		System.out.println(poitemlist.size());
		ByteArrayOutputStream outstream = new ByteArrayOutputStream();
		Marshaller marshaller = jcontext.createMarshaller();
		
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.valueOf(true));
		
		marshaller.marshal(factory.createPurchaseOrder(ptype), outstream);
		String poxml = new String(outstream.toByteArray());
		int idlx = poxml.indexOf("<vendorDetails>");
		poxml = poxml.substring(idlx, poxml.length());
		
		context.getExternalContext().getSessionMap()
				.put("poxml", "<purchaseOrder>"+poxml);
		context.getFlowScope().put("poxml_flow",poxml);
		return success();
	}

	public Event selectVendorEmailId(RequestContext context) throws Exception {
		POCommand command = (POCommand) getFormObject(context);
		List<SciPurchaseMast> master = (List<SciPurchaseMast>) context
				.getFlowScope().get("pomastlist");
		SciPurchaseMast selected = selectedPO(master, command.getScipurchID());
		String emailId = selected.getSciVendorMaster().getEmailId();
		if(emailId == null) {
			throw new Exception("Vendor EMAIL ID is null");
		}
		context.getExternalContext().getSessionMap()
				.put("vendorEmailID", emailId);
		context.getFlowScope().put("vendorEmailID_flow",emailId);
		return success();
	}


	public void sendEmail( RequestContext context) throws Exception{

		ServletContext externalContext =
				(ServletContext)context.getExternalContext().getNativeContext();

		 FopFactory fopFactory = FopFactory.newInstance();
		 TransformerFactory tFactory = TransformerFactory.newInstance();
		 URIResolver uriResolver = null;

		uriResolver = new ServletContextURIResolver(externalContext);
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		//Setup FOP
		Fop fop = null;
		try {
			fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);
			fopFactory.setURIResolver(uriResolver);
			String poxml = (String) context.getFlowScope().get("poxml_flow");
			String vendorEmailId = (String) context.getFlowScope().get("vendorEmailID_flow");
			if (poxml == null) {

			}

			//Setup TransformerRequestContext rc = RequestContextHolder.getRequestContext();
			Source xsltSrc = new StreamSource(new File(externalContext.getRealPath("/") + "/xslt/po_template.xsl"));
			Transformer transformer = tFactory.newTransformer(xsltSrc);
//transformer.setURIResolver(uriResolver);
			//Make sure the XSL transformation's result is piped through to FOP
			Result res = new SAXResult(fop.getDefaultHandler());

			//Setup input
			Source src = new StreamSource(new StringReader(poxml));

			//Start the transformation and rendering process
			transformer.transform(src, res);
			byte[] pdfarray = out.toByteArray();

			//Send content to Browser
			sendEmail("purchase@scigenics.in",vendorEmailId,"Purchase Order From Scigenics","Dear Sir \n Please find the attached purchase order from Scigenics India Pvt Ltd. \n\n\n Thanks and Regards \n Scigenics Purchase Manager \n email : purchase@scigenics.in ",pdfarray);
		}
		catch(Exception e) {

		}
		}

	public Event cancelPO(RequestContext context) throws Exception {

		POCommand command = (POCommand) getFormObject(context);
		List<SciPurchaseMast> master = (List<SciPurchaseMast>) context
				.getFlowScope().get("pomastlist");
		SciPurchaseMast selected = selectedPO(master, command.getScipurchID());
		selected.setPurchaseStatus(getLookupservice()
				.loadIDData("PO_CANCELLED"));
		selected.setUpdatedBy(getUserPreferences().getUserID());
		selected.setUpdatedDate(new Date());
		service.cancelPO(selected);
		context.getFlowScope().remove("pomastlist");
		resetForm(context);
		return success();
	}

	

	public Event despatchPO(RequestContext context) throws Exception {

		POCommand command = (POCommand) getFormObject(context);
		List<SciPurchaseMast> master = (List<SciPurchaseMast>) context
				.getFlowScope().get("pomastlist");
		SciPurchaseMast selected = selectedPO(master, command.getScipurchID());
		selected.setPurchaseStatus(getLookupservice()
				.loadIDData("PO_DESPATCHED"));
		selected.setUpdatedBy(getUserPreferences().getUserID());
		selected.setUpdatedDate(new Date());
		selected.setPurchaseCreatedDt(new Date());
		service.despatchPO(selected);
		context.getFlowScope().remove("pomastlist");
		resetForm(context);
		return success();
	}

	public Event cancelPOStatus(RequestContext context) throws Exception {

		POCommand command = (POCommand) getFormObject(context);
		List<SciPurchaseMast> master = (List<SciPurchaseMast>) context
				.getFlowScope().get("pomastlist");
		SciPurchaseMast selected = selectedPO(master, command.getScipurchID());
		selected.setPurchaseStatus(getLookupservice().loadIDData("PO_SENT"));
		selected.setUpdatedBy(getUserPreferences().getUserID());
		selected.setUpdatedDate(new Date());
		service.updatePOStatus(selected);
		context.getFlowScope().remove("pomastlist");
		resetForm(context);
		return success();
	}

	private SciVendorMaster getVendorMaster(List<SciVendorMaster> master,
			Long seqVendorID) {

		SciVendorMaster vendordetail = null;
		for (SciVendorMaster vm : master) {
			if (vm.getSeqVendorId().intValue() == seqVendorID.intValue()) {
				vendordetail = vm;
				break;
			}

		}
		return vendordetail;
	}

	public Event loadPOStoresStatus(RequestContext context) throws Exception {
		POCommand command = (POCommand) getFormObject(context);
		List<SciPurchaseMast> master = (List<SciPurchaseMast>) context
				.getFlowScope().get("pomastlist");
		SciPurchaseMast selected = selectedPO(master, command.getScipurchID());
		command.setScipurchID(selected.getSeqPurchId());
		List postorelist = service.closePO(command);
		context.getFlowScope().put("postorelist", postorelist);
		return success();
	}

	public Event viewRejected(RequestContext context) throws Exception {
		POCommand command = (POCommand) getFormObject(context);

		List rejectedList = service.viewRejected(command);
		context.getFlowScope().put("rejectedList", rejectedList);
		return success();
	}
	
	public Event addInvoiceDetails(RequestContext context) throws Exception {
		POCommand command = (POCommand) getFormObject(context);

		SciVendorInvoiceMaster vInvoice = new SciVendorInvoiceMaster();
		BeanUtils.copyProperties(vInvoice, command);
		vInvoice.setInsertedBy(getUserPreferences().getUserID());
		SciVendorMaster master = service.loadSciVendorMaster(command.getSeqVendorId());
		vInvoice.setSciVendorMaster(master);
		if(vInvoice.getPoId() == null) {
			vInvoice.setPoId(0L);
		}
		vInvoice.setFinalAmount(vInvoice.getBillAmount());
		vInvoice.setUpdatedBy(getUserPreferences().getUserID());
		vInvoice.setUpdatedDate(new Date());
		vInvoice.setInsertedDate(new Date());
		service.addInvoiceDetails(vInvoice);
		loadInvoiceDetails(context);
		return success();
	}
	
	
	public Event addVendorPurchCost(RequestContext context) throws Exception {
		POCommand command = (POCommand) getFormObject(context);
		
		SciVendorPurchaseCost puchaseCost = new SciVendorPurchaseCost();
		BeanUtils.copyProperties(puchaseCost, command);
		
		SciVendorMaster master = service.loadSciVendorMaster(command.getSeqVendorId());
		puchaseCost.setSciVendorMaster(master);
		puchaseCost.setUpdatedBy(getUserPreferences().getUserID());
		puchaseCost.setUpdatedDate(new Date());
		service.addPurchaseVendorCost(puchaseCost);
		loadQuotationsDetails(context);
		return success();
	}
	
	
	public Event loadInvoiceDetails(RequestContext context) throws Exception {
		

		List<SciVendorInvoiceMaster> details  = service.loadInvoiceDetails();
		context.getFlowScope().put("invoiceItemlist", details);
		return success();
	}
	
	
public Event loadQuotationsDetails(RequestContext context) throws Exception {
	POCommand command = (POCommand) getFormObject(context);

		List<SciVendorPurchaseCost> details  = service.loadQuotations(command.getMatDept(), command.getMatCategory());
		context.getFlowScope().put("quotationsList", details);
		return success();
	}
	
	public Event loadPODetailsForVendor(RequestContext context) throws Exception {
		
		POCommand command = (POCommand) getFormObject(context);
		List<SciPurchaseMast> details  = service.loadPODetails(command.getSeqVendorId());
		context.getFlowScope().put("poDetailsList", details);
		return success();
	}
	public Event addPayMentDetails(RequestContext context) throws Exception {
		POCommand command = (POCommand) getFormObject(context);

		SciPaymentDetails payment = new SciPaymentDetails();
		BeanUtils.copyProperties(payment, command);
		payment.setInsertedBy(getUserPreferences().getUserID());
		SciVendorMaster master = service.loadSciVendorMaster(command.getSeqVendorId());
		payment.setSciVendorMaster(master);
		payment.setInsertedDate(new Date());
		service.addPaymentDetails(payment);
		loadPayMentDetails(context);
		return success();
	}
	
	public Event loadPayMentDetails(RequestContext context) throws Exception {
		
		List<SciPaymentDetails> details  = service.loadPaymentDetails();
		context.getFlowScope().put("paymentItemlist", details);
		return success();
	}
	
public Event loadbillDetails(RequestContext context) throws Exception {
	POCommand command = (POCommand) getFormObject(context);


		List<SciVendorInvoiceMaster> list = service.loadbillNo(command.getSeqVendorId());
		context.getFlowScope().put("billdetails", list);
		return success();
	}
	public Event loadMatCatItems(RequestContext context) throws Exception {
		POCommand command = (POCommand) getFormObject(context);
		List matcatlist = prservice.selectCategory(command.getMatDept());
		context.getFlowScope().put("matcatitems", matcatlist);
		return success();
	}



	public void sendEmail(String aFromEmailAddr, String aToEmailAddr,
						  String aSubject, String aBody,byte[] array) throws NoSuchProviderException {
		// Here, no Authenticator argument is used (it is null).
		// Authenticators are used to prompt the user for user
		// name and password.



		final Properties properties = new Properties();
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(
				"com/sci/bpm/service/task/maildetails.properties");
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Properties config = createConfiguration();

		Session session = Session.getDefaultInstance(config,
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication((String) properties
								.get("mail.login.username"),
								(String) properties.get("mail.login.password"));
					}
				});
		session.setDebug(false);

		MimeMessage message = new MimeMessage(session);
		try {
			// the "from" address may be set in code, or set in the
			// config file under "mail.from" ; here, the latter style is used
			message.setFrom(new InternetAddress(aFromEmailAddr));

			/*InternetAddress[] address = new InternetAddress[1];
			address[0] = new InternetAddress("sundaraswamy@gmail.com");*/
			String[] addressarray = StringUtils.split(aToEmailAddr, ",");
			InternetAddress[] address = new InternetAddress[addressarray.length];
			for(int i=0;i<addressarray.length;i++) {
				address[i] = new InternetAddress(addressarray[i]);
			}
			message.addRecipients(javax.mail.internet.MimeMessage.RecipientType.TO, address);

			message.setSubject(aSubject);

			MimeBodyPart mbp1 = new MimeBodyPart();
			mbp1.setText(aBody);

			MimeBodyPart mbp2 = new MimeBodyPart();
			SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
			mbp2.setFileName("PurchaseOrder -" +  dateformat.format(new Date())+".pdf");
			ByteArrayDataSource bds = new ByteArrayDataSource(array, "application/pdf");
			mbp2.setDataHandler(new DataHandler(bds));
			Multipart mp = new MimeMultipart();

			mp.addBodyPart(mbp1);
			mp.addBodyPart(mbp2);
			message.setContent(mp);
			message.saveChanges();
			Transport.send(message);
		} catch (MessagingException ex) {
			ex.printStackTrace();
			System.err.println("Cannot send email. " + ex);
		}
	}

	private Properties createConfiguration() {
		return new Properties() {{
			put("mail.smtp.auth", "true");
			put("mail.smtp.starttls.enable", "true");
			put("mail.smtp.host", "smtp.gmail.com");
			put("mail.smtp.port", "587");

		}};
	}
}
