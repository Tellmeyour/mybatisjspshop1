<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>짝퉁옥션 글쓰기</title>
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" >
	<script src="/resources/js/test.js"></script>

</head>
<body>
	<span>
		<h1><a href="/">홈페이지</a></h1>
		
		<h1>글쓰기 페이지</h1>
	</span>
	<div class="container">	
		<div class="row">
			<form method="post" action="/board/post">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="2" style="text-align: center;">글쓰기 양식</th>
					</tr>
				</thead>
				<tbody>					
					<tr>
						<td><input type="text" id="title" name="title" class="form-control" placeholder="제목" maxlength="50" /></td>
					</tr>
					<tr>
						<td><textarea id="content" name="content" class="form-control" placeholder="내용" maxlength="2048"></textarea></td>
					</tr>				
				</tbody>
			</table>		
			<button class="btn btn-primary pull-right" type="submit">success</button>
			</form>
		</div>
	</div>
	
	<!-- <form method="post" action="/board/post">
		<input type="text" placeholder="제목" name="title" id="title">
		 <input type="text" placeholder="내용" name="content" id="content">
		<button type="submit">완료</button>
	</form> -->

	
</body>
</html>