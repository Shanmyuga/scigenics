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
<td>Mechanical</td>
<td><form:radiobutton path="dept" value="MECH"  />

</td>
 <td>Electronics</td>
<td><form:radiobutton path="dept" value="E&I"  />

</td>

 
</tr>
<tr>


 <td colspan="2" align="right"><input type="button" value="Search QC" onclick="eventdirect('searchQC')"/></td>

</tr>
</table>
</div>


<div style="float:left;width:750px;padding:10px;margin-top:50px:overflow:auto">

<display:table export="true" sort="list"   pagesize="10" name="qcunappitemslist"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >

<display:column sortable="true"  title="Select" media="html" >

<form:radiobutton  path="seqQCId"  value="${row.seqQcMiId}"  onclick="eventdirect('selectQC')"/>

</display:column>

<display:column sortable="true"   title="MatCode" property="matCode"  >
</display:column>
<display:column sortable="true"  title="MI ID"  >
<c:out value="${row.sciMiMaster.seqMiId}"/>
</display:column>
<display:column sortable="true"   title="MI Remarks"  >
<c:out value='${row.sciMiMaster.recommend}'/>
</display:column>
<display:column sortable="true"   title="QC QTY" property="qcAppCnt"  >
</display:column>

<display:column sortable="true"   title="QC Dimen" property="qcAppDime"  >
</display:column>
<display:column sortable="true"  title="Recd Qty"  property="qcRecCnt">

</display:column>
<display:column sortable="true"  title="Recd Dimen" property="qcRecDime" >

</display:column>
<display:column sortable="true"   title="Tests Conducted" property="qcTestsCond"  >
</display:column>


<display:column sortable="true"   title="Failed Dimen" property="qcFailedDim"  >
</display:column>
<display:column sortable="true"   title="Failed Qnty" property="qcFailedCnt"  >
</display:column>
<display:column sortable="true"  title="Recd Date"  property="updatedDt">

</display:column>
<display:column sortable="true"  title="WO DESC"  >
<c:out value='${row.sciMiMaster.sciWorkorderMaster.jobDesc}'/>
</display:column>
<display:column sortable="true"  title="Client Details"  >
<c:out value='${row.sciMiMaster.sciWorkorderMaster.sciCustomerMaster.customerName}'/>
</display:column>

</display:table>
</div>
<input type="hidden" name="_flowExecutionKey"  value="<c:out value="${flowExecutionKey}"/>" />
 <input type="hidden" name="_eventId"  id="_eventId" value="searchItem" >
 
  <c:if test="${fn:length(qcunappitemslist) > 0 }" >
<div style="padding-left:10px;width:787px;float:left">
<table >

</table>
<table >

<tr>
<td>Approve </td> <td><form:radiobutton path="approval" value="Y"/></td>
</tr>
<tr>
<td>Reject </td> <td><form:radiobutton path="approval" value="N"/></td>
</tr>
<tr>
<td>Update QC Results </td> <td><form:input path="qcTestsCond" /></td>
</tr>
<tr>
<td>Update Fail Reason </td> <td><form:input path="qcFailReason" /></td>
</tr>
</table>
 <input type="button"  value="Approve QC Results" onclick="eventdirect('approveQC')"/>
 </div>
 </c:if>
 
 
</form:form>
</div>

<div style="float:left;width:750px;padding:10px;margin-top:50px">
<p>QC Test Docs </p>
<display:table export="true" sort="list"   pagesize="10" name="qcdocs"  id="row1"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >


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
