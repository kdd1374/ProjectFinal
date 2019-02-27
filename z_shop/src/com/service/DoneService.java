package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.DoneDAO;
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
	
	
	public int doneDel(String orderday) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			DoneDAO dao = new DoneDAO();
			 n = dao.doneDel(session, orderday);
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
	 
	

}// end class
