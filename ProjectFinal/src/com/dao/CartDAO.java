package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;
import com.dto.DoneDTO;

public class CartDAO {
	
	public int orderAllDone(SqlSession session, List<DoneDTO> x) {
		int n = session.insert("CartMapper.orderAllDone", x);
		return n;
	}
	
	public int orderDone(SqlSession session, DoneDTO dto) {
		int n = session.insert("CartMapper.orderDone", dto);
		return n;
	}
	
	public List<CartDTO> orderAllConfirm(SqlSession session, List<String> list) {
		List<CartDTO> n = session.selectList("CartMapper.orderAllConfirm", list);
		return n;
	}
	
	public int cartAllDel(SqlSession session, List<String> list) {
		int n = session.delete("CartMapper.cartAllDel", list);
		return n;
	}
	
	public CartDTO cartbygCode(SqlSession session, String gCode) {
		CartDTO cdto = session.selectOne("CartMapper.cartbygCode",gCode);
		return cdto;
	}
	
	public List<CartDTO> retrieveUpdate(SqlSession session, String gCode) {
		List<CartDTO> list = session.selectList("CartMapper.retrieveUpdate",gCode);
	   return list;
	}
	
	
	public int cartUpdate(SqlSession session,HashMap<String, Object> map) {
		int n = session.update("CartMapper.cartUpdate", map);
		return n;
	}

	public int cartDel(SqlSession session, String gCode) {
		int n = session.delete("CartMapper.cartDel",gCode);
		return n;
	}
	
	public List<CartDTO> cartList(SqlSession session, String userid) {
		List<CartDTO> list = session.selectList("CartMapper.cartList", userid);
		return list;
	}

	public int cartAdd(SqlSession session, CartDTO dto) {
		int n = session.insert("CartMapper.cartAdd", dto);
		return n;
	}

}
