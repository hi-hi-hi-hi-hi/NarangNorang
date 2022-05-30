<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<a href="?year=${map.year - 1}&month=${map.month}" style="text-decoration: none;">▼</a>
	${map.year}년
	<a href="?year=${map.year + 1}&month=${map.month}" style="text-decoration: none;">▲</a>
</div>
<div>
	<c:choose>
		<c:when test="${map.month == 1}">
			<a href="?year=${map.year - 1}&month=${12}" style="text-decoration: none;">▼</a>
		</c:when>
		<c:otherwise>
			<a href="?year=${map.year}&month=${map.month - 1}" style="text-decoration: none;">▼</a>
		</c:otherwise>
	</c:choose>
	${map.month}월
	<c:choose>
		<c:when test="${map.month == 12}">
			<a href="?year=${map.year + 1}&month=${1}" style="text-decoration: none;">▲</a>
		</c:when>
		<c:otherwise>
			<a href="?year=${map.year}&month=${map.month + 1}" style="text-decoration: none;">▲</a>
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
		<c:set var="br" value="${0}" />
		<c:forEach var="i" begin="1" end="${map.start - 1}">
			<td></td>
			<c:set var="br" value="${br + 1}" />
			<c:if test="${br % 7 == 0}">
				<br>
			</c:if>
		</c:forEach>
		<c:forEach var="i" begin="1" end="${map.end}">
			<td>${i}</td>
			<c:set var="br" value="${br + 1}" />
			<c:if test="${br % 7 == 0}">
				<tr></tr>
			</c:if>
		</c:forEach>
	</tr>
</table>
<%-- <table>
	<tr>
		<c:forEach var="i" begin="${2 - map.start}" end="${map.end}">
			<c:choose>
				<c:when test="${i < 1}">
					<td></td>
				</c:when>
				<c:when test="${i < 1}">
					<td></td>
				</c:when>
			</c:choose>
		</c:forEach>
	</tr>
</table> --%>