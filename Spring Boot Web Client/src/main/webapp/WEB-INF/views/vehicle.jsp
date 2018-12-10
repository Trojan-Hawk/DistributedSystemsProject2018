<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Booking</title>
</head>
<body>
    <h2>Vehicles</h2>
    <form action="/getVehicles">
    	<button type=submit>View All Vehicles</button>
    </form>
    <form action="/createVehicle">
    	<button type=submit>Create A Vehicle</button>
    </form>
    <form action="/updateVehicle">
    	<button type=submit>Update A Vehicle</button>
    </form>
    <form action="/deleteVehicle">
    	<button type=submit>Delete A Vehicle</button>
    </form>
    <br>
    <form action="/">
    	<button type=submit>Back</button>
    </form>
</body>
</html>