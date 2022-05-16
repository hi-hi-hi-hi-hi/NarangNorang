miniroom_hexa
<%@page import="com.narangnorang.dto.PostDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<body>
<table width="100%" cellspacing="0" cellpadding="0">


	<tr>
		<td>
	<tr>
		<td rowspan="7">
			<img src="images/defaultMiniroom.jpeg" border="0" width="500" />
		</td>


	</tr>
	<tr>
		<td height="10">
	</tr>
	<tr>
		<td>
			<form name="buyItem">
				<input type="submit" value="구매" onclick="buy()"/>
				<input type="submit" value="꾸미기" class="style" onclick="style()"/>

			</form>
		</td>
	</tr>

</table>
<section class="section" id="products">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-heading">
					<h2>Our Latest Products</h2>
					<span>Check out all of our products.</span>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-lg-4">
				<div class="item">
					<div class="thumb">
						<div class="hover-content">
							<ul>
								<li><a href="single-product.html"><i class="fa fa-eye"></i></a></li>
								<li><a href="single-product.html"><i class="fa fa-star"></i></a></li>
								<li><a href="single-product.html"><i class="fa fa-shopping-cart"></i></a></li>
							</ul>
						</div>
						<img src="images/items/floor1.png" alt="">
					</div>
					<div class="down-content">
						<h4>Classic Spring</h4>
						<span>$120.00</span>
						<ul class="stars">
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="item">
					<div class="thumb">
						<div class="hover-content">
							<ul>
								<li><a href="single-product.html"><i class="fa fa-eye"></i></a></li>
								<li><a href="single-product.html"><i class="fa fa-star"></i></a></li>
								<li><a href="single-product.html"><i class="fa fa-shopping-cart"></i></a></li>
							</ul>
						</div>
						<img src="images/items/men-02.jpg" alt="">
					</div>
					<div class="down-content">
						<h4>Air Force 1 X</h4>
						<span>$90.00</span>
						<ul class="stars">
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="item">
					<div class="thumb">
						<div class="hover-content">
							<ul>
								<li><a href="single-product.html"><i class="fa fa-eye"></i></a></li>
								<li><a href="single-product.html"><i class="fa fa-star"></i></a></li>
								<li><a href="single-product.html"><i class="fa fa-shopping-cart"></i></a></li>
							</ul>
						</div>
						<img src="assets/images/men-03.jpg" alt="">
					</div>
					<div class="down-content">
						<h4>Love Nana ‘20</h4>
						<span>$150.00</span>
						<ul class="stars">
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="item">
					<div class="thumb">
						<div class="hover-content">
							<ul>
								<li><a href="single-product.html"><i class="fa fa-eye"></i></a></li>
								<li><a href="single-product.html"><i class="fa fa-star"></i></a></li>
								<li><a href="single-product.html"><i class="fa fa-shopping-cart"></i></a></li>
							</ul>
						</div>
						<img src="assets/images/women-01.jpg" alt="">
					</div>
					<div class="down-content">
						<h4>New Green Jacket</h4>
						<span>$75.00</span>
						<ul class="stars">
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="item">
					<div class="thumb">
						<div class="hover-content">
							<ul>
								<li><a href="single-product.html"><i class="fa fa-eye"></i></a></li>
								<li><a href="single-product.html"><i class="fa fa-star"></i></a></li>
								<li><a href="single-product.html"><i class="fa fa-shopping-cart"></i></a></li>
							</ul>
						</div>
						<img src="assets/images/women-02.jpg" alt="">
					</div>
					<div class="down-content">
						<h4>Classic Dress</h4>
						<span>$45.00</span>
						<ul class="stars">
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="item">
					<div class="thumb">
						<div class="hover-content">
							<ul>
								<li><a href="single-product.html"><i class="fa fa-eye"></i></a></li>
								<li><a href="single-product.html"><i class="fa fa-star"></i></a></li>
								<li><a href="single-product.html"><i class="fa fa-shopping-cart"></i></a></li>
							</ul>
						</div>
						<img src="assets/images/women-03.jpg" alt="">
					</div>
					<div class="down-content">
						<h4>Spring Collection</h4>
						<span>$130.00</span>
						<ul class="stars">
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="item">
					<div class="thumb">
						<div class="hover-content">
							<ul>
								<li><a href="single-product.html"><i class="fa fa-eye"></i></a></li>
								<li><a href="single-product.html"><i class="fa fa-star"></i></a></li>
								<li><a href="single-product.html"><i class="fa fa-shopping-cart"></i></a></li>
							</ul>
						</div>
						<img src="assets/images/kid-01.jpg" alt="">
					</div>
					<div class="down-content">
						<h4>School Collection</h4>
						<span>$80.00</span>
						<ul class="stars">
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="item">
					<div class="thumb">
						<div class="hover-content">
							<ul>
								<li><a href="single-product.html"><i class="fa fa-eye"></i></a></li>
								<li><a href="single-product.html"><i class="fa fa-star"></i></a></li>
								<li><a href="single-product.html"><i class="fa fa-shopping-cart"></i></a></li>
							</ul>
						</div>
						<img src="assets/images/kid-02.jpg" alt="">
					</div>
					<div class="down-content">
						<h4>Summer Cap</h4>
						<span>$12.00</span>
						<ul class="stars">
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="item">
					<div class="thumb">
						<div class="hover-content">
							<ul>
								<li><a href="single-product.html"><i class="fa fa-eye"></i></a></li>
								<li><a href="single-product.html"><i class="fa fa-star"></i></a></li>
								<li><a href="single-product.html"><i class="fa fa-shopping-cart"></i></a></li>
							</ul>
						</div>
						<img src="assets/images/kid-03.jpg" alt="">
					</div>
					<div class="down-content">
						<h4>Classic Kid</h4>
						<span>$30.00</span>
						<ul class="stars">
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
							<li><i class="fa fa-star"></i></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="pagination">
					<ul>
						<li>
							<a href="#">1</a>
						</li>
						<li class="active">
							<a href="#">2</a>
						</li>
						<li>
							<a href="#">3</a>
						</li>
						<li>
							<a href="#">4</a>
						</li>
						<li>
							<a href="#">></a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- ***** Products Area Ends ***** -->

