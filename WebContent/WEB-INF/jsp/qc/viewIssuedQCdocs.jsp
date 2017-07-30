<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Search  QC Results </font></p>
<p style="padding-left:20px" align="center"></p>
<div width="787px"  style="float:left;">
<form:form commandName="qcbean" name="qcbean" enctype="multipart/form-data">
<div width="787px"  style="float:left;">
<table  cellspacing="5" cellpadding="5" border="0" >
<tr>

 


<tr>
 <td>Work Order</td>
<td><form:select path="seqWorkId"    >
<form:option value="">All</form:option>
<form:options items="${workmastlist}" itemLabel="jobDesc" itemValue="seqWorkId"/>
</form:select>

</td>
 

</tr>
<tr>
 <td colspan="4" align="right"><input type="button" value="Search QC" onclick="eventdirect('searchQC')"/></td>

</tr>
</table>

</div>


<div style="float:left;width:750px;padding:10px;margin-top:50px">

<display:table export="true" sort="list"   pagesize="10" name="qcallupdateditems"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >

<display:column sortable="true"  title="Select" media="html" >

<form:radiobutton  path="seqQCId"  value="${row.seqQcMiId}"  onclick="eventdirect('selectQC')"/>

</display:column>
<display:column sortable="true"  title="Issue MI ID" property="issueMI" >



</display:column>
<display:column sortable="true"   title="Request MI ID" property="requestMI"  >
</display:column>

<display:column sortable="true"  title="MI Part Description" property="miFortype" >



</display:column>

<display:column sortable="true"  title="Issued Count" property="issueCnt" >



</display:column>
<display:column sortable="true"   title="Material Code" property="materialCode"  >
</display:column>
<display:column sortable="true"   title="Material Category" property="matCategory"  >
</display:column>
<display:column sortable="true"   title="Material Spec" property="materSpec"  >
</display:column>
<display:column sortable="true"   title="MI Recommendation" property="mirecommend"  >
</display:column>
<display:column sortable="true"   title="QC Tests  Cond" property="qcTestsCond"  >
</display:column>
<c:set var="nestedName" value="${row.qcdocs}" />

<c:set var="nestedmis" value="${row.rawmis}" />

<c:set var="nestedmyName" value="${row.mydocs}" />
<c:set var="nestedpoms" value="${row.pomasters}" />

<display:column title="Subcont Vendor">
<c:forEach items="${nestedpoms }" var="row1" varStatus="table">
<c:out value="${row1.subContVendor}" />
</c:forEach>
</display:column>
<display:column title="Qc Docs">
<c:forEach items="${nestedName }" var="row1" varStatus="table">
<c:out value="${row1.originalFile}" />/
</c:forEach>
</display:column>
<display:column title="Qc Docs links" media="html">
<c:forEach items="${nestedName }" var="row1" varStatus="table">
<a href="javascript:openfile('<c:out value="${row1.seqQcDocId}"/>')"><c:out value="${row1.originalFile}" /></a>
</c:forEach>
</display:column>
<display:column title="Raw MI">
<c:forEach items="${nestedmis }" var="row1" varStatus="table">
<c:out value="${row1.seqOrigMIID}" />/
</c:forEach>
</display:column>

<display:column title="Raw Qc Docs">
<c:forEach items="${nestedmyName }" var="row1" varStatus="table">
<c:out value="${row1.originalFile}" />/
</c:forEach>
</display:column>
<display:column title="Raw Qc Docs links" media="html">
<c:forEach items="${nestedmyName }" var="row1" varStatus="table">
<a href="javascript:openfile('<c:out value="${row1.seqQcDocId}"/>')"><c:out value="${row1.originalFile}" /></a>
</c:forEach>
</display:column>
</display:table>
</div>
<input type="hidden" name="_flowExecutionKey"  value="<c:out value="${flowExecutionKey}"/>" />
 <input type="hidden" name="_eventId"  id="_eventId" value="searchItem" >
 
  <c:if test="${fn:length(qcunappitemslist) > 0 }" >
<div style="padding-left:10px;width:787px;float:left">


 </div>
 </c:if>
 
 
</form:form>
</div>

<div style="float:left;width:750px;padding:10px;margin-top:50px">
<p>QC Test Docs </p>
<display:table export="true" sort="list"   pagesize="10" name="qcdocs"  id="row1"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >

<display:column sortable="true"  title="QC ID"   >
<c:out value="${row1.seqQcId}" />
</display:column>
<display:column sortable="true"  title="Uploaded File"   >
<a href="javascript:openfile('<c:out value="${row1.seqQcDocId}"/>')"><c:out value="${row1.originalFile}" /></a>
</display:column>
<display:column sortable="true"  title="Date uploaded"   >
<c:out value="${row1.updatedDt}" />
</display:column>
<display:column sortable="true"  title="Uploaded By"   >
<c:out value="${row1.updatedBy}" />
</display:column>

</display:table>

</div>
</div>
<form name="myloginform" action="streamer.QualityDocOpener" method="post">
<input type="hidden" name="key" id="key" value="workjdr"/>
<input type="hidden" name="idkey" id="idkey" value=""/>
</form>
<script language="javascript">

function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.qcbean.submit();
}



</script>


<script language="javascript">

function openfile(idkeyval) {
document.myloginform.idkey.value=idkeyval;
document.myloginform.submit();
}
</script>
