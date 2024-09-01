<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%ResultSet rs =(ResultSet)request.getAttribute("ResultSet");%>
	<% rs.next();%>
	<h1>Update Car Details</h1>
	<form action="saveUpdateCar" method="post">
		<input type="number" value="<%=rs.getInt(1)%>" name="CarId" readonly="true"> <br>
		<input type="text" value="<%=rs.getString(2)%>" name="CarModell"><br>
		<input type="text" value="<%=rs.getString(3)%>" name="CarBrand"> <br>
		<input type="text" value="<%=rs.getString(4)%>" name="CarColour"> <br>
		<input type="number" value="<%=rs.getInt(5)%>" name="CarPrice"> <br>
		<input type="Submit" value="UPDATE">
		
	</form>
</body>
</html>