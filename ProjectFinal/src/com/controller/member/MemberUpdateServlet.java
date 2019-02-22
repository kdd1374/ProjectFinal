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
@WebServlet("/MemberUpdateServlet")
public class MemberUpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userid = request.getParameter("id");
		String post = request.getParameter("post");
		String phone = request.getParameter("phone");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String email = request.getParameter("email");
		String ssn = request.getParameter("ssn");
		String [] semail = email.split("@");
		String email1=semail[0];
		String email2=semail[1];
		System.out.println(userid+"\t userid");
		System.out.println(post+"\t post");
		System.out.println(phone+"\t phone");
		System.out.println(addr1+"\t addr1");
		System.out.println(addr2+"\t addr2");
		System.out.println(ssn+"\t ssn");
		System.out.println(email1+"\t email1");
		System.out.println(email2+"\t email2");
		MemberDTO dto = new MemberDTO(userid, ssn, post, addr1, addr2, phone, email1, email2);
		MemberService ser = new MemberService();
		int n = ser.memberUpdate(dto);
		MemberDTO ldto = ser.idSerch(userid);
		if(n == 1) {
			String mesg = "정보가 수정되었습니다.";
			session.setAttribute("logindto", ldto);
			request.setAttribute("upmesg", mesg);
			RequestDispatcher dis = request.getRequestDispatcher("mypage.jsp");
			dis.forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
