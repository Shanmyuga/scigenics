<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Add  the Job Description Documents </font></p>
<p style="padding-left:20px" align="center"> Work Order : <c:out value="${workorderbean.jobDesc}" /></p>
<p style="padding-left:20px" align="center"> Client Details : <c:out value="${workorderbean.clientDetails}" /></p>
<div width="787px"  style="float:left;">
<form:form commandName="jdrbean" name="jdrbean"  enctype="multipart/form-data" >

<table border="0" width="100%" cellpadding="10x" height="70px">

<tr>

<td align="right" class="datatext">Document Name</td>
<td ><form:input path="jdrDocName"/>
<span style="color:red;">*</span></td>
<td colspan="2">&nbsp</td>
</tr>




<tr>


<td  align="left" class="datatext">Document Description file </td>
<td ><input type="file" name="filedoc" id="filedoc"/><span style="color:red;">*</span></td>
<td colspan="2">&nbsp</td>
</tr>

<tr>
<td align="right" class="datatext">Document  Description</td>
<td ><form:textarea path="jdrDesc" /><span style="color:red;">*</span></td>
<td colspan="2">&nbsp</td>
</tr>
<tr>
<td align="right" class="datatext">Document Version Number</td>
<td ><form:input path="docVersion" size="3"  maxlength="3"/><span style="color:red;">*</span></td>
<td colspan="2">&nbsp</td>
</tr>

 <tr>
  <td align="right" class="datatext">Document Type</td>
  <td ><form:select path="docType">

   <form:option value="JDR">JDR</form:option>
   <form:option value="QC">Quality Control</form:option>
   <form:option value="QA">Quality Assurance</form:option>
   <form:option value="Purchase">Purchase</form:option>
   <form:option value="Production">Production</form:option>
  </form:select></td>
  <td colspan="2">&nbsp</td>
 </tr>
<tr>



<td  colspan="4" align="right"><input type="submit" value="Add Documents " /></td>
</tr>

</table>

 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId"  id="_eventId"  value="addjdr"> 
   

</div>
</div>
<div width="787px" style="float:left;">

<div style="float:left;width:750px;padding:10px;margin-top:50px">
<display:table export="true" sort="list"   pagesize="10" name="workjdrdocs"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >

<display:column sortable="true"   title="Document Name" property="jdrDocName" >

</display:column>
<display:column sortable="true"  title="Document Desc" property="jdrDesc" >

</display:column>
<display:column sortable="true"  title="Document Version" property="docVersion"  >

</display:column>
 <display:column sortable="true"  title="Document Type" property="docType"  >

 </display:column>
<display:column sortable="true"  title="Uploaded File"   >
<a href="javascript:openfile('<c:out value="${row.seqJdrId}"/>')"><c:out value="${row.originalDoc}" /></a>
</display:column>
<display:column sortable="true"  title="Date uploaded"   >
<c:out value="${row.updatedDate}" />
</display:column>


</display:table>

</div>
</form:form>
<form name="myloginform" action="streamer.jdrservlet" method="post">
<input type="hidden" name="key" id="key" value="workjdr"/>
<input type="hidden" name="idkey" id="idkey" value=""/>
</form>
</div>
<script language="javascript">

function openfile(idkeyval) {
document.myloginform.idkey.value=idkeyval;
document.myloginform.submit();
}
</script>
