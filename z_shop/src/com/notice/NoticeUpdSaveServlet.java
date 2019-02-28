package com.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Dispatch;

import com.dto.MemberDTO;
import com.dto.NoticeDTO;
import com.service.NoticeService;


@WebServlet("/NoticeUpdFormServlet")
public class NoticeUpdSaveServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("logindto");
		String nextPage=null;
		if(dto!=null) {
			NoticeDTO noticedto = new NoticeDTO();
			String notice_seq = request.getParameter("notice_seq");
			String reg_admin = request.getParameter("reg_admin");
			String notice_title = request.getParameter("notice_title");
			String notice_contents = request.getParameter("notice_contents");
			String reg_datetime = request.getParameter("reg_datetime");
			
			System.out.println(notice_seq + reg_admin + notice_title + notice_contents + reg_datetime);
			
			
			
			NoticeService service = new NoticeService();
			
			System.out.println(noticedto);
			int n = service.noticeUpd(noticedto);
			
			
			nextPage = "noticeDetailMove.jsp?notice_seq=" + notice_seq;
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
