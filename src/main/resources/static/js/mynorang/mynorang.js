function select(year, month, date, sleep, medicine) {
	if (date < 1)
		return;
	console.log(year, month, date, sleep, medicine);
	if (month.length == 1) {
		month = '0' + month;
	}
	if (date.length == 1) {
		date = '0' + date;
	}
	window.open(`/narangnorang/mynorang/dailylog?datetime=${year}-${month}-${date}&sleep=${sleep}&medicine=${medicine}`, '', 'width=800, height=400');
}