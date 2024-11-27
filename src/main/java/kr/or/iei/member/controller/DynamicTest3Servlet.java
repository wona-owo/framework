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
 * Servlet implementation class DynamicTest3Servlet
 */
@WebServlet("/member/dynamic/test3")
public class DynamicTest3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DynamicTest3Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		//2. 값추출
		String sFlag1 = request.getParameter("sFlag1"); //이름 or 주소 or 전화번호
		String sFlag2 = request.getParameter("sFlag2"); //검색어
		
		//3. 비즈니스 로직
		Member m = new Member();
		m.setsFlag1(sFlag1);
		m.setsFlag2(sFlag2);
		
		MemberService service = new MemberService();
		ArrayList<Member> list = service.selDynamicTest3(m);
		
		//4. 결과처리
		request.setAttribute("memberList", list);
		request.getRequestDispatcher("/views/dynamicForTest3.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
