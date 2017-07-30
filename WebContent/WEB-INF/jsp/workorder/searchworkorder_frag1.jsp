<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib uri="http://ajaxtags.sourceforge.net/tags/ajaxtags"
    prefix="ajax"%>
<div id="body1" style="float:left;width:750px;padding:10px;margin-top:50px">
<p>Design Documents for this workorder</p>

 <div id="loading" style="display:none">  
Loading content, please wait..   
<img src="images/loading.gif" alt="loading.." />  
</div> 


<display:table    export="true" sort="list" class="displaytag"  pagesize="10" name="workdes"  id="row2"  requestURI="springtest.htm"  cellpadding="5px" cellspacing="3px" htmlId="design">


<display:column sortable="true"   title="Document Name"  >
<c:out value="${row2.sciDrawingRef.documentName}" />
</display:column>
<display:column sortable="true"  title="Document Desc" >
<c:out value="${row2.sciDrawingRef.drawingDesc}" />
</display:column>
<display:column sortable="true"  title="Document Ref Num"  >
<c:out value="${row2.sciDrawingRef.drwingRefnum}" />
</display:column>
<display:column sortable="true"  title="Revision"  >
<c:out value="${row2.documentVersion}" />
</display:column>
<display:column sortable="true"  title="Approval"   >
<c:out value="${row2.drawingStatus}" />
</display:column>

<display:column sortable="true"  title="Date uploaded"   >
<c:out value="${row2.updatedDate}" />
</display:column>


</display:table>


</div>

