let apply = function(itemId,memberId,category){
    if(confirm("미니룸에 적용하시겠습니까?") == true){
        $.ajax({
            type:'PUT',
            url: '/narangnorang/home/style',
            data:{
                itemId:itemId,
                memberId:memberId,
                category:category
            },
            success: function(result){
                alert("적용완료");
                $("#item").load("/narangnorang/home/style #item");
            },
            error: function(xhr, status, e){
                console.log(xhr, status, e)
            }
        });
    };
};

let buy = function(itemId,memberId,price){
    if(confirm("구매하시겠습니까?") == true){
        $.ajax({
            type:'POST',
            url: '/narangnorang/home/buy',
            data:{
                itemId:itemId,
                memberId:memberId,
                price:price
            },
            success: function(mesg){
                alert(mesg);
            },
            error: function(xhr, status, e){
                console.log(xhr, status, e)
            }
        });
    };
};

let wish = function(itemId,memberId){

        $.ajax({
            type:'POST',
            url: '/narangnorang/home/buy/'+itemId,
            data:{
                itemId:itemId,
                memberId:memberId
            },
            success: function(mesg){
                alert(mesg);
                $("#WISH").load("/narangnorang/home/wish #WISH");
            },
            error: function(xhr, status, e){
                console.log(xhr, status, e)
            }
        });
};
//
// $(document).ready(function(){
//
//     /*
//         <button class="req" data-xxx="order">구매</button>
//         <button class="req" data-xxx="wish">위시리스트</button>
//     */
//     $(".req").on("click", function() {
//
//         var target = $(this).attr("data-xxx");
//         var itemId = $(this).attr("data-item");
//         if (target == 'wish') {
//             $.ajax({
//                 type: 'POST',
//                 url: '/narangnorang/home/buy/'+itemId,
//                 datatype:'json',
//
//                 success: function(mesg){
//                     alert(mesg);
//                 },
//                 error: function(xhr, status, e){
//                     console.log(xhr,status, e)
//                 },
//             });
//         }
//         //else if (target == 'buy') {
//             //주문
//             // $.ajax({
//             //     type: 'POST',
//             //     url: '/narangnorang/home/buy',
//             //     datatype:'json',
//             //
//             //     success: function(mesg){
//             //         alert(mesg);
//             //
//             //     },
//             //     error: function(xhr, status, e){
//             //         console.log(xhr,status, e)
//             //         alert("에러발생")
//             //     },
//             // });
//         //}
//     });
//
// });