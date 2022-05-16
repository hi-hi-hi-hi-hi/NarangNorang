<%@page import="com.narangnorang.dto.PostDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table width="100%" cellspacing="0" cellpadding="0">
	
	
	<tr>
		<td>
			<table align="center" width="710" cellspacing="0" cellpadding="0"
				border="0">
	
				<tr>
					<th height="5">번호</th>
					<th height="5">제목</th>
					<th height="1" colspan="8" bgcolor="CECECE">작성자</th>
					<th height="10">작성일</th>
					<th>조회수</th>
					<th>추천</th>
				</tr>
		<c:forEach var="dto" items="${postList}" varStatus="status">
	 <tr>
	 	<td>${status.count}</td>
	 	<td><a href="/narangnorang/post/${dto.id}">${dto.title}</a></td>
	 	<td height="1" colspan="8" bgcolor="CECECE">${dto.memberNickname}</td>
	 	<td>${dto.datetime}</td>
	 	<td>${dto.views}</td>
	 	<td>${dto.likes}</td>
	</tr>
   </c:forEach>
				

			</table>
			<hr >
		</td>
	</tr>
	<tr>
		<td height="10">
	</tr>
</table>
<a href="/narangnorang/post/writeUI">글쓰기</a>