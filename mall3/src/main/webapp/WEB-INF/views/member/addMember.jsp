<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>addMember.jsp</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/addMember" method = "post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="memberId" size="20"></td>
			<tr>
			<tr>
				<td>암호</td>
				<td><input type="text" name="memberPw" size="20"></td>
			</tr>
		</table>
		<button type="submit">회원가입버튼</button>
	</form>
</body>
</html>