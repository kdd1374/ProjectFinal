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
@WebServlet("/MemberListServlet")
public class MemberListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("logindto");
		MemberService ser = new MemberService();
		String cur = request.getParameter("curpage");
		HashMap<String, String> map = new HashMap<>();
		int curpage=0;
		int purpage = 10;
		if(cur==null) {
			curpage=1;
		}else {
			curpage=Integer.parseInt(cur);
		}
		int total = ser.total(map)/purpage;
		if(total%2 != 0) {
			total++;
		}
		if(dto==null) {
			String mesg = "접속권한이 없습니다.";
			request.setAttribute("loginmesg", mesg);
			RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
			dis.forward(request, response);
		}else {
		List<MemberDTO> mdto = ser.selectAll(curpage, purpage);
		request.setAttribute("curpage", curpage);
		request.setAttribute("total", total);
		request.setAttribute("memberlistdto", mdto);
		RequestDispatcher dis = request.getRequestDispatcher("memberList.jsp");
		dis.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
