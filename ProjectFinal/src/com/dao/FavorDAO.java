package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;

public class FavorDAO {


	public int favorDel(SqlSession session, int gCode) {
		int n = session.selectOne("FavorMapper.favorDel",gCode);
		return n;
	}
	
	public List<CartDTO> favorList(SqlSession session, String userid) {
		List<CartDTO> list = session.selectList("FavorMapper.favorList", userid);
		return list;
	}

	public int favorAdd(SqlSession session, CartDTO dto) {
		int n = session.insert("FavorMapper.favorAdd", dto);
		return n;
	}

}
