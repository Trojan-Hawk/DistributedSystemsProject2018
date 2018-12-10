<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Action Result</title>
</head>
<body>
	<h2>Customer Action Result</h2>
	<p>${result}</p>
	<br>
	<form action="/customer">
    	<button type=submit>Manage Customers</button>
    </form>
</body>
</html>