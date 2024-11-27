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
 * Servlet implementation class DynamicTest1Servlet
 */
@WebServlet("/member/dynamic/test1")
public class DynamicTest1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DynamicTest1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		//2. 값 추출
		String sFlag1 = request.getParameter("sFlag1");  //서울
		String sFlag2 = request.getParameter("sFlag2");  //경기
		String sFlag3 = request.getParameter("sFlag3");  //부산
		String sFlag4 = request.getParameter("sFlag4");  //목포
	
		//3. 비즈니스 로직
		Member m = new Member();
		m.setsFlag1(sFlag1);
		m.setsFlag2(sFlag2);
		m.setsFlag3(sFlag3);
		m.setsFlag4(sFlag4);
		
		MemberService service = new MemberService();
		ArrayList<Member> list = service.selDynamicTest1(m);
		
		//4. 결과처리
		//적절한 JSP에서 list 출력
		request.setAttribute("memberList", list);
		request.getRequestDispatcher("/views/dynamicForTest1.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
