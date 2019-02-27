<%@page import="com.dto.MemberDTO"%>
<%@page import="com.dto.GoodsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   String mesgcart = (String)session.getAttribute("mesgcart");
  if(mesgcart!=null){
%>    
   <script>
     alert('<%=mesgcart %>');
   </script>
<%
  }
  session.removeAttribute("mesgcart");
%>    
<%
	MemberDTO dto = (MemberDTO) session.getAttribute("logindto");
%>

<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#up").on("click", function(e) {
			e.preventDefault();
			var gAmount = $("#gAmount").val();
			gAmount++;
			$("#gAmount").val(gAmount);
		});

		$("#down").on("click", function(e) {
			e.preventDefault();
			var gAmount = $("#gAmount").val();
			gAmount--;
			if (gAmount <= 0) {
				gAmount = 1;
				alert("최소 주문수량은 1개입니다.");
			}
			$("#gAmount").val(gAmount);
		});

		 $("#cart").on("click",function(){
			   $("form").attr("action","GoodsCartServlet");
			   
		   });
		 
	});
</script>
<style>
</style>
<div id="member">

	<form name="goodRetrieveForm" method="GET" action="#">
		<input type="hidden" name="gImage" value="${goodsRetrieve.gImage}">
		<input type="hidden" name="gCode" value="${goodsRetrieve.gCode}">
		<input type="hidden" name="gName" value="${goodsRetrieve.gName}">
		<input type="hidden" name="gPrice" value="${goodsRetrieve.gPrice}">
		<input type="hidden" name="gCategory" value="${goodsRetrieve.gCategory}">
		<span style="font-size: 15px; margin-bottom: 30px;"><b>${category}</b></span>

		
<span style="font-size:15px; margin-bottom:30px;"><b><a href="GoodsListServlet?gCategory=${goodsRetrieve.gCategory}">${goodsRetrieve.gCategory}</a></b></span>
<table width="750px" cellspacing="0" cellpadding="0" style="margin-top:30px;" align="center" >
<tr>
<td align="center" width="60px"><span style="font-size:12px;"><a href="GoodsListServlet?gCategory=rice">사료</a></spna></td>
<td align="center" width="60px"><span style="font-size:12px;"><a href="GoodsListServlet?gCategory=snack">간식</a></spna></td>
<td align="center" width="60px"><span style="font-size:12px;"><a href="GoodsListServlet?gCategory=tower">캣타워</a></span></spna></td>
<td align="center" width="60px"><span style="font-size:12px;"><a href="GoodsListServlet?gCategory=scratcher">스크래쳐</a></span></spna></td>
<td align="center" width="60px"><span style="font-size:12px;"><a href="GoodsListServlet?gCategory=send">모레</a></spna></td>
<td align="center" width="60px"><span style="font-size:12px;"><a href="GoodsListServlet?gCategory=toy">장난감</a></spna></td>
<td align="center" width="60px"><span style="font-size:12px;"><a href="GoodsListServlet?gCategory=healthy">건강영양제</spna></td>
</tr>
<tr>
<td colspan="7"><hr></td>
</tr>
</table>
		<table width="1200px" cellspacing="0" cellpadding="0"
			style="margin-top: 20px;" align="center">
			<tr>
				<td height="30" >
			</tr>
			<tr>
				<td align="center">
					<table align="center" width="750px" cellspacing="0" cellpadding="0"
						 style='margin:0'>
						<tr>
							<td height="20px" colspan="3" align="center">
							 <img src="images/goodsbar.gif">
							</td>
						</tr>
						<tr>
							<td height="20px">
							</td>
						</tr>
						<tr>
							<td height="30px" valign="top" style="font-size:14px;" colspan="3">
							<b>${goodsRetrieve.gName}</b></td>
						</tr>
						<tr>
							<td height="20px" valign="top" style="font-size:14px;" colspan="3"></td>
						</tr>
							
						<tr>
							<td rowspan="8" width="300px"><img
								src="images/${goodsRetrieve.gCategory}/${goodsRetrieve.gImage}.jpg"
								border="0" align="center" width="250" /></td>
						</tr>
						<tr>
							<td class="td_title" width="60px" style="font-size:12px;">원산지</td>
							<td class="td_red" colspan="2" style='padding-left: 30px; font-size:12px;'>
								${goodsRetrieve.gCountry}</td>
						</tr>
						<tr>
							<td class="td_title" width="60px" style="font-size:12px;">제조회사</td>
							<td class="td_red" colspan="2" style='padding-left: 30px; font-size:12px;'>
								${goodsRetrieve.gCompany}</td>
						</tr>
						<tr>
							<td class="td_title"width="60px" style="font-size:12px;">유통기한</td>
							<td class="td_red" colspan="2" style='padding-left: 30px; font-size:12px;'>
								<c:choose>
								 <c:when test="${empty goodsRetrieve.gDate}">
								 <span style="color:red;">유통기한이 없는 제품입니다.</span></td>
								 </c:when>
								 <c:otherwise>
								 ${goodsRetrieve.gDate}</td>
								 </c:otherwise>
								</c:choose>
						</tr>
						<tr>
							<td class="td_title"width="60px" style="font-size:12px;">금액</td>
							<td class="td_red" colspan="2" style='padding-left: 30px; font-size:12px;'>
								${goodsRetrieve.gPrice} 원</td>
						</tr>
						<tr>
							<td height="100px" colspan="2px">
							</td>
						</tr>
						<tr>
							<td colspan="2" align="right"><font color="#2e56a9" size="2"
								style='padding-left: 30px'><b> 배송료 : 2500원</b> </font> <font
								size="2">(도서 산간지역 별도 배송비 추가)</font></td>
						</tr>

						<tr>
							<td class="td_title" align="right" colspan="2" style="font-size:12px;">주문수량&nbsp;
							<input type="text" name="gAmount" value="${goodsRetrieve.gAmount}" id="gAmount" style="text-align: right; height: 18px" size="3"> 
							<img src="images/up.PNG" id="up"> <img src="images/down.PNG" id="down"></td>
						</tr>
				</table>

			</td>
		</tr>
	</table>

	<br> <button id="buy">구매</button>
	&nbsp;&nbsp;
	<button id="cart">장바구니</button><br><br>
	<img src="images/goodsbar.gif">
</form>
    