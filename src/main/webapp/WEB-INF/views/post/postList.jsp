<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티</title>
</head>
<body>
<ul>
	<li><button id="btn_freeBoard">자유게시판</button></li>
	<li><button id="btn_infoBoard">정보게시판</button></li>
	<li><button id="btn_goodWordBoard">예쁜말게시판</button></li>
	<li><button id="btn_bambooBoard">대나무숲</button></li>
</ul>
<div id="postTable"></div>
<div id="paging"></div>
<input type="hidden" id="userId" value="${sessionScope.login.id}">
</body>
</html>