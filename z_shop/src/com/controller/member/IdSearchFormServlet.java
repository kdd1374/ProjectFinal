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

@WebServlet("/IdSearchFormServlet")
public class IdSearchFormServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username=request.getParameter("username");
		String email = request.getParameter("email");
		MemberDTO dto = null;
		MemberService ser = new MemberService();
		String page = "";
		try {
		String [] e = email.split("@");
		String email1= e[0];
		String email2= e[1];
		HashMap<String, String> map = new HashMap<>();
		map.put("username", username);
		map.put("email1", email1);
		map.put("email2", email2);
		System.out.println(map);
		dto = ser.idSearch(map);
		System.out.println(dto);
		if(dto == null) {
			String mesg = "존재하지 않는 회원정보입니다.";
			session.setAttribute("searchmesg", mesg);
			page = "idsearch.jsp";
		}else {
			String userid = dto.getUserid();
			System.out.println(userid);
			session.setAttribute("findId", userid);
			page = "FindIdServlet";
		}
		}catch(ArrayIndexOutOfBoundsException e) {
			String mesg = "존재하지 않는 회원정보입니다.";
			session.setAttribute("searchmesg", mesg);
			page = "idsearch.jsp";
		}
		response.sendRedirect(page);
		}
      
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
