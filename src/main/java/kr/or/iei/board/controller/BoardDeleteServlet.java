package kr.or.iei.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.board.model.service.BoardService;

/**
 * Servlet implementation class BoardDeleteServlet
 */
@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		//2. 값 추출
		String [] delNo = request.getParameterValues("delNo");
		//3. 로직
		BoardService service = new BoardService();
		int result = service.deleteBoard(delNo);
		
		//4. 결과처리
		if(result > 0) {
			request.setAttribute("title", "알림");
			request.setAttribute("text", "게시글이 삭제되었습니다.");
			request.setAttribute("icon", "success");
		}else {
			request.setAttribute("title", "알림");
			request.setAttribute("text", "게시글 삭제 중 오류 발생");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/board/getList?reqPage=1");
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
