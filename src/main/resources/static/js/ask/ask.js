$(document).ready(function(){
	$("#answerContentPop").on("click", function(){
		if($("#answerContentArea").text()){
			$("#answerContentArea").text("");
		}else{
			$("#answerContentArea").text("A. 노랑이는 떡볶이를 좋아해요");
		}
	})
})