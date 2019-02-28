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

import com.dto.MemberDTO;
import com.dto.NoticeDTO;
import com.service.NoticeService;


@WebServlet("/NoticeUpdFormServlet")
public class NoticeUpdSaveServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("logindto");
		String nextPage=null;
		if(dto!=null) {
			NoticeDTO noticedto = new NoticeDTO();
			noticedto.setNotice_seq(Integer.parseInt(request.getParameter("notice_seq")));
			noticedto.setReg_admin(request.getParameter("reg_admin"));
			noticedto.setNotice_title(request.getParameter("notice_title"));
			noticedto.setNotice_contents(request.getParameter("notice_contents"));
			//String reg_datetime = request.getParameter("reg_datetime"); // 아니 이건 sysdate하면 되서 따로 선언안해도됨 ㅋ
			
			int notice_seq = noticedto.getNotice_seq();
			
			NoticeService service = new NoticeService();
			service.noticeUpd(noticedto);
			request.setAttribute("notice_seq", noticedto.getNotice_seq()); // 이건 뭐여 근데 notice_seq는 int 아님? ㅇㅇ 
			
			
			nextPage = "noticeDetailMove.jsp?notice_seq=" + notice_seq;
		}else {
			nextPage = "LoginServlet";
			request.setAttribute("mesg", "로그인이 필요한 작업입니다.");
		}
		  RequestDispatcher dis =
	    		  request.getRequestDispatcher(nextPage);
	      dis.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
