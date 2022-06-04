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
}
function openMoodState() {
	document.querySelector('#dailyLog').style.display = 'none';
	document.querySelector('#moodState').style.display = 'block';
}
function submitDailyLog() {
	$.ajax({
		url : '/narangnorang/norang',
		method : 'GET',
		dataType : 'text',
		success : function(response) {
			alert(response);
		},
		error : function() {
			alert('실패');
		}
	});
}
function submitMoodState() {
	$.ajax({
		url : '/narangnorang/norang',
		method : 'GET',
		dataType : 'text',
		success : function(response) {
			alert(response);
		},
		error : function() {
			alert('실패');
		}
	});
}