<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/narangnorang/css/retrieve.css">
<script type="text/javascript" src="/narangnorang/js/retrieve.js"></script>
</head>
<body>
	<h1>부서등록화면</h1>
	<img src="/narangnorang/images/retrieve.png" width="100"><br>
	<form action="/narangnorang/departments/${deptDTO.deptno}" method="post">
		<input type="hidden" name="_method" value="put"/>
		부서번호:<input type="text" name="deptno" value="${deptDTO.deptno}" readonly="readonly"><br>
		부서명:<input type="text" name="dname" value="${deptDTO.dname}"><br>
		부서위치:<input type="text" name="loc" value="${deptDTO.loc}"><br>
		<input type="submit" value="수정">
	</form>
	<form action="/narangnorang/departments/${deptDTO.deptno}" method="post">
		<input type="hidden" name="_method" value="delete"/>
		<input type="submit" value="삭제">
	</form>
</body>
</html>