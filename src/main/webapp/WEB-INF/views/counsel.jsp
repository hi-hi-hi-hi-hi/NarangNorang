<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나랑노랑</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- services 라이브러리 불러오기 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7c812e8a4271a0b1aa964940c3e5e02c&libraries=services"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7c812e8a4271a0b1aa964940c3e5e02c"></script>

<script type="text/javascript" src="/narangnorang/js/counsel/counselorList.js"></script>
</head>
<body>
	<h1>심리상담</h1>
	<jsp:include page="common/top.jsp" flush="true" /><br>
	<jsp:include page="common/navBar.jsp" flush="true" /><br>
	<hr>

	<jsp:include page="counsel/sideBar.jsp" flush="true"/><br>
	<c:choose>
		<c:when test="${empty counselorList}">
			<jsp:include page="counsel/counselCenterMap.jsp" flush="true" />
			
		</c:when>
		<c:otherwise>
			<jsp:include page="counsel/counselorList.jsp" flush="true" />
		</c:otherwise>
	</c:choose>
	
<script type="text/javascript" src="/narangnorang/js/counsel/centerMap.js"></script>
</body>
</html>

