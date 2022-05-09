<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>목록보기</h1>
	<table border="1">
		<tr>
			<th>부서번호</th>
			<th>부서명</th>
			<th>부서이름</th>
		</tr>
		<c:forEach var="dto" items="${list}" varStatus="status">
			<tr>
				<td>${dto.deptno}</td>
				<td><a href="departments/${dto.deptno}">${dto.dname}</a></td>
				<td>${dto.loc}</td>
			</tr>
		</c:forEach>
	</table>
	<form action="departments" method="post">
		부서번호:<input type="text" name="deptno"><br>
		부서명:<input type="text" name="dname"><br>
		부서위치:<input type="text" name="loc"><br>
		<input type="submit" value="저장">
	</form>
</body>
</html>