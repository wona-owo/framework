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
	<h1> IF - 회원정보</h1>

	<hr>
	<%--
	dynamicQueryTest.jsp에서 체크한 정보만 화면에 출력할 수 있도록 아래와 같이 처리
	 --%>
	
	<table border="1">
		<tr>
			<c:if test="${not empty chkInfo.sFlag1}">
			<td>번호</td>
			</c:if>
			<c:if test="${not empty chkInfo.sFlag2}">
			<td>아이디</td>
			</c:if>
			<c:if test="${not empty chkInfo.sFlag3}">
			<td>이름</td>
			</c:if>
			<c:if test="${not empty chkInfo.sFlag4}">
			<td>이메일</td>
			</c:if>
			<c:if test="${not empty chkInfo.sFlag5}">
			<td>전화번호</td>
			</c:if>
		</tr>
		<c:forEach var="m" items="${list}">
		<tr>
		<c:if test="${not empty chkInfo.sFlag1}">
			<td>${m.memberNo}</td> 
		</c:if>
		<c:if test="${not empty chkInfo.sFlag2}">
			<td>${m.memberId}</td> 
		</c:if>
		<c:if test="${not empty chkInfo.sFlag3}">
			<td>${m.memberName}</td> 
		</c:if>
		<c:if test="${not empty chkInfo.sFlag4}">
			<td>${m.memberEmail}</td> 
		</c:if>
		<c:if test="${not empty chkInfo.sFlag5}">
			<td>${m.memberPhone}</td>
		</c:if>
		</tr> 
		</c:forEach>
	</table>
</body>
</html>