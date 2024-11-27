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

	public BoardPageData selectBoardList(int reqPage) {
		
		SqlSession session = SqlSessionTemplate.getSqlSession();
		
		int viewBoardCnt = 10;
		
		int end = reqPage * viewBoardCnt;
		int start = end - viewBoardCnt + 1;
		
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("start", start);
		map.put("end", end);
		
		ArrayList<Board> list = (ArrayList<Board>) dao.selectBoardList(session, map);

		
		int totCnt = dao.selectTotalCount(session);
		int totPage = 0;


		if (totCnt % viewBoardCnt != 0) {
			totPage = totCnt / viewBoardCnt +1 ;
		}else {
			totPage = totCnt / viewBoardCnt;
		}

		
		int pageNaviSize = 5;

		
		int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1; 

		
		String pageNavi = "";


		if (pageNo != 1) {
			pageNavi += "<a href='/board/getList?reqPage=" + (pageNo - 1) + "'>이전</a>";
	
		}

		
		for (int i = 0; i < pageNaviSize; i++) {

			pageNavi += "<a href='/board/getList?reqPage=" + pageNo +"'>" +pageNo + "</a>";
			
			pageNo++;

			if (pageNo > totPage) {
				break;
			}
		}

		if (pageNo <= totPage) {			
			pageNavi += "<a href='/board/getList?reqPage=" + pageNo + "'>다음</a>";		
		}

		BoardPageData pd = new BoardPageData();
		pd.setList(list);
		pd.setPageNavi(pageNavi);

		session.close();
		return pd;
	}

}
