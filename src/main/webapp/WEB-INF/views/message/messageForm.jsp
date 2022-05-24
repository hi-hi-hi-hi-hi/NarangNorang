<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지보내기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="/narangnorang/js/message/messageForm.js"></script>
</head>

<body>
	<h1>상담신청</h1>
	<form id="messageForm">
		받는사람: <b>${counselor.name}</b> 상담사 
		<input type="hidden"id="id" value="${counselor.id}" />
		<input type="hidden"id="privilege" value="${counselor.privilege}" />
		<textarea id="content" rows="20" cols="60"></textarea>
	</form>
	<button type="submit" id="button">보내기</button>
</body>
</html>