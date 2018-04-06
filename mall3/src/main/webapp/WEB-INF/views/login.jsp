<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/login" method = "post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="memberId" value="${requestMember.memberId}"></td>
			<tr>
			<tr>
				<td>암호</td>
				<td><input type="text" name="memberPw" value="${requestMember.memberPw}"></td>
			</tr>
		</table>
		<button type="submit">로그인버튼</button>
	</form>
</body>
</html>