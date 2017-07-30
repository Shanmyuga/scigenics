<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Search  Issued Items </font></p>
<p style="padding-left:20px" align="center"></p>
<div width="787px"  style="float:left;">
<form:form commandName="matindbean" name="matindbean">


<div style="float:left;width:750px;padding:10px;margin-top:50px">

<display:table export="true" sort="list"   pagesize="10" name="issueAcceptance"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >
<display:column sortable="true"  title="Issue  ID"  >
<form:radiobutton path="miindexID" value="${row.seqStissueId}" />
</display:column>
<display:column sortable="true"  title="Issue MI ID"  >
<c:out value="${row.strequest.sciMiMaster.seqMiId}"/>
</display:column>
<display:column sortable="true"  title="Received MI ID"  >
<c:out value="${row.sciMiMaster.seqMiId}"/>
</display:column>
<display:column sortable="true"   title="Mat Code" property="matcode"  >
</display:column>

<display:column sortable="true"   title="Mat Type" property="matType"  >
</display:column>
<display:column sortable="true"   title="Mat Spec" property="matSpec"  >
</display:column>
<display:column sortable="true"   title="Mat Cost"   >
<c:out value="${row.sciMiMaster.matEstcost}"/>
</display:column>
<display:column sortable="true"  title="Issue Dimension" property="issueDimension" >

</display:column>


<display:column sortable="true"  title="Issue Quantity" property="issueCnt" >

</display:column>

<display:column sortable="true"  title="Issue Remarks" property="issueRemarks" >

</display:column>

<display:column sortable="true"  title="Issued To" property="issuedTo" >

</display:column>
<display:column sortable="true"  title="Issued Date" property="issueDate" >

</display:column>

<display:column sortable="true"  title="Stores Requst ID"  >
<c:out value="${row.strequest.seqStreqId}" />
</display:column>
<display:column sortable="true"  title="WO DESC"  >
<c:out value='${row.strequest.sciMiMaster.sciWorkorderMaster.jobDesc}'/>
</display:column>
<display:column sortable="true"  title="Client Details"  >
<c:out value='${row.strequest.sciMiMaster.sciWorkorderMaster.sciCustomerMaster.customerName}'/>
</display:column>
</display:table>
<c:if test="${fn:length(issueAcceptance) > 0}">

</div  >
<div style="float:left;width:750px;padding:10px;margin-top:50px">
<table>
<tr>
<td>Issue Accepted</td>
<td><form:radiobutton path="issueAcceptance" value="Y"/></td>
</tr>
<tr>
<td>Issue Rejected</td>
<td><form:radiobutton path="issueAcceptance" value="R"/></td>
</tr>
<tr>
<td>Issue Accepted By</td>
<td><form:input path="acceptedBy" /></td>
</tr>
<tr>
<td>Reopen Stores Request</td>
<td><form:checkbox path="reopenRequest" value ="Y"/></td>
</tr>
<tr>
<td><br><br></td>
<td><input type="submit" value="Update Issue"/></td>
</tr>
</table>
</div>
</c:if>
<input type="hidden" name="_flowExecutionKey"  value="<c:out value="${flowExecutionKey}"/>" />
 <input type="hidden" name="_eventId"  id="_eventId" value="submit" >
 

 
 
</form:form>


</div>
</div>

<script language="javascript">

function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.storesbean.submit();
}
</script>
