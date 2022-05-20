<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지보내기</title>
<script>
	function closeChats() {
		window.close();
	}
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<h2> 
		<c:choose>
		<c:when test="${chats[0].sender == userId}">
			${chats[0].recieverNickname}${chats[0].recieverName}
		</c:when>
		<c:otherwise>
			${chats[0].senderNickname}${chats[0].senderName}
		</c:otherwise>
		</c:choose>
		님과의 채팅
	</h2>
	<table style="width:80%" border="1">
		<c:forEach items="${chats}" var="message">
			<tr>
				<td style="width:50%" align="left">
					<c:if test="${message.sender != userId}">
						${message.content} <br>
					</c:if>
				</td>
				<td style="width:50%" align="right">
					<c:if test="${message.sender == userId}">
						${message.content} <br>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		<tr>
		<td colspan="2" align="center">
				<input type="text" id="content">
				<button>전송</button>
		</td>
		</tr>
	</table>

	<br>
	<button onclick="closeChats();">닫기</button>
</html>