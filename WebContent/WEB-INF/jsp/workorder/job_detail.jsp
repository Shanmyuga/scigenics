<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Add  Job Details </font></p>
<p style="padding-left:20px" align="center"> Work Order : <c:out value="${workorderbean.jobDesc}" /></p>
<p style="padding-left:20px" align="center"> Client Details : <c:out value="${workorderbean.clientDetails}" /></p>
<div width="787px"  style="float:left;">
<form:form commandName="workdetbasic" name="workdetbasic"  >

<table border="0" width="100%" cellpadding="10x" height="70px">

<tr>
<td align="right" class="datatext">Type </td>
<td ><form:select path="fermWorkType" onchange="disother(this,'fermWorkTypeo')">
<form:option value="LS1">LS1</form:option>
<form:option value="LS2">LS2</form:option>
<form:option value="LA1">LA1</form:option>
<form:option value="LA2">LA2</form:option>
<form:option value="others">others</form:option>
</form:select>
<span style="color:red;">*</span></td>

</tr>
<tr>
<td align="right" class="datatext">Type </td>
<td ><form:input path="fermWorkType" disabled="true" id="fermWorkTypeo" ondblclick="enable(this,'fermWorkType')"/> </td>

</tr>


<tr>
<td align="right" class="datatext">Total Volume</td>
<td ><form:input path="totalVolume"/> </td>

</tr>
<tr>
<td align="right" class="datatext">Working Volume</td>
<td ><form:input path="workingVolume"/> </td>

</tr>
<tr>
<td align="right" class="datatext">Quantity</td>
<td ><form:input path="quantity"/> </td>

</tr>
<tr>



<td  colspan="2" align="right"><input type="submit" value="Add Job Details " /></td>
</tr>

</table>

 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId"  id="_eventId"  value="addamend"> 
   

</div>
</div>
<div width="787px" style="float:left;">

<div style="float:left;width:750px;padding:10px;margin-top:50px">

</div>


</div>
</form:form>
<script language="javascript">

function disother(selectbx,textnm) {
	if(selectbx.value=='others') {
		selectbx.disabled = true;
		document.getElementById(textnm).disabled=false;
	
	}

}

function enable(selectbx,textnm) {
	
		selectbx.disabled = true;
		document.getElementById(textnm).disabled=false;
	
	

}
</script>

