<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Static Content -->
<script type="text/javascript" src="/resources/static/validation.js"></script>
<title>Update Booking</title>
</head>
<body>
	<h2>Update Booking</h2>
	<form method="get" action="updateBookingEntry" onsubmit="return validateBooking()">
		Booking ID: <input type = "text" name = "bookingId">
        <br>
        Customer ID: <input type = "text" name = "customerId" />
        <br>
        Registration Number: <input type = "text" name = "regNo" />
        <br>
        Date: <input type = "text" name = "date">
        <br>
        <input type = "submit" value = "Update Booking" />
    </form>
    <br>
    <form action="/booking">
    	<button type=submit>Back</button>
    </form>
</body>
</html>