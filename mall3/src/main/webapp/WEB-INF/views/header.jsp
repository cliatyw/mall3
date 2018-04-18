<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>3팀</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${pageContext.request.contextPath}/">Project name</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="${pageContext.request.contextPath}/">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/getBoardList">게시판</a></li>
            <c:if test="${empty loginMember.memberId}">
            	<li><a href="${pageContext.request.contextPath}/login">로그인</a></li>
            </c:if>
            <c:if test="${!empty loginMember.memberId}">
            	<li><a href="${pageContext.request.contextPath}/logout">로그아웃</a></li>
            	<li><a href="${pageContext.request.contextPath}/getMemberList">회원 목록</a></li>
            	<li><a href="${pageContext.request.contextPath}/getCategoryList">카테고리 목록</a></li>
            </c:if>
          </ul>
        </div>
      </div>
    </nav>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
			</div>