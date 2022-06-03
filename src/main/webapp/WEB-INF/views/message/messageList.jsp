<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="chatsList">
	<table border="1" style="width: 500px">
		<c:forEach items="${messageList}" var="message">
			<tr>
			<!-- 사용자 이름 -->
				<td><c:if
						test="${empty message.senderName || empty message.recieverName}">
						<b style="font-size: 11px; color: grey">탈퇴한 사용자</b>
					</c:if> <c:choose>
						<c:when test="${message.senderId==userId}">
							<c:set var="otherId" value="${message.recieverId}" />
							${message.recieverName}
						<c:if
								test="${message.recieverPrivilege == 1 && !empty message.recieverName}">
								<b style="font-size: 11px; color: green"> 상담사</b>
							</c:if>
						</c:when>

						<c:otherwise>
							<c:set var="otherId" value="${message.senderId}" />
							${message.senderName}
						<c:if
								test="${message.senderPrivilege == 1 && !empty message.senderName}">
								<b style="font-size: 11px; color: green"> 상담사</b>
							</c:if>
						</c:otherwise>
					</c:choose></td>
				
				<!-- 가장 최근 내용 및 시간 -->
				<td><a href="javascript:popChats('${otherId}');">${message.content}</a>
					<c:if test="${message.read==0 && message.senderId!=userId}">
						<b style="font-size: 11px; color: red"> new!</b>
					</c:if>
				</td>
				<td>${message.datetime}</td>
			</tr>

		</c:forEach>
	</table>
</div>