<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>    
<script type="text/javascript">
	$(document).ready(function(){
		$("#list").on("click", function(){
			location.href = '/narangnorang/post?category=${retrieve.category}';
		});
		
		$("#update").on("click", function(){
			location.href = '/narangnorang/post/edit/${retrieve.id}';
		});
		
		$("#delete").on("click", function(){
			if(confirm("정말 삭제하시겠습니까?") == true){
			
				$.ajax({
					type:'DELETE',
					url: '/narangnorang/post/${retrieve.id}',
					datatype: 'json',
					success: function(result){
						alert("게시물이 삭제되었습니다.");
						location.href = "/narangnorang/post?category=${retrieve.category}";
					},
					error: function(xhr, status, e){
						console.log(xhr, status, e)
					}
				});
			};
			
		});
	});
</script>
</head>
<body>
<br>
<button id="list">글 목록</button>
<button id="update">수정</button>
<button id="delete">삭제</button><br>
${retrieve.category}<br>
<input type="text" value="${retrieve.title}"><br>
${retrieve.memberId} 조회${retrieve.views} 추천${retrieve.likes} ${retrieve.datetime}<br>
<textarea>${retrieve.content}</textarea><br>
<hr>
댓글 ${retrieve.replies}
</body>
</html>