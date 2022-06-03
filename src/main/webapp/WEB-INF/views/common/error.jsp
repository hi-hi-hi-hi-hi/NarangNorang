<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나랑노랑</title>
</head>
<body>
	<h1>에러</h1>
	<%
		out.print(exception);
	%>
	<a href="/narangnorang/login">로그인</a>
</body>
</html>