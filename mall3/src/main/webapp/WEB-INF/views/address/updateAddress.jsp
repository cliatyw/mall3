<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../top.jsp"></jsp:include>
	<form action="${pageContext.request.contextPath}/updateAddress" method = "post">
		<input type="hidden" name="addressNo" value="${address.addressNo}">
		<input type="hidden" name="memberNo" value="${address.memberNo}">
		<table>
			<tr>
				<td>주소</td>
				<td><input type="text" name="addressContent" value="${address.addressContent}"></td>
			</tr>
		</table>
		<button type="submit">주소 수정 버튼</button>
	</form>
</body>
</html>