package com.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;
@WebServlet("/MemberDelServlet")
public class MemberDelServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("awefojwef");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("logindto");
		String userid = dto.getUserid();
		String mesg = "";
		MemberService ser = new MemberService();
		if(dto.getPasswd().equals(password)) {
			int n = ser.memberDel(userid);
			mesg = "회원탈퇴가 무사히 완료되었습니다";
			session.removeAttribute("logindto");
			session.setAttribute("delmesg", mesg);
			response.sendRedirect("Main");
		}else {
			mesg="비밀번호를 확인해주세요";
			session.setAttribute("delmesg", mesg);
			System.out.println(mesg);
			response.sendRedirect("memberDelForm.jsp");
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
