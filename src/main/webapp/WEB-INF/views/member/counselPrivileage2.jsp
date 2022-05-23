<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/narangnorang/js/member/counselPrivileage2.js"></script>
<title>회원관리</title>
</head>
<body>
<article id="member">
	<table border="1">
		<thead>
			<tr>
				<th><strong>체크</strong></th>
				<th><strong>id</strong></th>
				<th><strong>password</strong></th>
				<th><strong>phone</strong></th>
				<th><strong>privileage</strong></th>
				<th><strong>name</strong></th>
				<th><strong>zipcode</strong></th>
				<th><strong>address1</strong></th>
				<th><strong>address2</strong></th>
				<th><strong>address3</strong></th>
				<th><strong>job</strong></th>
				<th><strong>introduction</strong></th>
			</tr>
		</thead>
		<tbody>
			<form>
			<c:forEach var="list" items="${lists}">
				<tr>
					<td><input type="checkbox" name="check" id="check" value="${list.id}"></td>
					<td>${list.id}</td>
					<td>${list.password}</td>
					<td>${list.phone}</td>
					<td>${list.privileage}</td>
					<td>${list.name}</td>
					<td>${list.zipcode}</td>
					<td>${list.address1}</td>
					<td>${list.address2}</td>
					<td>${list.address3}</td>
					<td>${list.job}</td>
					<td>${list.introduction}</td>
				</tr>
			</c:forEach>
			</form>
		</tbody>
	</table>
	
	
	<input type="button" id="upgradePrivileage" value="상담사로 승급">
	<input type="button" value="취소" onclick="javascript:history.back()">
</article>
</body>
</html>
