function updateDailyLog(datetime) {
	let input = document.createElement('input');
	input.type = 'hidden';
	input.name = '_method';
	input.value = 'put';
	let form = document.querySelector('form');
	form.appendChild(input);
	form.submit();
}

function deleteDailyLog(datetime) {
	let input = document.createElement('input');
	input.type = 'hidden';
	input.name = '_method';
	input.value = 'delete';
	let form = document.querySelector('form');
	form.appendChild(input);
	form.submit();
}