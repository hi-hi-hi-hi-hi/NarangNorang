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
		<c:when test="${not empty testResultList}">
			<jsp:include page="test/results.jsp" flush="true" /><br>
		</c:when>
		<c:when test="${not empty result}">
			<jsp:include page="test/result${type}.jsp" flush="true" /><br>
		</c:when>
		<c:when test="${not empty type}">
			<script type="text/javascript" src="/narangnorang/js/test/qnaList${type}.js"></script>
			<script type="text/javascript" src="/narangnorang/js/test/test.js"></script>
			<jsp:include page="test/test.jsp" flush="true" /><br>
		</c:when>
		<c:otherwise>
			<jsp:include page="test/list.jsp" flush="true" /><br>
		</c:otherwise>
	</c:choose>
</body>
</html>