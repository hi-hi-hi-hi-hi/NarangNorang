<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<a href="?year=${year - 1}&month=${month}" style="text-decoration: none;">▼</a>
	${year}년
	<a href="?year=${year + 1}&month=${month}" style="text-decoration: none;">▲</a>
</div>
<div>
	<c:choose>
		<c:when test="${month == 1}">
			<a href="?year=${year - 1}&month=${12}" style="text-decoration: none;">▼</a>
		</c:when>
		<c:otherwise>
			<a href="?year=${year}&month=${month - 1}" style="text-decoration: none;">▼</a>
		</c:otherwise>
	</c:choose>
	${month}월
	<c:choose>
		<c:when test="${month == 12}">
			<a href="?year=${year + 1}&month=${1}" style="text-decoration: none;">▲</a>
		</c:when>
		<c:otherwise>
			<a href="?year=${year}&month=${month + 1}" style="text-decoration: none;">▲</a>
		</c:otherwise>
	</c:choose>
</div>
<table>
	<tr>
		<td width="100">일</td>
		<td width="100">월</td>
		<td width="100">화</td>
		<td width="100">수</td>
		<td width="100">목</td>
		<td width="100">금</td>
		<td width="100">토</td>
	</tr>
	<tr>
		<c:forEach var="dailyLogDTO" items="${dailyLogCalendar}" varStatus="status">
			<td height="80" style="vertical-align: top;">
				<c:if test="${status.count > (start - 1)}">
					<div>
						${status.count - (start - 1)}<br>
						<c:if test="${not empty dailyLogDTO.sleep}">
							수면 : ${dailyLogDTO.sleep}<br>
						</c:if>
						<c:if test="${not empty dailyLogDTO.medicine}">
							복용 : ${dailyLogDTO.medicine}<br>
						</c:if>
					</div>
				</c:if>
			</td>
			<c:if test="${!status.last && status.count % 7 == 0}">
				</tr><tr>
			</c:if>
		</c:forEach>
	</tr>
</table>