$(document).ready(function(){
	var idDuplication = false;
	var isCertification = false;
	
	$("#sendMail").on("click", function(){
		var id = $("#id").val();
		if(!email_check(id)){
			alert("이메일 형식에 맞게 입력해주세요");
			event.preventDefault();
		}else if(id.length == 0 || idDuplication == true){
			alert("아이디를 확인해주세요.");
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
	
	//아이디 중복체크
	$("#checkId").on("click", function(){
		$.ajax({
			url: '/narangnorang/checkId',
			type: 'post',
			data: {
				id: $('#id').val()
			},
			success: function(cnt){
				if(!email_check($('#id').val())){
					alert("이메일 형식에 맞게 입력해주세요");
					event.preventDefault();
	            }else if(cnt != 1){
	            	alert("등록된 계정이 없습니다.");
	            	$("#check-text").text("계정X").css("color", "red");
	                idDuplication = true;
	            }else {
	            	alert("등록된 계정이 있습니다. " +
	            		  "해당 계정으로 인증받으시려면  인증메일 보내기 버튼을 눌러주세요.");
	            	$("#check-text").text("계정O").css("color", "blue");
	                idDuplication = false;
	            }
			},
			error: function(){
				alert("에러");
			}
		});
	});
	
	//이메일 정규식 체크
	function email_check(email) {

		var reg = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;

		return reg.test(email);

	}
	
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
	
	$("#findPw").on("submit", function(){
		if(idDuplication = false){
			alert("id를 확인해주세요");
			event.preventDefault();
		}
		else if(isCertification = false){
			alert("이메일 인증이 완료되지 않았습니다.");
			event.preventDefault();
		}
	});
	
});