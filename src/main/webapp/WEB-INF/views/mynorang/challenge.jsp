<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="row">
		<c:forEach var="challengeDTO" items="${challengeList}" varStatus="status">
			<div class="col-auto m-2">
				<div class="card" style="width: 18rem;">
					<img src="/narangnorang/resources/images/challenge/${challengeDTO.memberId}_${challengeDTO.datetime}.png" class="card-img-top" height="200px;">
					<div class="card-body">
						<h5 class="card-title">${challengeDTO.title}</h5>
						<p class="card-text">${challengeDTO.datetime}</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>