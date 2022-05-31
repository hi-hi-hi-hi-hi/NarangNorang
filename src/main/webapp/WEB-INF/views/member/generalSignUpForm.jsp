<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="js/daumMap.js"></script>
<script src="js/generalSignUp.js"></script>
<link rel="stylesheet" href="css/signUp.css">

<div class="container">
	<form action="/narangnorang/generalSignUp" id="general" method="post">
		아이디(이메일)<br>
		<input type="email" name="email" id="email" placeholder="Email" required="required">
		<input type="button" id="checkEmail" value="중복 체크">
		<input type="button" id="sendMail" value="인증메일보내기"><br>
		<span id="emailCheckResult" style="color:blue"></span><br>
		인증확인<br>
		<input type="text" name="com" id="com" placeholder="인증확인" required="required">
		<input type="button" id="compare" value="인증확인"><br>
		<span id="compare-text"></span><br>
		비밀번호<br>
		<input type="password" name="password" id="password" placeholder="PASSWORD" required="required"><br>
		비밀번호 확인<br>
		<input type="password" name="password2" id="password2" placeholder="CONFIRM PASSWORD" required="required"><br>
		<span id="pwCheckResult" style="color:blue"></span><br>
		<br>
		닉네임<br>
		<input type="text" name="name" id="name" placeholder="NICKNAME" required="required">
		<input type="button" id="checkName" value="중복 체크"><br>
		<span id="nicknameCheckResult" style="color:blue"></span><br>
		휴대전화<br>
		<input type="text" name="phone" id="phone" placeholder="-제외 번호" required="required"><br>
		<br>
		지역<br>
		<input type="text" name="region" id="region" placeholder="지역(시/군/구)" required="required"><br>
		<br>
		<input type="submit" value="회원가입">
	</form>
</div>