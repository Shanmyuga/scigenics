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
<form:form commandName="storesbean" name="storesbean">
<div width="787px"  style="float:left;">
<table width="600px" cellspacing="5" cellpadding="5" align="left" border="0" >
<tr>

 
<td>Purchase Order ID</td>
<td  align="left"><form:input path="seqPurchId"/>
</td>
 <td colspan="2" align="right"><input type="submit" value="Search PO"/></td>
</tr>
</table>

</div>


<div style="float:left;width:750px;padding:10px;margin-top:50px">
<p align="left">Items under this Purchase Order</p> 
 <br/>
 <br/>
<display:table sort="list"   pagesize="10" name="poitemslist"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px"  htmlId="3">

<display:column sortable="true"   title="Select" media="html"   >
<form:radiobutton path="seqItemId" value="${row.seaPuritemId}"  onclick="selectItem('getmatitems')"/>
</display:column>
<display:column sortable="true"   title="Item Description" property="itemDescription"  >
</display:column>
<display:column sortable="true"  title="Item type" property="itemDimen" >

</display:column>


<display:column sortable="true"  title="Item qty" property="itemQty" >

</display:column>

<display:column sortable="true"  title="Item cost" property="itemEstimatedCost" >

</display:column>
</display:table>

</div>

 
  <c:if test="${fn:length(matitemlist) > 0 }" >
<div  style="float:left;width:750px;padding:10px;margin-top:50px">
<p align="left">MI's under the Selected Item </p> 
 <br/>
 <br/>
<display:table  sort="list"   pagesize="10" name="matitemlist" id="row2"   requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" htmlId="2">

<display:column sortable="true"  title="Select" media="html" >
<form:radiobutton path="seqSelectMIID" value="${row2.seqMiId}" onclick="selectItem('loadrecdmi')" />


</display:column>

<display:column sortable="true"   title="MI ID"  property="seqMiId">

</display:column>
<display:column sortable="true"   title="Material Code" property="matcode"  >

</display:column>
<display:column sortable="true"  title="Material Specs"  property="matSpec" >

</display:column>
<display:column sortable="true"  title="Material Type"  property="matType" >

</display:column>

<display:column sortable="true"  title="Qty"  property="matQty">

</display:column>
<display:column sortable="true"  title="Dimen"  property="matDimesion">

</display:column>



</display:table>
</div>

</c:if>
<input type="hidden" name="_flowExecutionKey"  value="<c:out value="${flowExecutionKey}"/>" />
 <input type="hidden" name="_eventId"  id="_eventId" value="seachPO" >
 
 
<table>

</table>

   <c:if test="${fn:length(matitemlist) > 0 }" >
<div style="padding-left:10px;width:787px;float:left">
<table >

<tr>
<td>Received Dimension</td><td><form:input path="receivedDimen"/></td>
<td>Received Quantity</td><td><form:input path="receivedCnt"/></td>
<td>Remarks</td><td><form:textarea path="remarks"/></td>
</tr>

</table>

 <input type="button"  value="Add New Item" onclick="eventdirect('additem')"/>
 </div>
 </c:if>
 
<c:if test="${fn:length(recditems) > 0 }" >
<div  style="float:left;width:750px;padding:10px;margin-top:50px">
<p align="left">Earlier Recd Items for the MI </p> 
 <br/>
 <br/>
<display:table  sort="list"   pagesize="10" name="recditems" id="row2"   requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" htmlId="2">



<display:column sortable="true"  title="MI ID"  >
<c:out value="${row2.sciMiMaster.seqMiId}"/>
</display:column>
<display:column sortable="true"   title="Material Code" property="matcode" >

</display:column>
<display:column sortable="true"   title="Mat Type" property="matType"  >
</display:column>
<display:column sortable="true"   title="Mat Spec" property="matSpec"  >
</display:column>
<display:column sortable="true"  title="Recd Dimension"  property="recdDimension" >

</display:column>
<display:column sortable="true"  title="Recd Quantity"  property="recdQuantity" >

</display:column>

<display:column sortable="true"  title="Recd Date"  property="recdDate">
<display:column sortable="true"  title="WO DESC"  >
<c:out value='${row2.sciMiMaster.sciWorkorderMaster.jobDesc}'/>
</display:column>
<display:column sortable="true"  title="Client Details"  >
<c:out value='${row2.sciMiMaster.sciWorkorderMaster.sciCustomerMaster.customerName}'/>
</display:column>
</display:column>



</display:table>
</div>

</c:if>
</form:form>


</div>
</div>

<script language="javascript">

function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.storesbean.submit();
}

function selectItem(event) {


document.getElementById('_eventId').value = event;

document.storesbean.submit();
}
</script>
