<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table border="1" style="width: 500px">
	<c:forEach items="${messageList}" var="message">
		<tr>
			<td>
				<c:if test="${empty message.senderName || empty message.recieverName}">
					<b style="font-size: 11px; color: grey">탈퇴한 사용자</b>
				</c:if>
				
				<c:choose>
					<c:when test="${message.senderId==id}">
						<c:set var="otherId" value="${message.recieverId}" />
							${message.recieverName}
						<c:if test="${message.recieverPrivilege == 1 && !empty message.recieverName}">
							<b style="font-size: 11px; color: green"> 상담사</b>
						</c:if>
					</c:when>

					<c:otherwise>
						<c:set var="otherId" value="${message.senderId}" />
							${message.senderName}
						<c:if test="${message.senderPrivilege == 1 && !empty message.senderName}">
							<b style="font-size: 11px; color: green"> 상담사</b>
						</c:if>
					</c:otherwise>
				</c:choose>
			</td>

			<td><a href="javascript:popChats('${otherId}');">${message.content}</a></td>
			<td>${message.datetime}</td>
		</tr>

	</c:forEach>
</table>