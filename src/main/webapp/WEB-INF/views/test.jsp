<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나랑노랑</title>
</head>
<body>
	<h1>테스트</h1>
	<jsp:include page="common/top.jsp" flush="true" /><br>
	<jsp:include page="common/navBar.jsp" flush="true" /><br>
	<c:choose>
		<c:when test="${not empty result}">
			<h2>결과${result}</h2>
			<jsp:include page="test/result${result}.jsp" flush="true" /><br>
		</c:when>
		<c:when test="${not empty type}">
			<h2>유형${type}</h2>
			<jsp:include page="test/type${type}.jsp" flush="true" /><br>
		</c:when>
		<c:otherwise>
			<h2>목록</h2>
			<jsp:include page="test/list.jsp" flush="true" /><br>
		</c:otherwise>
	</c:choose>
</body>
</html>