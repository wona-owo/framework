package kr.or.iei.board.model.dao;

import java.util.ArrayList;

import kr.or.iei.board.model.vo.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardPageData {
	private ArrayList<Board> list;
	private String pageNavi;
}
