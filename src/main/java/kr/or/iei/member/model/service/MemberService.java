package kr.or.iei.member.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import kr.or.iei.common.SqlSessionTemplate;
import kr.or.iei.member.model.dao.MemberDao;
import kr.or.iei.member.model.vo.Member;

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

}
