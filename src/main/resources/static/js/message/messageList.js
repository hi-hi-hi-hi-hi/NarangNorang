function popChats(otherId){
	var popupWidth = 500;
	var popupHeight = 700;
	var popupX = (window.screen.width/2) - (popupWidth/2);
	var popupY = (window.screen.height/2) - (popupHeight/2);
	
	childWin = window.open("message/chats/"+otherId, "new",
			"toolbar=no, menubar=no, scrollbars=yes, resizable=no, " +
			"width="+popupWidth+", height="+popupHeight+", left="+popupX+", top="+popupY);

}