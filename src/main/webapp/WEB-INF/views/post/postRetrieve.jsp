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
<a href="/narangnorang/post?category=${retrieve.category}"><button id="list">글 목록</button></a>
<a href="/narangnorang/post/edit/${retrieve.id}"><button id="update">수정</button></a>
<button id="btn_delete">삭제</button>
<br>
${retrieve.category}<br>
<input type="text" value="${retrieve.title}"><br>
${retrieve.memberName} 조회${retrieve.views} 추천${retrieve.likes} ${retrieve.datetime}<br>
<textarea>${retrieve.content}</textarea><br>
<hr>
댓글 ${retrieve.replies}
<hr>
<c:forEach var="dto" items="${replyList}" varStatus="status">
	${dto.memberName} ${dto.datetime}<br>
	${dto.content}<br>
	<hr>
</c:forEach>
<textarea id="reply"></textarea>
<button id="btn_insertReply">등록</button>
</body>
</html>