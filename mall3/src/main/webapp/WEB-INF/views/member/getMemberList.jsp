<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>회원 리스트 </h1>
	<table>
		<thead>
			<tr>
				<th>no</th>
				<th>id</th>
				<th>pw</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="member" items="${list}">
				<tr>
					<td>${member.memberNo}</td>
					<td>${member.memberId}</td>
					<td>${member.memberPw}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>