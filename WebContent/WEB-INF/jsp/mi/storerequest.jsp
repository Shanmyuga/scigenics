<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

 <div width="787px"  style="float:left;padding-left:20px">
 
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Stores Request For Approval</font></p>

<form:form commandName="matindbean" name="matindbean">

<table cellpadding="5px" cellspacing="10px">


<tr>

 

<td> Material <em>Dept</em></td>
<td>
<form:select path="matDept" size="1" id="matDept" onchange="eventdirect('loadCategory')">
<form:option value="">All</form:option>
<form:options items="${matdeptlist}" />
</form:select>
</td>

<td>Material Category</td>
<td  ><form:select path="matCategory" size="1" id="matCategory">
<form:option value="">All</form:option>
<form:options items="${matcatitems}" itemValue="matcatCode" itemLabel="matcatType"/>
</form:select>
</td>
</tr>
 <tr>

 

<td>Stores request created from date</td>
<td><form:input path="fromdate"  id="fromdate"/>
<a href="javascript:show_calendar('document.matindbean.fromdate', document.matindbean.fromdate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
</td>

<td>Stores request created to date</td>
<td><form:input path="todate" id="todate" />
<a href="javascript:show_calendar('document.matindbean.todate', document.matindbean.todate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
</td>
</tr>
<tr>
<c:if test="${userPreferences.roleName == 'prodsupervisor'}">
<td>Production Approval Status</td>
<td><form:select path="prodAppStatus"    >
<form:option value="">All</form:option>
<form:option value="Y">Production Approved</form:option>
<form:option value="N">Production Not Approved</form:option>
</form:select>

</td>
</c:if>
<c:if test="${userPreferences.roleName == 'purchase'}">
<td>Purchase Approval Status</td>
<td><form:select path="purAppStatus"  >
<form:option value="">All</form:option>
<form:option value="Y">Purchase Approved</form:option>
<form:option value="N">Purchase Not Approved</form:option>
</form:select>

</td>
</c:if>
<td></td>
</tr>
<tr>
<td>Work Order</td>
<td><form:select path="seqEnqId"    >
<form:option value="0">All</form:option>
<form:options items="${workmastlist}" itemLabel="jobDesc" itemValue="seqEnqId"/>
</form:select>

</td>
<td>Set Max results</td>
<td><form:input path="searchMax" id="searchMax"  />
</td>
</tr>
<tr>
<td>Stores Issued</td>
<td><form:select path="stIssued"  >
<form:option value="">All</form:option>
<form:option value="Y">Stores Issued</form:option>
<form:option value="N">Stores Not Issued</form:option>
</form:select>

</td>
<td colspan="2"> <input  type="button" value="Search Stores Request" onclick="eventdirect('searchst')"/> </td>

</tr>
 
</table>
<div   style="float:left;">
<display:table export="true" sort="list"  pagesize="10" name="openstreq"  id="row"  cellpadding="5px" cellspacing="5px" requestURI="springtest.htm">
<display:column sortable="true"  title="Select" media="html"  >
<form:checkbox path="miindex" value="${row.seqStreqId}" />
</display:column>
<display:column sortable="true"  title="Select to view mi" media="html"  >
<form:radiobutton path="miindexID" value="${row.seqStreqId}"  onclick="eventdirect('viewmi')" />
</display:column>
<display:column sortable="true"  title="Request ID" property="seqStreqId" >

</display:column>
<display:column sortable="true"  title="MI ID"  >
<c:out value="${row.sciMiMaster.seqMiId}"/>
</display:column>

<display:column sortable="true"  title="Mat Code" property="matcode" >

</display:column>
<display:column sortable="true"  title="Mat Type" property="matType" >

</display:column>
<display:column sortable="true"  title="Mat Spec" property="matSpec" >

</display:column>
<display:column sortable="true"  title="MI Status"  >
<c:out value="${lovmap[row.sciMiMaster.purStatus]}"/>
</display:column>
<display:column sortable="true"  title="Qty" property="reqQuantity" >

