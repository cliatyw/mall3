<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<jsp:include page="../header.jsp"></jsp:include>
	<h1>회원 리스트 </h1>
	<form action="${pageContext.request.contextPath}/getMemberList" method="get">
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
</body>
</html>