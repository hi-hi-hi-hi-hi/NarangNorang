<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지보내기</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>

</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="/narangnorang/js/message/chats.js"></script>
</head>

<body>
	
		<h2>
			<c:choose>
				<c:when test="${chats[0].senderId == login.id}">
					<input type="hidden" id="recieverId" value="${chats[0].recieverId}" />
					<input type="hidden" id="recieverName"
						value="${chats[0].recieverName}" />
					<input type="hidden" id="recieverPrivilege"
						value="${chats[0].recieverPrivilege}" />
				${chats[0].recieverName}
			</c:when>
				<c:otherwise>
					<input type="hidden" id="recieverId" value="${chats[0].senderId}" />
					<input type="hidden" id="recieverName"
						value="${chats[0].senderName}" />
					<input type="hidden" id="recieverPrivilege"
						value="${chats[0].senderPrivilege}" />
				${chats[0].senderName}
			</c:otherwise>
			</c:choose>
			<c:if
				test="${empty chats[0].senderName || empty chats[0].recieverName}">
				<b style="font-size: 20px; color: grey">탈퇴한 사용자</b>
			</c:if>
			님과의 채팅
		</h2>
<div id="chatsHistory">
		<table style="width: 80%" border="1">
			<c:forEach items="${chats}" var="message">
				<tr>
					<td style="width: 50%" align="left"><c:if
							test="${message.senderId != login.id}">
						${message.content} <br>
						</c:if></td>
					<td style="width: 50%" align="right"><c:if
							test="${message.senderId == login.id}">
						${message.content} <br>
						</c:if></td>
				</tr>
			</c:forEach>
		</table>
		</div>
			<input type="text" id="content">
					<c:choose>
						<c:when
							test="${empty chats[0].senderName || empty chats[0].recieverName}">
							<button disabled>전송</button>
						</c:when>
						<c:otherwise>
							<button id="sendMessage"
								onclick="sendMessage(${login.id}, '${login.name}', ${login.privilege})">전송</button>
						</c:otherwise>
					</c:choose>


		<br>
		<button onclick="closeChats();">닫기</button>
	
</html>