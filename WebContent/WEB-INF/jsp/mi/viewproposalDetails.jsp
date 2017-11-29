<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Search  Proposals </font></p>
<p style="padding-left:20px" align="center"></p>
<div width="787px"  style="float:left;">
<form:form commandName="proposalbean" name="proposalbean" >
<div width="787px"  style="float:left;">
<table  cellspacing="5" cellpadding="5" border="0" >
<tr>

 

<td> Proposal Names</td>
<td>
<form:select path="seqProposalId" size="1" id="seqProposalId" onchange="eventdirect('loadProp')">
 <form:option value="">Select</form:option>
<form:options items="${propsData}" itemLabel="proposalName" itemValue="seqPropId"/>
</form:select>
</td>




</tr>

 <c:if test="${propsMaster != null}">

<tr>
  <td> Proposal Name</td>
  <td><c:out value="${propsMaster.proposalName}"/> </td>

  <td> Proposal Client</td>
  <td><c:out value="${propsMaster.proposalClient}"/> </td>
 </tr>

  <tr>
   <td> Proposal Remarks</td>
   <td><c:out value="${propsMaster.proposalRemarks}"/> </td>

   <td> Proposal Created Date</td>
   <td><c:out value="${propsMaster.insertedDate}"/> </td>
  </tr>
  <tr>
   <td colspan="4"></td>
       <input type="button"  value="Edit Proposal " onclick="eventdirect('editprops')"/>

  </tr>
 </c:if>
</table>

</div>


<div style="float:left;width:750px;padding:10px;margin-top:50px">

<display:table export="true" sort="list"   pagesize="10" name="propsDetails"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >


<display:column sortable="true"  title="MI ID" property="seqMiId" >



</display:column>
<display:column sortable="true"   title="MatCode" property="matCode"  >
</display:column>

<display:column sortable="true"   title="Material Spec" property="matSpec"  >
</display:column>
<display:column sortable="true"   title="matCost" property="matCost"  >
</display:column>


</display:table>
</div>
<input type="hidden" name="_flowExecutionKey"  value="<c:out value="${flowExecutionKey}"/>" />
 <input type="hidden" name="_eventId"  id="_eventId" value="searchItem" >
 
  <c:if test="${fn:length(qcunappitemslist) > 0 }" >
<div style="padding-left:10px;width:787px;float:left">


 </div>
 </c:if>
 
 
</form:form>
</div>


</div>

<script language="javascript">

function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.proposalbean.submit();
}



</script>


<script language="javascript">

function openfile(idkeyval) {
document.myloginform.idkey.value=idkeyval;
document.myloginform.submit();
}
</script>
