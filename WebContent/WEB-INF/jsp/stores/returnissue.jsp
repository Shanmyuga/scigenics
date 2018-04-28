<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<script language="javascript">

function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.storesbean.submit();
}
</script>


 <div width="787px"  style="float:left;padding-left:20px">
 <form:form commandName="storesbean" name="storesbean">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Stores Request For Return</font></p>
<table  cellspacing="5" cellpadding="5" align="left" border="0" >
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

 

<td>Issue from date</td>
<td><form:input path="fromdate"  id="fromdate"/>
<a href="javascript:show_calendar('document.storesbean.fromdate', document.storesbean.fromdate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
</td>

<td>Issue End date</td>
<td><form:input path="todate" id="todate" />
<a href="javascript:show_calendar('document.storesbean.todate', document.storesbean.todate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
</td>
</tr>

<tr>

 



<td>Work Order</td>
<td  ><form:select path="seqEnqId" size="1" id="seqEnqId">
<form:option value="0">All</form:option>
<form:options items="${workmastlist}" itemValue="seqEnqId" itemLabel="jobDesc"/>
</form:select>
</td>

<td>Set Max results</td>
<td><form:input path="searchMax" id="searchMax"  />
</td>
</tr>

<tr>
<td>Stores Return Status</td>
<td  ><form:select path="hasReturnQty" size="1" id="hasReturnQty">
<form:option value="">All</form:option>
<form:option value="Y">Has Returns</form:option>
<form:option value="N">No Returns</form:option>
</form:select>
</td>
<td>Request Raised By</td>
<td  ><form:select path="requestUserId" size="1" id="requestUserId">
<form:option value="">All</form:option>
<form:option value="Y">Request Raised by me</form:option>

</form:select>
</td>
</tr>

<tr>

 



<td>Mat Code</td>
<td><form:input path="matcode" id="matcode"  />
</td>

<td>Request MI</td>
<td><form:input path="seqmiid" id="seqmiid"  />
</td>
</tr>
<tr>
<td>Production Return Status</td>
<td  ><form:select path="returnCriteria" size="1" id="returnCriteria">

<form:option value="P">Pending - Issues with no returns</form:option>
<form:option value="R">Returned - Issues with Previous returns</form:option>
</form:select>
</td>
<td colspan="2"> <input  type="button" value="Search Stores Request" onclick="eventdirect('searchstoresreq')"/> </td>

</tr>
 

</table>


<div width="787px"  style="float:left;">
<display:table export="true" sort="list"   pagesize="10" name="openreturnreq"  id="row" requestURI="springtest.htm"  >
<display:column sortable="true"  title="Select" media="html"  >
<form:radiobutton path="seqStoreissueId" value="${row.seqStissueId}" />
</display:column>

<display:column sortable="true"  title="Stores Requst ID"  >
<c:out value="${row.strequest.seqStreqId}" />
</display:column>
<display:column sortable="true"  title="MI ID"  >
<c:out value="${row.sciMiMaster.seqMiId}"/>
</display:column>

<display:column sortable="true"  title="Mat Code" property="matcode" >

</display:column>


<display:column sortable="true"   title="Mat Spec" property="matSpec"  >
</display:column>
<display:column sortable="true"  title="Issue Qty" property="issueCnt" >

</display:column>
<display:column sortable="true"  title= "Issue Dim" property="issueDimension" >

</display:column>

<display:column sortable="true"  title="Returned Qty" property="totalReturnQty" >

</display:column>
<display:column sortable="true"  title= "Requested Qnty"  >
<c:out value="${row.strequest.reqQuantity}"/>
</display:column>
<display:column sortable="true"  title= "Requested Dimen" >
<c:out value="${row.strequest.reqDimension}"/>
</display:column>
<display:column sortable="true"  title="Issued To" property="issuedTo" >

</display:column>


<display:column sortable="true"  title="Issued Date" property="issueDate" >

</display:column>

</display:table>

  
  <br/>

<div style="float:left;width:787px;padding: 10px" >
<input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId"  id="_eventId" value="viewAvailList" > 


  
<c:if test="${fn:length(openreturnreq) > 0 }" >

<table >

<tr>
<td>Return Count</td><td><form:input path="retQuantity"/></td>
<td>Return Dimension</td><td><form:input path="retDimension"/></td>

</tr>
<tr>
<td >Return Remarks</td><td><form:input path="prodRemarks"/></td>
<td >Damaged Material</td><td><form:checkbox path="damagedStatus" value="Y"/></td>
</tr>




</table>

 <input type="button"  value="Return  Item" onclick="eventdirect('returnItem')"/>

 </c:if>

 </div>
</div>

 
</form:form>
</div>


