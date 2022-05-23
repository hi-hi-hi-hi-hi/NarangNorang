$(document).ready(function(){
	$("#counselorEdit").on("submit", function(){
		if(confirm("정보를 수정하시면 다시 로그인 해야 합니다. 진행하시겠습니까?")){
		}else{
			event.preventDefault();
		}
	});
});