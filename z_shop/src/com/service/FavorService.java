package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.FavorDAO;
import com.dto.FavorDTO;

public class FavorService {
	
	
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
	
	
	
	public int favorDel(String gCode) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
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
