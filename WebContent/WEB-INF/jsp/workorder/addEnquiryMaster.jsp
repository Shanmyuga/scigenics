<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Add New Enquiry </font></p>

<div width="787px"  style="float:left;">
<form:form commandName="enqbean" name="enqbean" >

<table border="1" width="100%" cellpadding="3x" >
<tr>
<td align="right" class="datatext">Client Details</td>
<td ><form:select path="seqCustomerId" >
<form:options items="${custstats}" itemLabel="customerDetails" itemValue="seqCustId"/>
</form:select>

<span style="color:red;">*</span></td></tr>
<tr>
<td align="right" class="datatext">Customer Dept</td>
<td ><form:select path="customerDept" >
<form:options items="${customerDepts}" itemLabel="lovDescription" itemValue="seqLovId"/>
</form:select>

<span style="color:red;">*</span></td>
</tr>
<tr>
<td align="right" class="datatext">Customer Contact</td>
<td ><form:textarea path="customerContact" /></td>
</tr>
<tr>
<td align="right" class="datatext">Enquiry Details</td>
<td ><form:textarea path="enqDetails" /></td>
</tr>
<tr>
<td align="right" class="datatext">Enquiry Date</td>
<td ><form:input path="enqDate" />
<a href="javascript:show_calendar('document.enqbean.enqDate', document.enqbean.enqDate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
</td>
</tr>
<tr>
<td align="right" class="datatext">Enquiry Type</td>
<td ><form:select path="enqType" >
<form:options items="${enqtypes}" itemLabel="lovDescription" itemValue="seqLovId"/>
</form:select>

<span style="color:red;">*</span></td>
</tr>
<tr>
<td align="right" class="datatext">Enquiry Category</td>
<td ><form:select path="enqCategory" >
<form:options items="${enqCategories}" itemLabel="lovDescription" itemValue="seqLovId"/>
</form:select>

<span style="color:red;">*</span></td>
</tr>
<tr>
<td align="right" class="datatext">Enquiry Source</td>
<td ><form:input path="enqSource" /></td>
</tr>

<tr>
<td align="right" class="datatext">Enquiry Attendee</td>
<td ><form:input path="enqAttendee" /><span style="color:red;">*</span></td>
</tr>






<tr>

<td align="right" >&nbsp;</td>
<td>

   
 
 <input type="button" value="Add Enquiry Master" onclick="changeDtd('addEnqData')" />
  

</td>
</tr>

</table>

   <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
   <input type="hidden" name="_eventId"  id="_eventId" value="addEnqData"> 
</form:form>
</div>
</div>
<div width="787px" style="float:left;">



</div>

<script language="javascript">

function changeDtd(event) {

document.enqbean._eventId.value=event;
document.enqbean.submit();

}
</script>