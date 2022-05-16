<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<body>
	<h1>글쓰기 화면 </h1>
	<form action="/narangnorang/post" method="post">
		<input type="hidden" name="_method" value="put"/>
		제목:<input type="text" name="title" value="${postDTO.title}""><br>
		내용:<input type="text" name="content" value="${postDTO.content}"><br>
		<input type="submit" value="저장 ">
	</form>
</body>
</html>