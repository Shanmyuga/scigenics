<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <div width="787px"  style="float:left;height: 150px;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Add  Lookup value</font></p>
<form:form commandName="lookupvalbean" >


<div width="787px"  style="float:left;height: 87px;">


<table border="0" width="100%" cellpadding="10x" height="70px">
<tr>
<td align="right" class="datatext">Lookup Type</td>
<td><form:select path="seqRoleID" id="seqid" >

<form:options items="${myrolelist}" itemValue="seqRoleId" itemLabel="roleName"/>
</form:select></td></tr>

<tr >
<td align="right" >&nbsp;</td>
<td><input type="submit" value="Load Lookup" /></td>
</tr>
<form:errors >
<c:forEach items="${messages}" var="message">
		<tr><td colspan="2"><c:out value="${message}"></c:out></td></tr>
	</c:forEach>

</form:errors>
</table>

 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId" value='loadlookup' id="_eventId" > 
   
</div>
</form:form>


</div>
<div width="787px" style="float:left;height: 150px">


</div>