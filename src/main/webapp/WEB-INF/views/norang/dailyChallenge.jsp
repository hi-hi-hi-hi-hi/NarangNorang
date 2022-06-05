<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/narangnorang/js/norang/dailyChallenge.js"></script>

<h1>오늘의 챌린지!</h1>
<h2>${dailyChallenge}</h2>
<c:choose>
	<c:when test="${file}">
		<h2>오늘의 챌린지 도전 완료!</h2><br>
		<div id="img_container" style="width: 400px; height: 400px; background-color: #dedede;">
			<img style="position: relative; width:400px; height: 400px; text-align: center;" src="/narangnorang/images/norang/dailyChallenge/${login.id}_${today}.png">
		</div>
	</c:when>
	<c:otherwise>
		<form action="/narangnorang/dailyChallengeUpload" method="post" enctype="multipart/form-data">
			<h2>도전 가보자!</h2><br>
			<input type="file" name="img_upload" id="img_upload"  onchange="setThumbnail(event)" required="required"><br>
			<br>
			<div id="img_container" style="width: 400px; height: 400px; background-color: #dedede;"></div>
			<br>
			<input type="text" name="title" id="title" placeholder="사진 이름" required="required"><br>
			<input type="submit" value="업로드" onclick="dataSubmit()">
		</form>
	</c:otherwise>
</c:choose>