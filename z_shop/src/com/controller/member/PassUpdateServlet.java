package com.controller.member;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;

@WebServlet("/PassUpdateServlet")
public class PassUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		HashMap<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("passwd", password);
		System.out.println(map);
		MemberService ser = new MemberService();
		int n = ser.passwordUpdate(map);
		request.setAttribute("passmesg", "비밀번호가 변경되었습니다.");
		
		
		RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
		dis.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
