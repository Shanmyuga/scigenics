<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Search  Issued Items </font></p>
<p style="padding-left:20px" align="center"></p>
<div width="787px"  style="float:left;">
<form:form commandName="storesbean" name="storesbean">
<div width="787px"  style="float:left;">
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

 

<td>Issue From date </td>

<fmt:formatDate pattern="dd-MM-yyyy" value="${storesbean.fromdate}" var="fromdatestr"/>	
<td><input type="text" name="fromdate" value="<c:out value="${fromdatestr}"/>" size="10"/>

<a href="javascript:show_calendar('document.storesbean.fromdate', document.storesbean.fromdate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
</td>


<td>Issue to date</td>

<fmt:formatDate pattern="dd-MM-yyyy" value="${storesbean.todate}" var="todatestr"/>	
<td><input type="text" name="todate" value="<c:out value="${todatestr}"/>" size="10"/>
<a href="javascript:show_calendar('document.storesbean.todate', document.storesbean.todate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
</td>

</tr>
<tr>
<td>Issues with Return </td>
<td><form:checkbox path ="returnStatus" value="Y" /></td>

<td>MatCode</td>
<td><form:input path="matcode" id="matcode" />
</tr>
<tr>
<td>Work Order</td>
<td  ><form:select path="seqEnqId" size="1" id="seqEnqId">
<form:option value="0">All</form:option>
<form:options items="${workmastlist}" itemValue="seqEnqId" itemLabel="jobDesc"/>
</form:select>
</td>

<td>Set Max results</td>
<td><form:input path="searchMax" id="searchMax"  />
</td>
<tr>
<td colspan="4"> <input  type="button" value="Search Issue Items" onclick="eventdirect('searchIssue')"/> </td>

</tr>
 

</table>

</div>


<div style="float:left;width:750px;padding:10px;margin-top:50px">

<display:table export="true" sort="list"   pagesize="10" name="storeissuelist"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >

<display:column sortable="true"  title="Request MI ID"  >
<c:out value="${row.strequest.sciMiMaster.seqMiId}"/>
</display:column>
<display:column sortable="true"  title="Received MI ID"  >
<c:out value="${row.sciMiMaster.seqMiId}"/>
</display:column>
<display:column sortable="true"   title="Mat Code" property="matcode"  >
</display:column>

<display:column sortable="true"   title="Mat Type" property="matType"  >
</display:column>
<display:column sortable="true"   title="Mat Spec" property="matSpec"  >
</display:column>

<display:column sortable="true"   title="Requested MI Estimated Mat Cost"   >
<fmt:parseNumber var="ut1" type="NUMBER" value="${row.strequest.sciMiMaster.unitCost}"></fmt:parseNumber>
<fmt:parseNumber var="issquantity1" type="NUMBER" value="${row.finalCount}"></fmt:parseNumber>

            
       <c:set var="utcost1" value="${issquantity1 * ut1}" />     
<fmt:formatNumber type="number" 
            maxFractionDigits="2" value="${utcost1}" />
</display:column>
<display:column sortable="true"   title="Issued Mat Cost"   >
<fmt:parseNumber var="ut" type="NUMBER" value="${row.sciMiMaster.unitCost}"></fmt:parseNumber>
<fmt:parseNumber var="issquantity" type="NUMBER" value="${row.finalCount}"></fmt:parseNumber>

            
       <c:set var="utcost" value="${issquantity * ut}" />     
<fmt:formatNumber type="number" 
            maxFractionDigits="2" value="${utcost}" />
</display:column>
<display:column sortable="true"  title="Issue Dimension" property="issueDimension" >

</display:column>


<display:column sortable="true"  title="Issue Quantity" property="finalCount" >

</display:column>

<display:column sortable="true"  title="Issue Remarks" property="issueRemarks" >

</display:column>

<display:column sortable="true"  title="Issued To" property="issuedTo" >

</display:column>
<display:column sortable="true"  title="Issued Date" property="issueDate" >

</display:column>

<display:column sortable="true"  title="Stores Requst ID"  >
<c:out value="${row.strequest.seqStreqId}" />
</display:column>
<display:column sortable="true"  title="Stores Requst Qty"  >
<c:out value="${row.strequest.reqQuantity}" />
</display:column>
<display:column sortable="true"  title="WO DESC"  >
<c:out value='${row.strequest.sciMiMaster.sciWorkorderMaster.jobDesc}'/>
</display:column>
<display:column sortable="true"  title="Client Details"  >
<c:out value='${row.strequest.sciMiMaster.sciWorkorderMaster.sciCustomerMaster.customerName}'/>
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

document.storesbean.submit();
}
</script>
