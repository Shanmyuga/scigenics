<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <div width="787px"  style="float:left;height: 150px;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Add  New Vendor 
Data</font></p>



<div width="787px"  style="float:left;height: 87px;">
<form:form commandName="lookupvalbean" >

<table border="0" width="100%" cellpadding="10x" height="70px">
<tr>
<td align="right" class="datatext">Vendor Name</td>
<td ><form:input path="vendorName" maxlength="100" size="50"/></td></tr>
<tr>
<td align="right" class="datatext">Vendor Address</td>
<td><form:textarea path="vendorAddress"/></td>
</tr>
<tr>
<td align="right" class="datatext">Vendor Address 1</td>
<td><form:textarea path="vendorAddress1"/></td>
</tr>
<tr>
<td align="right" class="datatext">Vendor City</td>
<td><form:input path="vendorCity" maxlength="100" size="50"/></td>
</tr>
<tr>
<td align="right" class="datatext">Vendor Phone</td>
<td><form:input path="phoneNumber" maxlength="50" size="50"/></td>
</tr>
<tr>
<td align="right" class="datatext">Vendor Email</td>
<td><form:input path="emailId" maxlength="50" size="50"/></td>
</tr>
<tr>
<td align="right" class="datatext">Vendor Contact</td>
<td><form:input path="vendorContact" maxlength="100" size="50"/></td>
</tr>
<tr >
<td align="right" >&nbsp;</td>
<td><input type="submit" value="Add New Vendor" /></td>
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