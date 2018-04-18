<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../header.jsp"></jsp:include>
	<script>
		$(document).ready(function(){
			$("#memberId").blur(function(){
				if($("#memberId").val().length < 4){
					$("#idHelper").text("아이디는 4글자 이상입니다.");
				}else{
					$("#idHelper").text("");
				}
			});
			$("#memberPw").blur(function(){
				if($("#memberPw").val().length < 4){
					$("#pwHelper").text("비밀번호는 4글자 이상입니다.");
				}else{
					$("#pwHelper").text("");
				}
			});
			$("#memberPwCheck").blur(function(){
				if($("#memberPwCheck").val() !== $("#memberPw").val()){
					$("#pwCheckHelper").text("비밀번호를 확인해주세요.");
				}else{
					$("#pwCheckHelper").text("");
				}
			});
			$("#btn").click(function(){
				if($("#memberId").val().length >= 4 && $("#memberPw").val().length >= 4 && $("#memberPwCheck").val() === $("#memberPw").val()){
					$("#addMemberForm").submit();
				}
				else{
					return;
				}
			});
		});
	</script>
	<form action="${pageContext.request.contextPath}/addMember" id="addMemberForm" method = "post">
		<table>
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" id="memberId" name="memberId">
					<span id="idHelper"></span>
				</td>
			<tr>
			<tr>
				<td>암호</td>
				<td>
					<input type="text" id="memberPw" name="memberPw">
					<span id="pwHelper"></span>
				</td>
			</tr>
			<tr>
				<td>암호 확인</td>
				<td>
					<input type="text" id="memberPwCheck" name="memberPwCheck">
					<span id="pwCheckHelper"></span>
				</td>
			</tr>
		</table>
		<button id="btn" type="button">회원가입버튼</button>
	</form>
</body>
</html>