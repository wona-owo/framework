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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/member/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩 - 필터
		//2. 값 추출
    	String memberPw = request.getParameter("memberPw");
    	String memberName = request.getParameter("memberName");
    	String memberPhone = request.getParameter("memberPhone");
    	String memberAddr = request.getParameter("memberAddr");
    	String memberEmail = request.getParameter("memberEmail");
    	String memberNo = request.getParameter("memberNo");
    	
		//3. 비즈니스 로직
		Member member = new Member();
		member.setMemberNo(memberNo);
		member.setMemberPw(memberPw);
		member.setMemberName(memberName);
		member.setMemberPhone(memberPhone);
		member.setMemberAddr(memberAddr);
		member.setMemberEmail(memberEmail);
		
		MemberService service = new MemberService();
		int result = service.updateMember(member);
		
		
		//4. 결과 처리 - DB 뿐만 아니라, 세션 데이터도 업데이트를 해줘야 화면에서 확인할 수 있다.
		//FRM 서블릿이 단순 세션에 있는 정보만 불러오기 때문에, DB 데이터를 불러오는게 아니라서
		if(result > 0) {
			//request.getSession(false) : 기존세션 반환. 기존세션 없으면 -> null
			//request.getSession(true) : 기존세션 반환. 기존세션 없으면 -> 새로운 세션을 생성하여 반환

			HttpSession session = request.getSession(false);
			Member loginMember = (Member) session.getAttribute("loginMember");
			loginMember.setMemberPw(memberPw);
			loginMember.setMemberName(memberName);
			loginMember.setMemberPhone(memberPhone);
			loginMember.setMemberAddr(memberAddr);
			loginMember.setMemberEmail(memberEmail);
			
			request.setAttribute("title", "알림");
			request.setAttribute("text", "회원정보가 수정되었습니다.");
			request.setAttribute("icon", "success");
			request.setAttribute("loc", "/member/mypage");		
		}else {
			request.setAttribute("title", "알림");
			request.setAttribute("text", "회원정보 수정 중, 오류가 발생하였습니다.");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/member/mypage");		
		}
		
		
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
