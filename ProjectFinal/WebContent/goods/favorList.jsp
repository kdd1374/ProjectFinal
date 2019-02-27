<%@page import="com.dto.CartDTO"%>
<%@page import="com.dto.GoodsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		//삭제버튼
		$(".delBtn").on("click", function() {
			var gCode = $(this).attr("data-xxx");
			location.href = "FavorDelServlet?gCode=" + gCode;
		});
		
		//주문버튼
		$(".cart").on("click", function() {
			var gCode = $(this).attr("data-xxx");
			location.href = "FavorGoodsCartServlet?gCode=" + gCode;
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
		<td class="td_default" align="center"><strong>상품번호</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>상품정보</strong></td>
		<td class="td_default" align="center"><strong>판매가</strong></td>
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
		<td class="td_default" width="80">${x.gCode}</td>
		<td class="td_default" width="80"><a href="GoodsRetrieveServlet?gCode=${x.gCode}"><img
			src="images/${x.gCategory}/${x.gImage}.jpg" border="0" align="center"
			width="80" /></a></td>
		<td class="td_default" width="300" style='padding-left: 30px'><a href="GoodsRetrieveServlet?gCode=${x.gCode}"> ${x.gName}</a>
	    </td>
		<td class="td_default" align="center" width="110">${x.gPrice}</td>
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
		<td align="center" colspan="5">
			<a class="a_black" href="GoodsListServlet"> 계속 쇼핑하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td height="20">
	</tr>

</table>
