<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
</script>

<span style="font-size:15px; margin-bottom:30px;"><b><a href="GoodsListServlet?gCategory=${category}">${category}</a></b></span>
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
<center>
<table width="750px" cellspacing="0" cellpadding="0" style="margin-top:50px;">
<tr>
<c:forEach var="i" items="${goodsList}" varStatus="status">
 <td align="center" valign="top">
 <table>
 <tr>
 <td><a href="GoodsRetrieveServlet?gCode=${i.gCode}"><img src="images/${i.gCategory}/${i.gImage}.jpg" width="178px" height="185px"></a></td>
 </tr>
 <tr>
 <td align="left" width="178px" height="65px" valign="top"><span style="font-size:12px;">${i.gName}</span></td>
 </tr>
 <tr>
<td align="left"><span style="font-size:12px; color:#f0e928"><hr style="margin:0;"><b>${i.gPrice}원</b></span><br></td>
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
 <td colspan="4" align="center">
 <c:forEach var="i" begin="1" end="${goodsTotal}">
 <c:choose>
 <c:when test="${i == curpage}">
 <span style="font-size:12px;"><b>${i}</b>&nbsp;&nbsp;&nbsp;</span>
 </c:when>
 <c:otherwise>
 <span style="font-size:12px;"><b>[ <a href="GoodsListServlet?curpage=${i}&gCategory=${category}">${i}</a> ]</b>&nbsp;&nbsp;&nbsp;</span>
 </c:otherwise>
 </c:choose>
 </c:forEach>
 </td>
 </tr>
</table>
</center>
