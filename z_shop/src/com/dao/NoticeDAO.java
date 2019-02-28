package com.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.NoticeDTO;

public class NoticeDAO {
	// 여기서 보면 noticeList(SqlSession session, NoticeDTO noticeDto) 세션도 넣어주지? 이렇게 세션 넣어주고 noticeDTO도 넣어주고
	public List<NoticeDTO> noticeList(SqlSession session, NoticeDTO noticeDto) {
		List<NoticeDTO> list = session.selectList("NoticeMapper.noticeList", noticeDto); // "mapper이름.id", 너가 담아서 보낼 값 DTO ㅇㅋ?ㅇㅋ남겨줘
		return list; // 그럼 이 list에 값들이 담겨있음 해서 리턴
		
	}
	
	public int noticeDel(SqlSession session, int notice_seq) {
		int n = session.delete("NoticeMapper.noticeDel",notice_seq);
		return n;
	}
	
	
	public int noticeAdd(SqlSession session, NoticeDTO noticeDTo) {
		int n = session.insert("NoticeMapper.noticeAdd",noticeDTo);
		return n;
	}
	
	public NoticeDTO noticeDetail(SqlSession session, NoticeDTO noticeDto) {
		NoticeDTO noticeDetail = session.selectOne("NoticeMapper.noticeDetail", noticeDto); // "mapper이름.id", 너가 담아서 보낼 값 DTO ㅇㅋ?ㅇㅋ남겨줘
		return noticeDetail; // 그럼 이 list에 값들이 담겨있음 해서 리턴
		
	}
	
	public void noticeUpd(SqlSession session, NoticeDTO noticedto) {
		session.selectOne("NoticeMapper.noticeUpd",noticedto);
	}
	
	
	public int totalRecord(SqlSession session) {
		int count = session.selectOne("NoticeMapper.totalRecord");
		return count;
		
	}
	public List<NoticeDTO> selectAll(SqlSession session, int curPage,int purpage) {
		int offset = (curPage-1)*purpage;
		List<NoticeDTO> list = session.selectList("NoticeMapper.selectAll",null
				,new RowBounds(offset,purpage));
		return list;
	}
}
	
	

