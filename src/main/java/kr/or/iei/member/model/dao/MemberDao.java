package kr.or.iei.member.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.iei.member.model.vo.Member;

public class MemberDao {
	
	/*
	 여러개의 mapper.xml 생성 가능하므로, mapper 파일을 구분할 값과,
	 하나의 mapper.xml 내부의 여러개의 SQL 작성 가능하므로, 실행할 SQL을 지정할 값이 필요.
	 
	 
	 
	 session.메소드("mapper의 namespace 속성값.실행할 SQL ID값, 전달 파라미터")
	 * */
	
	public Member selectOneMember(SqlSession session, Member m) {
		return session.selectOne("member.selectOneMember",m);
		//namespace값과 ID 값을 작성해주면 mapper의 sql을 불러올 수 있다.	
	}

	public int insertMember(SqlSession session, Member m) {
		return session.insert("member.insertMember", m);
		
	}

	public List<Member> selectAllMember(SqlSession session) {
		return session.selectList("member.selectAllMember");
		
	}

}
