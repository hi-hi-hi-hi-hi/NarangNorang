<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		$("#btn_search").on("click", function(){
			var searchCol = $("#searchCol").val();
            var keyword = $("#keyword").val();
			$.ajax({
                type: 'GET',
                url: '/narangnorang/post/search',
                datatype: "json",
                data: {
                	searchCol:searchCol,
                	keyword:keyword
                },
                success: function(result) {
                	console.log("성공~~");
                },
				error: function(xhr, status, e){
					console.log(xhr, status, e)
				}
            });
		});
	});

</script>
</head>
<body>
	<select id="searchCol">
		<option value="title">제목</option>
		<option value="memberId">작성자</option>
	</select>
	<input type="text" id="keyword">
	<button id="btn_search">검색</button>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회</th>
			<th>추천</th>
		</tr>
	<c:forEach var="dto" items="${postList}" varStatus="status">
		<tr>
			<td>${dto.id}</td>
			<td><a href="/narangnorang/post/${dto.id}">${dto.title}</a></td>
			<td>${dto.memberId}</td>
			<td>${dto.datetime}</td>
			<td>${dto.views}</td>
			<td>${dto.likes}</td>
		</tr>
	</c:forEach>
	</table>
	<a href="/narangnorang/post/write?category=${category}">글쓰기</a>
</body>
</html>