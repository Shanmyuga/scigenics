<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div width="787px"  style="float:left;height: 150px">
<br>

<% System.out.println("shanmuga"); %>

</div>
<div width="787px"  style="float:left;height:87px;padding-left:200px">
<form:form commandName="loginbean" >

<table border="0" width="100%" cellpadding="10x" height="70px" >

<td align="right" class="datatext">My Roles </td>
<td><form:select path="seqRoleID" id="seqid" >

<form:options items="${myrolelist}" itemValue="seqRoleId" itemLabel="roleName"/>
</form:select></td>
</tr>
<tr >
<td align="right" >&nbsp;</td>
<td><input type="submit" value="submit" /></td>
</tr>

</table>

 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId" value='submit' id="_eventId" > 
   
</form:form>
</div>
<div width="787px" style="float:left;height: 150px">



</div>