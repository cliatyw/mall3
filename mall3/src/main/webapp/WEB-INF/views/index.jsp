<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>index.jsp</title>
</head>
<body>
	<h1>index</h1>
	
	<c:if test="${empty loginMember.memberId}">
		<a href="${pageContext.request.contextPath}/login">로그인</a>
	</c:if>
	<c:if test="${!empty loginMember.memberId}">
		${loginMember.memberId} 로그인 중
		<a href="${pageContext.request.contextPath}/logout">로그아웃</a>
	</c:if>
	
	<a href="${pageContext.request.contextPath}/addMember">회원등록</a>
	<a href="${pageContext.request.contextPath}/addCategory">카테고리 등록</a>
	<a href="${pageContext.request.contextPath}/addBoard">게시판 등록</a>
</body>
</html>