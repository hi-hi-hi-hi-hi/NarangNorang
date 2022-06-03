<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<div id="item">
				<c:if test="${myRoomDTO.floor !=0}">
					<div style="position: absolute;">
						<div style="position: relative;"><img src="/narangnorang/images/items/${myRoomDTO.floor}.png" width="500px"></img>
						</div>
					</div>
				</c:if>
				<c:if test="${myRoomDTO.bed !=0}">
					<div style="position: absolute;">
						<div style="position: relative; z-index: 1;"><img src="/narangnorang/images/items/${myRoomDTO.bed}.png" width="500px"></img>
						</div>
					</div>
				</c:if>
				<c:if test="${myRoomDTO.closet !=0}">
					<div style="position: absolute;">
						<div style="position: relative;z-index: 1; "><img src="/narangnorang/images/items/${myRoomDTO.closet}.png" width="500px"></img>
						</div>
					</div>
				</c:if>
				<c:if test="${myRoomDTO.desk !=0}">
						<div style="position: absolute;">
							<div style="position: relative;z-index: 1;"><img src="/narangnorang/images/items/${myRoomDTO.desk}.png" width="500px"></img>
							</div>
						</div>
				</c:if>
				<c:if test="${myRoomDTO.walldecoRight !=0}">
					<div style="position: absolute;">
						<div style="position: relative; z-index: 1;"><img src="/narangnorang/images/items/${myRoomDTO.walldecoRight}.png" width="500px"></img>
						</div>
					</div>
				</c:if>
				<c:if test="${myRoomDTO.wallpaper !=0}">
					<div style="position: absolute;">
						<div style="position: relative; z-index: 0;"><img src="/narangnorang/images/items/${myRoomDTO.wallpaper}.png" width="500px"></img>
						</div>
					</div>
				</c:if>
				<c:if test="${myRoomDTO.walldecoLeft !=0}">
					<div style="position: absolute;">
						<div style="position: relative; z-index: 0;"><img src="/narangnorang/images/items/${myRoomDTO.walldecoLeft}.png" width="500px"></img>
						</div>
					</div>
				</c:if>
				<c:if test="${myRoomDTO.chair !=0}">
					<div style="position: absolute;">
						<div style="position: relative; z-index: 1;"><img src="/narangnorang/images/items/${myRoomDTO.chair}.png" width="500px"></img>
						</div>
					</div>
				</c:if>

			<img src="/narangnorang/images/default.png" width="500" height="550px"/>
		</div>

<ul>
	<li><button><a href="/narangnorang/home/buy">아이템 구매</a></button></li>
	<li><button><a href="/narangnorang/home/style">미니룸 꾸미기</a></button></li>
	<li><button><a href="/narangnorang/home/wish">위시리스트</a></button></li>

</ul>