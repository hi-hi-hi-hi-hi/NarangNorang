var deleteReply = function(replyId, postId){
	if(confirm("댓글을 삭제하시겠습니까?") == true){	
		$.ajax({
			type:'DELETE',
			url: '/narangnorang/post/reply?postId=' + postId + "&replyId=" + replyId,
			success: function(result){
				location.href = "/narangnorang/post/" + postId;
			},
			error: function(xhr, status, e){
				console.log(xhr, status, e)
			}
		});
	};
}

// 댓글 수정
var updateReply = function(replyId){
	var content = $("#reply" + replyId).text();
	var h = "";
	h += "<textarea id='editReply"+ replyId +"'>" + content + "</textarea>"
	h += "<button id='btn_updateReplyPro' onclick='updateReplyPro(" + replyId + ")'>등록</button>"
	$("#reply" + replyId).replaceWith(h);
}
var updateReplyPro = function(replyId){
	var content = $("#editReply" + replyId).val();
	$.ajax({
		type:'PUT',
		url: '/narangnorang/post/reply?id=' + replyId + "&content=" + content,
		success: function(result){
			location.reload();
		},
		error: function(xhr, status, e){
			console.log(xhr, status, e)
		}
	});
}


$(document).ready(function(){
		
	
	$("#btn_delete").on("click", function(){
		if(confirm("게시글을 삭제하시겠습니까?") == true){
		
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