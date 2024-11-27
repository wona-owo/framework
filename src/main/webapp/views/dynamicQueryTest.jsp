<%@page import="kr.or.iei.member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.iei.member.model.vo.MemberPageData"%>
<%@page import="kr.or.iei.member.model.service.MemberService"%>
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
	<h1>Mybatis 동적 쿼리 테스트</h1>
	
	<hr>
	
	<h3>IF 테스트</h3>
	<form action="/member/dynamic/ifTest" method="post">
		<input type="checkbox" name="chkNo">		No
		<input type="checkbox" name="chkId">		ID
		<input type="checkbox" name="chkName">		Name
		<input type="checkbox" name="chkEmail">		Email
		<input type="checkbox" name="chkPhone">		Phone
		<input type="submit" value="회원정보 조회">
	</form>
	
	<hr>
	
	<h3>FOR 테스트</h3>
	
	<%
	MemberService service = new MemberService();
	MemberPageData pd = service.selectAllMemberPage(1);
	ArrayList<Member> list = pd.getList();
	%>
	
	<form action="/member/dynamic/forTest" method="get">
		<table border="1">
			<tr>
				<th>선택</th>
				<th>아이디</th>
			</tr>
			<c:forEach var="m" items="<%=list%>">
				<tr>
					<td><input type="checkbox" name="members" value="${m.memberId}"></td>
					<td>${m.memberId}</td>
				</tr>
			</c:forEach>
			<tr>
				<th colspan="2">
					<input type="submit" value="조회">
				</th>
			</tr>
		</table>
	</form>
	
	<hr>
	
	<h3>Choose 테스트</h3>
	
	<form action="/member/dynamic/chooseTest" method="get">
		<input type="radio" name="select" value="name"> 이름으로 검색
		<input type="radio" name="select" value="id"> 아이디로 검색
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
	
	<hr>
	
	<h3>Dynamic Test - 1</h3>
	
	<hr>
	
	<form action="/member/dynamic/test1" method = get>
		<h4>체크한 지역에 거주하는 회원 리스트 조회</h4>
		
		<input type="checkbox" name="sFlag1" value="서울"> 서울
		<input type="checkbox" name="sFlag2" value="경기"> 경기
		<input type="checkbox" name="sFlag3" value="부산"> 부산
		<input type="checkbox" name="sFlag4" value="목포"> 목포
		<input type="submit" value="조회">		
	</form>	
	
	<hr>
	
	<h3>Dynamic Test - 2</h3>
	
	<form action="/member/dynamic/test2" method = get>
		<h4>등급 체크박스 체크 시, 등급명 포함 조회</h4>
		
		<input type ="checkbox" name="sFlag1"> 등급명 포함조회
		<input type="submit" value="조회">
	</form>	
	
	<hr>
	
	<h3>Dynamic Test - 3</h3>
	
	<form action ="/member/dynamic/test3" method="get">
		<h4>체크한 조건 & 검색어를 포함하는 회원 조회</h4>
		<!-- 체크한 조건 컬럼명 기준으로 오름차순 정렬하여 출력 -->
		
		<input type="radio" name="sFlag1" value="member_name"> 이름
		<input type="radio" name="sFlag1" value="member_addr"> 주소
		<input type="radio" name="sFlag1" value="member_phone"> 전화번호
		
		<br>
		
		입력값 :  <input type="text" name="sFlag2">
		<input type="submit" value="조회">
		
	</form>
</body>
</html>