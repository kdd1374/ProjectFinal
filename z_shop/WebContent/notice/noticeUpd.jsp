<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
 
<html>
<head>
    <title>글 상세보기</title>
    
    <style type="text/css">
        #wrap {
            width: 800px;
            margin: 0 auto 0 auto;
        }
    
        #detailBoard{
            text-align :center;
        }
        
        #title{
            height : 16;
            font-family :'돋움';
            font-size : 12;
            text-align :center;
        }
    </style>
</head>
<script>
function moveList(){
	var frm = document.notice;
	frm.action = '/z_shop/NoticeServlet';
	frm.submit();
}

function updSave(){
	var frm2 = document.notice;
	frm2.action = '/z_shop/NoticeUpdFormServlet';
	frm2.submit();
}
</script>
<body>

<div id="wrap">
    <br><br>
    <form id="notice" name="notice" action="/z_shop/NoticeServlet">
    	<input type="hidden" id="notice_seq" name="notice_seq" value="${noticeDetail.notice_seq }"/>
    <div id="board">
        <table id="detailBoard" width="800" border="3" bordercolor="lightgray">
        <tr>
                <td id="title">조회수</td>
                <td>${noticeDetail.notice_rdcnt}</td>
            </tr>
            <tr>
                <td id="title">작성일</td>
                <td>${noticeDetail.reg_datetime}</td>
            </tr>
            <tr>
                <td id="title">작성자</td>
                <td><input type="text" name="reg_admin" id="reg_admin" value="${noticeDetail.reg_admin}"/></td>
            </tr>
            <tr>
            
                <td id="title">
                  	  제 목
                </td>
                <td>
                    <input type="text" name="notice_title" id="notice_title" value="${noticeDetail.notice_title}"/>
                </td>        
            </tr>
            <tr>
                <td id="title">
                    	내 용
                </td>
                <td>
                 <textarea rows="40" cols="100" name="notice_contents" id="notice_contents">${noticeDetail.notice_contents}</textarea>
                </td>        
            </tr>
            <tr>
                <td id="title">
                    <%-- 첨부파일
                </td>
                <td>
                    <a href='FileDownloadAction.bo?file_name=${notice.board_file}'>${notice.board_file}</a>
                </td>     --%>
            </tr>
    
            <tr align="center" valign="middle">
                <td colspan="5">
                    <input type="button" onclick="javascript:updSave();" value="수정" >                    
                    <input type="button" onclick="javascript:moveList();" value="목록" >
                </td>
            </tr>
        </table>
    </div>
    </form>
</div>    
 
</body>
</html>
