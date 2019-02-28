<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<script>
function moveDetail(notice_seq){
	var varForm = document.frm;
	varForm.notice_seq.value = notice_seq;
	
	var url = '/z_shop/NoticeDetailServlet';
	varForm.action = url; 
	varForm.submit();
}

function moveReg(){
	location.href= '/z_shop/NoticeFormServlet';
}
</script>
<body>

<form id="frm" name="frm" method="POST">
	<input type="hidden" id="notice_seq" name="notice_seq" value=""/>
</form>
<span style="font-size:14px"><b>공지사항</b></span><br>
<span style="font-size:10px; color:red;">각종이벤트 및 공지사항을 확인해주세요</span><br>
<table style="border:1px solid #fffb8b; margin-top:30px;" align="center" cellspacing="0" cellpadding="0" width="750px">
    <colgroup>
        <col width="10%"/>
        <col width="*"/>
        <col width="15%"/>
        <col width="20%"/>
    </colgroup>
    <thead>
        <tr>
<<<<<<< HEAD
          
            <th scope="col" width="10%">글번호</th>
            <th scope="col" width="10%">제목</th>
            <th scope="col" width="10%">내용</th>
            <th scope="col" width="10%">조회수</th>
            <th scope="col" width="10%">작성일</th>
            <th scope="col" width="10%">작성자</th>
=======
            <th scope="col" height="25px" width="10%" bgcolor="#fffb8b" style="font-size:12px;">글번호</th>
            <th scope="col" height="25px" width="10%" bgcolor="#fffb8b" style="font-size:12px;">제목</th>
            <th scope="col" height="25px" width="10%" bgcolor="#fffb8b" style="font-size:12px;">내용</th>
            <th scope="col" height="25px" width="10%" bgcolor="#fffb8b" style="font-size:12px;">조회수</th>
            <th scope="col" height="25px" width="10%" bgcolor="#fffb8b" style="font-size:12px;">작성일</th>
            <th scope="col" height="25px" width="10%" bgcolor="#fffb8b" style="font-size:12px;">작성자</th>
>>>>>>> branch 'master' of https://github.com/kdd1374/ProjectFinal.git
            
        </tr>
    </thead>
    <tbody>
        <c:choose>
            <c:when test="${fn:length(noticelist) > 0}">
                <c:forEach var="list" items="${noticelist}" varStatus="status">
                    <tr> 
<<<<<<< HEAD
                        
                        <td>${list.notice_seq}</td>
                        <td><a href="javascript:;" onclick="javascript:moveDetail('${list.notice_seq}');">${list.notice_title}</a></td>
                        <td>${list.notice_contents}</td>
                        <td>${list.notice_rdcnt}</td>
                        <td>${list.reg_datetime}</td>
                        <td>${list.reg_admin}</td>
=======
                        <td style="font-size:12px;">${list.notice_seq}</td>
                        <td style="font-size:12px;"><a href="javascript:;" onclick="javascript:moveDetail('${list.notice_seq}');">${list.notice_title}</a></td>
                        <td style="font-size:12px;">${list.notice_contents}</td>
                        <td style="font-size:12px;">${list.notice_rdcnt}</td>
                        <td style="font-size:12px;">${list.reg_datetime}</td>
                        <td style="font-size:12px;">${list.reg_admin}</td>
>>>>>>> branch 'master' of https://github.com/kdd1374/ProjectFinal.git
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="4">조회된 결과가 없습니다.</td>
                </tr>
            </c:otherwise>
        </c:choose>
        <tr>
        <td colspan="7" align="center">
        <c:forEach var="i" begin="1" end="${total}">
        <c:choose>
        <c:when test="${curPage == i}">
        ${i}&nbsp;&nbsp;
        </c:when>
        <c:otherwise>
        <a href="NoticeServlet?curpage=${i}">${i}&nbsp;&nbsp;</a>
        </c:otherwise>
        </c:choose>
        </c:forEach>
        </td>
        </tr>
    </tbody>
    
</table>
<input type="button" onclick="javascript:moveReg();" value="글쓰기" />
    <form>
     <div id="searchForm">
        <form>
            <select name="opt">
                <option value="0">제목</option>
                <option value="1">내용</option>
                <option value="2">제목+내용</option>
                <option value="3">글쓴이</option>
            </select>
            <input type="text" size="20" name="condition"/>&nbsp;
            <input type="submit" value="검색"/>
        </form>    
    </div>
    </form>


<!-- <a href='DeptServlet?curPage="+i+"'>" + i + "</a>&nbsp;&nbsp;  -->
</body>
</html>