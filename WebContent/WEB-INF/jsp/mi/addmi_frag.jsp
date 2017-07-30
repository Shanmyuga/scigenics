
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form commandName="matindbean"  >
<div id="body1" style="float:left;width:750px;padding:10px;margin-top:50px">
<table>

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
 <td colspan="2" align="right"></td>

</tr>
</table>
<display:table class="displaytag"   export="true" sort="list"   pagesize="10" name="workmis"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >
<display:column sortable="true"  title="Select"  media="html" >
<c:if test="${row.stRequestStatus == null}">
<form:radiobutton path="miindexID"  value='${row.seqMiId}'></form:radiobutton>
</c:if>
</display:column>
<display:column sortable="true"   title="MI ID"  property="seqMiId">

</display:column>
<display:column sortable="true"   title="Material Code" property="matcode" >

</display:column>

<display:column sortable="true"  title="Material Cat"  property="matType" >

</display:column>
<display:column sortable="true"  title="Material Spec"  property="matSpec" >

</display:column>
<display:column sortable="true"  title="Qty"  property="matQty">

</display:column>
<display:column sortable="true"  title="Dimen"  property="matDimesion">

</display:column>

<display:column sortable="true"  title="Due Date"  property="matDuedate" >

</display:column>

<display:column sortable="true"  title="Remarks"  property="recommend" >

</display:column>
<display:column sortable="true"  title="PO Remarks"  property="poDetails" >

</display:column>
<display:column sortable="true"  title="PO Due Date"  property="podueDate" >

</display:column>
<display:column sortable="true"   title="Material Status"  >
<c:out value='${lovmap[row.purStatus]}'/>
</display:column>

</display:table>

</div>

</form:form>