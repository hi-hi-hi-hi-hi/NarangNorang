<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지보내기</title>
<script>
function closeChats(){
	window.close();
}

</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>

<body>
	<h1>채팅</h1>
	${chats}
	<input type="text" id="content"><button>전송</button><br>
	<button onclick="closeChats();">닫기</button>
</html>