<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		$("#update").on("click",function(event){
			
			location.href="MemberUpdateServlet?id="+$("#id").text() + "&post="+$("#sample4_postcode").val()+
					"&addr1="+$("#sample4_roadAddress").val()+"&addr2="+$("#sample4_jibunAddress").val()+
					"&email="+$("#email").val()+"&ssn="+$("#ssn").val()+"&phone="+$("#phone").val();
			
		});
		
		
		$("#search").on("click",function(event){
			if($("#serch").val().length==0){
				alert("검색어를 입력해주세요");
				event.preventDefault();
			}else{
				location.href="MemberListFormServlet?nameOrId="+$("#nameOrId").val()+
						"&serch="+$("#serch").val();
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
<table width="1200px" cellspacing="0" cellpadding="0">
 <tr>
 <td width="225px">
 </td>
  <td align = "center" valign="center" colspan="2"  width="751px">
   <table width="750px" cellspacing="0" cellpadding="0" style="margin:0;" border="1" rules="none" bordercolor="#fffb8b">
    <tr>
     <td height="30px" colspan="3">
     </td>
    </tr>
    <tr>
    <td width="325px"></td>
     <td align = "center" height="21px" >
      <span style="font-size:14px;"><b>회원 관리</b></span></td>
    <td width="325px"></td>
    </tr>
    <tr>
    <td width="325px"></td>
     <td height="20px" colspan="2" align="right" valign="bottom">
     <table cellspacing="0" cellpadding="0" border="2" rules="none" bordercolor="#fffb8b" style="margin-bottom:10px;">
     <tr>
     <td valign="center" align="center" height="30px">
     <select style="height:20px; margin-left:5px;margin-top:3px; margin-right:5px; width:50px;font-size:8px;" id="nameOrId">
     <option value="id">아이디</option>
     <option value="name">이름</option>
     </select>
     </td>
     <td valign="center" align="center" height="30px" >
     <input type="text" name="serch" size="10" id="serch"
     style="font-size:12px; border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px; margin:0; height:20px; margin-right:5px;"></td>
     <td valign="center" align="center" height="30px" bgcolor="#fffb8b">
     <a href="#" id="search"><img src="images/search.gif"></a>
     </td>
     </tr>
     </table>
     </td>
    </tr>
    <tr>
     <td align="center" valign="center" colspan="3">
      <table width="750px" cellspacing="0" cellpadding="0" width="350px" frame="hsides" border="1" rules="none" bordercolor="#fffb8b">
       <tr>
        <td width="75px" valign="center" align="center" bgcolor="#fffb8b"><img src="images/id.gif" style="margin-top:6px;"></td>
        <td width="75px" valign="center" align="center" bgcolor="#fffb8b"><img src="images/name.gif" style="margin-top:6px;"></td>
        <td width="87px" valign="center" align="center" bgcolor="#fffb8b"><img src="images/phone.gif" style="margin-top:6px;"></td>
        <td width="135px" valign="center" align="center"bgcolor="#fffb8b"><img src="images/email.gif" style="margin-top:6px;"></td>
        <td width="75px" valign="center" align="center" bgcolor="#fffb8b"><img src="images/ssn.gif" style="margin-top:6px; "></td>
        <td width="68px" valign="center" align="center" bgcolor="#fffb8b"><img src="images/post.gif" style="margin-top:6px;"></td>
        <td width="150px" valign="center" align="center" bgcolor="#fffb8b"><img src="images/addr1.gif" style="margin-top:6px;"></td>
        <td width="75px" bgcolor="#fffb8b" align="center" valign="center"><img src="images/mileage.gif" style="margin-top:6px;"></td>
       </tr><!-- 컬럼 네임 -->
       <c:forEach var="i" items="${memberlistdto}">
       <tr>
       <td width="75px" height="35px" align="center" valign="center"><span style="font-size:12px;">${i.userid}</span></td>
       <td width="75px" height="35px" align="center" valign="center"><span style="font-size:12px;">${i.username}</span></td>
       <td width="87px" height="35px" align="center" valign="center"><span style="font-size:12px;">${i.phone}</span></td>
       <td width="135px" height="35px" align="center" valign="center"><span style="font-size:12px;">${i.email1}@${i.email2}</span></td>
       <td width="75px" height="35px" align="center" valign="center"><span style="font-size:12px;">${i.ssn}</span></td>
       <td width="68px" height="35px" align="center" valign="center"><span style="font-size:12px;">${i.post}</td>
       <td width="150px" height="35px" align="center" valign="center"><input type="text" size="20" 
       style="text-align:center; font-size:12px; border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px;" 
       value="${i.addr1}&nbsp;${i.addr2}" readonly="readonly"></td>
       <td width="75px" height="35px" align="center" valign="center"><span style="font-size:12px;">${i.mileage}</span></td>
       </tr>
       </c:forEach>
      </table>
     </td>
    </tr>
    <tr>
    <td height="30px" width="134px">
    </td>
    <td height="30px" width="483px" align="center" valign="top">
    <c:forEach var="i" begin="1" end="${total}">
    <c:choose>
    <c:when test="${curpage == i}">
    	<span style="font-size:12px;">${i}&nbsp;&nbsp;</span>
    </c:when>
    <c:otherwise>
    	<c:choose>
    		<c:when test="${empty serch}">
    			<a href="MemberListServlet?curpage=${i}"><span style="font-size:12px;">${i}&nbsp;&nbsp;</span></a>
    		</c:when>
    		<c:otherwise>
    			<a href="MemberListFormServlet?curpage=${i}&nameOrId=${nameOrId}&serch=${serch}">
    			<span style="font-size:12px;">${i}&nbsp;&nbsp;</span></a>
    		</c:otherwise>
    	</c:choose>
    </c:otherwise>
    </c:choose>
    </c:forEach>
    </td>
    <td height="30px" width="134px">
    </td>
   </tr>
  </table>
  </td>
  <td width="225px">
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