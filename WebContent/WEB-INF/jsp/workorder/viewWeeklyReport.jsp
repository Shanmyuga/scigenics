<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div width="787px"  style="float:left;">
    <br>
    <p style="padding-left:20px" align="center"><font color="#0080ff" size="4" face="Baskerville Old Face"> Weekly Status report </font></p>
    <p style="padding-left:20px" align="center"></p>
    <div width="787px"  style="float:left;">
        <form:form commandName="projschebean" name="projschebean">
            <div width="787px"  style="float:left;">
                <table width="600px" cellspacing="5" cellpadding="5" align="left" border="0" >


                    <tr>



                        <td>From date</td>
                        <fmt:formatDate pattern="dd-MM-yyyy" value="${projschebean.fromdate}" var="fromdatestr"/>
                        <td><input type="text" name="fromdate" value="<c:out value="${fromdatestr}"/>" size="10"/>
                            <a href="javascript:show_calendar('document.projschebean.fromdate', document.projschebean.fromdate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
                        </td>

                        <td>To date</td>
                        <fmt:formatDate pattern="dd-MM-yyyy" value="${projschebean.todate}" var="todatestr"/>
                        <td><input type="text" name="todate" value="<c:out value="${todatestr}"/>" size="10"/>
                            <a href="javascript:show_calendar('document.projschebean.todate', document.projschebean.todate.value);"><img src="images/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the timestamp"></a>
                        </td>
                    </tr>


                    <tr>
                        <td>Work Order</td>
                        <td><form:select path="seqWorkId"    >
                            <form:option value="">All</form:option>
                            <form:options items="${workorderlist}" itemLabel="jobDesc" itemValue="seqWorkId"/>
                        </form:select>

                        </td>


                        <td colspan="2" align="right"><input type="button" value="Search Report Tasks" onclick="eventdirect('viewStatusReport')"/></td>

                    </tr>
                </table>

            </div>


            <div style="float:left;width:750px;padding:10px;margin-top:50px">

                <display:table export="true" sort="list"   pagesize="10" name="subphaseTasks"  id="row1"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >

                    <display:column sortable="true"   title="Sub Task Phase"  property="subPhaseName">

                    </display:column>
                    <display:column sortable="true"  title="Actuak Man hrs entry "  property="actManhours">

                    </display:column>
                    <display:column sortable="true"  title="Task completion date "  property="subActEnd">

                    </display:column>
                    <display:column sortable="true"  title="Updated Date"  property="updatedDate">

                    </display:column>
                    <display:column sortable="true"  title="Task Description"  property="taskDesc">

                    </display:column>
                    <display:column sortable="true"  title="Updated By"  property="updatedBy">

                    </display:column>
                </display:table>


            </div>
            <input type="hidden" name="_flowExecutionKey"  value="<c:out value="${flowExecutionKey}"/>" />
            <input type="hidden" name="_eventId"  id="_eventId" value="seachPO" >




        </form:form>


    </div>
</div>

<script language="javascript">

    function eventdirect(event) {

        document.getElementById('_eventId').value = event;

        document.storesbean.submit();
    }
</script>
