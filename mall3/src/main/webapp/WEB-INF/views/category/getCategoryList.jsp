<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<body>
   
	<table>    
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

</body>
</html>