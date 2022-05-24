<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="w-50 mx-auto text-center">
	<img src="/narangnorang/images/test/${type}.jpg" class="w-50 rounded-circle mx-auto my-5 d-block">
	<h5>${result}점</h5>
	<c:choose>
		<c:when test="${result < 16}">
			<div>정상</div>
		</c:when>
		<c:when test="${result < 21}">
			<div>약간의 우울감</div>
		</c:when>
		<c:when test="${result < 25}">
			<div>심한 우울감</div>
		</c:when>
		<c:otherwise>
			<div>매우 심한 우울감</div>
		</c:otherwise>
	</c:choose>
</div>