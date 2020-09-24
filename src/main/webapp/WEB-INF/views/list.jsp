<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>list.jsp</h1>
	레코드 갯수 ${fn:length(lists)}
	<table border="1">
		<tr>
			<td>번호</td>
			<td>아이디</td>
			<td>이름</td>
			<td>나이</td>
		</tr>
		<c:forEach var="i" items="${lists}">
			<tr>
				<td>${i.num }</td>
				<td>
					<a href="delete_view?num=${i.num }">${i.id }</a>
				</td>
				<td>
					<a href="content_view?num=${i.num }">${i.name }</a>
				</td>
				<td>${i.age }</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="write_view">입력하러가자</a>

</body>
</html>