<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나랑노랑</title>
</head>
<body>
	<h1>심리상담</h1>
	<jsp:include page="common/top.jsp" flush="true" /><br>
	<jsp:include page="common/navBar.jsp" flush="true" /><br>
	<hr>

	<jsp:include page="counsel/sideBar.jsp" flush="true"/><br>
	<c:choose>
		<c:when test="${empty counselorList}">
			<jsp:include page="counsel/counselCenterMap.jsp" flush="true" />
			
		</c:when>
		<c:otherwise>
			<jsp:include page="counsel/counselorList.jsp" flush="true" />
		</c:otherwise>
	</c:choose>
</body>
</html>

