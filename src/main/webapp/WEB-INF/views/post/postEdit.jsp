<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나랑노랑</title>
</head>
<body>
	<form>
		<input type="hidden" id="category" value="${pDto.category}">
		제목:<input type="text" id="title" value="${pDto.title}"><br>
		내용:<textarea id="content">${pDto.content}</textarea><br>
	</form>
	<button id="btn_update">수정</button>
</body>
</html>