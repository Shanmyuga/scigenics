<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div width="787px"  style="float:left;height: 150px">
<form:form commandName="matindbean" name="matindbean" >
<table width="600px" cellspacing="5" cellpadding="5" align="left" border="0" >

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



 <td colspan="4" align="left"><input type="button" value="Search MI" onclick="eventdirect('searchMI')"/></td>

</tr>
</table>


<br/>

</div>
<div width="787px"  style="float:left;padding:30px";>

<display:table export="true" sort="list"    pagesize="10" name="milist"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >


<display:column sortable="true"  title="Select" media="html" >
<form:radiobutton path="miindexID"  value='${row.seqMiId}'></form:radiobutton>

</display:column>
<display:column sortable="true"  title="MI_ID" >

<c:out value="${row.seqMiId}"/>
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

<display:column sortable="true"  title="Remarks" property="recommend" >

</display:column>
<display:column sortable="true"  title="Due Date"  property="matDuedate" >

</display:column>
<display:column sortable="true"   title="Material Status"  >
<c:out value='${lovmap[row.purStatus]}'/>
</display:column>

</display:table>
  <div>
  
 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId"  id="_eventId"  value="updateMI">
 
 
 
 <c:if test="${fn:length(milist) > 0}">
 
  <input type="button" value="Update Old QC Id" onclick="javascript:addRemarks('updateRemarks')"/>
 
  <p>Old QC Id</p>
<form:input path="oldQCId"/>

</c:if>
</div> 
</div>

</form:form>
<script language="javascript">
function addRemarks(eventid) {
document.matindbean._eventId.value = eventid;
document.matindbean.submit();
}

function openfile(idkeyval) {
document.myloginform.idkey.value=idkeyval;
document.myloginform.submit();
}
</script>
<script language="javascript">

function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.matindbean.submit();
}
</script>