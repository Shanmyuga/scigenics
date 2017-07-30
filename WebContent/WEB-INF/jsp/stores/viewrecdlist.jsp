<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Recd Store  Items </font></p>
<p style="padding-left:20px" align="center"></p>
<div width="787px"  style="float:left;">
<form:form commandName="storesbean" name="storesbean">
<div width="787px"  style="float:left;">
<table width="600px" cellspacing="5" cellpadding="5" align="left" border="0" >

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

 

<td>Received From date</td>
<fmt:formatDate pattern="dd-MM-yyyy" value="${storesbean.fromdate}" var="fromdatestr"/>	
<td><input type="text" name="fromdate" value="<c:out value="${fromdatestr}"/>" size="10"/>
<a href="javascript:show_calendar('document.storesbean.fromdate', document.storesbean.fromdate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
</td>

<td>Received to date</td>
<fmt:formatDate pattern="dd-MM-yyyy" value="${storesbean.todate}" var="todatestr"/>	
<td><input type="text" name="todate" value="<c:out value="${todatestr}"/>" size="10"/>
<a href="javascript:show_calendar('document.storesbean.todate', document.storesbean.todate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
</td>
</tr>
<tr>
<td>MatCode</td>
<td><form:input path="matcode" id="matcode" /></td>

<td>Vendor Details</td>
<td  ><form:select path="seqVendorID" size="1" id="seqVendorID">
<form:option value="">All</form:option>
<form:options items="${vendorlist}" itemValue="seqVendorId" itemLabel="vendorName"/>
</form:select>
</td>
</tr>
<tr>
<td>MI ID</td>
<td><form:input path="seqmiid"  id="seqmiid"/>

</td>
 <td colspan="2" align="right"><input type="button" value="Search Recd Items" onclick="eventdirect('searchRecd')"/></td>

</tr>
</table>

</div>


<div style="float:left;width:750px;padding:10px;margin-top:50px">

<display:table export="true" sort="list"   pagesize="10" name="recdlist"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >
<display:column sortable="true"  title="MI ID"  >
<c:out value="${row.sciMiMaster.seqMiId}"/>
</display:column>

<display:column sortable="true"   title="Mat Code"   >
<c:out value="${row.sciMiMaster.matcode}"/>
</display:column>
<display:column sortable="true"   title="Mat Type"  >
<c:out value="${row.sciMiMaster.matType}"/>
</display:column>
<display:column sortable="true"   title="Mat Spec"   >
<c:out value="${row.sciMiMaster.matSpec}"/>
</display:column>
<display:column sortable="true"  title="Recd Dimension" property="recdDimension" >

</display:column>


<display:column sortable="true"  title="Recd Quantity" property="recdQuantity" >

</display:column>


<display:column sortable="true"  title="Stores Received Date" property="updatedDate" >

</display:column>
<display:column sortable="true"  title="Puchase Order ID" property="poId" >

</display:column>
<display:column sortable="true"  title="Puchase Item ID" property="seqPurchItemID" >

</display:column>
<display:column sortable="true"  title="MI WO DESC"  >
<c:out value='${row.sciMiMaster.sciWorkorderMaster.jobDesc}'/>
</display:column>
<display:column sortable="true"  title="Ordered Quantity"  >
<c:out value='${row.sciMiMaster.matQty}'/>
</display:column>
<display:column sortable="true"  title="Ordered Dimension"  >
<c:out value='${row.sciMiMaster.matDimesion}'/>
</display:column>
<display:column sortable="true"  title="MI Client Details"  >
<c:out value='${row.sciMiMaster.sciWorkorderMaster.sciCustomerMaster.customerName}'/>
</display:column>

<display:column sortable="true"   title="Mat  Cost"   >
<fmt:parseNumber var="ut" type="NUMBER" value="${row.sciMiMaster.unitCost}"></fmt:parseNumber>
<fmt:parseNumber var="recdQuantity" type="NUMBER" value="${row.recdQuantity}"></fmt:parseNumber>
<c:out value="${ut*recdQuantity}"/>
</display:column>
</display:table>


</div>
<input type="hidden" name="_flowExecutionKey"  value="<c:out value="${flowExecutionKey}"/>" />
 <input type="hidden" name="_eventId"  id="_eventId" value="seachPO" >
 

 
 
</form:form>


</div>
</div>

<script language="javascript">

function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.storesbean.submit();
}
</script>
