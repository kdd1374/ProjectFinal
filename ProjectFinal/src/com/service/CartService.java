package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.CartDAO;
import com.dto.CartDTO;
import com.dto.DoneDTO;

public class CartService {

	public int oderAllDone(List<DoneDTO> x, List<String> gCodes) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			CartDAO dao = new CartDAO();
			n = dao.orderAllDone(session, x);
			n = dao.cartAllDel(session, gCodes);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return n;
	}// end 주문완료

	public int orderDone(DoneDTO dto, String gCode) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			CartDAO dao = new CartDAO();
			n = dao.orderDone(session, dto);
			n = dao.cartDel(session, gCode);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return n;
	}// end 주문완료

	public List<CartDTO> orderAllConfirm(List<String> list) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<CartDTO> n = null;
		try {
			CartDAO dao = new CartDAO();
			n = dao.orderAllConfirm(session, list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return n;
	}// 전체주문확인

	public int cartAllDel(List<String> list) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			CartDAO dao = new CartDAO();
			n = dao.cartAllDel(session, list);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return n;
	}// end deleteAll

	public CartDTO cartbygCode(String gCode) {
		SqlSession session = MySqlSessionFactory.getSession();
		CartDTO cdto = null;
		try {
			CartDAO dao = new CartDAO();
			cdto = dao.cartbygCode(session, gCode);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cdto;
	}// end idCheck

	public List<CartDTO> retrieveUpdate(String gCode) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<CartDTO> list = null;
		try {
			CartDAO dao = new CartDAO();
			list = dao.retrieveUpdate(session, gCode);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}// retrieve select

	public int cartUpdate(HashMap<String, Object> map) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			CartDAO dao = new CartDAO();
			n = dao.cartUpdate(session, map);
			session.commit();
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return n;
	}// end cartUpdate

	public int cartDel(String gCode) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			CartDAO dao = new CartDAO();
			n = dao.cartDel(session, gCode);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return n;
	}// del

	public List<CartDTO> cartList(String userid) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<CartDTO> list = null;
		try {
			CartDAO dao = new CartDAO();
			list = dao.cartList(session, userid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}// end list

	public int cartAdd(CartDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			CartDAO dao = new CartDAO();
			n = dao.cartAdd(session, dto);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}// end cartAdd

}// end class
