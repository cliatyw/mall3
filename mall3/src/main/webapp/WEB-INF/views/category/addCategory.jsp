<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>addCategory.jsp</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/addCategory" method="post">
		<table>
			<tr>
				<td>카테고리 등록</td>
				<td><input type="text" name="categoryName" size="20"></td>
			<tr>
		</table>
		<button type="submit">등록</button>
	</form>
</body>
</html>