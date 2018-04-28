<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

 <div width="787px"  style="float:left;padding-left:20px">
 
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face">Search Work Order</font></p>


<form:form commandName="workorderbean" name="workorderbean">

 <label for="tags">Search Work order  by Job Desc: </label>
 <form:input path="reportFilter" size="100" />

 <p><input type="button" value="Filter report" onclick="eventdirect('filterReport')"/>&nbsp;&nbsp;</p>

 <br/>
 <br/>
 <br/>

 <br/>
 <br/><br/>
 <br/>
<div width="787px"  style="float:left;">
<display:table export="true" sort="list"  pagesize="10" name="workorderlist" requestURI="springtest.htm"  id="row1"   cellpadding="5px" cellspacing="5px" htmlId="2" >

<display:column sortable="true"  title="Select" media="html" >
<form:radiobutton path="windex"  value="${row1_rowNum}" onclick="eventdirect('viewworkdocs') "/>

</display:column>
<display:column sortable="true"  property="clientDetails" >

</display:column>
<display:column sortable="true"  property="deliveryAdd" >

</display:column>
<display:column sortable="true" title="Delivery Date" property="datePerPo" >

</display:column>
<display:column sortable="true"  property="jobDesc" >

</display:column>
<display:column sortable="true"  property="poNumber" >

</display:column>
<display:column sortable="true"  property="poDate" >

</display:column>
<display:column sortable="true"  property="workCreateDt" >

</display:column>
<display:column sortable="true"  property="preparedBy" >

</display:column>
<display:column sortable="true"  property="approvedBy" >

</display:column>

</display:table>
<div style="float:left;width:787px;padding: 10px" >
<input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId"  id="_eventId" value="addMI" > 

 </div>
</div>

 <div style="float:left;width:750px;padding:10px;margin-top:50px">
 <p align="center">Approved Design Documents</p>
<display:table export="true" sort="list"   pagesize="5" name="workdes"  id="row2"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" htmlId="1">


<display:column sortable="true"   title="Document Name"  >
<c:out value="${row2.sciDrawingRef.documentName}" />
</display:column>
<display:column sortable="true"  title="Document Desc" >
<c:out value="${row2.sciDrawingRef.drawingDesc}" />
</display:column>
<display:column sortable="true"  title="Document Ref Num"  >
<c:out value="${row2.sciDrawingRef.drwingRefnum}" />
</display:column>
<display:column sortable="true"  title="Revision"  >
<c:out value="${row2.documentVersion}" />
</display:column>
<display:column sortable="true"  title="Approval"   >
<c:out value="${row2.drawingStatus}" />
</display:column>
<display:column sortable="true"  title="Upload File"   >
<a href="javascript:openfile('<c:out value="${row2.seqDrwDtlid}"/>')"><c:out value="${row2.originalDoc}" /></a>
</display:column>
<display:column sortable="true"  title="Date uploaded"   >
<c:out value="${row2.updatedDate}" />
</display:column>


</display:table>

</div>
 <div style="float:left;width:750px;padding:10px;margin-top:50px">
 <p align="center">Design Plan Sheet</p>
<display:table export="true" sort="list"   pagesize="5" name="penddesg"  id="row4"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" htmlId="6">


<display:column sortable="true"   title="Document Number"  >
<c:out value="${row4.docmaster.docNum}" />
</display:column>
<display:column sortable="true"  title="Document Desc"  >
<c:out value="${row4.docmaster.docuDesc}" />
</display:column>
<display:column sortable="true"  title="Planned Completion Date" property="estCompletionDt"  >

</display:column>


</display:table>

</div>

<div style="float:left;width:750px;padding:10px;margin-top:50px">
<p align="center"> Work Order Documents </p>
<display:table export="true" sort="list"   pagesize="5" name="workjdrdocs"  id="row3"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" htmlId="3" >

<display:column sortable="true"   title="Document Name" property="enqDocName" >

</display:column>
<display:column sortable="true"  title="Document Desc" property="enqDocDesc" >

</display:column>
<display:column sortable="true"  title="Document Version" property="docVersion"  >

</display:column>

<display:column sortable="true"  title="Uploaded File"   >
<a href="javascript:openfile1('<c:out value="${row3.seqJdrId}"/>')"><c:out value="${row3.originalDoc}" /></a>
</display:column>
<display:column sortable="true"  title="Date uploaded"   >
<c:out value="${row3.updatedDate}" />
</display:column>


</display:table>

</div>
</form:form>
</div>
<form name="myloginform" action="streamer.servlet" method="post">
<input type="hidden" name="key" id="key" value="workdes"/>
<input type="hidden" name="idkey" id="idkey" value=""/>
</form>
<form name="myloginform1" action="streamer.jdrservlet" method="post">
<input type="hidden" name="key" id="key" value="workjdr"/>
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
function openfile1(idkeyval) {
document.myloginform1.idkey.value=idkeyval;
document.myloginform1.submit();
}
</script>

<script>
    $( function() {
        var temp = "<c:out value='${workorderlistNames}'/>";
        var availableTags =temp.split('|');
        $( "#reportFilter" ).autocomplete({
            source: availableTags
        });
    } );
</script>