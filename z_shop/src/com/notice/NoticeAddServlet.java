package com.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Dispatch;

import com.dto.NoticeDTO;
import com.service.NoticeService;


@WebServlet("/NoticeAddServlet")
public class NoticeAddServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String notice_username = request.getParameter("notice_username"); 
		//int notice_num = (Integer.parseInt(request.getParameter("notice_num")));
		//int notice_seq = (Integer.parseInt(request.getParameter("notice_seq")));
		String notice_title = request.getParameter("notice_title");
		String notice_contents = request.getParameter("notice_contents");
		System.out.println("title"+notice_title);
		int notice_rdcnt = 0; // 처음 등록이니까 조회수는 0
		//String reg_datetime = request.getParameter("reg_datetime");
		String reg_admin = request.getParameter("reg_admin");
		
		// 이거 순서 맞춰라 ㅡ.ㅡㅇㅇ
		NoticeDTO dto = new NoticeDTO();
		dto.setNotice_title(notice_title);
		dto.setNotice_contents(notice_contents);
		dto.setNotice_rdcnt(notice_rdcnt);
		dto.setReg_admin(reg_admin);
		NoticeService service = new NoticeService();
		
		int n = service.noticeAdd(dto); 
		System.out.println("n"+n);
		
		HttpSession session = request.getSession();
		session.setAttribute("noticeAdd", "등록되었습니다");
		
		response.sendRedirect("NoticeServlet");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
