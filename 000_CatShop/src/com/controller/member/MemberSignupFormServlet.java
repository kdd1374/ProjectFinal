package com.controller.member;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;

@WebServlet("/MemberSignupFormServlet")
public class MemberSignupFormServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String passwd= request.getParameter("passwd"); 
		String userid = request.getParameter("userid");
		String ssn= request.getParameter("ssn"); 
		String post= request.getParameter("post");
		String addr1= request.getParameter("addr1");
		String addr2= request.getParameter("addr2");
		String phone= request.getParameter("phone");
		String email1= request.getParameter("email1");
		String email2= request.getParameter("email2");
		
		MemberDTO dto = new MemberDTO(userid, passwd, username, ssn, post, addr1, addr2, phone, email1, email2, null);
		MemberService ser = new MemberService();
		int n = 0;
		n = ser.memberSignup(dto);
		
		HttpSession session = request.getSession();
		session.setAttribute("memberSignup", "회원가입성공");
		session.setMaxInactiveInterval(5);
		response.sendRedirect("LoginServlet");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
