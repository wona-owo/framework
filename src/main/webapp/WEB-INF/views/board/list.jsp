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
<h1>게시판 - 게시글 목록 조회</h1>
		
		<hr>
		
		<%--
		 게시물 번호는 오리클 시퀀스 객체로 자동 채번되어 삽입되어지는 값.
		 
		 게시글 등록 후, 오류가 발생해도 시퀀스는 다음 번호를 채번한다.. => 번호와 번호 사이에 빈 값들이 존재할 수 있음
		 (ex. 1=> 2=> 5=> 9=> 15....)
		 
		 사용자에게 보여지는 값은 == 열 번호(rowNum)
		 실제 수량, 삭제 시 SQL과 where 조건식에 작성될 값은 == 게시글 번호(boardNo)
		 --%>
		
		
		<table border="1">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
			<c:forEach var="b" items="${boardList}">
				<tr>
					<td>${b.boardNo}</td>
					<td>${b.boardTitle}</td>
					<td>${b.regDate}</td>
				</tr>
			</c:forEach>
		</table>
	<h4>${pageNavi}</h4>
</body>

</html>