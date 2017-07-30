<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Add New WorkOrder </font></p>

<div width="787px"  style="float:left;">
<form:form commandName="workorderbean" name="workorderbean" >

<table border="1" width="100%" cellpadding="3x" height="70px">
<tr>
<td align="right" class="datatext">Client Details</td>
<td ><form:select path="seqCustId" >
<form:options items="${customerData}" itemLabel="customerName" itemValue="seqCustId"/>
</form:select>

<span style="color:red;">*</span></td></tr>
<tr>
<td align="right" class="datatext">Work Order Type</td>
<td ><form:select path="wordOrderType" size="1" id="worktype" onchange="changeDtd('changeWtype')">

<form:option value="Fermenter">Fermenter</form:option>
<form:option value="Mixing Vessel">Mixing Vessel</form:option>
<form:option value="Down Stream Equipments">Down Stream Equipments</form:option>
<form:option value="Glass">Glass Vessel</form:option>
<form:option value="Service">Service</form:option>
<form:option value="Stock">Stock WorkOrder</form:option>
<form:option value="ShopFloor Work">ShopFloor WorkOrder</form:option>
<form:option value="Sub contractWork">SubContract WorkOrder</form:option>
</form:select><span style="color:red;">*</span></td>
</tr>
<tr>
<td align="right" class="datatext">PO Number</td>
<td ><form:input path="poNumber" /></td>
</tr>
<tr>
<td align="right" class="datatext">PO Date</td>
<td ><form:input path="poDate" id="poDate" />
<a href="javascript:show_calendar('document.workorderbean.poDate', document.workorderbean.poDate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
<span style="color:red;">*</span>





</td>
</tr>
<tr>
<td align="right" class="datatext">Job Description</td>
<td ><form:input path="jobDesc" /><span style="color:red;">*</span></td>
</tr>
<tr>
<td align="right" class="datatext">Date of Delivery as Per PO </td>
<td ><form:input path="datePerPo" />
<a href="javascript:show_calendar('document.workorderbean.datePerPo', document.workorderbean.datePerPo.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
<span style="color:red;">*</span></td></tr>
<tr>
<tr>
<td align="right" class="datatext">Delivery Address</td>
<td ><form:textarea path="deliveryAdd" /><span style="color:red;">*</span></td></tr>
<tr>
<c:if  test="${workorderbean.wordOrderType == 'Service1' && workorderbean.wordOrderType == 'Stock1'}">
<tr>
<td align="center" class="datatext" colspan="2" >Delivery Instructions</td>
</tr>






<tr>
<td align="right" class="datatext">Packing</td>
<td ><form:select path="packing"  >

<form:option value="Included">Included</form:option>
<form:option value="Not Included">Not Included</form:option>
<form:option value="Nil">Nil</form:option>
<form:option value="NA">NA</form:option>
</form:select><span style="color:red;">*</span></td>
</tr>
<tr>
<td align="right" class="datatext">Insurance </td>
<td ><form:select path="insurance">

<form:option value="Included">Included</form:option>
<form:option value="Not Included">Not Included</form:option>
<form:option value="Nil">Nil</form:option>
<form:option value="NA">NA</form:option>
</form:select><span style="color:red;">*</span></td>
</tr>
<tr>
<td align="right" class="datatext">Frieght</td>
<td ><form:select path="frieght"  >

<form:option value="Included">Included</form:option>
<form:option value="Not Included">Not Included</form:option>
<form:option value="Nil">Nil</form:option>
<form:option value="NA">NA</form:option>
</form:select><span style="color:red;">*</span></td>
</tr>
<tr>
<td align="right" class="datatext">Transporter</td>
<td ><form:select path="transportation"  >

<form:option value="Included">Included</form:option>
<form:option value="Not Included">Not Included</form:option>
<form:option value="Nil">Nil</form:option>
<form:option value="NA">NA</form:option>
</form:select><span style="color:red;">*</span></td>
</tr>
<tr>
<td align="right" class="datatext">Octroi</td>
<td ><form:select path="octroi"  >

<form:option value="Included">Included</form:option>
<form:option value="Not Included">Not Included</form:option>
<form:option value="Nil">Nil</form:option>
<form:option value="NA">NA</form:option>
</form:select><span style="color:red;">*</span></td>
</tr>
<tr>
<td align="right" class="datatext">Road Permit</td>
<td ><form:select path="roadPermit"  >

<form:option value="Included">Included</form:option>
<form:option value="Not Included">Not Included</form:option>
<form:option value="Nil">Nil</form:option>
<form:option value="NA">NA</form:option>
</form:select><span style="color:red;">*</span></td>
</tr>
<tr>
<td align="right" class="datatext">Sales Tax</td>
<td >
<form:input path="salesTax" />
<span style="color:red;">*</span></td>
</tr>
<tr>
<td align="right" class="datatext">Excise Duty</td>

<td >
<form:input path="exciseDuty" />
<span style="color:red;">*</span></td>
</tr>
<tr>
<td align="right" class="datatext">Entry Tax</td>
<td ><form:select path="entryTax"  >

<form:option value="Applicable">Applicable</form:option>

<form:option value="NA">NA</form:option>
</form:select><span style="color:red;">*</span></td>
</tr>
<tr>
<td align="right" class="datatext">Inspection By</td>
<td ><form:select path="inspectionBy"  >

<form:option value="Client">Client</form:option>
<form:option value="Third Party">Third Party</form:option>
</form:select><span style="color:red;">*</span></td>
</tr>
<tr>
<td align="right" class="datatext">Basis</td>
<td ><form:select path="basis"  >
<form:option value="Exworks">Exworks</form:option>
<form:option value="FOR"> FOR </form:option>
<form:option value="For Destination">For Destination</form:option>
<form:option value="For Destination">CIF</form:option>
</form:select><span style="color:red;">*</span></td>
</tr>
</c:if>
<tr>
<td align="right" class="datatext">Prepared By</td>
<td ><form:input path="preparedBy" /><span style="color:red;">*</span></td>
</tr>
<tr>
<td align="right" class="datatext">Approved By</td>
<td ><form:input path="approvedBy" /><span style="color:red;">*</span></td>
</tr>
<tr >
<td align="right" >&nbsp;</td>
<td>

   
 
 <input type="button" value="Save Work Order" onclick="changeDtd('saveWorkOrder')" />
  

</td>
</tr>
<form:errors >
<c:forEach items="${messages}" var="message">
		<tr><td colspan="2"><c:out value="${message}"></c:out></td></tr>
	</c:forEach>

</form:errors>
</table>

   <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
   <input type="hidden" name="_eventId"  id="_eventId" value="designspec"> 
</form:form>
</div>
</div>
<div width="787px" style="float:left;">



</div>

<script language="javascript">

function changeDtd(event) {

document.workorderbean._eventId.value=event;
document.workorderbean.submit();

}
</script>