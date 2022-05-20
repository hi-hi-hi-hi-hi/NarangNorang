$(document).ready(function(){
	$("#pwCheck").on("submit", function(){
		var pw = $("#password").val();
		var pw2 = $("#password2").val()
		if(pw != pw2){
			alert("비밀번호가 틀립니다.");
			event.preventDefault();
		}
	});
});