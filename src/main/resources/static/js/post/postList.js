$(document).ready(function(){
	var totalPage = Math.ceil(totalRows / limit); // 총 페이지 수
	var pageCount = 5 // 한 그룹에 포함되는 페이지 수
	
	if (totalPage < pageCount){
		pageCount = totalPage;
	}
	
	let pageGroup = Math.ceil(currentPage / pageCount)
	let last = pageGroup * pageCount;  
	let first = last - (pageCount - 1);
	
	if (last > totalPage){
		last = totalPage;
	}
	
	
	let next = last + 1;
	let prev = first - 1; 
	
	let h = "";
	
	if (prev > 0){
		h += "<a id='prev' href='/narangnorang/post?category=" + category + "&p=" + prev + "'>" + "이전" + "</a>";
	}
	for (var i = first; i <= last; i++){
		if (currentPage == i) {
			h += i
		}else{
			h += "<a href='/narangnorang/post?category=" + category + "&p=" + i + "'>" + i + "</a>";
		}
	}
	
	if (last < totalPage){
		h += "<a id='next' href='/narangnorang/post?category=" + category + "&p=" + next + "'>" + "다음" + "</a>";
	}
	
	$("#page").html(h);
	

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
	
	$("#allList").on("click", function(){
		location.href = "/narangnorang/post?category=" + category;
	});
	
	$("#overTen").on("click", function(){
		location.href = "/narangnorang/post?category=" + category + "&likes=10";
	});
	
	$("#overThirty").on("click", function(){
		location.href = "/narangnorang/post?category=" + category + "&likes=30";
	});
});