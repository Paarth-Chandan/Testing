<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>

<title>All Flights</title>

</head>

<body>

<h2>Available Flights</h2>

<table border="1">

<tr>

<th>ID</th>
<th>Flight Number</th>
<th>Source</th>
<th>Destination</th>
<th>Departure</th>
<th>Arrival</th>
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

</body>

</html>
