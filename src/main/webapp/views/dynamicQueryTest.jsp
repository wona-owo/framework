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
</body>
</html>