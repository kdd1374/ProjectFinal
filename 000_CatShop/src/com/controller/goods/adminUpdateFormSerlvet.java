package com.controller.goods;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.GoodsDTO;
import com.service.GoodsService;


@WebServlet("/adminUpdateFormSerlvet")
public class adminUpdateFormSerlvet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n = 0;
		HttpSession session = request.getSession();
		GoodsService ser = new GoodsService();
		GoodsDTO dto = (GoodsDTO)session.getAttribute("updateForm");
		String ne = request.getParameter("new");
		System.out.println(ne+"\tne");
		if(ne!=null) {
			session.removeAttribute("updateForm");
		}
		if(dto !=null) {
			String gImage = request.getParameter("gImage");
			String gCode = request.getParameter("gCode");
			String gCategory = request.getParameter("gCategory");
			String gName = request.getParameter("gName");
			int gPrice = Integer.parseInt(request.getParameter("gPrice"));
			String gCountry = request.getParameter("gCountry");
			String gCompany = request.getParameter("gCompany");
			String gDate = request.getParameter("gDate");
			if(gDate==null) {
				gDate="";
			}
			GoodsDTO gdto = new GoodsDTO(gCode, gCategory, gName, gPrice, gImage, gCountry, gCompany, gDate);
			n = ser.adminUpdateForm(gdto);
			session.setAttribute("updateForm", gdto);
			response.sendRedirect("goodsUpdateForm.jsp");
		}else {
			String gImage = request.getParameter("gImage");
			String gCode = request.getParameter("gCode");
			String gCategory = request.getParameter("gCategory");
			String gName = request.getParameter("gName");
			int gPrice = Integer.parseInt(request.getParameter("gPrice"));
			String gCountry = request.getParameter("gCountry");
			String gCompany = request.getParameter("gCompany");
			String gDate = request.getParameter("Date");
			GoodsDTO code = ser.codeSerch(gCode);
			if(gCode==null) {
				if(gDate==null) {
					gDate="";
				}
				GoodsDTO gdto = new GoodsDTO(gCode, gCategory, gName, gPrice, gImage, gCountry, gCompany, gDate);
				n = ser.adminInsert(gdto);
				response.sendRedirect("goodsUpdateForm.jsp");
			}else{
				if(gDate==null) {
					gDate="";
				}
				String mesg = "존재하는 상품코드입니다.";
				request.setAttribute("adminMesg", mesg);
				RequestDispatcher dis = request.getRequestDispatcher("GoodsUpdateFormServlet?gCode="+gCode);
				dis.forward(request, response);
			}//gcodoif
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
