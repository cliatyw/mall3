<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/getCategoryList" method = "post">
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