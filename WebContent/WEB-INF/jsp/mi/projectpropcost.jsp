<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Search  MI (Set Max results) </font></p>
<p style="padding-left:20px" align="center"></p>
<div width="787px"  style="float:left;">
<form:form commandName="matindbean" name="matindbean">
 
<div width="787px"  style="float:left;">
<table  cellspacing="5" cellpadding="5" align="left" border="0" >


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
<td>MI Status </td>
<td  ><form:select path="purStatus" size="1" id="matType">
<form:option value="">All</form:option>
<form:options items="${matstatitems}" itemValue="seqLovId" itemLabel="lovDescription"/>
</form:select>
</td>

<td>MatCode</td>
<td><form:input path="matCodeselected" id="matCodeselected" />
</tr>

<tr>
<td>MI ID</td>
<td><form:input path="seqMatindid" id="seqMatindid"  />
</td>
<td colspan="2"> <input  type="button" value="Search MI  Items" onclick="eventdirect('searchMI')"/> </td>

</tr>

</table>

</div>


<div style="float:left;width:750px;padding:10px;margin-top:50px">

<display:table export="true" sort="list"   pagesize="10" name="milist"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >

<display:column sortable="true"  title='Select' media="html"  >
<c:if test="${row.tempestCost == 0}">
<form:checkbox  path="matList[${row_rowNum%10}].matindex"  value="${row_rowNum}"/>
</c:if>
</display:column>

<display:column sortable="true"   title="MI ID"  property="seqMiId">

</display:column>
<display:column sortable="true"   title="Material Code" property="matcode" >

</display:column>
<display:column sortable="true"  title="Material Specs"  property="matSpec" >

</display:column>
<display:column sortable="true"  title="Material Cat"  property="matType" >

</display:column>

<display:column sortable="true"  title="Qty"  property="matQty">

</display:column>
<display:column sortable="true"  title="Dimen"  property="matDimesion">

</display:column>

<display:column sortable="true"  title="Due Date"  property="matDuedate" >

</display:column>

<display:column sortable="true"  title="Created Date"  property="insertedDate" >

</display:column>

<display:column sortable="true"  title="Client Details"   >
<c:out value='${row.sciWorkorderMaster.sciCustomerMaster.customerName}'/>
</display:column>
<display:column sortable="true"  title="Work Order Details"   >
<c:out value='${row.sciWorkorderMaster.jobDesc}'/>
</display:column>
<display:column sortable="true"   title="Material Status"  >
<c:out value='${lovmap[row.purStatus]}'/>
</display:column>
<display:column sortable="true"  title="Request Status"  property="requestStatus" >

</display:column>
<display:column sortable="true"  title="Last Itemized Unit Cost"  property="tempunitCost" >

</display:column>
<display:column sortable="true"  title="Estimated  Unit Cost"  property="estUnintCost" >

</display:column>
<c:if test="${row.tempestCost == 0}">
<display:column sortable="true"  title="Estimated unit cost"  >

<form:input path="matList[${row_rowNum%10}].matEstUnitCost" />

</display:column>
</c:if>
</display:table>
</div>
<input type="hidden" name="_flowExecutionKey"  value="<c:out value="${flowExecutionKey}"/>" />
 <input type="hidden" name="_eventId"  id="_eventId" value="submit" >
 

  <c:if test="${fn:length(milist) > 0}" >
<div style="padding-left:10px;width:787px;float:left">
<input type="button"  value="Check All " onclick="checkAll('miindex',true)"/>
<input type="button"  value="Uncheck All " onclick="checkAll('miindex',false)"/>
 <input type="button"  value="Update Cost " onclick="eventdirect('updateCostMI')"/>
  
 </div>
 </c:if>
 
</form:form>


</div>
</div>

<script language="javascript">

function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.matindbean.submit();
}
function checkAll(chkbox,status) {

var chklist = document.getElementsByName(chkbox)
for(i =0;i<chklist.length;i++) {
	chklist[i].checked = status;
}


}
</script>
