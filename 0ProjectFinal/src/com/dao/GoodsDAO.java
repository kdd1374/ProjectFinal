package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.GoodsDTO;
import com.dto.MemberDTO;

public class GoodsDAO {
	
	public List<GoodsDTO> goodsList(SqlSession session, String gCategory) {
		List<GoodsDTO> list = session.selectList("GoodsMapper.goodsList", gCategory);
		return list;
	}
	
	public List<GoodsDTO> goodsAll(SqlSession session){
		List<GoodsDTO> list = session.selectList("GoodsMapper.goodsAll");
		return list;
	}
	
	public GoodsDTO codeSerch(SqlSession session, String gCode){
		GoodsDTO list = session.selectOne("GoodsMapper.codeSerch", gCode);
		return list;
	}
	
	public int adminUpdateForm(SqlSession session, GoodsDTO dto) {
		int n = session.update("GoodsMapper.adminUpdateForm", dto);
		return n;
	}
	
	public int adminInsert(SqlSession session, GoodsDTO dto) {
		int n = session.insert("GoodsMapper.adminInsert", dto);
		return n;
	}
	
}
