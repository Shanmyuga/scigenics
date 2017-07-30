<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <div width="787px"  style="float:left;height: 150px;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Add  Item value</font></p>



<div width="787px"  style="float:left;height: 87px;">
<form:form commandName="lookupvalbean" >

<table border="0" width="100%" cellpadding="10x" height="70px">
<tr>
<td align="right" class="datatext">Item Type</td>
<td ><form:input path="lovType" maxlength="50" size="50"/></td></tr>
<tr>
<td align="right" class="datatext">Item Description</td>
<td><form:input path="lovDescription" maxlength="50" size="50"/></td>
</tr>

<tr >
<td align="right" >&nbsp;</td>
<td><input type="submit" value="Add Item Type" /></td>
</tr>
<form:errors >
<c:forEach items="${messages}" var="message">
		<tr><td colspan="2"><c:out value="${message}"></c:out></td></tr>
	</c:forEach>

</form:errors>
</table>

 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId" value='addlookup' id="_eventId" > 
   
</form:form>

</div>

</div>
<div width="787px" style="float:left;height: 150px">


</div>