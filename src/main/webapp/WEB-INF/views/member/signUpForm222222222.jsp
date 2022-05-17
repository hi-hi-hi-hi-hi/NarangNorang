<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="js/daumMap.js"></script>
<script src="js/signUp.js"></script>
<link rel="stylesheet" href="css/signUp.css">

<form action="/narangnorang/signUp" method="post">
	아이디(이메일)<br>
	<input type="text" name="id" id="id" placeholder="Email">
	<input type="button" onclick="checkId()" value="중복 체크">
	<input type="button" class="sendMail" value="인증메일보내기"><br>
	<span class="id_ok">사용 가능한 아이디입니다.</span>
	<span class="id_already">이미 등록된 아이디입니다.</span><br>
	인증확인<br>
	<input type="text" name="com" id="com" placeholder="인증확인">
	<input type="button" class="compare" value="인증확인"><br>
	<span class="compare-text"></span><br>
	비밀번호<br>
	<input type="text" name="password" id="password" placeholder="PASSWORD"><br>
	비밀번호 확인<br>
	<input type="text" name="password2" id="password2" placeholder="CONFIRM PASSWORD"><br>
	<span id="pwCheckResult" style="color:red"></span><br>
	<br>
	이름<br>
	<input type="text" name="name" id="name" placeholder="NAME"><br>
	닉네임<br>
	<input type="text" name="nickname" id="nickname" placeholder="NICKNAME"><br>
	휴대전화<br>
	<input type="text" name="phone" id="phone" placeholder="-제외 번호"><br>
	<br>
	주소<br>
	<input type="text" name="zipcode" id="postcode" placeholder="우편번호">
	<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
	<input type="text" name="address1" id="roadAddress" placeholder="도로명주소">
	<input type="text" name="address2" id="jibunAddress" placeholder="지번주소"><br>
	<input type="text" name="address3" id="detailAddress" placeholder="상세주소"><br>
	<input type="hidden" id="guide" style="color:#999"></input><br>
	<br>
	<input type="submit" value="회원가입">
</form>