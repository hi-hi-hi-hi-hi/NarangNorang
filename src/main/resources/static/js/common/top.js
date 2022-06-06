function getUnreads(){
	$.ajax({
		type: 'GET',
		url: '/narangnorang/message/unread',
		datatype: 'json',
		success:function(data){
			$("#messageAlarm").text(data.unreadCounts);
		},
		error:function(xhr, status, e){
			console.log(xhr, status, e)
		}
			
	}); //ajax
}

$(document).ready(function(){
	getUnreads();
});

setInterval('getUnreads()', 2000);
