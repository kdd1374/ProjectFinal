package com.controller.goods;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.CartDTO;
import com.dto.DoneDTO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.service.CartService;
import com.service.GoodsService;
import com.service.MemberService;

/**
 * Servlet implementation class GoodsListServlet
 */
@WebServlet("/CartOrderDoneServlet")
public class CartOrderDoneServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("logindto");
		String nextPage = null;
		if (dto != null) {
			String userid = dto.getUserid();
			String gCode = request.getParameter("gCode");
			String gCategory = request.getParameter("gCategory");
			String gName = request.getParameter("gName");
			int gPrice = Integer.parseInt(request.getParameter("gPrice"));
			String gImage = request.getParameter("gImage");
			int gAmount = Integer.parseInt(request.getParameter("gAmount"));
			String username = request.getParameter("username");
			String post = request.getParameter("post");
			String addr1 = request.getParameter("addr1");
			String addr2 = request.getParameter("addr2");
			String phone = request.getParameter("phone");
			String email1 = request.getParameter("email1");
			String email2 = request.getParameter("email2");
			String payMethod = request.getParameter("payMethod");
			Date date = (Date) new Date();
			String sysdate = date.toString();
			
		DoneDTO dto2 = 
				new DoneDTO(gCode, gCategory, gName, gPrice, gImage, gAmount, userid, username, post, 
				         addr1, addr2, phone, email1, email2, payMethod, sysdate);

		   CartService cService= new CartService();
		    int n =cService.orderDone(dto2, gCode);
		    
		    request.setAttribute("orderDTO", dto2);
			nextPage = "orderDone.jsp";

		} else {
			nextPage = "LoginServlet";
			session.setAttribute("mesg", "로그인이 필요한 작업입니다.");
		}

		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
