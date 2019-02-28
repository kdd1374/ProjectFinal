package com.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.NoticeDTO;
import com.service.NoticeService;


@WebServlet("/NoticeDetailServlet")
public class NoticeDetailServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		NoticeService noticeService = new NoticeService();
		
		NoticeDTO noticeDto = new NoticeDTO();
	
		if(request.getParameter("notice_seq") == null) {
			//예외처리 필요함.
		}else{
			noticeDto.setNotice_seq(Integer.valueOf(request.getParameter("notice_seq"))); // 요거 예외처리해라 여기서예외처리함?
			NoticeDTO noticeDetail = noticeService.noticeDetail(noticeDto); 		
			
			System.out.println(noticeDetail);
			
			request.setAttribute("noticeDetail", noticeDetail); 
		}
		RequestDispatcher dis = request.getRequestDispatcher("noticeDetailMove.jsp");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
