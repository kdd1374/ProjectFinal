package com.controller.favor;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.FavorDTO;
import com.dto.MemberDTO;
import com.service.FavorService;

/**
 * Servlet implementation class GoodsListServlet
 */
@WebServlet("/FavorOrderConfirmServlet")
public class FavorOrderConfirmServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 HttpSession session = request.getSession();
	      MemberDTO dto = (MemberDTO)session.getAttribute("logindto");
		 String nextPage = null;
	      if(dto!=null) {

	    	  String gCode = request.getParameter("gCode");//CartDTO
	    	  FavorService service = new FavorService();
	    	  List<FavorDTO> list = service.retrieveFavor(gCode);
	    	  
	    	  request.setAttribute("cList", list);
	       
			nextPage = "orderConfirm.jsp";

	      }else {
			  nextPage = "LoginUIServlet";
			  session.setAttribute("mesg", "로그인이 필요한 작업입니다.");
		  }
		
	  	RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