<!-- ***** Footer Start ***** -->
<footer>
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<div class="first-item">
					<div class="logo">
						<img src="assets/images/white-logo.png" alt="hexashop ecommerce templatemo">
					</div>
					<ul>
						<li><a href="#">16501 Collins Ave, Sunny Isles Beach, FL 33160, United States</a></li>
						<li><a href="#">hexashop@company.com</a></li>
						<li><a href="#">010-020-0340</a></li>
					</ul>
				</div>
			</div>
			<div class="col-lg-3">
				<h4>Shopping &amp; Categories</h4>
				<ul>
					<li><a href="#">Men’s Shopping</a></li>
					<li><a href="#">Women’s Shopping</a></li>
					<li><a href="#">Kid's Shopping</a></li>
				</ul>
			</div>
			<div class="col-lg-3">
				<h4>Useful Links</h4>
				<ul>
					<li><a href="#">Homepage</a></li>
					<li><a href="#">About Us</a></li>
					<li><a href="#">Help</a></li>
					<li><a href="#">Contact Us</a></li>
				</ul>
			</div>
			<div class="col-lg-3">
				<h4>Help &amp; Information</h4>
				<ul>
					<li><a href="#">Help</a></li>
					<li><a href="#">FAQ's</a></li>
					<li><a href="#">Shipping</a></li>
					<li><a href="#">Tracking ID</a></li>
				</ul>
			</div>
			<div class="col-lg-12">
				<div class="under-footer">
					<p>Copyright © 2022 HexaShop Co., Ltd. All Rights Reserved.

						<br>Design: <a href="https://templatemo.com" target="_parent" title="free css templates">TemplateMo</a>

						<br>Distributed By: <a href="https://themewagon.com" target="_blank" title="free & premium responsive templates">ThemeWagon</a></p>
					<ul>
						<li><a href="#"><i class="fa fa-facebook"></i></a></li>
						<li><a href="#"><i class="fa fa-twitter"></i></a></li>
						<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
						<li><a href="#"><i class="fa fa-behance"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</footer>

<a href="/narangnorang/post/writeUI">글쓰기</a>
</body>



