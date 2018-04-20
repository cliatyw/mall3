<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>addCategory.jsp</title>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<c:forEach var="category" items="${cateList}">
						<li><a href="${pageContext.request.contextPath}/getItemList?categoryNo=${category.categoryNo}&categoryName=${category.categoryName}">${category.categoryName}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<form action="${pageContext.request.contextPath}/updateCategory" method="post">
			<table>
				<tr>
					<td>카테고리 변경</td>
					<td><input type="hidden" name="categoryNo" value="${category.categoryNo}"></td>
					<td><input type="text" name="categoryName" size="20" value="${category.categoryName}"></td>
				<tr>
			</table>
			<button type="submit">변경</button>
		</form>
	</div>
</body>
</html>