<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

 <div width="787px"  style="float:left;padding-left:20px">
 
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face">Search Work Order</font></p>


<form:form commandName="workorderbean" name="workorderbean">
<div width="787px"  style="float:left;">
<display:table export="true" sort="list"  pagesize="10" name="workorderlist" requestURI="springtest.htm"  id="row"  cellpadding="5px" cellspacing="5px">

<display:column sortable="true"  title="Select" media="html" >
<form:radiobutton path="windex"  value="${row_rowNum}" onclick="eventdirect('loadDesignSpecs') "/>

</display:column>
<display:column sortable="true"  property="clientDetails" >

</display:column>
<display:column sortable="true"  property="jobDesc" >

</display:column>
<display:column sortable="true"  property="workCreateDt" >

</display:column>
<display:column sortable="true"  property="wordOrderType" >

</display:column>

</display:table>
<div style="float:left;width:787px;padding: 10px" >
<input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId"  id="_eventId" value="addMI" > 
 <input type="submit" value="Add Material"/>
 </div>
</div>

 <div style="float:left;width:750px;padding:10px;margin-top:50px">
<display:table export="true" sort="list"   pagesize="10" name="workdes"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >


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

</div>
</form:form>
</div>
<form name="myloginform" action="streamer.servlet" method="post">
<input type="hidden" name="key" id="key" value="workdes"/>
<input type="hidden" name="idkey" id="idkey" value=""/>
</form>
<div width="787px" style="float:left;height:150px">



</div>


<script language="javascript">

function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.workorderbean.submit();
}

function openfile(idkeyval) {
document.myloginform.idkey.value=idkeyval;
document.myloginform.submit();
}
</script>