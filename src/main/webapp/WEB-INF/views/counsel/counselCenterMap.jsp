<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<b>주변 상담 센터</b>
<c:forEach items="${centerList}" var="center">
 <input type="hidden" class="centerList" value="${center}"/>

</c:forEach>
<br>

<input type="text" placeholder="검색어 입력">
<button>검색</button>
<div id="map" style="width: 500px; height: 400px;"></div>

<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7c812e8a4271a0b1aa964940c3e5e02c"></script>

<script type="text/javascript" src="../js/counsel/centerMap.js"></script>


