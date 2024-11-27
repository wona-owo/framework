package kr.or.iei.board.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.iei.board.model.vo.Board;


public class BoardDao {

	public List<Board> selectBoardList(SqlSession session, HashMap<String, Integer> map) {
		return session.selectList("board.selectAllBoardPage", map);
	}

	public int selectTotalCount(SqlSession session) {	
		return session.selectOne("board.selectTotalCount");
	}

}
