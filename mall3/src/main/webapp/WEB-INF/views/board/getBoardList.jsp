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
		<form action="${pageContext.request.contextPath}/getBoardList?pagePerRow=pagePerRow">
			<select name="pagePerRow" id="pagePerRow">
				<option value="5">5</option>
				<option value="10">10</option>
				<option value="15">15</option>
			</select>
			<input type="submit" value="검색">
		</form>
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
		<c:forEach var="start" begin="1" end="${lastPage}">
			<a href="${pageContext.request.contextPath}/getBoardList?currentPage=${start}&pagePerRow=${pagePerRow}">[${start}]</a>
		</c:forEach>
		
</body>
</html>