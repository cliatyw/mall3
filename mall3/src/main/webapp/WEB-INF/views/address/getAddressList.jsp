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
		<h1>주소 리스트 </h1>
		<form action="${pageContext.request.contextPath}/getAddressList" method="get">
			<input type="hidden" name="memberNo" value="${memberNo}">
			<div class="col-xs-2">
				<select name="pagePerRow" class="form-control" placeholder=".col-xs-3">
					<option value="3">3개씩</option>
					<option value="5">5개씩</option>
					<option value="10">10개씩</option>
				</select>
			</div>
			<button type="submit" class="btn btn-default">보기</button>
		</form>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>addr no</th>
					<th>member no</th>
					<th>content</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="address" items="${list}">
					<tr>
						<td>${address.addressNo}</td>
						<td>${address.memberNo}</td>
						<td>${address.addressContent}</td>
						<td><a href="${pageContext.request.contextPath}/updateAddress?addressNo=${address.addressNo}&memberNo=${memberNo}">수정</a></td>
						<td><a href="${pageContext.request.contextPath}/deleteAddress?addressNo=${address.addressNo}&memberNo=${memberNo}">삭제</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/addAddress?memberNo=${memberNo}'">주소 추가</button>
		
		<c:if test="${currentPage > 1}">
			<a href="${pageContext.request.contextPath}/getAddressList?currentPage=1&pagePerRow=${pagePerRow}&memberNo=${memberNo}">[처음으로]</a>
		</c:if>
		<c:if test="${currentPage > 1}">
			<a href="${pageContext.request.contextPath}/getAddressList?currentPage=${currentPage-1}&pagePerRow=${pagePerRow}&memberNo=${memberNo}">[이전]</a>
		</c:if>
		<c:forEach var="a" begin="1" end="${lastPage}">
			<a href="${pageContext.request.contextPath}/getAddressList?currentPage=${a}&pagePerRow=${pagePerRow}&memberNo=${memberNo}">${a}</a>
		</c:forEach>
		<c:if test="${currentPage < lastPage}">
			<a href="${pageContext.request.contextPath}/getAddressList?currentPage=${currentPage+1}&pagePerRow=${pagePerRow}&memberNo=${memberNo}">[다음]</a>
		</c:if>
		<c:if test="${currentPage < lastPage}">
			<a href="${pageContext.request.contextPath}/getAddressList?currentPage=${lastPage}&pagePerRow=${pagePerRow}&memberNo=${memberNo}">[끝으로]</a>
		</c:if>
	</div>
</body>
</html>