<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나랑노랑</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="/narangnorang/login" method="post">
		이메일 : <input type="text" name="email" required="required"><br>
		비밀번호 : <input type="text" name="password" required="required"><br>
		<input type="submit" value="로그인">
	</form>
	<a href="/narangnorang/findPw">Forgot Password?</a><br>
	<a href="/narangnorang/signUp">회원 가입</a>
</body>
</html>