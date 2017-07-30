<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Create Purchase Order </font></p>
<p style="padding-left:20px" align="center"></p>
<div width="787px"  style="float:left;">
<form:form commandName="pocommand" name="pocommand" >

<table border="0" width="100%" cellpadding="10x" >



<tr>
<td align="left" class="datatext">Purchase Order Name</td>
<td ><form:input path="vendorOrder" /><span style="color:red;">*</span></td>

<td align="left" class="datatext">Purchase Vendor Details</td>
<td ><form:select path="seqVendorId" size="1" id="seqVendorId">
<form:option value="">Select</form:option>
<form:options items="${vendordata}" itemValue="seqVendorId" itemLabel="vendorName"/>
</form:select><span style="color:red;">*</span></td>
</tr>
<tr>
<td align="left" class="datatext">Dispatch Mode</td>
<td ><form:select path="modeOfDispatch"  id="modeOfDispatch">
<form:option value="By Air">By Air</form:option>
<form:option value="By Road">By Road</form:option>
<form:option value="By Water">By Ship</form:option>
</form:select>
<span style="color:red;">*</span></td>

<td align="left" class="datatext">Insurance</td>
<td ><form:select path="insurance"  id="insurance">
<form:option value="By You">By You</form:option>
<form:option value="By Scigenics">By Scigenics</form:option>

</form:select><span style="color:red;">*</span></td>
</tr>
<tr>
<td align="left" class="datatext">Payment Terms</td>
<td ><form:textarea path="paymentTerms" />
<span style="color:red;">*</span></td>

<td align="left" class="datatext">Delivery Schedule</td>
<td >

<form:select path="deliverySchedule"  id="deliverySchedule">
<form:option value="Not Later than">Not Later than</form:option>
<form:option value="After this date">After this date</form:option>

</form:select>
<span style="color:red;">*</span></td>
</tr>
<tr>
<td align="left" class="datatext">Special Conditions</td>
<td ><form:textarea path="specialCondition" />
<span style="color:red;">*</span></td>

<td align="left" class="datatext">Support Documents</td>
<td ><form:select path="supportDocuments"  id="supportDocuments" multiple="true">
<form:option value="Test Certificate">Test Certificate</form:option>
<form:option value="Calibration Report">Calibration Report</form:option>
<form:option value="Guarantee Certicate">Guarantee Certicate</form:option>
<form:option value="Operation Manual">Operation Manual</form:option>
</form:select>
</td>
</tr>
<tr>
<td align="left" class="datatext">PO Due Date</td>
<td ><form:input path="purchaseDueDate" />
<a href="javascript:show_calendar('document.pocommand.purchaseDueDate', document.pocommand.purchaseDueDate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
<span style="color:red;">*</span>





</td>

<td align="right" >Purchase Type</td>

<td ><form:select path="purchaseType"  id="purchaseType">
<form:option value="vendor">Vendor Purchase Order</form:option>
<form:option value="subcontract">Sub Contract Order</form:option>

</form:select><span style="color:red;">*</span></td>
</tr>

<tr>
<td align="left" class="datatext">Vat/CST Percentage</td>
<td ><form:input path="vatPercentage"  disabled="true"/>
</td>
<td align="left" class="datatext">Excise Percentage</td>
<td ><form:input path="excisePercent"   disabled="true"/>
</td>
</tr>

<tr>
<td align="left" class="datatext">GST</td>
<td ><form:input path="gst"  />
</td>

</tr>


<tr>
<td align="left" class="datatext">Packing and Forwarding Charges</td>
<td ><form:input path="packingFrwdCharges"  />
</td>
<td align="left" class="datatext">Freight Charges</td>
<td ><form:input path="freigntCharges" />
</td>
</tr>

<tr>
<td align="left" class="datatext">Refund Statment</td>
<td ><form:input path="refundStatement" />
</td>
<td align="left" class="datatext">Remarks PO</td>
<td ><form:input path="remarksPO" />
</td>
</tr>

<tr>
<td align="left" class="datatext">Quotation Ref</td>
<td ><form:input path="qutRefNo" />
</td>
<td align="left" class="datatext">Reference Date</td>
<td ><form:input path="refDate" />
<a href="javascript:show_calendar('document.pocommand.refDate', document.pocommand.refDate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
</td>
</tr>
<tr>
<td align="left" class="datatext">Subcont Vendor</td>
<td ><form:input path="subContVendor" />
<td colspan="2"><input type="submit" value="Create New PO" /></td>
</tr>
<form:errors >
<c:forEach items="${messages}" var="message">
		<tr><td colspan="2"><c:out value="${message}"></c:out></td></tr>
	</c:forEach>

</form:errors>
</table>
<div style="float:left;width:750px;padding:10px;margin-top:50px">

<display:table export="true" sort="list"   pagesize="10" name="poItemlist"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >


<display:column  sortable="true" title="Item Description" property="itemDescription"  >
</display:column>
<display:column title="Item Qty" property="itemQty" >

</display:column>
<display:column  title="Item Code" property="itemCode"  >
</display:column>
<display:column title="Created Date"  property="itemOrderDate">

</display:column>
<display:column title="Item Dimension"  property="itemDimen">

</display:column>
<display:column title="Item Estimated Cost"  property="itemEstimatedCost" >

</display:column>

</display:table>
</div>
<input type="hidden" name="_flowExecutionKey"  value="<c:out value="${flowExecutionKey}"/>" />
 <input type="hidden" name="_eventId"  id="_eventId" value="addPO" >
 

</form:form>
</div>
</div>

<script language="javascript">

function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.pocommand.submit();
}
</script>
