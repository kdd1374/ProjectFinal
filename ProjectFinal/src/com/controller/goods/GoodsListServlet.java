package com.controller.goods;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.GoodsDTO;
import com.service.GoodsService;

@WebServlet("/GoodsListServlet")
public class GoodsListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cur = request.getParameter("curpage");
		String gCategory = request.getParameter("gCategory");
		GoodsService ser = new GoodsService();
		if(gCategory == null) {
			gCategory = "rice";
		}
		int curpage = 0;
		if(cur ==null) {
			curpage = 1;
		}else {
			curpage = Integer.parseInt(cur);
		}
		int purpage = 12;
		int total = ser.goodsTotal(gCategory)/purpage;
		if(ser.goodsTotal(gCategory)%purpage != 0) {
			total++;
		}
		List<GoodsDTO> list = ser.goodsList(gCategory, curpage, purpage);
		request.setAttribute("goodsTotal", total);
		request.setAttribute("curpage", curpage);
		request.setAttribute("category", gCategory);
		request.setAttribute("goodsList", list);
		RequestDispatcher dis = request.getRequestDispatcher("goodsList.jsp");
		dis.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
