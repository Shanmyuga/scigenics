<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Search  Store Items </font></p>
<p style="padding-left:20px" align="center"></p>
<div width="787px"  style="float:left;">
<form:form commandName="qcbean" name="qcbean"   >
<div width="787px"  >
<table  cellspacing="5" cellpadding="5" border="0" >
<tr>
<td>Mechanical</td>
<td><form:radiobutton path="dept" value="MECH"  />

</td>
 <td>Electronics</td>
<td><form:radiobutton path="dept" value="E&I"  />

</td>

 
</tr>
<tr>


 <td colspan="2" align="right"><input type="button" value="Search QC" onclick="eventdirect('searchQC')"/></td>

</tr>
</table>

</div>


<div style="float:left;width:780px;padding:10px">

<display:table export="true" sort="list"   pagesize="10" name="qcitemslist"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >


<c:set var="nestedmis" value="${row.rawmis}" />

<c:set var="nestedmyName" value="${row.mydocs}" />
<c:set var="nestedpoms" value="${row.pomasters}" />

<display:column sortable="true"  title="Select" media="html" >

<form:radiobutton  path="seqQcMiId"  value="${row.seqQcMiId}"/>

</display:column>
<display:column sortable="true"  title="MI ID"  >
<c:out value="${row.sciMiMaster.seqMiId}"/>
</display:column>
<display:column sortable="true"   title="MI Remarks"  >
<c:out value='${row.sciMiMaster.recommend}'/>
</display:column>
<display:column sortable="true"   title="Mat Dimension"  >
<c:out value='${row.sciMiMaster.matDimesion}'/>
</display:column>
<display:column sortable="true"   title="Mat Qty"  >
<c:out value='${row.sciMiMaster.matQty}'/>
</display:column>
<display:column sortable="true"   title="Mat Code" property="matCode"  >
</display:column>
<display:column sortable="true"   title="Mat Type" property="matType"  >
</display:column>
<display:column sortable="true"   title="Mat Spec" property="matSpec"  >
</display:column>

<display:column title="Subcont Vendor">
<c:forEach items="${nestedpoms }" var="row1" varStatus="table">
<c:out value="${row1.subContVendor}" />
</c:forEach>
</display:column>

<display:column title="Raw MI">
<c:forEach items="${nestedmis }" var="row1" varStatus="table">
<c:out value="${row1.seqOrigMIID}" />/
</c:forEach>
</display:column>

<display:column title="Raw Qc Docs">
<c:forEach items="${nestedmyName }" var="row1" varStatus="table">
<c:out value="${row1.originalFile}" />/
</c:forEach>
</display:column>
<display:column sortable="true"  title="Recd Qty" property="qcRecCnt" >

</display:column>
<display:column sortable="true"  title="Recd Dimension"  property="qcRecDime">

</display:column>
<display:column sortable="true"  title="Recd Date" property="insertedDate" >

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
 
  <c:if test="${fn:length(qcitemslist) > 0 }" >
<div style="padding-left:10px;width:787px;float:left">
<table >

<tr>
<td>Approved Qty</td><td><form:input path="qcAppCnt"/></td>
<td>Approved Dimen </td><td><form:input path="qcAppDime"/></td>
</tr>
<tr>
<td>Failed/Rework Qty</td><td><form:input path="qcFailedCnt"/></td>
<td>Failed/Rework Dimension</td><td><form:input path="qcFailedDim"/></td>
</tr>
<tr>
<td>Tests Conducted</td><td><form:textarea path="qcTestsCond"/></td>
<td>Fail Reason</td><td><form:input path="qcFailReason"/></td>
</tr>

<tr>
<td colspan="2">Has Failed Materials</td><td><form:checkbox path="failedStatus" value="Y"/></td>

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

document.qcbean.submit();
}
</script>
