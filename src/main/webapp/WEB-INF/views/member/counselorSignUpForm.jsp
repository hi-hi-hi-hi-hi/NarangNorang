<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="js/daumMap.js"></script>
<script src="js/counselorSignUp.js"></script>
<link rel="stylesheet" href="css/signUp.css">

<div class="container">
	<form action="/narangnorang/counselorSignUp" id="counselor" method="post">
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
		이름<br>
		<input type="text" name="name" id="name" placeholder="NAME" required="required"><br>
		휴대전화<br>
		<input type="text" name="phone" id="phone" placeholder="-제외 번호" required="required"><br>
		<br>
		근무지 주소<br>
		<input type="text" name="zipcode" id="postcode" placeholder="우편번호" required="required">
		<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
		<input type="text" name="address1" id="roadAddress" placeholder="도로명주소" required="required">
		<input type="text" name="address2" id="jibunAddress" placeholder="지번주소" required="required"><br>
		<input type="text" name="address3" id="detailAddress" placeholder="상세주소" required="required"><br>
		<input type="hidden" id="guide" style="color:#999"></input><br>
		직업<br>
		<input type="text" name="job" id="job" placeholder="job" required="required"><br>
		소개<br>
		<textarea rows="30" cols="50" name="introduction" id="introduction" required="required"></textarea><br>
		<br>
		<input type="submit" value="회원가입">
	</form>
</div>