<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

<td align="right" class="datatext">Document Name</td>
<td ><form:select path="documentid" >
<form:options items="${desgdocs}" itemLabel="docnumDesc" itemValue="seqDesDocId"/>
</form:select>
<span style="color:red;">*</span></td>
<td colspan="2">&nbsp</td>
</tr>




<tr>


<td  align="left" class="datatext">Drawing/Design File </td>
<td ><input type="file" name="filedoc" id="filedoc"/><span style="color:red;">*</span></td>
<td colspan="2">&nbsp</td>
</tr>

<tr>
<td align="right" class="datatext">Document Desc</td>
<td ><form:textarea path="drawingDesc" /><span style="color:red;">*</span></td>
<td colspan="2">&nbsp</td>
</tr>
<tr>



<td  colspan="4" align="right"><input type="submit" value="Add Documents " /></td>
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
<display:table export="true" sort="list"   pagesize="10" name="workdes"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >
<display:column sortable="true"   title="Select" media="html"  >
<form:radiobutton path="revisionid" value="${row.seqDrwDtlid}"/>
</display:column>

<display:column sortable="true"   title="Document Name"  >
<c:out value="${row.sciDrawingRef.documentName}" />
</display:column>
<display:column sortable="true"  title="Document Desc" >
<c:out value="${row.sciDrawingRef.drawingDesc}" />
</display:column>
<display:column sortable="true"  title="Document Ref Num"  >
<c:out value="${row.sciDrawingRef.drwingRefnum}" />
</display:column>
<display:column sortable="true"  title="Revision"  >
<c:out value="${row.documentVersion}" />
</display:column>
<display:column sortable="true"  title="Approval"   >
<c:out value="${row.drawingStatus}" />
</display:column>

<display:column sortable="true"  title="Reject Comments"   >
<c:out value="${row.rejectComments}" />
</display:column>
<display:column sortable="true"  title="Upload File"   >
<a href="javascript:openfile('<c:out value="${row.seqDrwDtlid}"/>')"><c:out value="${row.originalDoc}" /></a>
</display:column>
<display:column sortable="true"  title="Date uploaded"   >
<c:out value="${row.updatedDate}" />
</display:column>


</display:table>
<c:if test="${fn:length(workdes) > 0 }">
<input type="button" value="Add Revision " onclick="javascript:addRevision()" />
<input type="button" value="Delete UnApproved Revision " onclick="javascript:deleteRevision()" />
</c:if>
</div>
</form:form>
<form name="myloginform" action="streamer.servlet" method="post">
<input type="hidden" name="key" id="key" value="workdes"/>
<input type="hidden" name="idkey" id="idkey" value=""/>
</form>
</div>
<script language="javascript">
function addRevision() {
document.drawingbean._eventId.value = "addrev";
document.drawingbean.submit();
}

function deleteRevision() {
document.drawingbean._eventId.value = "deleterev";
document.drawingbean.submit();
}

function openfile(idkeyval) {
document.myloginform.idkey.value=idkeyval;
document.myloginform.submit();
}
</script>
