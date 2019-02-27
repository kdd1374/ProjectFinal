package com.controller.favor;

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

import com.dto.CartDTO;
import com.dto.FavorDTO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.service.CartService;
import com.service.FavorService;
import com.service.GoodsService;
import com.service.MemberService;

/**
 * Servlet implementation class GoodsListServlet
 */
@WebServlet("/FavorCartServlet")
public class FavorCartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
	      MemberDTO dto = (MemberDTO)session.getAttribute("logindto");
	      String mesg= "";
		 String nextPage = null;
	      if(dto!=null) {
	  		String gCode = request.getParameter("gCode");
	  		String gCategory = request.getParameter("gCategory");
	  		String gName = request.getParameter("gName");
	  		int gPrice = Integer.parseInt(request.getParameter("gPrice"));
	    	String gImage = request.getParameter("gImage");
	  		int gAmount = Integer.parseInt(request.getParameter("gAmount"));
	  		String username = dto.getUsername();
	  		String post = dto.getPost();
	  		String addr1 = dto.getAddr1();
	  		String addr2 = dto.getAddr2();
	  		String phone = dto.getPhone();
	  		String email1 = dto.getEmail1();
	  		String email2 = dto.getEmail2();
	  		String userid=dto.getUserid();
	  		
	         
	  		FavorDTO xx  = new FavorDTO();
            
            FavorService service =new FavorService();
	        List<FavorDTO> list = service.retrieveFavor(gCode);//카트리스트의 코드값
	        
	        
            if(list.size()!=0 && gCode.equals(list.get(0).getgCode())) {
            	
     	       String n = service.favorDel(gCode);
   			session.setAttribute("mesgcart",gCode+" Favor삭제" );
    		    
            }else if(list.size() ==0 ){
    	  		xx.setgAmount(gAmount);
    	  		xx.setgCode(gCode);
    	  		xx.setgCategory(gCategory);
    	  		xx.setgName(gName);
    	  		xx.setgPrice(gPrice);
    	  		xx.setgImage(gImage);
    	  		xx.setUsername(username);
    	  		xx.setPost(post);
    	  		xx.setAddr1(addr1);
    	  		xx.setAddr2(addr2);
    	  		xx.setPhone(phone);
    	  		xx.setEmail1(email1);
    	  		xx.setEmail2(email2);
                xx.setUserid(userid);
    	  		int n=service.favorAdd(xx);
    			session.setAttribute("mesgcart",gCode+" Favor저장성공" );
            }
	        
	  		
			nextPage = "GoodsRetrieveServlet?gCode="+gCode;
	      }else {
	    	  
			  nextPage = "LoginUIServlet";
			  session.setAttribute("mesgcart", "로그인이 필요한 작업입니다.");
		  }
	     
	    response.sendRedirect(nextPage);
	/*	RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);*/
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
