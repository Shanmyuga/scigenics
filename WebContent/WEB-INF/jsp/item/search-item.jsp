\


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Search  Purchase Items </font></p>
<p style="padding-left:20px" align="center"></p>
<div width="787px"  style="float:left;">
<form:form commandName="itemcommand" name="itemcommand">
<div width="787px"  style="float:left;">
<table width="600px" cellspacing="5" cellpadding="5" align="left" border="0" >
<tr>

 
<td>Item Status</td>
<td  align="left"><form:select path="itemStatus" size="1" id="matType">
<form:option value="">All</form:option>
<form:options items="${itemstats}" itemValue="seqLovId" itemLabel="lovDescription"/>
</form:select>
</td>
 <td colspan="2" align="right"><input type="submit" value="Search Items"/></td>
</tr>
</table>

</div>


<div style="float:left;width:750px;padding:10px;margin-top:50px">

<display:table export="true" sort="list"   pagesize="10" name="itemlist"  id="row"  requestURI="springtest.htm" requestURIcontext="true" cellpadding="5px" cellspacing="3px" >

<display:column sortable="true"  title="Select" media="html" >

<form:checkbox  path="itemlist"  value="${row_rowNum}"/>

</display:column>
<display:column sortable="true"   title="Item Description" property="itemDescription"  >
</display:column>

<display:column sortable="true"   title="Item Code" property="itemCode"  >
</display:column>
<display:column sortable="true"  title="Item Qty" property="itemQty" >

</display:column>
<display:column sortable="true"  title="Created Date"  property="itemOrderDate">

</display:column>
<display:column sortable="true"  title="Item Dimension"  property="itemDimen">

</display:column>
<display:column sortable="true"  title="Item Estimated Cost"  property="itemEstimatedCost" >

</display:column>

</display:table>
</div>
<input type="hidden" name="_flowExecutionKey"  value="<c:out value="${flowExecutionKey}"/>" />
 <input type="hidden" name="_eventId"  id="_eventId" value="searchItem" >
 
 <c:if test="${fn:length(itemlist) > 0 && itemcommand.itemStatus == openITEM }" >
<div style="padding-left:10px;width:787px;float:left">
 <input type="button"  value="Create Purchase Order " onclick="eventdirect('createPurchaseOrder')"/>
 <input type="button"  value="Select Items for PurchaseOrder " onclick="eventdirect('selecttempItem')"/>
 </div>
 </c:if>
 
 
 
</form:form>
</div>
<div style="float:left;width:750px;padding:10px;margin-top:50px">

<display:table export="true" sort="list"   pagesize="10" name="poItemlist"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >


<display:column  sortable="true" title="Item Description" property="itemDescription"  >
</display:column>
<display:column title="Item Qty" property="itemQty" >

</display:column>
<display:column  title="Item Code" property="itemCode"  >
</display:column>
<display:column title="Created Date"  property="itemOrderDate">

</display:column>
<display:column title="Item Dimension"  property="itemDimen">

</display:column>
<display:column title="Item Estimated Cost"  property="itemEstimatedCost" >

</display:column>

</display:table>
</div>

</div>

<script language="javascript">

function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.itemcommand.submit();
}
</script>
