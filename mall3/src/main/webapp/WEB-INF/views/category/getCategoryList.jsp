<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>카테고리 </h1>
	<table>
		<thead>
			<tr>
				<th>no</th>
				<th>카테고리</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="category" items="${list}">
				<tr>
					<td>${category.categoryNo}</td>
					<td>${category.categoryName}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>