<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div width="787px"  style="float:left;padding:30px">

<br>

<p> PO Details</p>

<display:table  pagesize="10" name="selectedPO"  id="row1"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >


<display:column sortable="true"   title="Purchase ID" property="seqPurchId"  >
</display:column>


<display:column sortable="true"  title="PO Name" property="vendorOrder" >

</display:column>

<display:column sortable="true"  title="Vendor Detail" property="vendorOrder" >

</display:column>
<display:column sortable="true"  title="Status" >
<c:out value='${lovmap[row1.purchaseStatus]}'/>
</display:column>
<display:column sortable="true"  title="Due Date"  property="purchaseDueDate">

</display:column>
<display:column sortable="true"  title="Total Cost"  property="totalCost">

</display:column>
<display:column sortable="true"   title="Dispatch Mode" property="modeOfDispatch"  >
</display:column>
<display:column sortable="true"   title="Insurance" property="insurance"  >
</display:column>
<display:column sortable="true"   title="Payment Terms" property="paymentTerms"  >
</display:column>
<display:column sortable="true"   title="Delivery Schedule" property="deliverySchedule"  >
</display:column>
<display:column sortable="true"   title="Support Documents" property="supportDocuments"  >
</display:column>
</display:table>


</div>
<div width="787px"  style="float:left;padding:30px">
<form:form commandName="pocommand" name="pocommand" >
<display:table export="true" sort="list"   pagesize="10" name="podetails"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >
<display:column sortable="true"  title='Select' media="html"  >

<form:checkbox path="poitemList[${row_rowNum}].poitemIdx"  value="${row_rowNum}"/>

</display:column>
<display:column sortable="true"  title="Item ID" property="seaPuritemId" >

</display:column>
<display:column sortable="true"   title="Item Description" property="itemDescription"  >
</display:column>

<display:column sortable="true"   title="Item Code" property="itemCode"  >
</display:column>
<display:column sortable="true"  title="Item Qty" property="itemQty" >

</display:column>
<display:column sortable="true"  title="Created Date"  property="itemOrderDate">

</display:column>
<display:column sortable="true"  title="Item Dimension"  property="itemDimen">

</display:column>
<display:column sortable="true"  title="Item Estimated Cost"  property="itemEstimatedCost" >

</display:column>

<display:column sortable="true"  title="New Item Description"   >

<form:input path="poitemList[${row_rowNum}].itemDesc"  />
</display:column>

</display:table>
 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId"  id="_eventId"  value="updateMI"> 

 
</div>
<div width="787px" style="float:left;height: 150px">



</div>
</form:form>
<script language="javascript">
function addRemarks() {
document.matindbean._eventId.value = "updateRemarks";
document.matindbean.submit();
}

function openfile(idkeyval) {
document.myloginform.idkey.value=idkeyval;
document.myloginform.submit();
}
</script>