$(document).ready(function(){
	$("#photoUpdate").on("click", function(){
		var popUrl = "photoUpdate";
		var popName = "프로필사진";
		var popOption = "top=100, left=100, width=200, height=200";
		var win = window.open(popUrl, popName, popOption);
	});
});