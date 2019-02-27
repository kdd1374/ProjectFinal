<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
<%
String mesg = (String)request.getAttribute("adminMesg");
if(mesg != null){
%>
alert("<%=mesg%>");
<%}%>


	$(document).ready(function(){
		$("#profile_pt").on("click",function(event){
			$("#View_area").text("");
			$("#img").html(" <div id='View_area' style='position:relative; width:178px; height:210px; color: black; margin:0; border: 0px solid black; dispaly: inline; '></div>");
		});
		
	});


function previewImage(targetObj, View_area) {
	var preview = document.getElementById(View_area); //div id
	var ua = window.navigator.userAgent;

  //ie일때(IE8 이하에서만 작동)
	if (ua.indexOf("MSIE") > -1) {
		targetObj.select();
		try {
			var src = document.selection.createRange().text; // get file full path(IE9, IE10에서 사용 불가)
			var ie_preview_error = document.getElementById("ie_preview_error_" + View_area);


			if (ie_preview_error) {
				preview.removeChild(ie_preview_error); //error가 있으면 delete
			}

			var img = document.getElementById(View_area); //이미지가 뿌려질 곳

			//이미지 로딩, sizingMethod는 div에 맞춰서 사이즈를 자동조절 하는 역할
			img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+src+"', sizingMethod='scale')";
		} catch (e) {
			if (!document.getElementById("ie_preview_error_" + View_area)) {
				var info = document.createElement("<p>");
				info.id = "ie_preview_error_" + View_area;
				info.innerHTML = e.name;
				preview.insertBefore(info, null);
			}
		}
  //ie가 아닐때(크롬, 사파리, FF)
	} else {
		var files = targetObj.files;
		for ( var i = 0; i < files.length; i++) {
			var file = files[i];
			var imageType = /image.*/; //이미지 파일일경우만.. 뿌려준다.
			if (!file.type.match(imageType))
				continue;
			var prevImg = document.getElementById("prev_" + View_area); //이전에 미리보기가 있다면 삭제
			if (prevImg) {
				preview.removeChild(prevImg);
			}
			var img = document.createElement("img"); 
			img.id = "prev_" + View_area;
			img.classList.add("obj");
			img.file = file;
			img.style.width = '178px'; 
			img.style.height = '210px';
			preview.appendChild(img);
			if (window.FileReader) { // FireFox, Chrome, Opera 확인.
				var reader = new FileReader();
				reader.onloadend = (function(aImg) {
					return function(e) {
						aImg.src = e.target.result;
					};
				})(img);
				reader.readAsDataURL(file);
			} else { // safari is not supported FileReader
				//alert('not supported FileReader');
				if (!document.getElementById("sfr_preview_error_"
						+ View_area)) {
					var info = document.createElement("p");
					info.id = "sfr_preview_error_" + View_area;
					info.innerHTML = "not supported FileReader";
					preview.insertBefore(info, null);
				}
			}
		}
	}
}

</script>
<c:set value="${updateForm}" var="update"/>
<center>
<form action="adminUpdateFormSerlvet" method="get">
<table width="1200px" cellspacing="0" cellpadding="0" style="margin-top:80px; margin-bottom:30px;">
<tr>
 <td align="center" valign="center">
 <table cellpadding="0">
 <tr>
 <c:choose>
 	<c:when test="${update.gCode == null }">
 <td rowspan="8" width="178px" height="210px" valign="bottom">
 <div id='View_area' style="position:relative; width:178px; height:210px;
 color: black; margin:0; border: 0px solid black; dispaly: inline; ">이미지</div>
 </td>
  </c:when>
  <c:otherwise>
  <td rowspan="8" width="178px" height="210px" valign="bottom" id="img" >
 <img src="images/${update.gCategory}/${update.gImage}.jpg" width="178px" height="218px">
 <input type="hidden" value="${update.gImage}" name="gImage"></td>
  </c:otherwise>
 </c:choose>
 </td>
 </tr>
 <tr>
 <td align="left" width="80px" height="25px"><span style="font-size:12px;">코드: </span></td>
 <td align="center" width="80px">
 <input type="text" name="gCode" style="font-size:12px;" value="${update.gCode}" size="20"></td>
 </tr>
 <tr>
 <td align="left" width="80px"><span style="font-size:12px;">카테고리: </span></td>
 <td align="center" width="80px">
 <input type="text" name="gCategory" style="font-size:12px;" value="${update.gCategory}" size="20"></td>
 </tr>
 <tr>
  <td align="left" width="80px"><span style="font-size:12px;">상품명: </span></td>
 <td align="center" width="200px">
 <input type="text" name="gName" style="font-size:12px;" value="${update.gName}" size="20"></td>
 </tr>
 <tr>
  <td align="left" width="80px"><span style="font-size:12px;">가격: </span></td>
<td align="center" width="50px">
 <input type="text" name="gPrice" style="font-size:12px;" value="${update.gPrice}" size="20"></td>
</tr>
 <tr>
  <td align="left" width="80px"><span style="font-size:12px;">원산지: </span></td>
<td align="center" width="50px">
<input type="text" name="gCountry" style="font-size:12px;" value="${update.gCountry}" size="20"></td>
</tr>
 <tr>
  <td align="left" width="80px"><span style="font-size:12px;">회사명: </span></td>
<td align="center" width="80px">
<input type="text" name="gCompany" style="font-size:12px;" value="${update.gCompany}" size="20"></td>
</tr>
 <tr>
  <td align="left" width="80px"><span style="font-size:12px;">유통기한: </span></td>
<td align="center" width="80px">
<input type="text" name="gDate" style="font-size:12px;" value="${update.gDate}" size="20"></td>
</tr>
<tr>
<td height="10px">
</td>
</tr>
 <tr>
 <td align="center" width="50px" colspan=2><input type="file" name="profile_pt" id="profile_pt" onchange="previewImage(this,'View_area')"></td>
<td align="center" width="50px"><input type="submit" value="수정" style="font-size:12px;"></td>
 </tr>
 </table>
 </td>
 </tr>
</table>
<c:if test="${update != null}">
 <img src="images/${update.gCategory}_re/${update.gCode}_retrieve.jpg">
 </c:if>
</form>
</center>
