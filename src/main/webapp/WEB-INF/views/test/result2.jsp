<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${result < 12}">
		<div>정상적인 음주형태</div>
	</c:when>
	<c:when test="${result < 15}">
		<div>상습적 과음주자로 주의가 필요</div>
	</c:when>
	<c:when test="${result < 20}">
		<div>문제음주자로 적절한 조취가 필요</div>
	</c:when>
	<c:when test="${result < 25}">
		<div>전문가와 상담이 요구됨</div>
	</c:when>
	<c:otherwise>
		<div>알코올 중독자로 전문적 입원치료 및 상담필요</div>
	</c:otherwise>
</c:choose>