<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.html</title>
</head>
<body>
	<h1>Index Page</h1>
	<a href="getText">text받기</a>
	<a href="getObject">오브젝트받기</a>
	<a href="getList">List받기</a>
	<a href="sample/it/100">쿼리 스트링 처리</a>
	<a href="sample/novel/2023">쿼리 스트링 처리</a>
	
	<a href="sample/data">샘플데이터</a>
	
	<form action="sample/data" method="post">
		<input type="text" placeholder="name" name="name">
		<input type="text" placeholder="age" name="age">
		<input type="text" placeholder="message" name="message">
		<input type="submit" value="POST전송">
	</form>
</body>
</html>