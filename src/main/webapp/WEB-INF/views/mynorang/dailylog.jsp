<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="/narangnorang/js/mynorang/dailylog.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form>
		<div>
			<input type="datetime" name="datetime" value="${dailyLogDTO.datetime}">
		</div>
		<div>
			잠 : <input type="number" name="sleep" value="${dailyLogDTO.sleep}" min="0" max="24">
		</div>
		<div>
			약 : <input type="number" name="medicine" value="${dailyLogDTO.medicine}" min="0" max="1">
		</div>
		<c:choose>
			<c:when test="${dailyLogDTO.sleep == null && dailyLogDTO.medicine == null}">
				<button type="button" onclick="insertDailyLog()">저장</button>
			</c:when>
			<c:otherwise>
				<button type="button" onclick="updateDailyLog()">수정</button>
				<button type="button" onclick="deleteDailyLog()">삭제</button>
			</c:otherwise>
		</c:choose>
	</form>
</body>
</html>