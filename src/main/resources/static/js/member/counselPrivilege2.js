$(document).ready(function(){
	$("#upPrivilege").on("click", function(){
		if(confirm("선택된 계정들을 인증하시겠습니까?")){
			$("form").attr({
				"action": "/narangnorang/admin/privilegeUp",
				"method": "GET"
			});
			$("form").submit();
		}else{
			event.preventDefault();
		}
	});
});