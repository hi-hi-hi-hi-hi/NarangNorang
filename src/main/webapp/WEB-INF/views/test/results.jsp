<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table border="1">
	<tr>
		<th>유형</th>
		<th>일시</th>
	</tr>
	<c:forEach var="testResultDTO" items="${testResultList}" varStatus="status">
		<tr>
			<td>
				<a href="/narangnorang/test/${testResultDTO.type}/${testResultDTO.result}">
					<c:choose>
						<c:when test="${testResultDTO.type == 1}">우울증</c:when>
						<c:when test="${testResultDTO.type == 2}">알코올 중독</c:when>
						<c:when test="${testResultDTO.type == 3}">스트레스</c:when>
					</c:choose>
				</a>
			</td>
			<td>${testResultDTO.datetime}</td>
		</tr>
	</c:forEach>
</table>