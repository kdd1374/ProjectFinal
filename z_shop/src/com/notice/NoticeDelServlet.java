package com.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.dto.NoticeDTO;
import com.service.NoticeService;


@WebServlet("/NoticeDelServlet")
public class NoticeDelServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
	      MemberDTO dto = (MemberDTO)session.getAttribute("logindto");
	      System.out.println(dto);
		 String nextPage = null;
	      if(dto!=null) {
	       int notice_seq = Integer.parseInt(request.getParameter("notice_seq"));
	       
	       NoticeService service = new NoticeService();
	       int n = service.noticeDel(notice_seq);
	       
			nextPage = "NoticeServlet";

	      }else {
			  nextPage = "LoginServlet";
			  session.setAttribute("mesg", "로그인이 필요한 작업입니다.");
		  }
		
		 response.sendRedirect(nextPage);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
