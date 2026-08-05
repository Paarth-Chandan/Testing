<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<title>Login</title>

</head>

<body>

<h2>User Login</h2>

<form action="login" method="post">

Email

<input type="email" name="email">

<br><br>

Password

<input type="password" name="password">

<br><br>

<input type="submit" value="Login">

</form>

<br>

<span style="color:red">

${error}

</span>

</body>

</html>
