<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Customers</title>
</head>
<body>
	<h2>View Customers</h2>
	<!-- <c:forEach var="result" items="${results}">
  		<p>${result}</p>
	</c:forEach> -->
	${table}
	<br>
    <form action="/customer">
    	<button type=submit>Back</button>
    </form>
</body>
</html>