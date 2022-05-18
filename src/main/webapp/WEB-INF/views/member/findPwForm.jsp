<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="js/findPw.js"></script>
<link rel="stylesheet" href="css/signUp.css">
<title>계정 찾기</title>
</head>
<body>
<form action="/narangnorang/findPw" id="findPw" method="post">
	아이디(이메일)<br>
	<input type="text" name="id" id="id" required="required">
	<input type="button" id="checkId" value="아이디 확인">
	<input type="button" id="sendMail" value="인증메일보내기"><br>
	<span id="check-text"></span><br>
	<br>
	인증 번호<br>
	<input type="text" name="com" id="com" placeholder="인증확인">
	<input type="button" id="compare" value="인증하기"><br>
	<span id="compare-text"></span><br>
	<br>
	<input type="submit" value="새 비번 설정하러 가기">
</form>
</body>
</html>