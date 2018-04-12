<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	
	<a href="${pageContext.request.contextPath}/">홈으로</a>
	<a href="${pageContext.request.contextPath}/getMemberList">회원 목록</a>
	<a href="${pageContext.request.contextPath}/getCategoryList">카테고리 목록</a>
	<a href="${pageContext.request.contextPath}/getBoardList">게시판 목록</a>
	<c:if test="${empty loginMember.memberId}">
		<a href="${pageContext.request.contextPath}/login">로그인</a>
	</c:if>
	<c:if test="${!empty loginMember.memberId}">
		${loginMember.memberId} 로그인 중
		<a href="${pageContext.request.contextPath}/logout">로그아웃</a>
	</c:if>