package kr.or.iei.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.board.model.service.BoardService;
import kr.or.iei.board.model.vo.Board;

/**
 * Servlet implementation class UpdateFrmServlet
 */
@WebServlet("/board/updateFrm")
public class UpdateFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFrmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		//2. 값추출
		String boardNo = request.getParameter("boardNo");
		
		//3. 로직
		BoardService service = new BoardService();
		
		String pageGb = "upd";
		Board board = service.selectOneBoard(boardNo, pageGb);
		
		//4. 결과처리
		request.setAttribute("board", board);
		request.getRequestDispatcher("/WEB-INF/views/board/updateFrm.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
