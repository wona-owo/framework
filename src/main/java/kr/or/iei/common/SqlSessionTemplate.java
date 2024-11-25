package kr.or.iei.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {

		public static SqlSession getSqlSession() {
			SqlSession session = null; //SQL문을 실행하고, 트랜잭션을 관리하기 위한 객체
			
			String resource = "mybatis-config.xml"; //config 파일
			
			//클래스 패스(src, 최상위 파일)의 설정 파일을 읽어오기 위한 스트림 객체 읽어오기
			try {
				InputStream is = Resources.getResourceAsStream(resource);
				
				//SqlSessionFactory 객체를 생성하기 위한 빌더 객체
				SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
				
				//팩토리 빌더를 이용해, 팩토리 객체 생성(SqlSession 객체를 생성하는 역
				SqlSessionFactory factory = builder.build(is);
				
				//SqlSession 객체 생성
				session = factory.openSession(false); // false : autoCommit을 하지 않겠다라는 의미.
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return session;
		}
}
