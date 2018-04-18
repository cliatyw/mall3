<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../header.jsp"></jsp:include>
	<form action="${pageContext.request.contextPath}/updateMember" method = "post">
		<input type="hidden" name="memberNo" value="${member.memberNo}">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="memberId" value="${member.memberId}"></td>
			<tr>
			<tr>
				<td>암호</td>
				<td><input type="text" name="memberPw" value="${member.memberPw}"></td>
			</tr>
		</table>
		<button type="submit">회원 수정 버튼</button>
	</form>
</body>
</html>