</display:column>
<display:column sortable="true"  title= "Dimension" property="reqDimension" >

</display:column>
<display:column sortable="true"  title= "Purchase Approved" property="purchApproval"  >

</display:column>
<display:column sortable="true"  title= "Prod Approved" property="prodApproval" >

</display:column>
<display:column sortable="true"  title= "Prod Remarks" property="prodRemarks" >

</display:column>
<display:column sortable="true"  title= "Purch Remarks" property="purhRemarks" >

</display:column>
<display:column sortable="true"  title="WO DESC"  >
<c:out value='${row.sciMiMaster.sciWorkorderMaster.jobDesc}'/>
</display:column>
<display:column sortable="true"  title="Client Details"  >
<c:out value='${row.sciMiMaster.sciWorkorderMaster.sciCustomerMaster.customerName}'/>
</display:column>

<display:column title="Issue Details">
<display:table name="${row.sciStoreIssueSet}" id="rr" cellpadding="5px" cellspacing="5px">
<display:column  >
<c:out value="${rr.sciMiMaster.seqMiId}"/>
</display:column>
<display:column  >
<c:out value="${rr.sciMiMaster.matEstcost}"/>
</display:column>
</display:table>
</display:column>
</display:table>

<div style="float:left;width:787px;padding: 10px" >
<input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId"  id="_eventId" value="viewmi" > 
 
 <c:if test="${(rolelevel == 'prodSuper' &&  matindbean.stIssued == 'N') ||(rolelevel == 'purchaseSuper' &&  matindbean.stIssued == 'N')  }">
<table>
<tr>
<td align="right">Approve</td><td  align="left"><form:radiobutton path="strapproval" value="Y"/></td>

<td  align="right">Reject</td><td align="left"><form:radiobutton path="strapproval" value="R"/></td>

<td>Remarks</td><td><form:textarea path="remarks" /></td>
</tr>
<c:if test="${rolelevel == 'prodSuper' }">
<tr>
<td colspan="2"><input type="button" value="Update Store Request" onclick="eventdirect('updateProd')"/></td>
</tr>
</c:if>
<c:if test="${rolelevel == 'purchaseSuper'}">
<tr>
<td colspan="2"><input type="button" value="Update Store Request" onclick="eventdirect('updatePurchase')"/></td>
</tr>
</c:if>
</table>
</c:if>

<br/>
<br/>
<br/>
<c:if test="${viewmidetails != null}">


<display:table export="true" sort="list"  pagesize="10" name="viewmidetails"  id="row1"  cellpadding="5px" cellspacing="5px">
<display:column sortable="true"  title="Client"   >
<c:out value="${row1.sciWorkorderMaster.clientDetails}"/>
</display:column>

<display:column sortable="true"  title="Job Details"  >
<c:out value="${row1.sciWorkorderMaster.jobDesc}"/>
</display:column>
<display:column sortable="true"  title="MI Due Date"  >
<c:out value="${row1.matDuedate}"/>
</display:column>
<display:column sortable="true"  title="MI Status"  >
<c:out value='${lovmap[row1.purStatus]}'/>
</display:column>


</display:table>


</c:if>
<br/>
<br/>
<c:if test="${storeIssues != null}">

<p style="padding-left: 50px"> Issues for this request</p>
<display:table export="true" sort="list"  pagesize="10" name="storeIssues"  id="row2"  cellpadding="5px" cellspacing="5px">
<display:column sortable="true"  title="Issue cnt" property="issueCnt"   >

</display:column>
<display:column sortable="true"  title="Issue dimension" property="issueDimension"   >

</display:column>
<display:column sortable="true"  title="Issue Date" property="issueDate"  >

</display:column>
<display:column sortable="true"  title="Issued To" property="issuedTo"  >

</display:column>



</display:table>


</c:if>
 </div>
</div>

 
</form:form>
</div>



<script language="javascript">

function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.matindbean.submit();
}


</script>