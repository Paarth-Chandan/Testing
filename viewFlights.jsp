<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<head>

<title>View Flights</title>

</head>

<body>

<h2>Available Flights</h2>

<table border="1">

<tr>

<th>Flight ID</th>
<th>Flight Number</th>
<th>Source</th>
<th>Destination</th>
<th>Departure Time</th>
<th>Arrival Time</th>
<th>Capacity</th>
<th>Available Seats</th>
<th>Price</th>

</tr>

<c:forEach var="flight" items="${flights}">

<tr>

<td>${flight.flightId}</td>
<td>${flight.flightNumber}</td>
<td>${flight.source}</td>
<td>${flight.destination}</td>
<td>${flight.departureTime}</td>
<td>${flight.arrivalTime}</td>
<td>${flight.capacity}</td>
<td>${flight.availableSeats}</td>
<td>${flight.price}</td>

</tr>

</c:forEach>

</table>

<br><br>

<a href="add">

Add New Flight

</a>

</body>

</html>
