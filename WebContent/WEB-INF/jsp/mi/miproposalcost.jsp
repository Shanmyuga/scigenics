<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Search  MI (Set Max results) </font></p>
<p style="padding-left:20px" align="center"></p>
<div width="787px"  style="float:left;">
<form:form commandName="matindbean" name="matindbean">
 
<div width="787px"  style="float:left;">
<table  cellspacing="5" cellpadding="5" align="left" border="0" >


<tr>
<td> Material Dept</td>
<td>
<form:select path="matDept" size="1" id="matDept" onchange="eventdirect('loadCategory')">
<form:option value="">All</form:option>
<form:options items="${matdeptlist}" />
</form:select>
</td>
<td>Material Category</td>
<td  ><form:select path="matCategory" size="1" id="matCategory" onchange="eventdirect('loadDescription')">
<form:option value="">All</form:option>
<form:options items="${matcatitems}" itemValue="matcatCode" itemLabel="matcatType"/>
</form:select>
</td>
</tr>

<tr>
 <td colspan="2"> Material Description - </td>
 <td colspan="2">

  <form:select path="reportFilter" size="1" id="reportFilter" >
   <form:option value="">All</form:option>
   <form:options items="${matDescriptions}" itemValue="seqMaterialId" itemLabel="matSpecDesc"/>
  </form:select>


 </td>
</tr>

 <tr>
  <td colspan="2"> Material Description Filter - </td>
  <td colspan="2">



   <form:input path="matDescription" size="30" />


  </td>
  <tr>
 <td>Set Max results</td>
 <td><form:input path="searchMax" id="searchMax"  />
 </td>
 <td colspan="2">
 <input  type="button" value="Search MI  Items" onclick="eventdirect('searchMI')"/>


 </td>
 </tr>
</table>

</div>


<div style="float:left;width:750px;padding:10px;margin-top:50px">

<display:table export="true" sort="list"   pagesize="10" name="milist"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >

<display:column sortable="true"  title='Select' media="html"  >

<form:radiobutton  path="matList[${row_rowNum%10}].matindex"  value="${row_rowNum}"/>

</display:column>

<display:column sortable="true"   title="MI ID"  property="seqMiId">

</display:column>
<display:column sortable="true"   title="Material Code" property="matcode" >

</display:column>


<display:column sortable="true"  title="Material Cat"  property="matType" >

</display:column>

<display:column sortable="true"  title="Qty"  property="matQty">

</display:column>
<display:column sortable="true"  title="Dimen"  property="matDimesion">

</display:column>

 <display:column sortable="true"  title="Material Specs"  property="matSpec" >

 </display:column>




<display:column sortable="true"  title="Request Status"  property="requestStatus" >

</display:column>
<display:column sortable="true"  title="Last Itemized Unit Cost"  property="tempunitCost" >

</display:column>
<display:column sortable="true"  title="Estimated  Unit Cost"  property="estUnintCost" >

</display:column>

</display:table>

<input type="hidden" name="_flowExecutionKey"  value="<c:out value="${flowExecutionKey}"/>" />
 <input type="hidden" name="_eventId"  id="_eventId" value="submit" >


  <c:if test="${fn:length(milist) > 0}" >

 <input type="button"  value="Select MI For Proposal " onclick="eventdirect('selectPropMI')"/>



 </c:if>
</div>


</div>

</div>

 <div width="787px"  style="float:left;">

  <display:table export="true" sort="list"   pagesize="10" name="propMIList"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >



   <display:column sortable="true"   title="MI ID"  property="seqMiId">

   </display:column>
   <display:column sortable="true"   title="Material Code" property="matcode" >

   </display:column>

   <display:column sortable="true"  title="Material Cat"  property="matType" >

   </display:column>
   <display:column sortable="true"  title="Material Specs"  property="matSpec" >

   </display:column>
   <display:column sortable="true"  title="Qty"  property="matQty">

   </display:column>
   <display:column sortable="true"  title="Dimen"  property="matDimesion">

   </display:column>

   <display:column sortable="true"  title="Due Date"  property="matDuedate" >

   </display:column>

   <display:column sortable="true"  title="Created Date"  property="insertedDate" >

   </display:column>


   <display:column sortable="true"  title="Request Status"  property="requestStatus" >

   </display:column>
   <display:column sortable="true"  title="Last Itemized Unit Cost"  property="tempunitCost" >

   </display:column>
   <display:column sortable="true"  title="Estimated  Unit Cost"  property="estUnintCost" >

   </display:column>

  </display:table>

  <c:if test="${fn:length(propMIList) > 0}" >

   <input type="button"  value="Create Proposal Now " onclick="eventdirect('addprops')"/>



  </c:if>

 </div>
</form:form>




<script language="javascript">

function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.matindbean.submit();
}
function checkAll(chkbox,status) {

var chklist = document.getElementsByName(chkbox)
for(i =0;i<chklist.length;i++) {
	chklist[i].checked = status;
}


}
</script>
