////////////////////////////////////////
$(document).ready(function(){
		
	// form 입력 유효성 체크
	$("form").on("submit", function(){
		var id = $("#id").val();
		var password = $("#password").val();
		var password2 = $("#password2").val();
		var name = $("#name").val();
		var nickname = $("#nickname").val();
		var phone = $("#phone").val();
		var postcode = $("#postcode").val();
		var roadAddress = $("#roadAddress").val();
		var jibunAddress = $("#jibunAddress").val();
		var detailAddress = $("#detailAddress").val();
		
		if(id.length == 0){
			alert("아이디를 입력해주세요");
			event.preventDefault();
		}else{
			if(password.length == 0){
				alert("비밀번호를 입력해주세요");
				event.preventDefault();
			}else{
				if(password2.length == 0){
					alert("비밀번호 재확인을 해주세요");
					event.preventDefault();
				}else{
					if(name.length == 0){
						alert("이름을 입력해주세요");
						event.preventDefault();
					}else{
						if(nickname.length == 0){
							alert("닉네임을 입력해주세요");
							event.preventDefault();
						}else{
							if(phone.length == 0){
								alert("휴대전화 번호를 입력해주세요");
								event.preventDefault();
							}else{
								if(postcode.length == 0 || roadAddress.length == 0 ||
										   jibunAddress.length == 0 || detailAddress.length == 0){
											alert("주소를 입력해주세요");
											event.preventDefault();
										}
							}
						}
					}
				}
			}
		}
	});
	
	// 비번 재확인 체크
	$("#password2").on("keyup", function(){
		var pw = $("#password").val();
		var pw2 = $("#password2").val();
		var mesg = "비번일치";
		if(pw != pw2){
			mesg = "비번 불일치";
		}
		$("#pwCheckResult").text(mesg);
	});
		
	// 아이디 중복체크
//	$("#id").on("keyup", function(){
//		$.ajax({
//			url: 'idCheck',	// Controller의 요청맵핑 값
//			type: 'get',
//			data: {
//				userid: $("#userid").val()
//			},
//			dataType: 'text',	// 응답 데이터 타입 지정
//			success: function(responseData, status, xhr){
//				$("#idresult").text(responseData);
//			},
//			error: function(xhr, status, e){
//				console.log("Error:" + e);
//			}
//		});
//	});
	
});