 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <div width="787px"  style="float:left;">
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face">Enter Fermenter Details</font></p>


<div width="787px"  style="float:left;">
<form:form commandName="fermjobbean" >

<table border="0" width="100%" cellpadding="10x" height="70px">
<tr>
<td align="right" class="datatext">Quantity</td>
<td ><form:input path="quantity" /><span style="color:red;">*</span></td></tr>

<tr>
<td align="right" class="datatext">Design Code</td>
<td ><form:input path="designCode" /><span style="color:red;">*</span></td></tr>

<tr>
<td align="right" class="datatext">Vessel Volume</td>
<td ><form:input path="vesselVolume" /><span style="color:red;">*</span></td></tr>
<tr>
<td align="right" class="datatext">Height to Diameter Ratio</td>
<td ><form:input path="htDiaRatio" /><span style="color:red;">*</span></td>
</tr>
<tr>
<td align="right" class="datatext">Standard Vessel</td>
<td ><form:input path="standardVessel" /><span style="color:red;">*</span></td>
</tr>
<tr>
<td align="right" class="datatext">Density Broth</td>
<td ><form:input path="densityBroth" /><span style="color:red;">*</span></td>
</tr>
<tr>
<td align="right" class="datatext">Fermenter Broth Viscosity</td>
<td ><form:input path="fermBrothViscos" /></td>
</tr>
<tr>
<td align="right" class="datatext">Suspended Solids</td>
<td ><form:input path="suspendedSolids" /><span style="color:red;">*</span></td>
</tr>
<tr>
<td align="right" class="datatext">Air Flow Rate</td>
<td ><form:input path="airFlowRate" /><span style="color:red;">*</span></td>
</tr>
<tr>
<td align="right" class="datatext">Design Shell Press</td>
<td ><form:input path="designShellPres" /><span style="color:red;">*</span></td>
</tr>
<tr>
<td align="right" class="datatext">Design Jack Pressure</td>
<td ><form:input path="designJackPress" /></td>
</tr>
<tr>
<td align="right" class="datatext">Design Temp Shell </td>
<td ><form:input path="designTempShell" /></td>
</tr>
<tr>
<td align="right" class="datatext">Design Jack Temp</td>
<td ><form:input path="designJackTemp" /></td>
</tr>
<tr>
<td align="right" class="datatext">Internal Surface Finish</td>
<td ><form:input path="internalSurfFinish" /></td>
</tr>
<tr>
<td align="right" class="datatext">External Surface Finish</td>
<td ><form:input path="extSurfFinish" /></td>
</tr>
<tr>
<td align="right" class="datatext">Support Type</td>
<td ><form:select path="supportTypeLov" size="1" >

<form:options items="${supportitems}" itemValue="seqLovId" itemLabel="lovDescription"/>
</form:select></td>
</tr>

<tr>
<td align="right" class="datatext">Agitator Type</td>
<td ><form:input path="agitatorType" /></td>
</tr>
<tr>
<td align="right" class="datatext">Impeller Number</td>
<td ><form:input path="impellerNum" /></td>
</tr>
<tr>
<td align="right" class="datatext">Impeller Diameter</td>
<td ><form:input path="impellerDia" /></td>
</tr>

<tr>
<td align="right" class="datatext">Agitator Speed</td>
<td ><form:input path="agitatorSpeed" /></td>
</tr>
<tr>
<td align="right" class="datatext">Lantern Type</td>
<td ><form:input path="lanternType" /></td>
</tr>
<tr>
<td align="right" class="datatext">Motor Power</td>
<td ><form:input path="motorPower" /></td>
</tr>
<tr>
<td align="right" class="datatext">Motor Speed</td>
<td ><form:input path="motorSpeed" /></td>
</tr>
<tr>
<td align="right" class="datatext">Power Supply</td>
<td ><form:input path="powerSupply" /></td>
</tr>
<tr>
<td align="right" class="datatext">Class Protection</td>
<td ><form:input path="classProtection" /></td>
</tr>
<tr>
<td align="right" class="datatext">Transmission By</td>
<td ><form:input path="transmissionBy" /></td>
</tr>
<tr>
<td align="right" class="datatext">Mechanical Seal</td>
<td ><form:input path="mechanicalSeal" /></td>
</tr>
<tr>
<td align="right" class="datatext">Equispaced Baffles</td>
<td ><form:input path="equispacedBaffles" /></td>
</tr>
<tr>
<td align="right" class="datatext">VFD</td>
<td ><form:input path="vfd" /></td>
</tr>
<tr>
<td align="right" class="datatext">Rupture DISK</td>
<td ><form:input path="ruptureDisk" /></td>
</tr>
<tr>
<td align="right" class="datatext">Harvest Valve</td>
<td ><form:input path="harvestValve" /></td>
</tr>
<tr>
<td align="right" class="datatext">Sampling Valve</td>
<td ><form:input path="samplingValve" /></td>
</tr>
<tr >
<td align="right" >&nbsp;</td>
<td><input type="submit" value="Save Job Details" /> </td>
</tr>
<form:errors >
<c:forEach items="${messages}" var="message">
		<tr><td colspan="2"><c:out value="${message}"></c:out></td></tr>
	</c:forEach>

</form:errors>
</table>

 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId"  value="saveworkorder"   id="_eventId" > 
   
</form:form>
</div>
</div>
<div width="787px" style="float:left;height: 150px">



</div>