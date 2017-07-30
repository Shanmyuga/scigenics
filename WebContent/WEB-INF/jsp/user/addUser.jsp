<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <div width="787px"  style="float:left;height: 150px;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Add New User </font></p>


</div>
<div width="787px"  style="float:left;">
<form:form commandName="userbean" name="userbean">

<table border="0" width="100%" cellpadding="10x" height="70px">
<tr>
<td align="right" class="datatext">First Name</td>
<td ><form:input path="userFirstname" maxlength="40" size="40"/></td></tr>

<tr>
<td align="right" class="datatext">Last Name</td>
<td ><form:input path="userLastname" maxlength="40" size="40"/></td></tr>
<tr>
<td align="right" class="datatext">User ID</td>
<td ><form:input path="userId" maxlength="40" size="40"/>

</td></tr>
<tr>
<tr>
<td align="left" class="datatext"><input type="button" value="Check for duplicate User ID" onclick="eventdirect('checkUser')"/> </td>
<td >
<p><c:out value="${userexist}"/></td></tr>
<tr>
<td align="right" class="datatext">password</td>
<td ><form:password path="password" maxlength="40" size="40"/></td></tr>
<tr>
<td align="right" class="datatext">Select Roles</td>
<td ><form:select path="roleID" multiple="true" >

<form:options items="${roleitems}" itemValue="seqRoleId" itemLabel="roleName"/>
</form:select> </td></tr>
<tr>
<td align="right" >&nbsp;</td>
<td><input type="submit" value="Add New User" /></td>
</tr>
<form:errors >
<c:forEach items="${messages}" var="message">
		<tr><td colspan="2"><c:out value="${message}"></c:out></td></tr>
	</c:forEach>

</form:errors>
</table>

 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId" value='addUser' id="_eventId" > 
   
</form:form>
</div>
<div width="787px" style="float:left;height: 150px">



</div>
      <script language="javascript">

function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.userbean.submit();
}
</script>  