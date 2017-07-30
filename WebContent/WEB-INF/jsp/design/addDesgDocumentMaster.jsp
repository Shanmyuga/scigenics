<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Add  New Material Specs Data</font></p>



<div width="787px"  style="float:left;">
<form:form commandName="drawingbean" >

<table border="0" width="100%" cellpadding="10x" >
<tr>
<td align="right" class="datatext">Design Document Number</td>
<td><form:input  path="docNum" /></td>
</tr>
<tr>
<td align="right" class="datatext">Design Document Name</td>
<td><form:input  path="docuDesc" /></td>
</tr>

<tr>
<td align="right" class="datatext">Design Document Desc</td>
<td><form:input  path="docuName" /></td>
</tr>
<tr >
<td align="right" >&nbsp;</td>
<td><input type="submit" value="Add New Document Name" /></td>
</tr>

<form:errors >
<c:forEach items="${messages}" var="message">
		<tr><td colspan="2"><c:out value="${message}"></c:out></td></tr>
	</c:forEach>

</form:errors>
</table>

 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId" value='addDoc' id="_eventId" > 
   
</form:form>

</div>

</div>
<div width="787px" style="float:left;">
<display:table export="true" sort="list"   pagesize="10" name="desgdocs"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >

<display:column sortable="true"  title="Document Number" property="docNum" >

</display:column>
<display:column sortable="true"  title="Document Name"  property="docuDesc">

</display:column>


<display:column sortable="true"   title="Document Desc"  property="docuName"  >

</display:column>
</display:table>

</div>