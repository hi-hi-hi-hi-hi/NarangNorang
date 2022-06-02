<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
<c:choose>
	<c:when test = "${category eq '대나무숲'}">
		<form action="/narangnorang/post/write" method="post">
			<input type="hidden" name="category" value="${category}">
			<input type="hidden" name="title" value=null>
			<textarea name="content"></textarea><br>
			<button type="submit" id="btn_register">등록</button>
		</form>
	</c:when>
	<c:otherwise>
		<form action="/narangnorang/post/write" method="post">
			<input type="hidden" name="category" value="${category}">
			제목:<input type="text" name="title"><br>
			내용:<textarea name="content"></textarea><br>
			<button type="submit" id="btn_register">등록</button>
		</form>
	</c:otherwise>
</c:choose>
</body>
</html>