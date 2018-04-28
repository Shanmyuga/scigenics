<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Search  MI (Set Max results) </font></p>
<p style="padding-left:20px" align="center"></p>
<div width="787px"  style="float:left;">
<form:form commandName="matindbean" name="matindbean">
 
<div width="787px"  style="float:left;">
<table  cellspacing="5" cellpadding="5" align="left" border="0" >

<tr>

<td>Material due date</td>
<fmt:formatDate pattern="dd-MM-yyyy" value="${matindbean.matDuedate}" var="matDuedatestr"/>	
<td><input type="text" name="matDuedate" value="<c:out value="${matDuedatestr}"/>" size="10"/>
<a href="javascript:show_calendar('document.matindbean.matDuedate', document.matindbean.matDuedate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
</td>
<td>Approved MI</td>
<td><form:checkbox path="approvalStatus" value="Y"/>
</td>
</tr>
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

 

<td>MI created from date</td>
<fmt:formatDate pattern="dd-MM-yyyy" value="${matindbean.fromdate}" var="fromdatestr"/>	
<td><input type="text" name="fromdate" value="<c:out value="${fromdatestr}"/>" size="10"/>
<a href="javascript:show_calendar('document.matindbean.fromdate', document.matindbean.fromdate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
</td>

<td>MI created to date</td>
<fmt:formatDate pattern="dd-MM-yyyy" value="${matindbean.todate}" var="todatestr"/>	
<td><input type="text" name="todate" value="<c:out value="${todatestr}"/>" size="10"/>
<a href="javascript:show_calendar('document.matindbean.todate', document.matindbean.todate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
</td>
</tr>
<tr>
<td>MI Status </td>
<td  ><form:select path="purStatus" size="1" id="matType" >
<form:option value="">All</form:option>
<form:options items="${matstatitems}" itemValue="seqLovId" itemLabel="lovDescription"/>
</form:select>
</td>

<td>MatCode</td>
<td><form:input path="matCodeselected" id="matCodeselected" />
</tr>
<tr>
<td>Work Order</td>
<td><form:select path="seqEnqId"    >
<form:option value="">All</form:option>
<form:options items="${workmastlist}" itemLabel="jobDesc" itemValue="seqEnqId"/>
</form:select>

</td>
<td>Set Max results</td>
<td><form:input path="searchMax" id="searchMax"  />
</td>
</tr>
<tr>
<td>MI ID</td>
<td><form:input path="seqMatindid" id="seqMatindid"  />
</td>

<td>MI Created By</td>
<td><form:select path="createdByUser"    >
<form:option value="">All</form:option>
<form:options items="${usermastlist}" itemLabel="userfullname" itemValue="userId"/>
</form:select>
</td>
</tr>
<tr>
<td>Remove Cancelled MI</td>
<td><form:checkbox path="cancelStatus" value="Y"/>
</td>
<td>Remove Issued MI</td>
<td><form:checkbox path="filterIssued" value="Y"/>
</td>
</tr>
 <tr>
<td>Remove Rejected requests</td>
<td><form:checkbox path="filterRejected" value="Y"/>
</td>
<td colspan="2"> <input  type="button" value="Search MI  Items" onclick="eventdirect('searchMI')"/> </td>

</tr>
 

</table>

</div>


<div style="float:left;width:750px;padding:10px;margin-top:50px">

<display:table export="true" sort="list"   pagesize="10" name="milist"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >



<display:column sortable="true"   title="MI ID"  property="seqMiId">

</display:column>
<display:column sortable="true"   title="Material Code" property="matcode" >

</display:column>
<display:column sortable="true"  title="Material Specs"  property="matSpec" >

</display:column>
<display:column sortable="true"  title="Material Cat"  property="matType" >

</display:column>

<display:column sortable="true"  title="Qty"  property="matQty">

</display:column>
<display:column sortable="true"  title="Dimen"  property="matDimesion">

</display:column>

<display:column sortable="true"  title="PO ID"  property="poID" >

</display:column>
<display:column sortable="true"  title="Created By"  property="insertedBy" >

</display:column>
<display:column sortable="true"  title="Created Date"  property="insertedDate" >

</display:column>
<display:column sortable="true"   title="Mat Estimated Cost"   >
<fmt:parseNumber var="ut" type="NUMBER" value="${row.estUnintCost}"></fmt:parseNumber>
<fmt:parseNumber var="issquantity" type="NUMBER" value="${row.matQty}"></fmt:parseNumber>

            
       <c:set var="utcost" value="${issquantity * ut}" />     
<fmt:formatNumber type="number" 
            maxFractionDigits="2" value="${utcost}" />
</display:column>

<display:column sortable="true"  title="Work Order Details"  property="workorderDesc"  >

</display:column>
<display:column sortable="true"   title="Material Status"  >
<c:out value='${lovmap[row.purStatus]}'/>
</display:column>
<display:column sortable="true"  title="Request Status"  property="requestStatus" >

</display:column>
<display:column sortable="true"  title="Prod Appr reques"  property="prodRequestStatus" >

</display:column>
<display:column sortable="true"  title="Purch Appr Reques"  property="purchRequestStatus" >

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
