<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Add  New Material Specs Data</font></p>



<div width="787px"  style="float:left;">
<form:form commandName="drawingbean" >

<display:table export="true" sort="list"   pagesize="10" name="desgdocs"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >
<display:column  title="Select" media="html"   >
<form:checkbox  path="matList[${row_rowNum%10}].matindex"  value="${row_rowNum}"/>
</display:column>
<display:column sortable="true"  title="Document Number" property="docNum" >

</display:column>
<display:column sortable="true"  title="Document Name"  property="docuDesc">

</display:column>


<display:column sortable="true"   title="Document Desc"  property="docuName"  >

</display:column>

<display:column sortable="true"  title="Due Date"  >

<form:input path="matList[${row_rowNum%10}].matDuedatestr"  size="10"/>(dd-mm-yyyy)
</display:column>
</display:table>





 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId" value='addDesignPlan' id="_eventId" > 
   <input type ="submit" value="Add Design Plan"/>
</form:form>

</div>

</div>
<div width="787px" style="float:left;">
<display:table export="true" sort="list"   pagesize="10" name="desgplan"  id="row2"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >

<display:column sortable="true"  title="Document Number" >
<c:out value="${row2.docmaster.docNum}"></c:out>
</display:column>
<display:column sortable="true"  title="Document Name"  >
<c:out value="${row2.docmaster.docuDesc}"></c:out>
</display:column>


<display:column sortable="true"   title="Document Desc"   >
<c:out value="${row2.docmaster.docuName}"></c:out>
</display:column>

<display:column sortable="true"  title="Estimated Completion Date"   property="estCompletionDt" >


</display:column>
</display:table>

</div>