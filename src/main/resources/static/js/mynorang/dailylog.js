function insertDailyLog() {
	let form = document.querySelector('form');
	form.action = "/narangnorang/mynorang/dailylog";
	form.method = "post";
	form.submit();
}

function updateDailyLog() {
	let form = document.querySelector('form');
	form.action = "/narangnorang/mynorang/dailylog";
	form.method = "post";
	let input = document.createElement('input');
	input.type = 'hidden';
	input.name = '_method';
	input.value = 'put';
	form.appendChild(input);
	form.submit();
}

function deleteDailyLog() {
	let form = document.querySelector('form');
	form.action = "/narangnorang/mynorang/dailylog";
	form.method = "post";
	let input = document.createElement('input');
	input.type = 'hidden';
	input.name = '_method';
	input.value = 'delete';
	form.appendChild(input);
	form.submit();
}