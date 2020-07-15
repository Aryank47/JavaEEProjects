<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Page</title>
</head>
<body bgcolor="pink">
	<form action="FrontController" method="post">
	<h1 align="center">Update Session</h1>
	
	<table title="Update Session" align="center" border="5" cellpadding="5" cellspacing="10">
	
		<c:set value="${param.sessionId }" var="id" ></c:set>
		<input type="hidden" value="${id }" name="id1">
		
		
		<tr>
			<td> Session Name: <input type="text" readonly="readonly" value="${param.sessionName }" name="name"></td>
			
		</tr>
		
		<tr>
			<td> Duration: <input type="number" min="1"  max="9" name="duration" value="${param.sessionDuration }"></td>
		</tr>
		
		<tr>
			<td> Faculty: <input type="text" pattern="[a-zA-Z ]*$" name="faculty" value="${param.faculty }"></td>
		</tr>
	
		<tr>	
			<td> 
				Role :<select name="Role">
  					<option value="ILT">ILT</option>
  					<option value="ITL">ITL</option>
  					<option value="VC">VC</option>	
					</select> 
				</td>
			</tr>
       
       <tr>
       		<td><input type="submit" value="UPDATE" name="action" ></td>	
       </tr>
	</table>
	</form>
</body>
</html>