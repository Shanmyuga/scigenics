<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
 <div width="787px"  style="float:left;">




<div width="787px"  style="float:left;padding:20px;margin-bottom:20px">
<form:form  commandName="taskcommand">

<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face">My Tasks</font></p>

<display:table export="true" sort="list"   pagesize="10" name="taskItems"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >
  <display:column title="Select task" >
<form:radiobutton path="taskid" value="${row.seqIssueDtlId}" />
  </display:column>
<display:column sortable="true"  title="Task Subject" property="issueSubject"></display:column>
<display:column sortable="true" title="Task Details" property="issueDetails"></display:column>
<display:column sortable="true" title="Assigned From" property="assignedFrom"></display:column>
<display:column sortable="true" title="Assigned To" property="assignedTo"></display:column>
<display:column sortable="true" title="Assigned Date" property="assignedDate"></display:column>
<display:column sortable="true" title="Task Created By" >
<c:out value="${row.sciIssueMaster.issueCreatedBy}"></c:out>
</display:column>
<display:column sortable="true" title="Task Created Date" >
<c:out value="${row.sciIssueMaster.issueOpenDate}"></c:out>
</display:column>
<display:column sortable="true" title="Task Status" property="issueStatus"></display:column>

</display:table>


 <table>
 <tr>
<td  align="center"><input type='submit' value='Forward Task' onclick="submitform('forwardTask')"/></td>
<td  align="center"><input type='submit' value='Add New Task' onclick="submitform('addnewTask')"/></td>
<td  align="center"><input type='submit' value='Close Task' onclick="submitform('closeTask')"/></td>
<td colspan="3">
</td>
</tr>
</table>

 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId"  id="_eventId" > 

</div>


<div width="787px"  style="float:left;padding:20px;margin-top:30px">

<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face">Bulletin Board News </font></p>
<display:table export="true" sort="list"   pagesize="10" name="bulletinitems"  id="row1"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >
  
<display:column headerClass="true" title="Bulletin Subject"  property="bulletinSubject"></display:column>
<display:column sortable="true" title="Bulletin news" property="bulletinNews"></display:column>
<display:column sortable="true" title="Created By" property="createdBy"></display:column>
<display:column sortable="true" title="Date" property="bulletinDate"></display:column>

</display:table>

<input type='submit' value='Add New Bulletin News' onclick="submitform('addnewnews')"/>


</div>
</div>


</form:form>
<script language="javascript">
function submitform(eventid) {

 	document.getElementById('_eventId').value = eventid;
 
}

</script>