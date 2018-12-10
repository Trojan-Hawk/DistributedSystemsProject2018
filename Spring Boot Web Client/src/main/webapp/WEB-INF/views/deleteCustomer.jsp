<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Customer</title>
</head>
<body>
	<h2>Delete Customer</h2>
	<form method="get" action="deleteCustomerEntry">
        Customer ID: <input type = "text" name = "customerId" />
        <br>
        First Name: <input type = "text" name = "firstName" />
        <br>
        Last Name: <input type = "text" name = "lastName">
        <br>
        <input type = "submit" value = "Delete Customer" />
    </form>
    <br>
    <form action="/customer">
    	<button type=submit>Back</button>
    </form>
</body>
</html>