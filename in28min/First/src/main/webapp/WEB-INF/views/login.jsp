<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>coming from jsp</title>
</head>

<body>
<form action="/login" method="post">
<h3>${error}</h3>
Name:<input type="text" name="name">
Password:<input type="password" name="password">
<input type="submit" value="login">
 </form>
</body>

</html>