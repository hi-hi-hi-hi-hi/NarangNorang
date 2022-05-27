<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<button type="button" onclick="norang()">노랑이</button>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	function norang() {
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
</script>