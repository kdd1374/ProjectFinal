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
		 
		 $("#favor").on("click",function(){
			   $("form").attr("action","FavorCartServlet");
			   
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

		<table width="750px" cellspacing="0" cellpadding="0"
			style="margin-top: 30px;" align="center">
			<tr>
				<td align="center" width="60px"><span style="font-size: 12px;">사료</spna></td>
				<td align="center" width="60px"><span style="font-size: 12px;">간식</spna></td>
				<td align="center" width="60px"><span style="font-size: 12px;">캣타워</span>
				</spna></td>
				<td align="center" width="60px"><span style="font-size: 12px;">스크래쳐</span>
				</spna></td>
				<td align="center" width="60px"><span style="font-size: 12px;">모래</spna></td>
				<td align="center" width="60px"><span style="font-size: 12px;">장난감</spna></td>
				<td align="center" width="60px"><span style="font-size: 12px;">건강영양제</spna></td>
			</tr>
			<tr>
				<td colspan="7"><hr></td>
			</tr>
		</table>
		<table width="750px" cellspacing="0" cellpadding="0"
			style="margin-top: 20px;" align="center">
			<tr>
				<td height="30">
			</tr>
			<tr>
				<td>
					<table align="center" width="710" cellspacing="0" cellpadding="0"
						border="0" style='margin-left: 30px'>
						<tr>
							<td class="td_default"><font size="5"><b>- 상품 정보
										-</b></font> &nbsp;</td>
						</tr>
						<tr>
							<td height="5"></td>
						</tr>
						<tr>
							<td height="1" colspan="8" bgcolor="CECECE"></td>
						</tr>
						<tr>
							<td height="10"></td>
						</tr>

						<tr>
							<td rowspan="7"><img
								src="images/${goodsRetrieve.gCategory}/${goodsRetrieve.gImage}.jpg"
								border="0" align="center" width="250" /></td>
							<td class="td_title">제품코드</td>
							<td class="td_default" colspan="2" style='padding-left: 30px'>
								<span style="font-size: 16px;">${goodsRetrieve.gCode}
							</td>
						</tr>
						<tr>
							<td class="td_title">상품명</td>
							<th class="td_default" colspan="2" style='padding-left: 30px'>${goodsRetrieve.gName}
							</th>
						</tr>
						<tr>
							<td class="td_title">원산지</td>
							<td class="td_red" colspan="2" style='padding-left: 30px'>
								${goodsRetrieve.gCountry}</td>
						</tr>
						<tr>
							<td class="td_title">제조회사</td>
							<td class="td_red" colspan="2" style='padding-left: 30px'>
								${goodsRetrieve.gCompany}</td>
						</tr>
						<tr>
							<td class="td_title">유통기한</td>
							<td class="td_red" colspan="2" style='padding-left: 30px'>
								${goodsRetrieve.gDate}</td>
						</tr>
						<tr>
							<td class="td_title">금액</td>
							<td class="td_red" colspan="2" style='padding-left: 30px'>
								${goodsRetrieve.gPrice} 원</td>
						</tr>
						<tr>
							<td class="td_title">배송비</td>
							<td colspan="2"><font color="#2e56a9" size="2"
								style='padding-left: 30px'><b> 배송료 : 2500원</b> </font> <font
								size="2">(도서 산간지역 별도 배송비 추가)</font></td>
						</tr>

						<tr>
						
							<td></td>
							<td class="td_title">주문수량</td>
							<td style="padding-left: 30px"><input type="text" name="gAmount" value="${goodsRetrieve.gAmount}" id="gAmount" style="text-align: right; height: 18px" size="3"> 
							<img src="images/up.PNG" id="up"> <img src="images/down.PNG" id="down"></td>
						</tr>
				</table>

			</td>
		</tr>
	</table>

	<br> <button id="buy">구매</button>
	&nbsp;&nbsp;
	<button id="cart">장바구니</button>
	<button id="favor">관심목록</button>
	
</form>
    