<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div width="787px"  style="float:left;height: 150px">
<br>



</div>
<div width="787px"  style="float:left;padding:30px">
<form:form commandName="matindbean" name="matindbean" >
<display:table export="true" sort="list"    pagesize="10" name="workmis"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >


<display:column sortable="true"  title="Select" media="html" >
<form:radiobutton path="miindexID"  value='${row.seqMiId}'></form:radiobutton>

</display:column>
<display:column sortable="true"  title="MI_ID" >

<c:out value="${row.seqMiId}"/>
</display:column>
<display:column sortable="true"   title="Material Code" property="matcode" >

</display:column>
<display:column sortable="true"  title="Material Specs"  property="matSpec" >

</display:column>
<display:column sortable="true"  title="Material Cat"  property="matType" >

</display:column>



<display:column sortable="true"  title="Qty"  property="matQty">

</display:column>
<display:column sortable="true"  title="Dimen"  property="matDimesion">

</display:column>

<display:column sortable="true"  title="Remarks" property="recommend" >

</display:column>
<display:column sortable="true"  title="Due Date"  property="matDuedate" >

</display:column>
<display:column sortable="true"   title="Material Status"  >
<c:out value='${lovmap[row.purStatus]}'/>
</display:column>

</display:table>
  <div>
  
 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId"  id="_eventId"  value="updateMI">
 
 
 
 <c:if test="${fn:length(workmis) > 0}">
 <input type="submit" value="Cancel MI"/>
  <input type="button" value="Update Remarks" onclick="javascript:addRemarks('updateRemarks')"/>
 
  <p>New Remarks</p>
<form:textarea path="recommend"/>

</c:if>
</div> 
</div>
<div width="787px" style="float:left;height: 150px">



</div>
</form:form>
<script language="javascript">
function addRemarks(eventid) {
document.matindbean._eventId.value = eventid;
document.matindbean.submit();
}

function openfile(idkeyval) {
document.myloginform.idkey.value=idkeyval;
document.myloginform.submit();
}
</script>