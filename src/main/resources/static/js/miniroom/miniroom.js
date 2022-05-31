$(document).ready(function(){

    /*
        <button class="req" data-xxx="order">구매</button>
        <button class="req" data-xxx="wish">위시리스트</button>
    */
    $(".req").on("click", function(){

        var target = $(this).attr("data-xxx");
        var itemId=$(this).attr("data-item");
        if(target == 'wish'){
            $.ajax({
                type: 'PUT',
                url: '/narangnorang/home/buy/'+itemId,

                datatype: "json",
                data:{
                    itemId: itemId,
                },
                success: function(data){
                    alert("위시리스트에 추가되었습니다.");
                    location.href="/narangnorang/home/buy/"+itemId;
                },
                error: function(xhr, status, e){
                    console.log(xhr,status, e)
                },
            });

        }else if (target=='buy'){
            //주문
            // $.ajax({
            //     type: 'POST',
            //     url: '/narangnorang/home/buy',
            //
            //     data:data,
            //     success: function(data){
            //         location.href="/narangnorang/home/buy"
            //     },
            //     error: function(xhr, status, e){
            //         console.log(xhr,status, e)
            //         alert("에러발생")
            //     },
            // });
            $("form").attr({
                "action": "/narangnorang/home/buy",
                "method":"post"
            });
            $("form").submit();


        }else if(target == 'apply'){
            $.ajax({
                type: 'PUT',
                url: '/narangnorang/home/style',

                datatype: "json",
                data:data,
                success: function(data){
                    alert("적용완료");
                    location.href="/narangnorang/home/style";
                },
                error: function(xhr, status, e){
                    console.log(xhr,status, e)
                },
            });
            // $("form").attr({
            //     "action": "/narangnorang/home/style",
            //     "method":"post"
            // });
            // $("form").submit();

        }//end if

    });


});