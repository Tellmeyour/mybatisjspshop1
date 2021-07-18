<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	자유게시판
	
	<c:forEach items="${boardvo}" var="dto">
		<div>
			제목:${dto.title}
		</div>
		<div>
			내용:${dto.content}
		</div>
	</c:forEach>
	
	
	
	
</body>
</html>