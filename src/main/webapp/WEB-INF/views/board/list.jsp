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
	
	<form action="/board/delete" method="get">	
		<input type="submit" value="선택 삭제">
		<table border="1">
			<tr>
				<th>삭제</th>
				<th>번호</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
			<c:forEach var="b" items="${boardList}">
				<tr>
					<td><input type="checkbox" name="delNo" value="${b.boardNo}"></td>
					<td>${b.rNum}</td>
					<td><a href="/board/detailView?boardNo=${b.boardNo}&pageGb=sel">${b.boardTitle}</a></td>
					<td>${b.regDate}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<h4>${pageNavi}</h4>
	
	<%-- 게시글 목록 페이지에서 아래과 같이 검색하면,
		 조건에 부합하는 게시글 목록을 다시 조회.
		 기존 index.jsp에서 게시판 목록을 요청했을 때 작성한 URL과 동일한 URL로 요청 --%>
	<form action="/board/getList" method="get">
		<select name="srchType">
			<option value="boardTitle">제목</option>
			<option value="boardWriter" <c:if test="${srchType =='boardWriter'}">selected</c:if>>작성자</option>
			<%-- srchType이 boardWriter일때 selected 속성을 추가하겠다 --%>
		</select>
		
		<input type="text" name="srchKeyword" value="${srchKeyword}">
		<input type="submit" value="조회">
	</form>
	
</body>

</html>