<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Add Project Schedule </font></p>

<p style="padding-left:20px" align="center"> Work Order : <c:out value="${workorderbean.jobDesc}" /></p>
<p style="padding-left:20px" align="center"> Client Details : <c:out value="${workorderbean.clientDetails}" /></p>

<br/>
<form:form commandName="projschebean" name="projschebean">

<div width="787px" style="float:left;padding-left:10px;padding-right:600px;">
<p >Master Task Phases</p>
<display:table export="true" sort="list"   pagesize="10" name="wophases"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >
<display:column sortable="true"  title="Select"  media="html" >

<form:radiobutton path="phaseidx"  value='${row.seqWoTrkId}' onclick="loadsubtasks(this)"></form:radiobutton>

</display:column>
<display:column sortable="true"   title="Project Phase"  property="phaseDetail">

</display:column>
<display:column sortable="true"  title="Subphase Task"  property="phaseDesc">

</display:column>
<display:column sortable="true"   title="Estimated Start Date" property="estStdate" >

</display:column>

<display:column sortable="true"  title="Estimated End Date"  property="estEnddate" >

</display:column>
<display:column sortable="true"  title="Estimated Man hours"  property="estManhours" >

</display:column>
<display:column sortable="true"  title="Actual Man hours"  property="actManhours" >

</display:column>
<display:column sortable="true"  title="Actual Start date"  property="actualStdate" >

</display:column>
<display:column sortable="true"  title="Actual End date"  property="actualEnddate" >

</display:column>

<display:column sortable="true"  title="Updated By"  property="updatedBy">

</display:column>
</display:table>



</div>
<div width="787px" style="float:left;padding-left:10px;">
<p style="padding-left: 50px">Sub Task Phases</p>
<display:table export="true" sort="list"   pagesize="10" name="subphaseTasks"  id="row1"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >

<display:column sortable="true"   title="Sub Task Project Phase"  property="subPhaseName">

</display:column>
<display:column sortable="true"  title="Actuak Man hrs entry "  property="actManhours">

</display:column>
<display:column sortable="true"  title="Task completion date "  property="subActEnd">

</display:column>
<display:column sortable="true"  title="Updated Date"  property="updatedDate">

</display:column>
<display:column sortable="true"  title="Task Description"  property="taskDesc">

</display:column>
<display:column sortable="true"  title="Updated By"  property="updatedBy">

</display:column>
</display:table>



</div>

<div width="787px"  style="float:left;padding-left:10px;padding-right:600px;margin-top:50px">
<c:if test="${projschebean.phaseidx != null && completeTask != 'Y'}">

<table border="0" width="787px" cellpadding="10x" >



<tr>
<td align="left"  class="datatext">Actual Man hours for this task Today</td>
<td ><form:input path="actManHours" />
<td align="left" class="datatext">Is Task Fully Completed </td>
<td ><form:radiobutton path="isPhaseCompleted" value="Y"/> &nbsp;Completed</br>

<form:radiobutton path="isPhaseCompleted" value="N"/> &nbsp;Not Completed

</td>

</tr>



<tr>
<td align="left"  class="datatext"><span style="color:red;">*</span>Task Description (Work Done today)</td>
<td ><form:textarea path="taskDesc" />
<td align="left" ><input type="button" value="Add Hours for this Task" onclick="eventdirect('addProj')"/></td>


</tr>
<form:errors >
<c:forEach items="${messages}" var="message">
		<tr><td colspan="2"><c:out value="${message}"></c:out></td></tr>
	</c:forEach>

</form:errors>
</table>
<</c:if>
 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId" value='addUser' id="_eventId" > 
   

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