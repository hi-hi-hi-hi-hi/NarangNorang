<%@page import="com.narangnorang.dto.PostDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table id="buy" width="100%" cellspacing="0" cellpadding="0">
	<tr>
		<td>
			<table align="center" width="710" cellspacing="0" cellpadding="0"
				   border="1" >

				<tr>
				</tr>
				<tr>
					<th><button onclick=""><a href="buy?category=floor">바닥</a></button></th>
					<th><button onclick=""><a href="buy?category=wallpaper">벽지</a></button></th>
					<th><button onclick=""><a href="buy?category=bed">침대</a></button></th>
					<th><button onclick=""><a href="buy?category=closet">옷장</a></button></th>
					<th><button onclick=""><a href="buy?category=desk">책상</a></button></th>
					<th><button onclick=""><a href="buy?category=chair">의자</a></button></th>
					<th><button onclick=""><a href="buy?category=walldecoRight">벽장식오른쪽</a></button></th>
					<th><button onclick=""><a href="buy?category=walldecoLeft">벽장식왼쪽</a></button></th>
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
									<img src="/narangnorang/images/items/items/${dto.id}.png" border="0" align="center" width="200px" height="100">
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
<%--							<form name="buyForm">--%>
							<tr>
								<td height="10">
									<input type="hidden" name="itemId" value="${dto.id}">
									<input type="hidden" name="category" value="${dto.category}">
									<input type="hidden" name="price" value="${dto.price}">
							</tr>
							<tr>
								<td class= "inline-flex" align ="center">
									<button onclick="buy(${dto.id},${memberId},${dto.price})">구매</button>&nbsp;&nbsp;
									<button class="req" data-xxx="wish" data-item="${dto.id}">위시리스트</button>
								</td>
							</tr>

<%--							</form>--%>
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
