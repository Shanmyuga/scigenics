<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Create Proposals </font></p>
<p style="padding-left:20px" align="center"></p>
<div width="787px"  style="float:left;">
<form:form commandName="proposalbean" name="proposalbean" >

<table border="0" width="100%" cellpadding="10x" >





<tr>
<td align="left" class="datatext">Proposal Name</td>
<td ><form:input path="proposalName" /><span style="color:red;">*</span></td>
<td align="left" class="datatext">Proposal Remarks</td>
<td ><form:input path="propRemarks" /><span style="color:red;">*</span></td>


</tr>
<tr>
    <td align="right" class="datatext">Client Details</td>
    <td ><form:select path="proposalClient" >
        <form:options items="${customerData}" itemLabel="customerName" itemValue="customerName"/>
    </form:select>

        <span style="color:red;">*</span></td>


</tr>
<tr>
<td colspan="3" align="right" >&nbsp;</td>
<td><input type="submit" value="Create New Proposal" /></td>
</tr>
<form:errors >
<c:forEach items="${messages}" var="message">
		<tr><td colspan="2"><c:out value="${message}"></c:out></td></tr>
	</c:forEach>

</form:errors>
</table>


<div style="float:left;width:787px;padding-left:10px;margin-top:50px">

<display:table export="true" sort="list"  pagesize="10" name="propMIList"  id="row"  requestURI="springtest.htm" cellpadding="5px" cellspacing="5px">

    <display:column sortable="true"   title="MI ID"  property="seqMiId">

    </display:column>
    <display:column sortable="true"   title="Material Code" property="matcode" >

    </display:column>
    <display:column sortable="true"  title="Material Specs"  property="matSpec" >

    </display:column>
    <display:column sortable="true"  title="Material Cat"  property="matType" >

    </display:column>
    <display:column sortable="true"  title="Last Itemized Unit Cost"  property="tempunitCost" >

    </display:column>

</display:table>
</div>
 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId"  id="_eventId"  value="createProp">
 
</form:form>
</div>
</div>

<script language="javascript">

function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.proposalbean.submit();
}
</script>
