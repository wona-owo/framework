package kr.or.iei.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.iei.member.model.service.MemberService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/member/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩 - 필터
		//2. 값추출
		String memberNo = request.getParameter("memberNo");
		
		//3. 비즈니스 로직
		MemberService service = new MemberService();
		int result = service.deleteMember(memberNo);
		
		//4. 결과처리
		if(result > 0) {
			//회원탈퇴 => DB삭제, 세션파기
			HttpSession session = request.getSession(false);
			if(session != null) {
				session.invalidate();
				}
			
			request.setAttribute("title","알림");
			request.setAttribute("text","회원정보가 삭제되었습니다");
			request.setAttribute("icon","success");
			request.setAttribute("loc","/");
		}else {
			request.setAttribute("title","알림");
			request.setAttribute("text","회원정보가 삭제 중, 오류가 발생하였습니다");
			request.setAttribute("icon","error");
			request.setAttribute("loc","/member/mypage");
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
