<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>getCategoryList.jsp</title>
</head>
<body>
<h1>카테고리</h1>
		<form action="${pageContext.request.contextPath}/getCategoryList?pagePerRow=pagePerRow">
			<select name="pagePerRow" id="pagePerRow">
				<option value="5">5</option>
				<option value="10">10</option>
				<option value="15">15</option>
			</select>
			<input type="submit" value="개보기">
		</form>
	<table>
		<thead>
			<tr>
				<th>no</th>
				<th>카테고리</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="category" items="${list}">
				<tr>
					<td>${category.categoryNo}</td>
					<td><a href="${pageContext.request.contextPath}/getItemList?categoryNo=${category.categoryNo}">${category.categoryName}</a></td>
					<td><a href="${pageContext.request.contextPath}/updateCategory?categoryNo=${category.categoryNo}">수정</a></td>
					<td><a href="${pageContext.request.contextPath}/deleteCategory?categoryNo=${category.categoryNo}">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type="button" value="등록" onclick="window.location.href='${pageContext.request.contextPath}/addCategory'"/>
	<c:forEach var="start" begin="1" end="${lastPage}">
		<a href="${pageContext.request.contextPath}/getCategoryList?currentPage=${start}&pagePerRow=${pagePerRow}">[${start}]</a>
	</c:forEach>
</body>
</html>