package kr.or.iei.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MypageServlet
 */
@WebServlet("/member/mypage")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩 - 필터
		//2. 값 추출 - X
		//3. 비즈니스 로직 - X
		/*
		 - 요청 JSP에서 전달한 파라미터에 의한 로직이 존재하는가?
		 - 응답 JSP에서 화면에 출력 등 필요한 데이터가 존재하는가?
		  - 마이페이지에서 회원에 대한 정보를 출력
		  	- 해당 데이터가 DB에 종속된 데이터인가?
		 */
		
		//4. 결과 처리  - 마이페이지로 이동(회원에 대한 정보를 출력)
		request.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
