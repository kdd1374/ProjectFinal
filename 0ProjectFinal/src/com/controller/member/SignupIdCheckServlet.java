package com.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.MemberService;

@WebServlet("/SignupIdCheckServlet")
public class SignupIdCheckServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		MemberService ser= new MemberService();
		System.out.println(userid);
		int n = ser.signUpCheck(userid);
		System.out.println(n);
		String mesg = null;
		if(n==0) {
			mesg="사용가능한 아이디입니다";
		}else if(n!=0) {
			mesg="사용 불가능한 아이디입니다";
		}else if(userid==null||userid=="") {
			mesg="아이디를 입력해주세요";
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(mesg);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
