<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Search  QC Results </font></p>
<p style="padding-left:20px" align="center"></p>
<div width="787px"  style="float:left;">
<form:form commandName="storesbean" name="storesbean">
<div width="787px"  style="float:left;">


</div>


<div style="float:left;width:750px;padding:10px;margin-top:50px">

<display:table export="true" sort="list"   pagesize="10" name="qcupdatelist"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >

<display:column sortable="true"  title="Select" media="html" >

<form:radiobutton  path="selectedQCID"  value="${row.seqQcMiId}"  onclick="eventdirect('loadavail')"/>

</display:column>
<display:column sortable="true"  title="MI ID"  >
<c:out value="${row.sciMiMaster.seqMiId}"/>
</display:column>

<display:column sortable="true"   title="PurchItem ID" property="seqPurchItemID"  >
</display:column>
<display:column sortable="true"   title="Mat Code" property="matCode"  >
</display:column>

<display:column sortable="true"   title="Mat Type" property="matType"  >
</display:column>
<display:column sortable="true"   title="Mat Spec" property="matSpec"  >
</display:column>
<display:column sortable="true"   title="QC QTY" property="qcAppCnt"  >
</display:column>

<display:column sortable="true"   title="QC Dimen" property="qcAppDime"  >
</display:column>
<display:column sortable="true"  title="Recd Qty"  >
<c:out value="${row.stmimaster.recdMatQty}"></c:out>
</display:column>
<display:column sortable="true"  title="Recd Dimen"  >
<c:out value="${row.stmimaster.recdMatDime}"></c:out>
</display:column>

<display:column sortable="true"  title="Order Qty"  >
<c:out value="${row.stmimaster.ordQty}"></c:out>
</display:column>
<display:column sortable="true"  title="Order Dim"  >
<c:out value="${row.stmimaster.ordDim}"></c:out>
</display:column>


<display:column sortable="true"  title="Recd Date"  property="updatedDt">

</display:column>
<display:column sortable="true"  title="WO DESC"  >
<c:out value='${row.sciMiMaster.sciWorkorderMaster.jobDesc}'/>
</display:column>
<display:column sortable="true"  title="Client Details"  >
<c:out value='${row.sciMiMaster.sciWorkorderMaster.sciCustomerMaster.customerName}'/>
</display:column>

</display:table>
</div>
<input type="hidden" name="_flowExecutionKey"  value="<c:out value="${flowExecutionKey}"/>" />
 <input type="hidden" name="_eventId"  id="_eventId" value="searchItem" >
 
  <c:if test="${fn:length(qcupdatelist) > 0 }" >
<div style="padding-left:10px;width:787px;float:left">
<table >

</table>
<table >

<tr>
<td>Available Qty</td><td><form:input path="availableCnt"/></td>
<td>Available  Dimen </td><td><form:input path="availableDim"/></td>
</tr>

<tr>
<td>MI Received Fully</td><td><form:checkbox path="ocStatus" value="Y"/></td>
<td>Remarks</td><td><form:input path="remarks"/></td>
</tr>
<tr>
<td colspan="2">Zero Items Approved</td><td><form:checkbox path="closezeroItems" value="Y"/></td>

</tr>
</table>
 <input type="button"  value="Add QC Results" onclick="eventdirect('addQCResult')"/>
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



</script>
