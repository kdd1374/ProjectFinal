package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.CartDAO;
import com.dao.FavorDAO;
import com.dto.CartDTO;
import com.dto.FavorDTO;

public class FavorService {
	
	public List<FavorDTO> favorAllConfirm(List<String> list) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<FavorDTO> n = null;
		try {
			FavorDAO dao = new FavorDAO();
			 n = dao.favorAllConfirm(session, list);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return n;
	}
	
	public int favorAllDel(List<String> list) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			FavorDAO dao = new FavorDAO();
			n = dao.favorAllDel(session, list);
			session.commit();
		} catch(Exception e){
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return n;
	}// end deleteAll
	
	public FavorDTO favorbygCode( String gCode) {
		SqlSession session = MySqlSessionFactory.getSession();
		FavorDTO cdto = null;
		try {
			FavorDAO dao = new FavorDAO();
			 cdto = dao.favorbygCode(session, gCode);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cdto;
	}//end idCheck
	
	public int favorUpdate2(HashMap<String, Object> map) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			FavorDAO dao = new FavorDAO();
			n = dao.favorUpdate2(session, map);
			session.commit();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return n;
	}// end update-retrieve
	
	public List<FavorDTO> retrieveFavor(String gCode) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<FavorDTO> list = null;
		try {
			FavorDAO dao = new FavorDAO();
			list = dao.retrieveFavor(session, gCode);
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}//retrieve select
	
	
	public int favorUpdate(HashMap<String, String> map) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			FavorDAO dao = new FavorDAO();
			n = dao.favorUpdate(session, map);
			session.commit();
		}catch(ArithmeticException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return n;
	}// end cartUpdate
	
	public String favorDel(String gCode) {
		SqlSession session = MySqlSessionFactory.getSession();
		String n = null;
		try {
			FavorDAO dao = new FavorDAO();
			 n = dao.favorDel(session, gCode);
			 session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return n;
	}//del
	
	 public List<FavorDTO> favorList(String userid) {
			SqlSession session = MySqlSessionFactory.getSession();
			List<FavorDTO> list = null;
			try {
				FavorDAO dao = new FavorDAO();
				 list = dao.favorList(session, userid);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				session.close();
			}
			return list;
		}//end list
	 
	public int favorAdd(FavorDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			FavorDAO dao = new FavorDAO();
			n = dao.favorAdd(session, dto);
			session.commit();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return n;
	}// end cartAdd

}// end class
