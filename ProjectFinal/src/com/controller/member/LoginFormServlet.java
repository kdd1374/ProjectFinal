package com.controller.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;


@WebServlet("/LoginFormServlet")
public class LoginFormServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid= request.getParameter("userid");
		String password= request.getParameter("password");
		String mesg = null;
		HashMap<String, Object> map = new HashMap<>();
		MemberService ser = new MemberService();
		map.put("userid", userid);
		map.put("passwd",password);
		MemberDTO mdto = ser.idCheck(map);
		HttpSession session = request.getSession();
		
			if(mdto ==null) {
				mesg="회원정보가 틀렸습니다.";
				request.setAttribute("mesg", mesg);
				RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
				dis.forward(request, response);
			}else {
				session.setAttribute("logindto", mdto);
				response.sendRedirect("Main");
			}
		
	
		
		
		
		}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
