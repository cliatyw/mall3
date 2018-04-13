<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<jsp:include page="../top.jsp"></jsp:include>
	<h1>회원 리스트 </h1>
	<form action="${pageContext.request.contextPath}/getAddressList?memberNo=${memberNo}" method="get">
		<select name="pagePerRow">
			<option value="3">3개씩</option>
			<option value="5">5개씩</option>
			<option value="10">10개씩</option>
		</select>
		<button type="submit">보기</button>
	</form>
	<table>
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
					<td><a href="${pageContext.request.contextPath}/updateAddress?addressNo=${address.addressNo}">수정</a></td>
					<td><a href="${pageContext.request.contextPath}/deleteAddress?addressNo=${address.addressNo}">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button type="button" onclick="location.href='${pageContext.request.contextPath}/addAddress?memberNo=${memberNo}'">주소 추가</button>
	
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
</body>
</html>