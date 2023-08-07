<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title></title>
<style type="text/css">
	.name {
		background-color: #005b23;
		color: #ffffff;
	}
	.button {
		display: flex;
		justify-content: center;
		margin-top: 20px;
	}
	.button input {
		margin: 10px;
		border-radius: 20px;
		border: 1px solid #005b23;
		background-color: #ffffff;
		color: #005b23;
		width: 100px;
		height: 30px;
	}
	.button input:hover {
		background-color: #005b23;
		color: #ffffff;
	}
</style>
</head>
<body>
	<h1 style="text-align: center;">Read Page</h3>
	
	<table border="2px solid #005b23" style="text-align: center; width: 600px; margin: 0px auto;">
		<tr>
			<td colspan="6">${dto.subject}</td>
		</tr>
		<tr>
			<td class="name">작성자</td>
			<td>${dto.name}</td>
			<td class="name">작성일</td>
			<td><fmt:formatDate value="${dto.regdate}" pattern="yy-MM-dd" /> </td>
			<td class="name">조회수</td>
			<td>${dto.hit}</td>
		</tr>
		<tr>
			<td class="name">내용</td>
			<td colspan="5">${dto.content}</td>
		</tr>
	</table>
	<div class="button">
		<input type="button" value="리스트목록" onclick="location.href='list.htm'">
		<input type="button" value="답글달기" onclick="location.href='replyForm.htm?num=${dto.num}&pg=${pg}'">
		<input type="button" value="수정하기" onclick="location.href='updateForm.htm?num=${dto.num}&pg=${pg}'">
		<input type="button" value="삭제하기" onclick="location.href='deleteForm.htm?num=${dto.num}&pg=${pg}'">
	</div>
</body>
</html>