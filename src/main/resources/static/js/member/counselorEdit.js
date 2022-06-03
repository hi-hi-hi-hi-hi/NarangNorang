$(document).ready(function(){
	$("#counselorEdit").on("submit", function(){
		if(confirm("정보를 수정하시겠습니까?")){
			alert("정보가 수정되었습니다.");
		}else{
			event.preventDefault();
		}
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