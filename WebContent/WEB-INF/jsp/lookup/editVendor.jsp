<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <div width="787px"  style="float:left;height: 150px;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Edit Vendor
Data</font></p>



<div width="787px"  style="float:left;height: 87px;">
<div>
<form:form commandName="lookupvalbean" >

<table border="0" width="100%" cellpadding="10x" height="70px">

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
<td><input type="submit" value="Edit Vendor" /></td>
</tr>
<form:errors >
<c:forEach items="${messages}" var="message">
		<tr><td colspan="2"><c:out value="${message}"></c:out></td></tr>
	</c:forEach>

</form:errors>
</table>

</div>

 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId" value='editVendor' id="_eventId" >


</div>
    </div>





 

</form:form>