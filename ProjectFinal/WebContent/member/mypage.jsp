<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
<%
String mesg = (String)request.getAttribute("upmesg");
if(mesg != null){
%>
alert("<%=mesg%>");
<%}%>
	$(document).ready(function(){
		
		$("#update").on("click",function(event){
			
			location.href="MemberUpdateServlet?id="+$("#id").text() + "&post="+$("#sample4_postcode").val()+
					"&addr1="+$("#sample4_roadAddress").val()+"&addr2="+$("#sample4_jibunAddress").val()+
					"&email="+$("#email").val()+"&ssn="+$("#ssn").val()+"&phone="+$("#phone").val();
			
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
<table width="1200px" cellspacing="0" cellpadding="0" >
 <tr>
 <td width="378.5px">
 </td>
  <td align = "center" valign="center" colspan="2">
   <table width="443px" cellspacing="0" cellpadding="0" style="margin:0;" border="1" rules="none" bordercolor="#fffb8b">
    <tr>
     <td height="30px">
     </td>
    </tr>
    <tr>
     <td align = "center">
      <span style="font-size:14px;"><b>My Page</b></span></td>
    </tr>
    <tr>
     <td height="30px"></td>
    </tr>
    <tr>
     <td align = "center">
     <span style="font-size:12px;"><b>${logindto.hiredate} 부터 함께하고 계십니다!</b></span></td>
    </tr>
    <tr>
     <td height="10px">
     </td>
    </tr>
    <tr>
     <td align="center" valign="center">
      <table cellspacing="0" cellpadding="0" width="350px" border="1" rules="none" bordercolor="#fffb8b">
       <tr>
        <td valign="center" align="center" bgcolor="#fffb8b"><img src="images/id.gif" style="margin-top:10px;"></td>
        <td valign="center" align="center">
         <span style="font-size:12px;" id="id">${logindto.userid}</span></td>
       </tr>
       <tr>
        <td valign="center" align="center" bgcolor="#fffb8b"><img src="images/name.gif" style="margin-top:10px;"></td>
        <td valign="center" align="center"><span style="font-size:12px;">${logindto.username}</span></td>
       </tr>
       <tr>
        <td valign="ceter" align="center" bgcolor="#fffb8b" valign="center" rowspan="2"><img src="images/post.gif" style="margin-top:10px;"></td>
        <td valign="center" align="center"><input name="post" type="text" id="sample4_postcode" placeholder="우편번호" value="${logindto.post}" 
        style="margin:0; text-align:center; border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;" 
        size="25" readonly="readonly">
        </td>
       </tr>
       <tr>
        <td valign="center" align="center"><span style="font-size:12px; font-color:blue;">
        <b><a href="#" onclick="sample4_execDaumPostcode()">우편번호 찾기</a></b></span></td>
       </tr>
       <tr>
        <td valign="center" align="center" rowspan="2" bgcolor="#fffb8b"><img src="images/addr.gif" style="margin-top:10px;"></td>
        <td valign="center" align="center"><input type="text" name="addr1" id="sample4_roadAddress" value="${logindto.addr1}" 
        placeholder="도로명주소" size="25" readonly="readonly" 
        style="text-align:center; border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;"></td>
       </tr>
       <tr>
        <td valign="center" align="center">
        <input type="text" name="addr2" id="sample4_jibunAddress" value="${logindto.addr2}" placeholder="지번주소" size="25" readonly="readonly" 
        style="text-align:center; border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;"></td>
        <span id="guide" style="color:#999"></span>
       </tr>
       <tr>
        <td valign="center" align="center" bgcolor="#fffb8b"><img src="images/phone.gif" style="margin-top:6px;"></td>
        <td valign="center" align="center"><input name="phone" type="text" id="phone" value="${logindto.phone}" 
        style="margin:0; text-align:center; border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;" size="25"></td>
       </tr>
       <tr>
        <td valign="center" align="center"bgcolor="#fffb8b"><img src="images/email.gif" style="margin-top:10px;"></td>
        <td valign="center" align="center"><input name="email" type="text" id="email" value="${logindto.email1}@${logindto.email2}" 
        style="margin:0; text-align:center; border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;" size="25"></td>
       </tr>
       <tr> 
        <td valign="center" align="center" bgcolor="#fffb8b"><img src="images/ssn.gif" style="margin-top:10px; "></td>
        <td valign="center" align="center"><input name="ssn" type="text" id="ssn" value="${logindto.ssn}" 
        style="margin:0; text-align:center; border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;" size="25"></td>
       </tr>
       <tr>
        <td bgcolor="#fffb8b" align="center" valign="center"><img src="images/mileage.gif" style="margin:0;"></td>
        <td valign="center" align="center"><span style="font-size:12px;">${logindto.mileage}</span></td>
       </tr>
      </table>
     </td>
    </tr>
    <tr>
    <td height="30px">
    </td>
   </tr>
  </table>
  </td>
 </tr>
 <tr>
 <td width="378.5px">
 </td>
 <td width="292px">
 </td>
  <td align="right" valign="top" bgcolor="#fffb8b">
	<a href="#" id ="update"><img src="images/updateMember.gif"></a><a href="MemberDelFormServlet" id ="memberDel"><img src="images/signout2.gif"></a>
  </td>
 <td width="378.5px">
 </td>
 </tr>
</table>
</body>
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
</html>