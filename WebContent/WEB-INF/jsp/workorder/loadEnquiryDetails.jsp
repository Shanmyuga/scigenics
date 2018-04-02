<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

 <div width="787px"  style="float:left;padding-left:20px">
 
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face">Search Enquiry Details</font></p>


<form:form commandName="enqbean" name="enqbean">
<div width="787px"  style="float:left;">
<table  cellspacing="5" cellpadding="5" align="left" border="0" >


<tr>
<td> Customer Name </td>
<td>
<form:select path="seqCustomerId" size="1" id="seqCustomerId" >
<form:option value="">All</form:option>
<form:options items="${custstats}" itemLabel="customerDetails" itemValue="seqCustId" />
</form:select>
</td>
<td>Enquiry Status</td>
<td  ><form:select path="enqStatus" size="1" id="enqStatus">
<form:option value="">All</form:option>
<form:option value="O">Open</form:option>
<form:option value="C">Close</form:option>
</form:select>
</td>
 <td>Enquiry ID</td>
 <td  ><form:input path="seqEnqMasterId" id="seqEnqMasterId"></form:input>
 </td>

 <td align="right" class="datatext">Enquiry Priority</td>
 <td ><form:select path="enqPriority" >
  <form:option value="">Select</form:option>
  <form:options items="${enqpriorities}" itemLabel="lovDescription" itemValue="seqLovId"/>
 </form:select>

  <span style="color:red;">*</span></td>
</tr>

<tr>

<td colspan="4"> <input  type="button" value="Search Enquiry" onclick="eventdirect('searchEnquiry')"/> </td>

</tr>
 

</table>

</div>


<div width="787px"  style="float:left;">
<display:table export="true" sort="list"  pagesize="10" name="openenqlist" requestURI="springtest.htm"  id="row1" htmlId="2"  cellpadding="5px" cellspacing="5px">

<display:column sortable="true"  title="Select" media="html" >
<form:radiobutton path="seqenqmasterid"  value="${row1.seqEnqryId}" onclick="eventdirect('loadEnqDetails') "/>

</display:column>

 <display:column sortable="true"  property="seqEnqryId" title="Enquiry ID">

 </display:column>
<display:column sortable="true"  property="enqDetails" >

</display:column>
<display:column sortable="true"  title="Customer Details" >
<c:out value='${row1.sciCustomerMaster.customerName}'/>
</display:column>
<display:column sortable="true"  title="Customer Dept" >
<c:out value='${lovmap[row1.customerDept]}'/>
</display:column>
<display:column sortable="true"  title="Customer Contact" property="customerContact" >

</display:column>
<display:column sortable="true"  title="Enquiry Category" >

<c:out value='${lovmap[row1.enqCategory]}'/>
</display:column>
<display:column sortable="true"  property="enqDate" >

</display:column>
<display:column sortable="true"  property="enqSource" >

</display:column>
<display:column sortable="true"  property="enqAttendee" >

</display:column>
<display:column sortable="true"  title="EnqType" >
<c:out value='${lovmap[row1.enqType]}'/>
</display:column>

    <display:column sortable="true"  title="EnqPriority" >
        <c:out value='${lovmap[row1.enqPriority]}'/>
    </display:column>
    <display:column sortable="true"  property="enqFollowUpDate" >

</display:column>

<display:column sortable="true"  property="enqStatus" >

</display:column>

</display:table>
<div style="float:left;width:787px;padding: 10px" >
<input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId"  id="_eventId" value="addEnq" > 
 <input type="button" value="Add New Enquiry" onclick="eventdirect('addEnq')"/>
 <input type="button" value="Close Enquiry" onclick="eventdirect('closeenq')"/>
 </div>
</div>

 <div style="float:left;width:900px">
<display:table export="true" sort="list"  pagesize="10" name="openenqdetails" requestURI="springtest.htm"  id="row2"  htmlId="3" cellpadding="5px" cellspacing="5px">


<display:column sortable="true"  property="actionTaken" >

</display:column>

<display:column sortable="true"  property="actionDate" title="Action Date">

</display:column>

<display:column sortable="true"  property="bringForwardDate"   title="Bring Forward Date" >

</display:column>
<display:column sortable="true"  property="purpose" title="Action to be Taken" >

</display:column>
<display:column sortable="true"  property="insertedDate" >

</display:column>
<display:column sortable="true"  property="insertedBy" >

</display:column>

</display:table>

</div>

</div>

<div width="787px" style="float:left;height:150px">
<p> Action Details on the Enquiry</p>
<table>
<tr>
<td align="right" class="datatext">Action Taken till date</td>
<td ><form:textarea path="actionTaken" /></td>

<td align="right" class="datatext">Action Date</td>
<td ><form:input path="actionDate" />
<a href="javascript:show_calendar('document.enqbean.actionDate', document.enqbean.actionDate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
</td>
</tr>
<tr>
<td align="right" class="datatext">Action to be taken</td>
<td ><form:textarea path="purpose" /></td>

<td align="right" class="datatext">Bring Forward Date</td>
<td ><form:input path="bringForwardDate" />
<a href="javascript:show_calendar('document.enqbean.bringForwardDate', document.enqbean.bringForwardDate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
</td>
<td align="right" class="datatext">Enquiry Type</td>
<td ><form:select path="enqmasterType" >
<form:options items="${enqtypes}" itemLabel="lovDescription" itemValue="seqLovId"/>
</form:select>

<span style="color:red;">*</span></td>
</tr>
</table>
 <input type="button" value="Add Enquiry Details" onclick="eventdirect('addEnqdet')"/>
</div>
</form:form>

<script language="javascript">

function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.enqbean.submit();
}


</script>