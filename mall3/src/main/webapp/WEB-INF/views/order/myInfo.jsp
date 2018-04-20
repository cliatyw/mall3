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
		<h1>주문 리스트 </h1>
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/myInfo?previous=1'">하루</button>
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/myInfo?previous=7'">1주일</button>
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/myInfo?previous=30'">1개월</button>
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/myInfo?previous=90'">3개월</button>
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/myInfo?previous=180'">6개월</button>
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/myInfo?previous=365'">1년</button>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>orderNo</th>
					<th>memberNo</th>
					<th>itemNo</th>
					<th>orderDate</th>
					<th>주문 취소</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="order" items="${list}">
					<tr>
						<td>${order.orderNo}</td>
						<td>${order.memberNo}</td>
						<td>${order.itemNo}</td>
						<td>${order.orderDate}</td>
						<td><a href="${pageContext.request.contextPath}/deleteOrder?orderNo=${order.orderNo}">주문 취소</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>