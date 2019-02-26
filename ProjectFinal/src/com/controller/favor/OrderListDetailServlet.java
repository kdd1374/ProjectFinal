package com.controller.favor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.DoneDTO;
import com.dto.MemberDTO;
import com.service.DoneService;

@WebServlet("/OrderListDetailServlet")
public class OrderListDetailServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
	      MemberDTO dto = (MemberDTO)session.getAttribute("logindto");
		 String nextPage = null;
	      if(dto!=null) {
	    	  String userid =dto.getUserid();
	    	  DoneService service = new DoneService();
	    	  List<DoneDTO> list = service.doneList(userid);
	    	  
	    	  request.setAttribute("doneList", list);
				nextPage = "orderListDetail.jsp";
	    	  
	      } else {
		    	  nextPage="orderListDetail.jsp";
				  session.setAttribute("mesg", "비회원 카트리스트입니다.");
				  
			  }
	      RequestDispatcher dis = request.getRequestDispatcher(nextPage);
			dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
