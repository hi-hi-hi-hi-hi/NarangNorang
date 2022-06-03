<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="/narangnorang/js/mynorang/dailyLog.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form action="/narangnorang/mynorang/dailylog/${datetime}" method="post">
		<div>
			<input type="date" name="datetime" value="${datetime}" readonly="readonly" required="required">
		</div>
		<div>
			잠 : <input type="number" name="sleep" value="${dailyLogDTO.sleep}" min="0" max="24" required="required">
		</div>
		<div>
			약 : 
			<input type="radio" name="medicine" value="0" <c:if test="${dailyLogDTO.medicine == 0}">checked="checked"</c:if>>X
			<input type="radio" name="medicine" value="1" <c:if test="${dailyLogDTO.medicine == 1}">checked="checked"</c:if>>
			<img src="/narangnorang/images/mynorang/medicine.png" width="20">
		</div>
		<c:choose>
			<c:when test="${empty dailyLogDTO}">
				<button>저장</button>
			</c:when>
			<c:otherwise>
				<button type="button" onclick="updateDailyLog()">수정</button>
				<button type="button" onclick="deleteDailyLog()">삭제</button>
			</c:otherwise>
		</c:choose>
		<button type="button" onclick="window.close()">닫기</button>
	</form>
</body>
</html>