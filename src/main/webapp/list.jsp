<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글목록</title>
</head>
<body>
	<h2>자유게시판  글 목록</h2>
	<hr>
	<table width="600"  border="1" cellpadding="0" cellspaceing="0">
		<tr bgcolor=#CEFBC9>
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>등록일</td>
				<td>조회수</td>
		</tr>
		
		<c:forEach items="${list}"  var="dto"">		
		<tr>
			<td>${dto.bid }</td>
			<td>${dto.btitle }</td>
			<td>${dto.bname }</td>
			<td>${dto.bdate }</td>
			<td>${dto.bdate }</td>
			<td>${dto.bhit }</td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>