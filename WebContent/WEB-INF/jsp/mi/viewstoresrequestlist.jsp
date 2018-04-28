<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Search  MI Issued Items(Set Max Results) </font></p>
<p style="padding-left:20px" align="center"></p>
<div width="787px"  style="float:left;">
<form:form commandName="matindbean" name="matindbean">
<div width="787px"  style="float:left;">
<table  cellspacing="5" cellpadding="5" align="left" border="0" >


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
<fmt:formatDate pattern="dd-MM-yyyy" value="${matindbean.fromdate}" var="fromdatestr"/>	
<td><input type="text" name="fromdate" value="<c:out value="${fromdatestr}"/>" size="10"/>
<a href="javascript:show_calendar('document.matindbean.fromdate', document.matindbean.fromdate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
</td>

<td>Stores request created to date</td>
<fmt:formatDate pattern="dd-MM-yyyy" value="${matindbean.todate}" var="todatestr"/>	
<td><input type="text" name="todate" value="<c:out value="${todatestr}"/>" size="10"/>
<a href="javascript:show_calendar('document.matindbean.todate', document.matindbean.todate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
</td>
</tr>
<tr>
<td>Production Approval Status</td>
<td><form:select path="prodAppStatus"    >
<form:option value="">All</form:option>
<form:option value="Y">Production Approved</form:option>
<form:option value="N">Production Not Approved</form:option>
</form:select>

</td>
<td>Purchase Approval Status</td>
<td><form:select path="purAppStatus"  >
<form:option value="">All</form:option>
<form:option value="Y">Purchase Approved</form:option>
<form:option value="N">Purchase Not Approved</form:option>
</form:select>

</td>
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
<td colspan="2"> <input  type="button" value="Search Stores Request" onclick="eventdirect('searchST')"/> </td>

</tr>
 

</table>

</div>


<div style="float:left;width:750px;padding:10px;margin-top:50px">
<display:table export="true" sort="list"  pagesize="10" name="milist"  id="row"  cellpadding="5px" cellspacing="5px" requestURI="springtest.htm">


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
<display:column sortable="true"  title="Job Desc"  >
<c:out value="${row.sciMiMaster.sciWorkorderMaster.jobDesc}"/>
</display:column>
<display:column title="Issue MI Details">
<display:table name="${row.sciStoreIssueSet}" id="rr" cellpadding="5px" cellspacing="5px">
<display:column  >
<c:out value="${rr.sciMiMaster.seqMiId}"/>
</display:column>

</display:table>
</display:column>
</display:table>

</div>
<input type="hidden" name="_flowExecutionKey"  value="<c:out value="${flowExecutionKey}"/>" />
 <input type="hidden" name="_eventId"  id="_eventId" value="submit" >
 

 
 
</form:form>


</div>
</div>

<script language="javascript">

function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.matindbean.submit();
}
</script>
