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


@WebServlet("/NoticeFormServlet")
public class NoticeFormServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession session = request.getSession();
	      MemberDTO dto = (MemberDTO)session.getAttribute("logindto");
	      if(dto!=null && dto.getMas() != null) {
			
			RequestDispatcher dis = request.getRequestDispatcher("noticeAddMove.jsp");
			dis.forward(request, response);
		}else {
			request.setAttribute("mesg", "관리자만 작성 가능합니다");
			RequestDispatcher dis = request.getRequestDispatcher("NoticeServlet");
			dis.forward(request, response);
		}
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
