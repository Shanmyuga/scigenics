<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Add  MI </font></p>
<p style="padding-left:20px" align="center"> Work Order : <c:out value="${workorderbean.jobDesc}" /></p>
<p style="padding-left:20px" align="center"> Client Details : <c:out value="${workorderbean.clientDetails}" /></p>
<div   style="float:left;overflow:auto;width:850px;margin:10px">

<form:form commandName="matindbean" name="matindbean" >

<table  width="100%" height="70px" border="1" style="border-style:solid;border-width:2px;" >
<tr >
<td align="right" class="datatext">Mat Type</td>
<td align="right" class="datatext">Mat Cate</td>
<td align="right" class="datatext">Mat Spec</td>
<td align="right" class="datatext">Qty</td>
<td align="right" class="datatext">Dimension</td>
<td align="right" class="datatext">Mat Due Date</td>

<td align="right" class="datatext">Purchase details</td>
<td align="left" class="datatext">Mi Purpose </td>



</tr>
<c:forEach begin="0" end="9"   varStatus="rowcnt">

<tr>
<td ><form:select path="matList[${rowcnt.index}].productType" size="1" id="productCat"  onchange="loadCategory(this)">
<form:option value="" >Select</form:option>
<form:options items="${producttype}" itemLabel="matType" itemValue="deptandcode"/>
</form:select></td>


<td ><form:select path="matList[${rowcnt.index}].productCat" size="1" id="productCat"  onchange="loadSpecs(this)">
<form:option value="" >Select</form:option>
<form:options items="${productcatmap[rowcnt.index]}" itemLabel="matcatType" itemValue="deptandcode"/>
</form:select></td>

<td ><form:select path="matList[${rowcnt.index}].productSpecid" size="1" id="productSpecid" onchange="loadSpecs(this)">

<form:options items="${productspecmap[rowcnt.index]}" itemLabel="specCode" itemValue="specCode"/>
</form:select></td>
<td ><form:input path="matList[${rowcnt.index}].matQty"  size="4" /></td>
<td ><form:input path="matList[${rowcnt.index}].matDimesion"  size="10"/></td>




<td ><form:input path="matList[${rowcnt.index}].matDuedatestr" size="10"  />(dd-mm-yyyy)







</td>




<td ><form:input path="matList[${rowcnt.index}].recommend" size="10"/></td>


<td ><form:select path="matList[${rowcnt.index}].miForType"  size="1" >
<form:option value="">Select</form:option>
<form:options items="${matfortypeitems}" itemValue="lovDescription" itemLabel="lovDescription"/>
</form:select>
</td>






</tr>
<form:hidden path="matList[${rowcnt.index}].matSpec"/>
</c:forEach>

<form:errors >
<c:forEach items="${messages}" var="message">
		<tr><td colspan="2"><c:out value="${message}"></c:out></td></tr>
	</c:forEach>

</form:errors>
</table>
<input type="submit" value="Add New MI" />
 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId"  id="_eventId"  value="addMaterialMI"> 
  <form:hidden path="rowindex"/>  

</div>
</div>
<div width="787px" style="float:left;">

<div style="float:left;width:750px;padding:10px;margin-top:50px">
<table>

<tr>

 

<td> Material Dept</td>
<td>
<form:select path="matDept" size="1" id="matDept" onchange="eventdirect('loadCategory')">
<form:option value="">All</form:option>
<form:options items="${matdeptlist}" />
</form:select>
</td>

<td>Material Category</td>
<td  ><form:select path="matCategory" size="1" id="matCategory">
<form:option value="">All</form:option>
<form:options items="${matcatitems}" itemValue="matcatCode" itemLabel="matcatType"/>
</form:select>
</td>
</tr>
<tr>
 <td> Material Status</td>
<td>
<form:select path="purStatus" size="1" id="purStatus" >
<form:option value="0">All</form:option>
<form:options items="${matstatitems}" itemLabel="lovDescription" itemValue="seqLovId" />
</form:select>
</td>


 <td colspan="2" align="right"><input type="button" value="Search MI" onclick="eventdirect('searchMI')"/></td>

</tr>
</table>
<display:table export="true" sort="list"   pagesize="10" name="workmis"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >
<display:column sortable="true"  title="Select"  media="html" >
<c:if test="${row.stRequestStatus == null && row.approvedStatus == 'Y'}">
<form:radiobutton path="miindexID"  value='${row.seqMiId}'></form:radiobutton>
</c:if>
</display:column>

<display:column sortable="true"  title="Request Status"  property="requestStatus" >

</display:column>
<display:column sortable="true"   title="MI ID"  property="seqMiId">

</display:column>
<display:column sortable="true"   title="Material Code" property="matcode" >

</display:column>

<display:column sortable="true"  title="Material Cat"  property="matType" >

</display:column>
<display:column sortable="true"  title="Material Spec"  property="matSpec" >

</display:column>
<display:column sortable="true"  title="Qty"  property="matQty">

</display:column>
<display:column sortable="true"  title="Dimen"  property="matDimesion">

</display:column>

<display:column sortable="true"  title="Due Date"  property="matDuedate" >

</display:column>

<display:column sortable="true"  title="Remarks"  property="recommend" >

</display:column>
<display:column sortable="true"  title="PO Remarks"  property="poDetails" >

</display:column>
<display:column sortable="true"  title="PO Due Date"  property="podueDate" >

</display:column>
<display:column sortable="true"   title="Material Status"  >
<c:out value='${lovmap[row.purStatus]}'/>
</display:column>
<display:column sortable="true"  title="Inserted By"  property="insertedBy" >

</display:column>
<display:column sortable="true"  title="Created Date"  property="insertedDate" >

</display:column>
</display:table>
</div>
 <c:if test="${fn:length(workmis) > 0}">
<p align="left" style="padding-left:10px">
 <input type="button" value="Create Store Request" onclick="javascript:addRemarks('storerequest')"/>
 </p>
</c:if>
</form:form>
</div>
<script language="javascript">
function loadSpecs(selectbx) {

document.matindbean._eventId.value = 'loadSpecs';
var sbname = selectbx.name;
document.matindbean.rowindex.value = sbname.substring(8,9);

document.matindbean.submit();

}
function loadCategory(selectbx) {

document.matindbean._eventId.value = 'loadCats';
var sbname = selectbx.name;
document.matindbean.rowindex.value = sbname.substring(8,9);

document.matindbean.submit();

}

function addRemarks(eventid) {
document.matindbean._eventId.value = eventid;
document.matindbean.submit();
}



function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.matindbean.submit();
}

</script>

<script>


</script>
