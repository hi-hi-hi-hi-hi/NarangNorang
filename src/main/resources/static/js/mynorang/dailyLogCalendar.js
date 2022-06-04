function select(year, month, date) {
	if (month.length == 1) {
		month = '0' + month;
	}
	if (date.length == 1) {
		date = '0' + date;
	}
	const datetime = year + '-' + month + '-' + date;
	if (new Date() > new Date(datetime + 'T00:00:00')) {
		window.open('/narangnorang/mynorang/dailylog/' + datetime, '',
				'width=600, height=200');
	}
}