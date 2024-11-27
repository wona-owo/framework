package kr.or.iei.member.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import kr.or.iei.common.SqlSessionTemplate;
import kr.or.iei.member.model.dao.MemberDao;
import kr.or.iei.member.model.vo.Member;
import kr.or.iei.member.model.vo.MemberPageData;

public class MemberService {

	private MemberDao dao;
	
	public MemberService() {
		super();
		dao = new MemberDao();
	}
	
	
	public Member selectOneMember(Member m) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Member loginMember = dao.selectOneMember(session, m);
		session.close();
		return loginMember;
	}


	public int insertMember(Member m) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = dao.insertMember(session, m);
		
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		return result;
	}


	public ArrayList<Member> selectAllMember() {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		ArrayList<Member> list = (ArrayList<Member>)dao.selectAllMember(session);
		session.close();
		return list;		
	}


	public int updateMember(Member m) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = dao.updateMember(session, m);
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		return result;
	}


	public int deleteMember(String memberNo) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = dao.deleteMember(session, memberNo);
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		return result;
	}


	public MemberPageData selectAllMemberPage(int reqPage) {
		SqlSession session = SqlSessionTemplate.getSqlSession();

		// 한 페이지에 보여줄 게시글의 갯수
		int viewMemberCnt = 10;
		/*
		 * 요청 페이지가 1 번 페이지 일때, -> start : 1, end : 10 
		 * 요청 페이지가 2 번 페이지 일때, -> start : 11, end : 20
		 * 요청 페이지가 3 번 페이지 일때, -> start : 21, end : 30 ...
		 * 
		 * 한번에 보여줄 게시글이 5개 일때 
		 * 요청 페이지가 1 번 페이지 일때, -> start : 1, end : 5 
		 * 요청 페이지가 2 번 페이지 일때, -> start : 6, end : 10 
		 * 요청 페이지가 3 번 페이지 일때, -> start : 11, end : 15 ...
		 */
		int end = reqPage * viewMemberCnt;
		int start = end - viewMemberCnt + 1;
		
		//dao에서 xml 쿼리 호출 시 파라미터 값을 하나밖에 전달을 못하기 때문에, 두개 이상 전달하기 위해 해쉬맵에 담아 묶어서 전달한다.
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("start", start);
		map.put("end", end);
		
		ArrayList<Member> list = (ArrayList<Member>) dao.selectAllMemberPage(session, map);

		// 전체 게시물의 갯수
		int totCnt = dao.selectTotalCount(session);

		// 전체 페이지 갯수
		int totPage = 0;


		if (totCnt % viewMemberCnt != 0) {
			totPage = totCnt / viewMemberCnt +1 ;
		}else {
			totPage = totCnt / viewMemberCnt;
		}

		// 페이지 하단에 보여질 페이지 네비게이션 사이즈
		int pageNaviSize = 5;

		/*
		 * 페이지 네비게이션 시작 번호 
		 * 
		 * 요청 페이지가 1 페이지이고 페이지 네비게이션 사이즈가 5 일때 == 1 2 3 4 5 
		 * 요청 페이지가 4 페이지이고 페이지 네비게이션 사이즈가 5 일때 == 1 2 3 4 5 
		 * 요청 페이지가 6 페이지이고 페이지 네비게이션 사이즈가 5 일때 == 6 7 8 9 10
		 */
		int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1; //페이지 시작번호 연산식

		// 페이지 네비게이션 HTML 태그 생성
		String pageNavi = "";

		// 이전 버튼 생성
		if (pageNo != 1) {
			// 6 7 8 9 10 or 11 12 13 14 15 or 16 17 18 19 20 ...........
			pageNavi += "<a href='/member/allMemberPage?reqPage=" + (pageNo - 1) + "'>이전</a>";
	
		}

		// 페이지 네비게이션 사이즈만큼 반복하며, 태그 생성
		for (int i = 0; i < pageNaviSize; i++) {

			// 선택한 페이지와, 선택하지 않은 페이지를 시각적으로 다르게 표현		
			pageNavi += "<a href='/member/allMemberPage?reqPage=" + pageNo +"'>" +pageNo + "</a>";
			
			pageNo++;

			if (pageNo > totPage) {
				break;
			}
		}

		// 시작번호 <= 전체 페이지 갯수
		if (pageNo <= totPage) {			
			pageNavi += "<a href='/member/allMemberPage?reqPage=" + pageNo + "'>다음</a>";		
		}

		MemberPageData pd = new MemberPageData();
		pd.setList(list);
		pd.setPageNavi(pageNavi);

		session.close();
		return pd;
		
	}


	public int chgMemberLevel(String memberNo, String memberLevel) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		
		Member m = new Member();
		m.setMemberNo(memberNo);
		m.setMemberLevel(Integer.parseInt(memberLevel));
		
		int result = dao.chgMemberLevel(session, m);
		
		return result;
	}


	public ArrayList<Member> selDynamicIfTest(Member m) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		ArrayList<Member> list = (ArrayList<Member>) dao.selDynamicIfTest(session, m);
		session.close();
		return list;
		
	}


	public ArrayList<Member> selDynamicForTest(String[] members) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		ArrayList<Member> list = (ArrayList <Member>) dao.selDynamicForTest(session, members);
		session.close();
		return list;
	}


	public ArrayList<Member> selDynamicChooseTest(String select, String keyword) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("select", select);		//name or id
		map.put("keyword", keyword);    //입력한 검색어
		ArrayList<Member> list = (ArrayList<Member>) dao.selDynamicChooseTest(session, map);
		session.close();
		return list;

	}


	public ArrayList<Member> selDynamicTest1(Member m) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		ArrayList<Member> list = (ArrayList<Member>) dao.selDynamicTest1(session, m);
		session.close();
		return list;
	}


	public ArrayList<Member> selDynamicTest2(String sFlag1) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		ArrayList<Member> list = (ArrayList<Member>) dao.selDynamicTest2(session, sFlag1);
		session.close();
		return null;
	}


	public ArrayList<Member> selDynamicTest3(Member m) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		ArrayList<Member> list = (ArrayList<Member>) dao.selDynamicTest3(session, m);
		session.close();
		return list;
	}
	
	

}
