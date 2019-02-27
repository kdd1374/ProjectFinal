<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		$("#find").on("click",function(event){
			if($("#username").val().length==0){
				alert("이름을 입력해주세요");
				 $("#username").focus();
				event.preventDefault();
			}else if($("#email").val().length==0){
				alert("이메일을 입력해주세요");
				 $("#email").focus();
				event.preventDefault();
			}else{
				location.href="FindIdServlet?username="+$("#username").val()+"&email="+$("#email").val();
			}
		});
		
	});

</script>
<style type="text/css">
 
  #remote:link {                         
         color:black; text-decoration:none;    
         } 
    #remote:visited { 
         color:#c1c1c1; 
         } 
     #remote:hover { 
         color:#c1c1c1; 
         } 
   #remote:active { 
         color:#c1c1c1; 
         } 

</style>
</head>
<body>
<span style="font-size:14px;"><b>아이디 찾기</b></span><br>
<input type="text" id="username" name="username" style="text-align:center; margin-top:30px;" placeholder="이름" size="40"><br>
<span style="font-size:12px; color:red;"><b>이름을 입력해주세요</b></span></br>
<input type="test" id="email" name="email" style="text-align:center;" placeholder="이메일" size="40"><br>
<span style="font-size:12px; color:red;"><b>가입시 작성했던 이메일을 적어주세요.</b></span></br>
<a href="#" id="find">확인</a>
<a href="#" id="idlogin"><img src="images/login.gif" style="margin-top:10px;" id="loginimg"></a><br>
<a href="PasswordSearchServlet">비밀번호 찾기</a>
</body>
</html>