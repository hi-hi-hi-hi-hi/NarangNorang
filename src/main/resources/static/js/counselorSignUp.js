$(document).ready(function(){
	var isCertification = false;
	var idDuplication = false;
	var pwCompare = false;
	var key = "";
	
	// 상담사 form 입력 유효성 체크
	$("#counselor").on("submit", function(){
		var email = $("#email").val();
		var password = $("#password").val();
		var password2 = $("#password").val();
		var name = $("#name").val();
		var phone = $("#phone").val();
		var zipcode = $("#postcode").val();
		var address1 = $("#roadAddress").val();
		var address2 = $("#jibunAddress").val();
		var address3 = $("#detailAddress").val();
		var job = $("#job").val();
		var introduction = $("#introduction").val();
		
		if(email.length == 0){
			alert("아이디를 입력해주세요");
			event.preventDefault();
		}else{
			if(!email_check(email)){
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
									if(name.length == 0){
										alert("이름을 입력해주세요");
										event.preventDefault();
									}else{
										if(zipcode.length == 0 || address1.length == 0 ||
										   address2.length == 0 || address3.length == 0){
											alert("주소를 입력해주세요");
											event.preventDefault();
										}else{
											if(job.length == 0){
												alert("직업 입력해주세요");
												event.preventDefault();
											}else{
												if(introduction.length == 0){
													alert("소개글을 입력해주세요");
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
	
	// 아이디 중복체크
	$("#checkEmail").on("click", function(){
		var mesg = "사용 가능한 이메일입니다.";
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
	});

});





