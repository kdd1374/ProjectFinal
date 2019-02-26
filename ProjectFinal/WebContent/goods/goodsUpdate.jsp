<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		$(".update").on("mouseover",function(event){
			$(".update").attr("src","images/update2.gif");
		});
		$(".update").on("mouseout",function(event){
			$(".update").attr("src","images/update.gif");
		});
	});

</script>

<center>
<table width="750px" cellspacing="0" cellpadding="0" style="margin-top:30px;" align="center" >
<tr>
<td align="center" width="60px"><span style="font-size:12px;"><a href="GoodsUpdateServlet">전체보기</a></spna></td>
<td align="center" width="60px"><span style="font-size:12px;"><a href="GoodsUpdateServlet?gCategory=rice">사료</a></spna></td>
<td align="center" width="60px"><span style="font-size:12px;"><a href="GoodsUpdateServlet?gCategory=snack">간식</a></spna></td>
<td align="center" width="60px"><span style="font-size:12px;"><a href="GoodsUpdateServlet?gCategory=tower">캣타워</a></span></spna></td>
<td align="center" width="60px"><span style="font-size:12px;"><a href="GoodsUpdateServlet?gCategory=scratcher">스크래쳐</a></span></spna></td>
<td align="center" width="60px"><span style="font-size:12px;"><a href="GoodsUpdateServlet?gCategory=send">모레</a></spna></td>
<td align="center" width="60px"><span style="font-size:12px;"><a href="GoodsUpdateServlet?gCategory=toy">장난감</a></spna></td>
<td align="center" width="60px"><span style="font-size:12px;"><a href="GoodsUpdateServlet?gCategory=healthy">건강영양제</spna></td>
</tr>
<tr>
<td colspan="8" align="center"><hr></td>
</tr>
</table>
<table width="1200px" cellspacing="0" cellpadding="0" style="margin-top:20px; margin-bottom:30px;">
<tr>
<c:forEach var="i" items="${goodsAll}">
 <td align="center" valign="center">
 <table>
 <tr>
 <td><img src="images/${i.gCategory}/${i.gImage}.jpg" width="53px" height="57px"></td>
 <td width="30px"></td>
 <td align="left" width="80px"><span style="font-size:12px;">${i.gCategory}</span></td>
 <td align="left" width="200px"><span style="font-size:12px;">${i.gName}</span></td>
 <td width="20px"></td>
<td align="right" width="50px"><span style="font-size:12px;">${i.gPrice}원</span></td>
<td align="center" width="50px"><span style="font-size:12px;">${i.gCountry}</span></td>
<td align="right" width="80px"><span style="font-size:12px;">${i.gCompany}</span></td>
<td align="right" width="80px"><span style="font-size:12px;">${i.gDate}</span></td>
<td align="center" width="50px"><button type="button" onclick="location.href='GoodsUpdateFormServlet?gCode=${i.gCode}'">
<span style="font-size:12px;">수정</span></button></td>
<td align="center" width="50px"><button type="button" onclick="location.href='GoodsDelServlet?gCode=${i.gCode}'">
<span style="font-size:12px;">삭제</span></button></td>
 </tr>
 </table>
 </td>
 <c:if test="${status.count%4==0}">
<tr>
<td height="10">
</tr>
</c:if>
 </c:forEach>
 </tr>
  <tr>
 <td colspan="9"><hr width="750px">
 </td></tr>
  <tr>
 <td colspan="9" align="center"><button type="button" onclick="location.href='GoodsUpdateFormServlet?new=new'">
 <span style="font-size:12px;">상품등록</span></button>
 </td></tr>
</table>
</center>
