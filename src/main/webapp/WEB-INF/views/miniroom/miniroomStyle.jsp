<%@page import="com.narangnorang.dto.PostDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


	<!-- !!!!!!!! 꾸미기 !!!!!!!!!-->

		<table id="style" width="100%" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<table align="center" width="710" cellspacing="0" cellpadding="0"
						   border="1">

						<tr></tr>
						<tr>
							<th><button onclick=""><a href="style?category=floor">바닥</a></button></th>
							<th><button onclick=""><a href="style?category=wallpaper">벽지</a></button></th>
							<th><button onclick=""><a href="style?category=bed">침대</a></button></th>
							<th><button onclick=""><a href="style?category=closet">옷장</a></button></th>
							<th><button onclick=""><a href="style?category=desk">책상</a></button></th>
							<th><button onclick=""><a href="style?category=chair">의자</a></button></th>
							<th><button onclick=""><a href="style?category=walldecoRight">벽장식오른쪽</a></button></th>
							<th><button onclick=""><a href="style?category=walldecoLeft">벽장식왼쪽</a></button></th>
						</tr>

						<tr>
							<td height="5" colspan="8" bgcolor="CECECE"></td>
						</tr>


						<tr>
							<c:forEach var="dto" items="${myItemList}" varStatus="status">

							<td>


								<table style='padding:15px'>

								<tr>
										<td>
											<img src="/narangnorang/images/items/items/${dto.id}.png" border="0" align="center" width="100px" height="100">
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
											<button type="button" data-xxx="apply" onclick="apply(${dto.id},${memberId},'${dto.category}')">적용하기</button>
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

