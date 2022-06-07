function askContentOp(category){
	if (category == 'faq'){
		$("#askContentArea").empty();
		
		str = "";
		str += `<div class="qnaArea" id="qna1">
					Q. 노랑이는 좋아하는 음식이 뭔가요?
					<a onclick='answerContentPop'>▼</a>
					<div class='answerContentArea'></div>
				</div>`
		
		$("#askContentArea").html(str);
	}else if (category == 'qna'){
		$("#askContentArea").empty();
		
		str = "";
		str += "qna 게시판 인디용...";
		$("#askContentArea").html(str);
	}
}

function askContentPop(){
	
}


$(document).ready(function(){
	$("#btn_FAQ").on('click', function(){
		askContentOp('faq');
	});
	$("#btn_QNA").on('click', function(){
		askContentOp('qna');
	});
});