let postListOp = function(category, p, likes){
	$.ajax({
		type:'GET',
		url:'/narangnorang/post/list',
		datatype:'json',
		data:{
			category: category,
			p: p,
			likes: likes
		},
		success:function(result){
			if (category == '대나무숲'){
				$("#postTable").empty();
				
				str = "";
				str += `<button id="btn_allList" onclick="postListOp('` + category + `', 1)">전체글</button>
						<button id="btn_overTen" onclick="postListOp('` + category + `', 1, 10)">추천 10개 이상</button>
						<button id="btn_overThirty" onclick="postListOp('` + category + `', 1, 30)">추천 30개 이상</button>`;
				str += "<table>";
				result.postDto.forEach(function(item){
					str += "<tr><td>";
					str += "<div class='postSection' id='postSection"+item.id+"'>";
					str += "<b>익명</b>&nbsp;&nbsp;" + item.datetime + "&nbsp;&nbsp;<button class='btn_like' onclick='bambooLike(" + item.id + ")'>추천</button><span id='bbLikeCount"+item.id+"'>" + item.likes + "</span>&nbsp;&nbsp;";
					if ($("#userId").val() == item.memberId){
						str += `<a onclick='updatePost(`+item.id+`)'>수정</a>
								<a onclick='deletePost(`+item.id+`)'>삭제</a>`;
					}
					str += "<div class='contentArea' id='contentArea"+item.id+"'>" + item.content + "</div>";
					str += "<br><button class='btn_bambooReplyPop' id='bambooReplyPop"+item.id+"' onclick='bambooReplyPop("+item.id+");'>댓글</button>";
					str += "<div class='replyBoxArea' id='replyBox"+item.id+"'></div></div><hr></td></tr>";
				});
				str += "</table>";
				str += "<a href='/narangnorang/post/write?category=" + category + "'>글쓰기</a>";
				$("#postTable").append(str);
				//history.pushState('', '', "/narangnorang/post?category=" + category + "&p=" + result.pageDto.currentPage);
				
				
				h = "";
				
				[totalPage, first, last, prev, next] = pagingOp(result.pageDto.totalRows, result.pageDto.limit, result.pageDto.currentPage);
					
				if (prev > 0){
					h += `<button onclick="postListOp('` + category + `', ` + prev + `)"> 이전 </button>`;
				}
				for (var i = first; i <= last; i++){
					if (result.pageDto.currentPage == i) {
						h += i;
					}else{
						h += `<a onclick="postListOp('` + category + `', ` + i + `)">` + i + `</a>`;
					}
				}
				
				if (last < totalPage){
					h += `<button onclick="postListOp('` + category + `', ` + next + `)"> 다음 </button>`;
				}
				
				$("#paging").html(h);

			}else{
				$("#postTable").empty();
				str = "";
				str += `<button id="btn_allList" onclick="postListOp('` + category + `', 1)">전체글</button>
						<button id="btn_overTen" onclick="postListOp('` + category + `', 1, 10)">추천 10개 이상</button>
						<button id="btn_overThirty" onclick="postListOp('` + category + `', 1, 30)">추천 30개 이상</button><br>
						<select id="searchCol" onchange="postSearch('`+category+`')">
							<option value="title">제목</option>
							<option value="member_name">작성자</option>
						</select>
						<input type="text" id="keyword" onkeyup="postSearch('`+category+`')">
						<table border="1" id="postTableContent">
							<thead>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>글쓴이</th>
									<th>작성일</th>
									<th>조회</th>
									<th>추천</th>
								</tr>
							</thead>`;
				result.postDto.forEach(function(item){
					str += "<tr>"
       				str += "<td>"+item.id+"</td>";
       				str += "<td><a href = '/narangnorang/post/" + item.id + "'>" + item.title + "</a></td>";
       				str += "<td>"+item.memberName+"</td>";
       				str += "<td>"+item.datetime+"</td>";
       				str += "<td>"+item.views+"</td>";
       				str += "<td>"+item.likes+"</td>";
       				str += "</tr>";
				})
				str += "</table>";
				str += "<a href='/narangnorang/post/write?category=" + category + "'>글쓰기</a>";
				$("#postTable").append(str);
				//history.pushState('', '', "/narangnorang/post?category=" + category + "&p=" + result.pageDto.currentPage);
				
				h = "";
				
				[totalPage, first, last, prev, next] = pagingOp(result.pageDto.totalRows, result.pageDto.limit, result.pageDto.currentPage);
					
				if (prev > 0){
					h += `<button onclick="postListOp('` + category + `', ` + prev + `)"> 이전 </button>`;
				}
				for (var i = first; i <= last; i++){
					if (result.pageDto.currentPage == i) {
						h += i;
					}else{
						h += `<a onclick="postListOp('` + category + `', ` + i + `)">` + i + `</a>`;
					}
				}
				
				if (last < totalPage){
					h += `<button onclick="postListOp('` + category + `', ` + next + `)"> 다음 </button>`;
				}
				
				$("#paging").html(h);
			}
		},
		error:function(xhr, status, e){
			console.log(xhr, status, e)
		}
	}); // end ajax
}

