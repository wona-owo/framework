<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<h1>회원관리 - 마이페이지</h1>

	<hr>

	<form action="/member/update" method="post">
		<input type="hidden" name="memberNo" value="${loginMember.memberNo}"> <%--서블릿에 보이지는 않지만 요청은 되는게 hidden--%>
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="memberId" value="${loginMember.memberId}"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="memberPw" value="${loginMember.memberPw}"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="memberName" value="${loginMember.memberName}"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="memberPhone" value="${loginMember.memberPhone}"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="memberAddr" value="${loginMember.memberAddr}"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="memberEmail" value="${loginMember.memberEmail}"></td>
			</tr>
			<tr>
				<th>등급</th>
				<td>
					<c:choose>			<%--${}는 el문법, JSTL과 el 문법 같이 쓰는중 --%>
						<c:when test="${loginMmeber.memberLevel == 1}">
						관리자
						</c:when>
						<c:when test="${loginMmeber.memberLevel == 2}">
						정회원
						</c:when>
						<c:otherwise> <%--default, else의 역할을 해줌 --%>
						준회원
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th>가입일</th>
				<td>
				<span>${loginMember.enrollDate}</span>
				<%--수정할 수 없는 정보는 span 태그로 지정 --%>
				</td>
				<tr>
					<td colspan="2">
						<input type="submit" value="수정하기">
						<button type="button" onclick="deleteMember()">삭제하기</button>
					</td>
				</tr>
		</table>
	</form>
	<script>
		function deleteMember() {
			$('form').attr('action','/member/delete');
			$('form').submit;
		}
	</script>
</body>
</html>