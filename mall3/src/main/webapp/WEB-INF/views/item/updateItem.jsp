<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<form action="${pageContext.request.contextPath}/updateItem" method="post">
		<input type="hidden" name="itemNo" value="${item.itemNo}">
		<input type="hidden" name="categoryNo" value="${item.categoryNo}">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="itemName" value="${item.itemPrice}"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="itemPrice" value="${item.itemName}"></td>
			</tr>
		</table>
		<button type="submit">item 수정 버튼</button>
	</form>
