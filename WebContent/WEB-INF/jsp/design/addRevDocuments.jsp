<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Add  Design Documents </font></p>
<p style="padding-left:20px" align="center"> Work Order : <c:out value="${workorderbean.jobDesc}" /></p>
<p style="padding-left:20px" align="center"> Client Details : <c:out value="${workorderbean.clientDetails}" /></p>
<div width="787px"  style="float:left;">
<form:form commandName="drawingbean" name="drawingbean"  enctype="multipart/form-data" >

<table border="0" width="100%" cellpadding="10x" height="70px">

<tr>
<td align="right" class="datatext">Document Desc</td>
<td ><c:out value="${revdrawing.sciDrawingRef.drawingDesc}"/></td>
<td align="right" class="datatext">Document Name</td>
<td ><c:out value="${revdrawing.sciDrawingRef.documentName}"/></td>

</tr>




<tr>
<td align="left" class="datatext">Drawing RefNum</td>
<td ><c:out value="${revdrawing.sciDrawingRef.drwingRefnum}" /></td>

<td align="left" class="datatext">Drawing/Design File </td>
<td ><input type="file" name="filedoc" id="filedoc"/><span style="color:red;">*</span></td>
</tr>
<tr>

<tr>



<td  colspan="4" align="right"><input type="submit" value="Add Revision " /></td>
</tr>
<form:errors >
<c:forEach items="${messages}" var="message">
		<tr><td colspan="2"><c:out value="${message}"></c:out></td></tr>
	</c:forEach>

</form:errors>
</table>

 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId"  id="_eventId"  value="addDesign"> 
   

</div>
</div>
<div width="787px" style="float:left;">

<div style="float:left;width:750px;padding:10px;margin-top:50px">

</div>
</form:form>

</div>

