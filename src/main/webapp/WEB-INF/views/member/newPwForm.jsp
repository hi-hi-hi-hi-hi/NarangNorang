<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="js/newPw.js"></script>
<title>새 비밀번호 설정</title>
</head>
<body>
<form action="#" method="post">
	<input type="hidden" name="id" id="id" value="${findPw.id}">
	새 비밀번호<br>
	<input type="password" name="password" id="password" placeholder="새 비밀번호" required="required"><br>
	새 비밀번호 확인<br>
	<input type="password" name="password2" id="password2" placeholder="새 비밀번호 확인" required="required"><br>
	<span id="pwCheckResult"></span><br>
	<br>
	<input type="button" id="newPw" value="변경하기">
</form>
</body>
</html>