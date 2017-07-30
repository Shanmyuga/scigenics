<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Search  Purchase Orders </font></p>
<p style="padding-left:20px" align="center"></p>
<div width="787px"  style="float:left;">
<form:form commandName="storesbean" name="storesbean">
<div width="787px"  style="float:left;">
<table width="600px" cellspacing="5" cellpadding="5" align="left" border="0" >
<tr>

 
<td>Purchase Order ID</td>
<td  align="left"><form:input path="seqmiid"/>
</td>
 <td colspan="2" align="right"><input type="submit" value="Search MI"/></td>
</tr>
</table>

</div>


<div style="float:left;width:750px;padding:10px;margin-top:50px">

<display:table export="true" sort="list"   pagesize="10" name="poitemslist"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >

<display:column sortable="true"   title="Select" media="html"   >
<form:radiobutton path="seqItemId" value="${row.seaPuritemId}" />
</display:column>
<display:column sortable="true"   title="Item Desc" property="itemDescription"  >
</display:column>
<display:column sortable="true"  title="Item Dimension" property="itemDimen" >

</display:column>


<display:column sortable="true"  title="Item Quantity" property="itemQty" >

</display:column>

<display:column sortable="true"  title="Estimated cost" property="itemEstimatedCost" >

</display:column>
</display:table>


</div>
<input type="hidden" name="_flowExecutionKey"  value="<c:out value="${flowExecutionKey}"/>" />
 <input type="hidden" name="_eventId"  id="_eventId" value="seachPO" >
 
 <c:if test="${fn:length(poitemslist) > 0 }" >
<div style="padding-left:10px;width:787px;float:left">
<table >

<tr>
<td>Received Dimension</td><td><form:input path="receivedDimen"/></td>
<td>Received Quantity</td><td><form:input path="receivedCnt"/></td>
<td>Remarks</td><td><form:input path="remarks"/></td>
</tr>
</table>

 <input type="button"  value="Add New Item" onclick="eventdirect('additem')"/>
 </div>
 </c:if>
 
 
</form:form>


</div>
</div>

<script language="javascript">

function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.storesbean.submit();
}
</script>
