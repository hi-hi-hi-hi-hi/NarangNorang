<%@page import="com.narangnorang.dto.PostDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<table align="center" width="710" cellspacing="0" cellpadding="0"
	   border="0">
<tr>
	<td>
		<img src="images/defaultMiniroom.jpeg" border="0" width="500" />
	</td>
</tr>
	<tr>
	<td>
		<input type='button'
			   value='구매'
			   onclick='buy()' />

	</td>
	<td>
		<input type='button'
			   value='꾸미기'
			   onclick='style()' />
	</td>
</tr>
	<tr>
		<td height="70"></td>
	</tr>
</table>
<form action=# name="buyForm" method="post">
	<input type="hidden" name="memberId" value="${login.id}">
	<input type="hidden" name="itemId" value="${itemDTO.id}">
	<input type="hidden" name="wish" value="0">
<table id="buy" width="100%" cellspacing="0" cellpadding="0">





	<tr>
		<td>
			<table align="center" width="710" cellspacing="0" cellpadding="0"
				   border="0">

				<tr></tr>
				<tr>
					<th><a href="home?category=floor">floor</a></th>
					<th><a href="home?category=wallpaper">wallpaper</a></th>
					<th><a href="home?category=bed">bed</a></th>
					<th><a href="home?category=closet">closet</a></th>
					<th><a href="home?category=desk">desk</a></th>
					<th><a href="home?category=walldeco">walldeco</a></th>
				</tr>

				<tr>
					<td height="5"></td>
				</tr>
				<tr>
					<td height="1" colspan="8" bgcolor="CECECE"></td>
				</tr>
				<tr>
					<td height="10"></td>
				</tr>

				<tr>
<c:forEach var="dto" items="${itemList}" varStatus="status">

					<td>
						<table style='padding:15px'>
							<tr>


								<td>
									<img src="images/items/${dto.name}.png" border="0" align="center" width="200px" height="200">
								</td>
							</tr>
							<tr>
								<td height="10">
							</tr>
							<tr>
								<td class= "td_default" align ="center">
									${dto.category}<br>
								</td>
							</tr>
							<tr>
								<td height="10">
							</tr>
							<tr>
								<td class="td_red" align ="center"><font color="red"><strong>
									가격${dto.price}	</strong></font>
								</td>
							</tr>
							<tr>
								<td height="10">
							</tr>
							<tr>
								<td class= "inline-flex" align ="center">
									<button class="req" data-xxx="order">구매</button>&nbsp;&nbsp;
									<button class="req" data-xxx="cart">장바구니</button>
								</td>
							</tr>
						</table>
					</td>

				</tr>
				<c:if test="${status.count%4==0}">
					<tr>
						<td height="10">
					</tr>

				</c:if>
				</c:forEach>
			</table>
			<hr >
		</td>
	</tr>
	<tr>
		<td height="10">
	</tr>
</table>
</form>
