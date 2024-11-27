package kr.or.iei.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class DynamicChooseTestServlet
 */
@WebServlet("/member/dynamic/chooseTest")
public class DynamicChooseTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DynamicChooseTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		//2. 값 추출
		String select = request.getParameter("select"); //아이디로 검색 or 이름으로 검색
		String keyword = request.getParameter("keyword"); // 검색어
		
		//3. 비즈니스 로직
		MemberService service = new MemberService();
		ArrayList<Member> list = service.selDynamicChooseTest(select,keyword);
		
		//4. 결과처리
		request.setAttribute("memberList", list);
		request.getRequestDispatcher("/views/dynamicChooseTest.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
