<%@page import="com.narangnorang.dto.PostDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<div>
<%--<c:forEach var="dto" items="${myRoomList}" varStatus="status">--%>
			<div style="position: absolute;">
				<div style="position: relative; top: 176px; left: 0px;"><img src="/narangnorang/images/items/floor01.png"width="500"></img>
				</div>
			</div>

			<div style="position: absolute;">
			<div style="position: relative; top: 150px; left: 100px; z-index: 1;"><img src="/narangnorang/images/items/bed01.png" width="200"></img>
			</div>
			</div>
	<div style="position: absolute;">
		<div style="position: relative; top: -50px; left: 150px; z-index: 0"><img src="/narangnorang/images/items/closet01.png" width="130" height="340"></img>
		</div>
	</div>
		<div style="position: absolute;">
			<div style="position: relative; top: 150px; left: 300px; z-index: 1;"><img src="/narangnorang/images/items/desk01.png" width="130"></img>
			</div>
		</div>
			<div style="position: absolute;">
				<div style="position: relative; top: 100px; left: 10px; z-index: 1;"><img src="/narangnorang/images/items/walldeco01.png" width="130"></img>
				</div>
			</div>
				<div style="position: absolute;">
					<div style="position: relative; top: 0px; left: 0px; z-index: 0;"><img src="/narangnorang/images/items/wallpaper01.png" width="500"></img>
					</div>
				</div>
			<img src="/narangnorang/images/defaultMiniroom.jpeg" width="500"></img>
		</div>
</table>
<ul>
	<li><a href="/narangnorang/home/buy">아이템 구매</a></li>
	<li><a href="/narangnorang/home/style">미니룸 꾸미기</a></li>

</ul>