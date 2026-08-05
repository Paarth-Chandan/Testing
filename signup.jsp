<%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>

<title>Register</title>

</head>

<body>

<h2>User Registration</h2>

<form:form action="register"
method="post"
modelAttribute="user">

Name

<form:input path="name"/>

<form:errors path="name"/>

<br><br>

Email

<form:input path="email"/>

<form:errors path="email"/>

<br><br>

Password

<form:password path="password"/>

<form:errors path="password"/>

<br><br>

Role

<form:select path="role">

<form:option value="USER">USER</form:option>

<form:option value="ADMIN">ADMIN</form:option>

</form:select>

<br><br>

<input type="submit" value="Register">

</form:form>

</body>

</html>
