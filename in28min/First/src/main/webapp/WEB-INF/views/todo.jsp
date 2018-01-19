<%@page import="java.util.Date"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<title>coming from jsp</title>
</head>

<body>
<div class="container">
<h1>Add to do!!!</h1>
<form:form action='/add-todo' method="post" commandName="ToDo">
<fieldset class="form-group">
<form:label path="desc">Description </form:label>
<form:input type="text" path="desc" name="desc" class="form-control" REQUIRED="REQUIRED"/>
</fieldset>
<input class="btn btn-success" type="submit" value="submit"></form:form>
</div>

<script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>

</body>

</html>