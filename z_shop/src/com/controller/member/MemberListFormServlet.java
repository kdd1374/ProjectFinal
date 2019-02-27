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
@WebServlet("/MemberListFormServlet")
public class MemberListFormServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String nameOrId = request.getParameter("nameOrId");
		String serch = request.getParameter("serch");
		String cur = request.getParameter("curpage");
		HashMap<String, String> map = new HashMap<>();
		List<MemberDTO> list = null;
		MemberService ser = new MemberService();
		int curpage = 0;
		if(cur ==null) {
			curpage = 1;
		}else {
			curpage = Integer.parseInt(cur);
		}
		int purpage = 10;
		int m = 0;
		if(nameOrId.equals("id")) {
			map.put("userid",serch);
			list = ser.memberListSerch(map,curpage,purpage);
		}else if(nameOrId.equals("name")) {
			map.put("username", serch);
			list=ser.memberListSerch(map,curpage,purpage);
		}
		int total = ser.total(map)/purpage;
		if(ser.total(map)%purpage != 0) {
			total++;
		}
		request.setAttribute("nameOrId", nameOrId);
		request.setAttribute("serch", serch);
		request.setAttribute("curpage", curpage);
		request.setAttribute("total", total);
		request.setAttribute("memberlistdto", list);
		RequestDispatcher dis = request.getRequestDispatcher("memberList.jsp");
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
