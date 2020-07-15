<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Billing Details</title>
</head>
<body bgcolor="pink">
	
	<h1>Welcome ${sessionScope.username}</h1><br>
	
	
	<c:set value="${count }" var="count"></c:set>
	<c:if test="${count gt 0 }">
		<c:out value="Bill Details entered into database"></c:out>
	</c:if>
	<c:set value="${billDetails}" var="bill"></c:set>
	<h2>Electricity Bill For Consumer Number - ${bill.consumerNo} is </h2><br>
	
	<h3>Units Consumed:: ${bill.unitConsumed}</h3><br>
	<h3>NetAmount:: Rs. ${bill.netAmount }</h3><br>
	<form action="EBillServlet">
	<input type="submit" value="LOGOUT" name="action">
	</form>
	
</body>
</html>