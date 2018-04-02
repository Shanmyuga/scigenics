<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div width="787px"  style="float:left;height: 150px">
<br>



</div>
<div width="787px"  style="float:left;padding:30px">
<form:form commandName="userbean" name="userbean" >
<display:table export="true" sort="list"   pagesize="10" name="userlist"  id="row"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" >
<display:column sortable="true"  title="Select" media="html" >
<form:radiobutton path="selectedUserID"  value='${row.seqUserId}' onclick="eventdirect('loadRoleData')"></form:radiobutton>

</display:column>

<display:column sortable="true"   title="First Name"  property="userFirstname">

</display:column>
<display:column sortable="true"   title="Last Name"  property="userLastname">

</display:column>
<display:column sortable="true"  title="user ID"  property="userId">

</display:column>
<display:column sortable="true"  title="roles"  >
<c:forEach items="${row.scigenicsRoleMasters}" var="roleobj">
<c:out value="${roleobj.roleName}"></c:out><br>
</c:forEach>
</display:column>

</display:table>

  
 <input type="hidden" name="_flowExecutionKey" value='<c:out value="${flowExecutionKey}"/>'>
 <input type="hidden" name="_eventId"  id="_eventId"  value="updateUser">
 
 
 
 <c:if test="${fn:length(userlist) > 0}">


<table>
<tr>
<td>New Password</td>

<td><form:password path="password"/></td>
<td>Deactivate User</td>

<td><form:checkbox path="userStatus" value="N"/></td>
</tr>

    <tr>
        <td align="right" class="datatext">New Roles</td>
        <td ><form:select path="roleID" multiple="true" >

            <form:options items="${roleitems}" itemValue="seqRoleId" itemLabel="roleName"/>
        </form:select> </td></tr>
<tr>
<td colspan="4" align="left">
  <input type="submit" value="Update User" /></td>
  </tr>
  </table>
  
  
</c:if>
</div> 

<div width="787px" style="float:left;height: 150px">



</div>
</form:form>
<script language="javascript">
function addRemarks() {
document.matindbean._eventId.value = "updateRemarks";
document.matindbean.submit();
}

function openfile(idkeyval) {
document.myloginform.idkey.value=idkeyval;
document.myloginform.submit();
}
</script>

<script language="javascript">

    function eventdirect(event) {

        document.getElementById('_eventId').value = event;

        document.userbean.submit();
    }
</script>