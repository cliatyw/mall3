<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>addItem.jsp</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/addItem" method="post">
		<table>
			<tr>
				<td>아이템 이름</td>
				<td><input type="text" name="itemName" size="20"></td>
			<tr>
			<tr>
				<td>아이템 가격</td>
				<td><input type="text" name="itemPrice" size="20"></td>
			<tr>
		</table>
		<input type="hidden" name="categoryNo" value="${categoryNo}">
		<button type="submit">등록</button>
	</form>
</body>
</html>