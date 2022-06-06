function closeChats() {
	window.close();
};

function getHistory(){
	$("#chatsHistory").load(location.href+' #chatsHistory');
	$("#chatsList", opener.document).load("/narangnorang/message #chatsList");
};

function sendMessage(userId, userName, userPrivilege) {
	let data = {
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
				getHistory();
				$("#content").val('');
			};
		},
		error : function(xhr, status, e) {
			alert("전송 실패");
		}
	});
}

$(document).ready(function(){
	$("#content").focus();
	$("#chatsList", opener.document).load("/narangnorang/message #chatsList");
	$("#content").keydown(function(keyNum){
		if(keyNum.keyCode == 13){
			$("#sendMessage").trigger("click");
		}
	});
});

setInterval('getHistory()',2000);
