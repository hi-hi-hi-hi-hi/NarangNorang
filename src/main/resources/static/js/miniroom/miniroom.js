$(document).ready(function(){

    /*
        <button class="req" data-xxx="order">구매</button>
        <button class="req" data-xxx="wish">위시리스트</button>
    */
    $(".req").on("click", function(){

        var target = $(this).attr("data-xxx");
        if(target == 'wish'){
            var itemId=$(this).attr("data-item");
            console.log(itemId);

            $("form").attr({
                "action": "/narangnorang/home/buy/"+itemId,
                "method":"post"
            });
            // $("form").submit();

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