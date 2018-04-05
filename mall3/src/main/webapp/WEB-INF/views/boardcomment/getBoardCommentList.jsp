<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>		
	<center><b>글내용 보기</b><br>
	<table border = "2" cellspacing = "0" cellpadding = "0" align = "center">
		<c:forEach var="list" items="${list}">
		<tr height = "30">
		      <td align = "center" width = "125">순서</td>
		      <td align = "center" width = "125">
		            ${list.boardNo}
		      </td>
		      <td align = "center" width = "125">아이디</td>
		      <td align = "center" width = "125">
		          ${list.memberId}
		      </td>
		</tr>
		<tr height = "30">
		      <td align = "center" width = "250">작성일</td>
		      <td align = "center" width = "250">
		            ${list.boardDate}
		      </td>
		</tr>
		<tr height = "30">
		      <td align = "center" width = "125">글 제목</td>
		      <td align = "center" width = "375" colspan = "3">
		            ${list.boardTitle}
		      </td>
		</tr>
		<tr>
		      <td align = "center" width = "125">글 내용</td>
		      <td align = "left" width = "375" colspan = "3">
		            <pre>${list.boardContent}</pre>
		      </td>
		</tr>
		</c:forEach>
	</table>
	</center>
	<form action="${pageContext.request.contextPath}/getBoardCommentList" method="post">	
		<h1>댓글리스트</h1>
		<input type="text" name="commentContent"><input type="submit" value="댓글등록">
	</form>	
</body>
</html>