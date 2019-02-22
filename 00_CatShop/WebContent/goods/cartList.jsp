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
			var num = $(this).attr("data-xxx");
			var gAmount = $("#cartAmount" + num).val();
			var gPrice = $(this).attr("data-price");
			$.ajax({
				url : 'CartUpdateServlet',
				type : 'get',
				dataType : 'text',
				data : {
					num : num,
					gAmount : gAmount
				},
				success : function(data, status, xhr) {
					var sum = gAmount * gPrice;
					$("#sum" + num).text(sum);
				},
				error : function(xhr, status, error) {

				}
			});//end ajaxgkgk

		});

		//삭제버튼
		$(".delBtn").on("click", function() {
			var num = $(this).attr("data-xxx");
			location.href = "CartDelServlet?num=" + num;
			location.href = "GoodsCartServlet?num=" + num;
		});

		//전체선택
		$("#allCheck").on("click", function() {
			var result = this.checked;
			$(".check").each(function(idx, data) {
				this.checked = result;
			});
		});

		//전체cart 삭제
		$("#delAllCart").on("click", function() {
			var num = [];
			$("input:checkbox[name='check']:checked").each(function(idx, ele) {
				num[idx] = $(this).val();
			});
			console.log(num);
			location.href = "CartDelAllServlet?data=" + num;
		});
		//전체cart 삭제
		$("#delAllCart2").on("click", function() {

			$("form").attr("action", "CartDelAllServlet2");
			$("form").submit();// trigger
		});

		//주문버튼
		$(".orderBtn").on("click", function() {
			var num = $(this).attr("data-xxx");
			location.href = "CartOrderConfirmServlet?num=" + num;
		});
		//전체주문버튼
		$("#orderAllConfirm").on("click", function() {
			$("form").attr("action","CartOrderAllConfirmServlet");
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
			size="5"><b>- 장바구니-</b></font> &nbsp;
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
		<td class="td_default" align="center"><strong>주문번호</strong></td>
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

<c:forEach var="x" items="${cartList}" varStatus="status">



		<!-- <input type="text" name="num81" value="81" id="num81">
		<input type="text" name="gImage81" value="bottom1" id="gImage81">
		 <input type="text" name="gName81" value="제나 레이스 스커트" id="gName81">
		  <input type="text" name="gSize81" value="L" id="gSize81">
		   <inputsp type="text" name="gColor81" value="navy" id="gColor81"> 
		   <input type="text" name="gPrice81" value="9800" id="gPrice81"> -->
	<tr>
		<td class="td_default" width="80">
			<!-- checkbox는 체크된 값만 서블릿으로 넘어간다. 따라서 value에 삭제할 num값을 설정한다. --> <input
			type="checkbox" name="check" id="check81" class="check"
			value="${x.num}">
		</td>
		<td class="td_default" width="80">${x.num}</td>
		<td class="td_default" width="80"><img
			src="images/${x.gCategory}/${x.gImage}.jpg" border="0" align="center"
			width="80" /></td>
		<td class="td_default" width="300" style='padding-left: 30px'>${x.gName}
	    </td>
		<td class="td_default" align="center" width="110">${x.gPrice}</td>
		<td class="td_default" align="center" width="90"><input
			class="input_default" type="text" name="cartAmount"
			id="cartAmount${x.num}" style="text-align: right" maxlength="3"
			size="2" value="${x.gAmount}"></input></td>
		<td><input type="button" value="수정" class="updateBtn"
			data-xxx="${x.num}" data-price="${x.gPrice}"></td>
		<td class="td_default" align="center" width="80"
			style='padding-left: 5px'><span id="sum${x.num}">${x.gPrice*x.gAmount}
		</span></td>
		<td><input type="button" value="주문" class="orderBtn"
			data-xxx="${x.num}"``></td>
		<td class="td_default" align="center" width="30"
			style='padding-left: 10px'><input type="button" value="삭제"
			id="xx${status.count}" class="delBtn" data-xxx="${x.num}"></td>
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
		<td align="center" colspan="5"><a class="a_black" id="orderAllConfirm"> 전체 주문하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="a_black" href="#" id="delAllCart"> 전체 삭제하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="a_black" href="#" id="delAllCart2"> 전체 삭제하기2 </a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="a_black" href="index.jsp"> 계속 쇼핑하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td height="20">
	</tr>

</table>
