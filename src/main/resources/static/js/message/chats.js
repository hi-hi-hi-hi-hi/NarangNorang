function closeChats() {
	window.close();
};

function sendMessage(userId, otherId) {
	var data = {
		"content" : $("#content").val(),
		"senderId" : $("#senderId").val(),
		"senderName" : $("#senderName").val(),
		"senderPrivilege" : $("#senderPrivilege").val(),
		"recieverId" : $("#recieverId").val(),
		"recieverName" : $("#recieverName").val(),
		"recieverPrivilege" : $("#recieverPrivilege").val()
	}
	console.log(data);
	$.ajax({
		type : "POST",
		url : "/narangnorang/message/send",
		data : JSON.stringify(data),
		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		success : function(data) {
			if (data.result == "ok") {
				location.reload();
				opener.location.reload();
				$("#content").focus();
				// getMessages();
			}
			;
		},
		error : function(xhr, status, e) {
			alert("전송 실패");
		}
	});
}

$(document).ready(function(){
	$("#content").focus();
	
	$("#content").keydown(function(keyNum){
		if(keyNum.keyCode == 13){
			sendMessage();
			$("#content").focus();
		}
	});
});
