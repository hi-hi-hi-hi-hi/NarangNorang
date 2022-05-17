<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>    
</head>
<body>
<br>
<a href="/narangnorang/post?category=${retrieve.category}"><button id="list">글 목록</button></a>
<a href="/narangnorang/post/edit/${retrieve.id}"><button id="update">수정</button></a>
<button id="delete">삭제</button><br>
${retrieve.category}<br>
<input type="text" value="${retrieve.title}"><br>
${retrieve.memberId} 조회${retrieve.views} 추천${retrieve.likes} ${retrieve.datetime}<br>
<textarea>${retrieve.content}</textarea><br>
<hr>
댓글 ${retrieve.replies}
</body>
</html>