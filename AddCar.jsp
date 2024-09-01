<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Enter Car Details:-</h1>
	<form action="addCar" method="post">
		<input type="number" placeholder="Enter CarId" name="CarId"> <input
			type="text" placeholder="Enter CarModell" name="CarModell"> <input
			type="text" placeholder="Enter CarBrand" name="CarBrand"> <input
			type="text" placeholder="Enter CarColour" name="CarColour"> <input
			type="number" placeholder="Enter CarPrice" name="CarPrice"> <input
			type="Submit" value="ADD">
			
	</form>
</body>
</html>