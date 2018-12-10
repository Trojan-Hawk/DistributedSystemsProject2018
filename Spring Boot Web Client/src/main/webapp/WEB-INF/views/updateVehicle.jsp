<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Vehicle</title>
</head>
<body>
	<h2>Update Vehicle</h2>
	<form method="get" action="updateVehicleEntry">
        Registration: <input type = "text" name = "regNo" />
        <br>
        Brand: <input type = "text" name = "brand">
        <br>
        Model: <input type = "text" name = "modelName" />
        <br>
        <input type = "submit" value = "Update Vehicle" />
    </form>
    <br>
    <form action="/vehicle">
    	<button type=submit>Back</button>
    </form>
</body>
</html>