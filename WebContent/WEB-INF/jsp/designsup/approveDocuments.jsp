<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Approve  Design Documents </font></p>
<p style="padding-left:20px" align="center"> Work Order : <c:out value="${workorderbean.jobDesc}" /></p>
<p style="padding-left:20px" align="center"> Client Details : <c:out value="${workorderbean.clientDetails}" /></p>
<div width="787px"  style="float:left;">
<form:form commandName="drawingbean" name="drawingbean"  enctype="multipart/form-data" >



 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId"  id="_eventId"  value="approve"> 
   

</div>
</div>


<div style="float:left;width:750px;padding:10px;margin-top:50px">
<display:table export="true" sort="list"   pagesize="10" name="workdes"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >
<display:column sortable="true"   title="Select" media="html"  >
<form:checkbox path="detailID" value="${row.seqDrwDtlid}"/>
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
<display:column sortable="true"  title="Upload File"   >
<a href="javascript:openfile('<c:out value="${row.seqDrwDtlid}"/>')"><c:out value="${row.originalDoc}" /></a>
</display:column>
<display:column sortable="true"  title="Date uploaded"   >
<c:out value="${row.updatedDate}" />
</display:column>


</display:table>
<c:if test="${fn:length(workdes) > 0 }" >
<p>
Rejected Comments :- <form:input path="rejectComments"/>
</p>
<p>
<input type="button" value="Approve Design " onclick="eventdirect('approve')" />
<input type="button" value="Reject Design "  onclick="eventdirect('reject')"/>
</p>
</c:if>
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
function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.drawingbean.submit();
}

function openfile(idkeyval) {
document.myloginform.idkey.value=idkeyval;
document.myloginform.submit();
}
</script>
