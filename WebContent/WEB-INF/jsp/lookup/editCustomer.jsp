<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 <div width="787px"  style="float:left;height: 150px;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Edit  Customer
Data</font></p>



<div width="787px"  style="float:left;height: 87px;">
<form:form commandName="lookupvalbean" >

<table border="0" width="100%" cellpadding="10x" height="70px">
<tr>
<td align="right" class="datatext">Customer Name</td>
<td ><form:input path="customerName" maxlength="100" size="50"/></td>
<td align="right" class="datatext">Customer Address</td>
<td><form:textarea path="customerAddress"/></td>
</tr>
<tr>
<td align="right" class="datatext">Customer Address 1</td>
<td><form:textarea path="customerAddress1" /></td>

<td  align="right" class="datatext">Customer City</td>
<td><form:input path="cusomterCity" maxlength="100" size="50"/></td>
</tr>
<tr>
<td class="datatext" align="right">Customer State</td>
<td>
<form:select path="customerState"  id="customerState" >

<form:options items="${states}"  itemLabel="lovDescription" itemValue="seqLovId"/>
</form:select>
</td>

<td  align="right" class="datatext">Customer Country</td>
<td><form:input path="customerCountry" maxlength="50" size="50"/></td>
</tr>
<tr>
<td align="right" class="datatext">Customer Phone</td>
<td><form:input path="customerPhone" maxlength="50" size="50"/></td>

<td align="right" class="datatext">Customer Email</td>
<td><form:input path="customerEmail" maxlength="50" size="50"/></td>
</tr>
<tr>
<td align="right" class="datatext">Customer Contact</td>
<td><form:input path="customerContact" maxlength="100" size="50"/></td>
</tr>
<tr >
<td align="right" >&nbsp;</td>
<td><input type="submit" value="Edit Customer" /></td>
</tr>
<form:errors >
<c:forEach items="${messages}" var="message">
		<tr><td colspan="2"><c:out value="${message}"></c:out></td></tr>
	</c:forEach>

</form:errors>
</table>

 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId" value='editCustomer' id="_eventId" >
   
</form:form>

</div>



 </div>
<div width="787px" style="float:left;height: 150px">


</div>