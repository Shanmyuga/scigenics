<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face">Instrumentation Details </font></p>
<p style="padding-left:20px" align="center"> Work Order : <c:out value="${workorderbean.jobDesc}" /></p>
<p style="padding-left:20px" align="center"> Client Details : <c:out value="${workorderbean.clientDetails}" /></p>
<div width="787px"  style="float:left;">
<form:form commandName="instrudetails" name="instrudetails"  >

<table border="0" width="100%" cellpadding="10x" height="70px">
<tr>



<td  colspan="2" align="right">DO Measurement</td>
</tr>
<tr>
<td align="right" class="datatext">DO Measurement</td>
<td ><form:select path="doMeasurement">
<form:option value="Yes">Yes</form:option>
<form:option value="No">No</form:option>

</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext">Range(PPM/Percentage)</td>
<td ><form:input path="doRange"/> </td>

</tr>
<tr>
<td align="right" class="datatext">Accuracy Measurement</td>
<td ><form:input path="doAccuMeasu"/> </td>

</tr>
<tr>
<td align="right" class="datatext">Control Accuracy</td>
<td ><form:input path="doAccuCont"/> </td>

</tr>
<tr>
<td align="right" class="datatext"> Sensor </td>
<td ><form:select path="doSensortype">
<form:option value="Polorographic">Polorographic</form:option>
<form:option value="Amperometric">Amperometric</form:option>

</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext"> Sensor Entry</td>
<td ><form:select path="doSensorEntry">
<form:option value="Top">Top</form:option>
<form:option value="Side">Side</form:option>

</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext"> Length</td>
<td ><form:select path="doLength">
<form:option value="120mm">120mm</form:option>
<form:option value="225mm ">225mm </form:option>

</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext"> Transmitter make</td>
<td ><form:select path="doTransmitter">
<form:option value="Mettler Toledo">Mettler Toledo</form:option>
<form:option value="Forbes Marshall">Forbes Marshall</form:option>
<form:option value="Ion Exchange ">Ion Exchange  </form:option>

<form:option value="others">others</form:option>
</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext"> Control Type</td>
<td ><form:select path="doContType">
<form:option value="Only Air">Only Air</form:option>
<form:option value="Only Speed">Only Speed</form:option>
<form:option value="Cascade">Cascade</form:option>

<form:option value="others">others</form:option>
</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext">Air Control Device</td>
<td ><form:select path="doAircontDevice">
<form:option value="Solenoid">Solenoid</form:option>
<form:option value="Mass Flow Controller">Mass Flow Controller</form:option>

<form:option value="others">others</form:option>
</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext">Membrane Kit</td>
<td ><form:select path="doMembKit">
<form:option value="Standard">Standard</form:option>


<form:option value="others">others</form:option>
</form:select>
</td>

</tr>

<tr>



<td  colspan="2" align="right">Pressure Measurement Details</td>
</tr>
<tr>
<td align="right" class="datatext">Pressure Measurement</td>
<td ><form:select path="presMeasuCont">
<form:option value="Yes">Yes</form:option>
<form:option value="No">No</form:option>

</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext">Range(bar)</td>
<td ><form:input path="pressureRange"/> </td>

</tr>
<tr>
<td align="right" class="datatext">Accuracy Measurement</td>
<td ><form:input path="doAccuMeasu"/> </td>

</tr>
<tr>
<td align="right" class="datatext">Control Accuracy</td>
<td ><form:input path="doAccuCont"/> </td>

</tr>

<tr>
<td align="right" class="datatext">Transmitter</td>
<td ><form:select path="presTrans">
<form:option value="Wika">Wika</form:option>


<form:option value="others">others</form:option>
</form:select>
</td>

</tr>

<tr>
<td align="right" class="datatext">End Fitting</td>
<td ><form:select path="presEndFitting">
<form:option value="SS Flush Diaphram">SS Flush Diaphram</form:option>


<form:option value="others">others</form:option>
</form:select>
</td>

</tr>

<tr>
<td align="right" class="datatext">Control Valve</td>
<td ><form:select path="presContValve">
<form:option value="Jordan">Jordan</form:option>
<form:option value="pneuion">pneuion </form:option>
<form:option value="samson ">samson </form:option>
<form:option value="others">others</form:option>
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

