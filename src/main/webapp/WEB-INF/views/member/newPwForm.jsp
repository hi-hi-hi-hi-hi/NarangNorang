<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="js/findPw.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>새 비밀번호 등록</title>
</head>
<body>
<form action="/narangnorang/newPw" id="newPw" method="post">
	인증 번호<br>
	<input type="text" name="com" id="com" placeholder="인증확인"><br>
	새 비밀번호<br>
	<input type="text" name="password" id="password" placeholder="새 비밀번호"><br>
	새 비밀번호 확인<br>
	<input type="text" name="password2" id="password2" placeholder="새 비밀번호 확인"><br>
	<input type="submit" value="변경하기">
</form>
</body>
</html>