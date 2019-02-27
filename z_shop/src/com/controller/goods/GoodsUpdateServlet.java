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

@WebServlet("/GoodsUpdateServlet")
public class GoodsUpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gCategory=request.getParameter("gCategory");
		String cur = request.getParameter("curpage");
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("logindto");
		GoodsService ser = new GoodsService();
		List<GoodsDTO> list = null;
		int curpage = 0;
		if(cur ==null) {
			curpage = 1;
		}else {
			curpage = Integer.parseInt(cur);
		}
		int purpage = 20;
		int total = ser.goodsTotal(gCategory)/purpage;
		if(ser.goodsTotal(gCategory)%purpage != 0) {
			total++;
		}
		if(dto==null) {
			String mesg = "관리자로그인이 필요합니다";
			request.setAttribute("mesg", mesg);
			RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
			dis.forward(request, response);
		}else if(gCategory==null) {
		list = ser.goodsAll();
		request.setAttribute("goodsAll", list);
		RequestDispatcher dis = request.getRequestDispatcher("goodsUpdate.jsp");
		dis.forward(request, response);
		}else {
		list = ser.goodsList(gCategory, curpage, purpage);
		request.setAttribute("goodsAll", list);
		RequestDispatcher dis = request.getRequestDispatcher("goodsUpdate.jsp");
		dis.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
