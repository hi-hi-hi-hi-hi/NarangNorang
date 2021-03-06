function closeChats() {
	window.close();
};

$(document).ready(function() {
	$("#content").focus();
	$("#button").on("click", function(e) {
		if ($("#content").val().replace(/\s/g, "").length == 0) {
			alert("상담 받기 원하는 내용을 작성해주세요");
			$("#content").focus();
			return false;
		}

		$.ajax({
			url : './counsel',
			type : 'POST',
			data : {
				content : $("#content").val(),
				recieverId : $("#id").val(),
				recieverName : $("#name").val(),
				recieverPrivilege : $("#privilege").val()
			},
			success : function(data) {
				window.self.close();
				opener.alert("상담요청 완료");
			},
			error : function(xhr, status, e) {
				console.log(xhr, status, e);
			}
		});
	});// event
}); // document
