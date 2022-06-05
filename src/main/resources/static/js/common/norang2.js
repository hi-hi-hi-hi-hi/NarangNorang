function openNorang() {
	let norang = document.querySelector('#norang');
	if (norang.style.display == 'none') {
		norang.style.display = 'block';
	} else {
		norang.style.display = 'none';
	}
}
function openDailyLog() {
	document.querySelector('#moodState').style.display = 'none';
	document.querySelector('#dailyLog').style.display = 'block';
	$.ajax({
		url : '/narangnorang/norang2/dailylog',
		method : 'GET',
		dataType : 'json',
		success : function(dailyLog) {
			document.querySelector('input[name="sleep"]').value = dailyLog.sleep;
			document.querySelector('input[name="medicine"][value="' + dailyLog.medicine + '"]').checked = 'checked';
			document.querySelector('button[onclick="submitDailyLog()"]').disabled = true;
		},
		error : function() {
		}
	});
}
function openMoodState() {
	document.querySelector('#dailyLog').style.display = 'none';
	document.querySelector('button[onclick="submitMoodState()"]').disabled = false;
	document.querySelector('#moodState').style.display = 'block';
}
function submitDailyLog() {
	$.ajax({
		url : '/narangnorang/norang2/dailylog',
		method : 'POST',
		data : $('#dailyLog').serialize(),
		dataType : 'json',
		success : function(response) {
			if (response.flag == true) {
				openDailyLog();
			}
		},
		error : function() {
		}
	});
}
function submitMoodState() {
	$.ajax({
		url : '/narangnorang/norang2/moodstate',
		method : 'POST',
		data : $('#moodState').serialize(),
		dataType : 'json',
		success : function(response) {
			if (response.flag == true) {
				document.querySelector('button[onclick="submitMoodState()"]').disabled = true;
			}
		},
		error : function() {
		}
	});
}