package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.GoodsDAO;
import com.dao.MemberDAO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;

public class GoodsService {

	public List<GoodsDTO> goodsList(String gCategory,int curpage, int purpage) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<GoodsDTO> list = null;
		try {
			GoodsDAO dao = new GoodsDAO();
			list = dao.goodsList(session, gCategory, curpage, purpage);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	
	public List<GoodsDTO> goodsAll(){
		SqlSession session = MySqlSessionFactory.getSession();
		List<GoodsDTO> list = null;
		try {
			GoodsDAO dao = new GoodsDAO();
			list = dao.goodsAll(session);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	public GoodsDTO codeSerch(String gCode){
		SqlSession session = MySqlSessionFactory.getSession();
		GoodsDTO list = null;
		try {
			GoodsDAO dao = new GoodsDAO();
			list = dao.codeSerch(session, gCode);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	
	public int adminUpdateForm(GoodsDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			GoodsDAO dao = new GoodsDAO();
			n = dao.adminUpdateForm(session, dto);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		return n;
	}
	public int adminInsert(GoodsDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			GoodsDAO dao = new GoodsDAO();
			n = dao.adminInsert(session, dto);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		return n;
	}
	
	public int goodsTotal(String gCategory) {
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			GoodsDAO dao = new GoodsDAO();
			n = dao.goodsTotal(session, gCategory);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return n;
	}
}
