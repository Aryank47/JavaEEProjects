<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Scheduled Sessions</title>
</head>
<body bgcolor="pink">
	<h1 align="center">Session Scheduler</h1>
	<table title="Scheduled Sessions" align="center" border="5" cellpadding="5" cellspacing="10">
		<tr>
			<th>Session_Id</th>
			<th>Session_Name</th>
			<th>Session_Duration</th>
			<th>Session_Faculty</th>
			<th>Session_Mode1</th>
		</tr>
		
		<c:forEach items="${list }" var="list">
		<c:set value="${list.id }" var="id"></c:set>
		<c:set value="${list.name }" var="name"></c:set>
		<c:set value="${list.duration }" var="duration"></c:set>
		<c:set value="${list.faculty }" var="faculty"></c:set>
		<c:set value="${list.mode1 }" var="mode1"></c:set>
			<tr>
				<td>${list.id }</td>
				<td>${list.name }</td>
				<td>${list.duration }</td>
				<td>${list.faculty }</td>
				<td>${list.mode1 }</td>
				<td><a href="UpdatePage.jsp?action=UPDATE&sessionId=${id }&sessionName=${name }&sessionDuration=${duration}&faculty=${faculty}&mode1=${mode1}">UPDATE</a>
			</tr>
			
		</c:forEach>
	</table>

</body>
</html>