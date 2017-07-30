<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Add Vendor Quotations Details  </font></p>
<p style="padding-left:20px" align="center"></p>
<div width="787px"  style="float:left;">
<form:form commandName="pocommand" name="pocommand" >

<table border="0" width="100%" cellpadding="10x" >

<tr>

 

<td> Material Dept</td>
<td>
<form:select path="matDept" size="1" id="matDept" onchange="eventdirect('loadCategory')">

<form:options items="${matdeptlist}" />
</form:select>
</td>

<td>Material Category</td>
<td  ><form:select path="matCategory" size="1" id="matCategory" onchange="eventdirect('loadQuotations')">
<form:option value="">All</form:option>
<form:options items="${matcatitems}" itemValue="matcatType" itemLabel="matcatType"/>
</form:select>
</td>
</tr>

<tr>

<td align="left" class="datatext">Unit Price Amount</td>
<td ><form:input path="matCost"   />
<span style="color:red;">*</span></td>

<td align="left" class="datatext">Material Specs</td>
<td ><form:input path="specDetails" />
<span style="color:red;">*</span></td>
</tr>

<tr>

<td align="left" class="datatext">Excise Duty(%)</td>
<td ><form:input path="exciseDuty"   /></td>


<td align="left" class="datatext">Sales Tax(%)</td>
<td ><form:input path="salesTax" /></td>
</tr>
<tr>

<td align="left" class="datatext">Frieght Charges in (Rs)</td>
<td ><form:input path="frieghtCharges" /></td>

<td align="left" class="datatext"> Vendor Details</td>
<td ><form:select path="seqVendorId" size="1" id="seqVendorId">
<form:option value="">Select</form:option>
<form:options items="${vendorlist}" itemValue="seqVendorId" itemLabel="vendorName"/>
</form:select><span style="color:red;">*</span></td>

</tr>
<tr>
<td align="left" class="datatext">Quotation Date</td>
<td ><form:input path="quotationDate" />

<a href="javascript:show_calendar('document.pocommand.quotationDate', document.pocommand.quotationDate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
<span style="color:red;">*</span>

</td>
<td colspan="2"><input type="submit" value="Add Vendor Cost Details" /></td>

</tr>
<tr>

<form:errors >
<c:forEach items="${messages}" var="message">
		<tr><td colspan="2"><c:out value="${message}"></c:out></td></tr>
	</c:forEach>

</form:errors>
</table>
<div style="float:left;width:750px;padding:10px;margin-top:50px">

<display:table export="true" sort="list"   pagesize="10" name="quotationsList"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >

<display:column sortable="true" title="Vendor Information" >
<c:out value="${row.sciVendorMaster.vendorName}"></c:out>
</display:column>

<display:column sortable="true" title="Mat Dept"  property="matDept">

</display:column>
<display:column  sortable="true" title="Mat Category" property="matCategory"  >
</display:column>

<display:column sortable="true" title="Mat unit cost" property="matCost"  >
</display:column>
<display:column sortable="true" title="Spec Details"  property="specDetails">

</display:column>
<display:column sortable="true" title="Excise Duty"  property="exciseDuty">

</display:column>
<display:column sortable="true" title="Sales Tax"  property="salesTax">

</display:column>
<display:column sortable="true" title="Freight Charges"  property="frieghtCharges">

</display:column>
<display:column sortable="true" title="Quotation Date"  property="quotationDate">

</display:column>
<display:column sortable="true" title="Inserted Date"  property="updatedDate">

</display:column>

</display:table>
</div>
<input type="hidden" name="_flowExecutionKey"  value="<c:out value="${flowExecutionKey}"/>" />
 <input type="hidden" name="_eventId"  id="_eventId" value="addPaymentDetail" >
 

</form:form>
</div>
</div>

<script language="javascript">

function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.pocommand.submit();
}
</script>
