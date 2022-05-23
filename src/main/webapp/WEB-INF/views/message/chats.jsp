<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지보내기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	function closeChats() {
		window.close();
	};
	
	function sendMessage(userId, otherId){
		var data = {
				"content": $("#content").val(),
				"sender": userId,
				"reciever" : otherId
		}
		console.log(data);
		$.ajax({
			type : "POST",
			url : "/narangnorang/message/send",
			data : JSON.stringify(data),
			dataType : "json",
			contentType:"application/json;charset=UTF-8",
			success : function(data){
		 		if (data.result == "ok"){
					location.reload();
					opener.location.reload();
					//getMessages();
				};
			},
			error : function(xhr, status, e){
				alert("전송 실패");
			}
		});
	}
	
	
	
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>

<body>
	<h2>
		<c:choose>
			<c:when test="${(empty chats[0].recieverNickname && empty chats[0].recieverName) || (empty chats[0].senderNickname && empty chats[0].senderName)}">
				"탈퇴한 사용자"
			</c:when>
			<c:when test="${chats[0].sender == userId}">
				${chats[0].recieverNickname}${chats[0].recieverName}
			</c:when>
			<c:otherwise>
				${chats[0].senderNickname}${chats[0].senderName}
			</c:otherwise>
		</c:choose>
		님과의 채팅
	</h2>
	
	<table style="width:80%" border="1" >
		<c:forEach items="${chats}" var="message">
			<tr>
				<td style="width: 50%" align="left">
					<c:if test="${message.sender != userId}">
						${message.content} <br>
					</c:if>
				</td>
				<td style="width: 50%" align="right">
					<c:if test="${message.sender == userId}">
						${message.content} <br>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		
		<tr>
			<td colspan="2" align="center">
				<input type="text" id="content">
				<c:choose>
					<c:when test="${(empty chats[0].recieverNickname && empty chats[0].recieverName) || (empty chats[0].senderNickname && empty chats[0].senderName)}">
						<button disabled>전송</button>
					</c:when>
					<c:otherwise>
						<button id="sendMessage" onclick="sendMessage('${userId}', '${otherId}')">전송</button>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>

	<br>
	<button onclick="closeChats();">닫기</button>
</html>