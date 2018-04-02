

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>

<head>
<title>Scigenics</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<meta name="keywords" content="Keywords here">
<meta name="description" content="Description here">
<meta name="Author" content="MyFreeTemplates.com">
<META NAME="robots" CONTENT="index, follow"> <!-- (Robot commands: All, None, Index, No Index, Follow, No Follow) -->
<META NAME="revisit-after" CONTENT="30 days">
<META NAME="distribution" CONTENT="global"> 
<META NAME="rating" CONTENT="general">
<META NAME="Content-Language" CONTENT="english">



<script language="JavaScript" type="text/JavaScript" src="images/myfreetemplates.js"></script>
<script language="JavaScript" type="text/JavaScript" src="js/commonJS.js"></script>

<script language="JavaScript" src="images/ts_picker.js"></script>
<script type="text/javascript" src="<c:url value="/resources/dojo/dojo.js" />"> </script>
<script type="text/javascript" src="<c:url value="/resources/spring/Spring.js" />"> </script>
<script type="text/javascript" src="<c:url value="/resources/spring/Spring-Dojo.js" />"> </script>

    <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link href="images/myfreetemplates.css" rel="stylesheet" type="text/css">
<link href="css/displaytag.css" rel="stylesheet" type="text/css">



</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr> 
    <td height="87"><tiles:insertAttribute name="header"/></td>
  </tr>
  <tr> 
    <td valign="top">
    <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" background="images/topnavbg.jpg">
        <tr> 
          <td height="9" colspan="2" background="images/basebg2.jpg"><img src="images/basebg2.jpg" width="1" height="9"></td>
        </tr>
        <tr> 
          <td width="150" rowspan="2" valign="top">
    <tiles:insertAttribute name="menu">
    
    </tiles:insertAttribute>
</td>

<td valign="top" bgcolor="#FFFFFF">

 <tiles:insertAttribute name="body"></tiles:insertAttribute>
         </td>
       


    </tr>
        <tr> 
          <td bgcolor="#FFFFFF">&nbsp;</td>
        </tr>
      </table></td>
  </tr>
  <tr> 
    <td height="24" background="images/basebg1.jpg"><img src="images/basebg1.jpg" width="1" height="24"></td>
  </tr>
  <tr>
    <td height="44" valign="top" background="images/basebg2.jpg">   
    <tiles:insertAttribute name="footer"></tiles:insertAttribute>
    </td>
  </tr>
</table>
</body>
</html>

