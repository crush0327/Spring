<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title>list.jsp</title>
<style type="text/css">
	th {background: orange;}
	div {width: 600px; text-align: center;}
</style>
</head>
<body>
	<h3>LIST PAGE</h3>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.num}</td>
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
	
	<div>
		<input type="button" value="글쓰기" onclick="location.href='writeform.htm'">
	</div>
	
	<table>
		<tr>
			<td>
				<c:if test="${pg>1}">
					[<a href="list.htm?pg=1">⏪</a>]
					[<a href="list.htm?pg=${pg-1}">🔙</a>]
				</c:if>
				
				<c:if test="${pg<=1}">
					[<span style="color: gray;">⏪</span>]
					[<span style="color: gray;">🔙</span>]
				</c:if>
				<!-- 블록 범위 출력 -->
				<c:forEach begin="${formPage}" end="${toPage}" var="i">
					<c:if test="${i == pg}">[${i}]</c:if>
					<c:if test="${i != pg}">
					[<a href="list.htm?pg=${i}">${i}</a>]
					</c:if>
				</c:forEach>
				
				<c:if test="${pg < allPage}">
					[<a href="list.htm?pg=${pg+1}">🔜</a>]
					[<a href="list.htm?pg=${allPage}">⏩</a>]
				</c:if>
				<c:if test="${pg >= allPage}">
					[<span style="color: gray;">🔜</span>]
					[<span style="color: gray;">⏩</span>]
				</c:if>
			</td>
		</tr>
	</table>
</body>
</html>