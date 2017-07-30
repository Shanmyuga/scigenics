<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Add  New Material Specs Data</font></p>



<div width="787px"  style="float:left;">
<form:form commandName="matindbean" name="matindbean">

<table border="0" width="100%" cellpadding="10x" >
<tr>
 <td>Job Type</td>
<td><form:select path="jobType"   onchange="eventdirect('loadjobcode')" >
<form:option value="">Select</form:option>
<form:option value="Vessel">Vessel Accessories</form:option>
<form:option value="Agitator">Agitator Accessories</form:option>

</form:select>
</td>


 <td>Job Code</td>
<td><form:select path="jobCode"    >
<form:options items="${jobtypecodes}" itemValue="seqLovId" itemLabel="lovDescription"/>

</form:select>
</td>




</tr>
<tr>
 <td>Raw Material Status</td>
<td><form:select path="status"    >
<form:option value="Material MI Approved">Material MI Approved</form:option>
<form:option value="Material MI Not raised">Material MI Not raised</form:option>
<form:option value="Material procured and available in Stores">Material procured and available in Stores</form:option>
<form:option value="Material drawn from Stores">Material drawn from Stroes</form:option>
</form:select>
</td>
<td>Current Vendor</td>
<td><form:select path="seqVendorID"    >
<form:options items="${vendordata}" itemValue="seqVendorId" itemLabel="vendorConcat"/>

</form:select>
</td>
 
</tr>

<tr>
 <td>Estimated Completion Date</td>
<td><form:input path="estimatedReturnDate" />
<a href="javascript:show_calendar('document.matindbean.estimatedReturnDate', document.matindbean.estimatedReturnDate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>


</td>

 <td>Offloading Date</td>
<td><form:input path="offLoadingDate" />
<a href="javascript:show_calendar('document.matindbean.offLoadingDate', document.matindbean.offLoadingDate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>


</td>
</tr>


<tr>
 <td >Material Code </td>
<td ><form:input path="moc" />

 <td >Quantity </td>
<td ><form:input path="quantity" />


</td>


</tr>
<tr>

<td>Operations</td>
<td><form:select path="operation"    >
<form:options items="${operationStatuscodes}" itemValue="seqLovId" itemLabel="lovDescription"/>

</form:select>
</td>
 <td>Operation Status</td>
<td><form:input path="operationStatus" />
</td>

 
</tr>

<tr >
<td align="left" colspan="2"><input type="submit" value="Add SubContract Planning for each Job and Operation" /></td>
</tr>

<form:errors >
<c:forEach items="${messages}" var="message">
		<tr><td colspan="2"><c:out value="${message}"></c:out></td></tr>
	</c:forEach>

</form:errors>
</table>

 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId" value='addJobStatus' id="_eventId" > 
   
 
</div>

</div>
<div width="787px" style="float:left;">
<p>All Recent Job Details for the work orders</p>
<display:table export="true" sort="list"   pagesize="10" name="recentJobList"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >
<display:column sortable="true"   title="Select" media="html"   >
<c:if test="${row.receivedDate == null}">
<form:radiobutton path="seqScjobIdkey" value="${row.seqScjobId}" />
</c:if>
</display:column>
<display:column sortable="true"   property="jobType" >

</display:column>
<display:column sortable="true"  title="JobCode" >
<c:out value='${lovmap[row.jobCode]}'/>
</display:column>
<display:column sortable="true"   property="status" >

</display:column>
<display:column sortable="true"   title="Vendor" >
<c:out value="${row.sciVendorMaster.vendorName}"/>
</display:column>

<display:column sortable="true" title="Est Completion Dt"  property="estimatedReturnDate" >

</display:column>
<display:column sortable="true"   property="quantity" >

</display:column>
<display:column sortable="true"   property="moc" >

</display:column>
<display:column sortable="true" title="Act Completion Dt"   property="receivedDate" >

</display:column>
<display:column sortable="true" title="Operation"   >
<c:out value='${lovmap[row.operation]}'/>
</display:column>
<display:column sortable="true"   property="operationStatus" >

</display:column>
<display:column sortable="true"   property="insertedDate" >

</display:column>
</display:table>

</div>
<div>
<input type="button" value="Update Actual Completion Date for each Operation" onclick="eventdirect('loaddetails')" /></td>
</div>


</form:form>

<script language="javascript">

function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.matindbean.submit();
}


</script>
