package com.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.dto.NoticeDTO;
import com.service.MemberService;
import com.service.NoticeService;


@WebServlet("/NoticeUpdServlet")
public class NoticeUpdServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("logindto");
		String nextPage=null;
		if(dto!=null) {
			if(request.getParameter("notice_seq") == null) {
				//예외처리 필요함.
			}else{
				NoticeService service = new NoticeService();
				NoticeDTO noticeDto = new NoticeDTO();
				noticeDto.setNotice_seq(Integer.valueOf(request.getParameter("notice_seq"))); // 요거 예외처리
				NoticeDTO noticeDetail = service.noticeDetail(noticeDto); 		
				
				request.setAttribute("noticeDetail", noticeDetail); 
			}
			
			nextPage = "noticeUpdMove.jsp";	// 여기에 수정 페이지 하나 만들어야함
		}else {
			nextPage = "LoginServlet";
			request.setAttribute("mesg", "로그인이 필요한 작업입니다.");
		}
		  RequestDispatcher dis =
	    		  request.getRequestDispatcher(nextPage);
	      dis.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
