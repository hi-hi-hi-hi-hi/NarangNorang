<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나랑노랑</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<h1>쪽지함</h1>
	<jsp:include page="common/top.jsp" flush="true" /><br>
	<jsp:include page="common/navBar.jsp" flush="true" /><br>
	<hr>
	<jsp:include page="message/messageList.jsp" flush="true"/>
	<script type="text/javascript" src="/narangnorang/js/message/messageList.js"></script>
</body>
</html>