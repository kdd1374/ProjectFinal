package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.CartDAO;
import com.dao.FavorDAO;
import com.dto.CartDTO;

public class FavorService {
	
	public int favorDel(int gCode) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			FavorDAO dao = new FavorDAO();
			 n = dao.favorDel(session, gCode);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return n;
	}
	
	 public List<CartDTO> favorList(String userid) {
			SqlSession session = MySqlSessionFactory.getSession();
			List<CartDTO> list = null;
			try {
				FavorDAO dao = new FavorDAO();
				 list = dao.favorList(session, userid);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				session.close();
			}
			return list;
		}//end idCheck
	public int favorAdd(CartDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			FavorDAO dao = new FavorDAO();
			n = dao.favorAdd(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}// end cartAdd

}// end class
