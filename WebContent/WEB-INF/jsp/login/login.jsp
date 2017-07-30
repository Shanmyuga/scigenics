<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div width="787px"  style="float:left;height: 150px">
<br>

<% System.out.println("shanmuga"); %>

</div>
<div width="787px"  style="float:left;height:87px;padding-left:200px">
<form:form commandName="loginbean" >

<table border="0" width="100%" cellpadding="10x" height="70px" >
<tr>
<td align="right" class="datatext">User ID</td>
<td ><form:input path="userid" maxlength="10" size="10"/></td></tr>
<tr>
<td align="right" class="datatext">Password</td>
<td><form:password path="password" maxlength="10" size="10"/></td>
</tr>
<tr>
<td align="right" class="datatext">Role </td>
<td><form:select path="seqRoleID" id="seqid" >

<form:options items="${roleitems}" itemValue="seqRoleId" itemLabel="roleName"/>
</form:select></td>
</tr>
<tr >
<td align="right" >&nbsp;</td>
<td><input type="submit" value="login" /></td>
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
<div width="787px" style="float:left;height: 150px">



</div>