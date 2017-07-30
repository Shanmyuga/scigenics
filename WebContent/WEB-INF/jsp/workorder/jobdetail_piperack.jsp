<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Add  Pipe Rack </font></p>
<p style="padding-left:20px" align="center"> Work Order : <c:out value="${workorderbean.jobDesc}" /></p>
<p style="padding-left:20px" align="center"> Client Details : <c:out value="${workorderbean.clientDetails}" /></p>
<div width="787px"  style="float:left;">
<form:form commandName="workdesginst" name="workdesginst"  >

<table border="0" width="100%" cellpadding="10x" height="70px">

<tr>
<td align="right" class="datatext">Flow Range</td>
<td ><form:select path="flowRange" onchange="disother(this,'flowRangeo')">
<form:option value="0  - 5 lpm">0  - 5 lpm</form:option>
<form:option value="0  - 10 lpm ">0  -10 lpm </form:option>
<form:option value="0  - 20 lpm">0  - 20 lpm</form:option>
<form:option value="others">others</form:option>
</form:select>
<span style="color:red;">*</span></td>

</tr>
<tr>
<td align="right" class="datatext">Flow Range </td>
<td ><form:input path="flowRange" disabled="true" id="flowRangeo" ondblclick="enable(this,'flowRange')"/> </td>

</tr>
<tr>
<td align="right" class="datatext">Inlet Air Filter size</td>
<td ><form:input path="inletAirFilter"/> </td>

</tr>
<tr>
<td align="right" class="datatext">Inlet Air Filter Make</td>
<td ><form:select path="inlMake" >
<form:option value="Domnick Hunter">Domnick Hunter</form:option>
<form:option value="Pall">Pall</form:option>
<form:option value="Sartorius">Sartorius</form:option>
<form:option value="Mdi Advanced">Mdi Advanced</form:option>
</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext">Exhaust Air Filter size</td>
<td ><form:input path="exhAirFilter"/> </td>

</tr>
<tr>
<td align="right" class="datatext">Exhaust Condenser</td>
<td ><form:select path="exhMake" >
<form:option value="Domnick Hunter">Domnick Hunter</form:option>
<form:option value="Pall">Pall</form:option>
<form:option value="Sartorius">Sartorius</form:option>
<form:option value="Mdi Advanced">Mdi Advanced</form:option>
</form:select>
</td>

</tr>

<tr>
<td align="right" class="datatext">Flowmeter</td>
<td ><form:select path="flowmeter" onchange="disother(this,'flowmetero')">
<form:option value="Rotameter">Rotameter</form:option>
<form:option value="others">others</form:option>

</form:select>
<span style="color:red;">*</span></td>

</tr>
<tr>
<td align="right" class="datatext">Flowmeter </td>
<td ><form:input path="flowmeter" disabled="true" id="flowmetero" ondblclick="enable(this,'flowmeter')"/> </td>

</tr>
<tr>
<td align="right" class="datatext">Exhaust Condenser</td>
<td ><form:select path="exhCondensor" >
<form:option value="Glass">Glass</form:option>
<form:option value="Stainless Steel">Stainless Steel</form:option>

</form:select>
</td>

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

