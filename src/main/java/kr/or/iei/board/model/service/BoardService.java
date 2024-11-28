package kr.or.iei.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import kr.or.iei.board.model.dao.BoardDao;
import kr.or.iei.board.model.dao.BoardPageData;
import kr.or.iei.board.model.vo.Board;
import kr.or.iei.common.SqlSessionTemplate;

public class BoardService {
	
	private BoardDao dao;

	
	public BoardService() {
		super();
		dao = new BoardDao();
	}

	public BoardPageData selectBoardList(int reqPage, String srchType, String srchKeyword) {		
		SqlSession session = SqlSessionTemplate.getSqlSession();
		
		int viewBoardCnt = 10;
		
		int end = reqPage * viewBoardCnt;
		int start = end - viewBoardCnt + 1;
		
		//HashMap<String, Integer> 에서 아래와 같이 수정. (dao 메소드 호출 시, srchType과, srchKeyword도 같이 전달해주기 위해)
		HashMap<String, String> map = new HashMap<String, String>();	
		
		//String.valueOf : 전달 매개변수를 String으로 형변환
		map.put("start", String.valueOf(start));
		map.put("end", String.valueOf(end));
		//문자와 결합연산 하면 String으로 변환 되는 것을 이용하는 편법도 있다!
		
		map.put("srchType", srchType);
		map.put("srchKeyword", srchKeyword);
		ArrayList<Board> list = (ArrayList<Board>) dao.selectBoardList(session, map);

		
		int totCnt = dao.selectTotalCount(session, map);
		int totPage = 0;


		if (totCnt % viewBoardCnt != 0) {
			totPage = totCnt / viewBoardCnt +1 ;
		}else {
			totPage = totCnt / viewBoardCnt;
		}

		
		int pageNaviSize = 5;

		
		int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1; 

		
		String pageNavi = "";
		
		//사용자 조건 최초 검색 이후, 페이지 네비게이션 클릭시에도 조건에 부합하는 데이터를 조회할 수 있도록
		String srchParam ="";
		if(srchKeyword != null) {
			srchParam += "&srchType=" + srchType + "&srchKeyword=" + srchKeyword;
		}

		if (pageNo != 1) {
			pageNavi += "<a href='/board/getList?reqPage=" + (pageNo - 1) + srchParam + "'>이전</a>";
	
		}

		
		for (int i = 0; i < pageNaviSize; i++) {

			pageNavi += "<a href='/board/getList?reqPage=" + pageNo + srchParam +"'>" +pageNo + "</a>";
			
			pageNo++;

			if (pageNo > totPage) {
				break;
			}
		}

		if (pageNo <= totPage) {			
			pageNavi += "<a href='/board/getList?reqPage=" + pageNo + srchParam + "'>다음</a>";		
		}

		BoardPageData pd = new BoardPageData();
		pd.setList(list);
		pd.setPageNavi(pageNavi);

		session.close();
		return pd;
	}

	public int deleteBoard(String[] delNo) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = dao.deleteBoard(session, delNo);
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public Board selectOneBoard(String boardNo, String pageGb) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		
		/*
		 게시글 목록에서 제목을 클릭하여 상세보기 페이지로 이동 시  : pageGb == sel
		 게시글 상세보기에서 수정하기 페이지로 이동 시           : pageGb == upd
		 수정하기 페이지에서, 수정 완료 후 상세보기로 이동 시     : pageGb == upd
		 
		 */
		int result = -1;
		
		if(pageGb.equals("sel")) {			
			result = dao.updateReadCount(session,boardNo);
		}
		
	
		
		Board board = null;
		
		if(result > 0) {			
			board = dao.selectOneBoard(session, boardNo);
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return board;
		
		
	}

	public int updateBoard(Board b) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = dao.updateBoard(session, b);
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		return result;
	}

}
