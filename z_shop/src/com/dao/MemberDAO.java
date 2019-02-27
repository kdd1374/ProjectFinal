package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {
	
	public MemberDTO idCheck(SqlSession session, HashMap<String, Object> map) {
		MemberDTO dto = session.selectOne("MemberMapper.idCheck", map);
		return dto;
	}
	
	public List<MemberDTO> selectAll(SqlSession session,int curpage, int purpage) {
		int offset = (curpage-1)*purpage;
		List<MemberDTO> list = session.selectList("MemberMapper.selectAll",null,new RowBounds(offset, purpage));
		return list;
	}
	
	public int signUpCheck(SqlSession session,String userid) {
		int n = session.selectOne("MemberMapper.signUpCheck", userid);
		return n;
	}
	
	public int memberSignup(SqlSession session, MemberDTO dto) {
		int n = session.insert("MemberMapper.memberSignup", dto);
		return n;
	}
	
	public int memberDel(SqlSession session, String userid) {
		int n = session.delete("MemberMapper.memberDel", userid);
		return n;
	}
	public int memberUpdate(SqlSession session, MemberDTO dto) {
		int n = session.update("MemberMapper.memberUpdate", dto);
		return n;
	}
	
	public MemberDTO idSerch(SqlSession session, String userid) {
		MemberDTO dto = session.selectOne("MemberMapper.idSerch", userid);
		return dto;
	}
	
	public List<MemberDTO> memberListSerch(SqlSession session, HashMap<String, String> map, int curpage, int purpage) {
		int offset = (curpage-1)*purpage;
		List<MemberDTO> list = session.selectList("MemberMapper.memberListSerch", map,new RowBounds(offset, purpage));
		return list;
	}
	
	public int total(SqlSession session, HashMap<String, String> map) {
		int n = session.selectOne("MemberMapper.total",map);
		return n;
	}
	
	public MemberDTO idSearch(SqlSession session, HashMap<String, String> map) {
		MemberDTO dto = session.selectOne("MemberMapper.idSearch", map);
		return dto;
	}
	
}
