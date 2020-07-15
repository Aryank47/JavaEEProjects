<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
<table align="center" border="5" cellpadding="5" cellspacing="10">
		<tr>
			<th>FIRST NAME</th>
			<th>LAST NAME</th>
			<th>GENDER</th>
			<th>SKILL</th>
			<th>CITY</th>
		</tr>
		
		<c:forEach items="${empall }" var="emp">
			<tr>
				<td>${emp.firstName}</td>
				<td>${emp.lastName}</td>
				<td>${emp.gender}</td>
				<td>${emp.skills}</td>
				<td>${emp.city}</td>
			</tr>
		</c:forEach>
</table>
</body>
</html>