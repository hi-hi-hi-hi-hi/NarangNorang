<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form action="/" method="post">
	아이디(이메일)<br>
	<input type="text" name="userid" id="userid"><br>
	비밀번호<br>
	<input type="text" name="passwd" id="passwd"><br>
	비밀번호 재확인<br>
	<input type="text" name="passwd2" id="passwd2"><br>
	<br>
	이름<br>
	<input type="text" name="username" id="username"><br>
	닉네임<br>
	<input type="text" name="username" id="username"><br>
	휴대전화<br>
	<input type="text" name="username" id="username"><br>
	<br>
	주소<br>
	<input type="text" name="post" id="sample4_postcode" placeholder="우편번호">
	<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
	<input type="text" name="addr1" id="sample4_roadAddress" placeholder="도로명주소">
	<input type="text" name="addr2" id="sample4_jibunAddress" placeholder="지번주소"><br>
	<input type="text" name="username" id="username" placeholder="상세주소"><br>
	<input type="submit" value="회원가입">
</form>