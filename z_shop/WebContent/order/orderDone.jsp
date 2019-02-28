
<%@page import="com.dto.MemberDTO"%>
<%@page import="com.dto.CartDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script>
$(document).ready(function(){
	
		
});
</script>
<table width="750px" cellspacing="0" cellpadding="0" align="center">

	<tr>
		<td height="30">
	</tr>

	<tr>
		<td><h2>주문완료</h2></td>
	</tr>

	<tr>
		<td height="20">
	</tr>

	<tr>
		<td align="center"><b>주문해주셔서 감사합니다.</b></td>
	</tr>

	<tr>
		<td height="7">
	</tr>

	<tr>
		<td class="td_default" align="center"><b>${orderDTO.userid }</b> 님의 주문이
			안전하게 처리되었습니다.</td>
	</tr>

	<tr>
		<td height="40">
	</tr>

	<tr>
		<td class="td_default"><b>상품 및 배송정보</b>
		</td>
	</tr>

	<tr>
		<td height="15">
	</tr>

	<tr>
		<td>
			<table width="750px" border="1" style="border-collapse: collapse"
				bordercolor="#fffb8b">
				<tr>
					<td class="td_default" width="150" height="35" bgcolor="#fffb8b"> 받으시는 분</td>
					<td class="td_default" height="35" align="left">&nbsp;&nbsp; ${orderDTO.username }</td>
				</tr>
				<tr>
					<td class="td_default" height="35" bgcolor="#fffb8b"> 주소</td>
					<td class="td_default" height="35" align="left">&nbsp;&nbsp; (${orderDTO.post })&nbsp;&nbsp;
						${orderDTO.addr1 }<br>&nbsp;&nbsp;&nbsp;${orderDTO.addr2 }
					</td>
				</tr>
				
				<tr>
					<td class="td_default" height="35" bgcolor="#fffb8b"> 휴대전화</td>
					<td class="td_default" height="35" align="left">&nbsp;&nbsp; ${orderDTO.phone }</td>
				</tr>
			</table>
	</tr>
	</td>

	<tr>
		<td height="20">
	</tr>

	<tr>
		<td>
			<table width="100%" border="1" style="border-collapse: collapse"
				bordercolor="#fffb8b">
				<tr>
					<td width="250" class="td_default" height="35" align="center" bgcolor="#fffb8b"><strong>상품명</strong></td>
					<td width="100" class="td_default" height="35" align="center" bgcolor="#fffb8b"><strong>판매가</strong></td>
					<td class="td_default" width="50" height="35" align="center" bgcolor="#fffb8b"><strong>수량</strong></td>
					<td class="td_default" width="100" height="35" align="center" bgcolor="#fffb8b"><strong>합계</strong></td>
				</tr>

				
				
				<tr>
					<td height="35" class="td_default">
						<span class="a_default">${orderDTO.gName }</span>
					</td>
					<td height="35" class="td_default" align="center">
						<span  id = "price1">${orderDTO.gPrice }</span>원
					</td>
					<td height="35" class="td_default" align="center">
						<span id = "num1">${orderDTO.gAmount }</span>개
					</td>
					<td height="35" class="td_default" align="center">
						<span>${orderDTO.userid }</span>원
					</td>
				</tr>
				
				

			</table>
		</td>
	</tr>

	<tr>
		<td height="40">
	</tr>

	<tr>
		<td class="td_default"><b>결제정보</b></td>
	</tr>

	<tr>
		<td height="15">
	</tr>

	<tr>
		<td>
			<table width="70%" border="1" style="border-collapse: collapse"
				bordercolor="#fffb8b" align="center">
				<tr>
					<td class="td_default" width="150" height="35" bgcolor="#fffb8b"> 결제금액</td>
					<td class="td_default" height="35" align="right">
					<input type = 'text' id = 'total' value = '${orderDTO.gPrice*orderDTO.gAmount+2500 }' readonly>원
					&nbsp;</td>
				</tr>
				<tr>
					<td class="td_default" width="150" height="35" bgcolor="#fffb8b"> 결제수단</td>
					<td class="td_default" height="35" align="right">
					<span>${orderDTO.payMethod }</span>
					&nbsp;</td>
				</tr>
			</table>
		</td>
	</tr>

	<tr>
		<td height="40">
	</tr>

	

	<tr>
		<td height="20">
	</tr>

	<tr>
		<td class="td_default" align="center"><a class="a_default"
			href="OrderListDetailServlet?mem_id=guest">주문조회 페이지로 이동</a></td>
	</tr>

	<tr>
		<td height="30">
	</tr>

</table>
