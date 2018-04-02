<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

 <div width="787px"  style="float:left;padding-left:20px">
 
<br>
<p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face">Search Work Order</font></p>


<form:form commandName="workorderbean" name="workorderbean">

 <label for="tags">Search Work order  by Job Desc: </label>
 <form:input path="reportFilter" size="100" />

 <p><input type="button" value="Filter report" onclick="eventdirect('filterReport')"/>&nbsp;&nbsp;</p>

 <br/>
 <br/>
 <br/>

 <br/>
 <br/><br/>
 <br/>
<div width="787px"  style="float:left;">
 <div width="787px"  style="float:left;">
  <display:table export="true" sort="list"  pagesize="10" name="workorderlist" requestURI="springtest.htm"  id="row1"   cellpadding="5px" cellspacing="5px" htmlId="2" >

   <display:column sortable="true"  title="Select" media="html" >
    <form:radiobutton path="windex"  value="${row1_rowNum}" onclick="eventdirect('viewworkdocs') "/>

   </display:column>
   <display:column sortable="true"  property="clientDetails" >

   </display:column>
   <display:column sortable="true"  property="deliveryAdd" >

   </display:column>
   <display:column sortable="true" title="Delivery Date" property="datePerPo" >

   </display:column>
   <display:column sortable="true"  property="jobDesc" >

   </display:column>
   <display:column sortable="true"  property="poNumber" >

   </display:column>
   <display:column sortable="true"  property="poDate" >

   </display:column>
   <display:column sortable="true"  property="workCreateDt" >

   </display:column>
   <display:column sortable="true"  property="preparedBy" >

   </display:column>
   <display:column sortable="true"  property="approvedBy" >

   </display:column>

  </display:table>

  <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
  <input type="hidden" name="_eventId"  id="_eventId" value="addMI" >
 </div>

 <div style="float:left;width:750px;padding:10px;margin-top:50px">

</div>

<div style="float:left;width:750px;padding:10px;margin-top:50px">

  <script>
      window.onload = function () {

          var chart = new CanvasJS.Chart("chartContainer", {
              animationEnabled: true,
              title:{
                  text: "Work Order Actual vs Work Order Estimate"
              },
              axisY: {
                  title: "Cost in Rupees",
                  titleFontColor: "#4F81BC",
                  lineColor: "#4F81BC",
                  labelFontColor: "#4F81BC",
                  tickColor: "#4F81BC"
              },

              toolTip: {
                  shared: true
              },
              legend: {
                  cursor:"pointer",
                  itemclick: toggleDataSeries
              },
              data: <c:out value='${chartData}' escapeXml="false"/>
          });
          chart.render();

          function toggleDataSeries(e) {
              if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
                  e.dataSeries.visible = false;
              }
              else {
                  e.dataSeries.visible = true;
              }
              chart.render();
          }

      }
  </script>
 </head>
 <body>
 <div id="chartContainer" style="height: 370px; width: 100%;"></div>
 </body>
 </html>

</div>
</form:form>
</div>
<form name="myloginform" action="streamer.servlet" method="post">
<input type="hidden" name="key" id="key" value="workdes"/>
<input type="hidden" name="idkey" id="idkey" value=""/>
</form>
<form name="myloginform1" action="streamer.jdrservlet" method="post">
<input type="hidden" name="key" id="key" value="workjdr"/>
<input type="hidden" name="idkey" id="idkey" value=""/>
</form>
<div width="787px" style="float:left;height:150px">



</div>


<script language="javascript">

function eventdirect(event) {

document.getElementById('_eventId').value = event;

document.workorderbean.submit();
}

function openfile(idkeyval) {
document.myloginform.idkey.value=idkeyval;
document.myloginform.submit();
}
function openfile1(idkeyval) {
document.myloginform1.idkey.value=idkeyval;
document.myloginform1.submit();
}
</script>

<script>
    $( function() {
        var temp = "<c:out value='${workorderlistNames}'/>";
        var availableTags =temp.split('|');
        $( "#reportFilter" ).autocomplete({
            source: availableTags
        });
    } );
</script>