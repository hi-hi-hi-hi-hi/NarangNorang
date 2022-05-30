<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/narangnorang/js/member/generalEdit.js"></script>

<form action="/narangnorang/photoUpdate" id="photoUpdate" method="post" enctype="multipart/form-data">
	<input type="hidden" name="_method" value="put"/>
	<input type="hidden" name="email" value="${login.email}">
	프로필 사진<br>
	<div>
		<c:choose>
			<c:when test="${login.photo == null}">
				<img style="width:100px; height:100px;" src="/narangnorang/images/member/noImage.jpg">
			</c:when>
			<c:otherwise>
				<img style="width:100px; height:100px;" src="/narangnorang/images/member/${login.id}.png">
			</c:otherwise>
		</c:choose>
	</div>
	<input type="file" id="photoUpdate" name="filename">
	<input type="submit" value="수정하기">
</form>
<br>
<form action="/narangnorang/generalEdit" id="generalEdit" method="post">
	<input type="hidden" name="_method" value="put"/>
	이메일: <input type="email" name="email" id="email" value="${login.email}" readonly="readonly"><br>
	닉네임: <input type="text" name="name" id="name" value="${login.name}" required="required">
	<input type="hidden" name="originName" id="originName" value="${login.name}" required="required">
	<input type="button" id="checkNickname" value="중복 체크"><br>
	<span id="nicknameCheck" style="color:blue"></span><br>
	휴대전화: <input type="text" name="phone" id="phone" value="${login.phone}" required="required"><br>
	지역: <input type="text" name="region" id="region" value="${login.region}" required="required"><br>
	<br>
	<a href="/narangnorang/myPage/newPwForm">비밀번호 변경</a><br>
	<br>
	<input type="submit" value="확인">
	<input type="button" value="취소" onclick="javascript:history.back()">
</form>