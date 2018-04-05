<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>getBoardList.jsp</title>
</head>
<body>
	<h1>게시판리스트</h1>
		<input type="button" value="등록" onclick="window.location.href='${pageContext.request.contextPath}/addBoard'" />
		<table border="1">
			<thead>
				<tr>
					<th>순서</th>
					<th>제목</th>
				</tr>
			</thead>	
			<tbody>
				<c:forEach var="list" items="${list}">
				<tr>
					<td>${list.boardNo}</td>
					<td><a href="${pageContext.request.contextPath}/getBoardCommentList">${list.boardTitle}</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>