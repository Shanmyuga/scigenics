<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Add Project Cost </font></p>

<p style="padding-left:20px" align="center"> Work Order : <c:out value="${workorderbean.jobDesc}" /></p>
<p style="padding-left:20px" align="center"> Client Details : <c:out value="${workorderbean.clientDetails}" /></p>

<br/>
<form:form commandName="projschebean" name="projschebean">
<div width="787px"  style="float:left;padding-left:10px;padding-right:600px;margin-top:50px">


<table border="0" width="787px" cellpadding="10x" >
<tr>
<td align="left" class="datatext">Project Cost Category</td>

<td ><form:select path="costCategory" size="1" id="matType">

<form:options items="${costcategorylist}" itemValue="lovDescription" itemLabel="lovDescription"/>
</form:select> </td>
<td align="left" class="datatext">Cost Remarks</td>

<td ><form:input path="costRemarks" />
 </td>

</tr>

<tr>
<td align="left" class="datatext">Total Cost</td>

<td ><form:input path="totalCost" />
 </td>

<td align="left" class="datatext">Approved By</td>

<td ><form:input path="approvedBy" />
 </td></tr>




<tr>
<td align="left" ><input type="button" value="Add Project Cost Details" onclick="eventdirect('addProj')"/></td>

<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<form:errors >
<c:forEach items="${messages}" var="message">
		<tr><td colspan="2"><c:out value="${message}"></c:out></td></tr>
	</c:forEach>

</form:errors>
</table>

 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId" value='addUser' id="_eventId" > 
   

</div>
<div width="787px" style="float:left;padding-left:10px;padding-right:600px;">
<p > Project Estimated Cost Details</p>
<display:table export="true" sort="list"   pagesize="10" name="costList"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >

<display:column sortable="true"   title="Cost Category"  property="costCategory">

</display:column>
<display:column sortable="true"  title="Cost Remarks"  property="costRemarks">

</display:column>
<display:column sortable="true"   title="Total Cost" property="totalCost" >

</display:column>

<display:column sortable="true"   title="Approved By" property="approvedBy" >

</display:column>
<display:column sortable="true"  title="Updated Date"  property="updatedDate">

</display:column>
<display:column sortable="true"  title="Updated By"  property="updatedBy">

</display:column>
</display:table>



</div>


<form:hidden path="woTrackId"/>
</form:form>
</div>
      <script language="javascript">

function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.projschebean.submit();
}

function loadsubtasks(radiobject) {

document.getElementById('woTrackId').value = radiobject.value;
document.getElementById('_eventId').value = 'loadsubtasks';

document.projschebean.submit();
}
</script>  