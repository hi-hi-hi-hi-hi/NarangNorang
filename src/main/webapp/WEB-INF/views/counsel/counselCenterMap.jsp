<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<b>주변 상담 센터</b>

<br>
<input type="hidden" id="userRegion" value="${userRegion}">
<input type="search" id="searchRegion" placeholder="지역 검색(ex.제주)">
<button id="searchBtn">검색</button>
<br>
<button id="searchBtnMyRegion">내 지역 검색 : ${userRegion} </button>
<div id="map" style="width: 500px; height: 400px;"></div>
