package com.config;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//Configuration.xml 설정해서
//SqlSesstionFactory 얻기
//DeptService에서 사용
public class MySqlSessionFactory {
	private static SqlSessionFactory sqlSessionFactory = null;
	static {
		String resource = "com/config/Configuration.xml"; //패키지명 3.패키지변경시수정
		InputStream inputStream=null;//로컬변수이기 때문에 초기화
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sqlSessionFactory =
		  new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public static SqlSession getSession() {//객체생성을 하지않고 사용하기 위해서 static을 붙여준다.
		return sqlSessionFactory.openSession(); //sqlSessionFactory을 리턴해준다.
	}
	//드라이버 로딩과 커넥션까지 완료.
}
