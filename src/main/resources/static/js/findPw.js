$(document).ready(function(){
	var key = "";
	var isCertification = false;
	var pwCompare = false;
	$("#findPw").on("submit", function(){
		var id = $("#id").val();
		var idDuplication = false;
		
		$.ajax({
			url: '/narangnorang/checkId',
			type: 'post',
			data: {
				id: id
			},
			success: function(cnt){
				if(cnt != 1){
	                idDuplication = true;
	            } else {
	                idDuplication = false;
	            }
			},
			error: function(){
				alert("에러");
			}
		});
		
		if(idDuplication = true){
			alert("등록되지 않은 계정입니다.");
			event.preventDefault();
		}else{
			$.ajax({
				type : 'post',
				url : '/narangnorang/checkMail',
				dataType : 'text',
				async : "false",
				data : {
					id : id
				},
				success : function(data) {
					key = data;
				},
				error: function(xhr, status, e){
					console.log(xhr, status, e)
				}
			});
			alert("인증메일이 전송되었습니다.");
		}
	});
	
	$("#newPw").on("submit", function(){
		var com = $("#com").val();
		var password = $("#password").val();
		var password2 = $("#password2").val();
		if (com != key) {
			alert("인증번호를 확인해주세요.");
			isCertification = false;
			event.preventDefault();
		} else {
			isCertification = true;
			if(password.length == 0){
				alert("새 비밀번호를 입력해주세요.")
				event.preventDefault();
				}else{
					if(password2.length == 0){
						alert("새 비밀번호 확인 입력해주세요.")
						event.preventDefault();
					}else{
						if(pwCompare = false){
							alert("새 비밀번호 확인이 일치하지 않습니다.")
							event.preventDefault();
						}else{
							alert("비밀번호가 재설정 되었습니다.")
					}
				}
			}
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