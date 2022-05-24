<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="w-50 mx-auto text-center">
	<img src="/narangnorang/images/test/${type}.jpg" class="w-50 rounded-circle mx-auto my-5 d-block">
	<h5>${result}점</h5>
	<c:choose>
		<c:when test="${result < 14}">
			<div>정상범위로 유의한 수준의 스트레스가 시사되지 않습니다.</div>
		</c:when>
		<c:when test="${result < 17}">
			<div>약간의 스트레스를 받고 있으나 심각한 수준은 아닌 것으로 보입니다. 자신만의 스트레스 해소법을 찾아보는 것이 좋습니다.</div>
		</c:when>
		<c:when test="${result < 19}">
			<div>중간정도의 스트레스로, 스트레스 해소에 적극적인 노력이 필요합니다.</div>
		</c:when>
		<c:otherwise>
			<div>심한 스트레스로 일상생활에서 어려움을 겪고 있을 것으로 판단되며 전문가의 도움이 필요합니다.</div>
		</c:otherwise>
	</c:choose>
</div>