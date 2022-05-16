
document.addEventListener("DOMContentLoaded", function(buy1) {
    const input = document.getElementById("buy");

    input.style.display = "";});



//꾸미기 목록 보이기
function style()  {

  const styleDiv = document.getElementById('style');
  const buyDiv = document.getElementById('buy');
      buyDiv.style.display = 'none';

  if (styleDiv.style.display === ''){
      styleDiv.style.display = 'none';
  }else{
      styleDiv.style.display = '';
  }

}

// 구매 목록 보이기.
function buy() {

    const styleDiv = document.getElementById('style');
	const buyDiv = document.getElementById('buy');
    styleDiv.style.display = 'none';

    if (buyDiv.style.display === ''){
        buyDiv.style.display = 'none';;
    }else{
        buyDiv.style.display = '';
    }

}


    $(document).ready(function(){

    	/*
    	    <button class="req" data-xxx="order">구매</button>
        	<button class="req" data-xxx="wish">위시리스트</button>
    	*/
$(".req").on("click", function(){

    var target = $(this).attr("data-xxx");
    if(target == 'wish'){
        $("form").attr({
            "action": "wishAdd",
            "method":"get"
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
