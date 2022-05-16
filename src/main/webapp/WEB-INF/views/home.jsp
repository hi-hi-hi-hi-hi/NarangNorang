<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나랑노랑</title>

		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		<link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">

		<title>Hexashop - Product Listing Page</title>


		<!-- Additional CSS Files -->
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

		<link rel="stylesheet" type="text/css" href="css/font-awesome.css">

		<link rel="stylesheet" href="css/templatemo-hexashop.css">


		<!--

        TemplateMo 571 Hexashop

        https://templatemo.com/tm-571-hexashop

        -->
	<script type="text/javascript" src="/narangnorang/js/miniroom.js"></script>
	<!-- jQuery -->
	<script src="js/jquery-2.1.0.min.js"></script>

	<!-- Bootstrap -->
	<script src="js/popper.js"></script>
	<script src="js/bootstrap.min.js"></script>

	<!-- Plugins -->
	<script src="js/owl-carousel.js"></script>
	<script src="js/accordions.js"></script>
	<script src="js/datepicker.js"></script>
	<script src="js/scrollreveal.min.js"></script>
	<script src="js/waypoints.min.js"></script>
	<script src="js/jquery.counterup.min.js"></script>
	<script src="js/imgfix.min.js"></script>
	<script src="js/slick.js"></script>
	<script src="js/lightbox.js"></script>
	<script src="js/isotope.js"></script>

	<!-- Global Init -->
	<script src="js/custom.js"></script>

	<script>

		$(function() {
			var selectedClass = "";
			$("p").click(function(){
				selectedClass = $(this).attr("data-rel");
				$("#portfolio").fadeTo(50, 0.1);
				$("#portfolio div").not("."+selectedClass).fadeOut();
				setTimeout(function() {
					$("."+selectedClass).fadeIn();
					$("#portfolio").fadeTo(50, 1);
				}, 500);

			});
		});

	</script>
</head>
<body>
	<h1>홈</h1>
	<jsp:include page="common/top.jsp" flush="true" /><br>
	<jsp:include page="common/navBar.jsp" flush="true" /><br>
	<jsp:include page="miniroom/miniroom_JY.jsp" flush="true" /><br>
</body>
</html>