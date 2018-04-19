<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../left.jsp"></jsp:include>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>addCategory.jsp</title>
</head>
<body>
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
</body>
</html>