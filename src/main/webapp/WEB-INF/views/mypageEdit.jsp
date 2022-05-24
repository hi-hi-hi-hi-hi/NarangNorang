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
	<h1>회원 정보 수정</h1>
	<jsp:include page="common/top.jsp" flush="true" /><br>
	<jsp:include page="common/navBar.jsp" flush="true" /><br>
	<c:set var="privilege" value="${login.privilege}" />
	<c:choose>
		<c:when test="${privilege == 3}">
			<jsp:include page="member/generalEdit.jsp" flush="true" /><br>
		</c:when>
		<c:when test="${privilege == 2 or privilege == 1}">
			<jsp:include page="member/counselorEdit.jsp" flush="true" /><br>
		</c:when>
	</c:choose>
	
</body>
</html>