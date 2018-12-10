<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Booking</title>
</head>
<body>
    <h2>Customers</h2>
    <form action="/getCustomers">
    	<button type=submit>View All Customers</button>
    </form>
    <form action="/createCustomer">
    	<button type=submit>Create A Customer</button>
    </form>
    <form action="/updateCustomer">
    	<button type=submit>Update A Customer</button>
    </form>
    <form action="/deleteCustomer">
    	<button type=submit>Delete A Customer</button>
    </form>
    <br>
    <form action="/">
    	<button type=submit>Back</button>
    </form>
</body>
</html>