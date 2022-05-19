////////////////////////////////////////
$(document).ready(function(){
	var isCertification = false;
	var idDuplication = false;
	var pwCompare = false;
	var nicknameDuplication = false;
	var key = "";
	
	// 일반회원 form 입력 유효성 체크
	$("#general").on("submit", function(){
		var id = $("#id").val();
		var password = $("#password").val();
		var password2 = $("#password2").val();
		var nickname = $("#nickname").val();
		var phone = $("#phone").val();
		var region = $("#region").val();
		
		if(id.length == 0){
			alert("아이디를 입력해주세요");
			event.preventDefault();
		}else{
			if(!email_check(id)){
				alert("이메일 형식에 맞게 입력해주세요");
				event.preventDefault();
			}else{
				if(idDuplication == false){
					alert("아이디 중복검사를 해주세요");
					event.preventDefault();
				}else{
					if(isCertification == false){
						alert("이메일 인증을 완료해 주세요");
						event.preventDefault();
					}else{
						if(password.length == 0){
							alert("비밀번호를 입력해주세요");
							event.preventDefault();
						}else{
							if(password2.length == 0){
								alert("비밀번호 재확인을 입력해주세요");
								event.preventDefault();
							}else{
								if(pwCompare == false){
									alert("비밀번호가 일치하지 않습니다");
									event.preventDefault();
								}else{
									if(nickname.length == 0){
										alert("닉네임을 입력해주세요");
										event.preventDefault();
									}else{
										if(nicknameDuplication == false){
											alert("닉네임 중복검사를 해주세요");
											event.preventDefault();
										}else{
											if(phone.length == 0){
												alert("휴대전화 번호를 입력해주세요");
												event.preventDefault();
											}else{
												if(region.length == 0){
													alert("지역을 입력해주세요");
													event.preventDefault();
												}else{
													alert("회원가입 완료");
												}
											}
										}
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
	
	// 인증메일 전송
	$("#sendMail").click(function() {
		var id = $("#id").val();
		if(!email_check(id)){
			alert("이메일 형식에 맞게 입력해주세요");
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
	
	// 인증번호 확인
	$("#compare").click(function() {
		if ($("#com").val() == key) {
			$("#compare-text").text("인증 성공!").css("color", "blue");
			isCertification = true;
		} else {
			$("#compare-text").text("불일치!").css("color", "red");
			isCertification = false;
		}
	});
	
	//아이디 중복체크
	$("#checkId").on("click", function(){
		$.ajax({
			url: '/narangnorang/checkId',
			type: 'post',
			data: {
				id: $('#id').val()
			},
			success: function(cnt){
				if(cnt != 1){
	                $('#id_ok').css("display","inline-block"); 
	                $('#id_already').css("display", "none");
	                idDuplication = true;
	            } else {
	                $('#id_already').css("display","inline-block");
	                $('#id_ok').css("display", "none");
	                idDuplication = false;
	            }
			},
			error: function(){
				alert("에러");
			}
		});
	});

	// 닉네임 중복 체크
	$("#checkNickname").on("click", function(){
		$.ajax({
			url: '/narangnorang/checkNickname',
			type: 'post',
			data: {
				nickname: $('#nickname').val()
			},
			success: function(cnt){
				if(cnt != 1){
	                $('.nickname_ok').css("display","inline-block"); 
	                $('.nickname_already').css("display", "none");
	                nicknameDuplication = true;
	            } else {
	                $('.nickname_already').css("display","inline-block");
	                $('.nickname_ok').css("display", "none");
	                nicknameDuplication = false;
	            }
			},
			error: function(){
				alert("에러");
			}
		});
	});
	
});





