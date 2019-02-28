package com.notice;

import java.io.IOException;
import java.io.PrintWriter;
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


@WebServlet("/NoticeServlet")
public class NoticeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		NoticeService noticeService = new NoticeService();
		
		String cur = request.getParameter("curpage");
		int curPage=0;
		int purpage = 10;
		if(cur==null) {
			curPage=1;
		}else {
			curPage=Integer.parseInt(cur);
		}
		NoticeService service = new NoticeService();
		List<NoticeDTO> list = service.selectAll(curPage, purpage);
		int totalCount = service.totalRecord()/purpage;
		
		request.setAttribute("curPage", curPage);
		request.setAttribute("total", totalCount);
		request.setAttribute("noticelist", list); // 그래서 셋어트리뷰트로 담아서 
		RequestDispatcher dis = request.getRequestDispatcher("noticeMove.jsp"); // notice.jsp로 보냄 ㅇㅋ?ㅇㅋ
		dis.forward(request, response);
	}
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
