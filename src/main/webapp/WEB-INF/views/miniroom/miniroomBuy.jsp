<%@page import="com.narangnorang.dto.PostDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<table id="buy" width="100%" cellspacing="0" cellpadding="0">
	<tr>
		<td>
			<table align="center" width="710" cellspacing="0" cellpadding="0"
				   border="0">

				<tr>

				</tr>
				<tr>
					<th><a href="buy?category=floor">floor</a></th>
					<th><a href="buy?category=wallpaper">wallpaper</a></th>
					<th><a href="buy?category=bed">bed</a></th>
					<th><a href="buy?category=closet">closet</a></th>
					<th><a href="buy?category=desk">desk</a></th>
					<th><a href="buy?category=walldeco">walldeco</a></th>
				</tr>

				<tr>
					<td height="5"></td>
				</tr>
				<tr>
					<td height="1" colspan="8" bgcolor="CECECE"></td>
				</tr>
				<tr>
					<td height="10"></td>
					<!-- myItemDTO에 세션 스코프 로그인 아이디값 저장시켰음.-->

				</tr>

				<tr>
<c:forEach var="dto" items="${itemList}" varStatus="status">


					<td>
						<table style='padding:15px'>
							<tr>



								<td>
									<img src="/narangnorang/images/items/${dto.id}.png" border="0" align="center" width="100px" height="100">
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
									가격${dto.price}</strong></font>
								</td>
							</tr>
							<tr>
								<td class="td_red" align ="center"><strong>
									상품명${dto.name}</strong>
								</td>
							</tr>
							<form name="buyForm">
							<tr>
								<td height="10">



									<input type="hidden" name="itemId" value="${dto.id}">
									<input type="hidden" name="category" value="${dto.category}">
									<input type="hidden" name="price" value="${dto.price}">
							</tr>
							<tr>
								<td class= "inline-flex" align ="center">
									<button class="req" data-xxx="buy" data-item="${dto.id}">구매</button>&nbsp;&nbsp;
									<button class="req" data-xxx="wish" data-item="${dto.id}">위시리스트</button>
								</td>
							</tr>

							</form>
						</table>
					</td>
	<c:if test="${status.count%4==0}">
				<tr>
					<td height="10">
				</tr>

				</c:if>
				</c:forEach>
				</tr>

			</table>
			<hr >
		</td>
	</tr>
	<tr>
		<td height="10">
	</tr>
</table>
