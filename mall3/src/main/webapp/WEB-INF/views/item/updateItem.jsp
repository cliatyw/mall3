<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<form action="${pageContext.request.contextPath}/updateItem" method="post">
			<input type="hidden" name="itemNo" value="${item.itemNo}">
			<input type="hidden" name="categoryNo" value="${item.categoryNo}">
			<table>
				<tr>
					<td>이름</td>
					<td><input type="text" name="itemName" value="${item.itemName}"></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input type="text" name="itemPrice" value="${item.itemPrice}"></td>
				</tr>
			</table>
			<button type="submit">item 수정 버튼</button>
		</form>
	</div>