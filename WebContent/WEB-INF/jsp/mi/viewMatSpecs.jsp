<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Select Material Specs </font></p>
<p style="padding-left:20px" align="center"></p>
<div width="787px"  style="float:left;">
<form:form commandName="matindbean" name="matindbean">





<div style="float:left;width:750px;padding:10px;margin-top:50px">

<display:table  sort="list"   pagesize="30" name="openpopup"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >

<display:column sortable="true"  title='Select'  >

<form:radiobutton  path="matCodeselected"  id="matCodeselected" value="${row.specValue}" />

</display:column>
<display:column sortable="true"   title="Material Code" property="specCode" >

</display:column>

<display:column sortable="true"   title="Material Specs" property="matSpecDesc" >

</display:column>



</display:table>

</div>

 

<div style="padding-left:10px;width:787px;float:left">

 <input type="button"  value="Select Mat Specs " onclick="eventdirect('selectspec')"/>
 </div>
 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId"  id="_eventId"  value="addMaterialMI"> 
 <form:hidden path="selectedIdx" id="selectedIdx" />
</form:form>
</div>
</div>

<script language="javascript">

function eventdirect(event) {

document.getElementById('selectedIdx').value = '<c:out value="${specrowindex}"/>'


document.getElementById('_eventId').value = event;

document.matindbean.submit();

}
</script>
