<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table border="1" style="width: 500px">
	<c:forEach items="${messageList}" var="message">
		<tr>

			<c:choose>

				<c:when test="${message.sender==id}">
					<c:choose>
						<c:when test="${empty message.recieverName}">
							<td>${message.recieverNickname}</td>
						</c:when>
						<c:otherwise>
							<td>${message.recieverName}<b style="font-size:11px; color:green"> 상담사</b></td>
						</c:otherwise>
					</c:choose>
				</c:when>

				<c:otherwise>
					<c:choose>
						<c:when test="${empty message.senderName}">
							<td>${message.senderNickname}</td>
						</c:when>
						<c:otherwise>
							<td>${message.senderName}</td>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>

			<td><a href="">${message.content}</a></td>
			<td>${message.datetime}</td>
		</tr>

	</c:forEach>
</table>