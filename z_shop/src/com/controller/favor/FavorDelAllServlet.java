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

import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.service.CartService;
import com.service.FavorService;
import com.service.GoodsService;

/**
 * Servlet implementation class GoodsListServlet
 */
@WebServlet("/FavorDelAllServlet")
public class FavorDelAllServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 HttpSession session = request.getSession();
	      MemberDTO dto = (MemberDTO)session.getAttribute("logindto");
		 String nextPage = null;
	      if(dto!=null) {
	       String [] data = request.getParameterValues("check");
       
	       List<String> list= Arrays.asList(data);
	  
	       FavorService service = new FavorService();
	       int n = service.favorAllDel(list);
	       
			nextPage = "FavorListServlet";

	      }else {
			  nextPage = "LoginUIServlet";
			  session.setAttribute("mesg", "로그인이 필요한 작업입니다.");
		  }
		
		 response.sendRedirect(nextPage);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
