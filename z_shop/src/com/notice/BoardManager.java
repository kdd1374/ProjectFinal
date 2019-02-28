package com.notice;

import java.sql.SQLException;
import java.util.List;

public class BoardManager {

	public static int insert(Board board)
		throws SQLException{
		
		/* 이부분은 인자로 전달된 board 객체의 내용을 데이터베이스에 저장하는 소스코드가 들어감
		 * 
		 */
		return 0;
	}
	
	public static int update(Board board)throws SQLException{
		/*
		이부분은 인자로 전달된 board 객체의 내용을 데이터베이스에 저장되어 있는 
		게시물을 수정하는 소스코드가 들어감.*/
		
		return 0;
	}
	
	public static int delete(int id)throws SQLException{
		
		/*이부분은 인자로 id의 게시물을 삭제하는 소스코드가 들어감*/
		
		return 0;
	}
	
	public static List list(int currentPage, int pagePerCount)throws SQLException{
		/*
		이 부분은 인자로 현재 페이지와 페이지당 게시물의 수에 해당하는 게시물을
		선택하여 각각의 게시물을 Board객체에 저장한 후
		List에 저장하여 전달하는 소스코드가 들어간다.*/
		
		return null;
		
	}
	
}
