<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

 <div width="787px"  style="float:left;padding-left:20px">
 
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Stores Request For Approval</font></p>
<p style="padding-left:20px" align="center"> Work Order : <c:out value="${workorderbean.jobDesc}" /></p>
<p style="padding-left:20px" align="center"> Client Details : <c:out value="${workorderbean.clientDetails}" /></p>

<form:form commandName="matindbean" name="matindbean">

<table cellpadding="5px" cellspacing="10px">


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

<td colspan="2"><input type="button" value="Search Stores Request" onclick="eventdirect('searchst')"/></td>
</tr>
</table>
<div width="787px"  style="float:left;">
<display:table export="true" sort="list"  pagesize="10" name="openstreq"  id="row"  cellpadding="5px" cellspacing="5px" requestURI="springtest.htm">


<display:column sortable="true"  title="Request ID" >
<c:out value="${row.strequest.seqStreqId}"/>
</display:column>
<display:column sortable="true"  title="Request MI ID"  >
<c:out value="${row.strequest.sciMiMaster.seqMiId}"/>
</display:column>

<display:column sortable="true"  title="Mat Code" property="matcode" >

</display:column>
<display:column sortable="true"  title="Mat Type" property="matType" >

</display:column>
<display:column sortable="true"  title="Mat Spec" property="matSpec" >

</display:column>

<display:column sortable="true"  title="Requested Qty"  >
<c:out value="${row.strequest.reqQuantity}"/>
</display:column>
<display:column sortable="true"  title= "Request Dim"  >
<c:out value="${row.strequest.reqDimension}"/>
</display:column>
<display:column sortable="true"  title= "Issue Qty" property="issueCnt"  >

</display:column>
<display:column sortable="true"  title= "Issue Dimension" property="issueDimension" >

</display:column>
<display:column sortable="true"  title= "Issue MI"  >
<c:out value="${row.sciMiMaster.seqMiId}"/>
</display:column>
<display:column sortable="true"  title= "Issue MI Cost"  >
<c:out value="${row.sciMiMaster.matEstcost}"/>
</display:column>


</display:table>


</div>

 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId"  id="_eventId" value="viewmi" > 
</form:form>
</div>



<script language="javascript">

function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.matindbean.submit();
}


</script>