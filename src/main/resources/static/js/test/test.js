window.onload = function() {
	goNext(0);
}

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
	let progressBar = document.querySelector('.progress-bar');
	progressBar.style.width = (idx + 1) / qnaList.length * 100 + '%';
	let question = document.querySelector('.question');
	question.innerHTML = '<h5>' + qnaList[idx].question + '</h5>';
	let answer = document.querySelector('.answer');
	while (answer.hasChildNodes()) {
		answer.removeChild(answer.firstChild);
	}
	for ( let i in qnaList[idx].answer) {
		let btn = document.createElement('div');
		btn.classList.add('btn', 'btn-outline-dark', 'd-grid', 'gap-2', 'col-6', 'mx-auto', 'my-3');
		btn.innerText = qnaList[idx].answer[i].text;
		btn.addEventListener('click', function() {
			select(idx, i);
		});
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
