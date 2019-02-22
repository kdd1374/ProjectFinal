<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
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
		$("#userid").on("keyup",function(event){
			$.ajax({
	            type:'get',
	            url : 'SignupIdCheckServlet',
	            data:{
	            	userid: $("#userid").val()
	            		
	            },
	            dataType : "text",
	            success : function(data,status,xhr){
	            	console.log(data);
	                  $("#user").text(data);
	                 
	            },
	            error:function(xhr,status,ex){
	                  console.log(ex);
	            }
			});
			
		});
		 $("#signup").on("click",function(event){
			 if($("#username").val().length==0){
				 alert("이름을 입력해주세요");
				 event.preventDefault();
		     }else if($("#userid").val().length==0){
				 alert("아이디를 입력해주세요");
				 event.preventDefault();
			 }else if($("#password").val().length==0){
				 alert("비밀번호를 입력해주세요");
				 event.preventDefault();
			 }else if($("#sample4_postcode").val().length==0){
				 alert("주소를 입력해주세요");
				 event.preventDefault();
			 }else if($("#sample4_roadAddress").val().length==0){
				 alert("주소를 입력해주세요");
				 event.preventDefault();
			 }else if($("#sample4_jibunAddress").val().length==0){
				 alert("주소를 입력해주세요");
				 event.preventDefault();
			 }else if($("#phone").val().length==0){
				 alert("핸드폰번호를 입력해주세요");
				 event.preventDefault();
			 }else if($("#email1").val().length==0){
				 alert("이메일을 입력해주세요");
				 event.preventDefault();
			 }else if($("#email2").val().length==0){
				 alert("이메일을 입력해주세요");
				 event.preventDefault();
			 }else if($("#user").text()=="사용 불가능한 아이디입니다"){
				 alert("아이디가 중복되었습니다");
				 $("#user").focus();
				 event.preventDefault();
			 }else{
			location.href="MemberSignupFormServlet?userid="+$("#userid").val()+"&password="+$("#password").val()
					+"&username="+$("#username").val()+"&post="
			+$("#sample4_postcode").val()+"&addr1="+$("#sample4_roadAddress").val()+"&addr2="+$("#sample4_jibunAddress").val()
			+"&phone="+$("#phone").val()+"&email1="+$("#email1").val()+"&email2="+$("#email2").val();
			 }
		}); 
		//이메일 선택
		 $("#selectemail").on("change",function(){
			 var em= $(this).val();
				 $("#email2").val(em);
		 })
		
		
	});

</script>
<h1>회원가입</h1>
<div> * 는 필수 입력 사항입니다.</div>
<form action="MemberAddServlet" method="get">
<span style="font-size:12px" ><b>* 이름</b></span><br>
<input type="text" name="username" id="username" style="text-align:center; margin:0;" size="30"><br>
<span style="color:red; font-size:10px; margin:0;"> 이름을 입력해주세요</span><br>
<span style="font-size:12px" ><b>* 생년월일</b></span><br>
<input type="text" name="ssn" id="ssn" style="text-align:center; margin:0;" size="30" placeholder="ex) 19901234"><br>
<span style="color:red; font-size:10px; margin:0;"> 생년월일을 입력해주세요(8자)</span><br>
<span style="font-size:12px"><b>* 아이디</b></span><br>
<input type="text" name="userid" id="userid" style="text-align:center; margin:0;" size="30"><br>
<span style="color:red; font-size:10px; margin:0;" id="user"> 아이디를 입력해주세요</span><br>
<span style="font-size:12px"><b>* 비밀번호</b></span><br>
<input type="password" name="password" id="password" style="text-align:center;margin:0;" size="30"><br>
<span style="color:red; font-size:10px; margin:0;" id="pass">비밀번호를 입력해주세요</span><br>
<span style="font-size:12px"><b>* 비밀번호 확인</b></span><br>
<input type="password" id="passwd" style="text-align:center;margin:0 0 2xp 0;" size="30"><br>
<span style="color:red; font-size:10px; margin:0;" id="passcheck">비밀번호를 한번 더 입력해주세요</span><br>
<span style="font-size:12px"><b>* 주소</b></span><br>
<input name="post" type="text" id="sample4_postcode" placeholder="우편번호" style="text-align:center;margin:0;" size="18" readonly="readonly">
<span style="font-size:12px"><b><a href="#" onclick="sample4_execDaumPostcode()">우편번호 찾기</a></b></span><br>
<input type="text" name="addr1" id="sample4_roadAddress" placeholder="도로명주소" style="margin:10px 0 0 0;" size="30"><br>
<input type="text" name="addr2" id="sample4_jibunAddress" placeholder="지번주소" style="margin:10px 0 0 0;" size="30"><br>
<span id="guide" style="color:#999"></span>

<span style="font-size:12px"><b>* 연락처</b></span><br>
<input type="text" name="phone" id="phone" placeholder="-는 빼고 입력해주세요" style="text-align:center;margin:0;" size="30"><br>
<span style="font-size:12px"><b>* 메일주소</b></span><br>
<input name="email1" id="email1" type="text" size="12.1" style="text-align:center;margin:0;">
<span style="font-size:10px; margin:0;">@</span><input name="email2" placeholder="직접입력" id="email2" type="text" size="12.1" style="text-align:center;margin:0;">
<select id="selectemail">
<option value="naver.com" id="na">naver.com</option>
<option value="gmail.com" id="gm">gmail.com</option>
<option value="hanmail.net" id="hm">hanmail.net</option>
</select><br><br>
<input type="submit" value="회원가입">


<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample4_roadAddress').value = fullRoadAddr;
                document.getElementById('sample4_jibunAddress').value = data.jibunAddress;

                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    //예상되는 도로명 주소에 조합형 주소를 추가한다.
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

                } else {
                    document.getElementById('guide').innerHTML = '';
                }
            }
        }).open();
    }
</script>