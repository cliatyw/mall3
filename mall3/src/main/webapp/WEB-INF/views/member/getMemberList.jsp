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
		<h1>회원 리스트 </h1>
		<form action="${pageContext.request.contextPath}/getMemberList" method="get">
			<div class="col-xs-2">
				<select name="pagePerRow" class="form-control">
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
					<th>no</th>
					<th>id</th>
					<th>pw</th>
					<th>수정</th>
					<th>삭제</th>
					<th>주소 목록</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="member" items="${list}">
					<tr>
						<td>${member.memberNo}</td>
						<td>${member.memberId}</td>
						<td>${member.memberPw}</td>
						<td><a href="${pageContext.request.contextPath}/updateMember?memberNo=${member.memberNo}">수정</a></td>
						<td><a href="${pageContext.request.contextPath}/deleteMember?memberNo=${member.memberNo}">삭제</a></td>
						<td><a href="${pageContext.request.contextPath}/getAddressList?memberNo=${member.memberNo}">주소 목록</a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${currentPage > 1}">
			<a href="${pageContext.request.contextPath}/getMemberList?currentPage=1&pagePerRow=${pagePerRow}">[처음으로]</a>
		</c:if>
		<c:if test="${currentPage > 1}">
			<a href="${pageContext.request.contextPath}/getMemberList?currentPage=${currentPage-1}&pagePerRow=${pagePerRow}">[이전]</a>
		</c:if>
		<c:forEach var="a" begin="1" end="${lastPage}">
			<a href="${pageContext.request.contextPath}/getMemberList?currentPage=${a}&pagePerRow=${pagePerRow}">${a}</a>
		</c:forEach>
		<c:if test="${currentPage < lastPage}">
			<a href="${pageContext.request.contextPath}/getMemberList?currentPage=${currentPage+1}&pagePerRow=${pagePerRow}">[다음]</a>
		</c:if>
		<c:if test="${currentPage < lastPage}">
			<a href="${pageContext.request.contextPath}/getMemberList?currentPage=${lastPage}&pagePerRow=${pagePerRow}">[끝으로]</a>
		</c:if>
	</div>
</body>
</html>