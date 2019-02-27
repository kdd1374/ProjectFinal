package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;
import com.dto.DoneDTO;

public class DoneDAO {
	
	public int doneAllDel(SqlSession session, List<String> list) {
		int n = session.delete("DoneMapper.doneAllDel", list);
		return n;
	}
	
	public DoneDTO donebygCode(SqlSession session, String gCode) {
		DoneDTO cdto = session.selectOne("DoneMapper.donebygCode",gCode);
		return cdto;
	}

	public int doneUpdate2(SqlSession session,HashMap<String, Object> map) {
		int n = session.update("DoneMapper.doneUpdate", map);
		return n;
	}
	
	public List<DoneDTO> retrieveUpdate(SqlSession session, String gCode) {
		List<DoneDTO> list = session.selectList("DoneMapper.retrieveUpdate",gCode);
	   return list;
	}
	
	
	public int doneUpdate(SqlSession session,HashMap<String, String> map) {
		int n = session.update("DoneMapper.doneUpdate", map);
		return n;
	}

	public String doneDel(SqlSession session, String gCode) {
		String n = session.selectOne("DoneMapper.doneDel",gCode);
		return n;
	}
	
	public List<DoneDTO> doneList(SqlSession session, String userid) {
		List<DoneDTO> list = session.selectList("DoneMapper.doneList", userid);
		return list;
	}

	public int doneAdd(SqlSession session, DoneDTO dto) {
		int n = session.insert("DoneMapper.doneAdd", dto);
		return n;
	}

}
