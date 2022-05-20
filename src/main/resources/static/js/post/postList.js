$(document).ready(function(){
		console.log(totalRecord);
		$("#keyword").on("keydown", function(e){
			if(e.keyCode == 13){
				$("#btn_search").trigger('click');
			}
		});
		
		$("#btn_search").on("click", function(){
			
			var searchCol = $("#searchCol").val();
			var keyword = $("#keyword").val();
			
			$.ajax({
                type: 'GET',
                url: '/narangnorang/post/search',
                datatype: "json",
                data: {
                	searchCol:searchCol,
                	keyword:keyword,
                	category:category
                },
                success: function(result) {
                	$('#postTable > tbody').empty();
                	if(result.length>=1){
                		result.forEach(function(item){
        					str = "<tr>"
        					str += "<td>"+item.id+"</td>";
        					str += "<td><a href = '/narangnorang/post/" + item.id + "'>" + item.title + "</a></td>";
        					str += "<td>"+item.memberId+"</td>";
        					str += "<td>"+item.datetime+"</td>";
        					str += "<td>"+item.views+"</td>";
        					str += "<td>"+item.likes+"</td>";
        					str += "</tr>";
        					$('#postTable').append(str);
                		});
                	}
                },
				error: function(xhr, status, e){
					console.log(xhr, status, e)
				}
            });
		});
	});