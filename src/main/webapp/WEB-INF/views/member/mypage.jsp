<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나랑노랑</title>
</head>
<body>
<h3>회원 정보 확인</h3>
<p>정보를 안전하게 보호하기 위하여 비밀번호를 다시 확인 합니다.</p>
<form action="" method="post">
	아이디 : abc@naver.com<br>
	비밀번호 : <input type="text" name="password" required="required"><br>
	<input type="submit" value="확인">
	<input type="reset" value="취소" onclick="javascript:history.back()">
</form>
</body>
</html>