<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<jsp:include page="../header.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<c:forEach var="category" items="${cateList}">
						<li><a href="${pageContext.request.contextPath}/getItemList?categoryNo=${category.categoryNo}&categoryName=${category.categoryName}">${category.categoryName}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
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
	</div>
</body>
</html>