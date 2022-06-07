function openNorang() {
	let norang = document.querySelector('#norang');
	if (norang.style.display == 'none') {
		norang.style.display = 'block';
		getChallenge();
	} else {
		norang.style.display = 'none';
	}
}

function getChallenge() {
	$.ajax({
		url : '/narangnorang/norang2/challenge',
		method : 'GET',
		dataType : 'json',
		success : function(response) {
			if (response.flag == true) {
				let withNorang = document.querySelector('#withNorang');
				let fromNorang = `<div class="fromNorang" style="background-color: yellow;">오늘의 챌린지 완료!</div>`;
				withNorang.innerHTML = fromNorang;
				divUpload.innerHTML = "";
			} else {
				let withNorang = document.querySelector('#withNorang');
				let fromNorang = `<div class="fromNorang" style="background-color: yellow;">오늘의 챌린지 ${response.challenge}찍기!</div>`;
				withNorang.innerHTML = fromNorang;
				let divUpload = document.querySelector('#divUpload');
				let form = `<form>
								<input type="file" name="multipartFile">
								<input type="text" name="_title">
								<button type="button" onclick="postChallenge(multipartFile.files[0], _title.value)">업로드</button>
							</form>`;
				divUpload.innerHTML = form;
			}
			getDailyLog();
		},
		error : function() {
		}
	});
}

function getDailyLog() {
	$.ajax({
		url : '/narangnorang/norang2/dailylog',
		method : 'GET',
		dataType : 'json',
		success : function(response) {
			if (response.flag == true) {
				getMoodState();
			} else {
				let withNorang = document.querySelector('#withNorang');
				let fromNorang = `<div class="fromNorang" style="background-color: yellow;">수면시간이랑 약먹었는지 알려줘!</div>`;
				withNorang.innerHTML += fromNorang;
				let divSend = document.querySelector('#divSend');
				let form = `<form>
								<input type="number" name="sleep" min="0" max="24" required="required">
								<input type="radio" name="medicine" value="0">X
								<input type="radio" name="medicine" value="1">
								<img src="/narangnorang/images/mynorang/medicine.png" width="20">
								<button type="button" onclick="postDailyLog(sleep.value, medicine.value)">전송</button>
							</form>`;
				divSend.innerHTML = form;
			}
		},
		error : function() {
		}
	});
}

function getMoodState() {
	$.ajax({
		url : '/narangnorang/norang2/moodstate',
		method : 'GET',
		dataType : 'json',
		success : function(response) {
			if (response.flag == true) {
				let withNorang = document.querySelector('#withNorang');
				let fromNorang = `<div class="fromNorang" style="background-color: yellow;">나랑노랑!</div>`;
				withNorang.innerHTML += fromNorang;
				let divSend = document.querySelector('#divSend');
				let form = `<form>
								<input type="text">
								<button type="button">전송</button>
							</form>`;
				divSend.innerHTML = form;
			} else {
				let withNorang = document.querySelector('#withNorang');
				let fromNorang = `<div class="fromNorang" style="background-color: yellow;">기분은 어때?</div>`;
				withNorang.innerHTML += fromNorang;
				let divSend = document.querySelector('#divSend');
				let form = `<form>
								<input type="number" name="state" min="0" max="100" required="required">
								<button type="button" onclick="postMoodState(state.value)">전송</button>
							</form>`;
				divSend.innerHTML = form;
			}
		},
		error : function() {
		}
	});
}

function postChallenge(multipartFile, title) {
	let formData = new FormData();
	formData.append("multipartFile", multipartFile);
	formData.append("title", title);
	$.ajax({
		url : '/narangnorang/norang2/challenge',
		method : 'POST',
		enctype: 'multipart/form-data',
		processData: false,
	    contentType: false,
		data : formData,
		dataType : 'json',
		success : function(response) {
			if (response.flag == true) {
				getChallenge();
			}
		},
		error : function() {
		}
	});
}

function postDailyLog(sleep, medicine) {
	$.ajax({
		url : '/narangnorang/norang2/dailylog',
		method : 'POST',
		data : {
			sleep : sleep,
			medicine : medicine
		},
		dataType : 'json',
		success : function(response) {
			if (response.flag == true) {
				let withNorang = document.querySelector('#withNorang');
				let toNorang = `<div class="toNorang" style="background-color: aqua;">${sleep}시간</div>`;
				if (medicine == '0') {
					toNorang += `<div class="toNorang" style="background-color: aqua;">약은 아직 안 먹었어</div>`;
				} else if (medicine == '1') {
					toNorang += `<div class="toNorang" style="background-color: aqua;">약도 먹었어</div>`;
				}
				withNorang.innerHTML += toNorang;
				getMoodState();
			}
		},
		error : function() {
		}
	});
}

function postMoodState(state) {
	$.ajax({
		url : '/narangnorang/norang2/moodstate',
		method : 'POST',
		data : {
			state : state
		},
		dataType : 'json',
		success : function(response) {
			if (response.flag == true) {
				let withNorang = document.querySelector('#withNorang');
				let toNorang = `<div class="toNorang" style="background-color: aqua;">${state}점</div>`;
				withNorang.innerHTML += toNorang;
				let fromNorang = `<div class="fromNorang" style="background-color: yellow;">나랑노랑!</div>`;
				withNorang.innerHTML += fromNorang;
				let divSend = document.querySelector('#divSend');
				let form = `<form>
								<input type="text">
								<button type="button">전송</button>
							</form>`;
				divSend.innerHTML = form;
			}
		},
		error : function() {
		}
	});
}
