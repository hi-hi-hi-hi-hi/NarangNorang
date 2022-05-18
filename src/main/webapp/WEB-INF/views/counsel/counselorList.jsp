<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<b>상담사 목록</b>

<c:forEach var="counselor" items="${counselorList}" varStatus="status">
	<table style="width: 600px; border: 1px solid gray; margin: 20px">
		<tr align="center">
			<td rowspan="6"><img src="./images/counsel/${counselor.id}.jpg"
				width="150" height="200"></td>
			<td><b style="font-size: 20px">${counselor.name}</b></td>
		</tr>
		<tr align="center">
			<td>${counselor.job}</td>
		</tr>
		<tr>
			<td><b>병원정보:</b> ${counselor.address2} ${counselor.address3}
				[${counselor.address1}]</td>
		</tr>
		<tr>
			<td><b>연락처:</b> ${counselor.phone}</td>
		</tr>
		<tr>
			<td>${counselor.introduction}</td>
		</tr>
		<tr align="right">
			<td>
				<button id="sendMessage" value="${counselor.name}"
					onclick="popMessageForm();">쪽지 보내기</button>
			</td>
		</tr>

	</table>
</c:forEach>


