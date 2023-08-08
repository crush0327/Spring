<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>LIST PAGE</h3>
	<table>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>관리자여부</th>
			<th>등록일</th>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.id}</td>
				<td>
					<c:forEach begin="0" end="${list.tab}">
						&nbsp;&nbsp;&nbsp;
					</c:forEach>
					<a href="read.htm?num=${list.num}&pg=${pg}">${list.subject}</a>
				</td>
				<td>${list.name}</td>
				<td><fmt:formatDate value="${list.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${list.hit}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>