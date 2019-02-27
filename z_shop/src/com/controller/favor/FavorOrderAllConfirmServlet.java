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
import com.service.GoodsService;
import com.service.MemberService;

/**
 * Servlet implementation class GoodsListServlet
 */
@WebServlet("/FavorOrderAllConfirmServlet")
public class FavorOrderAllConfirmServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 HttpSession session = request.getSession();
	      MemberDTO dto = (MemberDTO)session.getAttribute("logindto");
		 String nextPage = null;
	      if(dto!=null) {

	    	String [] data=request.getParameterValues("check");  
	    	List<String> list= Arrays.asList(data);  
	    	CartService cService = new CartService();
	    	List<CartDTO> cList = cService.orderAllConfirm(list);
	    	request.setAttribute("cartList", cList);  
	    	
	    	MemberService mService = new MemberService();
	    	String userid=dto.getUserid();
	    	MemberDTO mDTO = mService.idSerch(userid);
	    	request.setAttribute("memberDTO", mDTO);  
	    	
	    	
			nextPage = "orderAllConfirm.jsp";

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
