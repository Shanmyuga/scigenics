
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<script language="javascript">

function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.storesbean.submit();
}
</script>


 <div width="787px"  style="float:left;padding-left:20px">
 <form:form commandName="storesbean" name="storesbean">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Stores Request For Issue</font></p>
<table  cellspacing="5" cellpadding="5" align="left" border="0" >
<tr>

 

<td> Material Dept</td>
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

 

<td>Request Start date</td>
<fmt:formatDate pattern="dd-MM-yyyy" value="${storesbean.fromdate}" var="fromdatestr"/>	
<td><input type="text" name="fromdate" value="<c:out value="${fromdatestr}"/>" size="10"/>
<a href="javascript:show_calendar('document.storesbean.fromdate', document.storesbean.fromdate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
</td>

<td>Request End date</td>
<fmt:formatDate pattern="dd-MM-yyyy" value="${storesbean.todate}" var="todatestr"/>	
<td><input type="text" name="todate" value="<c:out value="${todatestr}"/>" size="10"/>
<a href="javascript:show_calendar('document.storesbean.todate', document.storesbean.todate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
</td>
</tr>
<tr>
 <td>Work Order</td>
 <td><form:select path="seqEnqId"    >
  <form:option value="">All</form:option>
  <form:options items="${workorderlist}" itemLabel="jobDesc" itemValue="seqEnqId"/>
 </form:select>

 </td>
<td colspan="2"> <input  type="button" value="Search Stores Request" onclick="eventdirect('searchstoresreq')"/> </td>

</tr>


</table>


<div width="787px"  style="float:left;">
<display:table export="true" sort="list" keepStatus="true"  pagesize="10" name="openstreq" 
 id="row" requestURI="springtest.htm"  >
<display:column   title="Select" media="html"  >
<form:radiobutton path="seqSelectMIID" value="${row.seqStreqId}" onclick="eventdirect('loadPrevIssues')"/>
</display:column>

<display:column sortable="true"  title="Request ID" property="seqStreqId" >

</display:column>
<display:column sortable="true"  title="MI ID"  >
<c:out value="${row.sciMiMaster.seqMiId}"/>
</display:column>

<display:column sortable="true"  title="Mat Code" property="matcode" >

</display:column>

<display:column sortable="true"   title="Mat Type" property="matType"  >
</display:column>
<display:column sortable="true"   title="Mat Spec" property="matSpec"  >
</display:column>
<display:column sortable="true"  title="Qty" property="reqQuantity" >

</display:column>
<display:column sortable="true"  title= "Dimension" property="reqDimension" >

</display:column>
<display:column sortable="true"  title= "Purchase Remarks" property="purhRemarks" >

</display:column>
<display:column sortable="true"  title= "Production Remarks" property="prodRemarks" >

</display:column>
<display:column sortable="true"  title="MI Remarks"  >
<c:out value='${row.sciMiMaster.recommend}'/>
</display:column>
<display:column sortable="true"  title="WO DESC"  >
<c:out value='${row.sciMiMaster.sciWorkorderMaster.jobDesc}'/>
</display:column>
<display:column sortable="true"  title="Client Details"  >
<c:out value='${row.sciMiMaster.sciWorkorderMaster.sciCustomerMaster.customerName}'/>
</display:column>
</display:table>

 <p>

Cancellation Reason :

  <input type = "text" id="cancelReason" name="cancelReason"/>

 </p>
 <p>
 
  <input type="button" value="Search Stores with Mi/MatCode" onclick="eventdirect('viewbyMI')">
  <input type="button"  value="Cancel  Stores Request" onclick="eventdirect('cancelStoresRequest')"/>

 </p>
  
  <br/>
  <div style="float:left;width:750px;padding:10px;">
  <c:if test="${storeIssues != null}">

<p > Issues for this request</p>
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
<c:if test="${fn:length(storeavailmi) > 0 }" >
<div style="float:left;width:750px;padding:10px;margin-top:50px">

<display:table export="true" sort="list"   pagesize="10" name="storeavailmi"  id="row2"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >

<display:column   title="Select" media="html"   >
<form:radiobutton path="seqAvailId" value="${row2.seqAvailId}"  />
</display:column>
<display:column sortable="true"  title="MI ID"  >
<c:out value="${row2.sciMiMaster.seqMiId}"/>
</display:column>
<display:column sortable="true"  title="Mat Code" property="matcode" />
<display:column sortable="true"  title="Avail Qty" property="availQty" />
<display:column sortable="true"  title="Avail Dim" property="availDimension" >
</display:column>
<display:column sortable="true"  title="QC ID" property="seqQcId" >
</display:column>
<display:column sortable="true"  title="WO DESC"  >
<c:out value='${row2.sciMiMaster.sciWorkorderMaster.jobDesc}'/>
</display:column>
<display:column sortable="true"  title="Client Details"  >
<c:out value='${row2.sciMiMaster.sciWorkorderMaster.sciCustomerMaster.customerName}'/>
</display:column>



</display:table>


</div>
</c:if>
<div style="float:left;width:787px;padding: 10px" >
<input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId"  id="_eventId" value="viewAvailList" > 


  
<c:if test="${fn:length(storeavailmi) > 0 }" >

<table >

<tr>
<td>Issue Dimension</td><td><form:input path="issueDimension"/></td>
<td>Issued Count</td><td><form:input path="issueCnt"/></td>
</tr>
<tr>
<td>Has Return Qty</td><td><form:checkbox path="hasReturnQty" value="Y"/></td>
<td colspan="2"></td>
</tr>



<tr>
<td colspan="1">Issued to </td><td><form:input path="issuedTo" /> 
</td>
<td>Issue Remarks</td><td><form:input path="issueRemarks" /></td>
</tr>
<tr>
<td>Close Store request</td><td><form:checkbox path="storerequestStatus" value="Y"/></td>
<td colspan="2"></td>
</tr>
</table>

 <input type="button"  value="Issue  Item" onclick="eventdirect('issueItem')"/>
 </c:if>

 </div>
</div>

 
</form:form>
</div>


