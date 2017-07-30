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



<td  colspan="2" align="right">Utilities</td>
</tr>
<tr>
<td align="right" class="datatext">Steam Generator </td>
<td ><form:select path="utilitiesSteamgen">
<form:option value="Yes">Yes </form:option>
<form:option value="No">No </form:option>


</form:select>
</td>

</tr>

<tr>
<td align="right" class="datatext">Steam Generator Make</td>
<td ><form:select path="utilSteamMake">
<form:option value="Ramson">Ramson </form:option>
<form:option value="thermax">thermax </form:option>

<form:option value="others">others </form:option>
</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext">Steam Capacity</td>
<td ><form:input path="utilityCapacity"/> </td>

</tr>
<tr>
<td align="right" class="datatext">Chiller</td>
<td ><form:select path="utilityChiller">
<form:option value="Yes">Yes </form:option>
<form:option value="No">No </form:option>


</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext">Chiller Make</td>
<td ><form:select path="utilChillerType">
<form:option value="Reynold ">Reynold  </form:option>
<form:option value="Techscience">Techscience </form:option>

<form:option value="Maruthi ">Maruthi  </form:option>
<form:option value="Bheeshar  ">Bheeshar   </form:option>
<form:option value="others">others</form:option>
</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext">Chiller Capacity</td>
<td ><form:input path="utilityChillerCapac"/> </td>

</tr>
<tr>
<td align="right" class="datatext">Stablizer</td>
<td ><form:select path="utilityStablizer">
<form:option value="Yes">Yes </form:option>
<form:option value="No">No </form:option>


</form:select>
</td>

</tr>

<tr>
<td align="right" class="datatext">Air Compressor</td>
<td ><form:select path="utilAircompress">
<form:option value="Yes">Yes </form:option>
<form:option value="No">No </form:option>


</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext">Air Compressor Make</td>
<td ><form:select path="utilAircompType">
<form:option value="Elgi  ">Elgi   </form:option>
<form:option value="Anest Iwata">Anest Iwata </form:option>

<form:option value="High speed appliances">High speed appliances   </form:option>
<form:option value="FGNL">FGNL   </form:option>
<form:option value="others">others</form:option>
</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext">Air Compressor Capacity</td>
<td ><form:input path="utilAircompressCapac"/> </td>

</tr>

<tr>
<td align="right" class="datatext">UPS</td>
<td ><form:select path="utilUps">
<form:option value="Yes">Yes </form:option>
<form:option value="No">No </form:option>


</form:select>
</td>

</tr>
<tr>
<td align="right" class="datatext">Water Circulation System</td>
<td ><form:select path="utilWatercir">
<form:option value="Yes">Yes </form:option>
<form:option value="No">No </form:option>


</form:select>
</td>

</tr>
<tr>



<td  colspan="1" align="right"><input type="button" value="Back "  onclick="backpage()"/></td>
<td  colspan="1" align="right"><input type="submit" value="Add Job Details " /></td>
</tr>

</table>

 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId"  id="_eventId"  value="addworkfinal"> 
   

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
<script language="javascript">

function backpage() {
	document.getElementById('_eventId').value='back'
	document.forms[0].submit();
}
</script>
