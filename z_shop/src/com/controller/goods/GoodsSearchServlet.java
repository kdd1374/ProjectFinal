package com.controller.goods;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.GoodsDTO;
import com.service.GoodsService;

@WebServlet("/GoodsSearchServlet")
public class GoodsSearchServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String gName = request.getParameter("goodsSearch");
		System.out.println(gName);
		GoodsService ser = new GoodsService();
		HashMap<String, String> map = new HashMap<>();
		map.put("gName", gName);
		List<GoodsDTO> list = ser.goodsSearch(map);
		
		request.setAttribute("goodsList", list);
		RequestDispatcher dis = request.getRequestDispatcher("goodsList.jsp");
		dis.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
