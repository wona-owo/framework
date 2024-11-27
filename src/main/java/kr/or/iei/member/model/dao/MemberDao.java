package kr.or.iei.member.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
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

	public int updateMember(SqlSession session, Member m) {
		return session.update("member.updateMember", m);
	}

	public int deleteMember(SqlSession session, String memberNo) {
		return session.delete("member.deleteMember", memberNo);
	}

	public List<Member> selectAllMemberPage(SqlSession session, HashMap<String, Integer> map) {
		return session.selectList("member.selectAllMemberPage", map);
	}

	public int selectTotalCount(SqlSession session) {
		return session.selectOne("member.selectTotalCount");
	}

	public int chgMemberLevel(SqlSession session, Member m) {
		return session.update("member.chgMemberLevel", m);
	}

	public List<Member> selDynamicIfTest(SqlSession session, Member m) {
		return session.selectList("member.selDynamicIfTest", m);
	}

	public List<Member> selDynamicForTest(SqlSession session, String[] members) {
		return session.selectList("member.selDynamicForTest", members);
	}


	public List<Member> selDynamicChooseTest(SqlSession session, HashMap<String, String> map) {
		/*
		 ex1) session.selectList 
		 	- 사용자 입력값 : 아이디로 검색(id), 검색어(user01) ==> 결과 row 갯수 0 or 1 	   ==> O
		 	- 사용자 입력값 : 이름으로 검색(name), 검색어 (유저) ==> 결과 row 갯수 0 or 1 or N ==> O
		 ex2) session.selectOne
		 	- 사용자 입력값 : 아이디로 검색(id), 검색어(user01) ==> 결과 row 갯수 0 or 1	   ==> O
		 	- 사용자 입력값 : 이름으로 검색(name), 검색어 (유저) ==> 결과 row 갯수 0 or 1 or N ==> X
		 
		 사용자가 아이디로 검색 선택 시, 일치하는 회원만 조회하니 결과는 0개 또는 1개다. 이 때 selectOne, selectList 사용 가능하다.
		 사용자가 이름으로 검색 선택 시, 포함하는 회원들을 조회하니 결과는 0개 또는 1개 또는 N개이다. 이 때는 selectList만 사용 가능하다. 
		 */
		
		return session.selectList("member.selDynamicChooseTest", map);
		
	}
	
	public List<Member> selDynamicTest1(SqlSession session, Member m) {
		return session.selectList("member.selDynamicTest1", m);
	}

	public List<Member> selDynamicTest2(SqlSession session, String sFlag1) {
		return session.selectList("member.selDynamicTest2", sFlag1);
	}

	public List<Member> selDynamicTest3(SqlSession session, Member m) {
		return session.selectList("member.selDynamicTest3", m);
	}




}
