function pagingOp(totalRows, limit, currentPage){
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
	
	return [totalPage, first, last, prev, next];

};

$(document).ready(function(){
	
	let h = "";
	
	let [totalPage, first, last, prev, next] = pagingOp(totalRows, limit, currentPage);
		
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
	

	$("#keyword").on("keyup", function(e){
		//if(e.keyCode == 13){
			$("#btn_search").trigger('click');
		//}
	});
	
	$("#keyword").on("keyup", function(){
		
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
               	$('#page').empty();
               	if(result.PostDTO.length>=1){
               		result.PostDTO.forEach(function(item){
       					str = "<tr>"
       					str += "<td>"+item.id+"</td>";
       					str += "<td><a href = '/narangnorang/post/" + item.id + "'>" + item.title + "</a></td>";
       					str += "<td>"+item.memberName+"</td>";
       					str += "<td>"+item.datetime+"</td>";
       					str += "<td>"+item.views+"</td>";
       					str += "<td>"+item.likes+"</td>";
       					str += "</tr>";
       					$('#postTable').append(str);
               		});
               		
               		let searchH = "";
    				
    				let [sTotalPage, sFirst, sLast, sPrev, sNext] = pagingOp(result.PageDTO.totalRows, result.PageDTO.limit, result.PageDTO.currentPage);
    				
    				
    				
    				if (sPrev > 0){
    					searchH += "<a id='searchPrevPage' href='/narangnorang/post/search?category=" + category + "&p=" + sPrev + "&searchCol=" + searchCol + "&keyword="+ keyword +"'>" + "이전" + "</a>";
    				}
    				for (var i = sFirst; i <= sLast; i++){
    					if (result.PageDTO.currentPage == i) {
    						searchH += i
    					}else{
    						searchH += "<a id='searchPage' href='/narangnorang/post/search?category=" + category + "&p=" + i + "&searchCol=" + searchCol + "&keyword="+ keyword + "'>" + i + "</a>";
    					}
    				}
    				
    				if (sLast < sTotalPage){
    					searchH += "<a id='searchNextPage' href='/narangnorang/post/search?category=" + category + "&p=" + sNext + "&searchCol=" + searchCol + "&keyword="+ keyword +"'>" + "다음" + "</a>";
    				}
    				
    				$("#page").html(searchH);
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