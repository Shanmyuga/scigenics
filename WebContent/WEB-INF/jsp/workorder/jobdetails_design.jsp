<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Add  Design Parameters </font></p>
<p style="padding-left:20px" align="center"> Work Order : <c:out value="${workorderbean.jobDesc}" /></p>
<p style="padding-left:20px" align="center"> Client Details : <c:out value="${workorderbean.clientDetails}" /></p>
<div width="787px"  style="float:left;">
<form:form commandName="workdetbasic" name="workdetbasic"  >

<table border="0" width="100%" cellpadding="10x" height="70px">

<tr>
<td align="right" class="datatext">Shell Material </td>
<td ><form:select path="desgShell" >
<form:option value="SS 316">SS 316</form:option>
<form:option value="SS 316L">SS 316L</form:option>
<form:option value="SS 304">SS 304</form:option>

</form:select>
<span style="color:red;">*</span></td>

</tr>
<tr>
<td align="right" class="datatext">Jacket Material </td>
<td ><form:select path="desgJacket" >
<form:option value="SS 316">SS 316</form:option>
<form:option value="SS 316L">SS 316L</form:option>
<form:option value="SS 304">SS 304</form:option>

</form:select>
<span style="color:red;">*</span></td>

</tr>


<tr>
<td align="right" class="datatext">Pressure</td>
<td ><form:input path="desgPres"/> </td>

</tr>
<tr>
<td align="right" class="datatext">Temperature</td>
<td ><form:input path="desgTemp"/> </td>

</tr>
<tr>
<td align="right" class="datatext">End Closure Type - Top </td>
<td ><form:select path="desgClosurTop">
<form:option value="Torrispherical">Torrispherical</form:option>
<form:option value="Flat">Flat</form:option>


</form:select>
<span style="color:red;">*</span></td>

</tr>
<tr>
<td align="right" class="datatext">End Closure Type - Bottom </td>
<td ><form:select path="desgClosurBott">
<form:option value="Torrispherical">Torrispherical</form:option>
<form:option value="Flat">Flat</form:option>


</form:select>
<span style="color:red;">*</span></td>

</tr>
<tr>



<td  colspan="1" align="right"><input type="button" value="Back "  onclick="backpage()"/></td>
<td  colspan="1" align="right"><input type="submit" value="Add Job Details " /></td>
</tr>

</table>

 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId"  id="_eventId"  value="jobdetails"> 
   

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

