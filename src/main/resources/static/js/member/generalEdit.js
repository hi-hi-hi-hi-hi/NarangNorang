$(document).ready(function(){
	var nicknameDuplication = false;
	$("#generalEdit").on("submit", function(){
		var name = $('#name').val();
		var originName = $('#originName').val()
		if(name == originName){
			if(confirm("정보를 수정하시겠습니까?")){
				alert("정보가 수정되었습니다.");
			}else{
				event.preventDefault();
			}
		}else{
			if(nicknameDuplication == false){
				alert("닉네임 검사를 해주세요");
				event.preventDefault();
			}else if(confirm("정보를 수정하시겠습니까?")){
				alert("정보가 수정되었습니다.");
			}else{
				event.preventDefault();
			}
		}
	});
	
	// 닉네임 중복 체크
	$("#checkNickname").on("click", function(){
		var mesg = "사용 불가";
		var name = $('#name').val();
		var originName = $('#originName').val()
		$.ajax({
			url: '/narangnorang/checkName',
			type: 'post',
			data: {
				name: name
			},
			success: function(cnt){
				if(name==originName){
					mesg = "지금 사용중인 닉네임 입니다.";
					$("#nicknameCheck").css("color", "blue");
					nicknameDuplication = true;
				}else if(cnt != 1){
					mesg = "사용 가능";
					$("#nicknameCheck").css("color", "blue");
	                nicknameDuplication = true;
	            } else {
	            	$("#nicknameCheck").css("color", "red");
	                nicknameDuplication = false;
	            }
				if(name.length == 0){
					mesg = "닉네임을 입력해주세요";
					$("#nicknameCheck").css("color", "red");
	                nicknameDuplication = false;
				}
				$("#nicknameCheck").text(mesg);
			},
			error: function(){
				alert("에러");
			}
		});
	});
	
	// 프로필 사진 수정
	$("#photoUpload").on("change", function(e){
		var reader = new FileReader();
		reader.onload = function(e){
			var img = document.getElementById('photo');
			img.setAttribute("src", e.target.result);
		}
	});
	
	$("#photoUpdate").on("submit", function(){
		if(confirm("프로필 사진을 변경하시겠습니까?")){
			alert("프로필 사진이 변경되었습니다.");
		}else{
			event.preventDefault();
		}
	});
});
