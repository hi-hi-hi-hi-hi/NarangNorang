function closeChats() {
	window.close();
};


function sendMessage(userId, userName, userPrivilege) {
	var data = {
		"content" : $("#content").val(),
		"senderId" : userId,
		"senderName" : userName,
		"senderPrivilege" : userPrivilege,
		"recieverId" : $("#recieverId").val(),
		"recieverName" : $("#recieverName").val(),
		"recieverPrivilege" : $("#recieverPrivilege").val()
	}
	
	$.ajax({
		type : "POST",
		url : "/narangnorang/message/send",
		data : JSON.stringify(data),
		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		success : function(data) {
			if (data.result == "ok") {
				$("#chatsHistory").load("#chatsHistory");
				$("#chatsList", opener.document).load("/narangnorang/message #chatsList");
				$("#content").focus();
			};
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
			$("#sendMessage").trigger("click");
		}
	});
});
