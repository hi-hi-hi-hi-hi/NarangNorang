$(document).ready(function(){
		$("#delete").on("click", function(){
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
	});