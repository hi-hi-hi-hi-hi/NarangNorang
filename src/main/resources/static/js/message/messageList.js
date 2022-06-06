function popChats(otherId){
	let popupWidth = 500;
	let popupHeight = 700;
	let popupX = (window.screen.width/2) - (popupWidth/2);
	let popupY = (window.screen.height/2) - (popupHeight/2);
		
	childWin = window.open("message/chats/"+otherId, "new",
			"toolbar=no, menubar=no, scrollbars=yes, resizable=no, " +
			"width="+popupWidth+", height="+popupHeight+", left="+popupX+", top="+popupY);
}

function getMessageList(){
	$("#chatsList").load(location.href+" #chatsList");
}
setInterval('getMessageList()',2000);