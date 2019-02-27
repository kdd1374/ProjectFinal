<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
<%
String memberAdd = (String)session.getAttribute("memberAdd");
String delmesg = (String)session.getAttribute("delmesg");
if(memberAdd != null){
%>

alert("<%=memberAdd%>")
<%
session.removeAttribute("memberAdd");
}else if(delmesg!=null){
%>
alert("<%=delmesg%>")
<%
session.removeAttribute("delmesg");
}%>
</script>
<link rel="stylesheet" type="text/css" href="common/main.css"  />
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
<div id="main">
<div id="wrap">
<div id="wrapbox">
<img src="images/전라도1.JPG" width=750px height=350px style="margin-top:30px;"><br>
<img src="images/전라도1.JPG" width=370px height=150px style="margin-top:30px;">
<img src="images/전라도1.JPG" width=370px height=150px style="margin:30px 0 0 10px;">
</div>
</div>
<div id="wrap-left">
<div id="mainbanner">
<a href="Main">
<img src="images/main.PNG">
</a>
</div>

<jsp:include page="common/menu.jsp" flush="true" />
</div>
</div>
</body>
</html>