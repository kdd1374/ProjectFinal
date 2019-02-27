<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
MemberDTO dto = (MemberDTO)session.getAttribute("logindto");
%>

   
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	
});
</script>
<style>
 
</style>

<div id="member" style="text-align:center;">
<table width="180px" cellspacing="0" cellpadding="0">
<tr>
<td width="130px" bgcolor="white" align="center">
<input type="text" size="12"
style="font-size:12px; border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px; margin:0; height:20px; margin-right:5px;">
</td>
<td>
<img src="images/search.gif">
</td>
</tr>
</table>
</div>
<div id="menu">
</div>
<div id="notis">
</div>
</div>

</div>

    