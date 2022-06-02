<%@page import="com.narangnorang.dto.PostDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

		<div>

			<div style="position: absolute;">
				<div style="position: relative; top: 176px; left: 0px;"><img src="/narangnorang/images/items/${myRoomDTO.floor}.png"width="500"></img>
				</div>
			</div>

			<div style="position: absolute;">
			<div style="position: relative; top: 190px; left: 65px; z-index: 2;"><img src="/narangnorang/images/items/${myRoomDTO.bed}.png" width="200"></img>
			</div>
			</div>
	<div style="position: absolute;">
		<div style="position: relative; top: 20px; left: 150px; z-index: 1; "><img src="/narangnorang/images/items/${myRoomDTO.closet}.png" width="120" height="230"></img>
		</div>
	</div>
		<div style="position: absolute;">
			<div style="position: relative; top: 220px; left: 320px; z-index: 1;"><img src="/narangnorang/images/items/${myRoomDTO.desk}.png" width="130"></img>
			</div>
		</div>
			<div style="position: absolute;">
				<div style="position: relative; top: 100px; left: 10px; z-index: 1;"><img src="/narangnorang/images/items/${myRoomDTO.walldeco}.png" width="130"></img>
				</div>
			</div>
				<div style="position: absolute;">
					<div style="position: relative; top: 0px; left: 0px; z-index: 0;"><img src="/narangnorang/images/items/${myRoomDTO.wallpaper}.png" width="500"></img>
					</div>
				</div>
			<img src="/narangnorang/images/default.jpg" width="500"></img>
		</div>

<ul>
	<li><a href="/narangnorang/home/buy">아이템 구매</a></li>
	<li><a href="/narangnorang/home/style">미니룸 꾸미기</a></li>

</ul>