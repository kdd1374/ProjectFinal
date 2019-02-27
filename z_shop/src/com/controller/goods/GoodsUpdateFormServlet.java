package com.controller.goods;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.service.GoodsService;

@WebServlet("/GoodsUpdateFormServlet")
public class GoodsUpdateFormServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String gCode=request.getParameter("gCode");
		HttpSession session = request.getSession();
		String ne = request.getParameter("new");
		System.out.println(ne+"\tne");
		if(ne!=null) {
			session.removeAttribute("updateForm");
		}
		MemberDTO dto = (MemberDTO)session.getAttribute("logindto");
		GoodsService ser = new GoodsService();
		GoodsDTO list = null;
		if(dto.getMas()==null) {
			String mesg = "관리자로그인이 필요합니다";
			request.setAttribute("mesg", mesg);
			RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
			dis.forward(request, response);
		}else if(gCode==null) {
		RequestDispatcher dis = request.getRequestDispatcher("goodsUpdateForm.jsp");
		dis.forward(request, response);
		}else {
		list = ser.codeSerch(gCode);
		session.setAttribute("updateForm", list);
		RequestDispatcher dis = request.getRequestDispatcher("goodsUpdateForm.jsp");
		dis.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
