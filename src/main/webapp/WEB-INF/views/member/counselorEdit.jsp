<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="/narangnorang/js/daumMap.js"></script>
<script src="/narangnorang/js/member/counselorEdit.js"></script>

<form action="/narangnorang/photoUpdate" id="photoUpdate" method="post" enctype="multipart/form-data">
	<input type="hidden" name="_method" value="put"/>
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
	<input type="file" id="photoUpload" name="filename">
	<input type="submit" value="수정하기">
</form>
<form action="/narangnorang/counselorEdit" id="counselorEdit" method="post">
	<input type="hidden" name="_method" value="put"/>
	아이디 : <input type="text" name="email" id="email" value="${login.email}" readonly="readonly"><br>
	이름: <input type="text" name="name" id="name" value="${login.name}" readonly="readonly"><br>
	휴대전화: <input type="text" name="phone" id="phone" value="${login.phone}" required="required"><br>
	
	<br>
	근무지 주소<br>
	<input type="text" name="zipcode" id="postcode" value="${login.zipcode}" required="required">
	<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기" required="required"><br>
	<input type="text" name="address1" id="roadAddress" value="${login.address1}" required="required">
	<input type="text" name="address2" id="jibunAddress" value="${login.address2}" required="required"><br>
	<input type="text" name="address3" id="detailAddress" value="${login.address3}" required="required"><br>
	<input type="hidden" id="guide" style="color:#999"></input><br>
	직업<br>
	<input type="text" name="job" id="job" placeholder="job" value="${login.job}" required="required"><br>
	소개<br>
	<textarea rows="30" cols="50" name="introduction" id="introduction" required="required">${login.introduction}</textarea><br>
	<br>
	<a href="/narangnorang/myPage/newPwForm">비밀번호 변경</a><br>
	<br>
	<input type="submit" value="확인">
	<input type="button" value="취소" onclick="javascript:history.back()">
</form>