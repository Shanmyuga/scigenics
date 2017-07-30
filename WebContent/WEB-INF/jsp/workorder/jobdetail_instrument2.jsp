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



<td  colspan="2" align="right">Speed Control</td>
</tr>
<tr>
<td align="right" class="datatext">Motor & Drive</td>
<td ><form:select path="motoDrive">
<form:option value="AC">AC</form:option>
<form:option value="DC">DC</form:option>

</form:select>
<span style="color:red;">*</span></td>

</tr>

<tr>
<td align="right" class="datatext">Measurement Accuracy in RPM </td>
<td ><form:input path="accuRpm"/> </td>

</tr>
<tr>
<td align="right" class="datatext">Control Accuracy in RPM </td>
<td ><form:input path="accuRpmCont"/> </td>

</tr>
<tr>
<td align="right" class="datatext">Power (HP)</td>
<td ><form:select path="powerHp">
<form:option value="0.125">0.125</form:option>
<form:option value="0.25">0.25</form:option>
<form:option value="0.5">0.5</form:option>
<form:option value="others">others</form:option>
</form:select>
<span style="color:red;">*</span></td>

</tr>
<tr>
<td align="right" class="datatext">PH Measurement and control</td>
<td ><form:select path="phMeasurement">
<form:option value="Yes">Yes</form:option>
<form:option value="No">No</form:option>

</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext">PH Sensor</td>
<td ><form:select path="phSensor">
<form:option value="Mettler Toledo">Mettler Toledo</form:option>
<form:option value="Forbes Marshall">Forbes Marshall</form:option>
<form:option value="Phoenix">Phoenix </form:option>
<form:option value="Broadley James">Broadley James</form:option>
<form:option value="pH Products">pH Products </form:option>
<form:option value="others">others</form:option>
</form:select>
<span style="color:red;">*</span></td>

</tr>
<tr>
<td align="right" class="datatext">PH Sensor Entry</td>
<td ><form:select path="phSensorEntry">
<form:option value="Top">Top</form:option>
<form:option value="Side">Side</form:option>

</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext">PH Length</td>
<td ><form:select path="phLength">
<form:option value="120mm">120mm</form:option>
<form:option value="225mm ">225mm </form:option>
<form:option value="others">others</form:option>
</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext">PH Transmitter make</td>
<td ><form:select path="phTransmitterMake">
<form:option value="Mettler Toledo">Mettler Toledo</form:option>
<form:option value="Forbes Marshall">Forbes Marshall</form:option>
<form:option value="Ion Exchange ">Ion Exchange  </form:option>

<form:option value="others">others</form:option>
</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext">Temperature Compensation</td>
<td ><form:select path="phTemperatureComp">
<form:option value="Yes">Yes</form:option>
<form:option value="No">No</form:option>

</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext">PH Measurement Accuracy  </td>
<td ><form:input path="phAccuracy"/> </td>

</tr>
<tr>
<td align="right" class="datatext">PH Control Accuracy </td>
<td ><form:input path="phAccuracyCont"/> </td>

</tr>

<tr>
<td align="right" class="datatext">Peristaltic Pump</td>
<td ><form:select path="peristaticPump">
<form:option value="Ravel">Ravel</form:option>
<form:option value="coleparmier">coleparmier</form:option>
<form:option value="Wartson marlow ">Wartson marlow </form:option>
</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext">Flow Rate </td>
<td ><form:input path="flowRate"/> </td>

</tr>
<tr>
<td align="right" class="datatext">PH Pump Type</td>
<td ><form:select path="flowRateType">
<form:option value="Fixed">Fixed</form:option>
<form:option value="Variable">Variable</form:option>
<form:option value="Programmable">Programmable</form:option>
</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext">PH Quantity </td>
<td ><form:input path="phQuantity"/> </td>

</tr>
<tr>
<td align="right" class="datatext">Mounting</td>
<td ><form:select path="mounting">
<form:option value="Independent">Independent</form:option>
<form:option value="Panel Mounted">Panel Mounted</form:option>

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

