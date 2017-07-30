<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Add Invoice Details  </font></p>
<p style="padding-left:20px" align="center"></p>
<div width="787px"  style="float:left;">
<form:form commandName="pocommand" name="pocommand" >

<table border="0" width="100%" cellpadding="10x" >



<tr>


<td align="left" class="datatext">Bill Vendor Details</td>
<td ><form:select path="seqVendorId" size="1" id="seqVendorId" onchange="eventdirect('loadPOID') ">
<form:option value="">Select</form:option>
<form:options items="${vendorlist}" itemValue="seqVendorId" itemLabel="vendorName"/>
</form:select><span style="color:red;">*</span></td>

<td align="left" class="datatext">Vendor PO ID</td>
<td ><form:select path="poId" size="1" id="poId">
<form:option value="">Select</form:option>
<form:options items="${poDetailsList}" itemValue="seqPurchId" itemLabel="seqPurchId"/>
</form:select><span style="color:red;">*</span></td>
</tr>

<tr>
<td align="left" class="datatext">Bill Amount</td>
<td ><form:input path="billAmount"   />
<span style="color:red;">*</span></td>

<td align="left" class="datatext">Bill No</td>
<td ><form:input path="billNo" />
<span style="color:red;">*</span></td>
</tr>

<tr>
<td align="left" class="datatext">Bill  Date</td>
<td ><form:input path="billDate" />
<a href="javascript:show_calendar('document.pocommand.billDate', document.pocommand.billDate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
<span style="color:red;">*</span>





</td>
<td colspan="2"><input type="submit" value="Add Invoice Details" /></td>
</tr>
<form:errors >
<c:forEach items="${messages}" var="message">
		<tr><td colspan="2"><c:out value="${message}"></c:out></td></tr>
	</c:forEach>

</form:errors>
</table>
<div style="float:left;width:750px;padding:10px;margin-top:50px">

<display:table export="true" sort="list"   pagesize="10" name="invoiceItemlist"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >

<display:column sortable="true" title="Vendor Information" >
<c:out value="${row.sciVendorMaster.vendorName}"></c:out>
</display:column>
<display:column  sortable="true" title="Bill Date" property="billDate"  >
</display:column>

<display:column sortable="true" title="Bill Amt" property="billAmount"  >
</display:column>
<display:column sortable="true" title="Bill No"  property="billNo">

</display:column>
<display:column sortable="true" title="adjusted due"  property="adjustAmount">

</display:column>
<display:column sortable="true" title="Final Due"  property="finalAmount">

</display:column>
</display:table>
</div>
<input type="hidden" name="_flowExecutionKey"  value="<c:out value="${flowExecutionKey}"/>" />
 <input type="hidden" name="_eventId"  id="_eventId" value="addInvoiceDetail" >
 

</form:form>
</div>
</div>

<script language="javascript">

function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.pocommand.submit();
}
</script>
