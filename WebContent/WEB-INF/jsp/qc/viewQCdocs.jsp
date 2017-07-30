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

 

<td> Material Dept</td>
<td>
<form:select path="matDept" size="1" id="matDept" onchange="eventdirect('loadCategory')">
<form:option value="">All</form:option>
<form:options items="${matdeptlist}" />
</form:select>
</td>

<td>Material Category</td>
<td  ><form:select path="matCategory" size="1" id="matCategory">
<form:option value="">All</form:option>
<form:options items="${matcatitems}" itemValue="matcatCode" itemLabel="matcatType"/>
</form:select>
</td>
</tr>
 <tr>

 

<td>QC Updated From date</td>
<td><form:input path="fromdate"  id="fromdate"/>
<a href="javascript:show_calendar('document.qcbean.fromdate', document.qcbean.fromdate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
</td>

<td>QC Updated To date</td>
<td><form:input path="todate" id="todate" />
<a href="javascript:show_calendar('document.qcbean.todate', document.qcbean.todate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
</td>
</tr>
<tr>
 <td>Work Order</td>
<td><form:select path="seqWorkId"    >
<form:option value="">All</form:option>
<form:options items="${workmastlist}" itemLabel="jobDesc" itemValue="seqWorkId"/>
</form:select>

</td>
 
<td>MI ID</td>
<td><form:input path="seqQcMiId"  id="seqQcMiId"/>

</td>
</tr>
<tr>
<td>MatCode</td>
<td><form:input path="materialCode" id="materialCode" />
 <td colspan="2" align="right"><input type="button" value="Search QC" onclick="eventdirect('searchQC')"/></td>

</tr>
</table>

</div>


<div style="float:left;width:750px;padding:10px;margin-top:50px">

<display:table export="true" sort="list"   pagesize="10" name="qcallupdateditems"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >

<display:column sortable="true"  title="Select" media="html" >

<form:radiobutton  path="seqQCId"  value="${row.seqQcMiId}"  onclick="eventdirect('selectQC')"/>

</display:column>
<display:column sortable="true"  title="QC ID" property="seqQcMiId" >



</display:column>
<display:column sortable="true"   title="MatCode" property="matCode"  >
</display:column>
<display:column sortable="true"  title="MI ID"  >
<c:out value="${row.sciMiMaster.seqMiId}"/>
</display:column>
<display:column sortable="true"   title="MI Remarks"  >
<c:out value='${row.sciMiMaster.recommend}'/>
</display:column>
<display:column sortable="true"   title="Item Id" property="seqPurchItemID"  >
</display:column>
<display:column sortable="true"   title="QC QTY" property="qcAppCnt"  >
</display:column>
<display:column sortable="true"   title="QC Dimen" property="qcAppDime"  >
</display:column>


<display:column sortable="true"  title="QC Recd Date" property="insertedDate" >

</display:column>
<display:column sortable="true"  title="Recd Qty"  >
<c:out value="${row.stmimaster.recdMatQty}"></c:out>
</display:column>
<display:column sortable="true"  title="Recd Dimen"  >
<c:out value="${row.stmimaster.recdMatDime}"></c:out>
</display:column>
<display:column sortable="true"   title="Tests Conducted" property="qcTestsCond"  >
</display:column>


<display:column sortable="true"   title="Failed Dimen" property="qcFailedDim"  >
</display:column>
<display:column sortable="true"   title="Fail Reason" property="qcFailReason"  >
</display:column>
<display:column sortable="true"  title="QC Cleared  Date"  property="updatedDt">

</display:column>
<display:column sortable="true"  title="File Name"  >
<c:out value="${row.seqQCDoc.originalFile}" />
</display:column>
<display:column sortable="true"  title="Uploaded File"  media="html" >
<a href="javascript:openfile('<c:out value="${row.seqQCDoc.seqQcDocId}"/>')"><c:out value="${row.seqQCDoc.originalFile}" /></a>
</display:column>
<display:column sortable="true"  title="WO DESC"  >
<c:out value='${row.sciMiMaster.sciWorkorderMaster.jobDesc}'/>
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
