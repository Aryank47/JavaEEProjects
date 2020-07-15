<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USER INFO</title>
</head>
<body>
	<form action="EBillServlet" method="get">
	   <input type="hidden" name="username" value="${username}"> 
	<table align="center">
		<tr>
			<td>Consumer Number:</td>
			<td><input type="text" name="consumerno" value=${param.consumerno } readonly="readonly" ></td>
		</tr>
		<tr>
			<td>Last Month Meter Reading:</td>
			<td><input type="text" name="lastmonreading"></td>
		</tr>
		<tr>
			<td>Current Month Meter Reading:</td>
			<td><input type="text" name="currentmonreading"></td>
		</tr>
		<tr>
			<td><input type="submit" value="Calculate Bill" name="action"></td>
		</tr>
	</table>
</form>

</body>
</html>