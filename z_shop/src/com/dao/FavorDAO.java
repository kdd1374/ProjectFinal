package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;
import com.dto.FavorDTO;

public class FavorDAO {
	
	public List<FavorDTO> favorAllConfirm(SqlSession session, List<String> list) {
		List<FavorDTO> n = session.selectList("FavorMapper.favorAllConfirm", list);
		return n;
	}
	
	public int favorAllDel(SqlSession session, List<String> list) {
		int n = session.delete("FavorMapper.favorAllDel", list);
		return n;
	}
	
	public FavorDTO favorbygCode(SqlSession session, String gCode) {
		FavorDTO fdto = session.selectOne("FavorMapper.favorbygCode",gCode);
		return fdto;
	}

	public int favorUpdate2(SqlSession session,HashMap<String, Object> map) {
		int n = session.update("FavorMapper.cafavorUpdate", map);
		return n;
	}
	
	public List<FavorDTO> retrieveFavor(SqlSession session, String gCode) {
		List<FavorDTO> list = session.selectList("FavorMapper.retrieveFavor",gCode);
	   return list;
	}
	
	
	public int favorUpdate(SqlSession session,HashMap<String, String> map) {
		int n = session.update("FavorMapper.favorUpdate", map);
		return n;
	}

	public String favorDel(SqlSession session, String gCode) {
		String n = session.selectOne("FavorMapper.favorDel",gCode);
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
