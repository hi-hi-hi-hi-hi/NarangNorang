<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="js/member/mypage.js"></script>

<h3>회원 정보 확인</h3>
<p>정보를 안전하게 보호하기 위하여 비밀번호를 다시 확인 합니다.</p>
<form>
	<input type="hidden" name="privilege" id="privilege" value="${login.privilege}"><br>
	이메일 : ${login.email}<br>
	<input type="hidden" name="password2" id="password2" value="${login.password}"><br>
	비밀번호: <input type="password" name="password" id="password" required="required"><br>
	<input type="button" id="pwCheck" value="확인">
	<input type="button" value="취소" onclick="javascript:history.back()">
</form>
