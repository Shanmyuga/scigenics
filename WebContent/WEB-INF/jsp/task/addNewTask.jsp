<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <div width="787px"  style="float:left;height: 150px;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Add  New Task</font></p>



<div width="787px"  style="float:left;height: 87px;">
<form:form commandName="taskcommand" >

<table border="0" width="100%" cellpadding="10x" height="70px">
<tr>
<td align="right" class="datatext">Task Subject</td>
<td ><form:input path="issueSubject" maxlength="50" size="50"/></td></tr>
<tr>
<td align="right" class="datatext">Task Details</td>
<td><form:textarea path="issueDetails" /></td>
</tr>
<tr>
<td align="right" class="datatext">Assigned To</td>
<td><form:select path="assignedTo" multiple="true"  >

<form:options items="${userlistitems}" itemValue="userId" itemLabel="userName"/>
</form:select> </td>
</tr>
<tr >
<td align="right" >&nbsp;</td>
<td><input type="submit" value="Add New Task" /></td>
</tr>
<form:errors >
<c:forEach items="${messages}" var="message">
		<tr><td colspan="2"><c:out value="${message}"></c:out></td></tr>
	</c:forEach>

</form:errors>
</table>

 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId" value='submit' id="_eventId" > 
   
</form:form>

</div>

</div>
<div width="787px" style="float:left;height: 150px">


</div>