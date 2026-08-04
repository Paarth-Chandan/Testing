<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<head>

<title>Search Flights</title>

</head>

<body>

<h2>Search Flights</h2>

<form action="search" method="post">

Source

<input type="text" name="source">

<br><br>

Destination

<input type="text" name="destination">

<br><br>

<input type="submit" value="Search">

</form>

<br><br>

<table border="1">

<tr>

<th>Flight Number</th>
<th>Source</th>
<th>Destination</th>
<th>Departure Time</th>
<th>Arrival Time</th>
<th>Available Seats</th>
<th>Price</th>
<th>Action</th>

</tr>

<c:forEach var="flight" items="${flights}">

<tr>

<td>${flight.flightNumber}</td>
<td>${flight.source}</td>
<td>${flight.destination}</td>
<td>${flight.departureTime}</td>
<td>${flight.arrivalTime}</td>
<td>${flight.availableSeats}</td>
<td>${flight.price}</td>

<td>

<a href="../booking/book">

Book Flight

</a>

</td>

</tr>

</c:forEach>

</table>

</body>

</html>
