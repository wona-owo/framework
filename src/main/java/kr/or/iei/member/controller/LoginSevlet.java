package kr.or.iei.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class LoginSevlet
 */
@WebServlet("/member/login")
public class LoginSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩 - 필터
		//2. 값 추출
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		//3. 비즈니스 로직
		Member m = new Member();
		m.setMemberId(memberId);
		m.setMemberPw(memberPw);
		
		MemberService service = new MemberService();
		Member loginMember = service.selectOneMember(m);
		
		//4. 결과처리
		if(loginMember == null) {
			request.setAttribute("title", "알림");
			request.setAttribute("text", "아이디 및 비밀번호가 일치하지 않습니다.");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/member/loginFrm"); //처리되지 않았을때의 페이지 이동
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
			
		}else {
			//사용자가 입력한 아이디 및 비밀번호와 일치하는 회원이 존재할 때
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember); //loginMember이라는 키값으로 등록
			response.sendRedirect("/");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
