$(document).ready(function(){

    	/*
    	    <button class="req" data-xxx="order">구매</button>
        	<button class="req" data-xxx="wish">위시리스트</button>
    	*/
$(".req").on("click", function(){

    var target = $(this).attr("data-xxx");
    if(target == 'wish'){
        var memberId=$('#memberId').val();
        var itemId=$(this).attr("data-item");
        var wish = $('#wish').val();
        console.log(itemId);

        $("form").attr({
            "action": "/narangnorang/home/buy/"+itemId,
            "method":"post"
        });
        // $("form").submit();

    }else if (target=='order'){
        //주문
        $("form").attr({
            "action": "home/buy",
            "method":"post"
        });
        $("form").submit();

    }else if(target == 'represent'){
        $("form").attr({
            "action": "home/style",
            "method":"post"
        });
        $("form").submit();

    }//end if

});


});
