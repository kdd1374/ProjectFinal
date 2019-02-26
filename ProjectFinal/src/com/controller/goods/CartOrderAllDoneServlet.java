package com.controller.goods;

import java.io.IOException;
import java.util.ArrayList;
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
import com.dto.DoneDTO;
import com.dto.MemberDTO;
import com.service.CartService;

/**
 * Servlet implementation class GoodsListServlet
 */
@WebServlet("/CartOrderAllDoneServlet")
public class CartOrderAllDoneServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("logindto");
		String nextPage = null;
		if (dto != null) {
		
			String userid=dto.getUserid();
			String [] gCodes= request.getParameterValues("gCode");
			List<String> list = Arrays.asList(gCodes);
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
			
			CartService cService = new CartService();
			List<CartDTO> cList = cService.orderAllConfirm(list);
			//최종적으로 List<OrderDTO> 에 저장.
			List<DoneDTO> oList = new ArrayList<>();
			
			for(CartDTO cDTO : cList) {
				DoneDTO oDTO = new DoneDTO();
				oDTO.setUserid(userid);
				oDTO.setgCode(cDTO.getgCode());
				oDTO.setUsername(cDTO.getUsername());
				oDTO.setgCategory(cDTO.getgCategory());
				oDTO.setgName(cDTO.getgName());
				oDTO.setgPrice(cDTO.getgPrice());
				oDTO.setgImage(cDTO.getgImage());
				oDTO.setgAmount(cDTO.getgAmount());
				oDTO.setPost(cDTO.getPost());
				oDTO.setAddr1(cDTO.getAddr1());
				oDTO.setAddr2(cDTO.getAddr2());
				oDTO.setPhone(cDTO.getPhone());
				oDTO.setEmail1(cDTO.getEmail1());
				oDTO.setEmail2(cDTO.getEmail2());
				oDTO.setPayMethod(payMethod);
				System.out.println(oDTO);
				oList.add(oDTO);
			}
			
			int n =cService.oderAllDone(oList, list);
			
			request.setAttribute("orderAllDone", oList);
			nextPage = "orderAllDone.jsp";

		} else {
			nextPage = "LoginUIServlet";
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
