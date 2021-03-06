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
			$('.commentUpdate').click(function(){
				$(this).parents('span').find('.commentContent').attr('type','"text"');
				$(this).parents('span').find('.commentDelete').remove();
				$(this).parents('span').find('#updateCommentContent').html('<input type="submit" value="수정확인">');		
			});
			$('.commentDelete').click(function(){
				$(this).parents('span').find('#deleteForm').submit();
			});
		});
	</script>
</head>
<body>			
	<h1>게시판 내용</h1>
	<form action="${pageContext.request.contextPath}/updateBoardList" method="post">
		<table border = "2" cellspacing = "0" cellpadding = "0">
			<tr height = "30">
			      <td align = "center" width = "125">수정</td>
			      <td align = "center" width = "125">
			      	<input type="button" class="update" value="수정"> 
			      </td>
			      <td align = "center" width = "125">삭제</td>
			      <td align = "center" width = "125">
			      	<a href="${pageContext.request.contextPath}/deleteBoard?deleteBoardNo= ${board.boardNo}"><input type="button" value="삭제"></a>
			      </td>
			</tr>
			<tr height = "30">
			      <td align = "center" width = "125">순서</td>
			      <td align = "center" width = "125">
			      	<input type="hidden" value="${board.boardNo}" name="boardNo">
			      	${board.boardNo}
			      </td>
			      <td align = "center" width = "125">아이디</td>
			      <td align = "center" width = "125">
			      	${board.memberId}
			      </td>
			</tr>
			<tr height = "30">
			      <td align = "center" width = "250">작성일</td>
			      <td>
			      	${board.boardDate}
			      </td>
			</tr>
			<tr height = "30">
			      <td align = "center" width = "125">글 제목</td>
			      <td align = "left" width = "375" colspan = "3">
			     	<input type="text" value="${board.boardTitle}" readonly style="border:0" id="title" name="boardTitle">
			      </td>
			</tr>
			<tr>
			      <td align = "center" width = "125">글 내용</td>
			      <td align = "left" width = "375" colspan = "3">
			       	<input type="text" value="${board.boardContent}" readonly style="border:0" id="content" name="boardContent">
			      </td>
			</tr>
		</table>
		<p></p>
	</form>	
	<h1>댓글리스트</h1>
	<c:forEach var="list" items="${list}">
		<table border="1">
			<td width="150">
				<div style="text-align:center">
					${list.memberId}
				</div>
			</td>
			<td width="550">
				<div>
					${list.commentContent}
				</div>							
				<span>	
					<form id="updateForm"action="${pageContext.request.contextPath}/updateBoardComment" method="post">
						<c:if test="${list.memberId == sessionScope.loginMemberId}">
							<div>							
								<input type="button" class="commentUpdate" value="수정">
								<input type="hidden" value="${list.commentContent}" style="border:1" class="commentContent" name="updateCommentContent" size="50">						
								<input type="hidden" value="${list.commentNo}" name="commentNo">						
								<input type="hidden" value="${board.boardNo}" name="boardNo">
								<input type="hidden" value="${board.memberId}" name="memberId">
								<input type="hidden" value="${board.boardDate}" name="boardDate">
								<input type="hidden" value="${board.boardTitle}" name="boardTitle">
								<input type="hidden" value="${board.boardContent}" name="boardContent">
								<span id="updateCommentContent"></span>
								<input type="button" class="commentDelete" value="삭제">				
							</div>
						</c:if>
					 </form>
					<form id="deleteForm" action="${pageContext.request.contextPath}/deleteBoardComment" method="post">
						<input type="hidden" value="${list.commentNo}" name="commentNo">
						<input type="hidden" value="${board.boardNo}" name="boardNo">
						<input type="hidden" value="${board.memberId}" name="memberId">
						<input type="hidden" value="${board.boardDate}" name="boardDate">
						<input type="hidden" value="${board.boardTitle}" name="boardTitle">
						<input type="hidden" value="${board.boardContent}" name="boardContent">
					</form>	
				</span>									
			</td>
		</table>					
	</c:forEach>
	<c:forEach var="start" begin="1" end="${lastPage}">
			<a href="${pageContext.request.contextPath}/getBoardCommentList?currentPage=${start}
			&boardNo=${board.boardNo}&memberId=${board.memberId}&boardDate=${board.boardDate}&boardTitle=${board.boardTitle}&boardContent=${board.boardContent}">[${start}]</a>
	</c:forEach><br>		
	<br>
	<form id="insertForm" action="${pageContext.request.contextPath}/getBoardCommentList" method="post">
		<c:if test="${sessionScope.loginMemberId != null}">
			<table border="1">
				<td width="150">
					<div style="text-align:center">
						${sessionScope.loginMemberId}
					</div>
				</td>
				<td width="550">
					<div>
						<textarea name="commentContent" rows="4" cols="70"></textarea>
					</div>
				</td>
				<td>
					<input type="submit" value="댓글등록">
					<input type="hidden" value="${board.boardNo}" name="boardNo">
					<input type="hidden" value="${board.memberId}" name="memberId">
					<input type="hidden" value="${board.boardDate}" name="boardDate">
					<input type="hidden" value="${board.boardTitle}" name="boardTitle">
					<input type="hidden" value="${board.boardContent}" name="boardContent">					
				</td>
			</table>
		</c:if>		
	</form>	
</body>
</html>