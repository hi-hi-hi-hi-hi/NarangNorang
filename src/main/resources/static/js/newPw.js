$(document).ready(function(){
	var pwCompare = false;
	
	$("#newPw").on("click", function(){
		if(pwCompare == false){
			alert("비밀번호가 일치하지 않습니다.");
			event.preventDefault();
		}else if(confirm("비밀번호를 수정하시겠습니까?")){
			$.ajax({
                type: 'PUT',
                url: '/narangnorang/newPw',
                datatype: "json",
                data: {
                	id: $("#id").val(),
                	password: $("#password").val()
                },
                success: function(result) {
                    alert("비밀번호가 변경되었습니다.");
                    location.href="/narangnorang/login";
                },
				error: function(xhr, status, e){
					console.log(xhr, status, e);
				}
            });
		}
	});
	
	// 비번 재확인 체크
	$("#password2").on("input", function(){
		var pw = $("#password").val();
		var pw2 = $("#password2").val();
		var mesg = "비번일치";
		if(pw != pw2){
			mesg = "비번 불일치";
			$("#pwCheckResult").css("color", "red");
			pwCompare = false;
		}else{
			$("#pwCheckResult").css("color", "blue");
			pwCompare = true;
		}
		$("#pwCheckResult").text(mesg);
	});
});