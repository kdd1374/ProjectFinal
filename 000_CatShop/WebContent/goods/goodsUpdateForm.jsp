<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
</script>
<c:set value="${updateForm}" var="update"/>
<center>
<form action="GoodsUpdateSuccesServlet" method="post">
<table width="1200px" cellspacing="0" cellpadding="0" style="margin-top:20px;">
<tr>
 <td align="center" valign="center">
 <table>
 <tr>
 <td><img src="images/${update.gCategory}/${update.gImage}.jpg" width="53px" height="57px"></td>
 <td width="30px"></td>
 <td align="left" width="80px"><span style="font-size:12px;">${update.gCategory}</span></td>
 <td align="left" width="200px"><span style="font-size:12px;">${update.gName}</span></td>
 <td width="20px"></td>
<td align="right" width="50px"><span style="font-size:12px;">${update.gPrice}원</span></td>
<td align="center" width="50px"><span style="font-size:12px;">${update.gCountry}</span></td>
<td align="right" width="80px"><span style="font-size:12px;">${update.gCompany}</span></td>
<td align="right" width="80px"><span style="font-size:12px;">${update.gDate}</span></td>
<td align="center" width="50px"><input type="submit" value="수정" style="font-size:12px;"></td>
 </tr>
 </table>
 </td>
 </tr>
</table>
</form>
</center>
