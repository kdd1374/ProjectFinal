package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.CartDAO;
import com.dao.DoneDAO;
import com.dto.CartDTO;
import com.dto.DoneDTO;

public class DoneService {
	
	public int doneAllDel(List<String> list) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			DoneDAO dao = new DoneDAO();
			n = dao.doneAllDel(session, list);
			session.commit();
		} catch(Exception e){
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return n;
	}// end deleteAll
	
	public DoneDTO donebygCode( String gCode) {
		SqlSession session = MySqlSessionFactory.getSession();
		DoneDTO cdto = null;
		try {
			DoneDAO dao = new DoneDAO();
			 cdto = dao.donebygCode(session, gCode);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cdto;
	}//end idCheck
	
	public int doneUpdate2(HashMap<String, Object> map) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			DoneDAO dao = new DoneDAO();
			n = dao.doneUpdate2(session, map);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}// end update-retrieve
	
	public List<DoneDTO> retrieveUpdate(String gCode) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<DoneDTO> list = null;
		try {
			DoneDAO dao = new DoneDAO();
			list = dao.retrieveUpdate(session, gCode);
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}//retrieve select
	
	
	public int doneUpdate(HashMap<String, String> map) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			DoneDAO dao = new DoneDAO();
			n = dao.doneUpdate(session, map);
			session.commit();
		}catch(ArithmeticException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return n;
	}// end cartUpdate
	
	public String doneDel(String gCode) {
		SqlSession session = MySqlSessionFactory.getSession();
		String n = null;
		try {
			DoneDAO dao = new DoneDAO();
			 n = dao.doneDel(session, gCode);
			 session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return n;
	}//del
	
	 public List<DoneDTO> doneList(String userid) {
			SqlSession session = MySqlSessionFactory.getSession();
			List<DoneDTO> list = null;
			try {
				DoneDAO dao = new DoneDAO();
				 list = dao.doneList(session, userid);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				session.close();
			}
			return list;
		}//end list
	 
	public int doneAdd(DoneDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			DoneDAO dao = new DoneDAO();
			n = dao.doneAdd(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}// end cartAdd

}// end class
