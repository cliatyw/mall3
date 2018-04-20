<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>getItemList.jsp</title>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
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
	<h1>목록</h1>
		<div class="col-xs-2">
			<form action="${pageContext.request.contextPath}/getItemList?pagePerRow=pagePerRow&categoryNo=${categoryNo}">
				<select name="pagePerRow" class="form-control">
					<option value="5">5개씩</option>
					<option value="10">10개씩</option>
					<option value="15">15개씩</option>
				</select>
		</div>
			<input type="submit" class="btn btn-default" value="개보기">
		</form>
	<table class="table table-striped">
		<thead>
			<class style="float:right;font-size:12px" >
				<a href="${pageContext.request.contextPath}/getItemList?categoryNo=${categoryNo}&pricelist=high">높은가격순</a>&nbsp
				<a href="${pageContext.request.contextPath}/getItemList?categoryNo=${categoryNo}&pricelist=low">낮은가격순</a>
			</class>
		
			<tr>
				<th>아이템</th>
				<th>가격</th>
				<c:if test="${!empty loginMember.memberId}">
					<th>수정</th>
					<th>삭제</th>
					<th>주문</th>
				</c:if>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${list}">
				<tr>
					<td>${item.itemName}</td>
					<td>${item.itemPrice}</td>
					<c:if test="${!empty loginMember.memberId}">
						<td><a href="${pageContext.request.contextPath}/updateItem?itemNo=${item.itemNo}&categoryNo=${categoryNo}">수정</a></td>
						<td><a href="${pageContext.request.contextPath}/deleteItem?itemNo=${item.itemNo}&categoryNo=${categoryNo}">삭제</a></td>
						<td><a href="${pageContext.request.contextPath}/addOrder?itemNo=${item.itemNo}&memberNo=${loginMember.memberNo}">주문</a></td>
					</c:if>
				</tr>
			</c:forEach>

		</tbody>
	</table>
			<form id="seach" action="${pageContext.request.contextPath}/getItemList?pagePerRow=pagePerRow" style="margin:0;padding:0; float:right;">
				<input name="keyword" size="15" maxlength="30">
				<input type="hidden" name="categoryNo" value="${categoryNo}">
				<input type="submit" value="검색">
		    </form>
	<c:if test="${!empty loginMember.memberId}">
	<input type="button" value="등록" onclick="window.location.href='${pageContext.request.contextPath}/addItem?categoryNo=${categoryNo}'"/>
	</c:if>
	<c:forEach var="start" begin="1" end="${lastPage}">
		<a href="${pageContext.request.contextPath}/getItemList?currentPage=${start}&pagePerRow=${pagePerRow}&categoryNo=${categoryNo}">[${start}]</a>
	</c:forEach>
	</div>
</body>
</html>