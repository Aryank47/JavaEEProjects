<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<form action="EBillServlet" method="post">
		<h2>NEW USER</h2>
		Enter user name <input type="text" name="username"><br>
		Enter password <input type="password" name="password"><br>
		<input type="submit" value="Register" name="action"><br>
		<br>
		<br>
		<font color=" dark green">If already registered then <a href="Login.jsp">CLICK HERE</a></font>
	</form>
</body>
</html>