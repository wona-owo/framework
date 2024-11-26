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
	<h1>회원관리 - 관리자 마이페이지</h1>
	
	<hr>
	
	<table border="1">
		<tr>
			<th>선택</th>
			<th>번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>등급</th>
			<th>가입일</th>
			<th>변경</th>
		</tr>
	<c:forEach var="m" items="${list}">
		<tr>
			<td>
				<input type="checkbox">
			</td>
			<td class="memberNo">${m.memberNo}</td>
			<td>${m.memberId}</td>
			<td>${m.memberName}</td>
			<td>
				<select name="memberLevel">
					<c:choose>
						<c:when test="${m.memberLevel == 1}">
						<option value="1" selected>관리자</option>
						<option value="2">정회원</option>
						<option value="3">준회원</option>
						</c:when>
						<c:when test="${m.memberLevel == 2}">
						<option value="1">관리자</option>
						<option value="2" selected>정회원</option>
						<option value="3">준회원</option>
						</c:when>
						<c:otherwise>
						<option value="1">관리자</option>
						<option value="2">정회원</option>
						<option value="3" selected>준회원</option>
						</c:otherwise>
					</c:choose>
				</select>
			</td>
			<td>${m.enrollDate}</td>
			<td>
				<button type="button" onclick="chgLevel(this)">등급변경</button>
			</td>
		</tr>
	</c:forEach>
	</table>
	<script>
		//전달받은 요소 객체로 몇번째 행인지 알 수 있다.
		//버튼을 클릭한 행의 회원 등급을 변경 -> 서버로 전달해야하는 값
		function chgLevel(obj){
			/*
			./$(obj)		  : 버튼
			./$(obj).parant() : td
			./$(obj).parants("tr")
			*/
			let tr = $(obj).parents("tr");
			
			let memberNo = tr.find(".memberNo").html();
			let memberLevel = tr.find("select[name=memberLevel] option:selected").val();
			
			$.ajax({
				 url: "/member/chgLevel",
				    data: {
				        'memberNo': memberNo, 
				        'memberLevel': memberLevel
				       },
				type : 'get',
				success : function(res){
					if(res > 0){
						alert('등급 변경 완료');
					}else{
						alert('등급 변경 실패');
					}
				},
				error : function(){
					console.log('ajax 오류');
				}
			});
			
			}
	</script>

</body>
</html>