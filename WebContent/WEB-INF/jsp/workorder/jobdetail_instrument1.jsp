<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Instrumentation Details </font></p>
<p style="padding-left:20px" align="center"> Work Order : <c:out value="${workorderbean.jobDesc}" /></p>
<p style="padding-left:20px" align="center"> Client Details : <c:out value="${workorderbean.clientDetails}" /></p>
<div width="787px"  style="float:left;">
<form:form commandName="instrudetails" name="instrudetails"  >

<table border="0" width="100%" cellpadding="10x" height="70px">

<tr>
<td align="right" class="datatext">Panel with Controller</td>
<td ><form:select path="panelControl">
<form:option value="Yes">Yes</form:option>
<form:option value="No">No</form:option>

</form:select>
<span style="color:red;">*</span></td>

</tr>
<tr>
<td align="right" class="datatext">Controller Type</td>
<td ><form:select path="contollerType">
<form:option value="PLC">PLC</form:option>
<form:option value="PID">PID</form:option>

</form:select>
<span style="color:red;">*</span></td>

</tr>
<tr>
<td align="right" class="datatext">Controller Brand</td>
<td ><form:select path="controllerName">
<form:option value="Siemens">Siemens</form:option>
<form:option value="Allen Broadley">Allen Broadley</form:option>
<form:option value="Unitronics">Unitronics</form:option>
</form:select>
<span style="color:red;">*</span></td>

</tr>
<tr>
<td align="right" class="datatext">Control Panel</td>
<td ><form:select path="controlPanel">
<form:option value="Independant">Independant</form:option>
<form:option value="Common">Common</form:option>

</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext">Software</td>
<td ><form:select path="software">
<form:option value="Yes">Yes</form:option>
<form:option value="No">No</form:option>

</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext">Scada</td>
<td ><form:select path="scada">
<form:option value="Scigenics">Scigenics</form:option>
<form:option value="Intellution">Intellution</form:option>
<form:option value="FUNOC">FUNOC</form:option>
<form:option value="others">others</form:option>
</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext">Scada</td>
<td ><form:select path="scada">
<form:option value="Scigenics">Scigenics</form:option>
<form:option value="Intellution">Intellution</form:option>
<form:option value="FUNOC">FUNOC</form:option>
<form:option value="others">others</form:option>
</form:select>
</td>

</tr>
<tr>



<td  colspan="2" align="right">Temperature Measurement and Control</td>
</tr>
<tr>
<td align="right" class="datatext">Sensor</td>
<td ><form:select path="sensorType">
<form:option value="PT100">PT100</form:option>
<form:option value="Simplex">Simplex</form:option>
<form:option value="Duplex">Duplex</form:option>
<form:option value="others">others</form:option>
</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext">Sensor Entry</td>
<td ><form:select path="sensorEntry">
<form:option value="Side">Side</form:option>
<form:option value="Bottom">Bottom</form:option>

</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext">Transmitter</td>
<td ><form:select path="transmiType">
<form:option value="2 Wire">2 Wire</form:option>
<form:option value="Controller">Controller</form:option>

</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext">Temperature Range</td>
<td ><form:select path="tempRange">
<form:option value="5°C above cooling water to 40°C">5°C above cooling water to 40°C</form:option>
<form:option value="5°C above cooling water to 70°C">5°C above cooling water to 70°C</form:option>

</form:select>
</td>

</tr>

<tr>
<td align="right" class="datatext">Measurement Accuracy in °C </td>
<td ><form:input path="accuracyMeas"/> </td>

</tr>
<tr>
<td align="right" class="datatext">Control Accuracy in °C </td>
<td ><form:input path="accuracyCont"/> </td>

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
