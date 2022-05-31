$(document).ready(function(){

    /*
        <button class="req" data-xxx="order">구매</button>
        <button class="req" data-xxx="wish">위시리스트</button>
    */
    $(".req").on("click", function(){

        var target = $(this).attr("data-xxx");
        var itemId=$(this).attr("data-item");

    });


});