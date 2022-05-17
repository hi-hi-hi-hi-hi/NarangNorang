$(document).ready(function(){

    	/*
    	    <button class="req" data-xxx="order">구매</button>
        	<button class="req" data-xxx="wish">위시리스트</button>
    	*/
$(".req").on("click", function(){

    var target = $(this).attr("data-xxx");
    if(target == 'wish'){
        $("form").attr({
            "action": "home/buy/{itemId}",
            "method":"put"
        });
        $("form").submit();

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
