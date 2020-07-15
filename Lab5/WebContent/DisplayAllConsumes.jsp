<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consumer Details</title>
</head>
<body>
	<table align="center" border="5" cellpadding="5" cellspacing="10">
		<tr>
			<th>Consumer_NUMBER</th>
			<th>Cosumer_NAME</th>
			<th>Consumer_ADDRESS</th>
			<th>Option1</th>
			
		</tr>
				<c:forEach items="${list }" var="con">
				
				<tr>
				<td>${con.consumerNo}</td>
				<td>${con.name}</td>
				<td>${con.address}</td>
				<td><a href="EBillServlet?action=SHOW&consumerNo=${con.consumerNo }">SHOW BILL DETAILS</a></td>
				</tr>
				
				</c:forEach>
				

	</table>
	<br>
	<a href="Home.jsp">HOME</a>
</body>
</html>