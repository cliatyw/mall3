<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>getItemList.jsp</title>
</head>
<body>
<h1>아이템</h1>
		<form action="${pageContext.request.contextPath}/getItemList?pagePerRow=pagePerRow">
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
				<th>아이템</th>
				<th>가격</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${list}">
				<tr>
					<td>${item.itemNo}</td>
					<td>${item.itemName}</td>
					<td>${item.itemPrice}</td>
					<td><a href="${pageContext.request.contextPath}/updateItem?itemNo=${item.itemNo}&categoryNo=${categoryNo}">수정</a></td>
					<td><a href="${pageContext.request.contextPath}/deleteItem?itemNo=${item.itemNo}&categoryNo=${categoryNo}">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type="button" value="등록" onclick="window.location.href='${pageContext.request.contextPath}/addItem?categoryNo=${categoryNo}'"/>
	<c:forEach var="start" begin="1" end="${lastPage}">
		<a href="${pageContext.request.contextPath}/getItemList?currentPage=${start}&pagePerRow=${pagePerRow}">[${start}]</a>
	</c:forEach>
</body>
</html>