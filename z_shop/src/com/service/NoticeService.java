package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.NoticeDAO;
import com.dto.NoticeDTO;


public class NoticeService {
	public List<NoticeDTO> noticeList(NoticeDTO noticeDto) {
		SqlSession session = MySqlSessionFactory.getSession(); 
		List<NoticeDTO> list = null;
		try {
			NoticeDAO dao = new NoticeDAO();
			list = dao.noticeList(session, noticeDto);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list; 
	}// end noticeService
	
	public int noticeAdd(NoticeDTO noticeDTo) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			NoticeDAO dao = new NoticeDAO();
			n = dao.noticeAdd(session, noticeDTo);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}return n;
	}// end noticeAdd
	
	
	public int noticeDel(int notice_seq) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			NoticeDAO dao = new NoticeDAO();
			n = dao.noticeDel(session, notice_seq);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return n;
	} // end del
	
	
	public NoticeDTO noticeDetail(NoticeDTO noticeDto) {
		SqlSession session = MySqlSessionFactory.getSession(); 
		NoticeDTO noticeDetail = null;
		try {
			NoticeDAO dao = new NoticeDAO();
			noticeDetail = dao.noticeDetail(session, noticeDto);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return noticeDetail; //여기도 마찬가지
	}// end noticeService
	
	public void noticeUpd(NoticeDTO noticedto) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			NoticeDAO dao = new NoticeDAO();
			dao.noticeUpd(session, noticedto);
			session.commit();
		}catch(Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	public List<NoticeDTO> selectAll(int curPage, int purpage) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<NoticeDTO> list = null;
		try {
			NoticeDAO dao = new NoticeDAO();
			list = dao.selectAll(session, curPage, purpage);
		}finally {
			session.close();
		}
		return list;
	}
	
	public int totalRecord() {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			NoticeDAO dao = new NoticeDAO();
			n = dao.totalRecord(session);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return n;
	}
	
	
}// end class
