<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Create Purchase Item </font></p>
<p style="padding-left:20px" align="center"></p>
<div width="787px"  style="float:left;">
<form:form commandName="itemcommand" name="itemcommand" >

<table border="0" width="100%" cellpadding="10x" >



<tr>
<td align="left" class="datatext">Item Description</td>
<td ><c:out value="${itemcommand.itemDescription}" escapeXml="true"/></td>



<td align="left" class="datatext">Item Due Date</td>
<td ><form:input path="itemOrderDate" />
<a href="javascript:show_calendar('document.itemcommand.itemOrderDate', document.itemcommand.itemOrderDate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
<span style="color:red;">*</span>





</td>
</tr>

<tr>
<td align="left" class="datatext">Item Dimension</td>
<td ><form:input path="itemDimen" /><span style="color:red;">*</span></td>
<td align="left" class="datatext">Item Description</td>
<td ><form:input path="itemDescription" /><span style="color:red;">*</span></td>


</tr>
<tr>
<td align="left" class="datatext">Item Unit of Measurement</td>
<td><form:select path="itemDenom" id="itemDenom" >
<form:option value=""></form:option>
<form:options items="${denomlist}" itemValue="lovDescription" itemLabel="lovDescription"/>
</form:select></td>
<td align="left" class="datatext">List of Raw MI ID's</td>
<td ><form:input path="rawmiid"  size="40"/><span style="color:red;">(Give as Comma separated ex - MI1,MI2)</span></td>

</tr>
<tr>
<td colspan="3" align="right" >&nbsp;</td>
<td><input type="submit" value="Create New Item" /></td>
</tr>
<form:errors >
<c:forEach items="${messages}" var="message">
		<tr><td colspan="2"><c:out value="${message}"></c:out></td></tr>
	</c:forEach>

</form:errors>
</table>


<div style="float:left;width:787px;padding-left:10px;margin-top:50px">

<display:table export="true" sort="list"  pagesize="10" name="itemmilist"  id="row"  requestURI="springtest.htm" cellpadding="5px" cellspacing="5px">


<display:column sortable="true"   title="Material Code" property="matcode" >

</display:column>
<display:column sortable="true"  title="Material Specs"  property="matSpec" >

</display:column>
<display:column sortable="true"  title="Material Cat"  property="matType" >

</display:column>

<display:column sortable="true"  title="Qty"  property="matQty">

</display:column>
<display:column sortable="true"  title="Dimen"  property="matDimesion">

</display:column>

<display:column sortable="true"  title="Due Date"  property="matDuedate" >

</display:column>

<display:column sortable="true"  title="Previous Estimated  Unit Cost" property="tempunitCost" >

</display:column>
<display:column sortable="true"  title="Modified Quantity"  >
<form:input path="miquantity" />
</display:column>
<display:column sortable="true"  title="Estimated  Unit Cost"  >
<form:input path="micost" />
</display:column>

<display:column sortable="true"  title="Recommendation"  >
<form:input path="miremarks" />
</display:column>
</display:table>
</div>
 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId"  id="_eventId"  value="addItem"> 
 
</form:form>
</div>
</div>

<script language="javascript">

function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.itemcommand.submit();
}
</script>
