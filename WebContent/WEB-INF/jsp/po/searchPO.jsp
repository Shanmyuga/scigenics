<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Search  Purchase Orders </font></p>
<p style="padding-left:20px" align="center"></p>
<div width="787px"  style="float:left;">
<form:form commandName="pocommand" name="pocommand">
<div width="787px"  style="float:left;">
<table width="600px" cellspacing="5" cellpadding="5" align="left" border="0" >
<tr>

 
<td>PO Status</td>
<td  align="left">
<form:select path="purchaseStatus" size="1" id="matType">
<form:option value="0">All</form:option>
<form:options items="${purstats}" itemValue="seqLovId" itemLabel="lovDescription"/>
</form:select>
</td>
<td>PO type</td>
<td  align="left">
<c:choose>
<c:when test="${userPreferences.roleName == 'purchase'}">
<form:select path="purchaseType" size="1" id="purchaseType">
<form:option value="">All</form:option>
<form:option value="vendor">Vendor Purchase Order</form:option>
<form:option value="subcontract">Sub Contract Order</form:option>
</form:select>
</td>
</c:when>
<c:otherwise>
<form:select path="purchaseType" size="1" id="purchaseType">

<form:option value="subcontract">Sub Contract Order</form:option>
</form:select>

</c:otherwise>
</c:choose>
</tr>
<tr>

<td>Purchase created From date</td>
<td><form:input path="fromdate"/>
<a href="javascript:show_calendar('document.pocommand.fromdate', document.pocommand.fromdate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
</td>
<td>Purchase created To date</td>
<td><form:input path="todate"/>
<a href="javascript:show_calendar('document.pocommand.todate', document.pocommand.todate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
</td>
</td>
</tr>
<tr>
<td>PO ID</td>
<td><form:input path="purchaseID"/></td>

<td>Vendor</td>
<td  align="left">
<form:select path="seqVendorId" size="1" id="matType1">
<form:option value="0">All</form:option>
<form:options items="${vendorlist}" itemValue="seqVendorId" itemLabel="vendorConcat"/>
</form:select>
</td>
</tr>
<tr>
<td>Work Order</td>
<td><form:select path="seqWorkId"    >
<form:option value="">All</form:option>
<form:options items="${workmastlist}" itemLabel="jobDesc" itemValue="seqWorkId"/>
</form:select>

</td>
 <td colspan="2" align="right"><input type="submit" value="Search PO"/></td>
</tr>
</table>

</div>


<div style="float:left;width:750px;padding:10px;margin-top:50px">

<display:table export="true" sort="list"   pagesize="10" name="pomastlist"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >

<display:column sortable="true"   title="Select" media="html"   >
<form:radiobutton path="scipurchID" value="${row.seqPurchId}"  onclick="eventdirect('checkstatus')"/>
</display:column>
<display:column sortable="true"   title="Purchase ID" property="seqPurchId"  >
</display:column>
<display:column sortable="true"  title="PO Name" property="vendorOrder" >

</display:column>

<display:column sortable="true"  title="Vendor Detail" property="vendorOrder" >

</display:column>
<display:column sortable="true"  title="Status" >
<c:out value='${lovmap[row.purchaseStatus]}'/>
</display:column>

<display:column sortable="true"  title="PO Created Date"  property="purchaseCreatedDt">

</display:column>
<display:column sortable="true"  title="Due Date"  property="purchaseDueDate">

</display:column>
<display:column sortable="true"  title="Total Cost"  property="totalCost">

</display:column>
<display:column sortable="true"  title=" Item Total Cost"  property="itemTotalCost">

</display:column>
<display:column sortable="true"  title="PO Total Cost"  property="poTotalcost">

</display:column>
<display:column sortable="true"    property="exciseCharges">

</display:column>
<display:column sortable="true"    property="excisePercent">

</display:column>
<display:column sortable="true"   property="packingFrwdCharges">

</display:column>
<display:column sortable="true"    property="vatPercentage">

</display:column>
<display:column sortable="true"    property="vatCharges">

</display:column>

<display:column sortable="true"    property="gst">

</display:column>
<display:column sortable="true"    property="gstCharges">

</display:column>
</display:table>


</div>

<input type="hidden" name="_flowExecutionKey"  value="<c:out value="${flowExecutionKey}"/>" />
 <input type="hidden" name="_eventId"  id="_eventId" value="seachPO" >
 
 <c:if test="${fn:length(pomastlist) > 0 }" >
<div style="padding-left:10px;width:787px;float:left">
 <input type="button"  value="View Purchase Order " onclick="eventdirect('openPurchaseOrder')"/>
<input type="button"  value="Generate Purchase Order PDF" onclick="eventdirect('generatePDF')"/>

    <input type="button"  value="Send email Purchase Order PDF" onclick="eventdirect('generateEmail')"/>
   <input type="button"  value="Close Purchase Order " onclick="eventdirect('closePo')"/>
   <input type="button"  value="Cancel PO " onclick="eventdirect('cancelPO')"/>  
   <input type="button"  value="Despatch PO " onclick="eventdirect('despatchPO')"/>  
 <c:if test="${OPENSTATUS != null}">
 <input type="button"  value="Send Purchase to Vendor " onclick="eventdirect('senttovendor')"/>

 </c:if>
 </div>
 </c:if>
</form:form>


</div>
<div style="float:left;width:750px;padding:10px;margin-top:50px">
<p>Store List for the Purchase Order</p>
<display:table export="true" sort="list"   pagesize="10" name="postorelist"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >

<display:column sortable="true"  property="poid" >


</display:column>
<display:column sortable="true"   title="Matcode" property="matCode"  >
</display:column>

<display:column sortable="true"   title="Material type" property="matType"  >
</display:column>
<display:column sortable="true"  title="Material Spec" property="matSpec" >

</display:column>
<display:column sortable="true"  title="Order Qnt"  property="ordQty">

</display:column>
<display:column sortable="true"  title="QC Approved Qnt"  property="qcappQty">

</display:column>
<display:column sortable="true"  title="Received Qnt"  property="recdMatQty" >

</display:column>

<display:column sortable="true"  title="Order Dim"  property="ordDim" >

</display:column>
<display:column sortable="true"  title="QC Approved Dim"  property="qcappdim" >

</display:column>
<display:column sortable="true"  title="Received Dim"  property="recdMatDime" >

</display:column>

<display:column sortable="true"  title="Work Order"  property="workorder" >

</display:column>
</display:table>
</div>
</div>

<script language="javascript">

function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.pocommand.submit();
}
</script>
