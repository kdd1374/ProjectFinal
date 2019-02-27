<%@page import="com.dto.CartDTO"%>
<%@page import="com.dto.GoodsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		//수정버튼
		$(".updateBtn").on("click", function() {
			var gCode = $(this).attr("data-xxx");
			var gAmount = $("#cartAmount" + gCode).val();
			var gPrice = $(this).attr("data-price");
			$.ajax({
				url : 'FavorUpdateServlet',
				type : 'get',
				dataType : 'text',
				data : {
					gCode : gCode,
					gAmount : gAmount
				},
				success : function(data, status, xhr) {
					var sum = gAmount * gPrice;
					$("#sum" + gCode).text(sum);
				},
				error : function(xhr, status, error) {

				}
			});//end ajaxgkgk

		});

		//삭제버튼
		$(".delBtn").on("click", function() {
			var gCode = $(this).attr("data-xxx");
			location.href = "FavorDelServlet?gCode=" + gCode;
		});

		//전체선택
		$("#allCheck").on("click", function() {
			var result = this.checked;
			$(".check").each(function(idx, data) {
				this.checked = result;
			});
		});

		//전체cart 삭제
		/* $("#delAllCart").on("click", function() {
			var num = [];
			$("input:checkbox[name='check']:checked").each(function(idx, ele) {
				gCode[idx] = $(this).val();
			});
			console.log(gCode);
			location.href = "CartDelAllServlet?data=" + gCode;
		}); */
		//전체cart 삭제
		$("#delAllCart").on("click", function() {
			if($(".check").is(":checked")==false){
				alert("삭제 할 상품을 선택해 주세요");
				return false;
			}
			$("form").attr("action", "FavorDelAllServlet");
			$("form").submit();// trigger
		});

		//주문버튼
		$(".orderBtn").on("click", function() {
			var gCode = $(this).attr("data-xxx");
			location.href = "FavorOrderConfirmServlet?gCode=" + gCode;
		});
		//전체주문버튼
		$("#orderAllConfirm").on("click", function() {
			if($(".check").is(":checked")==false){
				alert("주문 할 상품을 선택해 주세요");
				return false;
			}
			$("form").attr("action","FavorOrderAllConfirmServlet");
			$("form").submit();//trigger
		});
	});
</script>
<table width="750px" cellspacing="0" cellpadding="0" border="0" align="center">

	<tr>
		<td height="30">
	</tr>

	<tr>
		<td colspan="5" class="td_default">&nbsp;&nbsp;&nbsp; <font
			size="5"><b>- 관심목록 -</b></font> &nbsp;
		</td>
	</tr>

	<tr>
		<td height="15">
	</tr>

	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>

	<tr>
		<td height="7">
	</tr>

	<tr>
		<td class="td_default" align="center"><input type="checkbox"
			name="allCheck" id="allCheck"> <strong>전체선택</strong></td>
		<td class="td_default" align="center"><strong>상품번호</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>상품정보</strong></td>
		<td class="td_default" align="center"><strong>판매가</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>수량</strong></td>
		<td class="td_default" align="center"><strong>합계</strong></td>
		<td></td>
	</tr>

	<tr>
		<td height="7">
	</tr>



	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>



	<form name="myForm">


<c:forEach var="x" items="${favorList}" varStatus="status">


	<tr>
		<td class="td_default" width="80">
			<!-- checkbox는 체크된 값만 서블릿으로 넘어간다. 따라서 value에 삭제할 num값을 설정한다. --> <input
			type="checkbox" name="check" id="check81" class="check"
			value="${x.gCode}">
		</td>
		<td class="td_default" width="80">${x.gCode}</td>
		<td class="td_default" width="80"><img
			src="images/${x.gCategory}/${x.gImage}.jpg" border="0" align="center"
			width="80" /></td>
		<td class="td_default" width="300" style='padding-left: 30px'>${x.gName}
	    </td>
		<td class="td_default" align="center" width="110">${x.gPrice}</td>
		<td class="td_default" align="center" width="90"><input
			class="input_default" type="text" name="cartAmount"
			id="cartAmount${x.gCode}" style="text-align: right" maxlength="3"
			size="2" value="${x.gAmount}"></input></td>
		<td><input type="button" value="수정" class="updateBtn"
			data-xxx="${x.gCode}" data-price="${x.gPrice}"></td>
		<td class="td_default" align="center" width="80"
			style='padding-left: 5px'><span id="sum${x.gCode}">${x.gPrice*x.gAmount}
		</span></td>
		<td><input type="button" value="주문" class="orderBtn" data-xxx="${x.gCode}"></td>
		<td class="td_default" align="center" width="30"
			style='padding-left: 10px'><input type="button" value="삭제"
			id="xx${status.count}" class="delBtn" data-xxx="${x.gCode}"></td>
		<td height="10"></td>
	</tr>

</c:forEach>

	</form>
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>
	<tr>
		<td height="30">
	</tr>

	<tr>
		<td align="center" colspan="5"><a class="a_black" id="orderAllConfirm"> 선택한 상품 주문 </a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="a_black" href="#" id="delAllCart"> 선택한 상품 삭제 </a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="a_black" href="GoodsListServlet"> 계속 쇼핑하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td height="20">
	</tr>

</table>
