<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String mesg=(String)request.getAttribute("mesg");
%>
<!DOCTYPE html>
<html>
<head>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
<%if(mesg!=null){%>
alert("<%=mesg%>")
<%}%>
</script>
<style type="text/css">
a:link {                         
         text-decoration:none;    
         } 
    a:visited { 
         color:black; 
         } 
     a:hover { 
         color:black; 
         } 
   a:active { 
         color:black; 
         } 
         
	body{
	min-width: 1340px;
	margin: 0;
	}
	div{
	 display: block;
    }
	
	}
	#main{
	width: 100%;
    padding: 40px 270px;
    box-sizing: border-box;
    overflow: hidden;
	}
	#wrap{
	display: block;
    padding: 0;
    margin: 0 auto;
    width:100%;
    max-width: 1200px;
    position:relative;
	}
	
	#wrapbox{
	
	clear: both;
    position: relative;
    margin: 0 auto;
    margin-top:60px;
    padding: 0;
    text-align: center;
    width: 100%;
	}
	

	#wrap-left{
	width: 230px;
    position: fixed;
    left: 0;
    top: 0;
    z-index: 99;
    height: 100%;
    padding: 25px;
    box-sizing: border-box;
    letter-spacing: 0.2px;
    background-color:rgba(255,251,139,1);
	}
	@media screen and (max-width: 1200px)
	{#wrap-right{display:none;}
	}
	#wrap-right{
	width: 230px;
    position: fixed;
    right: 0;
    top: 0;
    z-index: 99;
    height: 100%;
    padding: 25px;
    box-sizing: border-box;
    letter-spacing: 0.2px;
    background-color:rgba(255,251,139,1);
	}
	
	#mainbanner{
	width:100%;
	float:left;
	margin:0;
	padding:20px 0 0 0;
	}
	
	
	#member{
	width:100%;
	float:left;
	margin:0px;
	margin-top:20px;
	}
	#menu{
	width:100%;
	float:left;
	margin:0px;
	margin-top:30px;
	}
		#notis{
	width:100%;
	float:left;
	margin:0px;
	margin-top:30px;
	}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id=main>
<div id="wrap-left">
<div id="mainbanner">
<a href="main.jsp">
<img src="images/main.PNG">
</a>
</div>

<jsp:include page="common/menu.jsp" flush="true" />





<div id="wrap-right">
<jsp:include page="common/menu2.jsp" flush="true" />
</div>
<div id="wrap">
<div id="wrapbox">
<jsp:include page="member/memberList.jsp" flush="true"/>
</div>
</div>
</div>

</body>
</html>