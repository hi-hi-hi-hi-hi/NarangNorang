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

                    location.href="/narangnorang/home/buy/"+itemId;
                },
                error: function(xhr, status, e){
                    console.log(xhr,status, e)
                },
            });
            console.log("위시리스트에 추가되었습니다");
            alert("위시리스트에 추가되었습니다.");
        }else if (target=='order'){
            var itemId=$(this).attr("data-item");
            console.log(itemId)
            //주문
            $("form").attr({
                "action": "/narangnorang/home/buy",
                "method":"post"
            });
            $("form").submit();

        }else if(target == 'apply'){
            var memberId = $(this).attr("data-item");
            $("form").attr({
                "action": "/narangnorang/home/style",
                "method":"post"
            });
            //$("form").submit();

        }//end if

    });


});