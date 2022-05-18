<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="js/findPw.js"></script>
<title>계정 찾기</title>
</head>
<body>
<form action="/narangnorang/findPw" id="findPw" method="post">
	아이디(이메일)<br>
	<input type="text" name="id" id="id" required="required"><br>
	<input type="submit" value="찾기">
</form>
</body>
</html>