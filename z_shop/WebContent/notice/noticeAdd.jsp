<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 등록</title>

<script>
$(document).ready(function(){
	
	$("#Add").on("click",function(event){
		if($("#title").val().length==0){
			console.log("oo")
			alert("제목을 입력해주세요");
			$("#title").focus();
			event.preventDefault();
		}else{
			
			
		}
	})
	
	
	
});




</script>
                    


</head>
<body>
<h1>게시글 등록</h1>
<form name="frm" method="get" action="NoticeAddServlet">
<!-- form 이름 frm은 자바스크립트로 form을 선택할때 사용
post방식으로 보안상 값을 코드(바이트코드)로 변경해서 보냄
BoardServlet이란 주소로 request로 보냄

바이트코드 : 
자바(Java) 컴파일러는 플랫폼에 독립적인 자바 가상 머신(virtual machine) 상에서 동작하는 바이트 코드를 생성해낸다. 이것은 자바 애플릿은 자바 가상 머신을 지원하는 모든 기계 상에서 동작을 하는 것을 의미한다.

-->
<input type="hidden" name="command" value=""> <!-- command키로 board_write값을 보냄 -->
<table border="0" align="center" >
<tr>
<th bgcolor="#fffb8b">작성자</th>
<td>
<input type="text" name="reg_admin" align="center">
</td>
</tr>
<!-- <tr>
<th>비밀번호</th>
<td>
<input type="password" name="pass" id="passwd">
<span>* 필수 (게시물 수정 삭제시 필요합니다.)</span>
</td>
</tr> -->
<!-- <tr>
<th>이메일</th>
<td>
<input type="text" name="email">
</td>
</tr> -->
<tr>
<th bgcolor="#fffb8b">제목</th>
<td>
<input type="text" name="notice_title" id="title" align="center" placeholder="필수 입력사항">
</td>
</tr>
<tr>
<th bgcolor="#fffb8b">내용</th>
<td><textarea cols="70" rows="15" name="notice_contents"></textarea></td> 
<!-- textarea의 70x15 크기 -->
</tr>
</table>
<input type="submit" value="등록" id="Add">
    <!-- submit은 form의 키와 값를  request로 전송한다 -->
<input type="reset" value="다시작성">
 
<input type="button" value="목록" onclick="location.href='NoticeServlet?command=notice_list'">
     <!--button을 onclick(한번 눌럿을때)실행되었을때 location(장소)의 경로를 --> 
</form>
</div>
</body>
</html>


