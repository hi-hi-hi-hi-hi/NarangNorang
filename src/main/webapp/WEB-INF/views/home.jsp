<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나랑노랑</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script type="text/javascript" src="/narangnorang/js/miniroom/miniroom.js"></script>
	
	<script type="text/javascript" src="/narangnorang/js/norang/norang.js"></script>
	<script type="text/javascript" src="/narangnorang/js/norang/convform.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="css/norang.css">
	<link rel="stylesheet" type="text/css" href="css/convform.css">
	
</head>
<body>
<c:choose>
	<c:when test="${privilege eq 3}">
	<h1>홈</h1>
	<jsp:include page="common/top.jsp" flush="true" /><br>
	<jsp:include page="common/navBar.jsp" flush="true" /><br>
	<jsp:include page="miniroom/miniroomLink.jsp" flush="true" /><br>
	<jsp:include page="norang/norang.jsp" flush="true" />
	</c:when>
	<c:when test="${privilege eq 0}">
		<h1>관리자 HOME.</h1>
		<jsp:include page="common/top.jsp" flush="true" /><br>
		<jsp:include page="common/navBar.jsp" flush="true" /><br>
		<img src="/narangnorang/images/Norang.png" width="500px">
	</c:when>
	<c:otherwise>
		<h1>상담사 HOME.</h1>
		<jsp:include page="common/top.jsp" flush="true" /><br>
		<jsp:include page="common/navBar.jsp" flush="true" /><br>
		<img src="/narangnorang/images/Norang.png" width="500px">
	</c:otherwise>
</c:choose>
</body>
</html>