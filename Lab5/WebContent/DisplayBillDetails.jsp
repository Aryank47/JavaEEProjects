<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table align="center" border="5" cellpadding="5" cellspacing="10">
		<tr>
			<th>Bill_NUMBER</th>
			<th>Consumer_NUMBER</th>
			<th>Current_READING</th>
			<th>Unit_CONSUMED</th>
			<th>Net_AMOUNT</th>
			<th>Bill_DATE</th>
			
		</tr>
				<c:forEach items="${bill }" var="bill">
				<c:set value="${bill.consumerNo }" var="no"></c:set>
				<tr>
				<td>${bill.billNo}</td>
				<td>${bill.consumerNo}</td>
				<td>${bill.curReading}</td>
				<td>${bill.unitConsumed}</td>
				<td>${bill.netAmount}</td>
				<td>${bill.date }</td>
				</tr>
				
				</c:forEach>
				

	</table>
	<br>
	<a href="UserInfo.jsp?action=calculate bill&consumerno=${no }">GENERATE NEW BILL</a>

</body>
</html>