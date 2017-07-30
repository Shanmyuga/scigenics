<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Recd Store  Items </font></p>
<p style="padding-left:20px" align="center"></p>
<div width="787px"  style="float:left;">
<form:form commandName="pocommand" name="pocommand">
<div width="787px"  style="float:left;">
<table width="600px" cellspacing="5" cellpadding="5" align="left" border="0" >

<tr>

 

<td> Material Dept</td>
<td>
<form:select path="matDept" size="1" id="matDept" onchange="eventdirect('loadCategory')">
<form:option value="">All</form:option>
<form:options items="${matdeptlist}" />
</form:select>
</td>

<td>Material Category</td>
<td  ><form:select path="matCategory" size="1" id="matCategory">
<form:option value="">All</form:option>
<form:options items="${matcatitems}" itemValue="matcatCode" itemLabel="matcatType"/>
</form:select>
</td>
</tr>
 <tr>

 

<td>Rejected From date</td>
<td><form:input path="fromdate"  id="fromdate"/>
<a href="javascript:show_calendar('document.pocommand.fromdate', document.pocommand.fromdate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
</td>

<td>Rejected to date</td>
<td><form:input path="todate" id="todate" />
<a href="javascript:show_calendar('document.pocommand.todate', document.pocommand.todate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
</td>
</tr>
<tr>


<td>Reject Status  </td><td><form:select path="filterStatus">
<form:options items="${rejectStatus}" itemValue="lovDescription" itemLabel="lovDescription"/>

</form:select>
</td>
 <td colspan="2" align="right"><input type="button" value="Search Recd Items" onclick="eventdirect('searchRejected')"/></td>

</tr>
</table>

</div>


<div style="float:left;width:750px;padding:10px;margin-top:50px">

<display:table export="true" sort="list"   pagesize="10" name="rejectedList"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >

<display:column sortable="true"   title="Select" media="html"   >
<form:radiobutton path="seqRejectid" value="${row.seqRejdId}"  />
</display:column>
<display:column sortable="true"  title="MI ID"  >
<c:out value="${row.sciMiMaster.seqMiId}"/>
</display:column>

<display:column sortable="true"   title="Mat Code"   >
<c:out value="${row.sciMiMaster.matcode}"/>
</display:column>
<display:column sortable="true"   title="Mat Type"  >
<c:out value="${row.sciMiMaster.matType}"/>
</display:column>
<display:column sortable="true"   title="Mat Spec"   >
<c:out value="${row.sciMiMaster.matSpec}"/>
</display:column>
<display:column sortable="true"  title="Rejected Dimension" property="rejdDimension" >

</display:column>


<display:column sortable="true"  title="Rejected Quantity" property="rejdQuantity" >

</display:column>


<display:column sortable="true"  title="Rejected Date" property="rejdDate" >

</display:column>
<display:column sortable="true"  title="Rejected By" property="insertedBy" >

</display:column>
<display:column sortable="true"  title="QC Remarks" property="remarks" >

</display:column>
<display:column sortable="true"  title="Puchase Order ID" property="poId" >

</display:column>
<display:column sortable="true"  title="MI WO DESC"  >
<c:out value='${row.sciMiMaster.sciWorkorderMaster.jobDesc}'/>
</display:column>
<display:column sortable="true"  title="MI Client Details"  >
<c:out value='${row.sciMiMaster.sciWorkorderMaster.sciCustomerMaster.customerName}'/>
</display:column>
</display:table>


</div>
  <c:if test="${fn:length(rejectedList) > 0 }" >
<div style="padding-left:10px;width:787px;float:left">
<table >

<tr>
<td>Update Remarks  </td><td><form:input path="rejectremarks"/></td>

<td>Material Status  </td><td><form:select path="rejectStatus">
<form:options items="${rejectStatus}" itemValue="lovDescription" itemLabel="lovDescription"/>

</form:select>
</td>

</tr>

</table>

 <input type="button"  value="Add PO Updates" onclick="eventdirect('addPOUpdate')"/>
 </div>
 </c:if>
<input type="hidden" name="_flowExecutionKey"  value="<c:out value="${flowExecutionKey}"/>" />
 <input type="hidden" name="_eventId"  id="_eventId" value="seachPO" >
 

 
 
</form:form>


</div>
</div>

<script language="javascript">

function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.pocommand.submit();
}
</script>
