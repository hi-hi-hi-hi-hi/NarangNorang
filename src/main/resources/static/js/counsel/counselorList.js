function popMessageForm(id, value) {
	var popupWidth = 500;
	var popupHeight = 500;
	
	var popupX = (window.screen.width/2) - (popupWidth/2);
	var popupY = (window.screen.height/2) - (popupHeight/2);

	childWin = window.open("message/counsel?id="+id+"&name="+value, "new",
				"toolbar=no, menubar=no, scrollbars=no, resizable=no, " +
				"width="+popupWidth+", height="+popupHeight+", left="+popupX+", top="+popupY);
	

}


