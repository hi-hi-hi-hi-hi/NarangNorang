$(document).ready(function(){
	$("#pwCheck").on("click", function(){
		var password = $("#password").val();
		$.ajax({
			url: '/narangnorang/mypage2',
			type: 'post',
			data: {
				password: password
			},
			success : function(data) {
				console.log(data);
				location.href=data;
			},
			error: function(xhr, status, e){
				console.log(xhr, status, e);
			}
		});
		
	});
	
	$("#password").on("keyup", function(event){
		if(event.keyCode == 13){
			$("#pwCheck").trigger("click");
		}
	});
});

