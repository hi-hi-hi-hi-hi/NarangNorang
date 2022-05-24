$(document).ready(function(){
	$("#delSelected").on("click", function(){
		if(confirm("선택된 계정들을 삭제하시겠습니까?")){
			$("form").attr({
				"action": "/narangnorang/admin/delMember",
				"method": "GET"
			});
			$("form").submit();
			alert("계정이 삭제되었습니다.");
		}else{
			event.preventDefault();
		}
	});
});