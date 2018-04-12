<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../top.jsp"></jsp:include>
	<form action="${pageContext.request.contextPath}/addMember" method = "post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="memberId"></td>
			<tr>
			<tr>
				<td>암호</td>
				<td><input type="text" name="memberPw"></td>
			</tr>
		</table>
		<button type="submit">회원가입버튼</button>
	</form>
</body>
</html>