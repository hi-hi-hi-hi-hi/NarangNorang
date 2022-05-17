<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="js/daumMap.js"></script>
<script src="js/signUp.js"></script>

<form action="/narangnorang/mypage/edit" method="post">
	아이디 : ${login.id}<br>
	닉네임: <input type="text" name="nickname" id="nickname" placeholder="${login.nickname}"><br>
	휴대전화: <input type="text" name="phone" id="phone" placeholder="-제외 번호"><br>
	비밀번호 변경<br>
	새 비밀번호<br>
	<input type="text" name="password" id="password" placeholder="PASSWORD"><br>
	새 비밀번호 확인<br>
	<input type="text" name="password2" id="password2" placeholder="CONFIRM PASSWORD"><br>
	주소<br>
	<input type="text" name="zipcode" id="postcode" placeholder="우편번호">
	<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
	<input type="text" name="address1" id="roadAddress" placeholder="도로명주소">
	<input type="text" name="address2" id="jibunAddress" placeholder="지번주소"><br>
	<input type="text" name="address3" id="detailAddress" placeholder="상세주소"><br>
	<input type="hidden" id="guide" style="color:#999"></input><br>
	<input type="submit" value="확인">
	<input type="button" value="취소" onclick="javascript:history.back()">
</form>