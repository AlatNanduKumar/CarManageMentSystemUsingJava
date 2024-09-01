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
<div   style="border-colour: red">
	<h2>All Car Details</h2>
</div>
	<%ResultSet rs = (ResultSet) request.getAttribute("ResultSet");%>
	<table border="" style="background-color: lightblue">
		<tr>
			<th>CarId</th>
			<th>CarModel</th>
			<th>CarBrand</th>
			<th>CarColour</th>
			<th>CarPrice</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<% while(rs.next()){ %>
		<tr>
			<td><%=rs.getInt(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getString(3)%></td>
			<td><%=rs.getString(4)%></td>
			<td><%=rs.getInt(5)%></td>
			<td><a href="updateCar?CarId=<%=rs.getInt(1)%>">UPDATE</a></td>
			<td><a href="deleteCar?CarId=<%=rs.getInt(1)%>">Delete</a></td>
		</tr>
		<%}%>
	</table>
	<button style="background-color: green" onclick="history.back()">Go Back To DashBoard</button>
</body>
</html>
