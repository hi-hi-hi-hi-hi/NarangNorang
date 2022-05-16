
//꾸미기 목록 보이기
function style()  {

  const style = document.getElementById('style');
  const buy = document.getElementById('buy');


  if (style.style.display === ''){
      style.style.display = 'none';
  }else{
      style.style.display = '';
  }

}

// 구매 목록 보이기.
function buy() {

    const style = document.getElementById('style');
	const buy = document.getElementById('buy');


    if (buy.style.display === ''){
        buy.style.display = 'none';;
    }else{
        buy.style.display = '';
    }

}


$(document).ready(function(){

    const input = document.getElementById("buy");

    input.style.display = "none";

    	/*
    	    <button class="req" data-xxx="order">구매</button>
        	<button class="req" data-xxx="wish">위시리스트</button>
    	*/
$(".req").on("click", function(){

    var target = $(this).attr("data-xxx");
    if(target == 'wish'){
        $("form").attr({
            "action": "home/{itemId}",
            "method":"put"
        });
        $("form").submit();
    }else{
        //주문
        $("form").attr({
            "action": "home",
            "method":"post"
        });
        $("form").submit();

    }//end if

});


});
