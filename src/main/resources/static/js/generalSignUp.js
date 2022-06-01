$(document).ready(function(){
	var isCertification = false;
	var idDuplication = false;
	var pwCompare = false;
	var nicknameDuplication = false;
	var checkSendmail = false;
	var key = "";
	
	// 일반회원 form 입력 유효성 체크
	$("#general").on("submit", function(){
		var email = $("#email").val();
		
		if(!email_check(email)){
			alert("이메일 형식에 맞게 입력해주세요");
			event.preventDefault();
		}else{
			if(idDuplication == false){
				alert("아이디 중복검사를 해주세요");
				event.preventDefault();
			}else{
				if(isCertification == false){
					alert("인증 확인이 필요합니다");
					event.preventDefault();
				}else{				
					if(pwCompare == false){
						alert("비밀번호가 일치하지 않습니다");
						event.preventDefault();
					}else{									
						if(nicknameDuplication == false){
							alert("닉네임 중복검사를 해주세요");
							event.preventDefault();
						}else{
							alert("회원가입 완료");
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
		var email = $("#email").val();
		if(!email_check(email)){
			alert("이메일 형식에 맞게 입력해주세요");
			event.preventDefault();
		}else{
			$.ajax({
				type : 'post',
				url : '/narangnorang/checkMail',
				dataType : 'text',
				async : "false",
				data : {
					email : email
				},
				success : function(data) {
					console.log(data);
					key = data;
					checkSendmail = true;
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
		if(checkSendmail == false){
			alert("인증메일 보내기를 해주세요.");
			event.preventDefault();
		}else{
			if ($("#com").val() == key) {
				$("#compare-text").text("인증 성공!").css("color", "blue");
				isCertification = true;
			} else {
				$("#compare-text").text("불일치!").css("color", "red");
				isCertification = false;
			}
		}
	});
	
	// 아이디 중복체크
	$("#checkEmail").on("click", function(){
		var email = $("#email").val();
		var mesg = "사용 가능한 이메일입니다.";
		if(!email_check(email)){
			alert("이메일 형식에 맞게 입력해주세요");
			event.preventDefault();
		}else{
			$.ajax({
				url: '/narangnorang/checkEmail',
				type: 'post',
				data: {
					email: $('#email').val()
				},
				success: function(cnt){
					if(cnt != 1){
						$("#emailCheckResult").css("color", "blue");
		                idDuplication = true;
		            } else {
		            	$("#emailCheckResult").css("color", "red");
		            	mesg = "사용 불가능한 이메일입니다.";
		                idDuplication = false;
		            }
					$("#emailCheckResult").text(mesg);
				},
				error: function(){
					alert("에러");
				}
			});
		}
	});

	// 닉네임 중복 체크
	$("#checkName").on("click", function(){
		var mesg = "사용 가능한 닉네임입니다.";
		$.ajax({
			url: '/narangnorang/checkName',
			type: 'post',
			data: {
				name: $('#name').val()
			},
			success: function(cnt){
				if(cnt != 1){
					$("#nicknameCheckResult").css("color", "blue");
	                nicknameDuplication = true;
	            } else {
	            	$("#nicknameCheckResult").css("color", "red");
	            	mesg = "이미 등록된 닉네임입니다.";
	                nicknameDuplication = false;
	            }
				$("#nicknameCheckResult").text(mesg);
			},
			error: function(){
				alert("에러");
			}
		});
	});
	
});





