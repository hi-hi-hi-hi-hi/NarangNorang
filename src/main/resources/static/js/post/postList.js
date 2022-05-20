$(document).ready(function(){
	var totalPage = Math.ceil(totalRows / limit); // 총 페이지 수
	var pageCount = 5 // 한 그룹에 포함되는 페이지 수
	
	if (totalPage < pageCount){
		pageCount = totalPage;
	}
	
	let pageGroup = Math.ceil(currentPage / pageCount)
	let last = pageGroup * pageCount;  
	
	if (last > totalPage){
		last = totalPage;
	}
	
	let first = last - (pageCount - 1);
	let next = last + 1;
	let prev = first - 1; 
	
	let h = "";
	
	if (prev > 0){
		h += "<button id='prev'>이전</button>";
	}
	
	for (var i = first; i <= last; i++){
		if (currentPage == i) {
			h += i
		}else{
			h += "<a href='/narangnorang/post?category=" + category + "&currentPage=" + i + "'>" + i + "</a>";
		}
	}
	
	if (last < totalPage){
		h += "<button id='next'>다음</button>"
	}
	
	$("#page").html(h);
	
	$("#prev").on("click", function(){
		console.log("prev");
	});
	
	$("#next").on("click", function(){
		console.log("next");
	});

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