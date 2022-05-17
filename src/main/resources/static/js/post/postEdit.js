$(document).ready(function(){
	$("#btn_update").on("click", function(){
		if(confirm("게시글을 수정하시겠습니까?")){
			var title = $("#title").val();
            var content = $("#content").val();
            var category = $("#category").val();
            var id = $("#id").val();
               $.ajax({
                   type: 'PUT',
                   url: '/narangnorang/post/' + go,
                   datatype: "json",
                   data: {
                       title: title,
                       content: content,
                       category: category
                   },
                   success: function(result) {
                       alert("게시글을 수정하였습니다.");
                       location.href="/narangnorang/post/" + go;
                   },
				error: function(xhr, status, e){
					console.log(xhr, status, e)
				}
               });
           };
	});
});