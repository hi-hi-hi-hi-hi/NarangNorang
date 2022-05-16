////////////////////////////////////////
$(document).ready(function(){
	
	//form 입력 유효성 체크
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
			if(!email_check(id)){
				alert("이메일 형식에 맞게 입력해주세요");
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
		}
	});

	//이메일 정규식 체크
	function email_check(email) {

		var reg = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;

		return reg.test(email);

	}
		
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
	
	
});


		
//아이디 중복체크
function checkId(){
	$.ajax({
		url: '/narangnorang/signUp/checkId',
		type: 'post',
		data: {
			id: $('#id').val()
		},
		success: function(cnt){
			if(cnt != 1){
                $('.id_ok').css("display","inline-block"); 
                $('.id_already').css("display", "none");
            } else {
                $('.id_already').css("display","inline-block");
                $('.id_ok').css("display", "none");
            }
		},
		error: function(){
			alert("에러");
		}
	});
}

// 메일 전송
function sendMail(){
	$.ajax({
		type : 'post',
		url : '/narangnorang/signUp/checkMail',
		data : {
			id: $(".id").val()
			},
		dataType :'json',
	});
	alert("인증번호가 전송되었습니다.") 
	isCertification=true;
}

//$(".sendMail").click(function() {
//	if (id == "") {
//		alert("메일 주소가 입력되지 않았습니다.");
//	} else {
//		$.ajax({
//			type : 'post',
//			url : '/narangnorang/signUp/checkMail',
//			data : {
//				id: $(".id").val()
//				},
//			dataType :'json',
//		});
//		alert("인증번호가 전송되었습니다.") 
//		isCertification=true;
//	}
//});


