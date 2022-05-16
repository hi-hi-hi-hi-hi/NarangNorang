<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나랑노랑</title>
</head>
<body>
	<h1>심리상담</h1>
	<jsp:include page="common/top.jsp" flush="true"/><br>
	<jsp:include page="common/navBar.jsp" flush="true"/><br>
	<hr>
	
	<div>
		<div>
			<ul>
				<li>상담사 찾기</li>
				<li>주변 상담센터</li>
			</ul>
		</div>
		<div>
			<jsp:include page="counsel/counselorList.jsp" flush="true"/>
		</div>
	</div>
</body>
</html>