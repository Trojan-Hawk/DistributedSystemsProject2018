<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Booking</title>
</head>
<body>
    <h2>Bookings</h2>
    <form action="/getBookings">
    	<button type=submit>View All Bookings</button>
    </form>
    <form action="/createBooking">
    	<button type=submit>Create A Booking</button>
    </form>
    <form action="/updateBooking">
    	<button type=submit>Update A Booking</button>
    </form>
    <form action="/deleteBooking">
    	<button type=submit>Delete A Booking</button>
    </form>
    <br>
    <form action="/">
    	<button type=submit>Back</button>
    </form>
</body>
</html>