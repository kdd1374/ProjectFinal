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
			if($("#password").val().length==0){
				alert("비밀번호를 입력해주세요");
				 $("#password").focus();
				event.preventDefault();
			}else if($("#passwd").val().length==0){
				alert("비밀번호를 입력해주세요");
				 $("#passwd").focus();
				event.preventDefault();
			}else{
				location.href="PassUpdateServlet?password="+$("#password").val()+"&userid="+$("#userid").val();
			}
		});
		$("#passwd").on("keyup",function(event){
			if($("#password").val()==$("#passwd").val()){
				$("#passcheck").attr("style","color:blue;font-size:10px; margin:0;");
				$("#passcheck").text("비밀번호가 일치합니다");
			}else if($("#password").val()!=$("#passwd").val()){
				$("#passcheck").attr("style","color:red;font-size:10px; margin:0;");
				$("#passcheck").text("비밀번호가 일치하지 않습니다");
			}else{
				$("#passcheck").attr("style","color:red;font-size:10px; margin:0;");
				$("#passcheck").text("비밀번호를 한번 더 입력해주세요");
				}
		});
	});

</script>
<style type="text/css">
 
  #remote:link {                         
         text-decoration:none;    
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
<input type="hidden" id="userid" value="${userid}">
<span style="font-size:14px;"><b>비밀번호 변경</b></span><br>
<span style="font-size:12px"><b>비밀번호</b></span><br>
<input type="password" name="password" id="password" style="text-align:center;margin:0;" size="30"><br>
<span style="color:red; font-size:10px; margin:0;" id="pass">비밀번호를 입력해주세요</span><br>
<span style="font-size:12px"><b>* 비밀번호 확인</b></span><br>
<input type="password" id="passwd" style="text-align:center;margin:0 0 2xp 0;" size="30"><br>
<span style="color:red; font-size:10px; margin:0;" id="passcheck">비밀번호를 한번 더 입력해주세요</span><br>
<a href="#" id="find">확인</a><br>
<a href="#" id="idlogin"><img src="images/login.gif" style="margin-top:10px;" id="loginimg"></a><br>
<a href="IdSearchServlet">아이디찾기</a>  <a href="PasswordSearchServlet">비밀번호찾기</a><br>
<span style="font-size:12px"><b>아이디가 없으시다면 회원가입을 해주세요</b></span></br>
<a href="MemberSignupServlet" id="signup"><img src="images/signup.gif" style="margin-top:10px;" id="signupimg"></a><br>
</body>
</html>