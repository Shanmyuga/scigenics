package com.sci.bpm.controller.mi;

import java.math.BigDecimal;
import java.util.*;

import com.sci.bpm.db.model.*;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import com.sci.bpm.command.marketing.WorkOrderCommand;
import com.sci.bpm.command.mi.MatCollectionCommand;
import com.sci.bpm.command.mi.MatindCommand;
import com.sci.bpm.command.user.UserPreference;
import com.sci.bpm.constants.SciDataConstans;
import com.sci.bpm.controller.base.DatePropertyEditorRegistrar;
import com.sci.bpm.controller.base.SciBaseController;
import com.sci.bpm.service.mi.MaterialIndentService;
import com.sci.bpm.service.product.ProductMasterService;
import com.sci.bpm.service.role.RoleService;
import com.sci.bpm.service.task.TaskService;

@Controller("micont")
public class MaterialIndentController extends SciBaseController {

	@Autowired
	private MaterialIndentService service;
	@Autowired
	private RoleService roleservice;

	
	@Autowired
	private TaskService taskservice;
	@Autowired
	private ProductMasterService prservice;

	/**
	 * @param context
	 * @return
	 */
	public Event addnewMI(RequestContext context) {

		try {
			System.out.println("inside add");
			MatindCommand command = (MatindCommand) getFormObject(context);
			WorkOrderCommand wrkcommand = (WorkOrderCommand) context
					.getFlowScope().get("workorderbean");
			List wlist = (List) context.getFlowScope().get("workorderlist");
			List<MatCollectionCommand> matslist = command.getMatList();

			SciWorkorderMaster wmaster = (SciWorkorderMaster) wlist.get(Integer
					.parseInt(wrkcommand.getWindex()) - 1);

			for (MatCollectionCommand mi : matslist) {
				SciMatindMaster master = new SciMatindMaster();
				if (mi.getProductSpecid() == null) {
					continue;
				}

				String prodSpecid = mi.getProductSpecid().substring(0, 5);
				master.setSciWorkorderMaster(wmaster);
				BeanUtils.copyProperties(master, mi);
				System.out.println(command.getDrawingRef());
				/*if(!"".equals(mi.getDrawingRef())) {
					String[] arra = StringUtils.split(mi.getDrawingRef(),",");
					master.setDrawingRef(arra[0]);
					master.setDesignRef(arra[1]);
				}*/
				if(master.getMiForType() == null || "".equals(master.getMiForType() )) {
					throw new Exception();
				}
				master.setDrawingRef(command.getDrawingRef());
	               String dept = getDelimitedTokens(mi.getProductCat(), 1);
	               String cat = getDelimitedTokens(mi.getProductCat(), 0);
				master.setMatType(prservice.getMatType(cat, dept));
				master.setApprovedStatus("N");
				master.setMatSpec(mi.getMatSpec());
				master.setPurStatus(getLookupservice().loadIDData("MI_OPEN"));
				master.setUpdatedBy(getUserPreferences().getUserID());
				master.setUpdatedDate(new java.util.Date());
				master.setMatcode(getDelimitedTokens(mi.getProductType(),0)
						+ mi.getProductSpecid().substring(0, 5));
				master.setPreparedBy(getUserPreferences().getUserID());
				  master.setInsertedBy(getUserPreferences().getUserID()) ;
				    master.setInsertedDate(new java.util.Date());
				    System.out.println("mi data" + master.getMatQty());
				service.addNewMI(master);
				mi.reset();
			}

			SciMatindMaster master = new SciMatindMaster();
			master.setSciWorkorderMaster(wmaster);
			List milist = service.searchMIWorkOrder(master,command);
			context.getFlowScope().put("workmis", milist);
			context.getFlowScope().remove("productspecmap");
			context.getFlowScope().remove("productcatmap");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// service.addNewMI(master)
		return success();
	}

	public Event searchMI(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);

		System.out.println(command.getMatDuedate());
		if("Y".equals(command.getCancelStatus())) {
			command.setCancelStatusLov(getLookupservice().loadIDData("MI_CANCEL"));
		}
		List milist = service.searchMI(command);
		/*
		 * Map[] mymaps = prservice.loadDesc(milist);
		 * context.getFlowScope().put("pcatmap", mymaps[0]);
		 * context.getFlowScope().put("pspecmap", mymaps[1]);
		 */

		Collections.sort(milist,new SortComparator());
		context.getFlowScope().put("milist", milist);
		context.getFlowScope().put("approveMI",
				getLookupservice().loadIDData("MI_APPROVED"));
		context.getFlowScope().put("Openmi",
				getLookupservice().loadIDData("MI_OPEN"));
		return success();
	}
	public Event searchStreqView(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);

