<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script>
		$(document).ready(function(){			
			$('.update').click(function(){
				$('#title').removeAttr("readonly");
				$('#title').attr('style','"border:1"');
				$('#content').removeAttr("readonly");
				$('#content').attr('style','"border:1"');
				$("p").after('<input type="submit" value="수정확인">');
				$('.update').hide();
			});
		});
	</script>
</head>
<body>		
	<center>
	<h1>게시판 내용</h1>
	<form action="${pageContext.request.contextPath}/updateBoardList" method="post">
		<c:forEach var="list" items="${list}">
		<table border = "2" cellspacing = "0" cellpadding = "0">
			<tr height = "30">
			      <td align = "center" width = "125">수정</td>
			      <td align = "center" width = "125">
			      <input type="button" class="update" value="수정"> 
			      </td>
			      <td align = "center" width = "125">삭제</td>
			      <td align = "center" width = "125">
			      <a href="${pageContext.request.contextPath}/deleteBoard?deleteBoardNo= ${boardNo}"><input type="button" value="삭제"></a>
			      </td>
			</tr>
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
			      <td>
			      ${list.boardDate}
			      </td>
			</tr>
			<tr height = "30">
			      <td align = "center" width = "125">글 제목</td>
			      <td align = "left" width = "375" colspan = "3">
			      ${list.boardTitle}	
			      </td>
			</tr>
			<tr>
			      <td align = "center" width = "125">글 내용</td>
			      <td align = "left" width = "375" colspan = "3">
			      ${list.boardContent}
			      </td>
			</tr>
		</table>
		<p></p>
		</c:forEach>
	</form>	
	<form action="${pageContext.request.contextPath}/getBoardCommentList" method="post">
		<h1>댓글리스트</h1>
		<input type="text" name="commentContent"><input type="submit" value="댓글등록">
	</form>
	</center>	
</body>
</html>