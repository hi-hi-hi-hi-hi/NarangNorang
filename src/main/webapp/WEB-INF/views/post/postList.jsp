<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<button id="allList">전체글</button>
	<button id="overTen">추천 10개 이상</button>
	<button id="overThirty">추천 30개 이상</button><br>
	<select id="searchCol">
		<option value="title">제목</option>
		<option value="member_id">작성자</option>
	</select>
	<input type="text" id="keyword">
	<button id="btn_search">검색</button>
	<table id ="postTable" border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th>조회</th>
				<th>추천</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="dto" items="${postList}" varStatus="status">
			<tr>
				<td>${dto.id}</td>
				<td><a href="/narangnorang/post/${dto.id}">${dto.title}</a><a id="comment">[${dto.replies}]</a></td>
				<td>${dto.memberName}</td>
				<td>${dto.datetime}</td>
				<td>${dto.views}</td>
				<td>${dto.likes}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div id="page"></div>
	<br>
	<a href="/narangnorang/post/write?category=${category}">글쓰기</a>
</body>
</html>