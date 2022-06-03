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
		<th width="100">일</th>
		<th width="100">월</th>
		<th width="100">화</th>
		<th width="100">수</th>
		<th width="100">목</th>
		<th width="100">금</th>
		<th width="100">토</th>
	</tr>
	<tr><td colspan="7"><hr></td></tr>
	<tr>
		<c:forEach var="dailyLogDTO" items="${dailyLogCalendar}" varStatus="status">
			<c:set var="date" value="${status.count - (start - 1)}"/>
			<td height="80" style=" vertical-align: top;" <c:if test="${date > 0}">onclick="select('${year}', '${month}', '${date}')"</c:if>>
				<div>
					<c:if test="${date > 0}">
						<b>${date}</b>
					</c:if>
				</div>
				<div>
					<c:if test="${not empty dailyLogDTO}">
						<img src="/narangnorang/images/mynorang/sleep.png" width="20">
						<span style="color: orange;">${dailyLogDTO.sleep}</span>
					</c:if>
				</div>
				<div>
					<c:if test="${dailyLogDTO.medicine == 0}">X</c:if>
					<c:if test="${dailyLogDTO.medicine == 1}">
						<img src="/narangnorang/images/mynorang/medicine.png" width="20">
					</c:if>
				</div>
			</td>
			<c:if test="${!status.last && status.count % 7 == 0}">
				</tr><tr>
			</c:if>
		</c:forEach>
	</tr>
</table>