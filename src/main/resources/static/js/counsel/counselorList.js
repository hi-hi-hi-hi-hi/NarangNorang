function popMessageForm() {
	var popupWidth = 500;
	var popupHeight = 500;
	
	var popupX = (window.screen.width/2) - (popupWidth/2);
	var popupY = (window.screen.height/2) - (popupHeight/2);
	
	window.name = "parentWin";
	childWin = window.open("message/popup", "new",
				"toolbar=no, menubar=no, scrollbars=yes, resizable=no, " +
				"width="+popupWidth+", height="+popupHeight+", left="+popupX+", top="+popupY);
	
	console.log(document.getElementById("sendButton"));
	childWin.document.getElementById("reciever").value = document.getElementById("sendMessage").value;

}
