<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>index.jsp</title>
</head>
<body>
	<h1>index</h1>
	<a href="${pageContext.request.contextPath}/addMember">회원등록</a>
	<a href="${pageContext.request.contextPath}/addCategory">카테고리 등록</a>
	<a href="${pageContext.request.contextPath}/addBoard">게시판 등록</a>
</body>
</html>