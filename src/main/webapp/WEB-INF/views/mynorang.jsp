<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<!-- Bootstrap -->
<title>나랑노랑</title>
</head>
<body>
	<h1>나의노랑</h1>
	<jsp:include page="common/top.jsp" flush="true" /><br>
	<jsp:include page="common/navBar.jsp" flush="true" /><br>
	<jsp:include page="common/norang.jsp" flush="true" /><br>
	<c:choose>
		<c:when test="${not empty dailyLogCalendar}">
			<script type="text/javascript" src="/narangnorang/js/mynorang/dailyLogCalendar.js"></script>
			<jsp:include page="mynorang/dailyLogCalendar.jsp" flush="true" /><br>
		</c:when>
		<c:when test="${not empty moodStateList}">
			
		</c:when>
	</c:choose>
</body>
</html>