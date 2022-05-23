$(document).ready(function(){
	$("#pwCheck").on("click", function(){
		var pw = $("#password").val();
		var pw2 = $("#password2").val();
		var privileage= $("#privileage").val();
		if(pw != pw2){
			alert("비밀번호가 틀립니다.");
			event.preventDefault();
		}else if(privileage == 0){
			location.href="/narangnorang/admin";
		}else{
			location.href="/narangnorang/mypage/edit";
		}
		
	});
});