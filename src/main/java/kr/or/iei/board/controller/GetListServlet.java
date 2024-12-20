package kr.or.iei.board.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.board.model.dao.BoardPageData;
import kr.or.iei.board.model.service.BoardService;



/**
 * Servlet implementation class GetListServlet
 */
@WebServlet("/board/getList")
public class GetListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		//2. 값추출
		int reqPage = request.getParameter("reqPage") != null ? Integer.parseInt(request.getParameter("reqPage")) : 1 ; //요청 페이지 번호
		
		//게시글 목록 하단에서, 검색하였을 때 전달한 파라미터
		String srchType = request.getParameter("srchType");		  //검색 조건(제목 or 작성자)
		String srchKeyword = request.getParameter("srchKeyword"); //검색어
		
		//3. 로직
		BoardService service = new BoardService(); 
		BoardPageData pd = service.selectBoardList(reqPage, srchType, srchKeyword);
				
		//4. 결과처리
		request.setAttribute("srchType", srchType);
		request.setAttribute("srchKeyword", srchKeyword);
		
		request.setAttribute("boardList", pd.getList());
		request.setAttribute("pageNavi", pd.getPageNavi());
		request.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
