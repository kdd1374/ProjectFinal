package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {
	
	public MemberDTO idCheck(SqlSession session, HashMap<String, Object> map) {
		MemberDTO dto = session.selectOne("MemberMapper.idCheck", map);
		return dto;
	}
	
	public List<MemberDTO> selectAll(SqlSession session) {
		List<MemberDTO> list = session.selectList("MemberMapper.selectAll");
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
	
}
