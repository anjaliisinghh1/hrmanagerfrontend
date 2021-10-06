<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
    <style type="text/css">
h2{
color: #023e8a;
}

h3{
color: #023e8a;
margin-left: 20%;
}

.homepage{
  margin: auto;
  width: 50%;
  border: 0.5px blue;
}

.showasbutton{
	text-decoration: none;
	padding-left: 6px;
	padding-right: 6px;
	padding-top: 1px;
	padding-bottom: 1px;
	background-color: #e9ecef;
	color: black;
	border: solid;
	border-width: thin;
	border-color: black;
	border-radius: 1.5px;
}
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
    </head>
    <body>
    <h2>HR Manager Login</h2>

	<form action="login">
	<h3>Login</h3>
<div class="homepage">
<label for="userName"> Enter User Name: </label>
<input class="uname" type="text" name="userName" id="" required><br><br>

<label for="password">Enter Password: </label>
<input class="pass" type="password" name="password" required max=10><br><br>
<input type="submit" value="Login">
 <%--<a class="showasbutton" href="employeeList.jsp">Login</a> --%>
</div>
</form>
    </body>
</html>
