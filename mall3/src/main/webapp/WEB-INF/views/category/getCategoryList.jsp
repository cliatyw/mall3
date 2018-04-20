<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<body>
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
	
	<table class="table table-striped">    
		<thead>    
			<tr>    
				<th>no</th>    
				<th>카테고리</th>    
				<th>수정</th>    
				<th>삭제</th>    
			</tr>    
		</thead>    
		<tbody>    
			<c:forEach var="category" items="${list}">    
				<tr>    
					<td>${category.categoryNo}</td>    
					<td><a href="${pageContext.request.contextPath}/getItemList?categoryNo=${category.categoryNo}&categoryName=${category.categoryName}">${category.categoryName}</a></td>    
					<td><a href="${pageContext.request.contextPath}/updateCategory?categoryNo=${category.categoryNo}">수정</a></td>    
					<td><a href="${pageContext.request.contextPath}/deleteCategory?categoryNo=${category.categoryNo}">삭제</a></td>    
				</tr>    
			</c:forEach>    
		</tbody>    
	</table>  
	<input type="button" value="등록" onclick="window.location.href='${pageContext.request.contextPath}/addCategory'"/> 
	</div>
</body>
</html>