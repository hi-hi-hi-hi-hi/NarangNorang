<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나랑노랑</title>

	<script type="text/javascript" src="/narangnorang/js/miniroom.js"></script>
	<!-- jQuery -->
	<script src="js/jquery-2.1.0.min.js"></script>

</head>
<body>
	<h1>홈</h1>
	<jsp:include page="common/top.jsp" flush="true" /><br>
	<jsp:include page="common/navBar.jsp" flush="true" /><br>
	<jsp:include page="miniroom/miniroomLink.jsp" flush="true" /><br>
	<jsp:include page="miniroom/miniroom_buy.jsp" flush="true" />

</body>
</html>