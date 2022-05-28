$(document).ready(function(){
	
		$("#btn_delete").on("click", function(){
			if(confirm("정말 삭제하시겠습니까?") == true){
			
				$.ajax({
					type:'DELETE',
					url: '/narangnorang/post/' + id,
					datatype: 'json',
					success: function(result){
						alert("게시물이 삭제되었습니다.");
						location.href = "/narangnorang/post?category=" + category;
					},
					error: function(xhr, status, e){
						console.log(xhr, status, e)
					}
				});
			};
			
		});
		
		$("#btn_insertReply").on("click", function(){
			if(confirm("댓글을 등록하시겠습니까?") == true){
				var content = $("#reply").val();
				$.ajax({
					type:'POST',
					url: '/narangnorang/post/reply',
					datatype: 'json',
					data: {
						content: content,
						postId: id
					},
					success: function(result){
						alert("댓글을 등록하였습니다.");
						location.href = "/narangnorang/post/" + id;
					},
					error: function(xhr, status, e){
						console.log(xhr, status, e)
					}
				});
			};
			
		});
		
		$("#btn_like").on("click", function(){
			$.ajax({
				type:'POST',
				url: '/narangnorang/post/like/'+id,
				success: function(result){
					alert(result);
					location.href = "/narangnorang/post/" + id;
				},
				error: function(xhr, status, e){
					console.log(xhr, status, e)
				}
			});
		});
		
	});