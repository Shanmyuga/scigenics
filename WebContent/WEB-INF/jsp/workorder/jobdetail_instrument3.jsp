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



<td  colspan="2" align="right">Foam Details</td>
</tr>
<tr>
<td align="right" class="datatext">Foam Control</td>
<td ><form:select path="foamControl">
<form:option value="Yes">Yes</form:option>
<form:option value="No">No</form:option>

</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext"> Sensor Entry</td>
<td ><form:select path="phSensorEntry">
<form:option value="Top">Top</form:option>
<form:option value="Side">Side</form:option>

</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext">Sensor with Cable</td>
<td ><form:select path="sensorCable">
<form:option value="Capacitance ">Capacitance </form:option>
<form:option value="conductivity">conductivity</form:option>

</form:select>
<span style="color:red;">*</span></td>

</tr>
<tr>
<td align="right" class="datatext">Peristaltic Pump</td>
<td ><form:select path="foamPeristaltic">
<form:option value="Ravel">Ravel</form:option>
<form:option value="coleparmier">coleparmier</form:option>
<form:option value="Wartson marlow ">Wartson marlow </form:option>
</form:select>
</td>

</tr>











<tr>
<td align="right" class="datatext">Flow Rate </td>
<td ><form:input path="foamPumpRate"/> </td>

</tr>
<tr>
<td align="right" class="datatext"> Pump Type</td>
<td ><form:select path="foamPumpType">
<form:option value="Fixed">Fixed</form:option>
<form:option value="Variable">Variable</form:option>
<form:option value="Programmable">Programmable</form:option>
</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext"> Quantity </td>
<td ><form:input path="foamPumpQuantity"/> </td>

</tr>
<tr>
<td align="right" class="datatext">Mounting</td>
<td ><form:select path="foamPumpMount">
<form:option value="Independent">Independent</form:option>
<form:option value="Panel Mounted">Panel Mounted</form:option>

</form:select>
</td>

</tr>

<tr>



<td  colspan="2" align="right">INNOCULUM Details</td>
</tr>
<tr>
<td align="right" class="datatext">INNOCULUM Addition</td>
<td ><form:select path="innoAdd">
<form:option value="Yes">Yes</form:option>
<form:option value="No">No</form:option>

</form:select>
</td>

</tr>

<tr>
<td align="right" class="datatext">Peristaltic Pump</td>
<td ><form:select path="innoPerist">
<form:option value="Ravel">Ravel</form:option>
<form:option value="coleparmier">coleparmier</form:option>
<form:option value="Wartson marlow ">Wartson marlow </form:option>
</form:select>
</td>

</tr>

<tr>
<td align="right" class="datatext">Flow Rate </td>
<td ><form:input path="innoFlowrate"/> </td>

</tr>
<tr>
<td align="right" class="datatext"> Pump Type</td>
<td ><form:select path="foamPumpType">
<form:option value="Fixed">Fixed</form:option>
<form:option value="Variable">Variable</form:option>
<form:option value="Programmable">Programmable</form:option>
</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext"> Quantity </td>
<td ><form:input path="innoQuantity"/> </td>

</tr>
<tr>
<td align="right" class="datatext">Mounting</td>
<td ><form:select path="innoMount">
<form:option value="Independent">Independent</form:option>
<form:option value="Panel Mounted">Panel Mounted</form:option>

</form:select>
</td>

</tr>

<tr>
<td align="right" class="datatext">Vessel </td>
<td ><form:select path="innoVessel">
<form:option value="3l">3l</form:option>
<form:option value="5l">5l</form:option>
<form:option value="10l">10l</form:option>
<form:option value="14l">14l</form:option>
</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext">Flow (ml/min)</td>
<td ><form:select path="innoFlowml">
<form:option value="0-60">0-60</form:option>
<form:option value="10-100">10-100</form:option>
<form:option value="0-100">0-100</form:option>
<form:option value="0-300">0-300</form:option>
</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext">Capacity</td>
<td ><form:select path="innoCapacity">
<form:option value="500ml ">500ml </form:option>
<form:option value="1000ml">1000ml</form:option>
<form:option value="2000ml">2000ml</form:option>
<form:option value="2500ml">2500ml</form:option>
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

