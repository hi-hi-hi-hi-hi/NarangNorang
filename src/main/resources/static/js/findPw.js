$(document).ready(function(){
	var isCertification = false;
	
	$("#sendMail").on("click", function(){
		var email = $("#email").val();
		if(!email_check(email)){
			alert("이메일 형식에 맞게 입력해주세요");
			event.preventDefault();
        }else{
        	$.ajax({
    			url: '/narangnorang/checkEmail',
    			type: 'post',
    			data: {
    				email: email
    			},
    			success: function(cnt){
    				if(cnt != 1){
    	            	alert("등록된 계정이 없습니다.");
    	            	$("#check-text").text("계정X").css("color", "red");
    	    			event.preventDefault();
    	            }else {
    	            	$("#check-text").text("계정O").css("color", "blue");
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
    	    					alert("인증메일이 전송되었습니다.");
    	    				},
    	    				error: function(xhr, status, e){
    	    					console.log(xhr, status, e)
    	    				}
    	    			});
    	            }
    			},
    			error: function(){
    				alert("에러");
    			}
    		});
        }
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
	
	// submit
	$("#findPw").on("submit", function(){
		if(isCertification == false){
			alert("이메일 인증이 완료되지 않았습니다.");
			event.preventDefault();
		}
	});
	
});