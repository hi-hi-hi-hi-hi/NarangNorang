<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<body>
	<h1>글 자세히 보기</h1>
	<img src="/narangnorang/images/retrieve.png" width="100"><br>
	<form action="/narangnorang/post" method="get">
		<button>글 목록 </button><br>
	</form>
	<form action="/narangnorang/post/${id}" method="post">
	<input type="hidden" name="_method" value="put"/>
	카테고리: <input type="text" name="title" value="${postDTO.category}"><br><br>
	제목: <input type="text" name="content" value="${postDTO.title}">
	<input type="text" name="content" value="${postDTO.title}">
	<table>
			<tr>
				<th>${postDTO.memberNickname}</th>
				<th>${postDTO.views}</th>
				<th>${postDTO.likes}</th>
				<th><button>추천</button></th>
				
			</tr>
		</table>
	<input type="submit" value="수정">
</form> 
		
	<form action="/narangnorang/posts/${postDTO.id}" method="post">
		<input type="hidden" name="_method" value="delete"/>
		<input type="submit" value="삭제">
	</form>
</body>
</html>