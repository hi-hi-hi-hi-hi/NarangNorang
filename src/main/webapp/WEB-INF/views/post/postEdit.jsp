<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나랑노랑</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>    
<script type="text/javascript">
	$(document).ready(function(){
		$("#btn_update").on("click", function(){
			if(confirm("게시글을 수정하시겠습니까?")){
				var title = $("#title").val();
	            var content = $("#content").val();
	            var category = $("#category").val();
	            var id = $("#id").val();
                $.ajax({
                    type: 'PUT',
                    url: '/narangnorang/post/${pDto.id}',
                    datatype: "json",
                    data: {
                        title: title,
                        content: content,
                        category: category
                    },
                    success: function(result) {
                        alert("게시글을 수정하였습니다.");
                        location.href="/narangnorang/post/${pDto.id}";
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
	<h1>홈</h1>
	<jsp:include page="../common/top.jsp" flush="true" /><br>
	<jsp:include page="../common/navBar.jsp" flush="true" /><br>
	<hr>
	<form>
		<input type="hidden" id="category" value="${pDto.category}">
		제목:<input type="text" id="title" value="${pDto.title}"><br>
		내용:<textarea id="content">${pDto.content}</textarea><br>
	</form>
	<button id="btn_update">수정</button>
</body>
</html>