// 게시글 검색 함수
var postSearch = function(category, p){
	searchCol = $("#searchCol").val();
	keyword = $("#keyword").val();
	$.ajax({
		type:'GET',
		url:'/narangnorang/post/search',
		datatype:'json',
		data:{
			searchCol:searchCol,
			keyword:keyword,
			category:category,
			p:p
		},
		success:function(result){
			$("#postTableContent > tbody").empty();
			$('#paging').empty();
			if(result.PostDTO.length>=1){
				result.PostDTO.forEach(function(item){
					str = "<tr>";
		       		str += "<td>"+item.id+"</td>";
		       		str += "<td><a href = '/narangnorang/post/" + item.id + "'>" + item.title + "</a></td>";
		       		str += "<td>"+item.memberName+"</td>";
		       		str += "<td>"+item.datetime+"</td>";
		       		str += "<td>"+item.views+"</td>";
		       		str += "<td>"+item.likes+"</td>";
		       		str += "</tr>";
		       		$("#postTableContent").append(str);
				});
			}else{
				$("#postTableContent > tbody").html("<tr><td colspan='6'>검색 결과가 없습니다.</td><tr>");
			};
			
			h = "";
			
			[totalPage, first, last, prev, next] = pagingOp(result.PageDTO.totalRows, result.PageDTO.limit, result.PageDTO.currentPage);
				
			if (prev > 0){
				h += `<button onclick="postSearch('` + category + `', ` + prev + `)"> 이전 </button>`;
			}
			for (var i = first; i <= last; i++){
				if (result.PageDTO.currentPage == i) {
					h += i;
				}else{
					h += `<a onclick="postSearch('` + category + `', ` + i + `)">` + i + `</a>`;
				}
			}
			
			if (last < totalPage){
				h += `<button onclick="postSearch('` + category + `', ` + next + `)"> 다음 </button>`;
			}
			
			$("#paging").html(h);
		},
		error:function(xhr, status, e){
			console.log(xhr, status, e);
		}
	}); // end ajax
}

// 대나무숲 추천 함수
var bambooLike = function(id){
	currentLike = $("#bbLikeCount"+id).text();
	$.ajax({
		type:'POST',
		url: '/narangnorang/post/like/'+id,
		success: function(result){
			if (result == 1){
				
				alert("게시글을 추천하였습니다.");
			}else if (result == -1){
				alert("추천을 취소하였습니다.");
			}
			$("#bbLikeCount"+id).text(parseInt(currentLike) + result);
		},
		error: function(xhr, status, e){	
			console.log(xhr, status, e)
		}
	});
}

// 댓글 목록 불러오기
function getBambooReply(id){
	$.ajax({
		type:'GET',
		url:'/narangnorang/post/reply/' +id,
		success: function(result){
			h = "<hr>";
			result.forEach(function(item){
				h += "<b>익명</b>  " + item.datetime;
				if ($("#userId").val() == item.memberId){
					h += "  <a>수정</a> <a>삭제</a>";
				}
				h += "<br>";
				h += item.content;
				h += "<br><br>";
			})
			h += `<textarea id="reply"></textarea>
				<button id="btn_insertReply" onclick="bbInsertReply(`+id+`)">등록</button>`;
			$("#replyBox"+id).html(h);
		}
	});
}
// 댓글창 여닫기
function bambooReplyPop(id){
	if ($("#bambooReplyPop"+id).text() == '댓글'){
		getBambooReply(id);
		$("#bambooReplyPop"+id).text('댓글 닫기');
	}else if($("#bambooReplyPop"+id).text() == '댓글 닫기'){
		$("#replyBox"+id).empty();
		$("#bambooReplyPop"+id).text('댓글');
	}
	
}

// 댓글 등록 함수
function bbInsertReply(id){
	if(confirm("댓글을 등록하시겠습니까?") == true){
		var content = $("#reply").val();
		$.ajax({
			type:'POST',
			url: '/narangnorang/post/reply',
			datatype: 'json',
			data: {
				content: content,
				postId: id
			},
			success: function(result){
				getBambooReply(id);
			},
			error: function(xhr, status, e){
				console.log(xhr, status, e)
			}
		});
	};
}


// 페이징 계산 함수
function pagingOp(totalRows, limit, currentPage){
	let totalPage = Math.ceil(totalRows / limit); // 총 페이지 수
	let pageCount = 5 // 한 그룹에 포함되는 페이지 수
	
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

// 게시글 삭제
function deletePost(id){
	if(confirm("게시글을 삭제하시겠습니까?") == true){
		
		$.ajax({
			type:'DELETE',
			url: '/narangnorang/post/' + id,
			datatype: 'json',
			success: function(result){
				alert("게시물이 삭제되었습니다.");
				postListOp('대나무숲');
			},
			error: function(xhr, status, e){
				console.log(xhr, status, e)
			}
		});
	};
}

// 게시글 수정
function updatePost(id){
	content = $("#contentArea"+id).text();
	t = "<textarea class='bbEditPost'>" + content + "</textarea>"
	t += "<button onclick='updatePostPro("+id+")'>수정</button>"
	$("#postSection" + id).html(t);
}
function updatePostPro(id){
	content = $("#postSection"+id +" .bbEditPost").val();
	$.ajax({
        type: 'PUT',
        url: '/narangnorang/post/' + id,
        datatype: "json",
        data: {
        	title: null,
            content: content
        },
        success: function(result) {
            alert("게시글을 수정하였습니다.");
            postListOp('대나무숲');
        },
		error: function(xhr, status, e){
			console.log(xhr, status, e)
		}
    });
}


$(document).ready(function(){
	postListOp('자유게시판');
	
	$("#btn_freeBoard").on('click', function(){postListOp('자유게시판')});
	$("#btn_infoBoard").on('click', function(){postListOp('정보게시판')});
	$("#btn_goodWordBoard").on('click', function(){postListOp('예쁜말게시판')});
	$("#btn_bambooBoard").on('click', function(){postListOp('대나무숲')});
});