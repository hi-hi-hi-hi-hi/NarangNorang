<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="row">
		<c:forEach var="testResultDTO" items="${testResultList}" varStatus="status">
			<div class="col-auto m-2">
				<div class="card" style="width: 18rem;">
					<img src="/narangnorang/images/test/${testResultDTO.type}.jpg" class="card-img-top">
					<div class="card-body">
						<h5 class="card-title">
							<c:choose>
								<c:when test="${testResultDTO.type == 1}">우울증</c:when>
								<c:when test="${testResultDTO.type == 2}">알코올 중독</c:when>
								<c:when test="${testResultDTO.type == 3}">스트레스</c:when>
							</c:choose>
						</h5>
						<p class="card-text">${testResultDTO.datetime}</p>
						<a href="/narangnorang/test/${testResultDTO.type}/${testResultDTO.result}" class="btn btn-outline-dark">결과 보기</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>