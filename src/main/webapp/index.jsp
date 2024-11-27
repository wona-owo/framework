<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Framework - Mybatis </h1>
	
	<hr>
	
	<p>
	프레임워크 : 개발에 필요한 기본적인 기능들을, 일정한 구조와 규칙대로 미리 구현해둔 툴.	<br>
			  개발자가 좀 더 효율적으로 애플리케이션을 만들 수 있도록 재사용 가능한 코드와 도구들의 집합.	<br>
			  아키텍쳐와 규칙을 따르므로, 코드 구조가 체계적이고 유지보수가 용이하다.	<br>
			  여러가지 기본적인 기능들을 제공해서 개발 시간을 단축시킬 수 있다.	<br>
	<br>
	
	Mybatis : Java와 Database간의 상호 작용을 간편하게 하기 위한 영속성 프레임워크.	<br>
	영속성 : 프로그램이 종료되어도 데이터가 유지되는 성질(속성)을 의미.	<br><br>
	
	특징)	<br>
	1. 자동 매핑 :DB의 결과를 Java 객체로 자동으로 매핑하는 기능을 제공	<br>
	2. XML 파일에 SQL 작성 : SQL문이 Java 코드와 분리되어 가독성 및 유지보수가 용이하다.	<br>
	3. 동적 SQL 지원 : if, choose, foreach와 같은 구문을 이용하여, 동적인 SQL문 작성이 가능하다.	<br>
	4. SQL 재사용 : XML에 작성된 하나의 SMQ을 여러곳에서 사용이 가능하자.	<br>
	</pre>
	
	<hr>
	
	
	<c:if test="${empty sessionScope.loginMember}"> <!--세션에 유저를 등록.(값을 가져다 쓰기 위해) -->
		<h3>
			<a href="/member/loginFrm">로그인 페이지로 이동</a>
		</h3>
	</c:if>	
	<c:if test="${not empty sessionScope.loginMember}">
		<h3>${sessionScope.loginMember.memberName}님 환영합니다!</h3>
		<ul>
			<li><a href="/member/allMember">전체회원조회</a></li>
			<li><a href="/member/mypage">마이페이지</a></li>
			<li><a href="/member/logout">로그아웃</a></li>
			<li><a href="/member/allMemberPage?reqPage=1">전체회원조회(페이징)</a></li>
			
			<c:if test="${sessionScope.loginMember.memberLevel == 1}">
				<li><a href="/member/adminPage">관리자 페이지</a></li>
			</c:if>
			<li><a href="/views/dynamicQueryTest.jsp">마이바티스 동적 쿼리 테스트</a></li>
			<li><a href="/board/getList?reqPage=1">게시판 목록으로</a></li>
		</ul>
	</c:if>
	
</body>
</html>