		System.out.println(command.getMatDuedate());
		List milist = service.loadStoreRequest(command);
		/*
		 * Map[] mymaps = prservice.loadDesc(milist);
		 * context.getFlowScope().put("pcatmap", mymaps[0]);
		 * context.getFlowScope().put("pspecmap", mymaps[1]);
		 */
		context.getFlowScope().put("milist", milist);
		
		
		return success();
	}
	
	public Event searchStreqViewwithFilters(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);

		System.out.println(command.getMatDuedate());
		List milist = service.loadStoreRequestFilters(command);
		/*
		 * Map[] mymaps = prservice.loadDesc(milist);
		 * context.getFlowScope().put("pcatmap", mymaps[0]);
		 * context.getFlowScope().put("pspecmap", mymaps[1]);
		 */
		context.getFlowScope().put("milist", milist);
		
		
		return success();
	}
	public Event searchMIForQC(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);
		SciWorkorderMaster wmaster = (SciWorkorderMaster) context
		.getFlowScope().get("selectedwo");
		command.setWm(wmaster);
		command.setSeqWorkId(String.valueOf(wmaster.getSeqWorkId()));
		List milist = service.searchMI(command);
		context.getFlowScope().put("milist", milist);
		/*
		 * Map[] mymaps = prservice.loadDesc(milist);
		 * context.getFlowScope().put("pcatmap", mymaps[0]);
		 * context.getFlowScope().put("pspecmap", mymaps[1]);
		 */
		
		return success();
	}
	public Event searchMIWorkOrder(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);

		SciMatindMaster master = new SciMatindMaster();
		SciWorkorderMaster wmaster = (SciWorkorderMaster) context
				.getFlowScope().get("selectedwo");
		master.setSciWorkorderMaster(wmaster);
		List milist = service.searchMIWorkOrder(master,command);
		context.getFlowScope().put("workmis", milist);
		return success();
	}
	public Event searchforApproveMI(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);
		command.setApprovalStatus("N");
		command.setPurStatus(getLookupservice().loadIDData("MI_OPEN"));
		List milist = service.searchMI(command);
		/*
		 * Map[] mymaps = prservice.loadDesc(milist);
		 * context.getFlowScope().put("pcatmap", mymaps[0]);
		 * context.getFlowScope().put("pspecmap", mymaps[1]);
		 */
		context.getFlowScope().put("milist", milist);
		context.getFlowScope().put("openMI",
				getLookupservice().loadIDData("MI_OPEN"));
		return success();
	}

	public Event selectItemMI(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);
		List itemmilist = new ArrayList();
		String chkmatcode = null;
		String matSpec = null;
		String[] milist = command.getMiindex();
		
		List fullmilist = (List) context.getFlowScope().get("milist");
		for (int idx = 0; idx < milist.length; idx++) {
			SciMatindMaster mi = (SciMatindMaster) fullmilist.get(Integer.parseInt(milist[idx]) - 1);
			String matcode = mi.getMatcode();
			matSpec = mi.getMatSpec();
			if(idx == 0) {
				chkmatcode = mi.getMatcode();
				
			}
			if(chkmatcode.equals(matcode)) {
			itemmilist.add(fullmilist.get(Integer.parseInt(milist[idx]) - 1));
			}
			else {
				context.getFlashScope().put("itemerror","itemerror");
				
				return error();
			}
		}
		context.getFlowScope().put("itemdesc", matSpec);
		context.getFlowScope().put("itemmilist", itemmilist);
		return success();
	}


	public Event selectPropMI(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);
		List propMIList = (List) context.getFlowScope().get("propMIList");
		if(propMIList == null) {
			propMIList = new ArrayList();
		}

		List<MatCollectionCommand> matlist = command.getMatList();

		List fullmilist = (List) context.getFlowScope().get("milist");
		for (MatCollectionCommand colmi : matlist) {

				if(colmi.getMatindex() != null) {
					propMIList.add(fullmilist.get(Integer.parseInt(colmi.getMatindex()) - 1));
				}
		}
		context.getFlowScope().remove("milist");
		context.getFlowScope().put("propMIList", propMIList);
		return success();
	}
	public Event selectItemMIforStock(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);
		
		String[] milist = command.getMiindex();
		
		List fullmilist = (List) context.getFlowScope().get("milist");
		for (int idx = 0; idx < milist.length; idx++) {
			SciMatindMaster mi = (SciMatindMaster) fullmilist.get(Integer.parseInt(milist[idx]) - 1);
			mi = service.loadMI(mi.getSeqMiId());
			mi.setPurStatus(getLookupservice().loadIDData("MI_IN_STOCK"));
			mi.setUpdatedBy(getUserPreferences().getUserID());
			mi.setUpdatedDate(new Date());
			System.out.println("shanmuga");
			service.mergeMI(mi);
		}
		resetForm(context);
	     context.getFlowScope().remove("milist");
		return success();
	}
	@Override
	public Event setupForm(RequestContext context) throws Exception {
		setFormObjectClass(MatindCommand.class);
		setFormObjectName("matindbean");
		setPropertyEditorRegistrar(new DatePropertyEditorRegistrar());
		return super.setupForm(context);
	}

	@Override
	public Event bind(RequestContext context) throws Exception {
		// TODO Auto-generated method stub
		super.bind(context);
		return success();
	}

	public Event loadMIList(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);
		SciMatindMaster master = new SciMatindMaster();
		SciWorkorderMaster wmaster = (SciWorkorderMaster) context
				.getFlowScope().get("selectedwo");
		master.setSciWorkorderMaster(wmaster);
		List milist = service.searchMIWorkOrder(master,command);
		/*
		 * Map[] mymaps = prservice.loadDesc(milist);
		 * context.getFlowScope().put("pcatmap", mymaps[0]);
		 * context.getFlowScope().put("pspecmap", mymaps[1]);
		 */
		List drawinglist = service.selectDesignDocs(master);
		context.getFlowScope().put("workmis", milist);
		context.getFlowScope().put("deslist", drawinglist);
		return success();
	}
	
	public Event loadDrawingList(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);
		SciMatindMaster master = new SciMatindMaster();
		SciWorkorderMaster wmaster = (SciWorkorderMaster) context
				.getFlowScope().get("selectedwo");
		master.setSciWorkorderMaster(wmaster);
		List drawinglist = service.selectDesignDocs(master);
		
		context.getFlowScope().put("deslist", drawinglist);
		return success();
	}

	public Event selectapproveMI(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);
		String dept = command.getDept();
		List itemmilist = new ArrayList();

		String[] milist = command.getMiindex();
		List fullmilist = (List) context.getFlowScope().get("milist");
		
		
		List<MatCollectionCommand> matslist = command.getMatList();
		String seqmilist = "";
		List<SciMatindMaster> finallst = new ArrayList();
		for (MatCollectionCommand mcoll:matslist) {
			if(mcoll.getMatindex() == null) {
				continue;
			}
			int position = Integer.parseInt(mcoll.getMatindex()) - 1;
			SciMatindMaster master = (SciMatindMaster) fullmilist.get(position);
			master = service.loadMI(master.getSeqMiId());
			Date matdueDate = mcoll.getMatDuedate();
			if(matdueDate != null) {
				master.setMatDuedate(matdueDate);
			}
			master.setApprovedBy(getUserPreferences().getUserID());
			master.setUpdatedBy(getUserPreferences().getUserID());
		master.setUpdatedDate(new java.util.Date());
			master.setApprovedStatus("Y");
			master.setPurStatus(getLookupservice().loadIDData("MI_APPROVED"));
			finallst.add(master);
			mcoll.reset();
			//seqmilist = seqmilist + master.getSeqMiId() + ",";
		}
		//seqmilist = seqmilist.substring(0, seqmilist.length() - 1);
		milist = null;
		
		
		command.setMiindex(milist);
		
		service.approveMilist(finallst);
		
		searchforApproveMI(context);
	     resetForm(context);
	      command = (MatindCommand) getFormObject(context);
	     command.setDept(dept);
	     
	     
		return success();
	}
	
	public Event selectCostMI(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);
		String dept = command.getDept();
		List itemmilist = new ArrayList();

		String[] milist = command.getMiindex();
		List fullmilist = (List) context.getFlowScope().get("milist");
		
		
		List<MatCollectionCommand> matslist = command.getMatList();
		String seqmilist = "";
		List<SciMatindMaster> finallst = new ArrayList();
		
		for (MatCollectionCommand mcoll:matslist) {
			if(mcoll.getMatindex() == null) {
				continue;
			}
			int position = Integer.parseInt(mcoll.getMatindex()) - 1;
			SciMatindMaster master = (SciMatindMaster) fullmilist.get(position);
			master = service.loadMI(master.getSeqMiId());
			String estunitcost = mcoll.getMatEstUnitCost();
			if(estunitcost != null) {
				master.setEstUnintCost(new BigDecimal(estunitcost));
			}
			System.out.println(estunitcost);
			master.setUpdatedBy(getUserPreferences().getUserID());
		master.setUpdatedDate(new java.util.Date());
			
		
			finallst.add(master);
			mcoll.reset();
			//seqmilist = seqmilist + master.getSeqMiId() + ",";
		}
		//seqmilist = seqmilist.substring(0, seqmilist.length() - 1);
		milist = null;
		
		
		command.setMiindex(milist);
		
		service.approveMilist(finallst);
		
		searchforApproveMI(context);
	     resetForm(context);
	      command = (MatindCommand) getFormObject(context);
	     command.setDept(dept);
	     
	     
		return success();
	}
	public Event selectRejectMI(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);
		List itemmilist = new ArrayList();

		String[] milist = command.getMiindex();
		List fullmilist = (List) context.getFlowScope().get("milist");
		
		
		List<MatCollectionCommand> matslist = command.getMatList();
		String seqmilist = "";
		List<SciMatindMaster> finallst = new ArrayList();
		for (MatCollectionCommand mcoll:matslist) {
			if(mcoll.getMatindex() == null) {
				continue;
			}
			int position = Integer.parseInt(mcoll.getMatindex()) - 1;
			SciMatindMaster master = (SciMatindMaster) fullmilist.get(position);
			master = service.loadMI(master.getSeqMiId());
			Date matdueDate = mcoll.getMatDuedate();
			if(matdueDate != null) {
				master.setMatDuedate(matdueDate);
			}
			master.setApprovedBy(getUserPreferences().getUserID());
			master.setUpdatedBy(getUserPreferences().getUserID());
			master.setUpdatedDate(new java.util.Date());
			master.setApprovedStatus("Y");
			master.setPurStatus(getLookupservice().loadIDData("MI_CANCEL"));
			finallst.add(master);
			mcoll.reset();
			//seqmilist = seqmilist + master.getSeqMiId() + ",";
		}
		//seqmilist = seqmilist.substring(0, seqmilist.length() - 1);
		milist = null;
		
		
		command.setMiindex(milist);
		
		service.approveMilist(finallst);
		searchforApproveMI(context);
		return success();
	}

	public Event selectcancelMI(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);
		List<SciMatindMaster> masterList = (List<SciMatindMaster>) context.getFlowScope().get("workmis");
		SciMatindMaster master = selectMI(masterList, command.getMiindexID());
		master = service.loadMI(master.getSeqMiId());
		master.setUpdatedBy(getUserPreferences().getUserID());
		master.setPurStatus(getLookupservice().loadIDData("MI_CANCEL"));
		
		master.setUpdatedDate(new Date());
		SciWorkorderMaster wmaster = (SciWorkorderMaster) context
				.getFlowScope().get("selectedwo");
		
		service.cancelMI(master);
		
		List rolenames = new ArrayList();
		rolenames.add("purchase");
		rolenames.add("prodsupervisor");
		for (int idx = 0; idx < rolenames.size(); idx++) {
			Long roleID = roleservice.getRoleID((String) rolenames.get(idx));

			ScigenicsRoleMaster rolemaster = roleservice.getRoleDetails(roleID);
			Set<ScigenicsUserMaster> userlist = rolemaster
					.getScigenicsUserMasters();
			for (ScigenicsUserMaster scigenicsUserMaster : userlist) {
				SciIssueMaster issueMaster = new SciIssueMaster();
				// issueMaster.setSeqIssueId(new Long(seqID));
				UserPreference userpref = getUserPreferences();
				issueMaster.setIssueAssignedTo(userpref.getUserID());
				issueMaster.setIssueStatus(SciDataConstans.TASK_OPEN_STATUS);
				issueMaster.setIssueAssignedTo(scigenicsUserMaster.getUserId());
				issueMaster.setUpdatedBy(userpref.getUserID());
				issueMaster.setIssueCreatedBy(userpref.getUserID());
				issueMaster.setUpdatedDate(new java.util.Date());
				SciIssueDetails issueDetails = new SciIssueDetails();
				issueDetails.setIssueSubject("MI CANCELED");

				issueDetails.setIssueDetails("MI CANCELED in workorder "
						+ wmaster.getJobDesc()
						+ ". Please check the MI Cancellation list");
				issueDetails.setAssignedDate(new java.util.Date());
				issueDetails.setIssueStatus(SciDataConstans.TASK_OPEN_STATUS);
				issueDetails.setAssignedFrom(userpref.getUserID());
				issueDetails.setAssignedTo(scigenicsUserMaster.getUserId());
				issueDetails.setUpdatedBy(userpref.getUserID());
				issueDetails.setUpdatedDate(new java.util.Date());
				issueMaster.addIssueDetails(issueDetails);

				//taskservice.addNewTask(issueMaster);
			}
		}

		return success();
	}

	public Event updateRemarks(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);

		SciMatindMaster master = new SciMatindMaster();
		master.setSeqMiId(command.getMiindexID());
		master.setUpdatedBy(getUserPreferences().getUserID());
		master.setRecommend(command.getRecommend());
		service.updateMI(master);
		return success();
	}
	public Event updateOldQCID(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);
		List<SciMatindMaster> masterList = (List<SciMatindMaster>) context.getFlowScope().get("milist");
		SciMatindMaster master = selectMI(masterList, command.getMiindexID());
		
		master.setUpdatedBy(getUserPreferences().getUserID());
		master.setUpdatedDate(new Date());
		master.setOldQCId(command.getOldQCId());
		service.updateFullMi(master);
		return success();
	}
	public Event loadProducts(RequestContext context) throws Exception {
		List myprodlist = prservice.selectProdType();
		context.getFlowScope().put("producttype", myprodlist);
		return success();
	}

	public Event loadCatProducts(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);

		List<MatCollectionCommand> mylist = command.getMatList();
		MatCollectionCommand mcommand = mylist.get(Integer.parseInt(command
				.getRowindex()));
		String deptandCode = mcommand.getProductType();

		List myprodcatlist = prservice.selectCategory(
				mcommand.getProductType(), getDelimitedTokens(deptandCode, 1));
		HashMap<Integer, List> mymap = (HashMap<Integer, List>) context
				.getFlowScope().get("productcatmap");

		HashMap<Integer, List> specmap = (HashMap<Integer, List>) context
				.getFlowScope().get("productspecmap");
		if (mymap == null) {
			mymap = new HashMap<Integer, List>();
		}
		if (specmap == null) {
			specmap = new HashMap<Integer, List>();
		}
		specmap.put(new Integer(command.getRowindex()), null);
		mymap.put(new Integer(command.getRowindex()), myprodcatlist);
		context.getFlowScope().put("productcatmap", mymap);
		return success();
	}

	public Event loadProductspecs(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);

		List<MatCollectionCommand> mylist = command.getMatList();
		MatCollectionCommand mcommand = mylist.get(Integer.parseInt(command
				.getRowindex()));
		String deptandcode = mcommand.getProductCat();
		String dept = getDelimitedTokens(deptandcode, 1);
		String catcode = getDelimitedTokens(deptandcode, 0);
		List myprodlist = prservice.selectProducts(catcode, dept);
		HashMap<Integer, List> mymap = (HashMap<Integer, List>) context
				.getFlowScope().get("productspecmap");
		if (mymap == null) {
			mymap = new HashMap<Integer, List>();
		}

		mymap.put(new Integer(command.getRowindex()), myprodlist);
		context.getFlowScope().put("productspecmap", mymap);
		context.getFlowScope().put("openpopup", myprodlist);
		context.getFlowScope().put("specrowindex", command.getRowindex());
		return success();
	}

	public String getDelimitedTokens(String myString, int position) {
		List mylist = new ArrayList<String>();

		StringTokenizer tokenizer = new StringTokenizer(myString, ",");
		while (tokenizer.hasMoreTokens()) {
			String tokens = tokenizer.nextToken();
			mylist.add(tokens);
		}
		if(mylist.size() <= 0) {
			return "";
		}
		return (String) mylist.get(position);
	}
	
	public Event loadOpenMIList(RequestContext context) {
	
		SciMatindMaster master = new SciMatindMaster();
		SciWorkorderMaster wmaster = (SciWorkorderMaster) context
				.getFlowScope().get("selectedwo");
		master.setSciWorkorderMaster(wmaster);
		List milist = service.loadOpenMI(master);
		/*
		 * Map[] mymaps = prservice.loadDesc(milist);
		 * context.getFlowScope().put("pcatmap", mymaps[0]);
		 * context.getFlowScope().put("pspecmap", mymaps[1]);
		 */
		List drawinglist = service.selectDesignDocs(master);
		context.getFlowScope().put("workmis", milist);
		context.getFlowScope().put("deslist", drawinglist);
		return success();
	}
	
	public Event createStoreRequest(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);
		List<SciMatindMaster> masterList = (List<SciMatindMaster>) context.getFlowScope().get("workmis");
		SciMatindMaster master = selectMI(masterList, command.getMiindexID());
		SciStoresRequest strequest = new SciStoresRequest();
		
		
		strequest.setSciMiMaster(master);
		strequest.setReqDate(new Date());
		strequest.setMatcode(master.getMatcode());
		strequest.setPurchApproval("N");
		strequest.setProdApproval("N");
		strequest.setMatSpec(master.getMatSpec());
		strequest.setMatType(master.getMatType());
		strequest.setReqDimension(master.getMatDimesion());
		strequest.setReqQuantity(master.getMatQty().toString());
		strequest.setRequestBy(getUserPreferences().getUserID());
		strequest.setRequestStatus("N");
		strequest.setUpdatedBy(getUserPreferences().getUserID());
		strequest.setUpdatedDt(new Date());
		
		strequest.setInsertedBy(getUserPreferences().getUserID()) ;
		strequest.setInsertedDate(new java.util.Date());
		service.addStoreRequest(strequest);
		searchMIWorkOrder(context);
		return success();
	}
	
	private SciMatindMaster selectMI(List<SciMatindMaster> master,Long seqmiid) {
		SciMatindMaster selected = null;
		for(SciMatindMaster m : master) {
			if(m.getSeqMiId().intValue() == seqmiid.intValue()) {
				selected = m;
			}
		}
		
		return selected;
	}
	
	public Event selectSpecs(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);
		List<MatCollectionCommand> matcollection = command.getMatList();
		
		for(int idx =0;idx<matcollection.size();idx++) {
			MatCollectionCommand comamnd1 = (MatCollectionCommand)matcollection.get(idx);
			if(idx == Integer.parseInt(command.getSelectedIdx())) {
			comamnd1.setProductSpecid(command.getMatCodeselected().substring(0, 5));
			comamnd1.setMatSpec(command.getMatCodeselected().substring(6, command.getMatCodeselected().length()));
			}
			
		}
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
	
	private SciSubcontJobstatus getSubContJob(List<SciSubcontJobstatus> master,
			Long seqScjobId) {

		SciSubcontJobstatus vendordetail = null;
		for (SciSubcontJobstatus vm : master) {
			if (vm.getSeqScjobId().intValue() == seqScjobId.intValue()) {
				vendordetail = vm;
				break;
			}

		}
		return vendordetail;
	}
	public Event loadMatCatItems(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);
		List matcatlist = prservice.selectCategory(command.getMatDept());
		context.getFlowScope().put("matcatitems",matcatlist);
		return success();
	}
	public Event loadDescriptions(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);
		List<SciMatspecMaster> matcatlist = prservice.selectProducts(command.getMatCategory(),command.getMatDept());
	StringBuilder builder = new StringBuilder();

		context.getFlowScope().put("matDescriptions",matcatlist);
		return success();
	}
	
	public Event addNewSubContractDetail(RequestContext context) throws Exception {
		
		MatindCommand command = (MatindCommand) getFormObject(context);
		SciWorkorderMaster wmaster = (SciWorkorderMaster) context
				.getFlowScope().get("selectedwo");
		
		return success();
	}

	public Event viewMIRecdItems(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);
		List matcatlist = prservice.selectCategory(command.getMatDept());
		context.getFlowScope().put("matcatitems",matcatlist);
		return success();
	}
	
	
	public Event routeSame(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);
		if("Vessel".equals(command.getJobType())) {
			List<SciLookupMaster> jobtypelist = (List<SciLookupMaster>) context.getFlowScope().get("vesseljobcodeitems");
			context.getFlowScope().put("jobtypecodes", jobtypelist);
		}
		
		if("Agitator".equals(command.getJobType())) {
			List<SciLookupMaster> jobtypelist = (List<SciLookupMaster>) context.getFlowScope().get("agigjobcodeitems");
			context.getFlowScope().put("jobtypecodes", jobtypelist);
		}
		if("".equals(command.getJobType())) {


			context.getFlowScope().put("jobtypecodes", null);
		}
		return success();
	}
	
	
	public Event addJobStatus(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);
		SciWorkorderMaster wmaster = (SciWorkorderMaster) context
				.getFlowScope().get("selectedwo");
		List<SciVendorMaster> vmlist =(List<SciVendorMaster>) context.getFlowScope().get("vendordata");
		SciSubcontJobstatus jobstatus = new SciSubcontJobstatus();
		BeanUtils.copyProperties(jobstatus, command);
		jobstatus.setInsertedBy(getUserPreferences().getUserID());
		jobstatus.setInsertedDate(new Date());
		jobstatus.setUpdatedBy(getUserPreferences().getUserID());
		jobstatus.setUpdatedDate(new Date());
		jobstatus.setSciWorkorderMaster(wmaster);
		SciVendorMaster vmaster = getVendorMaster(vmlist, command.getSeqVendorID());
		jobstatus.setSciVendorMaster(vmaster);
		service.addSubContStatus(jobstatus);
		List<SciSubcontJobstatus> jobstatuslist = service.getRecentSubcontJobStatus(wmaster.getSeqWorkId());
		
		context.getFlowScope().put("recentJobList", jobstatuslist);
		context.getFlowScope().remove("subjobdetails");
		return success();
	}
	
	public Event loadDetailsJobs(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);
		SciWorkorderMaster wmaster = (SciWorkorderMaster) context
				.getFlowScope().get("selectedwo");
		List<SciSubcontJobstatus> jobstatuslist  =(List<SciSubcontJobstatus>) context.getFlowScope().get("recentJobList");
		SciSubcontJobstatus jobstatus = getSubContJob(jobstatuslist, command.getSeqScjobIdkey());
		BeanUtils.copyProperties(command, jobstatus);
		
		if("Vessel".equals(command.getJobType())) {
			List<SciLookupMaster> jobtypelist = (List<SciLookupMaster>) context.getFlowScope().get("vesseljobcodeitems");
			context.getFlowScope().put("jobtypecodes", jobtypelist);
		}
		
		if("Agitator".equals(command.getJobType())) {
			List<SciLookupMaster> jobtypelist = (List<SciLookupMaster>) context.getFlowScope().get("agigjobcodeitems");
			context.getFlowScope().put("jobtypecodes", jobtypelist);
		}
		if("".equals(command.getJobType())) {


			context.getFlowScope().put("jobtypecodes", null);
		}
		List<SciSubcontJobstatus> detaillist = service.getLoadDetails(jobstatus.getJobCode(), jobstatus.getJobType(), jobstatus.getSciWorkorderMaster().getSeqWorkId());
		context.getFlowScope().put("subjobdetails", detaillist);
		return success();
	}
	
	public Event loadAlljobs(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);
		SciWorkorderMaster wmaster = (SciWorkorderMaster) context
				.getFlowScope().get("selectedwo");
		List<SciSubcontJobstatus> jobstatuslist = service.getRecentSubcontJobStatus(wmaster.getSeqWorkId());
		context.getFlowScope().put("recentJobList", jobstatuslist);
		
		return success();
	}
	
	
	public Event updateSubContStatus(RequestContext context) throws Exception {
		MatindCommand command = (MatindCommand) getFormObject(context);
		
		List<SciSubcontJobstatus> jobstatuslist = (List<SciSubcontJobstatus>) context.getFlowScope().get("recentJobList");
		SciSubcontJobstatus jobstatus = getSubContJob(jobstatuslist, command.getSeqScjobIdkey());
		
				
		jobstatus.setReceivedDate(command.getReceivedDate());
		jobstatus.setUpdatedBy(getUserPreferences().getUserID());
		jobstatus.setUpdatedDate(new Date());
		service.addSubContStatus(jobstatus);
		return success();
	}
	
	
}
