<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Search  Return Results </font></p>
<p style="padding-left:20px" align="center"></p>
<div width="787px"  style="float:left;">
<form:form commandName="storesbean" name="storesbean">
<div width="787px"  style="float:left;">


</div>


<div style="float:left;width:750px;padding:10px;margin-top:50px">

<display:table export="true" sort="list"   pagesize="10" name="retupdatelist"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >

<display:column sortable="true"  title="Select" media="html" >

<form:radiobutton  path="selectedQCID"  value="${row.seqRtreqId}"  onclick="eventdirect('loadavail')"/>

</display:column>
<display:column sortable="true"  title="MI ID"  >
<c:out value="${row.sciMiMaster.seqMiId}"/>
</display:column>
<display:column sortable="true"   title="Mat Code"  >
<c:out value="${row.sciMiMaster.matcode}"/>
</display:column>

<display:column sortable="true"   title="Mat Type"   >
<c:out value="${row.sciMiMaster.matType}"/>
</display:column>
<display:column sortable="true"   title="Mat Spec"   >
<c:out value="${row.sciMiMaster.matSpec}"/>
</display:column>
<display:column sortable="true"   title="Returned QTY" property="retQuantity"  >
</display:column>
<display:column sortable="true"   title="Estimated to be  Returned " property= "actualReturnQty"   >
</display:column>

<display:column sortable="true"  title="Return By"  property="insertedBy">

</display:column>
<display:column sortable="true"  title="Damaged Status"  property="damagedStatus">

</display:column>
<display:column sortable="true"  title="Issue To"  >
<c:out value="${row.stissue.issuedTo}"/>
</display:column>

<display:column sortable="true"  title="Issue Qty"  >
<c:out value="${row.stissue.issueCnt}"/>
</display:column>
<display:column sortable="true"  title="Request Qty"  >
<c:out value="${row.stissue.strequest.reqQuantity}"/>
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
 
  <c:if test="${fn:length(retupdatelist) > 0 }" >
<div style="padding-left:10px;width:787px;float:left">
<table >

</table>
<table >

<tr>
<td>Available Qty</td><td><form:input path="availableCnt"/></td>
<td>Available  Dimen </td><td><form:input path="availableDim"/></td>
</tr>

<tr>
<td>Return Received Fully</td><td><form:checkbox path="ocStatus" value="Y"/></td>
<td>Remarks</td><td><form:input path="remarks"/></td>
</tr>
<tr>
<td colspan="2">Store Rejected</td><td><form:checkbox path="closezeroItems" value="Y"/></td>

</tr>
</table>
 <input type="button"  value="Add Return Results" onclick="eventdirect('addReturnResult')"/>
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
