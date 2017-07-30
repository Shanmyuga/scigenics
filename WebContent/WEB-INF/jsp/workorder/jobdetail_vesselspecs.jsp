<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Add  Vessel Specs </font></p>
<p style="padding-left:20px" align="center"> Work Order : <c:out value="${workorderbean.jobDesc}" /></p>
<p style="padding-left:20px" align="center"> Client Details : <c:out value="${workorderbean.clientDetails}" /></p>
<div width="787px"  style="float:left;">
<form:form commandName="workdetbasic" name="workdetbasic"  >

<table border="0" width="100%" cellpadding="10x" height="70px">

<tr>
<td align="right" class="datatext">Shell/End Closure Finish Inside</td>
<td ><form:select path="finiInsiShell">
<form:option value="180 Grit">180 Grit</form:option>
<form:option value="240 Grit">240 Grit</form:option>
<form:option value="EP">EP</form:option>

</form:select>
<span style="color:red;">*</span></td>

</tr>
<tr>
<td align="right" class="datatext">Finish Ports Process Side</td>
<td ><form:select path="finiInsiPorts">
<form:option value="180 Grit">180 Grit</form:option>
<form:option value="240 Grit">240 Grit</form:option>
<form:option value="EP">EP</form:option>

</form:select>
<span style="color:red;">*</span></td>

</tr>
<tr>
<td align="right" class="datatext">Finish Shaft and Impeller (Process side)</td>
<td ><form:select path="finiInsiShaft">
<form:option value="180 Grit">180 Grit</form:option>
<form:option value="240 Grit">240 Grit</form:option>
<form:option value="EP">EP</form:option>

</form:select>
<span style="color:red;">*</span></td>

</tr>
<tr>
<td align="right" class="datatext">Shell/End Closure Finish External</td>
<td ><form:select path="finiExtShell">
<form:option value="180 Grit">180 Grit</form:option>
<form:option value="240 Grit">240 Grit</form:option>
<form:option value="EP">EP</form:option>

</form:select>
<span style="color:red;">*</span></td>

</tr>
<tr>
<td align="right" class="datatext">Jacket Finish External</td>
<td ><form:select path="finiExtJacket">
<form:option value="180 Grit">180 Grit</form:option>
<form:option value="240 Grit">240 Grit</form:option>
<form:option value="EP">EP</form:option>

</form:select>
<span style="color:red;">*</span></td>

</tr>
<tr>
<td align="right" class="datatext">Ports Finish External</td>
<td ><form:select path="finiExtPorts">
<form:option value="180 Grit">180 Grit</form:option>
<form:option value="240 Grit">240 Grit</form:option>
<form:option value="EP">EP</form:option>

</form:select>
<span style="color:red;">*</span></td>

</tr>
<tr>
<td align="right" class="datatext">Shaft and Impeller Finish External</td>
<td ><form:select path="finiExtShaft">
<form:option value="180 Grit">180 Grit</form:option>
<form:option value="240 Grit">240 Grit</form:option>
<form:option value="EP">EP</form:option>

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
