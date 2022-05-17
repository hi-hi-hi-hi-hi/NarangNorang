<%@page import="com.narangnorang.dto.PostDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


	<!-- !!!!!!!! 꾸미기 !!!!!!!!!-->
	<form action=# name="styleForm" method="post">

		<table id="style" width="100%" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<table align="center" width="710" cellspacing="0" cellpadding="0"
						   border="1">

						<tr></tr>
						<tr>
							<th><a href="style?category=floor">floor</a></th>
							<th><a href="style?category=wallpaper">wallpaper</a></th>
							<th><a href="style?category=bed">bed</a></th>
							<th><a href="style?category=closet">closet</a></th>
							<th><a href="style?category=desk">desk</a></th>
							<th><a href="style?category=walldeco">walldeco</a></th>
						</tr>

						<tr>
							<td height="5" colspan="8" bgcolor="CECECE"></td>
						</tr>


						<tr>
							<c:forEach var="dto" items="${itemList}" varStatus="status">

							<td>
								<table style='padding:15px'>
									<tr>
										<!-- myItemDTO에 세션 스코프 로그인 아이디값 저장시켰음.-->
										<input type="hidden" name="memberId" value="${memberId}">
										<input type="hidden" name="itemId" value="${dto.id}">
										<!-- controller에서 mav.addObject("wish",wish) 저장하자.?-->
										<input type="hidden" name="wish" value="0">


										<td>
											<img src="/narangnorang/images/items/${dto.name}.png" border="0" align="center" width="100px" height="100">
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
											<button class="req" data-xxx="represent">적용하기</button>
										</td>
									</tr>
								</table>
							</td>
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
	</form>
