<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="js/member/mypage.js"></script>

<h3>회원 정보 확인</h3>
<p>정보를 안전하게 보호하기 위하여 비밀번호를 다시 확인 합니다.</p>
<form action="/narangnorang/mypage/edit" id="pwCheck" method="post">
	아이디 : ${login.id}<br>
	<input type="hidden" name="password2" id="password2" value="${login.password}"><br>
	비밀번호: <input type="text" name="password" id="password"><br>
	<input type="submit" value="확인">
	<input type="button" value="취소" onclick="javascript:history.back()">
</form>
