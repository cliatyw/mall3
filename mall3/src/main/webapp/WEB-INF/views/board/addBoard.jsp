<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
	<h1>게시글 작성</h1>
	<form method="post" action="${pageContext.request.contextPath}/addBoard">
		제목 :<input type="text" name="boardTitle"><br>
		내용:<input type="text" name="boardContent"><br>
		<input type="submit" value="등록">
	</form>
	</center>
</body>
</html>