package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;
import com.dto.FavorDTO;

public class FavorDAO {
	
	
	public List<FavorDTO> retrieveFavor(SqlSession session, String gCode) {
		List<FavorDTO> list = session.selectList("FavorMapper.retrieveFavor",gCode);
	   return list;
	}
	
	public int favorDel(SqlSession session, String gCode) {
		int n = session.delete("FavorMapper.favorDel",gCode);
		return n;
	}
	
	public List<FavorDTO> favorList(SqlSession session, String userid) {
		List<FavorDTO> list = session.selectList("FavorMapper.favorList", userid);
		return list;
	}

	public int favorAdd(SqlSession session, FavorDTO dto) {
		int n = session.insert("FavorMapper.favorAdd", dto);
		return n;
	}

}
