<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"></jsp:include>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">로그인</h1>
		<form class="form-signin" action="${pageContext.request.contextPath}/login" method = "post">
			<label>id</label>
			<input type="text" id="memberId" name="memberId" class="form-control" value="${requestMember.memberId}" required autofocus>
			<label>password</label>
			<input type="password" id="memberPw" name="memberPw" class="form-control" value="${requestMember.memberPw}" required>
			<br>
			<button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
			<button class="btn btn-lg btn-primary btn-block" type="button" onclick="location.href='${pageContext.request.contextPath}/addMember'">회원 가입</button>
		</form>
	</div>
</body>
</html>