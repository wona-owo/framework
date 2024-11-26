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
 * Servlet implementation class DynamicIfTestServlet
 */
@WebServlet("/member/dynamic/ifTest")
public class DynamicIfTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DynamicIfTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		//2. 값추출
		String chkNo = request.getParameter("chkNo");
		String chkId = request.getParameter("chkId");
		String chkName = request.getParameter("chkName");
		String chkEmail = request.getParameter("chkEmail");
		String chkPhone = request.getParameter("chkPhone");
		
		//3. 비즈니스 로직
		Member m = new Member();
		m.setsFlag1(chkNo);
		m.setsFlag2(chkId);
		m.setsFlag3(chkName);
		m.setsFlag4(chkEmail);
		m.setsFlag5(chkPhone);
		
		MemberService service = new MemberService();
		ArrayList<Member> list = service.selDynamicIfTest(m);
		
		//4. 결과처리
		request.setAttribute("list", list);
		request.setAttribute("chkInfo", m);
		request.getRequestDispatcher("/views/dynamicIfTest.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
