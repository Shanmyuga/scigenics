<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

 <div width="787px"  style="float:left;padding-left:20px">
 
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face">Search Work Order</font></p>


<form:form commandName="workorderbean" name="workorderbean">
<div width="787px"  style="float:left;">
<display:table export="true" sort="list"  pagesize="10" name="workorderlist" requestURI="springtest.htm"  id="row"  cellpadding="5px" cellspacing="5px">

<display:column sortable="true"  title="Select" media="html" >
<form:radiobutton path="windex"  value="${row_rowNum}" onclick="eventdirect('loadDesignSpecs') "/>

</display:column>
<display:column sortable="true"  property="clientDetails" >

</display:column>
<display:column sortable="true"  property="jobDesc" >

</display:column>
<display:column sortable="true"  property="workCreateDt" >

</display:column>
<display:column sortable="true"  property="wordOrderType" >

</display:column>

</display:table>
<div style="float:left;width:787px;padding: 10px" >
<input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId"  id="_eventId" value="reopenMI" > 
 <input type="submit" value="Reopen Workorder"/>
 </div>
</div>

 
</form:form>
</div>

<div width="787px" style="float:left;height:150px">



</div>