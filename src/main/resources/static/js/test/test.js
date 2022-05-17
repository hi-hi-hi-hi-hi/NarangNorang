
const selectList = [];

function select(idx, option) {
	selectList[idx] = option;
	if (idx + 1 < qnaList.length) {
		goNext(idx + 1);
	} else {
		goResult();
	}
}

function goNext(idx) {
	let question = document.querySelector('.question');
	question.innerText = qnaList[idx].question;
	let answer = document.querySelector('.answer');
	for ( let child of answer.childNodes) {
		child.style.display = 'none';
	}
	for ( let i in qnaList[idx].answer) {
		let btn = document.createElement('button');
		btn.addEventListener('click', function() {
			select(idx, i);
		});
		btn.innerText = qnaList[idx].answer[i].text;
		answer.appendChild(btn);
	}
}

function goResult() {
	let result = 0;
	for ( let i in qnaList) {
		result += qnaList[i].answer[selectList[i]].value;
	}
	let form = document.createElement('form');
	document.body.appendChild(form);
	form.action = location.href + '/' + result;
	form.method = 'post';
	form.submit();
}
